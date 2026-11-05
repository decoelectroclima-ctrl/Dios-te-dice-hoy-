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
  val collectPrayer: String = "Dios todopoderoso y eterno, aumenta en nosotros la fe, la esperanza y la caridad; y para que merezcamos alcanzar lo que prometes, concédenos amar lo que nos mandas. Por nuestro Señor Jesucristo, tu Hijo, que vive y reina contigo en la unidad del Espíritu Santo y es Dios por los siglos de los siglos. R/. Amén.",
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
  val prayersOfTheFaithful: List<String> = listOf(
    "Por la Santa Iglesia universal, el Papa, los obispos y sacerdotes: para que sean luz viva de Cristo en medio del mundo. Roguemos al Señor. — R/. Te rogamos, óyenos.",
    "Por los gobernantes y líderes sociales: para que velen con honestidad por la justicia, la paz y los más desamparados. Roguemos al Señor. — R/. Te rogamos, óyenos.",
    "Por los enfermos, los que sufren en soledad y quienes buscan a Dios con corazón sincero: para que hallen consuelo y esperanza en la Cruz redentora. Roguemos al Señor. — R/. Te rogamos, óyenos.",
    "Por nuestras familias y comunidades cristianas: para que seamos testimonio de perdón, amor fraternal y servicio generoso. Roguemos al Señor. — R/. Te rogamos, óyenos."
  ),
  val prayerOverOfferings: String = "Acepta, Señor, con bondad estas ofrendas que con devoción te presentamos; haz que este santo sacrificio nos purifique y nos una cada vez más a Cristo, nuestro Redentor. Por Jesucristo, nuestro Señor. R/. Amén.",
  val communionAntiphon: String,
  val prayerAfterCommunion: String = "Alimentados con el Cuerpo y la Sangre santísima de tu Hijo, te pedimos, Dios bondadoso, que la participación frecuente en este sacramento transforme nuestra vida y nos conceda el fruto de la redención eterna. Por Jesucristo, nuestro Señor. R/. Amén.",
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
