package com.example.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.model.Parish

object ParishRepository {

  val parishes: List<Parish> = listOf(
    Parish(
      id = "catedral_primada",
      name = "Catedral Basílica Metropolitana",
      dioceseOrArea = "Centro Histórico",
      address = "Plaza Mayor / Catedral Central",
      weekdayMasses = listOf("08:30", "12:00", "19:00", "20:00"),
      saturdayMasses = listOf("09:00", "12:00", "19:30"),
      sundayMasses = listOf("09:00", "10:30", "12:00 (Mayor)", "13:30", "18:00", "19:30", "20:30"),
      confessionHours = "Diario durante todas las misas y de 10:00 a 13:00 y 17:00 a 20:00",
      adorationHours = "Jueves Eucarísticos de 10:00 a 19:00 h",
      phone = "+34 91 542 22 00",
      latitude = 40.4155,
      longitude = -3.7145
    ),
    Parish(
      id = "san_jeronimo_real",
      name = "Parroquia San Jerónimo el Real",
      dioceseOrArea = "Zona Retiro",
      address = "Calle Moreto 4",
      weekdayMasses = listOf("08:00", "10:00", "13:00", "19:00", "20:00"),
      saturdayMasses = listOf("10:00", "13:00", "19:00", "20:00"),
      sundayMasses = listOf("10:00", "11:30", "13:00", "19:00", "20:00", "21:00"),
      confessionHours = "Permanente: 30 minutos antes y durante las celebraciones",
      adorationHours = "Primeros viernes de mes y tardes de 17:00 a 19:00",
      phone = "+34 91 420 30 78",
      latitude = 40.4146,
      longitude = -3.6908
    ),
    Parish(
      id = "sagrado_corazon_jesus",
      name = "Basílica del Sagrado Corazón de Jesús",
      dioceseOrArea = "Ensanche / Centro",
      address = "Gran Vía de San Francisco 29",
      weekdayMasses = listOf("07:30", "09:00", "11:30", "19:30"),
      saturdayMasses = listOf("09:00", "12:00", "19:30"),
      sundayMasses = listOf("08:30", "10:00", "11:30", "13:00", "19:00", "20:30"),
      confessionHours = "Confesores disponibles de 09:30 a 13:00 y 17:30 a 20:30",
      adorationHours = "Exposición permanente del Santísimo Sacramento (24 Horas)",
      isAdorationChapel = true,
      phone = "+34 91 365 38 00",
      latitude = 40.4109,
      longitude = -3.7139
    ),
    Parish(
      id = "virgen_paloma",
      name = "Parroquia Virgen de la Paloma y San Pedro",
      dioceseOrArea = "Barrio La Latina",
      address = "Calle de la Paloma 1",
      weekdayMasses = listOf("09:00", "19:00"),
      saturdayMasses = listOf("09:00", "20:00"),
      sundayMasses = listOf("10:00", "11:30", "13:00", "20:00"),
      confessionHours = "Antes de cada misa y previa petición en sacristía",
      adorationHours = "Jueves de 18:00 a 19:00",
      phone = "+34 91 365 42 13",
      latitude = 40.4104,
      longitude = -3.7118
    ),
    Parish(
      id = "san_manuel_benito",
      name = "Parroquia San Manuel y San Benito",
      dioceseOrArea = "Barrio Salamanca",
      address = "Calle de Alcalá 83",
      weekdayMasses = listOf("08:30", "11:00", "13:00", "19:00", "20:00"),
      saturdayMasses = listOf("11:00", "13:00", "19:00", "20:00"),
      sundayMasses = listOf("10:00", "11:00", "12:00", "13:00", "19:00", "20:00", "21:00"),
      confessionHours = "Laborables de 10:30 a 13:30 y 18:30 a 20:30",
      adorationHours = "Capilla de adoración eucarística de lunes a viernes",
      isAdorationChapel = true,
      phone = "+34 91 435 48 35",
      latitude = 40.4208,
      longitude = -3.6872
    ),
    Parish(
      id = "santo_domingo_guzman",
      name = "Parroquia Santo Domingo de Guzmán",
      dioceseOrArea = "Zona Norte",
      address = "Avenida San Luis 14",
      weekdayMasses = listOf("09:00", "19:30"),
      saturdayMasses = listOf("09:00", "20:00"),
      sundayMasses = listOf("09:30", "11:30", "13:00", "19:30"),
      confessionHours = "Media hora antes de cada Eucaristía",
      adorationHours = "Jueves sacerdotales de 18:30 a 19:30",
      phone = "+34 91 302 11 22",
      latitude = 40.4789,
      longitude = -3.6645
    )
  )

  fun getAllParishes(): List<Parish> = parishes

  fun searchParishes(query: String, onlyAdoration: Boolean = false): List<Parish> {
    val q = query.trim().lowercase()
    return parishes.filter { parish ->
      val matchesQuery = q.isEmpty() ||
        parish.name.lowercase().contains(q) ||
        parish.address.lowercase().contains(q) ||
        parish.dioceseOrArea.lowercase().contains(q) ||
        parish.confessionHours.lowercase().contains(q)
      
      val matchesAdoration = !onlyAdoration || parish.isAdorationChapel
      
      matchesQuery && matchesAdoration
    }
  }

  /**
   * Opens the parish location in Google Maps app or browser
   */
  fun openInGoogleMaps(context: Context, parish: Parish) {
    val encodedName = Uri.encode("${parish.name}, ${parish.address}")
    val gmmIntentUri = if (parish.latitude != 0.0 && parish.longitude != 0.0) {
      Uri.parse("geo:${parish.latitude},${parish.longitude}?q=${parish.latitude},${parish.longitude}($encodedName)")
    } else {
      Uri.parse("https://www.google.com/maps/search/?api=1&query=$encodedName")
    }

    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
      setPackage("com.google.android.apps.maps")
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    try {
      context.startActivity(mapIntent)
    } catch (_: Exception) {
      // Fallback to browser or any map provider
      val webIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://www.google.com/maps/search/?api=1&query=$encodedName")
      ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      context.startActivity(webIntent)
    }
  }

  /**
   * Triggers a nearby search for Catholic churches and parishes in Google Maps
   */
  fun openNearbyChurchesInGoogleMaps(context: Context) {
    val query = Uri.encode("parroquia iglesia catolica misa")
    val gmmIntentUri = Uri.parse("geo:0,0?q=$query")

    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
      setPackage("com.google.android.apps.maps")
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    try {
      context.startActivity(mapIntent)
    } catch (_: Exception) {
      val webIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://www.google.com/maps/search/?api=1&query=$query")
      ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      context.startActivity(webIntent)
    }
  }
}
