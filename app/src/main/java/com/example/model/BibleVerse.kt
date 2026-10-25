package com.example.model

enum class VerseCategory(val displayName: String, val iconName: String) {
  FORTALEZA("Fortaleza", "Shield"),
  PAZ("Paz", "Spa"),
  ESPERANZA("Esperanza", "LightMode"),
  AMOR("Amor Divino", "Favorite"),
  PROTECCION("Protección", "Security"),
  FE("Fe y Confianza", "Star"),
  SANACION("Sanación", "Healing"),
  SABIDURIA("Sabiduría", "MenuBook"),
  CONSUELO("Consuelo", "WbSunny"),
  GRATITUD("Gratitud", "VolunteerActivism")
}

data class BibleVerse(
  val id: String,
  val citation: String,
  val text: String,
  val category: VerseCategory,
  val godSaysToday: String,
  val modernMeaning: String,
  val practicalApplication: String,
  val virtue: String,
  val testament: String = "Nuevo Testamento"
)
