package com.example.model

data class SpotifyPlaylist(
  val id: String,
  val title: String,
  val description: String,
  val spotifyUrl: String,
  val category: String,
  val isCustom: Boolean = false,
  val emoji: String = "🎵"
)

object SpotifyCuratedPlaylists {

  val defaultPlaylists: List<SpotifyPlaylist> = listOf(
    SpotifyPlaylist(
      id = "gregoriano_monastico",
      title = "Canto Gregoriano Monástico",
      description = "Cantos gregorianos tradicionales de abadías benedictinas para meditación profunda, recogimiento y silencio.",
      spotifyUrl = "https://open.spotify.com/playlist/37i9dQZF1DX1qQqLwE8C5N",
      category = "Canto Gregoriano",
      emoji = "🕊️"
    ),
    SpotifyPlaylist(
      id = "adoracion_eucaristica",
      title = "Adoración Eucarística y Alabanza",
      description = "Música católica de adoración al Santísimo Sacramento, contemplación y alabanza del amor de Dios.",
      spotifyUrl = "https://open.spotify.com/playlist/37i9dQZF1DX3d5XgYx8M5a",
      category = "Adoración y Alabanza",
      emoji = "✨"
    ),
    SpotifyPlaylist(
      id = "himnos_marianos",
      title = "Música Mariana y Santo Rosario",
      description = "Himnos a la Santísima Virgen María, cantos de consagración maternal y acompañamiento para el Rosario.",
      spotifyUrl = "https://open.spotify.com/playlist/37i9dQZF1DX9uT5QjH3m6C",
      category = "Virgen María",
      emoji = "🌹"
    ),
    SpotifyPlaylist(
      id = "instrumental_oracion",
      title = "Instrumental Sagrado para Orar",
      description = "Música suave de piano, cuerdas y órgano para acompañar la lectura de la Biblia y la oración diaria.",
      spotifyUrl = "https://open.spotify.com/playlist/37i9dQZF1DX4sWSpwq3LiO",
      category = "Instrumental de Paz",
      emoji = "🎹"
    ),
    SpotifyPlaylist(
      id = "polifonia_sacra",
      title = "Polifonía y Coros Sacros",
      description = "Obras maestras de la polifonía renacentista y barroca: Tomás Luis de Victoria, Palestrina y coros catedralicios.",
      spotifyUrl = "https://open.spotify.com/playlist/37i9dQZF1DWVq1L8mJ5F6u",
      category = "Polifonía Litúrgica",
      emoji = "⛪"
    ),
    SpotifyPlaylist(
      id = "user_playlist_1",
      title = "Mi Lista de Oración",
      description = "Lista añadida por el usuario.",
      spotifyUrl = "https://open.spotify.com/playlist/08KZGp6bHAxGgS3CqpLypZ",
      category = "Personal",
      emoji = "🙏"
    )
  )
}
