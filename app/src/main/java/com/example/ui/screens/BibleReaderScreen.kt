package com.example.ui.screens

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BibleData
import com.example.data.BibleRepository
import com.example.data.BibleVerseEntity
import com.example.data.UserPreferences
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.BiblePdfManager
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BibleReaderScreen(modifier: Modifier = Modifier) {
  val context = LocalContext.current
  val userPrefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()
  val repository = remember { BibleRepository(context) }

  // Scaled font size from settings
  val fontScale = userPrefs.getFontSize()
  val baseFontSize = (fontScale * 16).toInt()

  // Reader mode: "BOOK" (PDF) or "DIGITAL"
  var readerMode by remember { mutableStateOf(userPrefs.getBibleReaderMode()) }
  var fontSizeScale by remember { mutableFloatStateOf(userPrefs.getFontSize()) }

  // Bible Version State
  var currentVersionCode by remember { mutableStateOf(userPrefs.getBibleVersion()) }
  var showVersionDialog by remember { mutableStateOf(false) }
  val currentVersionInfo = remember(currentVersionCode) {
    BibleData.getVersionInfo(currentVersionCode)
  }

  // Dark Mode for Bible reading (comfortable night reading)
  val systemDark = isSystemInDarkTheme() || userPrefs.getThemeMode() == UserPreferences.THEME_DARK
  var isBibleNightMode by remember { mutableStateOf(userPrefs.isBibleDarkMode() || systemDark) }

  val nightColorFilter = remember {
    ColorFilter.colorMatrix(
      ColorMatrix(
        floatArrayOf(
          -1.0f,  0.0f,  0.0f, 0.0f, 235f,
           0.0f, -1.0f,  0.0f, 0.0f, 230f,
           0.0f,  0.0f, -1.0f, 0.0f, 215f,
           0.0f,  0.0f,  0.0f, 1.0f, 0f
        )
      )
    )
  }

  // TTS Helper
  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }
  var speechSpeed by remember { mutableFloatStateOf(1.0f) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // --- PDF FILE & RENDERER STATE ---
  var pdfFile by remember { mutableStateOf<File?>(null) }
  var pdfRenderer by remember { mutableStateOf<PdfRenderer?>(null) }
  var totalPages by remember { mutableIntStateOf(1) }
  var currentPageIndex by remember { mutableIntStateOf(userPrefs.getLastBiblePage()) }
  var currentPageBitmap by remember { mutableStateOf<Bitmap?>(null) }
  var isGeneratingPdf by remember { mutableStateOf(false) }
  var showJumpDialog by remember { mutableStateOf(false) }
  var showBookIndexSheet by remember { mutableStateOf(false) }

  // Zoom & Pan state for PDF
  var scale by remember { mutableFloatStateOf(1f) }
  var offset by remember { mutableStateOf(Offset.Zero) }

  // --- DIGITAL MODE STATE ---
  var verses by remember { mutableStateOf<List<BibleVerseEntity>>(emptyList()) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedTestamentFilter by remember { mutableStateOf("TODOS") }

  // Initialize PDF and Digital verses according to selected version
  LaunchedEffect(currentVersionCode) {
    withContext(Dispatchers.IO) {
      val file = BiblePdfManager.ensureBiblePdfExists(context, currentVersionCode)
      val count = BiblePdfManager.getTotalPages(context, currentVersionCode)
      val vList = repository.getVerses(currentVersionCode)
      withContext(Dispatchers.Main) {
        pdfFile = file
        totalPages = count
        verses = vList
        if (currentPageIndex >= count) {
          currentPageIndex = 0
        }
      }
    }
  }

  // Setup PdfRenderer when pdfFile changes
  LaunchedEffect(pdfFile) {
    val file = pdfFile ?: return@LaunchedEffect
    withContext(Dispatchers.IO) {
      try {
        pdfRenderer?.close()
        val pfd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
        val renderer = PdfRenderer(pfd)
        withContext(Dispatchers.Main) {
          pdfRenderer = renderer
          totalPages = renderer.pageCount
        }
      } catch (e: Exception) {
        Log.e("BibleReaderScreen", "Error opening PDF renderer", e)
      }
    }
  }

  // Render current page when currentPageIndex or renderer changes
  LaunchedEffect(currentPageIndex, pdfRenderer) {
    val renderer = pdfRenderer ?: return@LaunchedEffect
    val targetIndex = currentPageIndex.coerceIn(0, (renderer.pageCount - 1).coerceAtLeast(0))
    withContext(Dispatchers.IO) {
      try {
        val page = renderer.openPage(targetIndex)
        // Render at 2x resolution for ultra-sharp reading
        val renderWidth = (page.width * 2).coerceAtLeast(600)
        val renderHeight = (page.height * 2).coerceAtLeast(800)
        val bitmap = Bitmap.createBitmap(renderWidth, renderHeight, Bitmap.Config.ARGB_8888)
        bitmap.eraseColor(android.graphics.Color.WHITE)
        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        page.close()

        withContext(Dispatchers.Main) {
          currentPageBitmap = bitmap
          // Reset zoom and pan on page turn
          scale = 1f
          offset = Offset.Zero
          // Save last read page
          userPrefs.setLastBiblePage(targetIndex)
        }
      } catch (e: Exception) {
        Log.e("BibleReaderScreen", "Error rendering PDF page $targetIndex", e)
      }
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 14.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // --- SELECTOR DE VERSIÓN DE LA BIBLIA ---
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 480.dp)
        .padding(top = 4.dp, bottom = 6.dp)
        .clickable { showVersionDialog = true }
        .testTag("bible_version_selector_card"),
      shape = RoundedCornerShape(14.dp),
      colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
      )
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 14.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.weight(1f)
        ) {
          Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = null,
            tint = GoldSecondary,
            modifier = Modifier.size(22.dp)
          )
          Spacer(modifier = Modifier.width(10.dp))
          Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "Versión: ${currentVersionInfo.name}",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                maxLines = 1
              )
              if (currentVersionInfo.isCatholic) {
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                  shape = RoundedCornerShape(4.dp),
                  color = MaterialTheme.colorScheme.primaryContainer
                ) {
                  Text(
                    text = "Católica",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                  )
                }
              }
            }
            Text(
              text = currentVersionInfo.description,
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.85f),
              maxLines = 1
            )
          }
        }
        Icon(
          imageVector = Icons.Default.ArrowDropDown,
          contentDescription = "Cambiar versión de la Biblia",
          tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
      }
    }

    // Top Mode Toggle: "Modo Libro (PDF)" vs "Modo Digital"
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 6.dp),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        modifier = Modifier.widthIn(max = 480.dp)
      ) {
        Row(
          modifier = Modifier.padding(4.dp),
          horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
          Button(
            onClick = {
              readerMode = "BOOK"
              userPrefs.setBibleReaderMode("BOOK")
            },
            colors = ButtonDefaults.buttonColors(
              containerColor = if (readerMode == "BOOK") WinePrimary else Color.Transparent,
              contentColor = if (readerMode == "BOOK") Color.White else MaterialTheme.colorScheme.onSurfaceVariant
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
              .testTag("mode_book_button")
          ) {
            Icon(Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Modo Libro (PDF)", fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
          }

          Button(
            onClick = {
              readerMode = "DIGITAL"
              userPrefs.setBibleReaderMode("DIGITAL")
            },
            colors = ButtonDefaults.buttonColors(
              containerColor = if (readerMode == "DIGITAL") WinePrimary else Color.Transparent,
              contentColor = if (readerMode == "DIGITAL") Color.White else MaterialTheme.colorScheme.onSurfaceVariant
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
            modifier = Modifier
              .weight(1f)
              .height(44.dp)
              .testTag("mode_digital_button")
          ) {
            Icon(Icons.Default.Book, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Modo Digital", fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
          }
        }
      }
    }

    if (readerMode == "BOOK") {
      // ==========================================
      // --- MODO LIBRO FÍSICO (PDF CON VOZ VIVA) ---
      // ==========================================

      // Toolbar: Book index, Jump to page, Night Mode toggle, Zoom controls
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Book Index Jump
        Button(
          onClick = { showBookIndexSheet = true },
          colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurface
          ),
          shape = RoundedCornerShape(10.dp),
          contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
        ) {
          Icon(Icons.Default.Bookmarks, contentDescription = null, modifier = Modifier.size(16.dp), tint = GoldSecondary)
          Spacer(modifier = Modifier.width(6.dp))
          Text("Índice de Libros", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }

        // Page Jump badge
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
          modifier = Modifier.clickable { showJumpDialog = true }
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Pág. ${currentPageIndex + 1} de $totalPages",
              style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(Icons.Default.Edit, contentDescription = "Saltar página", modifier = Modifier.size(14.dp), tint = MaterialTheme.colorScheme.primary)
          }
        }

        // Modo Noche Toggle para lectura descansada sin brillo blanco
        FilledTonalIconButton(
          onClick = {
            val newNight = !isBibleNightMode
            isBibleNightMode = newNight
            userPrefs.setBibleDarkMode(newNight)
          },
          modifier = Modifier
            .size(38.dp)
            .testTag("bible_dark_mode_button"),
          colors = IconButtonDefaults.filledTonalIconButtonColors(
            containerColor = if (isBibleNightMode) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
          )
        ) {
          Icon(
            imageVector = if (isBibleNightMode) Icons.Default.LightMode else Icons.Default.DarkMode,
            contentDescription = if (isBibleNightMode) "Modo Día" else "Modo Noche",
            tint = if (isBibleNightMode) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(18.dp)
          )
        }

        // Zoom Reset
        IconButton(
          onClick = {
            scale = if (scale > 1f) 1f else 1.5f
            offset = Offset.Zero
          }
        ) {
          Icon(
            imageVector = if (scale > 1f) Icons.Default.ZoomOut else Icons.Default.ZoomIn,
            contentDescription = "Zoom",
            tint = MaterialTheme.colorScheme.primary
          )
        }

        // Random Page
        IconButton(
          onClick = {
            val randomPage = (0 until totalPages).random()
            currentPageIndex = randomPage
          }
        ) {
          Icon(
            imageVector = Icons.Default.Casino,
            contentDescription = "Página al azar",
            tint = MaterialTheme.colorScheme.primary
          )
        }
      }

      // PDF Book Page Canvas Area
      val transformState = rememberTransformableState { zoomChange, offsetChange, _ ->
        scale = (scale * zoomChange).coerceIn(1f, 3.5f)
        if (scale > 1f) {
          offset += offsetChange
        } else {
          offset = Offset.Zero
        }
      }

      Box(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth()
          .clip(RoundedCornerShape(16.dp))
          .background(if (isBibleNightMode) Color(0xFF141112) else MaterialTheme.colorScheme.surface)
          .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
          .transformable(state = transformState),
        contentAlignment = Alignment.Center
      ) {
        if (currentPageBitmap != null) {
          Image(
            bitmap = currentPageBitmap!!.asImageBitmap(),
            contentDescription = "Página ${currentPageIndex + 1} de la Biblia en PDF",
            colorFilter = if (isBibleNightMode) nightColorFilter else null,
            modifier = Modifier
              .fillMaxSize()
              .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offset.x,
                translationY = offset.y
              )
          )
        } else {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
          ) {
            CircularProgressIndicator(color = WinePrimary)
            Spacer(modifier = Modifier.height(14.dp))
            Text(
              text = "Cargando página de la Sagrada Escritura...",
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(8.dp))

      // --- BARRA INFERIOR DE NAVEGACIÓN Y VOZ VIVA ---
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          // Row 1: Voz Viva Controls
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.RecordVoiceOver,
                contentDescription = null,
                tint = if (isSpeaking) WinePrimary else GoldSecondary,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = if (isSpeaking) "Leyendo con Voz Viva..." else "La Voz Viva",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = if (isSpeaking) WinePrimary else MaterialTheme.colorScheme.onSurface
              )
            }

            // Speed rate selector
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
              listOf(0.8f, 1.0f, 1.2f).forEach { rate ->
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = if (speechSpeed == rate) WinePrimary else MaterialTheme.colorScheme.surfaceVariant,
                  modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .clickable {
                      speechSpeed = rate
                      ttsHelper.setSpeechRate(rate)
                    }
                ) {
                  Text(
                    text = "${rate}x",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = if (speechSpeed == rate) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(6.dp))

          // Row 2: Page Navigation and Voice Playback
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Previous Page Button
            Button(
              onClick = {
                if (currentPageIndex > 0) {
                  ttsHelper.stop()
                  isSpeaking = false
                  currentPageIndex--
                }
              },
              enabled = currentPageIndex > 0,
              colors = ButtonDefaults.buttonColors(
                containerColor = WinePrimary,
                contentColor = Color.White,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContentColor = MaterialTheme.colorScheme.outline
              ),
              shape = RoundedCornerShape(12.dp),
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
              modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .testTag("bible_prev_page")
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
              ) {
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Página anterior",
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = "Anterior",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  maxLines = 1
                )
              }
            }

            // Central Play/Stop TTS Button
            Button(
              onClick = {
                if (isSpeaking) {
                  ttsHelper.stop()
                  isSpeaking = false
                } else {
                  val textToRead = BiblePdfManager.getPageText(currentPageIndex)
                  ttsHelper.speak(textToRead) {
                    isSpeaking = false
                  }
                  isSpeaking = true
                }
              },
              colors = ButtonDefaults.buttonColors(
                containerColor = if (isSpeaking) GoldSecondary else WinePrimary,
                contentColor = Color.White
              ),
              shape = RoundedCornerShape(12.dp),
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
              modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .testTag("bible_tts_toggle")
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
              ) {
                Icon(
                  imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                  contentDescription = if (isSpeaking) "Detener lectura" else "Escuchar página",
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                  text = if (isSpeaking) "Pausar" else "Escuchar",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  maxLines = 1
                )
              }
            }

            // Next Page Button
            Button(
              onClick = {
                if (currentPageIndex < totalPages - 1) {
                  ttsHelper.stop()
                  isSpeaking = false
                  currentPageIndex++
                }
              },
              enabled = currentPageIndex < totalPages - 1,
              colors = ButtonDefaults.buttonColors(
                containerColor = WinePrimary,
                contentColor = Color.White,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                disabledContentColor = MaterialTheme.colorScheme.outline
              ),
              shape = RoundedCornerShape(12.dp),
              contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp),
              modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .testTag("bible_next_page")
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
              ) {
                Text(
                  text = "Siguiente",
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp,
                  maxLines = 1
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                  contentDescription = "Página siguiente",
                  modifier = Modifier.size(18.dp)
                )
              }
            }
          }
        }
      }

    } else {
      // ==========================================
      // --- MODO DIGITAL (VERSÍCULOS Y BÚSQUEDA) ---
      // ==========================================
      val filteredVerses = remember(verses, searchQuery, selectedTestamentFilter) {
        verses.filter { v ->
          val matchesSearch = if (searchQuery.isEmpty()) true
          else v.text.contains(searchQuery, ignoreCase = true) || v.citation.contains(searchQuery, ignoreCase = true)

          val matchesTestament = when (selectedTestamentFilter) {
            "AT" -> v.testament.contains("Antiguo", ignoreCase = true)
            "NT" -> v.testament.contains("Nuevo", ignoreCase = true)
            else -> true
          }
          matchesSearch && matchesTestament
        }
      }

      val groupedVerses = remember(filteredVerses) {
        filteredVerses.groupBy { verse ->
          verse.citation.split(" ").firstOrNull() ?: "Libro Sagrado"
        }
      }

      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        item {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar libro, salmo o palabra sagrada...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                }
              }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp)
          )

          Spacer(modifier = Modifier.height(8.dp))

          // Filter chips
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            // Font controls
            Row(verticalAlignment = Alignment.CenterVertically) {
              IconButton(
                onClick = {
                  fontSizeScale = (fontSizeScale - 0.1f).coerceIn(0.8f, 1.5f)
                  userPrefs.setFontSize(fontSizeScale)
                },
                modifier = Modifier.size(36.dp)
              ) {
                Icon(Icons.Default.Remove, contentDescription = "Reducir letra")
              }
              Text(
                text = "${(fontSizeScale * 100).toInt()}%",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(horizontal = 4.dp)
              )
              IconButton(
                onClick = {
                  fontSizeScale = (fontSizeScale + 0.1f).coerceIn(0.8f, 1.5f)
                  userPrefs.setFontSize(fontSizeScale)
                },
                modifier = Modifier.size(36.dp)
              ) {
                Icon(Icons.Default.Add, contentDescription = "Aumentar letra")
              }
            }

            Spacer(modifier = Modifier.width(8.dp))

            FilterChip(
              selected = selectedTestamentFilter == "TODOS",
              onClick = { selectedTestamentFilter = "TODOS" },
              label = { Text("Todos") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = WinePrimary,
                selectedLabelColor = Color.White
              )
            )

            FilterChip(
              selected = selectedTestamentFilter == "AT",
              onClick = { selectedTestamentFilter = "AT" },
              label = { Text("Antiguo Testamento") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = WinePrimary,
                selectedLabelColor = Color.White
              )
            )

            FilterChip(
              selected = selectedTestamentFilter == "NT",
              onClick = { selectedTestamentFilter = "NT" },
              label = { Text("Nuevo Testamento") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = WinePrimary,
                selectedLabelColor = Color.White
              )
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
        }

        if (groupedVerses.isEmpty()) {
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp)
            ) {
              Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
              ) {
                Text("📖", fontSize = 32.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "No se encontraron versículos con ese criterio",
                  style = MaterialTheme.typography.bodyMedium,
                  textAlign = TextAlign.Center
                )
              }
            }
          }
        }

        groupedVerses.forEach { (bookName, bookVerses) ->
          item {
            Text(
              text = bookName,
              style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.primary,
              modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
          }

          items(bookVerses, key = { it.id }) { verse ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(14.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(
                    text = verse.citation,
                    style = MaterialTheme.typography.titleSmall.copy(
                      fontWeight = FontWeight.Bold,
                      color = MaterialTheme.colorScheme.primary
                    )
                  )

                  IconButton(
                    onClick = {
                      if (isSpeaking) {
                        ttsHelper.stop()
                        isSpeaking = false
                      } else {
                        ttsHelper.speak("${verse.citation}. ${verse.text}") {
                          isSpeaking = false
                        }
                        isSpeaking = true
                      }
                    }
                  ) {
                    Icon(
                      imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.VolumeUp,
                      contentDescription = "Escuchar versículo",
                      tint = MaterialTheme.colorScheme.primary,
                      modifier = Modifier.size(20.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                  text = verse.text,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = baseFontSize.sp,
                    lineHeight = (baseFontSize * 1.5).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
          }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }
      }
    }
  }

  // --- DIALOG: JUMP TO SPECIFIC PAGE ---
  if (showJumpDialog) {
    var inputPageText by remember { mutableStateOf("${currentPageIndex + 1}") }
    AlertDialog(
      onDismissRequest = { showJumpDialog = false },
      title = {
        Text("Ir a una Página de la Biblia", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
      },
      text = {
        Column {
          Text("Ingresa el número de página que deseas leer (1 a $totalPages):")
          Spacer(modifier = Modifier.height(12.dp))
          OutlinedTextField(
            value = inputPageText,
            onValueChange = { inputPageText = it.filter { ch -> ch.isDigit() } },
            label = { Text("Número de página") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
          )
        }
      },
      confirmButton = {
        Button(
          onClick = {
            val pageNum = inputPageText.toIntOrNull()
            if (pageNum != null && pageNum in 1..totalPages) {
              ttsHelper.stop()
              isSpeaking = false
              currentPageIndex = pageNum - 1
            }
            showJumpDialog = false
          },
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary, contentColor = Color.White)
        ) {
          Text("Ir a la Página")
        }
      },
      dismissButton = {
        TextButton(onClick = { showJumpDialog = false }) {
          Text("Cancelar")
        }
      }
    )
  }

  // --- BOTTOM SHEET / DIALOG: BOOK INDEX ---
  if (showBookIndexSheet) {
    val toc = remember { BiblePdfManager.getTableOfContents(context) }
    AlertDialog(
      onDismissRequest = { showBookIndexSheet = false },
      title = {
        Text("Índice de Libros Bíblicos", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 400.dp)
        ) {
          item {
            Text("Selecciona cualquier libro para abrir su primera página:", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
          }
          items(toc) { entry ->
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                  ttsHelper.stop()
                  isSpeaking = false
                  currentPageIndex = (entry.pageNumber - 1).coerceAtLeast(0)
                  showBookIndexSheet = false
                }
                .padding(vertical = 10.dp, horizontal = 8.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Column {
                Text(entry.book, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(entry.testament, fontSize = 11.sp, color = MaterialTheme.colorScheme.outline)
              }
              Surface(
                shape = RoundedCornerShape(6.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
              ) {
                Text(
                  text = "Pág. ${entry.pageNumber}",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = MaterialTheme.colorScheme.onPrimaryContainer,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
          }
        }
      },
      confirmButton = {
        Button(
          onClick = { showBookIndexSheet = false },
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary, contentColor = Color.White)
        ) {
          Text("Cerrar")
        }
      }
    )
  }

  // --- DIALOG: SELECCIONAR VERSIÓN DE LA BIBLIA ---
  if (showVersionDialog) {
    AlertDialog(
      onDismissRequest = { showVersionDialog = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.MenuBook, contentDescription = null, tint = GoldSecondary, modifier = Modifier.size(24.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Versiones de la Biblia",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
          )
        }
      },
      text = {
        LazyColumn(
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 420.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          item {
            Text(
              text = "Elige la traducción bíblica deseada para tu lectura en libro físico o digital:",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
          }
          items(BibleData.availableVersions) { versionInfo ->
            val isSelected = versionInfo.code.equals(currentVersionCode, ignoreCase = true)
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
              border = if (isSelected) androidx.compose.foundation.BorderStroke(1.5.dp, WinePrimary) else null,
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  currentVersionCode = versionInfo.code
                  userPrefs.setBibleVersion(versionInfo.code)
                  ttsHelper.stop()
                  isSpeaking = false
                  showVersionDialog = false
                }
                .testTag("version_item_${versionInfo.code.lowercase()}")
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = versionInfo.name,
                      style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                      color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                    )
                    if (versionInfo.isCatholic) {
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = WinePrimary
                      ) {
                        Text(
                          text = "Católica",
                          fontSize = 9.sp,
                          color = Color.White,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                      }
                    }
                  }
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                    text = versionInfo.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f) else MaterialTheme.colorScheme.onSurfaceVariant
                  )
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = versionInfo.yearOrTradition,
                    style = MaterialTheme.typography.labelSmall,
                    color = GoldSecondary
                  )
                }

                if (isSelected) {
                  Spacer(modifier = Modifier.width(8.dp))
                  Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Seleccionada",
                    tint = WinePrimary,
                    modifier = Modifier.size(24.dp)
                  )
                }
              }
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = { showVersionDialog = false },
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary, contentColor = Color.White)
        ) {
          Text("Cerrar")
        }
      }
    )
  }
}
