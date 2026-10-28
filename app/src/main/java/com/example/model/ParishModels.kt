package com.example.model

data class Parish(
  val id: String,
  val name: String,
  val dioceseOrArea: String,
  val address: String,
  val weekdayMasses: List<String>,
  val saturdayMasses: List<String>,
  val sundayMasses: List<String>,
  val confessionHours: String,
  val adorationHours: String? = null,
  val isAdorationChapel: Boolean = false,
  val isPerpetualAdoration: Boolean = false, // Adoración Perpetua (24 horas los 365 días)
  val liturgyOfHours: String? = null, // Oficios litúrgicos: Santo Rosario, Laudes, Vísperas
  val phone: String? = null,
  val latitude: Double = 0.0,
  val longitude: Double = 0.0,
  val distanceKm: Float? = null
)
