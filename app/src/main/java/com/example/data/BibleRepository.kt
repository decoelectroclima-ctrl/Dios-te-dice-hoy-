package com.example.data

import android.content.Context
import com.example.model.BibleVerse
import com.example.model.VerseCategory

class BibleRepository(context: Context) {
    private val db = AppDatabase.getDatabase(context)
    private val bibleDao = db.bibleDao()
    private val prefs = UserPreferences(context)

    suspend fun getVerses(versionOverride: String? = null): List<BibleVerseEntity> {
    try {
        val version = versionOverride ?: prefs.getBibleVersion()
        val verses = bibleDao.getVersesByVersion(version)
        if (verses.isEmpty() || verses.size <= 2) {
            val fullCollection = BibleData.getAllVersesAsEntities(version)
            bibleDao.insertAll(fullCollection)
            return fullCollection
        }
        return verses
    } catch (e: Exception) {
        android.util.Log.e("BibleRepository", "Error getting verses", e)
        throw e
    }
    }

    suspend fun downloadVerses(version: String, verses: List<BibleVerseEntity>) {
        bibleDao.insertAll(verses)
    }
}
