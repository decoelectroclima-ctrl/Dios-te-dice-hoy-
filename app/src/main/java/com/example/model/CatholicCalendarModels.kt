package com.example.model

enum class CelebrationRank(val displayName: String, val badgeColor: Long) {
  SOLEMNIDAD("Solemnidad", 0xFFB71C1C), // Deep red/crimson
  FIESTA("Fiesta", 0xFFD84315),       // Warm amber/rust
  MEMORIA_OBLIGATORIA("Memoria Obligatoria", 0xFF1565C0), // Blue
  MEMORIA_LIBRE("Memoria Libre", 0xFF5E35B1),             // Purple-slate
  DOMINGO("Día del Señor", 0xFF2E7D32),                   // Liturgical Green / Gold
  FERIAL("Ferial", 0xFF546E7A)                            // Slate
}

data class CatholicCalendarDay(
  val day: Int,
  val month: Int, // 1 to 12
  val year: Int,
  val title: String,
  val saintName: String,
  val saintBiography: String,
  val saintPatronage: String,
  val rank: CelebrationRank,
  val liturgicalSeason: String,
  val liturgicalColor: LiturgicalColor,
  val isHolyDayOfObligation: Boolean = false,
  val isAbstinenceDay: Boolean = false,
  val firstReadingCitation: String,
  val firstReadingSummary: String,
  val psalmCitation: String,
  val psalmResponse: String,
  val secondReadingCitation: String? = null,
  val secondReadingSummary: String? = null,
  val gospelCitation: String,
  val gospelSummary: String,
  val dailyPrayer: String
)
