package com.example.ui.screens

import android.content.Intent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import com.example.notification.NotificationHelper
import com.example.widget.DailyVerseWidgetProvider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.model.BibleVerse
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
  snackbarHostState: SnackbarHostState,
  currentThemeMode: String,
  onThemeModeChanged: (String) -> Unit,
  onNavigateToLiturgy: () -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()
  val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current
  val heartbeatPlayer = remember { com.example.util.HeartbeatPlayer() }
  var isHeartbeatPlaying by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose { heartbeatPlayer.release() }
  }

  // Current displayed verse
  var currentVerse by remember {
    mutableStateOf(
      prefs.getLastFreeWillVerseId()?.let { VerseRepository.getVerseById(it) }
        ?: VerseRepository.getDailyVerse()
    )
  }

  var isFavorite by remember(currentVerse.id) {
    mutableStateOf(prefs.isVerseFavorite(currentVerse.id))
  }

  // Text-To-Speech helper
  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  val todayFormatted = remember {
    val sdf = SimpleDateFormat("EEEE, d 'de' MMMM", Locale("es", "ES"))
    sdf.format(Date()).replaceFirstChar { it.uppercase() }
  }

  fun shareVerse(verse: BibleVerse) {
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(
        Intent.EXTRA_TEXT,
        "✨ Dios te dice hoy:\n«${verse.godSaysToday}»\n\n📖 ${verse.text}\n— ${verse.citation}\n\n💡 Significado para hoy:\n${verse.modernMeaning}\n\n👣 Aplicación práctica:\n${verse.practicalApplication}\n\nCompartido desde la app Dios Te Dice Hoy"
      )
      type = "text/plain"
    }
    context.startActivity(Intent.createChooser(sendIntent, "Compartir palabra de Dios"))
  }

  fun speakCurrentVerse() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val textToRead = "Dios te dice hoy: ${currentVerse.godSaysToday}. ${currentVerse.text}. Cita: ${currentVerse.citation}. Significado para hoy: ${currentVerse.modernMeaning}. Cómo aplicarlo a tu día: ${currentVerse.practicalApplication}"
      ttsHelper.speak(textToRead)
      isSpeaking = true
    }
  }

  fun drawRandomVerse() {
    ttsHelper.stop()
    isSpeaking = false
    val newVerse = VerseRepository.getRandomVerse(excludeId = currentVerse.id)
    currentVerse = newVerse
    prefs.setLastFreeWillVerseId(newVerse.id)
    isFavorite = prefs.isVerseFavorite(newVerse.id)
    scope.launch {
      snackbarHostState.showSnackbar("Palabra recibida al azar: ${newVerse.citation}")
    }
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(4.dp))
      // Liturgical Greeting Card
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        ),
        shape = RoundedCornerShape(16.dp)
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "🕊️",
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 10.dp)
          )
          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = todayFormatted,
              style = MaterialTheme.typography.labelMedium,
              color = MaterialTheme.colorScheme.primary,
              fontWeight = FontWeight.SemiBold
            )
            Text(
              text = "«La paz del Señor esté siempre con tu espíritu»",
              style = MaterialTheme.typography.bodySmall,
              fontStyle = FontStyle.Italic,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }
    }



    // MAIN SACRED CARD: "DIOS TE DICE HOY"
    item {
      ElevatedCard(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp)
          .testTag("daily_verse_card"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(
          containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          // Celestial header badge
          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(50.dp))
              .background(
                Brush.horizontalGradient(listOf(WinePrimary, GoldSecondary))
              )
              .padding(horizontal = 16.dp, vertical = 6.dp)
          ) {
            Text(
              text = "✨ Dios te dice hoy ✨",
              color = Color.White,
              style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
              )
            )
          }

          Spacer(modifier = Modifier.height(18.dp))

          // 1. Mensaje celestial para tu corazón
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(16.dp))
              .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f))
              .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                shape = RoundedCornerShape(16.dp)
              )
              .padding(16.dp)
          ) {
            Text(
              text = "«${currentVerse.godSaysToday}»",
              style = MaterialTheme.typography.titleMedium.copy(
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 24.sp
              ),
              color = MaterialTheme.colorScheme.onPrimaryContainer,
              textAlign = TextAlign.Center,
              modifier = Modifier.fillMaxWidth()
            )
          }

          Spacer(modifier = Modifier.height(16.dp))

          // 2. Texto bíblico
          Text(
            text = currentVerse.text,
            style = MaterialTheme.typography.bodyLarge.copy(
              fontFamily = FontFamily.Serif,
              fontStyle = FontStyle.Italic,
              lineHeight = 26.sp,
              fontSize = 17.sp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 8.dp)
          )

          Spacer(modifier = Modifier.height(10.dp))

          // Cita
          Text(
            text = "— ${currentVerse.citation}",
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )
          )

          Spacer(modifier = Modifier.height(16.dp))

          // 3. EXPLICACIÓN MODERNA DEL SIGNIFICADO
          Surface(
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.Info,
                  contentDescription = null,
                  tint = MaterialTheme.colorScheme.primary,
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Significado para tu vida actual:",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = currentVerse.modernMeaning,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                color = MaterialTheme.colorScheme.onSurface
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // 4. CÓMO APLICARLO A TU DÍA HOY
          Surface(
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
            border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.3f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.TaskAlt,
                  contentDescription = null,
                  tint = GoldSecondary,
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = "Cómo aplicarlo hoy a tu día:",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSecondaryContainer
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = currentVerse.practicalApplication,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
              )
            }
          }

          Spacer(modifier = Modifier.height(20.dp))

          // Actions Row: Escuchar / Favorito / Compartir / Al Azar
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
          ) {
            FilledTonalButton(
              onClick = { speakCurrentVerse() },
              modifier = Modifier.testTag("speak_verse_button"),
              colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = if (isSpeaking) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
              )
            ) {
              Icon(
                imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                contentDescription = if (isSpeaking) "Detener audio" else "Escuchar versículo",
                tint = if (isSpeaking) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = if (isSpeaking) "Pausar" else "Escuchar",
                color = if (isSpeaking) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
              )
            }

            IconButton(
              onClick = {
                haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
                val newStatus = prefs.toggleFavoriteVerse(currentVerse.id)
                isFavorite = newStatus
                scope.launch {
                  val msg = if (newStatus) "Guardado en tus favoritos 💖" else "Eliminado de favoritos"
                  snackbarHostState.showSnackbar(msg)
                }
              },
              modifier = Modifier.size(46.dp)
            ) {
              Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Favorito",
                tint = if (isFavorite) WinePrimary else MaterialTheme.colorScheme.outline
              )
            }

            IconButton(
              onClick = { shareVerse(currentVerse) },
              modifier = Modifier.size(46.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Compartir versículo",
                tint = MaterialTheme.colorScheme.primary
              )
            }

            IconButton(
              onClick = { drawRandomVerse() },
              modifier = Modifier.size(46.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Casino,
                contentDescription = "Nueva palabra al azar",
                tint = GoldSecondary
              )
            }

            IconButton(
              onClick = {
                isHeartbeatPlaying = !isHeartbeatPlaying
                if (isHeartbeatPlaying) heartbeatPlayer.start(72) else heartbeatPlayer.stop()
              },
              modifier = Modifier.size(46.dp)
            ) {
              Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Activar latido",
                tint = if (isHeartbeatPlaying) Color.Red else MaterialTheme.colorScheme.outline
              )
            }
          }
        }
      }
    }

    // SECTION 6: LA MISA DE HOY Y EL ORDINARIO (MISALITO)
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp)
          .clickable { onNavigateToLiturgy() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(46.dp)
              .clip(CircleShape)
              .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
          ) {
            Text("📖", fontSize = 22.sp)
          }

          Spacer(modifier = Modifier.width(14.dp))

          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = "La Misa de Hoy y el Misalito",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Lecturas bíblicas, Salmo, Evangelio del día y el Ordinario completo de la Santa Misa.",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }

          Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = null, tint = GoldSecondary)
        }
      }
    }

  }
}
