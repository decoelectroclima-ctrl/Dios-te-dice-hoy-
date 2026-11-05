package com.example.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.RemoteViews
import android.widget.Toast
import com.example.MainActivity
import com.example.R
import com.example.data.VerseRepository
import com.example.model.DiosTeDiceMessage

class DiosTeDiceWidgetProvider : AppWidgetProvider() {

    companion object {
        const val ACTION_SYNC_WIDGET = "com.example.ACTION_SYNC_WIDGET"
        private const val PREFS_NAME = "dios_te_dice_widget_prefs"
        private const val KEY_WIDGET_VERSE_ID = "current_widget_verse_id"

        /**
         * Actualiza todas las instancias del Widget colocadas en el escritorio del usuario.
         * Si newRandomVerse es true, selecciona un nuevo mensaje inspirado; de lo contrario, muestra
         * el mensaje del día o el último sincronizado.
         */
        fun updateAllWidgets(context: Context, newRandomVerse: Boolean = false): DiosTeDiceMessage {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val thisWidget = ComponentName(context, DiosTeDiceWidgetProvider::class.java)
            val allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget)

            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val verse = if (newRandomVerse) {
                val currentSavedId = prefs.getString(KEY_WIDGET_VERSE_ID, null)
                var nextVerse = VerseRepository.getRandomVerse()
                // Asegurar que si hay variedad, cambie de versículo
                if (nextVerse.id == currentSavedId && VerseRepository.verses.size > 1) {
                    nextVerse = VerseRepository.getRandomVerse()
                }
                prefs.edit().putString(KEY_WIDGET_VERSE_ID, nextVerse.id).apply()
                nextVerse
            } else {
                val savedId = prefs.getString(KEY_WIDGET_VERSE_ID, null)
                val found = if (savedId != null) VerseRepository.getVerseById(savedId) else null
                found ?: VerseRepository.getDailyVerse()
            }

            if (allWidgetIds.isNotEmpty()) {
                for (widgetId in allWidgetIds) {
                    val views = buildRemoteViews(context, widgetId, verse)
                    appWidgetManager.updateAppWidget(widgetId, views)
                }
            }

            return verse
        }

        private fun buildRemoteViews(
            context: Context,
            widgetId: Int,
            verse: DiosTeDiceMessage
        ): RemoteViews {
            val views = RemoteViews(context.packageName, R.layout.widget_daily_verse)

            views.setTextViewText(R.id.widget_badge, "🕊️ DIOS TE DICE")
            views.setTextViewText(R.id.widget_citation, "${verse.emoji} ${verse.citation}")
            views.setTextViewText(R.id.widget_verse_text, verse.verseText)
            views.setTextViewText(R.id.widget_god_says, "«${verse.godSaysToday}»")

            // 1. Clic en el cuerpo del widget abre la aplicación Dios Te Dice Hoy
            val openAppIntent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            val pendingOpenIntent = PendingIntent.getActivity(
                context,
                0,
                openAppIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.widget_root, pendingOpenIntent)

            // 2. Clic en el botón "↻ Sincronizar" dispara ACTION_SYNC_WIDGET
            val syncIntent = Intent(context, DiosTeDiceWidgetProvider::class.java).apply {
                action = ACTION_SYNC_WIDGET
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
            }
            val pendingSyncIntent = PendingIntent.getBroadcast(
                context,
                widgetId,
                syncIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.btn_sync, pendingSyncIntent)

            return views
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        updateAllWidgets(context, newRandomVerse = false)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_SYNC_WIDGET || intent.action == AppWidgetManager.ACTION_APPWIDGET_UPDATE) {
            val isManualSync = intent.action == ACTION_SYNC_WIDGET
            val updatedVerse = updateAllWidgets(context, newRandomVerse = isManualSync)

            if (isManualSync) {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(
                        context,
                        "🕊️ Sincronizado: ${updatedVerse.citation}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
