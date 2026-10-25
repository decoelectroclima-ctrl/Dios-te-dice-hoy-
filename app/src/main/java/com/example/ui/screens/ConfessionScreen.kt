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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.model.ConfessionItem
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

@Composable
fun ConfessionScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var isPlayingPrayer by remember { mutableStateOf(false) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  var confessionItems by remember { mutableStateOf(prefs.getConfessionItems()) }
  var showAddDialog by remember { mutableStateOf(false) }
  var showExamGuide by remember { mutableStateOf(false) }
  var showActoContricion by remember { mutableStateOf(false) }

  var newSinText by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("Pensamiento") }
  val categories = listOf("Pensamiento", "Palabra", "Obra", "Omisión")

  val cardenalVerdierText = remember {
    """¡Oh Espíritu Santo, Amor del Padre y del Hijo!
Inspírame siempre lo que debo pensar,
lo que debo decir, cómo debo decirlo,
lo que debo callar, lo que debo escribir,
cómo debo actuar, lo que debo hacer,
para procurar vuestra gloria,
el bien de las almas y mi propia santificación.
¡Oh Jesús, toda mi confianza está en Ti!
¡Oh María, Templo del Espíritu Santo, ruega por nosotros! Amén."""
  }

  fun togglePrayerAudio() {
    if (isPlayingPrayer) {
      ttsHelper.stop()
      isPlayingPrayer = false
    } else {
      ttsHelper.speak("Oración al Espíritu Santo del Cardenal Verdier. $cardenalVerdierText")
      isPlayingPrayer = true
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
      Spacer(modifier = Modifier.height(4.dp))
      // HEADER: ILUMINACIÓN DEL ESPÍRITU SANTO (CARDENAL VERDIER)
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(
          1.5.dp,
          Brush.horizontalGradient(listOf(GoldSecondary, WinePrimary))
        )
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(
                  Brush.radialGradient(listOf(GoldSecondary.copy(alpha = 0.5f), WinePrimary.copy(alpha = 0.2f)))
                ),
              contentAlignment = Alignment.Center
            ) {
              Text("🔥", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "Luz del Espíritu Santo para tu Examen",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = WinePrimary
              )
              Text(
                text = "Oración del Cardenal Verdier",
                style = MaterialTheme.typography.labelSmall,
                fontStyle = FontStyle.Italic,
                color = GoldSecondary
              )
            }

            IconButton(onClick = { togglePrayerAudio() }) {
              Icon(
                imageVector = if (isPlayingPrayer) Icons.Default.Stop else Icons.Default.PlayArrow,
                contentDescription = "Escuchar oración del Cardenal Verdier",
                tint = if (isPlayingPrayer) WinePrimary else MaterialTheme.colorScheme.primary
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = "«¡Oh Espíritu Santo, Amor del Padre y del Hijo! Inspírame siempre lo que debo pensar, lo que debo decir, cómo debo decirlo, lo que debo callar...»",
            style = MaterialTheme.typography.bodySmall.copy(
              fontFamily = FontFamily.Serif,
              fontStyle = FontStyle.Italic,
              lineHeight = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "Pide al Espíritu Santo que ilumine tu memoria con amor y misericordia para reconocer tus faltas sin miedo.",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.outline
          )
        }
      }
    }

    // BOTONES DE ACCIÓN: AÑADIR PECADO + GUÍA DE EXAMEN
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Button(
          onClick = { showAddDialog = true },
          modifier = Modifier
            .weight(1f)
            .testTag("add_sin_button"),
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
          shape = RoundedCornerShape(14.dp)
        ) {
          Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("Anotar Falta")
        }

        OutlinedButton(
          onClick = { showExamGuide = !showExamGuide },
          modifier = Modifier.weight(1f),
          shape = RoundedCornerShape(14.dp)
        ) {
          Icon(imageVector = Icons.Default.HelpOutline, contentDescription = null, modifier = Modifier.size(18.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text(if (showExamGuide) "Ocultar Guía" else "Guía Examen")
        }
      }
    }

    // GUÍA RÁPIDA DE EXAMEN DE CONCIENCIA (DESPLEGABLE)
    if (showExamGuide) {
      item {
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
          )
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Puntos para el Examen de Conciencia:",
              style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))

            val guidePoints = listOf(
              "Con Dios: ¿He descuidado la oración, los sacramentos o dudado de su misericordia?",
              "Con el prójimo: ¿He guardado rencor, hablado mal de otros, mentido o perdido la paciencia?",
              "Familia y trabajo: ¿He sido egoísta, perezoso o descuidado mis deberes hacia los míos?",
              "Pureza y verdad: ¿He consentido pensamientos deshonestos, vanidad o apego al dinero?",
              "Omisiones: ¿Pude haber hecho el bien a alguien necesitado y fui indiferente?"
            )

            guidePoints.forEach { point ->
              Text(
                text = "• $point",
                style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(vertical = 3.dp)
              )
            }
          }
        }
      }
    }

    // TITULO Y BOTÓN DE ABSOLUCIÓN
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "Mis Faltas para Confesión",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          Text(
            text = "${confessionItems.size} anotadas (${confessionItems.count { it.isConfessed }} confesadas)",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }

        if (confessionItems.any { it.isConfessed }) {
          Button(
            onClick = {
              prefs.clearAbsolvedConfessions()
              confessionItems = prefs.getConfessionItems()
              scope.launch {
                snackbarHostState.showSnackbar("¡Tus faltas han sido borradas en la Sangre de Cristo! 🕊️")
              }
            },
            colors = ButtonDefaults.buttonColors(containerColor = GoldSecondary),
            shape = RoundedCornerShape(12.dp)
          ) {
            Icon(imageVector = Icons.Default.CleaningServices, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text("Limpiar Confesados")
          }
        }
      }
    }

    // LISTA DE PECADOS / FALTAS
    if (confessionItems.isEmpty()) {
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("🕊️", fontSize = 42.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "Tu lista de confesión está vacía",
              style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Usa el botón «Anotar Falta» para registrar lo que desees llevar ante el sacerdote.",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }
    } else {
      items(confessionItems, key = { it.id }) { item ->
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp)
            .clickable {
              prefs.toggleConfessionItem(item.id)
              confessionItems = prefs.getConfessionItems()
            },
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(
            containerColor = if (item.isConfessed) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surface
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = if (item.isConfessed) 0.dp else 2.dp)
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              imageVector = if (item.isConfessed) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
              contentDescription = if (item.isConfessed) "Confesado" else "Pendiente",
              tint = if (item.isConfessed) GoldSecondary else MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = item.text,
                style = MaterialTheme.typography.bodyMedium.copy(
                  textDecoration = if (item.isConfessed) TextDecoration.LineThrough else TextDecoration.None
                ),
                color = if (item.isConfessed) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.onSurface
              )
              Spacer(modifier = Modifier.height(4.dp))
              Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(
                  shape = RoundedCornerShape(6.dp),
                  color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                  Text(
                    text = item.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                  )
                }
                Text(
                  text = item.dateAdded,
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.outline
                )
              }
            }

            IconButton(
              onClick = {
                prefs.removeConfessionItem(item.id)
                confessionItems = prefs.getConfessionItems()
              }
            ) {
              Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                tint = MaterialTheme.colorScheme.outline,
                modifier = Modifier.size(20.dp)
              )
            }
          }
        }
      }
    }

    // ORACIÓN DEL ACTO DE CONTRICIÓN DIRECTA
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "Acto de Contrición",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = WinePrimary
            )
            IconButton(
              onClick = {
                ttsHelper.speak("""Señor mío Jesucristo, Dios y Hombre verdadero, Creador, Padre y Redentor mío; por ser Vos quien sois, Bondad infinita, y porque os amo sobre todas las cosas, me pesa de todo corazón haberos ofendido. Me propongo firmemente nunca más pecar, confesarme y cumplir la penitencia que me fuere impuesta. Amén.""")
              }
            ) {
              Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Escuchar", tint = WinePrimary)
            }
          }
          Text(
            text = """«Señor mío Jesucristo, Dios y Hombre verdadero, Creador, Padre y Redentor mío; por ser Vos quien sois, Bondad infinita, y porque os amo sobre todas las cosas, me pesa de todo corazón haberos ofendido. Propongo firmemente nunca más pecar, confesarme y cumplir la penitencia. Amén.»""",
            style = MaterialTheme.typography.bodySmall.copy(
              fontFamily = FontFamily.Serif,
              fontStyle = FontStyle.Italic,
              lineHeight = 22.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
      Spacer(modifier = Modifier.height(24.dp))
    }
  }

  // DIALOG TO ADD A NEW SIN/FAULT
  if (showAddDialog) {
    val dateNow = remember {
      SimpleDateFormat("d MMM", Locale("es", "ES")).format(Date())
    }

    AlertDialog(
      onDismissRequest = {
        showAddDialog = false
        newSinText = ""
      },
      title = {
        Text("Anotar para la Confesión")
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = "Escribe con sinceridad la falta o debilidad que deseas confesar:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
          Spacer(modifier = Modifier.height(10.dp))

          OutlinedTextField(
            value = newSinText,
            onValueChange = { newSinText = it },
            placeholder = { Text("Ej. Falté a la paciencia en casa, juicio temerario...") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3,
            shape = RoundedCornerShape(12.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Tipo de falta:",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
          )

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            categories.forEach { cat ->
              FilterChip(
                selected = selectedCategory == cat,
                onClick = { selectedCategory = cat },
                label = { Text(cat, fontSize = 11.sp) }
              )
            }
          }
        }
      },
      confirmButton = {
        Button(
          onClick = {
            if (newSinText.isNotBlank()) {
              val item = ConfessionItem(
                id = UUID.randomUUID().toString(),
                text = newSinText.trim(),
                category = selectedCategory,
                isConfessed = false,
                dateAdded = dateNow
              )
              prefs.addConfessionItem(item)
              confessionItems = prefs.getConfessionItems()
              newSinText = ""
              showAddDialog = false
              scope.launch {
                snackbarHostState.showSnackbar("Anotado en tu diario de confesión")
              }
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = WinePrimary)
        ) {
          Text("Guardar")
        }
      },
      dismissButton = {
        TextButton(
          onClick = {
            showAddDialog = false
            newSinText = ""
          }
        ) {
          Text("Cancelar")
        }
      }
    )
  }
}
