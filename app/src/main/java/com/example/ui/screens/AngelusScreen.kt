package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.AngelusRepository
import com.example.data.CatholicCalendarRepository
import com.example.data.UserPreferences
import com.example.notification.NotificationHelper
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import java.util.Calendar

@Composable
fun AngelusScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val scope = rememberCoroutineScope()
  val userPrefs = remember { UserPreferences(context) }
  val fontSize = (userPrefs.getFontSize() * 16).toInt()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // Detect season
  val todayCal = remember { Calendar.getInstance() }
  val currentSeason = remember {
    val month = todayCal.get(Calendar.MONTH) + 1
    val day = todayCal.get(Calendar.DAY_OF_MONTH)
    when {
      month == 4 || month == 5 -> "Tiempo Pascual"
      else -> "Tiempo Ordinario"
    }
  }

  val isEasterTime = currentSeason.contains("Pascual", ignoreCase = true)
  var selectedTab by remember { mutableIntStateOf(if (isEasterTime) 1 else 0) }

  val prayer = if (selectedTab == 1) AngelusRepository.reginaCaeli else AngelusRepository.angelus
  var angelusNotifEnabled by remember { mutableStateOf(userPrefs.isAngelusNotifEnabled()) }

  fun speakPrayer() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val speech = buildString {
        append("${prayer.title}. ${prayer.subtitle}. ")
        prayer.verses.forEach { v ->
          append("${v.versicle} ${v.response} ")
        }
        append("Dios te salve, María... ")
        append(prayer.concludingPrayer)
      }
      ttsHelper.speak(speech)
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

    // Top Header
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
            text = "El Ángelus y Regina Caeli",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = WinePrimary
          )
          Text(
            text = "Pausa Mariana a las 12:00h y 18:00h",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        IconButton(
          onClick = { speakPrayer() },
          modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
        ) {
          Icon(
            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
            contentDescription = "Escuchar oración",
            tint = WinePrimary
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Mode Selector (Ángelus vs Regina Caeli)
    TabRow(
      selectedTabIndex = selectedTab,
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .clip(RoundedCornerShape(14.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
      contentColor = WinePrimary
    ) {
      Tab(
        selected = selectedTab == 0,
        onClick = {
          ttsHelper.stop()
          isSpeaking = false
          selectedTab = 0
        },
        text = {
          Text(
            text = "El Ángelus 🔔",
            style = MaterialTheme.typography.labelMedium.copy(
              fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal
            )
          )
        }
      )
      Tab(
        selected = selectedTab == 1,
        onClick = {
          ttsHelper.stop()
          isSpeaking = false
          selectedTab = 1
        },
        text = {
          Text(
            text = "Regina Caeli (Pascua) 🌸",
            style = MaterialTheme.typography.labelMedium.copy(
              fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal
            )
          )
        }
      )
    }

    Spacer(modifier = Modifier.height(12.dp))

    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .widthIn(max = 600.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      // Angelus Notification Reminder Toggle Card
      item {
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
              Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = WinePrimary)
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Recordatorio a las 12:00h",
                  style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                  text = "Campana y aviso diario para consagrar el mediodía",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.outline
                )
              }
            }

            Switch(
              checked = angelusNotifEnabled,
              onCheckedChange = { isEnabled ->
                angelusNotifEnabled = isEnabled
                userPrefs.setAngelusNotifEnabled(isEnabled)
                if (isEnabled) {
                  NotificationHelper.scheduleAngelusAlarm(context)
                  scope.launch {
                    snackbarHostState.showSnackbar("Recordatorio del Ángelus activado a las 12:00h 🔔")
                  }
                } else {
                  NotificationHelper.cancelAngelusAlarm(context)
                  scope.launch {
                    snackbarHostState.showSnackbar("Recordatorio del Ángelus desactivado")
                  }
                }
              },
              colors = SwitchDefaults.colors(checkedThumbColor = WinePrimary, checkedTrackColor = WinePrimary.copy(alpha = 0.5f))
            )
          }
        }
      }

      // Versicles & Responses
      prayer.verses.forEachIndexed { index, v ->
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = v.versicle,
                style = MaterialTheme.typography.bodyLarge.copy(
                  fontWeight = FontWeight.Bold,
                  fontSize = fontSize.sp,
                  lineHeight = (fontSize * 1.4).sp
                ),
                color = WinePrimary
              )
              Spacer(modifier = Modifier.height(6.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
              ) {
                Text(
                  text = v.response,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.4).sp
                  ),
                  color = MaterialTheme.colorScheme.onPrimaryContainer,
                  modifier = Modifier.padding(10.dp)
                )
              }
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "Ave María, llena eres de gracia...",
                style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic),
                color = GoldSecondary
              )
            }
          }
        }
      }

      // Concluding Prayer
      item {
        ElevatedCard(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Oración Conclusiva",
              style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
              color = WinePrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = prayer.concludingPrayer,
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

      item { Spacer(modifier = Modifier.height(24.dp)) }
    }
  }
}
