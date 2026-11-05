package com.example

import android.app.Application
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter

class DiosApp : Application() {
  override fun onCreate() {
    super.onCreate()
    val previous = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
      try {
        val sw = StringWriter()
        throwable.printStackTrace(PrintWriter(sw))
        File(filesDir, "last_crash.txt").writeText("Hilo: ${thread.name}\n$sw")
      } catch (_: Throwable) {}
      previous?.uncaughtException(thread, throwable)
    }
  }
}
