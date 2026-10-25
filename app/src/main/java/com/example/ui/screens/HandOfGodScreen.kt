package com.example.ui.screens

import android.app.TimePickerDialog
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.VolunteerActivism
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.model.HandOfGodEntry
import com.example.notification.NotificationHelper
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

@Composable
fun HandOfGodScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  var entries by remember { mutableStateOf(prefs.getHandOfGodEntries()) }
  var showAddDialog by remember { mutableStateOf(false) }

  var entryText by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("Providencia") }
  val categories = listOf("Providencia", "Paz en la prueba", "Protección", "Gesto de Amor", "Luz y Sabiduría")

  // Night notification preferences
  var nightNotifEnabled by remember { mutableStateOf(prefs.isNightNotificationEnabled()) }
  var nightHour by remember { mutableIntStateOf(prefs.getNightNotificationHour()) }
  var nightMinute by remember { mutableIntStateOf(prefs.getNightNotificationMinute()) }

  val formattedNightTime = String.format(Locale.getDefault(), "%02d:%02d", nightHour, nightMinute)

  fun showNightTimePicker() {
    val picker = TimePickerDialog(
      context,
      { _, hour, minute ->
        nightHour = hour
        nightMinute = minute
        prefs.setNightNotificationTime(hour, minute)
        if (nightNotifEnabled) {
          NotificationHelper.scheduleNightAlarm(context)
        }
        scope.launch {
          snackbarHostState.showSnackbar("Hora nocturna fijada a las ${String.format(Locale.getDefault(), "%02d:%02d", hour, minute)} hrs")
        }
      },
      nightHour,
      nightMinute,
      true
    )
    picker.show()
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
      // HEADER BANNER
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(
          1.dp,
          Brush.horizontalGradient(listOf(GoldSecondary, WinePrimary))
        )
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(46.dp)
              .clip(CircleShape)
              .background(
                Brush.radialGradient(listOf(GoldSecondary.copy(alpha = 0.5f), WinePrimary.copy(alpha = 0.2f)))
              ),
            contentAlignment = Alignment.Center
          ) {
            Text("🤲", fontSize = 24.sp)
          }

          Spacer(modifier = Modifier.width(14.dp))

          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = "La Mano de Dios en mi Día",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = WinePrimary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "Un diario de gratitud para reconocer las huellas de su amor, auxilio y providencia en tu jornada.",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }
    }

    // BOTÓN AÑADIR EXPERIENCIA
    item {
      Button(
        onClick = { showAddDialog = true },
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp)
          .testTag("add_hand_of_god_button"),
        colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
        shape = RoundedCornerShape(14.dp)
      ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("¿Dónde notaste hoy la mano de Dios? (Escribir)")
      }
    }

    // CARD DE CONFIGURACIÓN DEL RECORDATORIO NOCTURNO
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
        )
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.weight(1f)
            ) {
              Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(22.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Recordatorio Nocturno",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = if (nightNotifEnabled) "Te avisa a las $formattedNightTime hrs para llenar este apartado" else "Desactivado",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }

            Switch(
              checked = nightNotifEnabled,
              onCheckedChange = { checked ->
                nightNotifEnabled = checked
                prefs.setNightNotificationEnabled(checked)
                if (checked) {
                  NotificationHelper.scheduleNightAlarm(context)
                  scope.launch {
                    snackbarHostState.showSnackbar("Recordatorio nocturno fijado para las $formattedNightTime hrs")
                  }
                } else {
                  NotificationHelper.cancelNightAlarm(context)
                  scope.launch {
                    snackbarHostState.showSnackbar("Recordatorio nocturno desactivado")
                  }
                }
              },
              colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = WinePrimary
              )
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = MaterialTheme.colorScheme.surface,
              modifier = Modifier
                .weight(1f)
                .clickable { showNightTimePicker() }
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(imageVector = Icons.Default.AccessTime, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Cambiar hora: $formattedNightTime", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
              }
            }

            Button(
              onClick = {
                NotificationHelper.sendTestNightNotification(context)
                scope.launch {
                  snackbarHostState.showSnackbar("🔔 ¡Notificación nocturna de prueba enviada!")
                }
              },
              colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
              shape = RoundedCornerShape(10.dp)
            ) {
              Text("Probar", fontSize = 12.sp)
            }
          }
        }
      }
    }

    // LISTA DE ENTRADAS DEL DIARIO
    item {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "Mis Registros de la Mano de Dios",
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
          ),
          color = MaterialTheme.colorScheme.onSurface
        )
        Text(
          text = "${entries.size} testimonios",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }

    if (entries.isEmpty()) {
      item {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("✨", fontSize = 38.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = "Aún no has registrado momentos de hoy",
              style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Piensa en un detalle donde sentiste su paz, providencia o consuelo.",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
      }
    } else {
      items(entries, key = { it.id }) { item ->
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(16.dp),
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
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f)
                ) {
                  Text(
                    text = item.category,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = item.date,
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.outline
                )
              }

              IconButton(
                onClick = {
                  prefs.removeHandOfGodEntry(item.id)
                  entries = prefs.getHandOfGodEntries()
                }
              ) {
                Icon(
                  imageVector = Icons.Default.Delete,
                  contentDescription = "Eliminar",
                  tint = MaterialTheme.colorScheme.outline,
                  modifier = Modifier.size(18.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
              text = item.text,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = FontFamily.Serif,
                lineHeight = 22.sp
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }
        }
      }
    }

    item { Spacer(modifier = Modifier.height(24.dp)) }
  }

  // DIALOG TO ADD ENTRY
  if (showAddDialog) {
    val dateNow = remember {
      SimpleDateFormat("d 'de' MMMM, yyyy", Locale("es", "ES")).format(Date())
    }

    AlertDialog(
      onDismissRequest = {
        showAddDialog = false
        entryText = ""
      },
      title = {
        Text("La Mano de Dios en mi Día")
      },
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = "¿Dónde sentiste hoy la presencia, ayuda o amor de Dios?",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
          Spacer(modifier = Modifier.height(10.dp))

          OutlinedTextField(
            value = entryText,
            onValueChange = { entryText = it },
            placeholder = { Text("Ej. En un momento de mucha ansiedad sentí una paz repentina; en cómo una persona me ayudó sin pedirlo...") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 4,
            shape = RoundedCornerShape(12.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Categoría:",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
          )

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            categories.take(3).forEach { cat ->
              FilterChip(
                selected = selectedCategory == cat,
                onClick = { selectedCategory = cat },
                label = { Text(cat, fontSize = 11.sp) }
              )
            }
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            categories.drop(3).forEach { cat ->
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
            if (entryText.isNotBlank()) {
              val entry = HandOfGodEntry(
                id = UUID.randomUUID().toString(),
                date = dateNow,
                text = entryText.trim(),
                category = selectedCategory
              )
              prefs.addHandOfGodEntry(entry)
              entries = prefs.getHandOfGodEntries()
              entryText = ""
              showAddDialog = false
              scope.launch {
                snackbarHostState.showSnackbar("¡Testimonio guardado en tu diario de providencia! 🤲")
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
            entryText = ""
          }
        ) {
          Text("Cancelar")
        }
      }
    )
  }
}
