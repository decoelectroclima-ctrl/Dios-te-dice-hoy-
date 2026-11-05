package com.example.model

data class NovenaDay(
  val dayNumber: Int,
  val title: String,
  val meditation: String,
  val dailyPrayer: String
)

data class CatholicNovena(
  val id: String,
  val title: String,
  val saintOrAdvocation: String,
  val category: String, // "Jesucristo", "Virgen María", "Santos Intercesores", "Causas Urgentes e Imposibles", "Arcángeles y Ángeles"
  val feastDate: String,
  val description: String,
  val openingPrayer: String,
  val days: List<NovenaDay>,
  val closingPrayer: String
)

data class CoronillaStep(
  val index: Int,
  val sectionName: String,
  val beadType: String, // "INTRO", "LARGE", "SMALL", "CONCLUDING"
  val prayerTitle: String,
  val prayerText: String,
  val repetition: String
)
