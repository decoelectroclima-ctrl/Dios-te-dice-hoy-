package com.example.ui.screens

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterDrama
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import com.example.model.VerseCategory
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.MarianTertiary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FreeWillScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isSpeaking by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  // State for revealed verse
  var revealedVerse by remember {
    mutableStateOf<BibleVerse?>(
      prefs.getLastFreeWillVerseId()?.let { VerseRepository.getVerseById(it) }
    )
  }

  var selectedDoorIndex by remember { mutableStateOf<Int?>(null) }
  var doorsSeed by remember { mutableStateOf(System.currentTimeMillis()) }

  // 3 Mystery Virtues for the doors
  val doorVirtues = remember(doorsSeed) {
    val pool = listOf("Paz", "Fortaleza", "Esperanza", "Protección", "Amor", "Sabiduría", "Confianza", "Consuelo")
    pool.shuffled().take(3)
  }

  fun onSelectDoor(index: Int) {
    ttsHelper.stop()
    isSpeaking = false
    selectedDoorIndex = index
    val virtue = doorVirtues[index]
    val verse = VerseRepository.getVerseByVirtue(virtue)
    revealedVerse = verse
    prefs.setLastFreeWillVerseId(verse.id)
    scope.launch {
      snackbarHostState.showSnackbar("¡Has elegido la Puerta ${index + 1}! Virtud revelada: $virtue")
    }
  }

  fun onChooseCategory(cat: VerseCategory) {
    ttsHelper.stop()
    isSpeaking = false
    selectedDoorIndex = null
    val verse = VerseRepository.getVerseByCategory(cat)
    revealedVerse = verse
    prefs.setLastFreeWillVerseId(verse.id)
    scope.launch {
      snackbarHostState.showSnackbar("Palabra recibida para: ${cat.displayName}")
    }
  }

  fun onDrawCompletelyRandom() {
    ttsHelper.stop()
    isSpeaking = false
    selectedDoorIndex = null
    val verse = VerseRepository.getRandomVerse(excludeId = revealedVerse?.id)
    revealedVerse = verse
    prefs.setLastFreeWillVerseId(verse.id)
    scope.launch {
      snackbarHostState.showSnackbar("Inspiración divina al azar recibida: ${verse.citation}")
    }
  }

  fun reshuffleDoors() {
    ttsHelper.stop()
    isSpeaking = false
    selectedDoorIndex = null
    doorsSeed = System.currentTimeMillis()
    scope.launch {
      snackbarHostState.showSnackbar("Puertas barajadas nuevamente")
    }
  }

  fun shareRevealedVerse(verse: BibleVerse) {
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(
        Intent.EXTRA_TEXT,
        "✨ Dios te dice hoy (Elegido con Libre Albedrío):\n«${verse.godSaysToday}»\n\n📖 ${verse.text}\n— ${verse.citation}\n\nApp Dios Te Dice Hoy"
      )
      type = "text/plain"
    }
    context.startActivity(Intent.createChooser(sendIntent, "Compartir palabra elegida"))
  }

  fun speakVerse(verse: BibleVerse) {
    if (isSpeaking) {
      ttsHelper.stop()
      isSpeaking = false
    } else {
      val text = "Dios te dice hoy: ${verse.godSaysToday}. ${verse.text}. ${verse.citation}"
      ttsHelper.speak(text)
      isSpeaking = true
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
      // Theological presentation
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(GoldSecondary.copy(alpha = 0.2f)),
              contentAlignment = Alignment.Center
            ) {
              Text("🕊️", fontSize = 22.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
              Text(
                text = "Tu Sagrado Libre Albedrío",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = MaterialTheme.colorScheme.onSurface
              )
              Text(
                text = "«Escoge, pues, la vida» — Dt 30:19",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                fontStyle = FontStyle.Italic
              )
            }
          }
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "Dios no impone su gracia a la fuerza; respeta infinitamente tu libertad. Aquí puedes escoger con tu libre albedrío la palabra que tu alma necesita en este instante.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 20.sp
          )
        }
      }
    }

    // SECTION 1: LAS TRES PUERTAS CELESTIALES
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Las 3 Puertas Celestiales",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )

            IconButton(
              onClick = { reshuffleDoors() },
              modifier = Modifier.testTag("reshuffle_doors_button")
            ) {
              Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Barajar puertas",
                tint = GoldSecondary
              )
            }
          }

          Text(
            text = "Toca una de las tres puertas con fe para descubrir la palabra reservada para ti:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.fillMaxWidth()
          )

          Spacer(modifier = Modifier.height(16.dp))

          // 3 Doors Row
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            doorVirtues.forEachIndexed { index, virtue ->
              val isSelected = selectedDoorIndex == index
              OutlinedCard(
                modifier = Modifier
                  .weight(1f)
                  .testTag("door_card_${index + 1}")
                  .clickable { onSelectDoor(index) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.outlinedCardColors(
                  containerColor = if (isSelected) WinePrimary.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                border = CardDefaults.outlinedCardBorder().copy(
                  brush = if (isSelected) {
                    Brush.verticalGradient(listOf(GoldSecondary, WinePrimary))
                  } else {
                    Brush.verticalGradient(listOf(Color.LightGray.copy(alpha = 0.4f), Color.Gray.copy(alpha = 0.4f)))
                  }
                )
              ) {
                Column(
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 6.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
                ) {
                  Text(
                    text = if (isSelected) "✨" else "🚪",
                    fontSize = 28.sp
                  )
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = "Puerta ${index + 1}",
                    style = MaterialTheme.typography.labelMedium.copy(
                      fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                  )
                  Spacer(modifier = Modifier.height(2.dp))
                  Text(
                    text = if (isSelected) virtue else "Misterio",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (isSelected) WinePrimary else MaterialTheme.colorScheme.outline
                  )
                }
              }
            }
          }
        }
      }
    }

    // REVEALED VERSE DISPLAY
    item {
      AnimatedVisibility(
        visible = revealedVerse != null,
        enter = fadeIn(tween(400)) + expandVertically(),
        exit = fadeOut() + shrinkVertically()
      ) {
        revealedVerse?.let { verse ->
          ElevatedCard(
            modifier = Modifier
              .fillMaxWidth()
              .widthIn(max = 600.dp)
              .testTag("revealed_verse_card"),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.elevatedCardColors(
              containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Box(
                modifier = Modifier
                  .clip(RoundedCornerShape(50.dp))
                  .background(
                    Brush.horizontalGradient(
                      listOf(GoldSecondary, WinePrimary)
                    )
                  )
                  .padding(horizontal = 16.dp, vertical = 6.dp)
              ) {
                Text(
                  text = "✨ Tu Elección Personal ✨",
                  color = Color.White,
                  style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                )
              }

              Spacer(modifier = Modifier.height(14.dp))

              Box(
                modifier = Modifier
                  .fillMaxWidth()
                  .clip(RoundedCornerShape(16.dp))
                  .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f))
                  .padding(14.dp)
              ) {
                Text(
                  text = "«${verse.godSaysToday}»",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold
                  ),
                  color = MaterialTheme.colorScheme.onPrimaryContainer,
                  textAlign = TextAlign.Center,
                  modifier = Modifier.fillMaxWidth()
                )
              }

              Spacer(modifier = Modifier.height(14.dp))

              Text(
                text = verse.text,
                style = MaterialTheme.typography.bodyLarge.copy(
                  fontFamily = FontFamily.Serif,
                  fontStyle = FontStyle.Italic,
                  lineHeight = 24.sp
                ),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 6.dp)
              )

              Spacer(modifier = Modifier.height(8.dp))

              Text(
                text = "— ${verse.citation}",
                style = MaterialTheme.typography.titleSmall.copy(
                  fontWeight = FontWeight.Bold,
                  color = MaterialTheme.colorScheme.primary
                )
              )

              Spacer(modifier = Modifier.height(16.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
              ) {
                FilledTonalButton(
                  onClick = { speakVerse(verse) },
                  colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = if (isSpeaking) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                  )
                ) {
                  Icon(
                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                    contentDescription = null,
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
                    val status = prefs.toggleFavoriteVerse(verse.id)
                    scope.launch {
                      val m = if (status) "¡Añadido a tus favoritos!" else "Quitado de favoritos"
                      snackbarHostState.showSnackbar(m)
                    }
                  }
                ) {
                  val isFav = prefs.isVerseFavorite(verse.id)
                  Icon(
                    imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = if (isFav) WinePrimary else MaterialTheme.colorScheme.outline
                  )
                }

                IconButton(
                  onClick = { shareRevealedVerse(verse) }
                ) {
                  Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Compartir",
                    tint = MaterialTheme.colorScheme.primary
                  )
                }
              }
            }
          }
        }
      }
    }

    // SECTION 2: ESCOGE SEGÚN LO QUE TU ALMA NECESITA
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
        ) {
          Text(
            text = "¿Qué anhela tu corazón hoy?",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          Text(
            text = "Elige libremente el auxilio espiritual que buscas:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(14.dp))

          val options = listOf(
            VerseCategory.PAZ to "🕊️ Paz en la tormenta",
            VerseCategory.FORTALEZA to "🛡️ Fortaleza en la prueba",
            VerseCategory.ESPERANZA to "🌅 Esperanza renovada",
            VerseCategory.AMOR to "💖 Amor incondicional",
            VerseCategory.PROTECCION to "🌿 Protección de Dios",
            VerseCategory.FE to "✨ Fe y Confianza",
            VerseCategory.SANACION to "💧 Sanación interior",
            VerseCategory.SABIDURIA to "🕯️ Sabiduría y Guía",
            VerseCategory.CONSUELO to "🫂 Alivio y Descanso",
            VerseCategory.GRATITUD to "☀️ Acción de Gracias"
          )

          FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            options.forEach { (category, label) ->
              Surface(
                modifier = Modifier
                  .clip(RoundedCornerShape(12.dp))
                  .clickable { onChooseCategory(category) }
                  .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(12.dp)
                  ),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
              ) {
                Text(
                  text = label,
                  style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                  ),
                  color = MaterialTheme.colorScheme.onSurface,
                  modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
              }
            }
          }
        }
      }
    }

    // SECTION 3: SORTEO DIVINO AL AZAR
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surface
        )
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "Sorteo Divino 100% al Azar",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "Deja que el Espíritu Santo hable libremente a través de las Sagradas Escrituras.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
          )

          Spacer(modifier = Modifier.height(14.dp))

          Button(
            onClick = { onDrawCompletelyRandom() },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("random_draw_large_button"),
            colors = ButtonDefaults.buttonColors(
              containerColor = WinePrimary
            ),
            shape = RoundedCornerShape(14.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Casino,
              contentDescription = null,
              tint = Color.White
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "Pedir Palabra al Azar",
              style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Bold,
                color = Color.White
              )
            )
          }
        }
      }
      Spacer(modifier = Modifier.height(20.dp))
    }
  }
}
