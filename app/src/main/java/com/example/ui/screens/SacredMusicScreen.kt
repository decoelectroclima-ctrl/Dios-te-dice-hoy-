package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.model.SpotifyCuratedPlaylists
import com.example.model.SpotifyPlaylist
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.SpotifyHelper
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SacredMusicScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val prefs = remember { UserPreferences(context) }
  val scope = rememberCoroutineScope()

  var customPlaylists by remember { mutableStateOf(prefs.getCustomSpotifyPlaylists()) }
  var showAddDialog by remember { mutableStateOf(false) }
  var selectedCategoryFilter by remember { mutableStateOf("TODAS") }

  val allPlaylists = remember(customPlaylists, selectedCategoryFilter) {
    val combined = customPlaylists + SpotifyCuratedPlaylists.defaultPlaylists
    when (selectedCategoryFilter) {
      "TODAS" -> combined
      "MIS_LISTAS" -> customPlaylists
      else -> combined.filter { it.category.equals(selectedCategoryFilter, ignoreCase = true) }
    }
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      item {
        Spacer(modifier = Modifier.height(6.dp))

        // Hero Intro Card
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp),
          shape = RoundedCornerShape(20.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
          ),
          border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.4f))
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Surface(
                shape = CircleShape,
                color = WinePrimary,
                modifier = Modifier.size(40.dp)
              ) {
                Box(contentAlignment = Alignment.Center) {
                  Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                  )
                }
              }
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = "Música Sacra en Spotify",
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                  text = "Acompaña tu oración y lectura con listas sacras",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                )
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = "Toca cualquier lista para escucharla al instante en tu aplicación de Spotify o en el reproductor web. También puedes añadir tus propias listas personales de adoración.",
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 20.sp),
              color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Add Custom Playlist Button
            Button(
              onClick = { showAddDialog = true },
              modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("add_spotify_playlist_button"),
              colors = ButtonDefaults.buttonColors(
                containerColor = WinePrimary,
                contentColor = Color.White
              ),
              shape = RoundedCornerShape(12.dp)
            ) {
              Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(18.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text("Añadir mi Lista de Spotify", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
          }
        }
      }

      // Filter Chips
      item {
        val categories = listOf(
          "TODAS" to "Todas las Listas",
          "MIS_LISTAS" to "Mis Listas (${customPlaylists.size})",
          "Canto Gregoriano" to "Gregoriano",
          "Adoración y Alabanza" to "Adoración",
          "Virgen María" to "Mariana",
          "Instrumental de Paz" to "Instrumental",
          "Polifonía Litúrgica" to "Polifonía"
        )

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          categories.take(3).forEach { (code, label) ->
            FilterChip(
              selected = selectedCategoryFilter == code,
              onClick = { selectedCategoryFilter = code },
              label = { Text(label, fontSize = 12.sp) },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = WinePrimary,
                selectedLabelColor = Color.White
              )
            )
          }
        }
      }

      // Empty State for Custom
      if (selectedCategoryFilter == "MIS_LISTAS" && customPlaylists.isEmpty()) {
        item {
          Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🎵", fontSize = 32.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = "Aún no has añadido listas personales de Spotify",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Toca el botón 'Añadir mi Lista de Spotify' para guardar tus cantos y listas favoritas.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }
          }
        }
      }

      // Playlist Items
      items(allPlaylists, key = { it.id }) { playlist ->
        Card(
          modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 600.dp)
            .testTag("playlist_card_${playlist.id}"),
          shape = RoundedCornerShape(16.dp),
          colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
          ),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
              ) {
                Surface(
                  shape = RoundedCornerShape(10.dp),
                  color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                  modifier = Modifier.size(42.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(playlist.emoji, fontSize = 20.sp)
                  }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                      text = playlist.title,
                      style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                      ),
                      color = MaterialTheme.colorScheme.onSurface
                    )
                    if (playlist.isCustom) {
                      Spacer(modifier = Modifier.width(6.dp))
                      Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = GoldSecondary
                      ) {
                        Text(
                          text = "Mi Lista",
                          fontSize = 9.sp,
                          color = Color.White,
                          fontWeight = FontWeight.Bold,
                          modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                        )
                      }
                    }
                  }

                  Text(
                    text = playlist.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                  )
                }
              }

              // Share Button
              IconButton(
                onClick = { SpotifyHelper.sharePlaylist(context, playlist.title, playlist.spotifyUrl) },
                modifier = Modifier.size(36.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.Share,
                  contentDescription = "Compartir lista",
                  tint = MaterialTheme.colorScheme.outline,
                  modifier = Modifier.size(18.dp)
                )
              }

              // Delete Button (only for custom)
              if (playlist.isCustom) {
                IconButton(
                  onClick = {
                    prefs.removeCustomSpotifyPlaylist(playlist.id)
                    customPlaylists = prefs.getCustomSpotifyPlaylists()
                    scope.launch {
                      snackbarHostState.showSnackbar("Lista «${playlist.title}» eliminada")
                    }
                  },
                  modifier = Modifier.size(36.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar lista",
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(18.dp)
                  )
                }
              }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = playlist.description,
              style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Action Button: Open in Spotify
            Button(
              onClick = {
                SpotifyHelper.openSpotifyPlaylist(context, playlist.spotifyUrl)
                scope.launch {
                  snackbarHostState.showSnackbar("Abriendo «${playlist.title}» en Spotify 🎧")
                }
              },
              modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .testTag("play_spotify_${playlist.id}"),
              colors = ButtonDefaults.buttonColors(
                containerColor = WinePrimary,
                contentColor = Color.White
              ),
              shape = RoundedCornerShape(12.dp)
            ) {
              Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = Color.White
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "Escuchar en Spotify",
                style = MaterialTheme.typography.labelLarge.copy(
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              )
              Spacer(modifier = Modifier.width(4.dp))
              Icon(
                imageVector = Icons.Default.OpenInNew,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.White.copy(alpha = 0.8f)
              )
            }
          }
        }
      }

      item {
        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }

  // --- DIALOG: AÑADIR LISTA DE SPOTIFY ---
  if (showAddDialog) {
    var titleInput by remember { mutableStateOf("") }
    var urlInput by remember { mutableStateOf("") }
    var descriptionInput by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Oración y Alabanza") }
    var inputError by remember { mutableStateOf<String?>(null) }

    AlertDialog(
      onDismissRequest = { showAddDialog = false },
      title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(Icons.Default.MusicNote, contentDescription = null, tint = WinePrimary, modifier = Modifier.size(24.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Añadir Lista de Spotify",
            style = MaterialTheme.typography.titleLarge.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif
            )
          )
        }
      },
      text = {
        Column(
          modifier = Modifier.fillMaxWidth(),
          verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          Text(
            text = "Pega el enlace o enlace compartido de cualquier lista de reproducción de Spotify:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          OutlinedTextField(
            value = titleInput,
            onValueChange = {
              titleInput = it
              inputError = null
            },
            label = { Text("Nombre de la lista (ej. Mis cantos de adoración)") },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("spotify_title_input"),
            singleLine = true
          )

          OutlinedTextField(
            value = urlInput,
            onValueChange = {
              urlInput = it
              inputError = null
            },
            label = { Text("Enlace o URI de Spotify") },
            placeholder = { Text("https://open.spotify.com/playlist/...") },
            modifier = Modifier
              .fillMaxWidth()
              .testTag("spotify_url_input"),
            singleLine = true
          )

          OutlinedTextField(
            value = descriptionInput,
            onValueChange = { descriptionInput = it },
            label = { Text("Descripción (opcional)") },
            placeholder = { Text("Canciones para la oración de la mañana") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2
          )

          if (inputError != null) {
            Text(
              text = inputError!!,
              color = MaterialTheme.colorScheme.error,
              style = MaterialTheme.typography.bodySmall
            )
          }
        }
      },
      confirmButton = {
        Button(
          onClick = {
            val title = titleInput.trim()
            val url = urlInput.trim()

            if (title.isEmpty()) {
              inputError = "Por favor ingresa un nombre para la lista"
              return@Button
            }
            if (url.isEmpty()) {
              inputError = "Por favor ingresa el enlace de Spotify"
              return@Button
            }

            val newPlaylist = SpotifyPlaylist(
              id = UUID.randomUUID().toString(),
              title = title,
              description = if (descriptionInput.trim().isNotEmpty()) descriptionInput.trim() else "Lista personalizada de Spotify",
              spotifyUrl = url,
              category = selectedCategory,
              isCustom = true,
              emoji = "🎵"
            )

            prefs.addCustomSpotifyPlaylist(newPlaylist)
            customPlaylists = prefs.getCustomSpotifyPlaylists()
            showAddDialog = false

            scope.launch {
              snackbarHostState.showSnackbar("✨ Lista «$title» guardada en tus listas de Spotify")
            }
          },
          colors = ButtonDefaults.buttonColors(
            containerColor = WinePrimary,
            contentColor = Color.White
          ),
          modifier = Modifier.testTag("save_spotify_playlist_button")
        ) {
          Text("Guardar Lista", fontWeight = FontWeight.Bold)
        }
      },
      dismissButton = {
        TextButton(onClick = { showAddDialog = false }) {
          Text("Cancelar")
        }
      }
    )
  }
}
