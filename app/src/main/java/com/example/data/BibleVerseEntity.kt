package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bible_verses")
data class BibleVerseEntity(
    @PrimaryKey val id: String,
    val version: String, // e.g., "DHHED", "BLP", "Reina Valera"
    val citation: String,
    val text: String,
    val category: String, // Stored as string for simplicity
    val godSaysToday: String,
    val modernMeaning: String,
    val practicalApplication: String,
    val virtue: String,
    val testament: String
)
