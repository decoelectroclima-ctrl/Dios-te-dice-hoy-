package com.example.data

import com.example.model.AngelusPrayer
import com.example.model.AngelusVerse
import java.util.Calendar

object AngelusRepository {

  val angelus = AngelusPrayer(
    title = "El Ángelus",
    subtitle = "Consagración de la Encarnación al mediodía y atardecer",
    verses = listOf(
      AngelusVerse("V/. El Ángel del Señor anunció a María.", "R/. Y concibió por obra del Espíritu Santo."),
      AngelusVerse("V/. He aquí la esclava del Señor.", "R/. Hágase en mí según tu palabra."),
      AngelusVerse("V/. Y el Verbo se hizo carne.", "R/. Y habitó entre nosotros.")
    ),
    concludingPrayer = "V/. Ruega por nosotros, Santa Madre de Dios.\nR/. Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo.\n\nOremos:\nDerrama, Señor, tu gracia sobre nuestros corazones, para que habiendo conocido por el anuncio del ángel la Encarnación de tu Hijo Jesucristo, por los méritos de su Pasión y de su Cruz seamos llevados a la gloria de su Resurrección. Por Jesucristo, nuestro Señor. R/. Amén.\n\nGloria al Padre, y al Hijo, y al Espíritu Santo. Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén. (Se repite tres veces).",
    isReginaCaeli = false
  )

  val reginaCaeli = AngelusPrayer(
    title = "Regina Caeli (Reina del Cielo)",
    subtitle = "Antífona Pascual de la Resurrección (Tiempo de Pascua)",
    verses = listOf(
      AngelusVerse("V/. Reina del cielo, alégrate; aleluya.", "R/. Porque el que mereciste llevar en tu seno; aleluya."),
      AngelusVerse("V/. Resucitó como dijo; aleluya.", "R/. Ruega a Dios por nosotros; aleluya."),
      AngelusVerse("V/. Gózate y alégrate, Virgen María; aleluya.", "R/. Porque verdaderamente ha resucitado el Señor; aleluya.")
    ),
    concludingPrayer = "Oremos:\nOh Dios, que por la resurrección de tu Hijo, nuestro Señor Jesucristo, te has dignado dar la alegría al mundo entero; concédenos que por su Madre, la Virgen María, alcancemos los gozos de la vida eterna. Por el mismo Jesucristo, nuestro Señor. R/. Amén.\n\nGloria al Padre... (tres veces).",
    isReginaCaeli = true
  )

  fun getTodayPrayer(liturgicalSeason: String): AngelusPrayer {
    val isEaster = liturgicalSeason.contains("Pascua", ignoreCase = true) ||
        liturgicalSeason.contains("Pascual", ignoreCase = true)
    return if (isEaster) reginaCaeli else angelus
  }
}
