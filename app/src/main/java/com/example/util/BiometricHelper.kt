package com.example.util

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

object BiometricHelper {

  fun isBiometricAvailable(context: Context): Boolean {
    return try {
      val biometricManager = BiometricManager.from(context)
      when (biometricManager.canAuthenticate(
        BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.BIOMETRIC_WEAK
      )) {
        BiometricManager.BIOMETRIC_SUCCESS -> true
        else -> false
      }
    } catch (_: Throwable) {
      false
    }
  }

  fun showBiometricPrompt(
    activity: FragmentActivity,
    title: String = "Acceso Seguro",
    subtitle: String = "Usa tu huella dactilar o biometría",
    negativeButtonText: String = "Usar PIN de 4 dígitos",
    onSuccess: () -> Unit,
    onError: (String) -> Unit
  ) {
    try {
      val executor = ContextCompat.getMainExecutor(activity)
      val biometricPrompt = BiometricPrompt(
        activity,
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
          override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
            super.onAuthenticationSucceeded(result)
            onSuccess()
          }

          override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
            super.onAuthenticationError(errorCode, errString)
            onError(errString.toString())
          }

          override fun onAuthenticationFailed() {
            super.onAuthenticationFailed()
            onError("Huella no reconocida. Intenta de nuevo o ingresa el PIN.")
          }
        }
      )

      val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle(title)
        .setSubtitle(subtitle)
        .setNegativeButtonText(negativeButtonText)
        .build()

      biometricPrompt.authenticate(promptInfo)
    } catch (e: Throwable) {
      onError("No se pudo iniciar la autenticación biométrica: ${e.localizedMessage ?: "error"}")
    }
  }
}

