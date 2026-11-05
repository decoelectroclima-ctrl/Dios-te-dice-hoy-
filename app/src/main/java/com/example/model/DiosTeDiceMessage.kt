package com.example.model

data class DiosTeDiceMessage(
  val id: String,
  val citation: String,
  val verseText: String,
  val godSaysToday: String,
  val modernMeaning: String,
  val practicalApplication: String,
  val virtue: String = "Paz",
  val emoji: String = "🕊️"
)
