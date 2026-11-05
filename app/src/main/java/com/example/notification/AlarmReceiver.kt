package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            NotificationHelper.ACTION_DAILY_NOTIFICATION -> {
                NotificationHelper.showDailyNotification(context)
                NotificationHelper.scheduleDailyAlarm(context)
            }
            NotificationHelper.ACTION_NIGHT_NOTIFICATION -> {
                NotificationHelper.showNightNotification(context)
                NotificationHelper.scheduleNightAlarm(context)
            }
            NotificationHelper.ACTION_ANGELUS_NOTIFICATION -> {
                NotificationHelper.showAngelusNotification(context)
                NotificationHelper.scheduleAngelusAlarm(context)
            }
            Intent.ACTION_BOOT_COMPLETED -> {
                NotificationHelper.scheduleDailyAlarm(context)
                NotificationHelper.scheduleNightAlarm(context)
                NotificationHelper.scheduleAngelusAlarm(context)
            }
        }
    }
}
