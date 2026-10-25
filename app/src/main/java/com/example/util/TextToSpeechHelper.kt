package com.example.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

  private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
  private var isInitialized = false

  override fun onInit(status: Int) {
    if (status == TextToSpeech.SUCCESS) {
      val result = tts?.setLanguage(Locale("es", "ES"))
      if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        // Fallback to general Spanish
        tts?.setLanguage(Locale("es"))
      }
      tts?.setSpeechRate(0.92f) // slightly slower, peaceful contemplation rate
      tts?.setPitch(1.0f)
      isInitialized = true
    } else {
      Log.e("TTS", "Error inicializando TextToSpeech")
    }
  }

  fun speak(text: String, onDone: (() -> Unit)? = null) {
    if (!isInitialized || tts == null) return
    tts?.stop()
    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "UTTERANCE_PRAYER")
  }

  fun stop() {
    tts?.stop()
  }

  fun isSpeaking(): Boolean {
    return tts?.isSpeaking == true
  }

  fun shutdown() {
    tts?.stop()
    tts?.shutdown()
    tts = null
  }
}
