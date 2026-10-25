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
  val phone: String? = null,
  val latitude: Double = 0.0,
  val longitude: Double = 0.0
)
