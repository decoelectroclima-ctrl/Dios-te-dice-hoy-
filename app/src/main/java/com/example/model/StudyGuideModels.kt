package com.example.model

enum class SchemaType {
    TIMELINE, TREE, FLOW, COMPARISON, CYCLE
}

data class VerseRef(
    val book: String,
    val chapter: Int,
    val verse: Int,
    val text: String,
    val translation: String
)

data class StudyChapter(
    val number: Int,
    val title: String,
    val keyVerses: List<VerseRef>,
    val observation: String,
    val questions: List<String>,
    val application: String,
    val prayer: String,
    val schema: SchemaType
)

data class OutlineSection(
    val title: String,
    val range: String,
    val points: List<String>
)

data class StudyBook(
    val id: String,
    val name: String,
    val testament: String,
    val summary: String,
    val historicalContext: String,
    val authorAndDate: String,
    val keyThemes: List<String>,
    val outline: List<OutlineSection>,
    val chapters: List<StudyChapter>
)
