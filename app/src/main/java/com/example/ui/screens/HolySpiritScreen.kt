package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.GoldSecondary

@Composable
fun HolySpiritScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Apartado del Espíritu Santo",
                style = MaterialTheme.typography.headlineMedium,
                color = WinePrimary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Ven, Espíritu Santo, llena los corazones de tus fieles y enciende en ellos el fuego de tu amor.",
                        style = MaterialTheme.typography.bodyLarge,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }

        item {
            Text("Invocación", style = MaterialTheme.typography.titleMedium, color = GoldSecondary)
            Text(
                "Oh Espíritu Santo, Amor del Padre y del Hijo,\ninspírame siempre lo que debo pensar,\nlo que debo decir, cómo debo decirlo,\nlo que debo callar, cómo debo actuar,\nlo que debo hacer, para gloria de Dios,\nbien de las almas y mi propia santificación.\nEspíritu Santo, dame agudeza para entender,\ncapacidad para retener, método y facultad para aprender,\nlucidez para interpretar y gracia abundante para hablar.\nDame acierto al empezar, dirección al progresar\ny perfección al acabar. Amén.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        
        item {
            Text("Los 7 Dones", style = MaterialTheme.typography.titleMedium, color = GoldSecondary)
            Text(
                "Sabiduría, Entendimiento, Consejo, Fortaleza, Ciencia, Piedad y Temor de Dios.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
