package com.example.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.MainActivity
import com.example.R
import com.example.data.VerseRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyVerseWidgetProvider : AppWidgetProvider() {

  override fun onUpdate(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetIds: IntArray
  ) {
    for (appWidgetId in appWidgetIds) {
      updateAppWidget(context, appWidgetManager, appWidgetId)
    }
  }

  companion object {
    const val ACTION_REFRESH_WIDGET = "com.example.widget.ACTION_REFRESH_DAILY_WIDGET"

    fun updateAppWidget(
      context: Context,
      appWidgetManager: AppWidgetManager,
      appWidgetId: Int
    ) {
      try {
        val verse = VerseRepository.getDailyVerse()
        val sdf = SimpleDateFormat("EEEE, d 'de' MMMM", Locale("es", "ES"))
        val formattedDate = sdf.format(Date()).replaceFirstChar { it.uppercase() }

        val views = RemoteViews(context.packageName, R.layout.widget_daily_verse).apply {
          setTextViewText(R.id.widget_date, formattedDate)
          setTextViewText(R.id.widget_god_says, "«${verse.godSaysToday}»")
          setTextViewText(R.id.widget_verse_text, verse.text)
          setTextViewText(R.id.widget_citation, "— ${verse.citation}")

          // Intent to launch MainActivity when clicking anywhere on the widget
          val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra("TARGET_VERSE_ID", verse.id)
          }

          val pendingIntent = PendingIntent.getActivity(
            context,
            appWidgetId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
          )

          setOnClickPendingIntent(R.id.widget_root, pendingIntent)
        }

        appWidgetManager.updateAppWidget(appWidgetId, views)
      } catch (_: Throwable) {}
    }

    fun updateAllWidgets(context: Context) {
      try {
        val appWidgetManager = AppWidgetManager.getInstance(context) ?: return
        val thisWidget = ComponentName(context, DailyVerseWidgetProvider::class.java)
        val allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget) ?: return
        if (allWidgetIds.isNotEmpty()) {
          for (widgetId in allWidgetIds) {
            updateAppWidget(context, appWidgetManager, widgetId)
          }
        }
      } catch (_: Throwable) {}
    }
  }

  override fun onReceive(context: Context, intent: Intent?) {
    super.onReceive(context, intent)
    if (intent?.action == ACTION_REFRESH_WIDGET ||
      intent?.action == Intent.ACTION_BOOT_COMPLETED ||
      intent?.action == Intent.ACTION_TIME_CHANGED ||
      intent?.action == Intent.ACTION_DATE_CHANGED ||
      intent?.action == Intent.ACTION_TIMEZONE_CHANGED
    ) {
      updateAllWidgets(context)
    }
  }
}
