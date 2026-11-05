package com.example.ui.screens

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
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.RosaryRepository
import com.example.data.UserPreferences
import com.example.model.RosaryMysteryType
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
fun RosaryInteractiveScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val haptic = LocalHapticFeedback.current
  val scope = rememberCoroutineScope()
  val userPrefs = remember { UserPreferences(context) }
  val fontSize = (userPrefs.getFontSize() * 16).toInt()
  val isDark = isAppInDarkTheme()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // Preselected today's mystery group
  val todayGroup = remember { RosaryRepository.getMysteryForToday() }
  var selectedType by remember { mutableStateOf(todayGroup.type) }
  val currentGroup = remember(selectedType) { RosaryRepository.getGroupByEnum(selectedType) }

  // Current Decade (0 to 4: representing 1st to 5th mystery)
  var currentDecadeIndex by remember { mutableIntStateOf(0) }
  val currentMystery = currentGroup.mysteries[currentDecadeIndex]

  // Bead counter (0 = Padre Nuestro, 1 to 10 = Avemarías, 11 = Gloria & Jaculatoria de Fátima)
  var beadCount by remember { mutableIntStateOf(0) }
  var autoAudioEnabled by remember { mutableStateOf(false) }

  // Section view toggle: 0 = Rosario Interactivo, 1 = Letanías Lauretanas
  var viewSubTab by remember { mutableIntStateOf(0) }

  val mysteryTypes = listOf(
    RosaryMysteryType.GOZOSOS,
    RosaryMysteryType.LUMINOSOS,
    RosaryMysteryType.DOLOROSOS,
    RosaryMysteryType.GLORIOSOS
  )

  fun speakCurrentBead() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val textToSpeak = when {
        beadCount == 0 -> "Primer rezo de la decena: Padre Nuestro. ${RosaryRepository.OUR_FATHER_TEXT}"
        beadCount in 1..10 -> "Decena ${currentDecadeIndex + 1}, Avemaría $beadCount de 10: ${RosaryRepository.HAIL_MARY_TEXT}"
        else -> "Gloria al Padre: ${RosaryRepository.GLORY_BE_TEXT} Jaculatoria de Fátima: ${RosaryRepository.FATIMA_EJACULATION}"
      }
      ttsHelper.speak(textToSpeak) {
        isSpeaking = false
      }
      isSpeaking = true
    }
  }

  fun advanceBead() {
    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    }
    if (beadCount < 10) {
      beadCount++
    } else if (beadCount == 10) {
      beadCount = 11 // Finished 10 Avemarías -> Gloria y Fátima
    } else {
      // Advance to next decade or complete
      if (currentDecadeIndex < 4) {
        currentDecadeIndex++
        beadCount = 0 // Start next decade with Padre Nuestro
        scope.launch {
          snackbarHostState.showSnackbar("Avanzando al ${currentDecadeIndex + 1}º Misterio 🕊️")
        }
      } else {
        beadCount = 11
        scope.launch {
          snackbarHostState.showSnackbar("¡Has completado los 5 misterios del Santo Rosario! 🌹")
        }
      }
    }
    if (autoAudioEnabled) {
      speakCurrentBead()
    }
  }

  fun speakMystery() {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val text = "${currentMystery.number}º Misterio: ${currentMystery.title}. Fruto del misterio: ${currentMystery.fruit}. ${currentMystery.scriptureCitation}. ${currentMystery.scriptureText}. Meditación: ${currentMystery.meditation}."
      ttsHelper.speak(text) {
        isSpeaking = false
      }
      isSpeaking = true
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(6.dp))

    // Today's Mystery indicator banner
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .padding(bottom = 6.dp),
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f))
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          modifier = Modifier.weight(1f, fill = false),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text("✨", fontSize = 16.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Column {
            Text(
              text = "Misterios de hoy: ${todayGroup.type.displayName}",
              style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
              color = appWineColor()
            )
            Text(
              text = "Liturgia del día (${todayGroup.type.days})",
              style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
        if (selectedType != todayGroup.type) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = if (isDark) WineButtonDark.copy(alpha = 0.35f) else WinePrimary.copy(alpha = 0.15f),
            border = if (isDark) BorderStroke(1.dp, WineButtonBorderDark.copy(alpha = 0.5f)) else null,
            modifier = Modifier
              .clip(RoundedCornerShape(8.dp))
              .clickable {
                selectedType = todayGroup.type
                currentDecadeIndex = 0
                beadCount = 0
              }
          ) {
            Text(
              text = "Ir a hoy",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = appWineColor(),
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            )
          }
        }
      }
    }

    // Mystery Cycle Tabs
    ScrollableTabRow(
      selectedTabIndex = mysteryTypes.indexOf(selectedType),
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .clip(RoundedCornerShape(14.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
      contentColor = appWineColor(),
      edgePadding = 8.dp,
      indicator = { tabPositions ->
        val idx = mysteryTypes.indexOf(selectedType)
        if (idx in tabPositions.indices) {
          TabRowDefaults.SecondaryIndicator(
            modifier = Modifier.tabIndicatorOffset(tabPositions[idx]),
            color = appWineColor(),
            height = 3.dp
          )
        }
      }
    ) {
      mysteryTypes.forEach { type ->
        val isSelected = selectedType == type
        Tab(
          selected = isSelected,
          onClick = {
            ttsHelper.stop()
            isSpeaking = false
            selectedType = type
            currentDecadeIndex = 0
            beadCount = 0
          },
          text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text(
                text = type.displayName,
                style = MaterialTheme.typography.labelSmall.copy(
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                  fontSize = 12.sp
                ),
                maxLines = 1
              )
              Text(
                text = type.days,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                color = if (isSelected) appWineColor() else MaterialTheme.colorScheme.outline
              )
            }
          }
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    // Sub-mode tabs: Decenario vs Letanías
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      horizontalArrangement = Arrangement.Center
    ) {
      Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (viewSubTab == 0) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.surfaceVariant,
        border = if (viewSubTab == 0 && isDark) BorderStroke(1.dp, WineButtonBorderDark) else null,
        modifier = Modifier
          .clip(RoundedCornerShape(12.dp))
          .clickable { viewSubTab = 0 }
      ) {
        Text(
          text = "Rosario Interactivo 📿",
          style = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Bold,
            color = if (viewSubTab == 0) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
          ),
          modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (viewSubTab == 1) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.surfaceVariant,
        border = if (viewSubTab == 1 && isDark) BorderStroke(1.dp, WineButtonBorderDark) else null,
        modifier = Modifier
          .clip(RoundedCornerShape(12.dp))
          .clickable { viewSubTab = 1 }
      ) {
        Text(
          text = "Letanías Lauretanas 👑",
          style = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Bold,
            color = if (viewSubTab == 1) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
          ),
          modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(10.dp))

    if (viewSubTab == 1) {
      // Letanías Lauretanas List
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .widthIn(max = 600.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = "Letanías de la Santísima Virgen María",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = appWineColor()
              )
              Text(
                text = "Alabanzas tradicionales de la Santa Iglesia",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }
        }

        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              RosaryRepository.litanyOfLoreto.forEach { litany ->
                Text(
                  text = litany,
                  style = MaterialTheme.typography.bodyMedium.copy(fontSize = fontSize.sp, lineHeight = (fontSize * 1.4).sp),
                  color = MaterialTheme.colorScheme.onSurface,
                  modifier = Modifier.padding(vertical = 4.dp)
                )
              }
            }
          }
        }

        item {
          ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = "La Salve Regina",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = GoldSecondary
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = RosaryRepository.SALVE_REGINA_TEXT,
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
    } else {
      // Interactive Rosary Counter & Decades
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .widthIn(max = 600.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        // Decade Selector Pills
        item {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            (0..4).forEach { idx ->
              val isDecadeSelected = idx == currentDecadeIndex
              Surface(
                shape = CircleShape,
                color = if (isDecadeSelected) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.surfaceVariant,
                border = if (isDecadeSelected && isDark) BorderStroke(1.5.dp, WineButtonBorderDark) else null,
                modifier = Modifier
                  .size(44.dp)
                  .clip(CircleShape)
                  .clickable {
                    currentDecadeIndex = idx
                    beadCount = 1
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                  }
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Text(
                    text = "${idx + 1}º",
                    style = MaterialTheme.typography.labelMedium.copy(
                      fontWeight = FontWeight.Bold,
                      color = if (isDecadeSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  )
                }
              }
            }
          }
        }

        // Active Mystery Header
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (isDark) WineButtonDark.copy(alpha = 0.35f) else WinePrimary.copy(alpha = 0.15f),
                  border = if (isDark) BorderStroke(1.dp, WineButtonBorderDark.copy(alpha = 0.5f)) else null
                ) {
                  Text(
                    text = "Misterio ${currentMystery.number} de 5",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = appWineColor(),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }

                IconButton(
                  onClick = { speakMystery() },
                  modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = "Escuchar misterio",
                    tint = appWineColor(),
                    modifier = Modifier.size(20.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = currentMystery.title,
                style = MaterialTheme.typography.titleLarge.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = MaterialTheme.colorScheme.onSurface
              )

              Surface(
                shape = RoundedCornerShape(6.dp),
                color = GoldSecondary.copy(alpha = 0.15f),
                modifier = Modifier.padding(top = 4.dp)
              ) {
                Text(
                  text = "Fruto: ${currentMystery.fruit}",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                  color = GoldSecondary,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
              }

              Spacer(modifier = Modifier.height(10.dp))

              Text(
                text = currentMystery.scriptureCitation,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
              )
              Text(
                text = currentMystery.scriptureText,
                style = MaterialTheme.typography.bodyMedium.copy(
                  fontStyle = FontStyle.Italic,
                  fontSize = fontSize.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )

              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = currentMystery.meditation,
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                color = MaterialTheme.colorScheme.onSurface
              )
            }
          }
        }

        // Bead Progress Visual (Padre Nuestro + 10 Avemarías + Gloria)
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
          ) {
            Column(
              modifier = Modifier.padding(16.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column {
                  Text(
                    text = when {
                      beadCount == 0 -> "Cuenta 0: Padre Nuestro"
                      beadCount in 1..10 -> "Cuenta $beadCount: Avemaría ($beadCount de 10)"
                      else -> "Cuenta Final: Gloria y Jaculatoria"
                    },
                    style = MaterialTheme.typography.titleMedium.copy(
                      fontWeight = FontWeight.Bold,
                      color = appWineColor()
                    )
                  )
                  Text(
                    text = "Toca cualquier cuenta para rezarla",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                  )
                }

                // Audio Button for this specific bead
                IconButton(
                  onClick = { speakCurrentBead() },
                  modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(if (isSpeaking) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.primaryContainer)
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = "Escuchar cuenta actual en audio",
                    tint = if (isSpeaking) Color.White else appWineColor(),
                    modifier = Modifier.size(24.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(14.dp))

              // Bead Navigation Row (Padre Nuestro + 10 Avemarías + Gloria)
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                // Bead 0: Padre Nuestro
                val isPNOSelected = beadCount == 0
                Box(
                  modifier = Modifier
                    .size(if (isPNOSelected) 32.dp else 26.dp)
                    .clip(CircleShape)
                    .background(if (isPNOSelected) GoldSecondary else (if (isDark) WineButtonDark else WinePrimary.copy(alpha = 0.85f)))
                    .border(
                      width = if (isPNOSelected) 2.dp else 1.dp,
                      color = if (isPNOSelected) (if (isDark) WineButtonBorderDark else WinePrimary) else Color.Transparent,
                      shape = CircleShape
                    )
                    .clickable {
                      beadCount = 0
                      haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                      if (autoAudioEnabled) speakCurrentBead()
                    },
                  contentAlignment = Alignment.Center
                ) {
                  Text(
                    text = "P",
                    style = MaterialTheme.typography.labelSmall.copy(
                      fontWeight = FontWeight.Bold,
                      fontSize = 11.sp,
                      color = Color.White
                    )
                  )
                }

                // 10 Avemaría Beads
                (1..10).forEach { i ->
                  val isCompleted = i < beadCount && beadCount <= 10
                  val isCurrent = i == beadCount
                  Box(
                    modifier = Modifier
                      .size(if (isCurrent) 26.dp else 20.dp)
                      .clip(CircleShape)
                    .background(
                      when {
                        isCurrent -> GoldSecondary
                        isCompleted -> if (isDark) WineButtonDark else WinePrimary
                        else -> MaterialTheme.colorScheme.surfaceVariant
                      }
                    )
                    .border(
                      width = if (isCurrent) 2.dp else 1.dp,
                      color = if (isCurrent) (if (isDark) WineButtonBorderDark else WinePrimary) else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                      shape = CircleShape
                    )
                    .clickable {
                      beadCount = i
                      haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                      if (autoAudioEnabled) speakCurrentBead()
                    },
                  contentAlignment = Alignment.Center
                ) {
                  if (isCompleted && !isCurrent) {
                    Icon(
                      imageVector = Icons.Default.Check,
                      contentDescription = null,
                      tint = Color.White,
                      modifier = Modifier.size(11.dp)
                    )
                  } else {
                    Text(
                      text = "$i",
                      style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 9.sp,
                        fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                        color = if (isCurrent) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                      )
                    )
                  }
                }
              }

              // Bead 11: Gloria
              val isGloriaSelected = beadCount == 11
              Box(
                modifier = Modifier
                  .size(if (isGloriaSelected) 32.dp else 26.dp)
                  .clip(CircleShape)
                  .background(if (isGloriaSelected) GoldSecondary else (if (isDark) WineButtonDark else WinePrimary.copy(alpha = 0.85f)))
                  .border(
                    width = if (isGloriaSelected) 2.dp else 1.dp,
                    color = if (isGloriaSelected) (if (isDark) WineButtonBorderDark else WinePrimary) else Color.Transparent,
                    shape = CircleShape
                  )
                  .clickable {
                    beadCount = 11
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    if (autoAudioEnabled) speakCurrentBead()
                  },
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = "G",
                  style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = Color.White
                  )
                )
              }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Primary Action: Advance Bead Button (Large, tactile)
            Button(
              onClick = { advanceBead() },
              modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
              shape = RoundedCornerShape(16.dp),
              colors = appButtonColors(),
              border = appButtonBorder()
            ) {
                Text(
                  text = when {
                    beadCount == 0 -> "Rezar Padre Nuestro • Pasar a 1ª Avemaría 📿"
                    beadCount < 10 -> "Rezar Avemaría ($beadCount/10) • Pasar Cuenta"
                    beadCount == 10 -> "Concluir 10 Avemarías • Rezar Gloria"
                    else -> "Siguiente Misterio (${currentDecadeIndex + 2}º) ➡️"
                  },
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                  )
                )
              }
            }
          }
        }

        // Active Prayer Text Card with Audio Listen Bar
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = when {
                    beadCount == 0 -> "Oración del Padre Nuestro"
                    beadCount in 1..10 -> "Oración del Avemaría ($beadCount de 10)"
                    else -> "Gloria al Padre y Jaculatoria de Fátima"
                  },
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )

                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (isSpeaking) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                  border = if (isSpeaking && isDark) BorderStroke(1.dp, WineButtonBorderDark) else null,
                  modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { speakCurrentBead() }
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = if (isSpeaking) "Detener ⏹️" else "Escuchar en Español 🔊",
                      style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (isSpeaking) Color.White else appWineColor()
                      )
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = when {
                  beadCount == 0 -> RosaryRepository.OUR_FATHER_TEXT
                  beadCount in 1..10 -> RosaryRepository.HAIL_MARY_TEXT
                  else -> "${RosaryRepository.GLORY_BE_TEXT}\n\n${RosaryRepository.FATIMA_EJACULATION}"
                },
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

        // Reset Decade or Rosary
        item {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
          ) {
            OutlinedButton(
              onClick = {
                beadCount = 1
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
              },
              shape = RoundedCornerShape(12.dp)
            ) {
              Icon(imageVector = Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Reiniciar Decena Actual")
            }
          }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }
      }
    }
  }
}
