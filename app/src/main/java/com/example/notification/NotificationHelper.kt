package com.example.notification

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.MainActivity
import com.example.R
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.model.BibleVerse
import java.util.Calendar

object NotificationHelper {

  const val CHANNEL_ID = "dios_te_dice_daily_channel"
  const val NIGHT_CHANNEL_ID = "dios_te_dice_night_channel"

  const val NOTIFICATION_ID = 777
  const val NIGHT_NOTIFICATION_ID = 888

  const val ACTION_DAILY_NOTIFICATION = "com.example.ACTION_DAILY_VERSE_NOTIFICATION"
  const val ACTION_NIGHT_NOTIFICATION = "com.example.ACTION_NIGHT_HAND_OF_GOD_NOTIFICATION"

  fun createNotificationChannels(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

      // Morning Verse Channel
      val morningChannel = NotificationChannel(
        CHANNEL_ID,
        "Dios Te Dice Hoy",
        NotificationManager.IMPORTANCE_HIGH
      ).apply {
        description = "Notificación diaria con un versículo bíblico y mensaje de Dios"
        enableVibration(true)
        enableLights(true)
      }
      notificationManager.createNotificationChannel(morningChannel)

      // Night Examination / Gratitude Channel
      val nightChannel = NotificationChannel(
        NIGHT_CHANNEL_ID,
        "La Mano de Dios (Noche)",
        NotificationManager.IMPORTANCE_HIGH
      ).apply {
        description = "Recordatorio nocturno para registrar dónde notaste la mano de Dios"
        enableVibration(true)
        enableLights(true)
      }
      notificationManager.createNotificationChannel(nightChannel)
    }
  }

  // --- Morning Notification ---
  fun showDailyNotification(context: Context, verse: BibleVerse) {
    try {
      createNotificationChannels(context)

      val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        putExtra("TARGET_VERSE_ID", verse.id)
      }

      val pendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
      )

      val notification = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_cross)
        .setContentTitle("Dios te dice hoy ✨")
        .setContentText("${verse.citation}: «${verse.godSaysToday}»")
        .setStyle(
          NotificationCompat.BigTextStyle()
            .setBigContentTitle("Dios te dice hoy ✨")
            .setSummaryText(verse.citation)
            .bigText("«${verse.godSaysToday}»\n\n${verse.text}\n— ${verse.citation}")
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .build()

      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.notify(NOTIFICATION_ID, notification)
    } catch (_: Throwable) {}
  }

  // --- Night Notification: "La Mano de Dios" ---
  fun showNightNotification(context: Context) {
    try {
      createNotificationChannels(context)

      val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        putExtra("OPEN_TAB", "HAND_OF_GOD")
      }

      val pendingIntent = PendingIntent.getActivity(
        context,
        1,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
      )

      val notification = NotificationCompat.Builder(context, NIGHT_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_cross)
        .setContentTitle("¿Dónde notaste hoy la mano de Dios? 🕊️")
        .setContentText("Dedica 2 minutos a recordar su gracia, agradecer y anotar las bendiciones de hoy.")
        .setStyle(
          NotificationCompat.BigTextStyle()
            .setBigContentTitle("¿Dónde notaste hoy la mano de Dios? 🕊️")
            .setSummaryText("Examen de Gratitud Nocturno")
            .bigText("«Den gracias al Señor, porque él es bueno; su gran amor perdura para siempre» (Salmo 107:1).\n\nTómate un instante antes de dormir para registrar dónde se hizo presente Dios en tu jornada.")
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .build()

      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.notify(NIGHT_NOTIFICATION_ID, notification)
    } catch (_: Throwable) {}
  }

  // --- Scheduling Morning Alarm ---
  fun scheduleDailyAlarm(context: Context) {
    val prefs = UserPreferences(context)
    if (!prefs.isNotificationEnabled()) {
      cancelDailyAlarm(context)
      return
    }

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, DailyVerseReceiver::class.java).apply {
      action = ACTION_DAILY_NOTIFICATION
    }

    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1001,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val hour = prefs.getNotificationHour()
    val minute = prefs.getNotificationMinute()

    val calendar = Calendar.getInstance().apply {
      set(Calendar.HOUR_OF_DAY, hour)
      set(Calendar.MINUTE, minute)
      set(Calendar.SECOND, 0)
      set(Calendar.MILLISECOND, 0)
      if (before(Calendar.getInstance())) {
        add(Calendar.DAY_OF_YEAR, 1)
      }
    }

    try {
      val canExact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        alarmManager.canScheduleExactAlarms()
      } else {
        true
      }

      if (canExact && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        alarmManager.setExactAndAllowWhileIdle(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      } else {
        alarmManager.set(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      }
    } catch (_: Exception) {
      try {
        alarmManager.set(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      } catch (_: Exception) {}
    }
  }

  fun cancelDailyAlarm(context: Context) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, DailyVerseReceiver::class.java).apply {
      action = ACTION_DAILY_NOTIFICATION
    }
    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1001,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    try {
      alarmManager.cancel(pendingIntent)
    } catch (_: Exception) {}
  }

  // --- Scheduling Night Alarm ---
  fun scheduleNightAlarm(context: Context) {
    val prefs = UserPreferences(context)
    if (!prefs.isNightNotificationEnabled()) {
      cancelNightAlarm(context)
      return
    }

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, DailyVerseReceiver::class.java).apply {
      action = ACTION_NIGHT_NOTIFICATION
    }

    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1002,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val hour = prefs.getNightNotificationHour()
    val minute = prefs.getNightNotificationMinute()

    val calendar = Calendar.getInstance().apply {
      set(Calendar.HOUR_OF_DAY, hour)
      set(Calendar.MINUTE, minute)
      set(Calendar.SECOND, 0)
      set(Calendar.MILLISECOND, 0)
      if (before(Calendar.getInstance())) {
        add(Calendar.DAY_OF_YEAR, 1)
      }
    }

    try {
      val canExact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        alarmManager.canScheduleExactAlarms()
      } else {
        true
      }

      if (canExact && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        alarmManager.setExactAndAllowWhileIdle(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      } else {
        alarmManager.set(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      }
    } catch (_: Exception) {
      try {
        alarmManager.set(
          AlarmManager.RTC_WAKEUP,
          calendar.timeInMillis,
          pendingIntent
        )
      } catch (_: Exception) {}
    }
  }

  fun cancelNightAlarm(context: Context) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, DailyVerseReceiver::class.java).apply {
      action = ACTION_NIGHT_NOTIFICATION
    }
    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1002,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    alarmManager.cancel(pendingIntent)
  }

  fun sendTestNotification(context: Context) {
    val randomVerse = VerseRepository.getRandomVerse()
    showDailyNotification(context, randomVerse)
  }

  fun sendTestNightNotification(context: Context) {
    showNightNotification(context)
  }
}
