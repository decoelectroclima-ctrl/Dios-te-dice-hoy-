package com.example.model

data class ViaCrucisStation(
  val number: Int,
  val romanNumeral: String,
  val title: String,
  val latinTitle: String,
  val scriptureCitation: String,
  val scriptureText: String,
  val meditation: String,
  val prayer: String,
  val virtue: String
)

enum class RosaryMysteryType(val displayName: String, val days: String) {
  GOZOSOS("Misterios Gozosos", "Lunes y Sábados"),
  LUMINOSOS("Misterios Luminosos", "Jueves"),
  DOLOROSOS("Misterios Dolorosos", "Martes y Viernes"),
  GLORIOSOS("Misterios Gloriosos", "Miércoles y Domingos")
}

data class RosaryMystery(
  val number: Int,
  val title: String,
  val fruit: String,
  val scriptureCitation: String,
  val scriptureText: String,
  val meditation: String
)

data class RosaryGroup(
  val type: RosaryMysteryType,
  val mysteries: List<RosaryMystery>
)

data class AngelusVerse(
  val versicle: String,
  val response: String
)

data class AngelusPrayer(
  val title: String,
  val subtitle: String,
  val verses: List<AngelusVerse>,
  val concludingPrayer: String,
  val isReginaCaeli: Boolean = false
)
