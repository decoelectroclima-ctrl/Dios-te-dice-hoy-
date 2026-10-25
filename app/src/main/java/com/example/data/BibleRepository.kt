package com.example.data

import android.content.Context
import com.example.model.BibleVerse
import com.example.model.VerseCategory

class BibleRepository(context: Context) {
    private val db = AppDatabase.getDatabase(context)
    private val bibleDao = db.bibleDao()
    private val prefs = UserPreferences(context)

    suspend fun getVerses(): List<BibleVerseEntity> {
        val version = prefs.getBibleVersion()
        return bibleDao.getVersesByVersion(version)
    }

    suspend fun downloadVerses(version: String, verses: List<BibleVerseEntity>) {
        bibleDao.insertAll(verses)
    }
}
