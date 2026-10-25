package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BibleDao {
    @Query("SELECT * FROM bible_verses WHERE version = :version")
    suspend fun getVersesByVersion(version: String): List<BibleVerseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(verses: List<BibleVerseEntity>)
}
