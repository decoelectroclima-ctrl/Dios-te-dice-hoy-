package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.widget.DailyVerseWidgetProvider

class DailyVerseReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent?) {
    try {
      val action = intent?.action
      val prefs = UserPreferences(context)

      if (action == Intent.ACTION_BOOT_COMPLETED) {
        if (prefs.isNotificationEnabled()) {
          NotificationHelper.scheduleDailyAlarm(context)
        }
        if (prefs.isNightNotificationEnabled()) {
          NotificationHelper.scheduleNightAlarm(context)
        }
        DailyVerseWidgetProvider.updateAllWidgets(context)
        return
      }

      if (action == NotificationHelper.ACTION_NIGHT_NOTIFICATION) {
        if (prefs.isNightNotificationEnabled()) {
          NotificationHelper.showNightNotification(context)
          NotificationHelper.scheduleNightAlarm(context)
        }
        return
      }

      // Default: Morning Daily Verse
      if (prefs.isNotificationEnabled()) {
        val verse = VerseRepository.getRandomVerse()
        NotificationHelper.showDailyNotification(context, verse)
        NotificationHelper.scheduleDailyAlarm(context)
      }
      // Update daily widget whenever morning cycle triggers
      DailyVerseWidgetProvider.updateAllWidgets(context)
    } catch (_: Throwable) {}
  }
}
