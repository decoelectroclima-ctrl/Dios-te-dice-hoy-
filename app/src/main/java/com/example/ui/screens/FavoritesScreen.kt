package com.example.ui.screens

import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PrayerRepository
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.DisposableEffect
import com.example.util.TextToSpeechHelper
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.notification.NotificationHelper
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun FavoritesScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  val ttsHelper = remember { TextToSpeechHelper(context) }
  var playingPrayerId by remember { mutableStateOf<String?>(null) }

  DisposableEffect(Unit) {
    onDispose {
      ttsHelper.shutdown()
    }
  }

  var selectedTabIndex by remember { mutableIntStateOf(0) }
  val tabs = listOf("Versículos", "Oraciones", "Mis Peticiones", "Notificaciones")

  // Data states
  var favVersesIds by remember { mutableStateOf(prefs.getFavoriteVerses()) }
  var favPrayersIds by remember { mutableStateOf(prefs.getFavoritePrayers()) }
  var petitions by remember { mutableStateOf(prefs.getPetitions()) }

  // Notification states
  var notifEnabled by remember { mutableStateOf(prefs.isNotificationEnabled()) }
  var notifHour by remember { mutableIntStateOf(prefs.getNotificationHour()) }
  var notifMinute by remember { mutableIntStateOf(prefs.getNotificationMinute()) }

  // Dialog state for adding prayer petition
  var showAddPetitionDialog by remember { mutableStateOf(false) }
  var newPetitionText by remember { mutableStateOf("") }

  fun showTimePicker() {
    val picker = TimePickerDialog(
      context,
      { _, hour, minute ->
        notifHour = hour
        notifMinute = minute
        prefs.setNotificationTime(hour, minute)
        if (notifEnabled) {
          NotificationHelper.scheduleDailyAlarm(context)
        }
        scope.launch {
          snackbarHostState.showSnackbar(
            "Hora actualizada a las ${String.format(Locale.getDefault(), "%02d:%02d", hour, minute)} hrs"
          )
        }
      },
      notifHour,
      notifMinute,
      true
    )
    picker.show()
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(6.dp))

    // Tab Navigation
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
          onClick = { selectedTabIndex = index },
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

    Spacer(modifier = Modifier.height(14.dp))

    when (selectedTabIndex) {
      0 -> {
        // TAB 1: FAVORITE VERSES
        val favoriteVerses = remember(favVersesIds) {
          favVersesIds.mapNotNull { VerseRepository.getVerseById(it) }
        }

        if (favoriteVerses.isEmpty()) {
          Box(
            modifier = Modifier
              .fillMaxSize()
              .padding(32.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("📖", fontSize = 48.sp)
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Aún no tienes versículos guardados",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "Pulsa el corazón en cualquier versículo para conservarlo en tu altar personal.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
              )
            }
          }
        } else {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .widthIn(max = 600.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            items(favoriteVerses, key = { it.id }) { verse ->
              Card(
                modifier = Modifier.fillMaxWidth(),
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
                      text = verse.citation,
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = WinePrimary
                      )
                    )
                    IconButton(
                      onClick = {
                        prefs.toggleFavoriteVerse(verse.id)
                        favVersesIds = prefs.getFavoriteVerses()
                        scope.launch {
                          snackbarHostState.showSnackbar("Versículo quitado de favoritos")
                        }
                      }
                    ) {
                      Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar de favoritos",
                        tint = MaterialTheme.colorScheme.outline
                      )
                    }
                  }
                  Text(
                    text = "«${verse.godSaysToday}»",
                    style = MaterialTheme.typography.bodyMedium.copy(
                      fontFamily = FontFamily.Serif,
                      fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                  )
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = verse.text,
                    style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.onSurface
                  )
                }
              }
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
          }
        }
      }

      1 -> {
        // TAB 2: FAVORITE PRAYERS
        val favoritePrayers = remember(favPrayersIds) {
          favPrayersIds.mapNotNull { PrayerRepository.getPrayerById(it) }
        }

        if (favoritePrayers.isEmpty()) {
          Box(
            modifier = Modifier
              .fillMaxSize()
              .padding(32.dp),
            contentAlignment = Alignment.Center
          ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text("🕊️", fontSize = 48.sp)
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Aún no tienes oraciones guardadas",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
              )
              Spacer(modifier = Modifier.height(6.dp))
              Text(
                text = "Explora la sección de Oraciones Católicas y marca con un corazón las que más te conmuevan.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
              )
            }
          }
        } else {
          LazyColumn(
            modifier = Modifier
              .fillMaxSize()
              .widthIn(max = 600.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
          ) {
            items(favoritePrayers, key = { it.id }) { prayer ->
              val isPlaying = playingPrayerId == prayer.id
              Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
              ) {
                Column(modifier = Modifier.padding(16.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Column(modifier = Modifier.weight(1f)) {
                      Text(
                        text = prayer.title,
                        style = MaterialTheme.typography.titleMedium.copy(
                          fontWeight = FontWeight.Bold,
                          fontFamily = FontFamily.Serif
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                      )
                      prayer.latinTitle?.let {
                        Text(
                          text = it,
                          style = MaterialTheme.typography.labelSmall,
                          fontStyle = FontStyle.Italic,
                          color = GoldSecondary
                        )
                      }
                    }

                    // Play/Stop audio with Voz Viva
                    IconButton(
                      onClick = {
                        if (isPlaying) {
                          ttsHelper.stop()
                          playingPrayerId = null
                        } else {
                          ttsHelper.stop()
                          ttsHelper.speak("${prayer.title}. ${prayer.content}")
                          playingPrayerId = prayer.id
                          scope.launch {
                            snackbarHostState.showSnackbar("Reproduciendo con Voz Viva: ${prayer.title} 🎧")
                          }
                        }
                      }
                    ) {
                      Icon(
                        imageVector = if (isPlaying) Icons.Default.Stop else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Detener audio" else "Escuchar oración",
                        tint = if (isPlaying) WinePrimary else MaterialTheme.colorScheme.primary
                      )
                    }

                    IconButton(
                      onClick = {
                        if (isPlaying) {
                          ttsHelper.stop()
                          playingPrayerId = null
                        }
                        prefs.toggleFavoritePrayer(prayer.id)
                        favPrayersIds = prefs.getFavoritePrayers()
                        scope.launch {
                          snackbarHostState.showSnackbar("Oración retirada de favoritas")
                        }
                      }
                    ) {
                      Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar de favoritas",
                        tint = MaterialTheme.colorScheme.outline
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Text(
                    text = prayer.content,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 5
                  )
                }
              }
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
          }
        }
      }

      2 -> {
        // TAB 3: PRAYER PETITIONS / INTENTIONS
        Column(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp)
        ) {
          Button(
            onClick = { showAddPetitionDialog = true },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("add_petition_button"),
            colors = ButtonDefaults.buttonColors(
              containerColor = WinePrimary,
              contentColor = Color.White
            ),
            shape = RoundedCornerShape(14.dp)
          ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Añadir Petición o Intención de Oración", color = Color.White, fontWeight = FontWeight.Bold)
          }

          Spacer(modifier = Modifier.height(14.dp))

          if (petitions.isEmpty()) {
            Box(
              modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
              contentAlignment = Alignment.Center
            ) {
              Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("🙏", fontSize = 48.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                  text = "Sin intenciones registradas",
                  style = MaterialTheme.typography.titleMedium,
                  fontWeight = FontWeight.Bold,
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                  text = "Anota tus peticiones por familiares, enfermos, proyectos o acción de gracias al Señor.",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
                  textAlign = TextAlign.Center
                )
              }
            }
          } else {
            LazyColumn(
              verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
              items(petitions, key = { it }) { item ->
                Card(
                  modifier = Modifier.fillMaxWidth(),
                  shape = RoundedCornerShape(16.dp),
                  colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text("🕯️", fontSize = 22.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                      text = item,
                      style = MaterialTheme.typography.bodyMedium,
                      color = MaterialTheme.colorScheme.onSurface,
                      modifier = Modifier.weight(1f)
                    )
                    IconButton(
                      onClick = {
                        prefs.removePetition(item)
                        petitions = prefs.getPetitions()
                        scope.launch {
                          snackbarHostState.showSnackbar("Intención eliminada")
                        }
                      }
                    ) {
                      Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = MaterialTheme.colorScheme.outline
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }

      3 -> {
        // TAB 4: NOTIFICATION SETTINGS
        val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", notifHour, notifMinute)

        LazyColumn(
          modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 600.dp),
          verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
          item {
            Card(
              modifier = Modifier.fillMaxWidth(),
              shape = RoundedCornerShape(20.dp),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
              Column(modifier = Modifier.padding(20.dp)) {
                Text(
                  text = "Configuración de Notificaciones Diarias",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = "Cada día a la hora fijada recibirás un mensaje bíblico aleatorio: «Dios te dice hoy».",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Column {
                    Text(
                      text = "Notificación Diaria Activa",
                      style = MaterialTheme.typography.bodyLarge,
                      fontWeight = FontWeight.SemiBold
                    )
                    Text(
                      text = if (notifEnabled) "Activada" else "Desactivada",
                      style = MaterialTheme.typography.bodySmall,
                      color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                  }
                  Switch(
                    checked = notifEnabled,
                    onCheckedChange = { checked ->
                      notifEnabled = checked
                      prefs.setNotificationEnabled(checked)
                      if (checked) {
                        NotificationHelper.scheduleDailyAlarm(context)
                        scope.launch {
                          snackbarHostState.showSnackbar("Notificación programada para las $formattedTime hrs")
                        }
                      } else {
                        NotificationHelper.cancelDailyAlarm(context)
                        scope.launch {
                          snackbarHostState.showSnackbar("Notificación diaria desactivada")
                        }
                      }
                    },
                    colors = SwitchDefaults.colors(
                      checkedThumbColor = Color.White,
                      checkedTrackColor = WinePrimary
                    )
                  )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Time configuration
                Surface(
                  shape = RoundedCornerShape(14.dp),
                  color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                  modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showTimePicker() }
                ) {
                  Row(
                    modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                      Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                      )
                      Spacer(modifier = Modifier.width(12.dp))
                      Column {
                        Text(
                          text = "Hora de la Notificación",
                          style = MaterialTheme.typography.bodyMedium,
                          fontWeight = FontWeight.Medium
                        )
                        Text(
                          text = "Toca para cambiar la hora",
                          style = MaterialTheme.typography.labelSmall,
                          color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                      }
                    }

                    Text(
                      text = formattedTime,
                      style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = WinePrimary
                      )
                    )
                  }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                  onClick = {
                    NotificationHelper.sendTestNotification(context)
                    scope.launch {
                      snackbarHostState.showSnackbar("🔔 ¡Notificación de prueba enviada!")
                    }
                  },
                  modifier = Modifier.fillMaxWidth(),
                  colors = ButtonDefaults.buttonColors(
                    containerColor = WinePrimary,
                    contentColor = Color.White
                  ),
                  shape = RoundedCornerShape(12.dp)
                ) {
                  Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = Color.White)
                  Spacer(modifier = Modifier.width(8.dp))
                  Text("Enviar Notificación de Prueba Ahora", color = Color.White, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      }
    }
  }

  // ADD PETITION DIALOG
  if (showAddPetitionDialog) {
    AlertDialog(
      onDismissRequest = {
        showAddPetitionDialog = false
        newPetitionText = ""
      },
      title = {
        Text("Nueva Intención de Oración")
      },
      text = {
        OutlinedTextField(
          value = newPetitionText,
          onValueChange = { newPetitionText = it },
          placeholder = { Text("Escribe tu petición o agradecimiento a Dios...") },
          modifier = Modifier.fillMaxWidth(),
          maxLines = 4,
          shape = RoundedCornerShape(12.dp)
        )
      },
      confirmButton = {
        Button(
          onClick = {
            if (newPetitionText.isNotBlank()) {
              prefs.addPetition(newPetitionText)
              petitions = prefs.getPetitions()
              newPetitionText = ""
              showAddPetitionDialog = false
              scope.launch {
                snackbarHostState.showSnackbar("Petición guardada en tu altar 🙏")
              }
            }
          },
          colors = ButtonDefaults.buttonColors(
            containerColor = WinePrimary,
            contentColor = Color.White
          )
        ) {
          Text("Guardar", color = Color.White, fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(
          onClick = {
            showAddPetitionDialog = false
            newPetitionText = ""
          }
        ) {
          Text("Cancelar")
        }
      }
    )
  }
}
