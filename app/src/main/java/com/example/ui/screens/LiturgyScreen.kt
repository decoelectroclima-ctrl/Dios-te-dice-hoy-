package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.rememberLazyListState
import kotlinx.coroutines.delay
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
import com.example.data.LiturgyRepository
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper

@Composable
fun LiturgyScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { com.example.data.UserPreferences(context) }
  var fontSize by remember { mutableFloatStateOf(prefs.getFontSize()) }
  var isAutoScrolling by remember { mutableStateOf(false) }

  val listState = rememberLazyListState()

  LaunchedEffect(isAutoScrolling) {
    if (isAutoScrolling) {
      while (true) {
        listState.animateScrollToItem(listState.firstVisibleItemIndex + 1)
        delay(1500)
      }
    }
  }

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  var selectedTabIndex by remember { mutableIntStateOf(0) }
  val tabs = listOf("La Misa de Hoy", "El Ordinario (Misalito)")

  val todayLiturgy = remember { LiturgyRepository.getTodayLiturgy() }
  val ordinaryParts = remember { LiturgyRepository.getOrdinaryOfTheMass() }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Controls
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text("Aa", fontSize = 12.sp, modifier = Modifier.padding(end = 8.dp))
      Slider(
        value = fontSize,
        onValueChange = {
          fontSize = it
          prefs.setFontSize(it)
        },
        valueRange = 12f..24f,
        modifier = Modifier.weight(1f)
      )
      IconButton(onClick = { isAutoScrolling = !isAutoScrolling }) {
        Icon(
          imageVector = if (isAutoScrolling) Icons.Default.Stop else Icons.Default.PlayArrow,
          contentDescription = "Autoscroll"
        )
      }
    }


    Spacer(modifier = Modifier.height(4.dp))

    // Sub-Tabs
    TabRow(
      selectedTabIndex = selectedTabIndex,
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .clip(RoundedCornerShape(14.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
      contentColor = WinePrimary
    ) {
      tabs.forEachIndexed { index, title ->
        Tab(
          selected = selectedTabIndex == index,
          onClick = {
            ttsHelper.stop()
            isSpeaking = false
            selectedTabIndex = index
          },
          text = {
            Text(
              text = title,
              style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
              )
            )
          }
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    when (selectedTabIndex) {
      0 -> {
        // TAB 1: LA MISA DE HOY (LECTURAS LITÚRGICAS)
        LazyColumn(
          state = listState,
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
          item {
            // Liturgical Color & Date Card
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
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                      modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(Color(todayLiturgy.liturgicalColor.hexColor))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = "${todayLiturgy.liturgicalSeason} • Color ${todayLiturgy.liturgicalColor.displayName}",
                      style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = (fontSize - 2).sp),
                      color = Color(todayLiturgy.liturgicalColor.hexColor)
                    )
                  }

                  IconButton(
                    onClick = {
                      if (isSpeaking) {
                        ttsHelper.stop()
                        isSpeaking = false
                      } else {
                        val fullSpeech = "${todayLiturgy.dayTitle}. ${todayLiturgy.celebrationName}. Primera Lectura: ${todayLiturgy.firstReadingCitation}. ${todayLiturgy.firstReadingText}. Salmo: ${todayLiturgy.responsorialPsalmCitation}. ${todayLiturgy.responsorialPsalmResponse}. Evangelio: ${todayLiturgy.gospelCitation}. ${todayLiturgy.gospelText}"
                        ttsHelper.speak(fullSpeech)
                        isSpeaking = true
                      }
                    }
                  ) {
                    Icon(
                      imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                      contentDescription = "Escuchar lecturas completas",
                      tint = WinePrimary
                    )
                  }
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = todayLiturgy.dayTitle,
                  style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = (fontSize + 4).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = todayLiturgy.celebrationName,
                  style = MaterialTheme.typography.bodyMedium.copy(fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.primary
                )
              }
            }
          }

          // Antífona de Entrada
          item {
            LiturgySectionCard(
              title = "Antífona de Entrada",
              citation = null,
              content = todayLiturgy.entranceAntiphon,
              italic = true,
              fontSize = fontSize
            )
          }

          // Primera Lectura
          item {
            LiturgySectionCard(
              title = "Primera Lectura",
              citation = todayLiturgy.firstReadingCitation,
              content = todayLiturgy.firstReadingText,
              footer = "Palabra de Dios. — R/. Te alabamos, Señor.",
              fontSize = fontSize
            )
          }

          // Salmo Responsorial
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text(
                  text = "Salmo Responsorial",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.primary
                )
                Text(
                  text = todayLiturgy.responsorialPsalmCitation,
                  style = MaterialTheme.typography.labelSmall.copy(fontSize = (fontSize - 2).sp),
                  color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.height(8.dp))

                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Text(
                    text = todayLiturgy.responsorialPsalmResponse,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(10.dp)
                  )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = todayLiturgy.responsorialPsalmText,
                  style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 22.sp, fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
          }

          // Segunda Lectura (si existe)
          if (todayLiturgy.secondReadingCitation != null && todayLiturgy.secondReadingText != null) {
            item {
              LiturgySectionCard(
                title = "Segunda Lectura",
                citation = todayLiturgy.secondReadingCitation,
                content = todayLiturgy.secondReadingText,
                footer = "Palabra de Dios. — R/. Te alabamos, Señor.",
                fontSize = fontSize
              )
            }
          }

          // Aclamación antes del Evangelio
          item {
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "Aleluya y Aclamación",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
                  color = GoldSecondary
                )
                Text(
                  text = todayLiturgy.gospelAcclamation,
                  style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic, fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.onSecondaryContainer
                )
              }
            }
          }

          // Santo Evangelio
          item {
            ElevatedCard(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(18.dp),
              colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("✝", fontSize = 20.sp, color = WinePrimary)
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "Santo Evangelio",
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = (fontSize + 2).sp
                      ),
                      color = WinePrimary
                    )
                    Text(
                      text = todayLiturgy.gospelCitation,
                      style = MaterialTheme.typography.labelSmall.copy(fontSize = fontSize.sp),
                      color = GoldSecondary,
                      fontWeight = FontWeight.SemiBold
                    )
                  }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                  text = todayLiturgy.gospelText,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    lineHeight = 26.sp,
                    fontSize = fontSize.sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                  text = "Palabra del Señor. — R/. Gloria a ti, Señor Jesús.",
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.primary
                )
              }
            }
          }

          // Antífona de Comunión y Reflexión
          item {
            LiturgySectionCard(
              title = "Antífona de Comunión",
              citation = null,
              content = todayLiturgy.communionAntiphon,
              italic = true,
              fontSize = fontSize
            )
          }

          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
              )
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = "Reflexión Litúrgica del Día",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
                    color = MaterialTheme.colorScheme.primary
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = todayLiturgy.liturgicalReflection,
                  style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp, fontSize = fontSize.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }

      1 -> {
        // TAB 2: EL ORDINARIO DE LA MISA (MISALITO COMPLETO PARA LAICOS)
        var showLatin by remember { mutableStateOf(false) }

        LazyColumn(
          state = listState,
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          item {
            // Header with Latin toggle
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
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
                    text = "El Ordinario de la Misa",
                    style = MaterialTheme.typography.titleMedium.copy(
                      fontWeight = FontWeight.Bold,
                      fontFamily = FontFamily.Serif
                    ),
                    color = WinePrimary
                  )
                  Text(
                    text = "Estructura, diálogos y respuestas de los fieles",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }

                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = if (showLatin) WinePrimary else MaterialTheme.colorScheme.surfaceVariant,
                  modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { showLatin = !showLatin }
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      imageVector = Icons.Default.Translate,
                      contentDescription = null,
                      tint = if (showLatin) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                      modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                      text = if (showLatin) "Latín" else "Español",
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                      color = if (showLatin) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  }
                }
              }
            }
          }

          items(ordinaryParts, key = { it.id }) { part ->
            OrdinaryPartCard(part = part, showLatin = showLatin, fontSize = fontSize)
          }

          item { Spacer(modifier = Modifier.height(24.dp)) }
        }
      }
    }
  }
}

