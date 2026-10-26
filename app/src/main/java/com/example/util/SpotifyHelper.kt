package com.example.util

import android.content.Context
import android.content.Intent
import android.net.Uri

object SpotifyHelper {

  fun openSpotifyPlaylist(context: Context, playlistUriOrUrl: String) {
    val clean = playlistUriOrUrl.trim()
    if (clean.isEmpty()) return

    // Derive Spotify Native App URI (e.g. spotify:playlist:...)
    val spotifyUri: Uri = when {
      clean.startsWith("spotify:playlist:") -> Uri.parse(clean)
      clean.contains("open.spotify.com/playlist/") -> {
        val playlistId = clean.substringAfter("playlist/").substringBefore("?").substringBefore("/")
        Uri.parse("spotify:playlist:$playlistId")
      }
      clean.startsWith("http://") || clean.startsWith("https://") -> Uri.parse(clean)
      else -> Uri.parse("https://open.spotify.com/search/${Uri.encode(clean)}")
    }

    // Web fallback URL in case Spotify app is not installed
    val webFallbackUrl: String = when {
      clean.contains("open.spotify.com/playlist/") -> clean
      clean.startsWith("spotify:playlist:") -> {
        val id = clean.removePrefix("spotify:playlist:")
        "https://open.spotify.com/playlist/$id"
      }
      clean.startsWith("http://") || clean.startsWith("https://") -> clean
      else -> "https://open.spotify.com/search/${Uri.encode(clean)}"
    }

    // First attempt: Open official Spotify app directly
    val appIntent = Intent(Intent.ACTION_VIEW, spotifyUri).apply {
      setPackage("com.spotify.music")
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }

    try {
      context.startActivity(appIntent)
    } catch (_: Exception) {
      // Fallback: Open in browser or any app that can handle https://open.spotify.com
      val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webFallbackUrl)).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
      }
      try {
        context.startActivity(webIntent)
      } catch (_: Exception) {
        // Handled silently
      }
    }
  }

  fun sharePlaylist(context: Context, title: String, url: String) {
    val sendIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(
        Intent.EXTRA_TEXT,
        "🎵 Te comparto esta lista de música sacra en Spotify:\n«$title»\n$url\n\nCompartido desde Dios Te Dice Hoy"
      )
      type = "text/plain"
      flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    context.startActivity(Intent.createChooser(sendIntent, "Compartir lista de Spotify"))
  }
}
