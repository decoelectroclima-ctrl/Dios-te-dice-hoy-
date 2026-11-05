package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.data.ViaCrucisRepository
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.GranateButton
import com.example.ui.theme.GranateButtonDark
import com.example.ui.theme.GranateButtonBorderDark
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.appWineColor
import com.example.ui.theme.isAppInDarkTheme
import com.example.util.TextToSpeechHelper

@Composable
fun ViaCrucisScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val haptic = LocalHapticFeedback.current
  val isDark = isAppInDarkTheme()
  val userPrefs = remember { UserPreferences(context) }
  val fontSize = (userPrefs.getFontSize() * 16).toInt()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // Active Station index (0 to 13)
  var currentStationIndex by remember { mutableIntStateOf(0) }
  val stations = ViaCrucisRepository.stations
  val currentStation = stations[currentStationIndex]

  fun speakStation() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val textToSpeak = "Estación ${currentStation.number}: ${currentStation.title}. " +
          "${ViaCrucisRepository.stationInvocationV} ${ViaCrucisRepository.stationInvocationR}. " +
          "Lectura: ${currentStation.scriptureCitation}. ${currentStation.scriptureText}. " +
          "Meditación: ${currentStation.meditation}. " +
          "Oración: ${currentStation.prayer}."
      ttsHelper.speak(textToSpeak)
      isSpeaking = true
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(8.dp))

    // Top Header & Audio Control
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      shape = RoundedCornerShape(18.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = "El Santo Viacrucis",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = appWineColor()
          )
          Text(
            text = "14 Estaciones de la Pasión de Cristo",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        IconButton(
          onClick = { speakStation() },
          modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
        ) {
          Icon(
            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
            contentDescription = "Escuchar meditación",
            tint = appWineColor()
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Station selector pill row (I to XIV)
    LazyRow(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      itemsIndexed(stations) { idx, station ->
        val isSelected = idx == currentStationIndex
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = if (isSelected) (if (isDark) GranateButtonDark else GranateButton) else MaterialTheme.colorScheme.surfaceVariant,
          border = if (isSelected && isDark) BorderStroke(1.2.dp, GranateButtonBorderDark) else null,
          modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable {
              ttsHelper.stop()
              isSpeaking = false
              currentStationIndex = idx
              haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        ) {
          Box(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = station.romanNumeral,
              style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
              )
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // Station Detail Content
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .widthIn(max = 600.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // Header of Station
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = if (isDark) GranateButtonDark.copy(alpha = 0.25f) else WinePrimary.copy(alpha = 0.15f)
              ) {
                Text(
                  text = "Estación ${currentStation.romanNumeral} • ${currentStation.number} de 14",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor(),
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
              }

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = GoldSecondary.copy(alpha = 0.2f)
              ) {
                Text(
                  text = currentStation.virtue,
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                  color = GoldSecondary,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = currentStation.title,
              style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            Text(
              text = currentStation.latinTitle,
              style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
              color = MaterialTheme.colorScheme.outline
            )
          }
        }
      }

      // Universal Liturgical Invocation Card
      item {
        Surface(
          shape = RoundedCornerShape(14.dp),
          color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text(
              text = ViaCrucisRepository.stationInvocationV,
              style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
              color = appWineColor()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = ViaCrucisRepository.stationInvocationR,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
              )
            )
          }
        }
      }

      // Scripture
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Palabra de Dios",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.primary
            )
            Text(
              text = currentStation.scriptureCitation,
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = currentStation.scriptureText,
              style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily.Serif,
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.45).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }

      // Contemplative Meditation
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
          )
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Meditación Contemplativa",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = appWineColor()
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = currentStation.meditation,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.4).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }

      // Station Prayer
      item {
        ElevatedCard(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Oración",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = GoldSecondary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = currentStation.prayer,
              style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontSize = fontSize.sp,
                lineHeight = (fontSize * 1.45).sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
              text = "Padre Nuestro, Ave María y Gloria.",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.primary
            )
          }
        }
      }

      // Prev / Next Station Navigation buttons
      item {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          OutlinedButton(
            onClick = {
              if (currentStationIndex > 0) {
                ttsHelper.stop()
                isSpeaking = false
                currentStationIndex--
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
              }
            },
            enabled = currentStationIndex > 0,
            shape = RoundedCornerShape(12.dp)
          ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Anterior")
          }

          Text(
            text = "${currentStationIndex + 1} / 14",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.outline
          )

          Button(
            onClick = {
              if (currentStationIndex < stations.size - 1) {
                ttsHelper.stop()
                isSpeaking = false
                currentStationIndex++
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
              }
            },
            enabled = currentStationIndex < stations.size - 1,
            colors = appButtonColors(),
            border = appButtonBorder(),
            shape = RoundedCornerShape(12.dp)
          ) {
            Text("Siguiente", fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.width(6.dp))
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
          }
        }
      }

      item { Spacer(modifier = Modifier.height(24.dp)) }
    }
  }
}
