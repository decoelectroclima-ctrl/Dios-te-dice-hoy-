package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PrayerRepository
import com.example.data.UserPreferences
import com.example.model.CatholicPrayer
import com.example.model.PrayerPurpose
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrayersScreen(
  snackbarHostState: SnackbarHostState,
  initialPurposeFilter: PrayerPurpose? = null,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var currentlyPlayingPrayerId by remember { mutableStateOf<String?>(null) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  var viewModeIndex by remember {
    mutableIntStateOf(if (initialPurposeFilter == PrayerPurpose.ESPIRITU_SANTO) 1 else 0)
  }
  val viewTabs = listOf("Índice por Propósito", "Espíritu Santo 🔥", "Todas las Oraciones")

  var searchQuery by remember { mutableStateOf("") }
  var selectedPurpose by remember { mutableStateOf<PrayerPurpose?>(initialPurposeFilter) }
  var activePrayerDetail by remember { mutableStateOf<CatholicPrayer?>(null) }

  fun playOrStopPrayer(prayer: CatholicPrayer) {
    if (currentlyPlayingPrayerId == prayer.id) {
      ttsHelper.stop()
      currentlyPlayingPrayerId = null
    } else {
      ttsHelper.stop()
      val textToSpeak = "${prayer.title}. ${prayer.content}"
      ttsHelper.speak(textToSpeak)
      currentlyPlayingPrayerId = prayer.id
      scope.launch {
        snackbarHostState.showSnackbar("Reproduciendo audio: ${prayer.title} 🎧")
      }
    }
  }

  fun copyToClipboard(title: String, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Oración $title", text)
    clipboard.setPrimaryClip(clip)
    scope.launch {
      snackbarHostState.showSnackbar("«$title» copiada al portapapeles 📋")
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(4.dp))

    // Top Navigation Mode
    TabRow(
      selectedTabIndex = viewModeIndex,
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .clip(RoundedCornerShape(14.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
      contentColor = WinePrimary
    ) {
      viewTabs.forEachIndexed { index, title ->
        Tab(
          selected = viewModeIndex == index,
          onClick = {
            viewModeIndex = index
            if (index == 1) {
              selectedPurpose = PrayerPurpose.ESPIRITU_SANTO
            } else if (index == 2) {
              selectedPurpose = null
            }
          },
          text = {
            Text(
              text = title,
              style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = if (viewModeIndex == index) FontWeight.Bold else FontWeight.Normal
              )
            )
          }
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Audio Notice Banner
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.Default.Headphones,
          contentDescription = null,
          tint = GoldSecondary,
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
          text = "Toca el botón ▶ en cualquier oración para escucharla si no puedes leerla.",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSecondaryContainer
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .testTag("prayer_search_input"),
      placeholder = { Text("Buscar oración por nombre o palabra clave...") },
      leadingIcon = {
        Icon(
          imageVector = Icons.Default.Search,
          contentDescription = "Buscar",
          tint = MaterialTheme.colorScheme.primary
        )
      },
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "Limpiar")
          }
        }
      },
      singleLine = true,
      shape = RoundedCornerShape(14.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface
      )
    )

    Spacer(modifier = Modifier.height(10.dp))

    when (viewModeIndex) {
      0 -> {
        // TAB 1: ÍNDICE POR PROPÓSITO ESPIRITUAL
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          items(PrayerPurpose.entries, key = { it.name }) { purpose ->
            val count = PrayerRepository.getPrayersByPurpose(purpose).size
            val isSelected = selectedPurpose == purpose

            Card(
              modifier = Modifier
                .fillMaxWidth()
                .clickable {
                  selectedPurpose = if (isSelected) null else purpose
                },
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(
                containerColor = if (isSelected) WinePrimary.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surface
              ),
              border = if (isSelected) androidx.compose.foundation.BorderStroke(1.5.dp, WinePrimary) else null,
              elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text(text = purpose.emoji, fontSize = 26.sp)
                  Spacer(modifier = Modifier.width(12.dp))
                  Column(modifier = Modifier.weight(1f)) {
                    Text(
                      text = purpose.displayName,
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                      ),
                      color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                      text = purpose.subtitle,
                      style = MaterialTheme.typography.bodySmall,
                      color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  }
                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                  ) {
                    Text(
                      text = "$count",
                      style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                      color = MaterialTheme.colorScheme.onPrimaryContainer,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }

                // If expanded/selected, show prayers in this purpose
                AnimatedVisibility(visible = isSelected) {
                  Column(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                  ) {
                    PrayerRepository.getPrayersByPurpose(purpose).forEach { prayer ->
                      PrayerItemRow(
                        prayer = prayer,
                        isPlaying = currentlyPlayingPrayerId == prayer.id,
                        isFavorite = prefs.isPrayerFavorite(prayer.id),
                        onPlayClick = { playOrStopPrayer(prayer) },
                        onFavoriteClick = {
                          prefs.toggleFavoritePrayer(prayer.id)
                        },
                        onClick = {
                          ttsHelper.stop()
                          currentlyPlayingPrayerId = null
                          activePrayerDetail = prayer
                        }
                      )
                    }
                  }
                }
              }
            }
          }
          item { Spacer(modifier = Modifier.height(24.dp)) }
        }
      }

      1 -> {
        // TAB 2: APARTADO ESPECIAL DEL ESPÍRITU SANTO
        val holySpiritPrayers = remember { PrayerRepository.getHolySpiritPrayers() }
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
              ),
              border = androidx.compose.foundation.BorderStroke(
                1.dp,
                Brush.horizontalGradient(listOf(GoldSecondary, WinePrimary))
              )
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text("🔥", fontSize = 28.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                  Text(
                    text = "Invocaciones al Espíritu Santo",
                    style = MaterialTheme.typography.titleMedium.copy(
                      fontWeight = FontWeight.Bold,
                      fontFamily = FontFamily.Serif
                    ),
                    color = WinePrimary
                  )
                  Text(
                    text = "El Consolador, Abogado y Luz que guía tus pasos. Escucha y ora en cualquier instante.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
            }
          }

          items(holySpiritPrayers, key = { it.id }) { prayer ->
            PrayerItemRow(
              prayer = prayer,
              isPlaying = currentlyPlayingPrayerId == prayer.id,
              isFavorite = prefs.isPrayerFavorite(prayer.id),
              onPlayClick = { playOrStopPrayer(prayer) },
              onFavoriteClick = { prefs.toggleFavoritePrayer(prayer.id) },
              onClick = {
                ttsHelper.stop()
                currentlyPlayingPrayerId = null
                activePrayerDetail = prayer
              }
            )
          }

          item { Spacer(modifier = Modifier.height(24.dp)) }
        }
      }

      2 -> {
        // TAB 3: TODAS LAS ORACIONES
        val prayers = remember(searchQuery) {
          if (searchQuery.isNotBlank()) PrayerRepository.searchPrayers(searchQuery) else PrayerRepository.getAllPrayers()
        }

        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          items(prayers, key = { it.id }) { prayer ->
            PrayerItemRow(
              prayer = prayer,
              isPlaying = currentlyPlayingPrayerId == prayer.id,
              isFavorite = prefs.isPrayerFavorite(prayer.id),
              onPlayClick = { playOrStopPrayer(prayer) },
              onFavoriteClick = { prefs.toggleFavoritePrayer(prayer.id) },
              onClick = {
                ttsHelper.stop()
                currentlyPlayingPrayerId = null
                activePrayerDetail = prayer
              }
            )
          }
          item { Spacer(modifier = Modifier.height(24.dp)) }
        }
      }
    }
  }

  // PRAYER DETAIL MODAL DIALOG
  activePrayerDetail?.let { prayer ->
    var isLatinView by remember { mutableStateOf(false) }
    var fontScale by remember { mutableIntStateOf(16) }
    var prayerCounter by remember { mutableIntStateOf(0) }
    val isFav = prefs.isPrayerFavorite(prayer.id)

    val currentContent = if (isLatinView && prayer.latinContent != null) {
      prayer.latinContent
    } else {
      prayer.content
    }

    AlertDialog(
      onDismissRequest = {
        ttsHelper.stop()
        currentlyPlayingPrayerId = null
        activePrayerDetail = null
      },
      confirmButton = {
        TextButton(
          onClick = {
            ttsHelper.stop()
            currentlyPlayingPrayerId = null
            activePrayerDetail = null
          }
        ) {
          Text("Cerrar")
        }
      },
      title = {
        Column {
          Text(
            text = prayer.title,
            style = MaterialTheme.typography.titleLarge.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          prayer.latinTitle?.let {
            Text(
              text = it,
              style = MaterialTheme.typography.labelMedium,
              fontStyle = FontStyle.Italic,
              color = MaterialTheme.colorScheme.secondary
            )
          }
        }
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          // Controls Row: Latin Switcher + Font Size + Audio TTS + Copy
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            if (prayer.isTraditionLatinAvailable && prayer.latinContent != null) {
              Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier
                  .clip(RoundedCornerShape(12.dp))
                  .clickable { isLatinView = !isLatinView }
              ) {
                Text(
                  text = if (isLatinView) "Ver en Español" else "Ver en Latín",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
                )
              }
            } else {
              Spacer(modifier = Modifier.width(1.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(
                text = "A-",
                modifier = Modifier
                  .clickable { if (fontScale > 13) fontScale -= 2 }
                  .padding(horizontal = 6.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
              )
              Text(
                text = "A+",
                modifier = Modifier
                  .clickable { if (fontScale < 24) fontScale += 2 }
                  .padding(horizontal = 6.dp, vertical = 4.dp),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
              )

              IconButton(
                onClick = {
                  if (currentlyPlayingPrayerId == prayer.id) {
                    ttsHelper.stop()
                    currentlyPlayingPrayerId = null
                  } else {
                    ttsHelper.speak(currentContent)
                    currentlyPlayingPrayerId = prayer.id
                  }
                }
              ) {
                Icon(
                  imageVector = if (currentlyPlayingPrayerId == prayer.id) Icons.Default.Stop else Icons.Default.PlayArrow,
                  contentDescription = "Escuchar oración",
                  tint = if (currentlyPlayingPrayerId == prayer.id) WinePrimary else MaterialTheme.colorScheme.primary
                )
              }

              IconButton(
                onClick = { copyToClipboard(prayer.title, currentContent) }
              ) {
                Icon(
                  imageVector = Icons.Default.ContentCopy,
                  contentDescription = "Copiar oración",
                  tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Interactive Bead Counter
          if (prayer.hasCounter) {
            Surface(
              shape = RoundedCornerShape(14.dp),
              color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
              modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Column {
                  Text(
                    text = "Contador de Cuentas",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                  )
                  Text(
                    text = "$prayerCounter / ${prayer.counterTotal}",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                  )
                }

                Row {
                  IconButton(onClick = { prayerCounter = 0 }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reiniciar")
                  }
                  Button(
                    onClick = {
                      if (prayerCounter < prayer.counterTotal) prayerCounter++
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
                    shape = RoundedCornerShape(10.dp)
                  ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Rezar cuenta")
                  }
                }
              }
            }
          }

          // Content Box
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(300.dp)
              .clip(RoundedCornerShape(12.dp))
              .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
              .padding(14.dp)
          ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
              item {
                Text(
                  text = currentContent,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = fontScale.sp,
                    lineHeight = (fontScale + 8).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                  text = "— ${prayer.description}",
                  style = MaterialTheme.typography.bodySmall,
                  fontStyle = FontStyle.Italic,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }
        }
      }
    )
  }
}

@Composable
fun PrayerItemRow(
  prayer: CatholicPrayer,
  isPlaying: Boolean,
  isFavorite: Boolean,
  onPlayClick: () -> Unit,
  onFavoriteClick: () -> Unit,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() },
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surface
    ),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(14.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = prayer.title,
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
          ),
          color = MaterialTheme.colorScheme.onSurface
        )

        prayer.latinTitle?.let {
          Text(
            text = it,
            style = MaterialTheme.typography.labelSmall,
            fontStyle = FontStyle.Italic,
            color = GoldSecondary
          )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text = prayer.description,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 2
        )
      }

      // Quick Audio Play Button
      IconButton(
        onClick = onPlayClick,
        modifier = Modifier.size(42.dp)
      ) {
        Icon(
          imageVector = if (isPlaying) Icons.Default.Stop else Icons.Default.PlayArrow,
          contentDescription = if (isPlaying) "Detener audio" else "Escuchar oración",
          tint = if (isPlaying) WinePrimary else MaterialTheme.colorScheme.primary
        )
      }

      // Favorite toggle
      IconButton(
        onClick = onFavoriteClick,
        modifier = Modifier.size(42.dp)
      ) {
        Icon(
          imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
          contentDescription = "Favorito",
          tint = if (isFavorite) WinePrimary else MaterialTheme.colorScheme.outline
        )
      }
    }
  }
}
