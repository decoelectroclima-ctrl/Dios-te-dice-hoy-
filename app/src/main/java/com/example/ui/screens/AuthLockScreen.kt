package com.example.ui.screens

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.example.data.UserPreferences
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.BiometricHelper

enum class AuthMode {
  UNLOCK,
  SETUP_NEW,
  CHANGE_PIN
}

@Composable
fun AuthLockScreen(
  mode: AuthMode = AuthMode.UNLOCK,
  onUnlocked: () -> Unit,
  onCancel: (() -> Unit)? = null
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val activity = context as? FragmentActivity

  var enteredPin by remember { mutableStateOf("") }
  var setupStep by remember { mutableStateOf(1) } // 1: enter new pin, 2: confirm pin
  var firstPinAttempt by remember { mutableStateOf("") }
  var errorMessage by remember { mutableStateOf<String?>(null) }
  var successMessage by remember { mutableStateOf<String?>(null) }

  val isBiometricAvailable = remember { BiometricHelper.isBiometricAvailable(context) }
  val canUseBiometrics = mode == AuthMode.UNLOCK && isBiometricAvailable && prefs.isBiometricEnabled()

  fun triggerBiometric() {
    if (activity != null && canUseBiometrics) {
      BiometricHelper.showBiometricPrompt(
        activity = activity,
        title = "Acceso a Dios Te Dice Hoy",
        subtitle = "Identifícate con tu huella dactilar",
        negativeButtonText = "Usar PIN de 4 dígitos",
        onSuccess = {
          onUnlocked()
        },
        onError = { err ->
          // Non-blocking error, user can type PIN
          errorMessage = err
        }
      )
    }
  }

  // Attempt biometric prompt automatically once on enter if in unlock mode
  LaunchedEffect(Unit) {
    if (mode == AuthMode.UNLOCK && canUseBiometrics) {
      triggerBiometric()
    }
  }

  fun handleDigit(digit: String) {
    if (enteredPin.length < 4) {
      val newPin = enteredPin + digit
      enteredPin = newPin
      errorMessage = null

      if (newPin.length == 4) {
        when (mode) {
          AuthMode.UNLOCK -> {
            if (prefs.verifyPin(newPin)) {
              onUnlocked()
            } else {
              errorMessage = "Clave incorrecta. Inténtalo de nuevo."
              enteredPin = ""
            }
          }
          AuthMode.SETUP_NEW, AuthMode.CHANGE_PIN -> {
            if (setupStep == 1) {
              firstPinAttempt = newPin
              enteredPin = ""
              setupStep = 2
            } else {
              if (newPin == firstPinAttempt) {
                prefs.setPin(newPin)
                successMessage = "¡Clave de 4 dígitos guardada con éxito!"
                onUnlocked()
              } else {
                errorMessage = "Las claves no coinciden. Comienza de nuevo."
                enteredPin = ""
                firstPinAttempt = ""
                setupStep = 1
              }
            }
          }
        }
      }
    }
  }

  fun handleBackspace() {
    if (enteredPin.isNotEmpty()) {
      enteredPin = enteredPin.dropLast(1)
      errorMessage = null
    }
  }

  BackHandler(enabled = onCancel != null) {
    onCancel?.invoke()
  }

  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp, vertical = 20.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      // Top bar for cancel if allowed
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
      ) {
        if (onCancel != null) {
          IconButton(onClick = onCancel) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Cancelar"
            )
          }
        } else {
          Spacer(modifier = Modifier.height(48.dp))
        }
      }

      // Sacred Emblem & Instructions
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.widthIn(max = 400.dp)
      ) {
        Box(
          modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(
              Brush.linearGradient(listOf(WinePrimary, GoldSecondary))
            ),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = if (mode == AuthMode.UNLOCK) Icons.Default.Lock else Icons.Default.Security,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(36.dp)
          )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = when (mode) {
            AuthMode.UNLOCK -> "Privacidad Sagrada"
            AuthMode.SETUP_NEW -> if (setupStep == 1) "Configurar Clave" else "Confirmar Clave"
            AuthMode.CHANGE_PIN -> if (setupStep == 1) "Nueva Clave" else "Confirmar Nueva Clave"
          },
          style = MaterialTheme.typography.headlineSmall.copy(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
          ),
          color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = when (mode) {
            AuthMode.UNLOCK -> "Ingresa tu clave de 4 dígitos o usa tu huella para acceder a tu diario y confesiones."
            AuthMode.SETUP_NEW, AuthMode.CHANGE_PIN -> if (setupStep == 1)
              "Elige un código de 4 dígitos que se guardará de forma privada en tu dispositivo."
            else
              "Vuelve a introducir los 4 dígitos para confirmar tu código."
          },
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        // 4-Digit PIN Indicators
        Row(
          horizontalArrangement = Arrangement.spacedBy(20.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          for (i in 0 until 4) {
            val isFilled = i < enteredPin.length
            Box(
              modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(
                  if (isFilled) WinePrimary else MaterialTheme.colorScheme.surfaceVariant
                )
                .border(
                  width = 2.dp,
                  color = if (isFilled) GoldSecondary else MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                  shape = CircleShape
                )
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Error or Success message
        AnimatedVisibility(
          visible = errorMessage != null,
          enter = fadeIn(),
          exit = fadeOut()
        ) {
          Text(
            text = errorMessage ?: "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            textAlign = TextAlign.Center
          )
        }

        AnimatedVisibility(
          visible = successMessage != null,
          enter = fadeIn(),
          exit = fadeOut()
        ) {
          Text(
            text = successMessage ?: "",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            textAlign = TextAlign.Center
          )
        }
      }

      // Numeric Keypad
      Column(
        modifier = Modifier
          .widthIn(max = 340.dp)
          .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        val rows = listOf(
          listOf("1", "2", "3"),
          listOf("4", "5", "6"),
          listOf("7", "8", "9")
        )

        for (row in rows) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
          ) {
            for (digit in row) {
              KeypadButton(
                text = digit,
                onClick = { handleDigit(digit) },
                testTag = "keypad_$digit"
              )
            }
          }
        }

        // Bottom row: Biometric / Fingerprint, 0, Backspace
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceEvenly,
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Left: Biometric trigger if available and in UNLOCK mode
          if (canUseBiometrics) {
            Box(
              modifier = Modifier
                .size(68.dp)
                .clip(CircleShape)
                .clickable { triggerBiometric() }
                .testTag("keypad_biometric"),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Fingerprint,
                contentDescription = "Desbloquear con Huella",
                tint = GoldSecondary,
                modifier = Modifier.size(36.dp)
              )
            }
          } else {
            Spacer(modifier = Modifier.size(68.dp))
          }

          // Center: 0
          KeypadButton(
            text = "0",
            onClick = { handleDigit("0") },
            testTag = "keypad_0"
          )

          // Right: Backspace
          Box(
            modifier = Modifier
              .size(68.dp)
              .clip(CircleShape)
              .clickable(enabled = enteredPin.isNotEmpty()) { handleBackspace() }
              .testTag("keypad_backspace"),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.Backspace,
              contentDescription = "Borrar",
              tint = if (enteredPin.isNotEmpty())
                MaterialTheme.colorScheme.onSurface
              else
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
              modifier = Modifier.size(28.dp)
            )
          }
        }
      }

      // Bottom information footnote
      Text(
        text = "Tus datos y reflexiones se mantienen exclusivamente en tu dispositivo.",
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 8.dp)
      )
    }
  }
}

@Composable
private fun KeypadButton(
  text: String,
  onClick: () -> Unit,
  testTag: String
) {
  Box(
    modifier = Modifier
      .size(68.dp)
      .clip(CircleShape)
      .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
      .clickable(onClick = onClick)
      .testTag(testTag),
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.titleLarge.copy(
        fontSize = 26.sp,
        fontWeight = FontWeight.Medium
      ),
      color = MaterialTheme.colorScheme.onSurface
    )
  }
}
