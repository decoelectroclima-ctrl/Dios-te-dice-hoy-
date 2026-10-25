package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.WinePrimary

@Composable
fun SpiritualLifeScreen(
    onNavigateToFreeWill: () -> Unit,
    onNavigateToHolySpirit: () -> Unit,
    onNavigateToConfession: () -> Unit,
    onNavigateToHandOfGod: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text("Vida Espiritual", style = MaterialTheme.typography.headlineMedium, color = WinePrimary)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            NavigationCard(
                title = "Apartado del Espíritu Santo",
                description = "Secuencia de Pentecostés, 7 Dones.",
                icon = "🕊️",
                onClick = onNavigateToHolySpirit
            )
        }

        item {
            NavigationCard(
                title = "El Don del Libre Albedrío",
                description = "Toca para elegir tu camino.",
                icon = "✨",
                onClick = onNavigateToFreeWill
            )
        }

        item {
            NavigationCard(
                title = "Diario de Confesión",
                description = "Examen de conciencia y Oración del Cardenal.",
                icon = "🙏",
                onClick = onNavigateToConfession
            )
        }

        item {
            NavigationCard(
                title = "La Mano de Dios en mi Día",
                description = "Anota la presencia de Dios.",
                icon = "🤲",
                onClick = onNavigateToHandOfGod
            )
        }
    }
}

@Composable
fun NavigationCard(title: String, description: String, icon: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp)
    ) {
        Row(modifier = Modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(icon, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
