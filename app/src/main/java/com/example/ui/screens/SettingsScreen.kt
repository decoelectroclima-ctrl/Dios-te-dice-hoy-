package com.example.ui.screens

import android.Manifest
import android.app.Activity
import android.app.TimePickerDialog
import android.content.pm.PackageManager
import android.os.Build
import com.example.util.PermissionBridge
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.data.UserPreferences
import com.example.notification.NotificationHelper
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.GranateButton
import com.example.ui.theme.GranateButtonDark
import com.example.ui.theme.GranateButtonBorderDark
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.appWineColor
import com.example.util.BiometricHelper
import com.example.widget.DiosTeDiceWidgetProvider

import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun SettingsScreen(
  snackbarHostState: SnackbarHostState,
  onThemeChanged: (String) -> Unit,
  onFontSizeChanged: (Float) -> Unit,
  onOpenPinSetup: () -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  // Theme Mode
  var currentTheme by remember { mutableStateOf(prefs.getThemeMode()) }

  // Morning notification
  var morningNotifEnabled by remember { mutableStateOf(prefs.isNotificationEnabled()) }
  var morningHour by remember { mutableIntStateOf(prefs.getNotificationHour()) }
  var morningMinute by remember { mutableIntStateOf(prefs.getNotificationMinute()) }
  val formattedMorningTime = String.format(Locale.getDefault(), "%02d:%02d", morningHour, morningMinute)

  // Night notification
  var nightNotifEnabled by remember { mutableStateOf(prefs.isNightNotificationEnabled()) }
  var nightHour by remember { mutableIntStateOf(prefs.getNightNotificationHour()) }
  var nightMinute by remember { mutableIntStateOf(prefs.getNightNotificationMinute()) }
  val formattedNightTime = String.format(Locale.getDefault(), "%02d:%02d", nightHour, nightMinute)

  // Security & App Lock states
  var isLockEnabled by remember { mutableStateOf(prefs.isAppLockEnabled()) }
  var isBiometricEnabled by remember { mutableStateOf(prefs.isBiometricEnabled()) }
  val isBiometricDeviceAvailable = remember { BiometricHelper.isBiometricAvailable(context) }
  val hasPin = remember(isLockEnabled) { prefs.hasPinSet() }

  fun showMorningTimePicker() {
    val picker = TimePickerDialog(
      context,
      { _, hour, minute ->
        morningHour = hour
        morningMinute = minute
        prefs.setNotificationTime(hour, minute)
        if (morningNotifEnabled) {
          NotificationHelper.scheduleDailyAlarm(context)
        }
        scope.launch {
          snackbarHostState.showSnackbar("Hora matutina actualizada a las $formattedMorningTime hrs")
        }
      },
      morningHour,
      morningMinute,
      true
    )
    picker.show()
  }

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
          snackbarHostState.showSnackbar("Hora nocturna actualizada a las $formattedNightTime hrs")
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
      // TEMA DE LA APLICACIÓN
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Palette,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "Apariencia y Tema",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
              ),
              color = MaterialTheme.colorScheme.onSurface
            )
          }

          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Elige entre el tema claro con pergamino litúrgico o el modo oscuro solemne:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(14.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            FilterChip(
              selected = currentTheme == UserPreferences.THEME_LIGHT,
              onClick = {
                currentTheme = UserPreferences.THEME_LIGHT
                prefs.setThemeMode(UserPreferences.THEME_LIGHT)
                onThemeChanged(UserPreferences.THEME_LIGHT)
              },
              label = { Text("☀️ Modo Claro") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = appWineColor(),
                selectedLabelColor = Color.White
              )
            )

            FilterChip(
              selected = currentTheme == UserPreferences.THEME_DARK,
              onClick = {
                currentTheme = UserPreferences.THEME_DARK
                prefs.setThemeMode(UserPreferences.THEME_DARK)
                onThemeChanged(UserPreferences.THEME_DARK)
              },
              label = { Text("🌙 Modo Oscuro") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = appWineColor(),
                selectedLabelColor = Color.White
              )
            )

            FilterChip(
              selected = currentTheme == UserPreferences.THEME_SYSTEM,
              onClick = {
                currentTheme = UserPreferences.THEME_SYSTEM
                prefs.setThemeMode(UserPreferences.THEME_SYSTEM)
                onThemeChanged(UserPreferences.THEME_SYSTEM)
              },
              label = { Text("📱 Sistema") },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = appWineColor(),
                selectedLabelColor = Color.White
              )
            )
          }
        }
      }
    }

    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
           var fontSize by remember { mutableStateOf(prefs.getFontSize().coerceIn(0.8f, 1.5f)) }
           Text("Tamaño de letra: ${(fontSize * 100).toInt()}%")
           androidx.compose.material3.Slider(
              value = fontSize,
              onValueChange = { 
                  fontSize = it
                  prefs.setFontSize(it)
                  onFontSizeChanged(it)
              },
              valueRange = 0.8f..1.5f,
              steps = 6
           )
        }
      }
    }



    // ALARMA Y RECORDATORIO NOCTURNO ("LA MANO DE DIOS")
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🤲", fontSize = 20.sp)
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Recordatorio Nocturno «La Mano de Dios»",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = if (nightNotifEnabled) "Programada a las $formattedNightTime hrs" else "Desactivada",
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
              colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = appWineColor())
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
              modifier = Modifier
                .weight(1f)
                .clickable { showNightTimePicker() }
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(imageVector = Icons.Default.AccessTime, contentDescription = null, modifier = Modifier.size(18.dp), tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Hora: $formattedNightTime hrs", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
              }
            }

            Button(
              onClick = {
                NotificationHelper.sendTestNightNotification(context)
                scope.launch {
                  snackbarHostState.showSnackbar("🔔 ¡Notificación nocturna de prueba enviada al sistema!")
                }
              },
              colors = appButtonColors(),
              border = appButtonBorder(),
              shape = RoundedCornerShape(10.dp)
            ) {
              Text("Probar ahora", color = Color.White, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    }

    // SEGURIDAD: BLOQUEO POR PIN DE 4 DÍGITOS Y HUELLA DACTILAR
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = appWineColor(),
                modifier = Modifier.size(24.dp)
              )
              Spacer(modifier = Modifier.width(10.dp))
              Column {
                Text(
                  text = "Bloqueo y Privacidad de la App",
                  style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = if (isLockEnabled)
                    "Protegido con PIN de 4 dígitos"
                  else
                    "Desactivado (acceso libre)",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }

            Switch(
              checked = isLockEnabled,
              onCheckedChange = { checked ->
                if (checked) {
                  if (hasPin) {
                    prefs.setAppLockEnabled(true)
                    isLockEnabled = true
                    scope.launch {
                      snackbarHostState.showSnackbar("Bloqueo de app activado con PIN")
                    }
                  } else {
                    onOpenPinSetup()
                  }
                } else {
                  prefs.setAppLockEnabled(false)
                  isLockEnabled = false
                  scope.launch {
                    snackbarHostState.showSnackbar("Bloqueo de app desactivado")
                  }
                }
              },
              colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = appWineColor()
              )
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Button(
              onClick = { onOpenPinSetup() },
              colors = appButtonColors(),
              border = appButtonBorder(),
              shape = RoundedCornerShape(10.dp),
              modifier = Modifier.weight(1f)
            ) {
              Text(
                text = if (hasPin) "Cambiar PIN de 4 dígitos" else "Configurar PIN de 4 dígitos",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
              )
            }

            if (hasPin) {
              Button(
                onClick = {
                  prefs.removePin()
                  isLockEnabled = false
                  scope.launch {
                    snackbarHostState.showSnackbar("PIN eliminado. Acceso sin clave.")
                  }
                },
                colors = appButtonColors(),
                border = appButtonBorder(),
                shape = RoundedCornerShape(10.dp)
              ) {
                Text("Eliminar", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
              }
            }
          }

          if (isBiometricDeviceAvailable && isLockEnabled) {
            HorizontalDivider(
              modifier = Modifier.padding(vertical = 12.dp),
              color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
            )

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.Fingerprint,
                  contentDescription = null,
                  tint = GoldSecondary,
                  modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = "Desbloqueo con Huella / Biometría",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurface
                  )
                  Text(
                    text = "Usa el sensor del teléfono como alternativa al PIN",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }

              Switch(
                checked = isBiometricEnabled,
                onCheckedChange = { checked ->
                  isBiometricEnabled = checked
                  prefs.setBiometricEnabled(checked)
                  scope.launch {
                    snackbarHostState.showSnackbar(
                      if (checked) "Huella dactilar activada para desbloqueo" else "Huella dactilar desactivada"
                    )
                  }
                },
                colors = SwitchDefaults.colors(
                  checkedThumbColor = Color.White,
                  checkedTrackColor = appWineColor()
                )
              )
            }
          }
        }
      }
    }



    // WIDGET DE LA PANTALLA DE INICIO (ESCRITORIO)
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Widgets,
              contentDescription = null,
              tint = appWineColor(),
              modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "Widget en tu Pantalla de Inicio",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  fontFamily = FontFamily.Serif
                ),
                color = MaterialTheme.colorScheme.onSurface
              )
              Text(
                text = "Lleva la Palabra de Dios viva a tu escritorio",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }

          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = "Puedes colocar el widget compacto (4x1) en tu pantalla de inicio de Android para leer la cita bíblica e inspiración diaria ocupando solo una fila en tu escritorio.\n\nPara añadirlo: mantén pulsado un espacio vacío de tu pantalla de inicio -> selecciona «Widgets» -> busca «Dios Te Dice Hoy» (4x1) y colócalo.",
            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(14.dp))

          Button(
            onClick = {
              val updatedVerse = DiosTeDiceWidgetProvider.updateAllWidgets(context, newRandomVerse = true)
              scope.launch {
                snackbarHostState.showSnackbar("🕊️ ¡Widget sincronizado con éxito! (${updatedVerse.citation})")
              }
            },
            colors = appButtonColors(),
            border = appButtonBorder(),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(
              imageVector = Icons.Default.Sync,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Sincronizar Widget Ahora",
              color = Color.White,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }
    }

    // PRIVACIDAD TOTAL: 100% LOCAL Y OFFLINE (SIN IA EXTERNA NI NUBE)
    item {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Security,
              contentDescription = null,
              tint = GoldSecondary,
              modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "100% Local, Offline y Privado",
              style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onSecondaryContainer
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          Text(
            text = "• Toda la liturgia, lecturas, oraciones y versículos residen en tu teléfono.\n• No utiliza IA en la nube ni requiere conexión a internet para funcionar.\n• Tus pecados anotados para confesión y testimonios de la mano de Dios nunca salen de tu dispositivo.",
            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
            color = MaterialTheme.colorScheme.onSecondaryContainer
          )
        }

      }
    }

    item {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Dios Te Dice Hoy • Versión 43.0",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
        )
      }
    }
  }
}
