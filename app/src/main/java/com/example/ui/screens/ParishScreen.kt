package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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

  val filteredParishes = remember(searchQuery, filterOnlyAdoration) {
    ParishRepository.searchParishes(searchQuery, filterOnlyAdoration)
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
      placeholder = { Text("Buscar parroquia, ciudad o barrio...") },
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

    Spacer(modifier = Modifier.height(10.dp))

    // Button to search nearby churches on Google Maps
    Button(
      onClick = {
        haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
        ParishRepository.openNearbyChurchesInGoogleMaps(context)
        scope.launch {
          snackbarHostState.showSnackbar("Abriendo Google Maps para buscar iglesias cercanas...")
        }
      },
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      colors = ButtonDefaults.buttonColors(
        containerColor = WinePrimary,
        contentColor = Color.White
      ),
      shape = RoundedCornerShape(12.dp)
    ) {
      Icon(imageVector = Icons.Default.NearMe, contentDescription = null, modifier = Modifier.size(18.dp), tint = Color.White)
      Spacer(modifier = Modifier.width(8.dp))
      Text("Buscar iglesias católicas cerca de mí en Google Maps", color = Color.White, fontWeight = FontWeight.Bold)
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Filter Chips
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .widthIn(max = 600.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      FilterChip(
        selected = !filterOnlyAdoration,
        onClick = { filterOnlyAdoration = false },
        label = { Text("Todas (${ParishRepository.getAllParishes().size})") },
        colors = FilterChipDefaults.filterChipColors(
          selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
          selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
      )

      FilterChip(
        selected = filterOnlyAdoration,
        onClick = { filterOnlyAdoration = !filterOnlyAdoration },
        label = { Text("Con Adoración Eucarística ✨") },
        colors = FilterChipDefaults.filterChipColors(
          selectedContainerColor = GoldSecondary.copy(alpha = 0.2f),
          selectedLabelColor = GoldSecondary
        )
      )
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Parishes list
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .widthIn(max = 600.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      items(filteredParishes, key = { it.id }) { parish ->
        Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(18.dp),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.Top
            ) {
              Column(modifier = Modifier.weight(1f)) {
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
              }

              OutlinedButton(
                onClick = {
                  ParishRepository.openInGoogleMaps(context, parish)
                  scope.launch {
                    snackbarHostState.showSnackbar("Abriendo ${parish.name} en Google Maps...")
                  }
                },
                shape = RoundedCornerShape(10.dp)
              ) {
                Icon(
                  imageVector = Icons.Default.LocationOn,
                  contentDescription = null,
                  modifier = Modifier.size(16.dp),
                  tint = WinePrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Mapa", fontSize = 12.sp)
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
                  Icon(imageVector = Icons.Default.Schedule, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.primary)
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
                  text = "• Domingos: ${parish.sundayMasses.joinToString(", ")}",
                  style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                  color = MaterialTheme.colorScheme.onSurface
                )
              }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Confesiones
            Row(verticalAlignment = Alignment.CenterVertically) {
              Text("🕊️", fontSize = 14.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = "Confesiones: ${parish.confessionHours}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
              )
            }

            // Adoración si existe
            if (parish.adorationHours != null) {
              Spacer(modifier = Modifier.height(4.dp))
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text("✨", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                  text = "Adoración: ${parish.adorationHours}",
                  style = MaterialTheme.typography.labelSmall,
                  color = GoldSecondary,
                  fontWeight = FontWeight.SemiBold
                )
              }
            }
          }
        }
      }

      item { Spacer(modifier = Modifier.height(24.dp)) }
    }
  }
}
