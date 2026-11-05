package com.example.ui.screens

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CatholicCalendarRepository
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.model.DiosTeDiceMessage
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appWineColor
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
  snackbarHostState: SnackbarHostState,
  currentThemeMode: String,
  onThemeModeChanged: (String) -> Unit,
  onNavigateToLiturgy: (() -> Unit)? = null,
  onNavigateToPrayers: (() -> Unit)? = null,
  onNavigateToConfession: (() -> Unit)? = null,
  onNavigateToParishes: (() -> Unit)? = null,
  onNavigateToHandOfGod: (() -> Unit)? = null,
  onNavigateToSpotify: (() -> Unit)? = null,
  onNavigateToHolySpirit: (() -> Unit)? = null,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  // Text-To-Speech helper
  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // Today Date & Liturgical Info
  val todayFormatted = remember {
    val sdf = SimpleDateFormat("EEEE, d 'de' MMMM", Locale("es", "ES"))
    sdf.format(Date()).replaceFirstChar { it.uppercase() }
  }

  val todayCalendarDay = remember {
    try {
      val cal = Calendar.getInstance()
      val year = cal.get(Calendar.YEAR)
      val month = cal.get(Calendar.MONTH) + 1
      val day = cal.get(Calendar.DAY_OF_MONTH)
      CatholicCalendarRepository.getMonthCalendar(year, month).find { it.day == day }
    } catch (_: Exception) {
      null
    }
  }

  // Active message state
  var currentMessage by remember { mutableStateOf(VerseRepository.getDailyVerse()) }
  var selectedVirtueFilter by remember { mutableStateOf("Todos") }
  val virtues = remember { listOf("Todos") + VerseRepository.getAllVirtues() }

  var isFavorite by remember(currentMessage.id) {
    mutableStateOf(prefs.isVerseFavorite(currentMessage.id))
  }

  fun shareMessage(msg: DiosTeDiceMessage) {
    val shareText = """
      🕊️ DIOS TE DICE HOY 🕊️

      ${msg.citation}
      ${msg.verseText}

      «${msg.godSaysToday}»

      🌱 Significado:
      ${msg.modernMeaning}

      ⚓ Propósito de hoy:
      ${msg.practicalApplication}

      — Compartido desde la app Dios Te Dice Hoy
    """.trimIndent()

    val intent = Intent(Intent.ACTION_SEND).apply {
      type = "text/plain"
      putExtra(Intent.EXTRA_SUBJECT, "Dios te dice hoy: ${msg.citation}")
      putExtra(Intent.EXTRA_TEXT, shareText)
    }
    context.startActivity(Intent.createChooser(intent, "Compartir mensaje de fe"))
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(6.dp))

      // ============================================================
      // 1. LITURGICAL GREETING & DAILY BANNER
      // ============================================================
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        ),
        shape = RoundedCornerShape(18.dp)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text(text = "🕊️", fontSize = 22.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text(
                  text = todayFormatted,
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )
                if (todayCalendarDay != null) {
                  Text(
                    text = todayCalendarDay.title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
            }

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = appWineColor().copy(alpha = 0.16f)
            ) {
              Text(
                text = todayCalendarDay?.liturgicalSeason ?: "Tiempo Ordinario",
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                color = appWineColor()
              )
            }
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "«La paz del Señor esté siempre con tu espíritu»",
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }

    // ============================================================
    // 2. VIRTUE / EMOTIONAL FILTER CHIPS
    // ============================================================
    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "¿Qué necesita tu alma hoy?",
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
          )
          Text(
            text = "Elige un estado",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          items(virtues) { virtue ->
            val isSelected = selectedVirtueFilter == virtue
            FilterChip(
              selected = isSelected,
              onClick = {
                selectedVirtueFilter = virtue
                currentMessage = if (virtue == "Todos") {
                  VerseRepository.getDailyVerse()
                } else {
                  VerseRepository.getVerseByVirtue(virtue) ?: VerseRepository.getDailyVerse()
                }
              },
              label = { Text(virtue) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = appWineColor(),
                selectedLabelColor = Color.White
              )
            )
          }
        }
      }
    }

    // ============================================================
    // 3. MAIN CARD: «DIOS TE DICE HOY» (HERO CARD)
    // ============================================================
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.35f))
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          // Top badge & action controls
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = GoldSecondary.copy(alpha = 0.18f)
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(currentMessage.emoji, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "DIOS TE DICE HOY",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                  ),
                  color = appWineColor()
                )
              }
            }

            Surface(
              shape = RoundedCornerShape(12.dp),
              color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            ) {
              Text(
                text = currentMessage.virtue,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Citation
          Text(
            text = currentMessage.citation,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.primary
          )

          Spacer(modifier = Modifier.height(6.dp))

          // Scripture verse
          Text(
            text = currentMessage.verseText,
            style = MaterialTheme.typography.bodyMedium.copy(
              fontStyle = FontStyle.Italic,
              lineHeight = 22.sp
            ),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
          )

          Spacer(modifier = Modifier.height(14.dp))

          // God's voice quote container
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(16.dp))
              .background(
                Brush.verticalGradient(
                  colors = listOf(
                    appWineColor().copy(alpha = 0.12f),
                    GoldSecondary.copy(alpha = 0.15f)
                  )
                )
              )
              .border(1.dp, GoldSecondary.copy(alpha = 0.35f), RoundedCornerShape(16.dp))
              .padding(16.dp)
          ) {
            Column {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("✨", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "Palabra de Dios a tu corazón:",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "«${currentMessage.godSaysToday}»",
                style = MaterialTheme.typography.bodyLarge.copy(
                  fontWeight = FontWeight.SemiBold,
                  lineHeight = 25.sp,
                  fontFamily = FontFamily.Serif
                ),
                color = MaterialTheme.colorScheme.onSurface
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Contemporary Meaning
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
              .padding(12.dp)
          ) {
            Text(
              text = "💡 Reflexión Espiritual:",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = currentMessage.modernMeaning,
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          // Practical Application
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .background(appWineColor().copy(alpha = 0.08f))
              .padding(12.dp)
          ) {
            Text(
              text = "⚓ Propósito para hoy:",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = appWineColor()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = currentMessage.practicalApplication,
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }

          Spacer(modifier = Modifier.height(16.dp))
          HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
          Spacer(modifier = Modifier.height(10.dp))

          // Interactive action buttons (Voice, Favorite, Share, Randomize)
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
              // TTS Read Aloud Button
              IconButton(
                onClick = {
                  if (isSpeaking) {
                    ttsHelper.stop()
                    isSpeaking = false
                  } else {
                    val fullSpeech = "${currentMessage.citation}. ${currentMessage.verseText}. Dios te dice hoy: ${currentMessage.godSaysToday}. Propósito para hoy: ${currentMessage.practicalApplication}"
                    ttsHelper.speak(fullSpeech) {
                      isSpeaking = false
                    }
                    isSpeaking = true
                  }
                },
                modifier = Modifier.testTag("home_tts_button")
              ) {
                Icon(
                  imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                  contentDescription = if (isSpeaking) "Detener audio" else "Escuchar mensaje",
                  tint = if (isSpeaking) appWineColor() else MaterialTheme.colorScheme.onSurfaceVariant
                )
              }

              // Favorite Button
              IconButton(
                onClick = {
                  val newFav = prefs.toggleFavoriteVerse(currentMessage.id)
                  isFavorite = newFav
                  scope.launch {
                    snackbarHostState.showSnackbar(
                      if (newFav) "❤️ Mensaje guardado en tus favoritos" else "Mensaje eliminado de favoritos"
                    )
                  }
                },
                modifier = Modifier.testTag("home_favorite_button")
              ) {
                Icon(
                  imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                  contentDescription = "Favorito",
                  tint = if (isFavorite) appWineColor() else MaterialTheme.colorScheme.onSurfaceVariant
                )
              }

              // Share Button
              IconButton(
                onClick = { shareMessage(currentMessage) },
                modifier = Modifier.testTag("home_share_button")
              ) {
                Icon(
                  imageVector = Icons.Default.Share,
                  contentDescription = "Compartir mensaje",
                  tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }

            // Next / Random Message Button
            Button(
              onClick = {
                currentMessage = VerseRepository.getRandomVerse()
                selectedVirtueFilter = "Todos"
                if (isSpeaking) {
                  ttsHelper.stop()
                  isSpeaking = false
                }
              },
              shape = RoundedCornerShape(12.dp),
              colors = appButtonColors(),
              border = appButtonBorder(),
              modifier = Modifier.testTag("home_random_message_button")
            ) {
              Icon(imageVector = Icons.Default.Casino, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Otro mensaje", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, color = Color.White))
            }
          }
        }
      }
    }

    item {
      Spacer(modifier = Modifier.height(28.dp))
    }
  }
}
