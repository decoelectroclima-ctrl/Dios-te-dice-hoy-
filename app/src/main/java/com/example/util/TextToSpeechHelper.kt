package com.example.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

  private var tts: TextToSpeech? = TextToSpeech(context.applicationContext, this)
  private var isInitialized = false
  private var currentRate = 0.95f
  private var onCompletionCallback: (() -> Unit)? = null
  private val mainHandler = Handler(Looper.getMainLooper())

  override fun onInit(status: Int) {
    if (status == TextToSpeech.SUCCESS) {
      val result = tts?.setLanguage(Locale("es", "ES"))
      if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        tts?.setLanguage(Locale("es"))
      }
      tts?.setSpeechRate(currentRate)
      tts?.setPitch(1.0f)
      tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
        override fun onStart(utteranceId: String?) {}

        override fun onDone(utteranceId: String?) {
          mainHandler.post {
            onCompletionCallback?.invoke()
          }
        }

        override fun onError(utteranceId: String?) {
          mainHandler.post {
            onCompletionCallback?.invoke()
          }
        }
      })
      isInitialized = true
    } else {
      Log.e("TTS", "Error inicializando TextToSpeech")
    }
  }

  fun setSpeechRate(rate: Float) {
    currentRate = rate.coerceIn(0.5f, 2.0f)
    if (isInitialized) {
      tts?.setSpeechRate(currentRate)
    }
  }

  fun getSpeechRate(): Float = currentRate

  fun speak(text: String, onDone: (() -> Unit)? = null) {
    if (!isInitialized || tts == null) return
    tts?.stop()
    onCompletionCallback = onDone
    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "UTTERANCE_BIBLE_${System.currentTimeMillis()}")
  }

  fun stop() {
    onCompletionCallback = null
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
