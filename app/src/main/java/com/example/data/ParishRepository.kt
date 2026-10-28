package com.example.data

import android.content.Context
import android.content.Intent
import android.location.Location
import android.net.Uri
import com.example.model.Parish

object ParishRepository {

  val parishes: List<Parish> = listOf(
    Parish(
      id = "capilla_adoracion_perpetua_manuel_becerra",
      name = "Capilla de Adoración Eucarística Perpetua (La Encarnación)",
      dioceseOrArea = "Madrid Centro - Barrio de Salamanca",
      address = "Calle de Alcalá 168, Madrid",
      weekdayMasses = listOf("08:30", "12:30", "19:30"),
      saturdayMasses = listOf("09:00", "19:30"),
      sundayMasses = listOf("10:00", "12:00", "13:00", "20:00"),
      confessionHours = "Permanente durante el día (9:00 a 13:00 y 17:00 a 21:00)",
      adorationHours = "Adoración Perpetua: Abierto las 24 horas del día, los 365 días del año",
      isAdorationChapel = true,
      isPerpetualAdoration = true,
      liturgyOfHours = "Laudes: 08:00 • Santo Rosario: 18:45 • Vísperas: 19:15 • Completas: 22:00",
      phone = "+34 91 574 12 34",
      latitude = 40.4298,
      longitude = -3.6698
    ),
    Parish(
      id = "basilica_sagrado_corazon",
      name = "Basílica del Sagrado Corazón de Jesús (Adoración Nacional)",
      dioceseOrArea = "Centro Histórico",
      address = "Gran Vía de San Francisco 29, Madrid",
      weekdayMasses = listOf("07:30", "09:00", "11:30", "19:30"),
      saturdayMasses = listOf("09:00", "12:00", "19:30"),
      sundayMasses = listOf("08:30", "10:00", "11:30", "13:00", "19:00", "20:30"),
      confessionHours = "Confesores de guardia de 09:30 a 13:00 y 17:30 a 20:30",
      adorationHours = "Adoración Eucarística Diurna y Nocturna Continua (24 Horas)",
      isAdorationChapel = true,
      isPerpetualAdoration = true,
      liturgyOfHours = "Oficio de Lectura: 07:00 • Santo Rosario diario: 18:30 • Bendición con el Santísimo: 20:15",
      phone = "+34 91 365 38 00",
      latitude = 40.4109,
      longitude = -3.7139
    ),
    Parish(
      id = "catedral_santa_maria_almudena",
      name = "Santa Iglesia Catedral Metropolitana de Santa María la Real de la Almudena",
      dioceseOrArea = "Archidiócesis de Madrid",
      address = "Calle de Bailén 10, Madrid",
      weekdayMasses = listOf("09:00", "12:00 (Mayor)", "19:00", "20:00"),
      saturdayMasses = listOf("09:00", "12:00", "19:00", "20:00"),
      sundayMasses = listOf("10:30", "12:00 (Misa Capitular)", "13:30", "18:00", "19:00", "20:00"),
      confessionHours = "Lunes a domingo en la Capilla del Santísimo de 10:00 a 13:30 y 17:00 a 20:00",
      adorationHours = "Capilla del Santísimo Sacramento: Lunes a Domingo de 09:00 a 20:30 h",
      isAdorationChapel = true,
      isPerpetualAdoration = false,
      liturgyOfHours = "Laudes corales: 09:30 • Santo Rosario: 18:30 • Vísperas solemnes: 19:30",
      phone = "+34 91 542 22 00",
      latitude = 40.4155,
      longitude = -3.7145
    ),
    Parish(
      id = "parroquia_san_jeronimo_real",
      name = "Parroquia San Jerónimo el Real («Los Jerónimos»)",
      dioceseOrArea = "Zona Prado - Retiro",
      address = "Calle Moreto 4, Madrid",
      weekdayMasses = listOf("08:00", "10:00", "13:00", "19:00", "20:00"),
      saturdayMasses = listOf("10:00", "13:00", "19:00", "20:00"),
      sundayMasses = listOf("10:00", "11:30", "13:00", "19:00", "20:00", "21:00"),
      confessionHours = "Permanente: 30 minutos antes y durante todas las celebraciones",
      adorationHours = "Primeros viernes de mes de 17:00 a 20:00 con hora santa",
      isAdorationChapel = false,
      isPerpetualAdoration = false,
      liturgyOfHours = "Santo Rosario meditativo: 19:30",
      phone = "+34 91 420 30 78",
      latitude = 40.4146,
      longitude = -3.6908
    ),
    Parish(
      id = "capilla_adoracion_perpetua_san_sebastian",
      name = "Capilla de Adoración Perpetua Parroquia San Sebastián",
      dioceseOrArea = "Centro / Barrio de las Letras",
      address = "Calle de Atocha 39, Madrid",
      weekdayMasses = listOf("09:00", "11:00", "19:00", "20:00"),
      saturdayMasses = listOf("09:00", "19:00", "20:00"),
      sundayMasses = listOf("10:00", "11:30", "13:00", "19:00", "20:30"),
      confessionHours = "De 10:00 a 13:00 y de 18:00 a 20:30",
      adorationHours = "Adoración Eucarística Perpetua: Turnos de adoración 24 horas ininterrumpidas",
      isAdorationChapel = true,
      isPerpetualAdoration = true,
      liturgyOfHours = "Coronilla de la Divina Misericordia: 15:00 • Rosario: 18:30 • Completas: 22:30",
      phone = "+34 91 429 27 58",
      latitude = 40.4132,
      longitude = -3.7009
    ),
    Parish(
      id = "santuario_inmaculado_corazon_maria",
      name = "Santuario Inmaculado Corazón de María (PP. Claretianos)",
      dioceseOrArea = "Chamberí / Argüelles",
      address = "Calle Ferraz 74, Madrid",
      weekdayMasses = listOf("07:30", "09:00", "11:00", "12:00", "19:00", "20:00"),
      saturdayMasses = listOf("09:00", "11:00", "12:00", "19:00", "20:00"),
      sundayMasses = listOf("08:00", "09:00", "10:30", "12:00", "13:15", "19:00", "20:30"),
      confessionHours = "Atención continuada en confesionarios de 08:30 a 13:00 y 17:30 a 20:30",
      adorationHours = "Jueves Eucarísticos y Horas Santas los sábados tarde",
      isAdorationChapel = true,
      isPerpetualAdoration = false,
      liturgyOfHours = "Laudes: 08:30 • Rezo del Santo Rosario: 18:30 • Vísperas: 19:30",
      phone = "+34 91 547 28 00",
      latitude = 40.4326,
      longitude = -3.7198
    ),
    Parish(
      id = "parroquia_san_manuel_benito",
      name = "Parroquia San Manuel y San Benito (PP. Agustinos)",
      dioceseOrArea = "Barrio de Salamanca / Retiro",
      address = "Calle de Alcalá 83, Madrid",
      weekdayMasses = listOf("08:30", "11:00", "13:00", "19:00", "20:00"),
      saturdayMasses = listOf("11:00", "13:00", "19:00", "20:00"),
      sundayMasses = listOf("10:00", "11:00", "12:00", "13:00", "19:00", "20:00", "21:00"),
      confessionHours = "Laborables de 10:30 a 13:30 y 18:30 a 20:30 en templo y cripta",
      adorationHours = "Capilla de Adoración Eucarística expuesta de 09:00 a 21:00 h",
      isAdorationChapel = true,
      isPerpetualAdoration = false,
      liturgyOfHours = "Rosario: 18:30 • Vísperas cantadas los domingos: 19:30",
      phone = "+34 91 435 48 35",
      latitude = 40.4208,
      longitude = -3.6872
    ),
    Parish(
      id = "virgen_de_la_paloma",
      name = "Real Parroquia Virgen de la Paloma y San Pedro el Real",
      dioceseOrArea = "La Latina / Centro",
      address = "Calle de la Paloma 1, Madrid",
      weekdayMasses = listOf("09:00", "19:00", "20:00"),
      saturdayMasses = listOf("09:00", "20:00"),
      sundayMasses = listOf("10:00", "11:30", "13:00", "20:00"),
      confessionHours = "Treinta minutos antes de cada Eucaristía y a petición personal",
      adorationHours = "Jueves de Adoración Eucarística de 18:00 a 19:45 h",
      isAdorationChapel = false,
      isPerpetualAdoration = false,
      liturgyOfHours = "Santo Rosario a la Virgen de la Paloma: 19:30",
      phone = "+34 91 365 42 13",
      latitude = 40.4104,
      longitude = -3.7118
    )
  )

