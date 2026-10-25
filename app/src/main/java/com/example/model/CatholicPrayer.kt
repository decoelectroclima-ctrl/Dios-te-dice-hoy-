package com.example.model

enum class PrayerCategory(val displayName: String) {
  BASICAS("Oraciones Básicas"),
  ESPIRITU_SANTO("Espíritu Santo"),
  ROSARIO("Santo Rosario"),
  DIVINA_MISERICORDIA("Divina Misericordia"),
  VIRGEN_MARIA("Virgen María"),
  SANTOS("Oraciones de Santos"),
  PROTECCION("Protección y Sanación"),
  EUCARISTIA("Jesús y Eucaristía"),
  MOMENTOS_DEL_DIA("Día y Noche"),
  DIFUNTOS("Por los Difuntos")
}

enum class PrayerPurpose(val displayName: String, val subtitle: String, val emoji: String) {
  ESPIRITU_SANTO(
    "Espíritu Santo y Dones",
    "Fuego divino, discernimiento, dones y luz para tu alma",
    "🔥"
  ),
  DIA_Y_NOCHE(
    "Comenzar y Terminar el Día",
    "Ofrecimiento matutino, bendición de alimentos y descanso en paz",
    "🌅"
  ),
  PROTECCION(
    "Protección y Amparo en la Batalla",
    "San Miguel, San Benito, Salmo 91 y Ángel Custodio",
    "🛡️"
  ),
  PAZ_INTERIOR(
    "Paz Interior y Serenidad",
    "Nada te turbe, San Francisco, abandono filial en Dios",
    "🕊️"
  ),
  PERDON_Y_MISERICORDIA(
    "Perdón y Reconciliación",
    "Acto de contrición y Coronilla de la Divina Misericordia",
    "💧"
  ),
  ALABANZA_Y_EUCARISTIA(
    "Alabanza y Santísimo Sacramento",
    "Padre Nuestro, Gloria, Credo, Comunión Espiritual",
    "✨"
  ),
  MARIA_Y_ROSARIO(
    "Virgen María y Santo Rosario",
    "Ave María, Salve, Magníficat, Acordaos, misterios y letanías",
    "🌹"
  ),
  DIFUNTOS(
    "Por los Fieles Difuntos",
    "Réquiem, Salmo De Profundis y sufragio de las almas",
    "🕯️"
  )
}

data class CatholicPrayer(
  val id: String,
  val title: String,
  val latinTitle: String? = null,
  val category: PrayerCategory,
  val purpose: PrayerPurpose,
  val content: String,
  val description: String,
  val isTraditionLatinAvailable: Boolean = false,
  val latinContent: String? = null,
  val hasCounter: Boolean = false,
  val counterTotal: Int = 10
)
