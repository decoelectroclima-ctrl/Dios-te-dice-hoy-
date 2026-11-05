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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.data.CatholicCalendarRepository
import com.example.data.LiturgyHour
import com.example.data.LiturgyOfHoursRepository
import com.example.data.LiturgyRepository
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.WineButtonDark
import com.example.ui.theme.WineButtonBorderDark
import com.example.ui.theme.appWineColor
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.isAppInDarkTheme
import com.example.util.TextToSpeechHelper

@Composable
fun LiturgyScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val userPrefs = remember { com.example.data.UserPreferences(context) }
  val fontSize = (userPrefs.getFontSize() * 16).toInt() // Assuming 1.0f base is 16sp
  var isAutoScrolling by remember { mutableStateOf(false) }
  var isTempleMode by remember { mutableStateOf(userPrefs.isTempleModeEnabled()) }

  val listState = rememberLazyListState()

  LaunchedEffect(isAutoScrolling) {
    if (isAutoScrolling) {
      try {
        while (isAutoScrolling) {
          val totalItems = listState.layoutInfo.totalItemsCount
          val nextIndex = listState.firstVisibleItemIndex + 1
          if (totalItems > 0 && nextIndex < totalItems) {
            listState.animateScrollToItem(nextIndex)
            delay(2000)
          } else {
            isAutoScrolling = false
            break
          }
        }
      } catch (_: Exception) {
        isAutoScrolling = false
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
  val tabs = listOf("El Evangelio de Hoy", "El Santo del Día", "Liturgia de las Horas", "El Ordinario")

  val todayLiturgy = remember { LiturgyRepository.getTodayLiturgy() }
  val todaySaintDay = remember { CatholicCalendarRepository.getTodayDay() }
  val liturgyHours = remember { LiturgyOfHoursRepository.hours }
  var selectedHourId by remember { mutableStateOf("laudes") }
  val currentHour = remember(selectedHourId) { liturgyHours.firstOrNull { it.id == selectedHourId } ?: liturgyHours.first() }
  val ordinaryParts = remember { LiturgyRepository.getOrdinaryOfTheMass() }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Controls: Temple Mode + Autoscroll
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .padding(vertical = 4.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = if (isTempleMode) Color(0xFF332005) else MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
          .clip(RoundedCornerShape(10.dp))
          .clickable {
            isTempleMode = !isTempleMode
            userPrefs.setTempleModeEnabled(isTempleMode)
          }
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = if (isTempleMode) "🕯️ Modo Templo ON" else "🕯️ Modo Templo",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = if (isTempleMode) Color(0xFFFFD54F) else MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }

      if (selectedTabIndex != 0) {
        IconButton(onClick = { isAutoScrolling = !isAutoScrolling }) {
          Icon(
            imageVector = if (isAutoScrolling) Icons.Default.Stop else Icons.Default.PlayArrow,
            contentDescription = "Autoscroll",
            tint = MaterialTheme.colorScheme.primary
          )
        }
      }
    }

    if (isTempleMode) {
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF1C1917),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.5f)),
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp)
          .padding(bottom = 6.dp)
      ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
          Text("🕯️", fontSize = 16.sp)
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "Modo Templo activo: pantalla atenuada. Por favor, silencia tu móvil en la Santa Misa.",
            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp, color = Color(0xFFFEF3C7))
          )
        }
      }
    }

    // Sub-Tabs
    TabRow(
      selectedTabIndex = selectedTabIndex,
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .clip(RoundedCornerShape(14.dp)),
      containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
      contentColor = appWineColor()
    ) {
      tabs.forEachIndexed { index, title ->
        Tab(
          selected = selectedTabIndex == index,
          onClick = {
            ttsHelper.stop()
            isSpeaking = false
            isAutoScrolling = false
            selectedTabIndex = index
          },
          text = {
            Text(
              text = title,
              style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                fontSize = 11.sp
              ),
              maxLines = 1
            )
          }
        )
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    when (selectedTabIndex) {
      0 -> {
        // TAB 0: EL EVANGELIO DE HOY Y SANTA MISA (LECTURAS LITÚRGICAS)
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
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = Color(todayLiturgy.liturgicalColor.hexColor)
                )
              }

              IconButton(
                onClick = {
                  if (isSpeaking) {
                    ttsHelper.stop()
                    isSpeaking = false
                  } else {
                    val fullSpeech = "${todayLiturgy.dayTitle}. ${todayLiturgy.celebrationName}. Antífona de entrada: ${todayLiturgy.entranceAntiphon}. Oración Colecta: ${todayLiturgy.collectPrayer}. Primera Lectura: ${todayLiturgy.firstReadingCitation}. ${todayLiturgy.firstReadingText}. Salmo: ${todayLiturgy.responsorialPsalmCitation}. ${todayLiturgy.responsorialPsalmResponse}. Evangelio: ${todayLiturgy.gospelCitation}. ${todayLiturgy.gospelText}. Oración después de la Comunión: ${todayLiturgy.prayerAfterCommunion}."
                    ttsHelper.speak(fullSpeech)
                    isSpeaking = true
                  }
                }
              ) {
                Icon(
                  imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                  contentDescription = "Escuchar lecturas completas",
                  tint = MaterialTheme.colorScheme.primary
                )
              }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = todayLiturgy.dayTitle,
              style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = todayLiturgy.celebrationName,
              style = MaterialTheme.typography.bodyMedium,
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
              fontSize = fontSize,
              italic = true
            )
          }

          // Oración Colecta del Día
          item {
            LiturgySectionCard(
              title = "Oración Colecta",
              citation = "Oración propia del día",
              content = todayLiturgy.collectPrayer,
              fontSize = fontSize,
              footer = "R/. Amén."
            )
          }

          // Primera Lectura
          item {
            LiturgySectionCard(
              title = "Primera Lectura",
              citation = todayLiturgy.firstReadingCitation,
              content = todayLiturgy.firstReadingText,
              fontSize = fontSize,
              footer = "Palabra de Dios. — R/. Te alabamos, Señor."
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
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )
                Text(
                  text = todayLiturgy.responsorialPsalmCitation,
                  style = MaterialTheme.typography.labelSmall,
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
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(10.dp)
                  )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = todayLiturgy.responsorialPsalmText,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    lineHeight = (fontSize * 1.5).sp,
                    fontSize = fontSize.sp
                  ),
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
                fontSize = fontSize,
                footer = "Palabra de Dios. — R/. Te alabamos, Señor."
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
              Column(modifier = Modifier.padding(14.dp)) {
                Text(
                  text = "Aleluya y Aclamación",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = GoldSecondary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = todayLiturgy.gospelAcclamation,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontStyle = FontStyle.Italic,
                    fontSize = fontSize.sp
                  ),
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
                  Text("✝", fontSize = 20.sp, color = appWineColor())
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = "Santo Evangelio",
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        fontSize = (fontSize + 2).sp
                      ),
                      color = appWineColor()
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
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )
              }
            }
          }

          // Oración Universal (Plegaria de los Fieles)
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text(
                  text = "Oración Universal (Plegaria de los Fieles)",
                  style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.primary
                )
                Text(
                  text = "Intenciones del día y súplica comunitaria",
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.height(10.dp))
                todayLiturgy.prayersOfTheFaithful.forEach { intention ->
                  Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 4.dp)
                  ) {
                    Text(
                      text = intention,
                      style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = fontSize.sp,
                        lineHeight = (fontSize * 1.4).sp
                      ),
                      color = MaterialTheme.colorScheme.onSurface,
                      modifier = Modifier.padding(10.dp)
                    )
                  }
                }
              }
            }
          }

          // Oración sobre las Ofrendas
          item {
            LiturgySectionCard(
              title = "Oración sobre las Ofrendas",
              citation = "Super Oblata",
              content = todayLiturgy.prayerOverOfferings,
              fontSize = fontSize,
              footer = "R/. Amén."
            )
          }

          // Antífona de Comunión
          item {
            LiturgySectionCard(
              title = "Antífona de Comunión",
              citation = null,
              content = todayLiturgy.communionAntiphon,
              fontSize = fontSize,
              italic = true
            )
          }

          // Oración después de la Comunión
          item {
            LiturgySectionCard(
              title = "Oración después de la Comunión",
              citation = "Postcommunio",
              content = todayLiturgy.prayerAfterCommunion,
              fontSize = fontSize,
              footer = "R/. Amén."
            )
          }

          // Comunión Espiritual (San Alfonso María de Ligorio)
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f))
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Text("🍞", fontSize = 18.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = "Comunión Espiritual",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = appWineColor()
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "«Creo, Jesús mío, que estás real y verdaderamente presente en el Santísimo Sacramento del Altar. Te amo sobre todas las cosas y deseo vivamente recibirte dentro de mi alma; pero no pudiendo hacerlo ahora sacramentalmente, ven al menos espiritualmente a mi corazón. Y como si ya te hubiese recibido, me abrazo y me uno del todo a Ti; no permitas, Señor, que jamás me separe de Ti. Amén.»",
                  style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic, lineHeight = 20.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
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
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                  )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = todayLiturgy.liturgicalReflection,
                  style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }

      1 -> {
        // TAB 1: EL SANTO DEL DÍA CON SU HISTORIA Y SANTORAL ANUAL
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
          // Saint of Today Hero Card
          item {
            ElevatedCard(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(20.dp),
              colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
            ) {
              Column(modifier = Modifier.padding(18.dp)) {
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
                        .background(Color(todaySaintDay.liturgicalColor.hexColor))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = "${todaySaintDay.rank.displayName.uppercase()} • ${todaySaintDay.liturgicalSeason}",
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                      color = Color(todaySaintDay.liturgicalColor.hexColor)
                    )
                  }

                  IconButton(
                    onClick = {
                      if (isSpeaking) {
                        ttsHelper.stop()
                        isSpeaking = false
                      } else {
                        val speech = "Santo del día: ${todaySaintDay.saintName}. ${todaySaintDay.title}. Patronazgo: ${todaySaintDay.saintPatronage}. Historia y biografía: ${todaySaintDay.saintBiography}. Oración de intercesión: ${todaySaintDay.dailyPrayer}."
                        ttsHelper.speak(speech) { isSpeaking = false }
                        isSpeaking = true
                      }
                    },
                    modifier = Modifier
                      .size(38.dp)
                      .clip(CircleShape)
                      .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
                  ) {
                    Icon(
                      imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                      contentDescription = "Escuchar historia del Santo del Día",
                      tint = appWineColor(),
                      modifier = Modifier.size(22.dp)
                    )
                  }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                  text = todaySaintDay.saintName,
                  style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = appWineColor()
                )

                Text(
                  text = todaySaintDay.title,
                  style = MaterialTheme.typography.titleSmall,
                  color = GoldSecondary
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Patronage Pill
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "🛡️ Patronazgo: ",
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                      color = appWineColor()
                    )
                    Text(
                      text = todaySaintDay.saintPatronage,
                      style = MaterialTheme.typography.bodySmall,
                      color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                  text = "Historia y Biografía:",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = todaySaintDay.saintBiography,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.5).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Oración de Intercesión
                Surface(
                  shape = RoundedCornerShape(12.dp),
                  color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                  modifier = Modifier.fillMaxWidth()
                ) {
                  Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                      text = "Oración de Intercesión",
                      style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                      color = appWineColor()
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = todaySaintDay.dailyPrayer,
                      style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                        fontSize = fontSize.sp,
                        lineHeight = (fontSize * 1.45).sp
                      ),
                      color = MaterialTheme.colorScheme.onSurface
                    )
                  }
                }
              }
            }
          }

          // Full Catholic Calendar Browser
          item {
            Text(
              text = "Santoral y Calendario Litúrgico Anual",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = appWineColor(),
              modifier = Modifier.padding(top = 8.dp)
            )
          }

          item {
            com.example.ui.components.CatholicCalendarView(
              snackbarHostState = snackbarHostState,
              ttsHelper = ttsHelper,
              isSpeaking = isSpeaking,
              onSpeakingChange = { isSpeaking = it },
              fontSize = fontSize,
              onNavigateToMassToday = { selectedTabIndex = 0 }
            )
          }

          item {
            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }

      2 -> {
        // TAB 2: LITURGIA DE LAS HORAS (OFICIO DIVINO)
        val isDark = isAppInDarkTheme()
        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          // Selector of Hours: Laudes, Vísperas, Completas, Oficio de Lectura
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Text(
                  text = "Selecciona la Hora Canónica:",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  liturgyHours.forEach { hour ->
                    val isHourSelected = hour.id == selectedHourId
                    Surface(
                      shape = RoundedCornerShape(10.dp),
                      color = if (isHourSelected) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.surface,
                      border = BorderStroke(
                        if (isHourSelected && isDark) 1.5.dp else 1.dp,
                        if (isHourSelected) (if (isDark) WineButtonBorderDark else WinePrimary) else MaterialTheme.colorScheme.outlineVariant
                      ),
                      modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 2.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {
                          ttsHelper.stop()
                          isSpeaking = false
                          selectedHourId = hour.id
                        }
                    ) {
                      Column(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                      ) {
                        Text(hour.icon, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                          text = hour.name,
                          style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = if (isHourSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 11.sp,
                            color = if (isHourSelected) Color.White else MaterialTheme.colorScheme.onSurface
                          ),
                          maxLines = 1
                        )
                      }
                    }
                  }
                }
              }
            }
          }

          // Active Hour Header Card with Audio TTS
          item {
            ElevatedCard(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(18.dp),
              colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Row(
                    modifier = Modifier.weight(1f, fill = false),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(currentHour.icon, fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                      Text(
                        text = "Liturgia de ${currentHour.name}",
                        style = MaterialTheme.typography.titleLarge.copy(
                          fontWeight = FontWeight.Bold,
                          fontFamily = FontFamily.Serif
                        ),
                        color = appWineColor()
                      )
                      Text(
                        text = currentHour.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                      )
                    }
                  }

                  IconButton(
                    onClick = {
                      if (isSpeaking) {
                        ttsHelper.stop()
                        isSpeaking = false
                      } else {
                        val fullSpeech = "Liturgia de las Horas: ${currentHour.name}. ${currentHour.subtitle}. ${currentHour.invocation}. Himno: ${currentHour.hymn}. Salmodia: ${currentHour.psalmodyCitation}. ${currentHour.psalmodyText}. Lectura Breve: ${currentHour.shortReadingCitation}. ${currentHour.shortReadingText}. Cántico evangélico: ${currentHour.gospelCanticleTitle}. ${currentHour.gospelCanticleText}. Oración conclusiva: ${currentHour.concludingPrayer}."
                        ttsHelper.speak(fullSpeech) { isSpeaking = false }
                        isSpeaking = true
                      }
                    },
                    modifier = Modifier
                      .size(38.dp)
                      .clip(CircleShape)
                      .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
                  ) {
                    Icon(
                      imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                      contentDescription = "Escuchar Hora Litúrgica",
                      tint = appWineColor(),
                      modifier = Modifier.size(22.dp)
                    )
                  }
                }
              }
            }
          }

          // Invocación Inicial
          item {
            LiturgySectionCard(
              title = "Invocación Inicial",
              citation = "Apertura del Oficio",
              content = currentHour.invocation,
              fontSize = fontSize
            )
          }

          // Himno
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text(
                  text = "Himno Litúrgico",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = currentHour.hymn,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.5).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
          }

          // Salmodia
          item {
            LiturgySectionCard(
              title = "Salmodia",
              citation = currentHour.psalmodyCitation,
              content = currentHour.psalmodyText,
              fontSize = fontSize,
              footer = "Gloria al Padre, y al Hijo, y al Espíritu Santo. Amén."
            )
          }

          // Lectura Breve
          item {
            LiturgySectionCard(
              title = "Lectura Breve",
              citation = currentHour.shortReadingCitation,
              content = currentHour.shortReadingText,
              fontSize = fontSize,
              footer = "Palabra de Dios. — R/. Te alabamos, Señor."
            )
          }

          // Cántico Evangélico
          item {
            ElevatedCard(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
              elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text(
                  text = currentHour.gospelCanticleTitle,
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = GoldSecondary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = currentHour.gospelCanticleText,
                  style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.5).sp
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }
          }

          // Preces e Intercesiones
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(16.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
              Column(modifier = Modifier.padding(16.dp)) {
                Text(
                  text = "Preces y Súplicas",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = appWineColor()
                )
                Spacer(modifier = Modifier.height(8.dp))
                currentHour.intercessions.forEach { intercession ->
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.25f),
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(vertical = 4.dp)
                  ) {
                    Text(
                      text = intercession,
                      style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = fontSize.sp,
                        lineHeight = (fontSize * 1.4).sp
                      ),
                      color = MaterialTheme.colorScheme.onSurface,
                      modifier = Modifier.padding(10.dp)
                    )
                  }
                }
              }
            }
          }

          // Oración Conclusiva
          item {
            LiturgySectionCard(
              title = "Oración Conclusiva",
              citation = "Oremos",
              content = currentHour.concludingPrayer,
              fontSize = fontSize,
              footer = "R/. Amén."
            )
          }

          item {
            Spacer(modifier = Modifier.height(24.dp))
          }
        }
      }

      3 -> {
        // TAB 3: EL ORDINARIO DE LA MISA (MISALITO COMPLETO PARA LAICOS)
        var showLatin by remember { mutableStateOf(false) }
        val isDark = isAppInDarkTheme()

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
                    color = appWineColor()
                  )
                  Text(
                    text = "Estructura, diálogos y respuestas de los fieles",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }

                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = if (showLatin) (if (isDark) WineButtonDark else WinePrimary) else MaterialTheme.colorScheme.surfaceVariant,
                  border = if (showLatin && isDark) BorderStroke(1.dp, WineButtonBorderDark) else null,
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

          itemsIndexed(ordinaryParts, key = { index, part -> "lit_${index}_${part.id}" }) { _, part ->
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
  fontSize: Int = 16,
  italic: Boolean = false,
  footer: String? = null
) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.primary
      )
      if (citation != null) {
        Text(
          text = citation,
          style = MaterialTheme.typography.labelSmall.copy(fontSize = (fontSize - 2).coerceAtLeast(12).sp),
          color = MaterialTheme.colorScheme.outline
        )
      }
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = content,
        style = MaterialTheme.typography.bodyLarge.copy(
          fontFamily = FontFamily.Serif,
          fontStyle = if (italic) FontStyle.Italic else FontStyle.Normal,
          lineHeight = (fontSize * 1.5).sp,
          fontSize = fontSize.sp
        ),
        color = MaterialTheme.colorScheme.onSurface
      )
      if (footer != null) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = footer,
          style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = fontSize.sp
          ),
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
  fontSize: Int = 16
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
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = part.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          if (showLatin && part.latinTitle != null) {
            Text(
              text = part.latinTitle,
              style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic),
              color = GoldSecondary
            )
          }
        }

        IconButton(onClick = { expandedExplanation = !expandedExplanation }) {
          Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Explicación",
            tint = if (expandedExplanation) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
          )
        }
      }

      Spacer(modifier = Modifier.height(6.dp))

      // Rubric
      Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = "Rúbrica: ${part.rubric}",
          style = MaterialTheme.typography.labelSmall.copy(
            fontStyle = FontStyle.Italic,
            fontSize = (fontSize - 2).coerceAtLeast(11).sp
          ),
          color = MaterialTheme.colorScheme.onSecondaryContainer,
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
      }

      Spacer(modifier = Modifier.height(10.dp))

      // Sacerdote
      Text(
        text = "Sacerdote:",
        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.primary
      )
      Text(
        text = part.priestDialogue,
        style = MaterialTheme.typography.bodyLarge.copy(fontSize = fontSize.sp, lineHeight = (fontSize * 1.4).sp),
        color = MaterialTheme.colorScheme.onSurface
      )

      Spacer(modifier = Modifier.height(8.dp))

      // Pueblo
      Text(
        text = "Pueblo (Fieles):",
        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
        color = GoldSecondary
      )
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
        modifier = Modifier.fillMaxWidth()
      ) {
        Text(
          text = if (showLatin && part.latinPeopleResponse != null) part.latinPeopleResponse else part.peopleResponse,
          style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = (fontSize + 1).sp,
            lineHeight = (fontSize * 1.45).sp
          ),
          color = MaterialTheme.colorScheme.onPrimaryContainer,
          modifier = Modifier.padding(10.dp)
        )
      }

      // Pedagogical Explanation
      AnimatedVisibility(visible = expandedExplanation) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
          Text(
            text = "Sentido litúrgico y espiritual:",
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = part.explanation,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }
  }
}
