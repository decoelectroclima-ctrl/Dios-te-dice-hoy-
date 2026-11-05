package com.example.ui.screens

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.model.DiosTeDiceMessage
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary
import com.example.ui.theme.GranateButton
import com.example.ui.theme.GranateButtonDark
import com.example.ui.theme.GranateButtonBorderDark
import com.example.ui.theme.appButtonColors
import com.example.ui.theme.appButtonBorder
import com.example.ui.theme.appWineColor
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FreeWillScreen(
    snackbarHostState: SnackbarHostState? = null,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val prefs = remember { UserPreferences(context) }
    val scope = rememberCoroutineScope()

    // TTS
    val ttsHelper = remember { TextToSpeechHelper(context) }
    var isSpeaking by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose {
            ttsHelper.shutdown()
        }
    }

    // Estado del versículo abierto por libre albedrío
    val initialVerse = remember {
        val lastId = prefs.getLastFreeWillVerseId()
        val found = if (lastId != null) VerseRepository.getVerseById(lastId) else null
        found ?: VerseRepository.getRandomVerse().also {
            prefs.setLastFreeWillVerseId(it.id)
        }
    }

    var currentVerse by remember { mutableStateOf(initialVerse) }
    var isFlipping by remember { mutableStateOf(false) }
    var isFavorite by remember(currentVerse.id) {
        mutableStateOf(prefs.isVerseFavorite(currentVerse.id))
    }

    // Vibración suave al abrir la página
    fun triggerVibration() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vibratorManager?.defaultVibrator?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
            } else {
                @Suppress("DEPRECATION")
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
                @Suppress("DEPRECATION")
                vibrator?.vibrate(40)
            }
        } catch (_: Throwable) {}
    }

    // Función para abrir la Biblia al azar
    fun openBibleRandomly() {
        scope.launch {
            if (isSpeaking) {
                ttsHelper.stop()
                isSpeaking = false
            }
            triggerVibration()
            isFlipping = true
            delay(350)
            var nextVerse = VerseRepository.getRandomVerse()
            if (nextVerse.id == currentVerse.id && VerseRepository.verses.size > 1) {
                nextVerse = VerseRepository.getRandomVerse()
            }
            currentVerse = nextVerse
            prefs.setLastFreeWillVerseId(nextVerse.id)
            isFavorite = prefs.isVerseFavorite(nextVerse.id)
            delay(150)
            isFlipping = false
            snackbarHostState?.showSnackbar("📖 Abierta en: ${nextVerse.citation}")
        }
    }

    fun shareReading(msg: DiosTeDiceMessage) {
        val text = """
            📖 EL DON DEL LIBRE ALBEDRÍO 📖
            «La Palabra viva de Dios que habla a tu libertad»
            
            ${msg.citation}
            ${msg.verseText}
            
            ✨ Palabra de Dios para ti hoy:
            «${msg.godSaysToday}»
            
            💡 Reflexión:
            ${msg.modernMeaning}
            
            ⚓ Propósito:
            ${msg.practicalApplication}
            
            — Compartido desde la app Dios Te Dice Hoy
        """.trimIndent()

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Lectura de la Santa Biblia: ${msg.citation}")
            putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivity(Intent.createChooser(intent, "Compartir lectura viva"))
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(6.dp))

            // ============================================================
            // 1. INTRODUCCIÓN CATEQUÉTICA: EL DON DEL LIBRE ALBEDRÍO
            // ============================================================
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.35f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = WinePrimary.copy(alpha = 0.12f),
                            modifier = Modifier.size(46.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("⚖️", fontSize = 22.sp)
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "El Don del Libre Albedrío",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Serif
                                ),
                                color = WinePrimary
                            )
                            Text(
                                text = "«La Palabra de Dios es viva y eficaz» (Hb 4, 12)",
                                style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Dios te concedió el don del Libre Albedrío: la libertad suprema de acudir a Él con fe. Como cuando tomas la Santa Biblia entre tus manos con reverencia y la abres al azar por cualquier página, la Providencia Divina sabe con exactitud qué palabra necesita tu alma en este momento. Deja que Su Espíritu Santo te hable.",
                        style = MaterialTheme.typography.bodySmall.copy(lineHeight = 19.sp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // ============================================================
        // 2. BOTÓN INTERACTIVO: ABRIR LA BIBLIA AL AZAR
        // ============================================================
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = WinePrimary
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("📖", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Abrir la Sagrada Escritura al Azar",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = "Haz una pausa en silencio y déjate guiar por Dios",
                                style = MaterialTheme.typography.bodySmall.copy(color = Color.White.copy(alpha = 0.85f))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = { openBibleRandomly() },
                        enabled = !isFlipping,
                        colors = appButtonColors(),
                        border = appButtonBorder(),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("freewill_open_button")
                    ) {
                        Icon(
                            imageVector = if (isFlipping) Icons.Default.Refresh else Icons.Default.AutoStories,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (isFlipping) "Abriendo la Biblia con el Espíritu Santo..." else "Abrir en otra página al azar",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // ============================================================
        // 3. TARJETA PRINCIPAL: LA LECTURA VIVA ENCONTRADA
        // ============================================================
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                border = BorderStroke(1.5.dp, GoldSecondary.copy(alpha = 0.45f))
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    // Header de la lectura
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = GoldSecondary.copy(alpha = 0.2f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(currentVerse.emoji, fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "PALABRA VIVA PARA TI",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 0.8.sp
                                    ),
                                    color = WinePrimary
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = currentVerse.virtue,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Cita Bíblica
                    Text(
                        text = currentVerse.citation,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Texto Bíblico de la Escritura
                    Text(
                        text = currentVerse.verseText,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontStyle = FontStyle.Italic,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily.Serif
                        ),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Contenedor: Lo que Dios le dice a tu corazón y a tu libertad
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        WinePrimary.copy(alpha = 0.08f),
                                        GoldSecondary.copy(alpha = 0.12f)
                                    )
                                )
                            )
                            .border(1.dp, GoldSecondary.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("✨", fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Lo que Dios dice hoy a tu corazón:",
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                    color = WinePrimary
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "«${currentVerse.godSaysToday}»",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.SemiBold,
                                    lineHeight = 24.sp,
                                    fontFamily = FontFamily.Serif
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Reflexión sobre la libertad y el libre albedrío
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "💡 Para tu discernimiento y libertad:",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentVerse.modernMeaning,
                            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Propósito para obrar el bien en uso de tu libertad
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(WinePrimary.copy(alpha = 0.05f))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "⚓ Decisión libre para hoy:",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = WinePrimary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentVerse.practicalApplication,
                            style = MaterialTheme.typography.bodySmall.copy(lineHeight = 18.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                    Spacer(modifier = Modifier.height(10.dp))

                    // Botones de acción: Audio, Favorito, Compartir
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            // Audio TTS
                            IconButton(
                                onClick = {
                                    if (isSpeaking) {
                                        ttsHelper.stop()
                                        isSpeaking = false
                                    } else {
                                        val speech = "${currentVerse.citation}. ${currentVerse.verseText}. Lo que Dios dice a tu corazón hoy: ${currentVerse.godSaysToday}. Propósito: ${currentVerse.practicalApplication}"
                                        ttsHelper.speak(speech) { isSpeaking = false }
                                        isSpeaking = true
                                    }
                                },
                                modifier = Modifier.testTag("freewill_tts_button")
                            ) {
                                Icon(
                                    imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                                    contentDescription = if (isSpeaking) "Detener audio" else "Escuchar lectura",
                                    tint = if (isSpeaking) appWineColor() else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            // Favorito
                            IconButton(
                                onClick = {
                                    val newFav = prefs.toggleFavoriteVerse(currentVerse.id)
                                    isFavorite = newFav
                                    scope.launch {
                                        snackbarHostState?.showSnackbar(
                                            if (newFav) "❤️ Pasaje guardado en favoritos" else "Pasaje eliminado de favoritos"
                                        )
                                    }
                                },
                                modifier = Modifier.testTag("freewill_favorite_button")
                            ) {
                                Icon(
                                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                    contentDescription = "Favorito",
                                    tint = if (isFavorite) appWineColor() else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            // Compartir
                            IconButton(
                                onClick = { shareReading(currentVerse) },
                                modifier = Modifier.testTag("freewill_share_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "Compartir pasaje",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        // Abrir otra vez
                        Button(
                            onClick = { openBibleRandomly() },
                            shape = RoundedCornerShape(12.dp),
                            colors = appButtonColors(),
                            border = appButtonBorder(),
                            modifier = Modifier.testTag("freewill_another_button")
                        ) {
                            Icon(imageVector = Icons.Default.Casino, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.White)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Otra página", color = Color.White, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // ============================================================
        // 4. ORACIÓN DE SAN IGNACIO DE LOYOLA: ENTREGA DE LA LIBERTAD
        // ============================================================
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 600.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
                ),
                border = BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.25f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🕊️", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Oración de Entrega del Libre Albedrío",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Serif
                            ),
                            color = appWineColor()
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "San Ignacio de Loyola (Suscipe, Domine):",
                        style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "«Tomad, Señor, y recibid toda mi libertad, mi memoria, mi entendimiento y toda mi voluntad; todo mi haber y mi poseer. Vos me lo disteis, a Vos, Señor, lo torno; todo es vuestro, disponed de ello a toda vuestra voluntad. Dadme vuestro amor y gracia, que ésta me basta. Amén.»",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            lineHeight = 22.sp,
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Serif
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}
