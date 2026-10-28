package com.example.ui.screens

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Church
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ParishRepository
import com.example.model.Parish
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.util.LocationHelper
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ParishScreen(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  val scope = rememberCoroutineScope()
  val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current

  var searchQuery by remember { mutableStateOf("") }
  var filterOnlyAdoration by remember { mutableStateOf(false) }
  var filterOnlyPerpetual by remember { mutableStateOf(false) }

  // Location state
  var hasPermission by remember { mutableStateOf(LocationHelper.hasLocationPermission(context)) }
  var userLocation by remember { mutableStateOf<Pair<Double, Double>?>(null) }
  var isLocating by remember { mutableStateOf(false) }

  fun refreshLocation() {
    if (LocationHelper.hasLocationPermission(context)) {
      hasPermission = true
      isLocating = true
      val lastLoc = LocationHelper.getLastKnownLocation(context)
      if (lastLoc != null) {
        userLocation = lastLoc
      }
      LocationHelper.requestSingleLocationUpdate(context) { freshLoc ->
        userLocation = freshLoc
        isLocating = false
      }
    } else {
      hasPermission = false
    }
  }

  // Location Permission Launcher
  val locationPermissionLauncher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.RequestMultiplePermissions()
  ) { permissions ->
    val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
    val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
    if (fineGranted || coarseGranted) {
      hasPermission = true
      refreshLocation()
      scope.launch {
        snackbarHostState.showSnackbar("¡Ubicación activada! Ordenando iglesias por cercanía a ti.")
      }
    } else {
      hasPermission = false
      scope.launch {
        snackbarHostState.showSnackbar("Permiso denegado. Puedes buscar iglesias y capillas manualmente.")
      }
    }
  }

  LaunchedEffect(Unit) {
    if (hasPermission) {
      refreshLocation()
    }
  }

  val filteredParishes = remember(searchQuery, filterOnlyAdoration, filterOnlyPerpetual, userLocation) {
    ParishRepository.searchParishes(
      query = searchQuery,
      onlyAdoration = filterOnlyAdoration,
      onlyPerpetual = filterOnlyPerpetual,
      userLocation = userLocation
    )
  }

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(4.dp))

    // Search bar
    OutlinedTextField(
      value = searchQuery,
      onValueChange = { searchQuery = it },
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp)
        .testTag("parish_search_input"),
      placeholder = { Text("Buscar parroquia, adoración, ciudad...") },
      leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
      },
      trailingIcon = {
        if (searchQuery.isNotEmpty()) {
          IconButton(onClick = { searchQuery = "" }) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "Limpiar")
          }
        }
      },
      singleLine = true,
      shape = RoundedCornerShape(14.dp),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    // Location Permission Rationale or Active Status Banner
    if (!hasPermission) {
      ElevatedCard(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)
        )
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(44.dp)
              .clip(CircleShape)
              .background(WinePrimary),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Default.LocationOn,
              contentDescription = null,
              tint = Color.White,
              modifier = Modifier.size(24.dp)
            )
          }

          Spacer(modifier = Modifier.width(12.dp))

          Column(modifier = Modifier.weight(1f)) {
            Text(
              text = "Ver iglesias y Adoración a tu alrededor",
              style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
              color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
              text = "Activa los permisos de ubicación para ordenar las parroquias y capillas de Adoración Perpetua (24h) por distancia exacta a ti.",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
              onClick = {
                locationPermissionLauncher.launch(
                  arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                  )
                )
              },
              colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
              shape = RoundedCornerShape(10.dp),
              modifier = Modifier.testTag("enable_location_button")
            ) {
              Icon(imageVector = Icons.Default.MyLocation, contentDescription = null, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Activar Ubicación", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
          }
        }
      }
    } else {
      // Permission Granted: Active GPS Status
      Surface(
        modifier = Modifier
          .fillMaxWidth()
          .widthIn(max = 600.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
      ) {
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.MyLocation,
              contentDescription = null,
              tint = WinePrimary,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = if (userLocation != null) "📍 Ubicación detectada • Iglesias ordenadas por cercanía" else "📍 Obteniendo señal GPS...",
              style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
              color = MaterialTheme.colorScheme.onSurface
            )
          }

          IconButton(
            onClick = { refreshLocation() },
            modifier = Modifier.size(28.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Explore,
              contentDescription = "Actualizar posición",
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(16.dp)
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Direct Google Maps Action Buttons
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Button(
        onClick = {
          haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
          ParishRepository.openNearbyChurchesInGoogleMaps(context, userLocation, onlyPerpetual = false)
          scope.launch {
            snackbarHostState.showSnackbar("Abriendo Google Maps con iglesias y misas alrededor de ti...")
          }
        },
        modifier = Modifier.weight(1f),
        colors = ButtonDefaults.buttonColors(containerColor = WinePrimary),
        shape = RoundedCornerShape(12.dp)
      ) {
        Icon(imageVector = Icons.Default.NearMe, contentDescription = null, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("Iglesias en Maps", fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1)
      }

      Button(
        onClick = {
          haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
          ParishRepository.openNearbyChurchesInGoogleMaps(context, userLocation, onlyPerpetual = true)
          scope.launch {
            snackbarHostState.showSnackbar("Buscando capillas de Adoración Perpetua 24h en Google Maps...")
          }
        },
        modifier = Modifier.weight(1f),
        colors = ButtonDefaults.buttonColors(containerColor = GoldSecondary, contentColor = Color(0xFF2C1E00)),
        shape = RoundedCornerShape(12.dp)
      ) {
        Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("Adoración 24h Maps", fontSize = 12.sp, fontWeight = FontWeight.Bold, maxLines = 1)
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Filter Chips
    FlowRow(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      FilterChip(
        selected = !filterOnlyAdoration && !filterOnlyPerpetual,
        onClick = {
          filterOnlyAdoration = false
          filterOnlyPerpetual = false
        },
        label = { Text("Todas (${ParishRepository.getAllParishes().size})") },
        colors = FilterChipDefaults.filterChipColors(
          selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
          selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
      )

      FilterChip(
        selected = filterOnlyPerpetual,
        onClick = {
          filterOnlyPerpetual = !filterOnlyPerpetual
          if (filterOnlyPerpetual) filterOnlyAdoration = false
        },
        label = { Text("🌟 Adoración Perpetua (24h)") },
        colors = FilterChipDefaults.filterChipColors(
          selectedContainerColor = GoldSecondary.copy(alpha = 0.25f),
          selectedLabelColor = GoldSecondary
        )
      )

      FilterChip(
        selected = filterOnlyAdoration,
        onClick = {
          filterOnlyAdoration = !filterOnlyAdoration
          if (filterOnlyAdoration) filterOnlyPerpetual = false
        },
        label = { Text("✨ Exposición Eucarística") },
        colors = FilterChipDefaults.filterChipColors(
          selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
          selectedLabelColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
      )
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Parishes list
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .widthIn(max = 600.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      items(filteredParishes, key = { it.id }) { parish ->
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            // Header with title, distance badge and maps buttons
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.Top
            ) {
              Column(modifier = Modifier.weight(1f)) {
                // Perpetual adoration badge
                if (parish.isPerpetualAdoration) {
                  Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = GoldSecondary.copy(alpha = 0.2f),
                    border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.6f)),
                    modifier = Modifier.padding(bottom = 6.dp)
                  ) {
                    Text(
                      text = "🌟 CAPILLA DE ADORACIÓN PERPETUA 24H",
                      color = GoldSecondary,
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp),
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                  }
                }

                Text(
                  text = parish.name,
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  ),
                  color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                  text = parish.dioceseOrArea,
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.primary,
                  fontWeight = FontWeight.SemiBold
                )

                Text(
                  text = parish.address,
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Distance indicator if calculated
                if (parish.distanceKm != null) {
                  Spacer(modifier = Modifier.height(4.dp))
                  Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = WinePrimary.copy(alpha = 0.12f)
                  ) {
                    Text(
                      text = if (parish.distanceKm < 1.0f)
                        "📍 A ${(parish.distanceKm * 1000).toInt()} metros de ti"
                      else
                        "📍 A ${"%.1f".format(parish.distanceKm)} km de ti",
                      style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                      color = WinePrimary,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }
              }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Horarios de Misas
            Surface(
              shape = RoundedCornerShape(12.dp),
              color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
              modifier = Modifier.fillMaxWidth()
            ) {
              Column(modifier = Modifier.padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.primary
                  )
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = "Horarios de Santa Misa:",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                  )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                  text = "• Lunes a Viernes: ${parish.weekdayMasses.joinToString(", ")}",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = "• Sábados: ${parish.saturdayMasses.joinToString(", ")}",
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = "• Domingos y Festivos: ${parish.sundayMasses.joinToString(", ")}",
                  style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }

            // Adoración Eucarística Section
            if (parish.adorationHours != null) {
              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (parish.isPerpetualAdoration) GoldSecondary.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(10.dp),
                  verticalAlignment = Alignment.Top
                ) {
                  Text("✨", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Column {
                    Text(
                      text = if (parish.isPerpetualAdoration) "Adoración Eucarística Perpetua (24 Horas):" else "Adoración al Santísimo:",
                      style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = if (parish.isPerpetualAdoration) GoldSecondary else MaterialTheme.colorScheme.onSurface
                      )
                    )
                    Text(
                      text = parish.adorationHours,
                      style = MaterialTheme.typography.bodySmall,
                      color = MaterialTheme.colorScheme.onSurface
                    )
                  }
                }
              }
            }

            // Oficios Litúrgicos (Liturgia de las Horas, Rosario)
            if (parish.liturgyOfHours != null) {
              Spacer(modifier = Modifier.height(6.dp))
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
              ) {
                Icon(
                  imageVector = Icons.Default.MenuBook,
                  contentDescription = null,
                  modifier = Modifier.size(15.dp),
                  tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                  Text(
                    text = "Oficios y Oración Comunitaria:",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary
                  )
                  Text(
                    text = parish.liturgyOfHours,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                  )
                }
              }
            }

            // Confesiones
            Spacer(modifier = Modifier.height(6.dp))
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.Top
            ) {
              Text("🕊️", fontSize = 14.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Column {
                Text(
                  text = "Sacramento de la Confesión:",
                  style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                  color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                  text = parish.confessionHours,
                  style = MaterialTheme.typography.bodySmall,
                  color = MaterialTheme.colorScheme.onSurfaceVariant
                )
              }
            }

            // Action Buttons: Directions (GPS), View in Map, and Call
            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))
            Spacer(modifier = Modifier.height(10.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              OutlinedButton(
                onClick = {
                  ParishRepository.openInGoogleMaps(context, parish)
                  scope.launch {
                    snackbarHostState.showSnackbar("Abriendo ${parish.name} en Google Maps...")
                  }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.LocationOn,
                  contentDescription = null,
                  modifier = Modifier.size(16.dp),
                  tint = WinePrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Ver en Mapa", fontSize = 12.sp)
              }

              Button(
                onClick = {
                  ParishRepository.navigateToParish(context, parish)
                  scope.launch {
                    snackbarHostState.showSnackbar("Iniciando navegación GPS hacia ${parish.name}...")
                  }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = WinePrimary)
              ) {
                Icon(
                  imageVector = Icons.Default.Directions,
                  contentDescription = null,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Cómo llegar", fontSize = 12.sp, fontWeight = FontWeight.Bold)
              }

              if (parish.phone != null) {
                IconButton(
                  onClick = {
                    try {
                      val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${parish.phone}"))
                      context.startActivity(intent)
                    } catch (_: Throwable) {}
                  },
                  modifier = Modifier.size(38.dp)
                ) {
                  Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Llamar",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                  )
                }
              }
            }
          }
        }
      }

      item { Spacer(modifier = Modifier.height(28.dp)) }
    }
  }
}
