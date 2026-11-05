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
import java.util.Calendar

object NotificationHelper {

  const val DAILY_CHANNEL_ID = "dios_te_dice_daily_channel"
  const val DAILY_NOTIFICATION_ID = 777
  const val ACTION_DAILY_NOTIFICATION = "com.example.ACTION_DAILY_NOTIFICATION"

  const val NIGHT_CHANNEL_ID = "dios_te_dice_night_channel"
  const val NIGHT_NOTIFICATION_ID = 888
  const val ACTION_NIGHT_NOTIFICATION = "com.example.ACTION_NIGHT_HAND_OF_GOD_NOTIFICATION"

  const val ANGELUS_CHANNEL_ID = "dios_te_dice_angelus_channel"
  const val ANGELUS_NOTIFICATION_ID = 999
  const val ACTION_ANGELUS_NOTIFICATION = "com.example.ACTION_ANGELUS_NOTIFICATION"

  private val DAILY_MESSAGES = listOf(
    "«El Señor es mi pastor, nada me faltará.» Recuerda que hoy Dios cuida de cada uno de tus pasos.",
    "«Todo lo puedo en Cristo que me fortalece.» Camina hoy con confianza y fe en Su amor.",
    "«No temas, porque yo estoy contigo; no desmayes, porque yo soy tu Dios.» Descansa en Su paz.",
    "«La paz os dejo, mi paz os doy; no se turbe vuestro corazón.» Que la gracia de Dios te acompañe hoy.",
    "«Pedid, y se os dará; buscad, y hallaréis.» Dedica un instante de tu día a la oración personal.",
    "«Den gracias al Señor, porque él es bueno; su gran amor perdura para siempre.» Que hoy abunde la gratitud en tu vida."
  )

  fun createNotificationChannels(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

      // Daily Inspiration Channel
      val dailyChannel = NotificationChannel(
        DAILY_CHANNEL_ID,
        "Mensajes Diarios (Dios te dice hoy)",
        NotificationManager.IMPORTANCE_HIGH
      ).apply {
        description = "Mensaje diario de fe e inspiración católica"
        enableVibration(true)
        enableLights(true)
      }
      notificationManager.createNotificationChannel(dailyChannel)

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

      // Angelus / Regina Caeli Channel
      val angelusChannel = NotificationChannel(
        ANGELUS_CHANNEL_ID,
        "El Ángelus (Mediodía)",
        NotificationManager.IMPORTANCE_HIGH
      ).apply {
        description = "Recordatorio del rezo del Ángelus o Regina Caeli a las 12:00h"
        enableVibration(true)
        enableLights(true)
      }
      notificationManager.createNotificationChannel(angelusChannel)
    }
  }

  // --- Daily Notification: "Dios te dice hoy" ---
  fun showDailyNotification(context: Context) {
    try {
      createNotificationChannels(context)
      val dailyMsg = com.example.data.VerseRepository.getDailyVerse()
      val title = "Dios te dice hoy: ${dailyMsg.citation} 🕊️"
      val body = "«${dailyMsg.godSaysToday}»"

      val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
      }

      val pendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
      )

      val notification = NotificationCompat.Builder(context, DAILY_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_cross)
        .setContentTitle(title)
        .setContentText(body)
        .setStyle(
          NotificationCompat.BigTextStyle()
            .setBigContentTitle(title)
            .setSummaryText(dailyMsg.citation)
            .bigText("${dailyMsg.verseText}\n\n«${dailyMsg.godSaysToday}»\n\n⚓ Propósito: ${dailyMsg.practicalApplication}")
        )
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .build()

      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.notify(DAILY_NOTIFICATION_ID, notification)
    } catch (_: Throwable) {}
  }

  fun scheduleDailyAlarm(context: Context) {
    val prefs = UserPreferences(context)
    if (!prefs.isNotificationEnabled()) {
      cancelDailyAlarm(context)
      return
    }

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java).apply {
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
    val intent = Intent(context, AlarmReceiver::class.java).apply {
      action = ACTION_DAILY_NOTIFICATION
    }
    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1001,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    alarmManager.cancel(pendingIntent)
  }

  fun sendTestNotification(context: Context) {
    showDailyNotification(context)
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

  // --- Scheduling Night Alarm ---
  fun scheduleNightAlarm(context: Context) {
    val prefs = UserPreferences(context)
    if (!prefs.isNightNotificationEnabled()) {
      cancelNightAlarm(context)
      return
    }

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java).apply {
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
    val intent = Intent(context, AlarmReceiver::class.java).apply {
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

  fun sendTestNightNotification(context: Context) {
    showNightNotification(context)
  }

  // --- Angelus / Regina Caeli Notification (12:00h) ---
  fun showAngelusNotification(context: Context) {
    try {
      createNotificationChannels(context)
      val cal = Calendar.getInstance()
      val month = cal.get(Calendar.MONTH) + 1
      val isEaster = month == 4 || month == 5
      val title = if (isEaster) "Regina Caeli • 12:00h 🌸" else "El Ángelus • 12:00h 🔔"
      val body = if (isEaster) {
        "«Reina del cielo, alégrate; aleluya. Porque el que mereciste llevar en tu seno resucitó como dijo; aleluya.»"
      } else {
        "«El Ángel del Señor anunció a María, y concibió por obra del Espíritu Santo. He aquí la esclava del Señor...»"
      }

      val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        putExtra("OPEN_TAB", "ANGELUS")
      }

      val pendingIntent = PendingIntent.getActivity(
        context,
        1003,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
      )

      val notification = NotificationCompat.Builder(context, ANGELUS_CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_stat_cross)
        .setContentTitle(title)
        .setContentText(body)
        .setStyle(NotificationCompat.BigTextStyle().bigText(body))
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .build()

      val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.notify(ANGELUS_NOTIFICATION_ID, notification)
    } catch (e: Exception) {
      android.util.Log.e("NotificationHelper", "Error showing Angelus notification", e)
    }
  }

  fun scheduleAngelusAlarm(context: Context) {
    val prefs = UserPreferences(context)
    if (!prefs.isAngelusNotifEnabled()) return

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java).apply {
      action = ACTION_ANGELUS_NOTIFICATION
    }
    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1004,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val calendar = Calendar.getInstance().apply {
      set(Calendar.HOUR_OF_DAY, 12)
      set(Calendar.MINUTE, 0)
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

  fun cancelAngelusAlarm(context: Context) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java).apply {
      action = ACTION_ANGELUS_NOTIFICATION
    }
    val pendingIntent = PendingIntent.getBroadcast(
      context,
      1004,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    alarmManager.cancel(pendingIntent)
  }
}