@Composable
fun LiturgySectionCard(
  title: String,
  citation: String?,
  content: String,
  italic: Boolean = false,
  footer: String? = null,
  fontSize: Float
) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Text(
        text = title,
        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
        color = MaterialTheme.colorScheme.primary
      )
      if (citation != null) {
        Text(
          text = citation,
          style = MaterialTheme.typography.labelSmall.copy(fontSize = (fontSize - 2).sp),
          color = MaterialTheme.colorScheme.outline
        )
      }
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = content,
        style = MaterialTheme.typography.bodyMedium.copy(
          fontFamily = FontFamily.Serif,
          fontStyle = if (italic) FontStyle.Italic else FontStyle.Normal,
          lineHeight = (fontSize + 6).sp,
          fontSize = fontSize.sp
        ),
        color = MaterialTheme.colorScheme.onSurface
      )
      if (footer != null) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = footer,
          style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
          color = MaterialTheme.colorScheme.primary
        )
      }
    }
  }
}

@Composable
fun OrdinaryPartCard(
  part: com.example.model.OrdinaryPart,
  showLatin: Boolean,
  fontSize: Float
) {
  var expandedExplanation by remember { mutableStateOf(false) }

  Card(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Surface(
            shape = RoundedCornerShape(6.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
          ) {
            Text(
              text = part.section,
              style = MaterialTheme.typography.labelSmall.copy(fontSize = (fontSize - 4).sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = part.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif,
              fontSize = (fontSize + 2).sp
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          if (showLatin && part.latinTitle != null) {
            Text(
              text = part.latinTitle,
              style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic, fontSize = (fontSize - 2).sp),
              color = GoldSecondary
            )
          }
        }

        IconButton(onClick = { expandedExplanation = !expandedExplanation }) {
          Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Explicación",
            tint = if (expandedExplanation) WinePrimary else MaterialTheme.colorScheme.outline
          )
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Rubric (Postura / Acción)
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = "Rúbrica: ${part.rubric}",
          style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic, fontSize = (fontSize - 2).sp),
          color = MaterialTheme.colorScheme.onSecondaryContainer,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Sacerdote
      Text(
        text = "Sacerdote:",
        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
        color = WinePrimary
      )
      Text(
        text = part.priestDialogue,
        style = MaterialTheme.typography.bodySmall.copy(lineHeight = (fontSize + 3).sp, fontSize = fontSize.sp),
        color = MaterialTheme.colorScheme.onSurface
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Pueblo
      Text(
        text = "Pueblo (Fieles):",
        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
        color = GoldSecondary
      )
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = if (showLatin && part.latinPeopleResponse != null) part.latinPeopleResponse else part.peopleResponse,
          style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.SemiBold,
            lineHeight = (fontSize + 5).sp,
            fontSize = fontSize.sp
          ),
          color = MaterialTheme.colorScheme.onPrimaryContainer,
          modifier = Modifier.padding(10.dp)
        )
      }

      // Pedagogical Explanation for Laypeople
      AnimatedVisibility(visible = expandedExplanation) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
          Text(
            text = "Sentido litúrgico y espiritual:",
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, fontSize = fontSize.sp),
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = part.explanation,
            style = MaterialTheme.typography.bodySmall.copy(fontSize = fontSize.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }
  }
}
