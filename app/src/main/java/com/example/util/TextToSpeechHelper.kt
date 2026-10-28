package com.example.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.Locale

class TextToSpeechHelper(context: Context) : TextToSpeech.OnInitListener {

  private var tts: TextToSpeech? = null
  private var isInitialized = false
  private var currentRate = 0.95f
  private var onCompletionCallback: (() -> Unit)? = null
  private val mainHandler = Handler(Looper.getMainLooper())

  init {
    try {
      tts = TextToSpeech(context.applicationContext, this)
    } catch (t: Throwable) {
      Log.e("TTS", "Could not instantiate TextToSpeech", t)
      tts = null
    }
  }

  override fun onInit(status: Int) {
    try {
      if (status == TextToSpeech.SUCCESS && tts != null) {
        val result = try {
          tts?.setLanguage(Locale("es", "ES"))
        } catch (_: Throwable) {
          TextToSpeech.LANG_MISSING_DATA
        }
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
          try {
            tts?.setLanguage(Locale("es"))
          } catch (_: Throwable) {}
        }
        try {
          tts?.setSpeechRate(currentRate)
          tts?.setPitch(1.0f)
          tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {}

            override fun onDone(utteranceId: String?) {
              mainHandler.post {
                try {
                  onCompletionCallback?.invoke()
                } catch (_: Throwable) {}
              }
            }

            override fun onError(utteranceId: String?) {
              mainHandler.post {
                try {
                  onCompletionCallback?.invoke()
                } catch (_: Throwable) {}
              }
            }
          })
          isInitialized = true
        } catch (t: Throwable) {
          Log.e("TTS", "Error configuring TTS settings", t)
        }
      }
    } catch (t: Throwable) {
      Log.e("TTS", "Exception in onInit", t)
    }
  }

  fun setSpeechRate(rate: Float) {
    currentRate = rate.coerceIn(0.5f, 2.0f)
    if (isInitialized) {
      try {
        tts?.setSpeechRate(currentRate)
      } catch (_: Throwable) {}
    }
  }

  fun getSpeechRate(): Float = currentRate

  fun speak(text: String, onDone: (() -> Unit)? = null) {
    if (!isInitialized || tts == null) return
    try {
      tts?.stop()
      onCompletionCallback = onDone
      tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "UTTERANCE_BIBLE_${System.currentTimeMillis()}")
    } catch (t: Throwable) {
      Log.e("TTS", "Error speaking text", t)
      onDone?.invoke()
    }
  }

  fun stop() {
    onCompletionCallback = null
    try {
      tts?.stop()
    } catch (_: Throwable) {}
  }

  fun isSpeaking(): Boolean {
    return try {
      tts?.isSpeaking == true
    } catch (_: Throwable) {
      false
    }
  }

  fun shutdown() {
    try {
      onCompletionCallback = null
      tts?.stop()
      tts?.shutdown()
    } catch (_: Throwable) {}
    tts = null
    isInitialized = false
  }
}
