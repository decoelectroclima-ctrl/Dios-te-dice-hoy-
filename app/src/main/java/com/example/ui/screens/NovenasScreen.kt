package com.example.ui.screens

import android.app.TimePickerDialog
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NovenaRepository
import com.example.data.UserPreferences
import com.example.model.CatholicNovena
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
fun NovenasScreen(
  snackbarHostState: SnackbarHostState? = null,
  onBack: (() -> Unit)? = null,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
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

  // Selected novena (null = list view, non-null = detail view)
  var selectedNovena by remember { mutableStateOf<CatholicNovena?>(null) }
  var searchQuery by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("Todos") }

  // Handle system back button when in detail view
  BackHandler(enabled = selectedNovena != null) {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    }
    selectedNovena = null
  }

  if (selectedNovena != null) {
    val novena = selectedNovena!!
    var currentDay by remember(novena.id) {
      mutableIntStateOf(prefs.getNovenaCurrentDay(novena.id))
    }
    var isReminderOn by remember(novena.id) {
      mutableStateOf(prefs.isNovenaReminderEnabled(novena.id))
    }
    val reminderTime = remember(novena.id, isReminderOn) {
      prefs.getNovenaReminderTime(novena.id)
    }

    val activeDayData = novena.days.getOrNull(currentDay - 1) ?: novena.days.first()

    LazyColumn(
      modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      item {
        Spacer(modifier = Modifier.height(6.dp))

        // Back header
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          IconButton(
            onClick = {
              if (isSpeaking) {
                ttsHelper.stop()
                isSpeaking = false
              }
              selectedNovena = null
            },
            modifier = Modifier.testTag("novena_back_button")
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Volver a la lista de novenas",
              tint = WinePrimary
            )
          }
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = novena.title,
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = WinePrimary
            )
            Text(
              text = "Fiesta: ${novena.feastDate}",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }

      // Day selector (Días 1 al 9)
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Text(
              text = "Progreso de la Novena (Día $currentDay de 9):",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = WinePrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              items(novena.days) { d ->
                val isSelected = d.dayNumber == currentDay
                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSelected) WinePrimary else MaterialTheme.colorScheme.surface,
                  border = BorderStroke(1.dp, if (isSelected) GoldSecondary else MaterialTheme.colorScheme.outlineVariant),
                  modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                      if (isSpeaking) {
                        ttsHelper.stop()
                        isSpeaking = false
                      }
                      currentDay = d.dayNumber
                      prefs.setNovenaCurrentDay(novena.id, d.dayNumber)
                    }
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "Día ${d.dayNumber}",
                      style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                      ),
                      color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                    )
                  }
                }
              }
            }
          }
        }
      }

      // Reminder bar
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (isReminderOn) WinePrimary.copy(alpha = 0.08f) else MaterialTheme.colorScheme.surface
          ),
          border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.35f))
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = if (isReminderOn) Icons.Default.NotificationsActive else Icons.Default.Alarm,
                contentDescription = null,
                tint = if (isReminderOn) WinePrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = if (isReminderOn) "Recordatorio activo: ${String.format("%02d:%02d", reminderTime.first, reminderTime.second)}h" else "Recordatorio diario apagado",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = "Recibe aviso cada día para tu novena",
                  style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }

            Button(
              onClick = {
                val curTime = prefs.getNovenaReminderTime(novena.id)
                TimePickerDialog(
                  context,
                  { _, hourOfDay, minute ->
                    prefs.setNovenaReminderTime(novena.id, hourOfDay, minute)
                    prefs.setNovenaReminderEnabled(novena.id, true)
                    isReminderOn = true
                    scope.launch {
                      snackbarHostState?.showSnackbar("⏰ Recordatorio diario fijado a las ${String.format("%02d:%02d", hourOfDay, minute)}h")
                    }
                  },
                  curTime.first,
                  curTime.second,
                  true
                ).show()
              },
              shape = RoundedCornerShape(10.dp),
              colors = appButtonColors(),
              border = appButtonBorder(),
              modifier = Modifier.testTag("novena_reminder_button")
            ) {
              Text(
                text = if (isReminderOn) "Cambiar hora" else "Activar aviso",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            }
          }
        }
      }

      // Prayer Content Card
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.3f))
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            // Title of current day
            Text(
              text = activeDayData.title,
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = WinePrimary
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Oración Inicial
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "🕊️ Oración Inicial para todos los días:",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = WinePrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = novena.openingPrayer,
                  style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Meditación del Día
            Text(
              text = "📖 Meditación del Día:",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = GoldSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = activeDayData.meditation,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontStyle = FontStyle.Italic,
                lineHeight = 22.sp,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Oración Particular del Día
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = WinePrimary.copy(alpha = 0.06f),
              border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.25f)),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "🙏 Súplica y Plegaria del Día:",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = WinePrimary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = activeDayData.dailyPrayer,
                  style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 20.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Oración Final
            Text(
              text = "✝️ Oración Final:",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = novena.closingPrayer,
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(12.dp))

            // Action row: Audio TTS, Share, Advance
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                // Audio
                IconButton(
                  onClick = {
                    if (isSpeaking) {
                      ttsHelper.stop()
                      isSpeaking = false
                    } else {
                      val fullPrayer = "${novena.title}. ${activeDayData.title}. Oración inicial: ${novena.openingPrayer}. Meditación: ${activeDayData.meditation}. Plegaria: ${activeDayData.dailyPrayer}. Oración final: ${novena.closingPrayer}"
                      ttsHelper.speak(fullPrayer) { isSpeaking = false }
                      isSpeaking = true
                    }
                  },
                  modifier = Modifier.testTag("novena_audio_button")
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = if (isSpeaking) "Detener audio" else "Escuchar oración del día",
                    tint = if (isSpeaking) WinePrimary else MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }

                // Share
                IconButton(
                  onClick = {
                    val shareText = """
                      🕊️ ${novena.title} 🕊️
                      ${activeDayData.title}
                      
                      📖 Meditación:
                      ${activeDayData.meditation}
                      
                      🙏 Oración:
                      ${activeDayData.dailyPrayer}
                      
                      — Rezo desde la app Dios Te Dice Hoy
                    """.trimIndent()
                    val intent = Intent(Intent.ACTION_SEND).apply {
                      type = "text/plain"
                      putExtra(Intent.EXTRA_SUBJECT, "${novena.title} - ${activeDayData.title}")
                      putExtra(Intent.EXTRA_TEXT, shareText)
                    }
                    context.startActivity(Intent.createChooser(intent, "Compartir novena"))
                  },
                  modifier = Modifier.testTag("novena_share_button")
                ) {
                  Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Compartir novena",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }

              // Advance to next day
              Button(
                onClick = {
                  val nextDay = if (currentDay < 9) currentDay + 1 else 9
                  currentDay = nextDay
                  prefs.setNovenaCurrentDay(novena.id, nextDay)
                  scope.launch {
                    if (nextDay == 9) {
                      snackbarHostState?.showSnackbar("¡Has alcanzado el Día 9! Que Dios escuche tu novena 🌹")
                    } else {
                      snackbarHostState?.showSnackbar("Día completado. Avanzando al Día $nextDay 🕊️")
                    }
                  }
                },
                colors = appButtonColors(),
                border = appButtonBorder(),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.testTag("novena_next_day_button")
              ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = if (currentDay >= 9) "Novena completada" else "Completar Día $currentDay",
                  fontSize = 12.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
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
  } else {
    // List view of 49 novenas
    val categories = remember { NovenaRepository.getCategories() }
    val filteredNovenas = remember(searchQuery, selectedCategory) {
      NovenaRepository.searchNovenas(searchQuery, selectedCategory)
    }

    LazyColumn(
      modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      item {
        Spacer(modifier = Modifier.height(6.dp))

        // Title header
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(22.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
          border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.35f))
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                shape = CircleShape,
                color = WinePrimary.copy(alpha = 0.12f),
                modifier = Modifier.size(44.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Text("🕯️", fontSize = 22.sp)
                }
              }
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = "49 Novenas Católicas",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = WinePrimary
                )
                Text(
                  text = "Nueve días de oración perseverante con recordatorio",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }
          }
        }
      }

      // Search bar
      item {
        OutlinedTextField(
          value = searchQuery,
          onValueChange = { searchQuery = it },
          placeholder = { Text("Buscar entre las 49 novenas...") },
          leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = WinePrimary)
          },
          trailingIcon = {
            if (searchQuery.isNotEmpty()) {
              IconButton(onClick = { searchQuery = "" }) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "Limpiar búsqueda")
              }
            }
          },
          singleLine = true,
          shape = RoundedCornerShape(16.dp),
          colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = WinePrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
          ),
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp)
            .testTag("novenas_search_input")
        )
      }

      // Category Chips
      item {
        LazyRow(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(categories) { cat ->
            FilterChip(
              selected = selectedCategory == cat,
              onClick = { selectedCategory = cat },
              label = { Text(cat, fontSize = 12.sp) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = WinePrimary,
                selectedLabelColor = Color.White
              ),
              border = FilterChipDefaults.filterChipBorder(
                enabled = true,
                selected = selectedCategory == cat,
                borderColor = if (selectedCategory == cat) GoldSecondary else MaterialTheme.colorScheme.outlineVariant
              )
            )
          }
        }
      }

      // Counter
      item {
        Text(
          text = "Mostrando ${filteredNovenas.size} de 49 novenas",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }

      // Novena Cards
      items(filteredNovenas, key = { it.id }) { novena ->
        val savedDay = prefs.getNovenaCurrentDay(novena.id)
        val hasReminder = prefs.isNovenaReminderEnabled(novena.id)

        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp)
            .clip(RoundedCornerShape(18.dp))
            .clickable { selectedNovena = novena }
            .testTag("novena_card_${novena.id}"),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
          border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.25f))
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = WinePrimary.copy(alpha = 0.1f)
              ) {
                Text(
                  text = novena.category,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = WinePrimary
                )
              }

              Row(verticalAlignment = Alignment.CenterVertically) {
                if (hasReminder) {
                  Icon(
                    imageVector = Icons.Default.NotificationsActive,
                    contentDescription = "Aviso activo",
                    tint = GoldSecondary,
                    modifier = Modifier.size(16.dp)
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                }
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = GoldSecondary.copy(alpha = 0.18f)
                ) {
                  Text(
                    text = "Día $savedDay de 9",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF523608)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = novena.title,
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
              text = novena.description,
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              maxLines = 2
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = "Fiesta: ${novena.feastDate}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
              )
              Text(
                text = "Rezar novena →",
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = WinePrimary
              )
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(28.dp))
      }
    }
  }
}
