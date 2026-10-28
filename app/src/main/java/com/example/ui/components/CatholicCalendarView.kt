package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolunteerActivism
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
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CatholicCalendarRepository
import com.example.model.CatholicCalendarDay
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun CatholicCalendarView(
  snackbarHostState: SnackbarHostState,
  ttsHelper: TextToSpeechHelper,
  isSpeaking: Boolean,
  onSpeakingChange: (Boolean) -> Unit,
  fontSize: Int = 16,
  onNavigateToMassToday: () -> Unit = {}
) {
  val context = LocalContext.current
  val scope = rememberCoroutineScope()
  val haptic = LocalHapticFeedback.current

  // Current real date
  val realCal = remember { Calendar.getInstance() }
  val currentRealYear = remember { realCal.get(Calendar.YEAR) }
  val currentRealMonth = remember { realCal.get(Calendar.MONTH) + 1 }
  val currentRealDay = remember { realCal.get(Calendar.DAY_OF_MONTH) }

  // Calendar browsing state (year and 1-indexed month)
  var displayedYear by remember { mutableIntStateOf(currentRealYear) }
  var displayedMonth by remember { mutableIntStateOf(currentRealMonth) }
  var selectedDayNumber by remember { mutableIntStateOf(currentRealDay) }

  // Days list of displayed month
  val monthDays = remember(displayedYear, displayedMonth) {
    CatholicCalendarRepository.getMonthCalendar(displayedYear, displayedMonth)
  }

  // Selected day object
  val selectedDay = remember(monthDays, selectedDayNumber) {
    monthDays.find { it.day == selectedDayNumber } ?: monthDays.firstOrNull()
  }

  // Calculate day-of-week offset for day 1 (Monday = 0, Sunday = 6)
  val firstDayOffset = remember(displayedYear, displayedMonth) {
    val temp = Calendar.getInstance()
    temp.set(Calendar.YEAR, displayedYear)
    temp.set(Calendar.MONTH, displayedMonth - 1)
    temp.set(Calendar.DAY_OF_MONTH, 1)
    val dow = temp.get(Calendar.DAY_OF_WEEK)
    // Convert Sunday (1) to 6, Monday (2) to 0, ...
    if (dow == Calendar.SUNDAY) 6 else dow - 2
  }

  val monthName = remember(displayedMonth) {
    val symbols = DateFormatSymbols(Locale("es", "ES"))
    symbols.months[displayedMonth - 1].replaceFirstChar { it.uppercase() }
  }

  val weekDayHeaders = listOf("L", "M", "X", "J", "V", "S", "D")

  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // --- MONTH NAVIGATION HEADER ---
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .testTag("catholic_calendar_card"),
      shape = RoundedCornerShape(18.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(modifier = Modifier.padding(14.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.CalendarToday,
              contentDescription = null,
              tint = WinePrimary,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "$monthName $displayedYear",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }

          Row(verticalAlignment = Alignment.CenterVertically) {
            // Previous Month
            IconButton(
              onClick = {
                if (displayedMonth == 1) {
                  displayedMonth = 12
                  displayedYear--
                } else {
                  displayedMonth--
                }
                selectedDayNumber = 1
              },
              modifier = Modifier.size(36.dp)
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Mes anterior",
                tint = MaterialTheme.colorScheme.primary
              )
            }

            // Today button
            OutlinedButton(
              onClick = {
                displayedYear = currentRealYear
                displayedMonth = currentRealMonth
                selectedDayNumber = currentRealDay
              },
              shape = RoundedCornerShape(8.dp),
              contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 8.dp, vertical = 2.dp),
              modifier = Modifier.height(30.dp)
            ) {
              Text("Hoy", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }

            // Next Month
            IconButton(
              onClick = {
                if (displayedMonth == 12) {
                  displayedMonth = 1
                  displayedYear++
                } else {
                  displayedMonth++
                }
                selectedDayNumber = 1
              },
              modifier = Modifier.size(36.dp)
            ) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Mes siguiente",
                tint = MaterialTheme.colorScheme.primary
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // --- WEEKDAY LABELS (L M X J V S D) ---
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceAround
        ) {
          weekDayHeaders.forEachIndexed { idx, dayLabel ->
            val isSunday = idx == 6
            Text(
              text = dayLabel,
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = if (isSunday) WinePrimary else MaterialTheme.colorScheme.outline,
              modifier = Modifier.weight(1f),
              textAlign = TextAlign.Center
            )
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // --- CALENDAR GRID OF DAYS (7 COLUMNS) ---
        val totalCells = firstDayOffset + monthDays.size
        val totalRows = (totalCells + 6) / 7

        for (row in 0 until totalRows) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
          ) {
            for (col in 0 until 7) {
              val cellIndex = row * 7 + col
              val dayNum = cellIndex - firstDayOffset + 1

              if (dayNum in 1..monthDays.size) {
                val dayData = monthDays[dayNum - 1]
                val isSelected = dayData.day == selectedDayNumber
                val isToday = dayData.year == currentRealYear &&
                  dayData.month == currentRealMonth &&
                  dayData.day == currentRealDay
                val isSunday = col == 6

                Box(
                  modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .padding(2.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                      when {
                        isSelected -> WinePrimary
                        isToday -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                        else -> Color.Transparent
                      }
                    )
                    .border(
                      width = if (isToday && !isSelected) 1.5.dp else if (dayData.rank == CelebrationRank.SOLEMNIDAD) 1.dp else 0.dp,
                      color = if (isToday && !isSelected) WinePrimary else if (dayData.rank == CelebrationRank.SOLEMNIDAD) GoldSecondary else Color.Transparent,
                      shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                      haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.TextHandleMove)
                      selectedDayNumber = dayData.day
                    },
                  contentAlignment = Alignment.Center
                ) {
                  Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                  ) {
                    Text(
                      text = "${dayData.day}",
                      style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = if (isSelected || isToday || isSunday || dayData.rank == CelebrationRank.SOLEMNIDAD) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                      ),
                      color = when {
                        isSelected -> Color.White
                        isSunday -> WinePrimary
                        else -> MaterialTheme.colorScheme.onSurface
                      }
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    // Liturgical color dot
                    Box(
                      modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(
                          if (isSelected) Color.White else Color(dayData.liturgicalColor.hexColor)
                        )
                    )
                  }
                }
              } else {
                // Empty spacer cell
                Spacer(
                  modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Liturgical color legend
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceAround,
          verticalAlignment = Alignment.CenterVertically
        ) {
          LiturgicalLegendItem(color = LiturgicalColor.VERDE, label = "T. Ordinario")
          LiturgicalLegendItem(color = LiturgicalColor.BLANCO, label = "Fiestas/Pascua")
          LiturgicalLegendItem(color = LiturgicalColor.MORADO, label = "Adviento/Cuaresma")
          LiturgicalLegendItem(color = LiturgicalColor.ROJO, label = "Mártires/Espíritu")
        }
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    // --- DETAILED SELECTED DAY SECTION ---
    if (selectedDay != null) {
      SelectedDayDetailCard(
        day = selectedDay,
        fontSize = fontSize,
        ttsHelper = ttsHelper,
        isSpeaking = isSpeaking,
        onSpeakingChange = onSpeakingChange,
        onNavigateToMassToday = onNavigateToMassToday,
        snackbarHostState = snackbarHostState
      )
    }
  }
}

@Composable
private fun LiturgicalLegendItem(color: LiturgicalColor, label: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Box(
      modifier = Modifier
        .size(8.dp)
        .clip(CircleShape)
        .background(Color(color.hexColor))
    )
    Spacer(modifier = Modifier.width(4.dp))
    Text(
      text = label,
      fontSize = 9.sp,
      color = MaterialTheme.colorScheme.outline
    )
  }
}

@Composable
fun SelectedDayDetailCard(
  day: CatholicCalendarDay,
  fontSize: Int,
  ttsHelper: TextToSpeechHelper,
  isSpeaking: Boolean,
  onSpeakingChange: (Boolean) -> Unit,
  onNavigateToMassToday: () -> Unit,
  snackbarHostState: SnackbarHostState
) {
  val context = LocalContext.current
  val scope = rememberCoroutineScope()

  val formattedFullDate = remember(day) {
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, day.year)
    cal.set(Calendar.MONTH, day.month - 1)
    cal.set(Calendar.DAY_OF_MONTH, day.day)
    val sdf = SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", Locale("es", "ES"))
    sdf.format(cal.time).replaceFirstChar { it.uppercase() }
  }

  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .testTag("selected_day_detail_card"),
    shape = RoundedCornerShape(20.dp),
    colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
  ) {
    Column(modifier = Modifier.padding(18.dp)) {
      // Header: Date & TTS Playback
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = formattedFullDate,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "${day.liturgicalSeason} • Color ${day.liturgicalColor.displayName}",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = Color(day.liturgicalColor.hexColor)
          )
        }

        IconButton(
          onClick = {
            if (isSpeaking) {
              ttsHelper.stop()
              onSpeakingChange(false)
            } else {
              val speech = "$formattedFullDate. ${day.title}. ${day.saintName}. ${day.saintBiography}. Primera Lectura: ${day.firstReadingCitation}. ${day.firstReadingSummary}. Salmo: ${day.psalmCitation}. ${day.psalmResponse}. Evangelio: ${day.gospelCitation}. ${day.gospelSummary}. Oración: ${day.dailyPrayer}"
              ttsHelper.speak(speech) {
                onSpeakingChange(false)
              }
              onSpeakingChange(true)
            }
          }
        ) {
          Icon(
            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
            contentDescription = "Escuchar el santoral y lecturas del día",
            tint = WinePrimary
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Badges: Rank, Precept, Abstinence
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        Surface(
          shape = RoundedCornerShape(6.dp),
          color = Color(day.rank.badgeColor).copy(alpha = 0.15f)
        ) {
          Text(
            text = day.rank.displayName,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = Color(day.rank.badgeColor),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
          )
        }

        if (day.isHolyDayOfObligation) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = GoldSecondary.copy(alpha = 0.2f)
          ) {
            Text(
              text = "Día de Precepto ✝",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = GoldSecondary,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
            )
          }
        }

        if (day.isAbstinenceDay) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)
          ) {
            Text(
              text = "Abstinencia 🕊️",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onSecondaryContainer,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // --- SANTORAL CATÓLICO DEL DÍA ---
      Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🕊️", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Santoral Católico",
              style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = WinePrimary
            )
          }

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = day.saintName,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = day.saintBiography,
            style = MaterialTheme.typography.bodyMedium.copy(
              lineHeight = (fontSize * 1.4).sp,
              fontSize = (fontSize - 1).sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = "Patronazgo / Virtud: ${day.saintPatronage}",
            style = MaterialTheme.typography.labelSmall.copy(
              fontWeight = FontWeight.SemiBold,
              fontStyle = FontStyle.Italic
            ),
            color = GoldSecondary
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // --- LITURGIA DE LA PALABRA Y EVANGELIO ---
      Text(
        text = "Liturgia de la Palabra",
        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.primary
      )

      Spacer(modifier = Modifier.height(6.dp))

      // 1ª Lectura
      Text(
        text = "• 1ª Lectura: ${day.firstReadingCitation}",
        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onSurface
      )
      Text(
        text = day.firstReadingSummary,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )

      Spacer(modifier = Modifier.height(6.dp))

      // Salmo Responsorial
      Text(
        text = "• Salmo: ${day.psalmCitation}",
        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onSurface
      )
      Text(
        text = day.psalmResponse,
        style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
        color = GoldSecondary
      )

      // 2ª Lectura (si aplica en domingos)
      if (day.secondReadingCitation != null && day.secondReadingSummary != null) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
          text = "• 2ª Lectura: ${day.secondReadingCitation}",
          style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
          color = MaterialTheme.colorScheme.onSurface
        )
        Text(
          text = day.secondReadingSummary,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Santo Evangelio
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(10.dp)) {
          Text(
            text = "✝ Santo Evangelio: ${day.gospelCitation}",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = WinePrimary
          )
          Spacer(modifier = Modifier.height(3.dp))
          Text(
            text = day.gospelSummary,
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onPrimaryContainer
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // --- ORACIÓN DEVOCIONAL / JACULATORIA DEL DÍA ---
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(12.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.VolunteerActivism,
              contentDescription = null,
              tint = GoldSecondary,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Oración y Jaculatoria del Día",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = GoldSecondary
            )
          }

          Spacer(modifier = Modifier.height(6.dp))

          Text(
            text = day.dailyPrayer,
            style = MaterialTheme.typography.bodyMedium.copy(
              fontFamily = FontFamily.Serif,
              fontStyle = FontStyle.Italic,
              lineHeight = 22.sp
            ),
            color = MaterialTheme.colorScheme.onSecondaryContainer
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Buttons
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        OutlinedButton(
          onClick = {
            val shareText = "📅 ${day.title}\n🕊️ Santoral: ${day.saintName}\n📖 Evangelio: ${day.gospelCitation}\n\n«${day.dailyPrayer}»\n\n— Dios Te Dice Hoy"
            val sendIntent = android.content.Intent().apply {
              action = android.content.Intent.ACTION_SEND
              putExtra(android.content.Intent.EXTRA_TEXT, shareText)
              type = "text/plain"
            }
            context.startActivity(android.content.Intent.createChooser(sendIntent, "Compartir Santoral del Día"))
          },
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("Compartir", fontSize = 12.sp)
        }

        Button(
          onClick = onNavigateToMassToday,
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary, contentColor = Color.White),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("Ver Misa", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
      }
    }
  }
}