  fun getAllParishes(): List<Parish> = parishes

  /**
   * Filter and sort parishes based on search query, filters, and user GPS coordinates
   */
  fun searchParishes(
    query: String,
    onlyAdoration: Boolean = false,
    onlyPerpetual: Boolean = false,
    userLocation: Pair<Double, Double>? = null
  ): List<Parish> {
    val q = query.trim().lowercase()

    val filtered = parishes.filter { parish ->
      val matchesQuery = q.isEmpty() ||
        parish.name.lowercase().contains(q) ||
        parish.address.lowercase().contains(q) ||
        parish.dioceseOrArea.lowercase().contains(q) ||
        parish.confessionHours.lowercase().contains(q) ||
        (parish.liturgyOfHours?.lowercase()?.contains(q) == true)

      val matchesAdoration = !onlyAdoration || parish.isAdorationChapel || parish.isPerpetualAdoration
      val matchesPerpetual = !onlyPerpetual || parish.isPerpetualAdoration

      matchesQuery && matchesAdoration && matchesPerpetual
    }

    if (userLocation != null) {
      val (userLat, userLon) = userLocation
      return filtered.map { parish ->
        if (parish.latitude != 0.0 && parish.longitude != 0.0) {
          val results = FloatArray(1)
          Location.distanceBetween(
            userLat,
            userLon,
            parish.latitude,
            parish.longitude,
            results
          )
          val distanceKm = results[0] / 1000f
          parish.copy(distanceKm = distanceKm)
        } else {
          parish
        }
      }.sortedWith(
        compareBy(
          { it.distanceKm ?: Float.MAX_VALUE },
          { !it.isPerpetualAdoration }
        )
      )
    }

    return filtered
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
   * Starts turn-by-turn GPS navigation to the chosen parish
   */
  fun navigateToParish(context: Context, parish: Parish) {
    val uri = if (parish.latitude != 0.0 && parish.longitude != 0.0) {
      Uri.parse("google.navigation:q=${parish.latitude},${parish.longitude}")
    } else {
      val encodedAddress = Uri.encode("${parish.name}, ${parish.address}")
      Uri.parse("google.navigation:q=$encodedAddress")
    }

    val navIntent = Intent(Intent.ACTION_VIEW, uri).apply {
      setPackage("com.google.android.apps.maps")
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    try {
      context.startActivity(navIntent)
    } catch (_: Exception) {
      openInGoogleMaps(context, parish)
    }
  }

  /**
   * Triggers a nearby search around the user's GPS position in Google Maps
   * for Catholic churches, Perpetual Adoration chapels, and Holy Masses
   */
  fun openNearbyChurchesInGoogleMaps(context: Context, userLocation: Pair<Double, Double>? = null, onlyPerpetual: Boolean = false) {
    val searchTerms = if (onlyPerpetual) {
      "capilla adoracion perpetua santisimo eucaristia"
    } else {
      "iglesia catolica parroquia misa adoracion perpetua"
    }

    val query = Uri.encode(searchTerms)
    val gmmIntentUri = if (userLocation != null) {
      Uri.parse("geo:${userLocation.first},${userLocation.second}?q=$query")
    } else {
      Uri.parse("geo:0,0?q=$query")
    }

    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
      setPackage("com.google.android.apps.maps")
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    try {
      context.startActivity(mapIntent)
    } catch (_: Exception) {
      val webUri = if (userLocation != null) {
        Uri.parse("https://www.google.com/maps/search/$query/@${userLocation.first},${userLocation.second},14z")
      } else {
        Uri.parse("https://www.google.com/maps/search/?api=1&query=$query")
      }
      val webIntent = Intent(Intent.ACTION_VIEW, webUri).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      context.startActivity(webIntent)
    }
  }
}
