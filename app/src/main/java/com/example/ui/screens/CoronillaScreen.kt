package com.example.ui.screens

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CoronillaRepository
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.WineButtonDark
import com.example.ui.theme.WineButtonBorderDark
import com.example.ui.theme.appWineColor
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.isAppInDarkTheme
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch

@Composable
fun CoronillaScreen(
  snackbarHostState: SnackbarHostState? = null,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val haptic = LocalHapticFeedback.current
  val scope = rememberCoroutineScope()
  val isDark = isAppInDarkTheme()

  // TTS
  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // Stage: 0 = Oraciones Iniciales (3 PM, Padre Nuestro, Ave María, Credo)
  // 1 to 5 = Decenas (1 a 5)
  // 6 = Oraciones Finales (Santo Dios 3x, Oración Conclusiva)
  var currentStage by remember { mutableIntStateOf(0) }

  // Current bead in decade: 0 = Cuenta grande (Padre Eterno), 1 to 10 = Cuentas pequeñas (Por su dolorosa Pasión)
  var decadeBead by remember { mutableIntStateOf(0) }

  fun advanceBead() {
    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
    if (currentStage == 0) {
      currentStage = 1
      decadeBead = 0
      scope.launch {
        snackbarHostState?.showSnackbar("Iniciando la 1ª Decena de la Coronilla 🕊️")
      }
    } else if (currentStage in 1..5) {
      if (decadeBead < 10) {
        decadeBead++
      } else {
        // Finished 10 small beads
        if (currentStage < 5) {
          currentStage++
          decadeBead = 0
          scope.launch {
            snackbarHostState?.showSnackbar("Avanzando a la ${currentStage}ª Decena 🕊️")
          }
        } else {
          currentStage = 6
          decadeBead = 0
          scope.launch {
            snackbarHostState?.showSnackbar("¡Has completado las 5 decenas! Rezando la Doxología final ✨")
          }
        }
      }
    } else {
      // Stage 6 finished
      scope.launch {
        snackbarHostState?.showSnackbar("¡Coronilla de la Divina Misericordia completada! Jesús, en Ti confío ❤️")
      }
    }
  }

  fun resetCoronilla() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    }
    currentStage = 0
    decadeBead = 0
    scope.launch {
      snackbarHostState?.showSnackbar("Coronilla reiniciada desde el principio")
    }
  }

  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(14.dp)
  ) {
    item {
      Spacer(modifier = Modifier.height(6.dp))

      // Header card
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
              shape = CircleShape,
              color = if (isDark) WineButtonDark.copy(alpha = 0.25f) else WinePrimary.copy(alpha = 0.12f),
              border = if (isDark) BorderStroke(1.dp, WineButtonBorderDark.copy(alpha = 0.5f)) else null,
              modifier = Modifier.size(46.dp)
            ) {
              Box(contentAlignment = Alignment.Center) {
                Text("❤️", fontSize = 22.sp)
              }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
              Text(
                text = "Coronilla de la Divina Misericordia",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = appWineColor()
              )
              Text(
                text = "Rezo guiado cuenta por cuenta con audio en español",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "Revelada por el Señor Jesús a Santa Faustina Kowalska. Rezarla preferentemente a las 3:00 p.m. (la Hora de la Misericordia) o en cualquier momento de aflicción y conversión.",
            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }

    // Decade progress bar (Decenas 1 a 5)
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.3f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = when (currentStage) {
                0 -> "Paso: Oraciones Iniciales"
                in 1..5 -> "Decena $currentStage de 5 ${if (decadeBead == 0) "(Cuenta Grande)" else "(Cuenta $decadeBead de 10)"}"
                else -> "Paso: Oraciones Finales y Doxología"
              },
              style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
              color = appWineColor()
            )

            IconButton(
              onClick = { resetCoronilla() },
              modifier = Modifier.size(28.dp).testTag("coronilla_reset_button")
            ) {
              Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reiniciar", tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // 5 Decades indicators
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            for (dec in 1..5) {
              val isCompleted = currentStage > dec || currentStage == 6
              val isCurrent = currentStage == dec
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = when {
                  isCompleted -> GoldSecondary
                  isCurrent -> if (isDark) WineButtonDark else WinePrimary
                  else -> MaterialTheme.colorScheme.surfaceVariant
                },
                modifier = Modifier
                  .weight(1f)
                  .height(8.dp)
              ) {}
            }
          }
        }
      }
    }

    // Interactive Bead View
    item {
      when (currentStage) {
        0 -> {
          // Introductory prayers
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 600.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(1.5.dp, if (isDark) WineButtonBorderDark.copy(alpha = 0.6f) else WinePrimary.copy(alpha = 0.4f))
          ) {
            Column(modifier = Modifier.padding(18.dp)) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isDark) WineButtonDark.copy(alpha = 0.25f) else WinePrimary.copy(alpha = 0.1f)
              ) {
                Text(
                  text = "PASO 1: ORACIONES PREPARATORIAS",
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
              }

              Spacer(modifier = Modifier.height(12.dp))

              Text(
                text = "Oración de las Tres de la Tarde (Hora de la Misericordia):",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = GoldSecondary
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = CoronillaRepository.THREE_PM_PRAYER,
                style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic, lineHeight = 18.sp),
                color = MaterialTheme.colorScheme.onSurface
              )

              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Rezar a continuación:\n• Señal de la Cruz\n• Padre Nuestro\n• Ave María\n• Credo de los Apóstoles",
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp, fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )

              Spacer(modifier = Modifier.height(16.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(
                  onClick = {
                    if (isSpeaking) {
                      ttsHelper.stop()
                      isSpeaking = false
                    } else {
                      val full = "Oraciones iniciales de la Coronilla de la Divina Misericordia. ${CoronillaRepository.THREE_PM_PRAYER}. Padre Nuestro: ${CoronillaRepository.OUR_FATHER}. Ave María: ${CoronillaRepository.HAIL_MARY}. Credo: ${CoronillaRepository.APOSTLES_CREED}."
                      ttsHelper.speak(full) { isSpeaking = false }
                      isSpeaking = true
                    }
                  },
                  modifier = Modifier.testTag("coronilla_audio_intro")
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = "Escuchar audio",
                    tint = appWineColor()
                  )
                }

                Button(
                  onClick = { advanceBead() },
                  colors = appButtonColors(),
                  border = appButtonBorder(),
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.testTag("coronilla_start_decades_button")
                ) {
                  Text("Comenzar Decenas →", fontWeight = FontWeight.Bold, color = Color.White)
                }
              }
            }
          }
        }

        in 1..5 -> {
          // Decade bead-by-bead view
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 600.dp),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            border = BorderStroke(1.5.dp, GoldSecondary.copy(alpha = 0.5f))
          ) {
            Column(modifier = Modifier.padding(20.dp)) {
              // Bead Counter Row (10 small beads visualizer)
              Text(
                text = "Decena $currentStage de 5",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = appWineColor()
              )

              Spacer(modifier = Modifier.height(10.dp))

              // 10 Beads icons
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                // Large bead
                Surface(
                  shape = CircleShape,
                  color = if (decadeBead == 0) (if (isDark) WineButtonDark else WinePrimary) else GoldSecondary,
                  border = BorderStroke(2.dp, if (decadeBead == 0) GoldSecondary else Color.Transparent),
                  modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .clickable {
                      decadeBead = 0
                    }
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text("✝", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.Bold)
                  }
                }

                // 10 Small beads
                for (b in 1..10) {
                  val isDone = decadeBead >= b
                  val isSelected = decadeBead == b
                  Surface(
                    shape = CircleShape,
                    color = when {
                      isSelected -> if (isDark) WineButtonDark else WinePrimary
                      isDone -> GoldSecondary
                      else -> MaterialTheme.colorScheme.surfaceVariant
                    },
                    border = BorderStroke(1.dp, if (isSelected) GoldSecondary else Color.Transparent),
                    modifier = Modifier
                      .size(16.dp)
                      .clip(CircleShape)
                      .clickable {
                        decadeBead = b
                      }
                  ) {}
                }
              }

              Spacer(modifier = Modifier.height(16.dp))

              // Main prayer container for current bead
              if (decadeBead == 0) {
                // Cuenta Grande: Padre Eterno
                Surface(
                  shape = RoundedCornerShape(14.dp),
                  color = if (isDark) WineButtonDark.copy(alpha = 0.2f) else WinePrimary.copy(alpha = 0.08f),
                  border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.35f)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                      text = "⚪ En la cuenta grande al iniciar la decena:",
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                      color = appWineColor()
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = CoronillaRepository.ETERNAL_FATHER_PRAYER,
                      style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily.Serif
                      ),
                      color = MaterialTheme.colorScheme.onSurface
                    )
                  }
                }
              } else {
                // Cuenta Pequeña (1 a 10): Por su dolorosa Pasión
                Surface(
                  shape = RoundedCornerShape(14.dp),
                  color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                  border = BorderStroke(1.dp, if (isDark) WineButtonBorderDark.copy(alpha = 0.5f) else WinePrimary.copy(alpha = 0.3f)),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                      modifier = Modifier.fillMaxWidth(),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                    ) {
                      Text(
                        text = "🔴 Cuenta pequeña ($decadeBead de 10):",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = appWineColor()
                      )
                      Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (isDark) WineButtonDark.copy(alpha = 0.25f) else WinePrimary.copy(alpha = 0.12f)
                      ) {
                        Text(
                          text = "$decadeBead/10",
                          modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                          style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                          color = appWineColor()
                        )
                      }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                      text = "«${CoronillaRepository.SORROWFUL_PASSION_PRAYER}»",
                      style = MaterialTheme.typography.bodyLarge.copy(
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily.Serif
                      ),
                      color = MaterialTheme.colorScheme.onSurface
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(18.dp))
              HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
              Spacer(modifier = Modifier.height(12.dp))

              // Action buttons: Audio for current bead and Advance
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(
                  onClick = {
                    if (isSpeaking) {
                      ttsHelper.stop()
                      isSpeaking = false
                    } else {
                      val speechText = if (decadeBead == 0) {
                        "Decena $currentStage. Cuenta grande: ${CoronillaRepository.ETERNAL_FATHER_PRAYER}"
                      } else {
                        "Decena $currentStage, cuenta $decadeBead: ${CoronillaRepository.SORROWFUL_PASSION_PRAYER}"
                      }
                      ttsHelper.speak(speechText) { isSpeaking = false }
                      isSpeaking = true
                    }
                  },
                  modifier = Modifier.testTag("coronilla_audio_bead")
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = "Escuchar cuenta actual",
                    tint = appWineColor()
                  )
                }

                Button(
                  onClick = { advanceBead() },
                  colors = appButtonColors(),
                  border = appButtonBorder(),
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.testTag("coronilla_advance_bead_button")
                ) {
                  Text(
                    text = if (decadeBead < 10) "Siguiente cuenta ($decadeBead/10) →" else "Completar decena $currentStage →",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                  )
                }
              }
            }
          }
        }

        else -> {
          // Concluding Doxology and final prayer
          Card(
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 600.dp),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            border = BorderStroke(1.5.dp, GoldSecondary.copy(alpha = 0.5f))
          ) {
            Column(modifier = Modifier.padding(20.dp)) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = GoldSecondary.copy(alpha = 0.2f)
              ) {
                Text(
                  text = "DOXOLOGÍA Y ORACIÓN FINAL",
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
              }

              Spacer(modifier = Modifier.height(14.dp))

              Text(
                text = "Doxología Trisagio (repetir 3 veces):",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = appWineColor()
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "«Santo Dios, Santo Fuerte, Santo Inmortal, ten piedad de nosotros y del mundo entero.»",
                style = MaterialTheme.typography.bodyLarge.copy(
                  fontWeight = FontWeight.Bold,
                  fontStyle = FontStyle.Italic,
                  fontFamily = FontFamily.Serif,
                  lineHeight = 24.sp
                ),
                color = MaterialTheme.colorScheme.onSurface
              )

              Spacer(modifier = Modifier.height(14.dp))

              Text(
                text = "Oración Conclusiva:",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                color = GoldSecondary
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = CoronillaRepository.CONCLUDING_PRAYER,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 19.sp),
                color = MaterialTheme.colorScheme.onSurface
              )

              Spacer(modifier = Modifier.height(18.dp))
              HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
              Spacer(modifier = Modifier.height(12.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                IconButton(
                  onClick = {
                    if (isSpeaking) {
                      ttsHelper.stop()
                      isSpeaking = false
                    } else {
                      val full = "Doxología final: ${CoronillaRepository.HOLY_GOD_DOXOLOGY}. Oración final: ${CoronillaRepository.CONCLUDING_PRAYER}"
                      ttsHelper.speak(full) { isSpeaking = false }
                      isSpeaking = true
                    }
                  },
                  modifier = Modifier.testTag("coronilla_audio_final")
                ) {
                  Icon(imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow, contentDescription = null, tint = appWineColor())
                }

                Button(
                  onClick = { resetCoronilla() },
                  colors = appButtonColors(),
                  border = appButtonBorder(),
                  shape = RoundedCornerShape(12.dp),
                  modifier = Modifier.testTag("coronilla_finish_button")
                ) {
                  Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(6.dp))
                  Text("Rezar otra vez", fontWeight = FontWeight.Bold, color = Color.White)
                }
              }
            }
          }
        }
      }
    }

    // Promesas de Jesús para quienes recen la Coronilla
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
        border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.25f))
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Promesas de Jesús a Santa Faustina:",
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif),
            color = appWineColor()
          )
          Spacer(modifier = Modifier.height(8.dp))
          CoronillaRepository.promises.forEach { promise ->
            Row(modifier = Modifier.padding(vertical = 4.dp)) {
              Text("✨", fontSize = 14.sp)
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = promise,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp, fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
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
