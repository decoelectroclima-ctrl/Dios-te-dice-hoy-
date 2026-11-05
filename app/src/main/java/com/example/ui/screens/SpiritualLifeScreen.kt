package com.example.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.GranateButton
import com.example.ui.theme.GranateButtonDark
import com.example.ui.theme.GranateButtonBorderDark
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.appWineColor
import com.example.util.HeartbeatPlayer

@Composable
fun SpiritualLifeScreen(
    onNavigateToViaCrucis: () -> Unit,
    onNavigateToRosary: () -> Unit,
    onNavigateToCoronilla: () -> Unit,
    onNavigateToNovenas: () -> Unit,
    onNavigateToAngelus: () -> Unit,
    onNavigateToEucharisticAdoration: () -> Unit,
    onNavigateToHolySpirit: () -> Unit,
    onNavigateToConfession: () -> Unit,
    onNavigateToHandOfGod: () -> Unit,
    onNavigateToSpotify: () -> Unit,
    onNavigateToFreeWill: () -> Unit,
    modifier: Modifier = Modifier
) {
    val heartbeatPlayer = remember { HeartbeatPlayer() }
    var isHeartbeatPlaying by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose {
            heartbeatPlayer.release()
        }
    }

    val infiniteTransition = rememberInfiniteTransition(label = "spiritual_heartbeat_pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isHeartbeatPlaying) 1.25f else 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(if (isHeartbeatPlaying) 450 else 900),
            repeatMode = RepeatMode.Reverse
        ),
        label = "spiritual_heartbeat_scale"
    )

    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                text = "Vida Espiritual",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                ),
                color = WinePrimary
            )
            Text(
                text = "Devociones católicas, sacramentos y contemplación",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        // ============================================================
        // EXPERIENCIA CONTEMPLATIVA: LATIDO DEL SAGRADO CORAZÓN
        // ============================================================
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(1.dp, if (isHeartbeatPlaying) WinePrimary else MaterialTheme.colorScheme.outlineVariant)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .scale(pulseScale)
                                .clip(CircleShape)
                                .background(if (isHeartbeatPlaying) WinePrimary.copy(alpha = 0.2f) else MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(if (isHeartbeatPlaying) "❤️‍🔥" else "🤍", fontSize = 24.sp)
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Latido del Sagrado Corazón de Jesús",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Serif
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (isHeartbeatPlaying) "Sintiendo la paz del Señor (68 BPM)..." else "Tómate 2 minutos de sosiego y contemplación",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isHeartbeatPlaying) WinePrimary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "«Aprended de mí, que soy manso y humilde de corazón, y hallaréis descanso para vuestras almas.» (Mt 11, 29). Cierra los ojos y medita en Su amor constante.",
                        style = MaterialTheme.typography.bodySmall,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = {
                            if (isHeartbeatPlaying) {
                                heartbeatPlayer.stop()
                                isHeartbeatPlaying = false
                            } else {
                                heartbeatPlayer.start(68)
                                isHeartbeatPlaying = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("spiritual_heartbeat_button"),
                        colors = appButtonColors(),
                        border = appButtonBorder(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = if (isHeartbeatPlaying) Icons.Default.Stop else Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isHeartbeatPlaying) "Pausar Latido Contemplativo" else "Escuchar Latido del Sagrado Corazón",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        item {
            NavigationCard(
                title = "El Santo Rosario Guiado",
                description = "Decenario con audio en español cuenta por cuenta y misterios del día.",
                icon = "📿",
                onClick = onNavigateToRosary
            )
        }

        item {
            NavigationCard(
                title = "La Coronilla de la Divina Misericordia",
                description = "Rezo guiado cuenta por cuenta con audio en español, oración de las 3:00 PM y promesas.",
                icon = "❤️‍🔥",
                onClick = onNavigateToCoronilla
            )
        }

        item {
            NavigationCard(
                title = "49 Novenas Católicas con Recordatorio",
                description = "Catálogo completo de 49 novenas de 9 días con seguimiento de progreso y alarma diaria.",
                icon = "🕯️",
                onClick = onNavigateToNovenas
            )
        }

        item {
            NavigationCard(
                title = "El Santo Viacrucis",
                description = "Las 14 Estaciones de la Cruz con meditaciones, lecturas bíblicas y audio.",
                icon = "✝️",
                onClick = onNavigateToViaCrucis
            )
        }

        item {
            NavigationCard(
                title = "El Don del Libre Albedrío",
                description = "Abre la Santa Biblia al azar: la Palabra viva de Dios para tu alma en este momento.",
                icon = "📖",
                onClick = onNavigateToFreeWill
            )
        }

        item {
            NavigationCard(
                title = "El Ángelus y Regina Caeli",
                description = "Pausa mariana a las 12:00h y 18:00h con versículos responsoriales y campanas.",
                icon = "🔔",
                onClick = onNavigateToAngelus
            )
        }

        item {
            NavigationCard(
                title = "Adoración y Comunión Espiritual",
                description = "Presencia real de Cristo, oración de San Alfonso de Ligorio y desagravio.",
                icon = "🍞",
                onClick = onNavigateToEucharisticAdoration
            )
        }

        item {
            NavigationCard(
                title = "Apartado del Espíritu Santo",
                description = "Oración del Cardenal Verdier, Secuencia de Pentecostés y los 7 Dones sagrados.",
                icon = "🕊️",
                onClick = onNavigateToHolySpirit
            )
        }

        item {
            NavigationCard(
                title = "Diario y Examen de Confesión",
                description = "Examen de conciencia según los Mandamientos de la Iglesia y absolución.",
                icon = "🙏",
                onClick = onNavigateToConfession
            )
        }

        item {
            NavigationCard(
                title = "La Mano de Dios en mi Día",
                description = "Cuaderno personal de gratitud y presencia divina bajo huella dactilar.",
                icon = "🤲",
                onClick = onNavigateToHandOfGod
            )
        }

        item {
            NavigationCard(
                title = "Música Sacra en Spotify",
                description = "Canto gregoriano, polifonía sacra, adoración y alabanzas católicas.",
                icon = "🎵",
                onClick = onNavigateToSpotify
            )
        }


        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun NavigationCard(title: String, description: String, icon: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(icon, fontSize = 26.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text(description, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
