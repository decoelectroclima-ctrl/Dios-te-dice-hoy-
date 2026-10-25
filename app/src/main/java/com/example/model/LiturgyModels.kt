package com.example.model

enum class LiturgicalColor(val displayName: String, val hexColor: Long, val meaning: String) {
  VERDE("Verde", 0xFF2E7D32, "Esperanza y vida cristiana en el Tiempo Ordinario"),
  BLANCO("Blanco y Oro", 0xFFF9A825, "Gloria, pureza, júbilo y resurrección (Pascua, Navidad, Santos)"),
  MORADO("Morado", 0xFF6A1B9A, "Conversión, penitencia y espera (Adviento y Cuaresma)"),
  ROJO("Rojo", 0xFFC62828, "Fuego del Espíritu Santo, Pasión de Cristo y Mártires")
}

data class DailyLiturgy(
  val dayTitle: String,
  val liturgicalSeason: String,
  val liturgicalColor: LiturgicalColor,
  val celebrationName: String,
  val entranceAntiphon: String,
  val firstReadingCitation: String,
  val firstReadingText: String,
  val responsorialPsalmCitation: String,
  val responsorialPsalmResponse: String,
  val responsorialPsalmText: String,
  val secondReadingCitation: String? = null,
  val secondReadingText: String? = null,
  val gospelAcclamation: String,
  val gospelCitation: String,
  val gospelText: String,
  val communionAntiphon: String,
  val liturgicalReflection: String
)

data class OrdinaryPart(
  val id: String,
  val section: String,
  val title: String,
  val priestDialogue: String,
  val peopleResponse: String,
  val rubric: String,
  val latinTitle: String? = null,
  val latinPeopleResponse: String? = null,
  val explanation: String
)
