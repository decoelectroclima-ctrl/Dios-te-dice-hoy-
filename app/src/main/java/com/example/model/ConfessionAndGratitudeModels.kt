package com.example.model

data class ConfessionItem(
  val id: String,
  val text: String,
  val category: String = "Falta", // e.g. "Pensamiento", "Palabra", "Obra", "Omisión"
  val isConfessed: Boolean = false,
  val dateAdded: String
)

data class HandOfGodEntry(
  val id: String,
  val date: String,
  val text: String,
  val category: String = "Providencia" // "Bendición", "Protección", "Paz", "Providencia", "Encuentro"
)
