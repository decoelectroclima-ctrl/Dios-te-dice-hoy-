package com.example.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.VolumeMute
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.GranateButton
import com.example.ui.theme.GranateButtonBorderDark
import com.example.ui.theme.WinePrimary
import com.example.util.HeartbeatPlayer

@Composable
fun SplashScreen(
  onFinish: () -> Unit,
  modifier: Modifier = Modifier
) {
  val haptic = LocalHapticFeedback.current
  val alpha = remember { Animatable(0f) }
  val scale = remember { Animatable(1.05f) }

  // Heartbeat audio synthesis player
  val heartbeatPlayer = remember {
    HeartbeatPlayer { isLub ->
      try {
        if (isLub) {
          haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
      } catch (_: Throwable) {}
    }
  }
  var isMuted by remember { mutableStateOf(false) }

  // Cleanup audio upon navigating away
  DisposableEffect(Unit) {
    onDispose {
      heartbeatPlayer.release()
    }
  }

  // Heartbeat sound, visual pulse animation, and haptics
  LaunchedEffect(Unit) {
    // 1. Start audio heartbeats of Christ immediately at 66 BPM with full volume
    heartbeatPlayer.setVolume(1.0f)
    heartbeatPlayer.start(bpm = 66)

    // 2. Initial sacred haptic beat
    try {
      haptic.performHapticFeedback(HapticFeedbackType.LongPress)
    } catch (_: Throwable) {}

    // 3. Visual fade-in and subtle zoom
    alpha.animateTo(
      targetValue = 1f,
      animationSpec = tween(durationMillis = 800)
    )
    scale.animateTo(
      targetValue = 1.0f,
      animationSpec = tween(durationMillis = 4000, easing = LinearEasing)
    )

    // 4. Conclude intro automatically after user hears heartbeats
    heartbeatPlayer.stop()
    heartbeatPlayer.release()
    onFinish()
  }


  fun handleEnter() {
    heartbeatPlayer.stop()
    heartbeatPlayer.release()
    onFinish()
  }

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(Color(0xFF090B10))
      .clickable { handleEnter() }
  ) {
    // Majestic Painting Image of Cristo de San Juan de la Cruz
    Image(
      painter = painterResource(id = R.drawable.cristo_intro),
      contentDescription = "Cristo de San Juan de la Cruz",
      modifier = Modifier
        .fillMaxSize()
        .scale(scale.value)
        .alpha(alpha.value),
      contentScale = ContentScale.Crop
    )

    // Dark gradient overlays for sacred contrast
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(
          Brush.verticalGradient(
            colors = listOf(
              Color(0xBB000000),
              Color.Transparent,
              Color.Transparent,
              Color(0xF5090B10)
            )
          )
        )
    )

    // Top Bar with Audio Toggle and Enter Button
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(horizontal = 16.dp, vertical = 12.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Heartbeat audio status & mute toggle
      Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color(0x66000000),
        border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.4f)),
        modifier = Modifier.clickable {
          isMuted = !isMuted
          if (isMuted) {
            heartbeatPlayer.setVolume(0.0f)
          } else {
            heartbeatPlayer.setVolume(1.0f)
          }
        }
      ) {
        Row(
          modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = if (isMuted) Icons.Default.VolumeMute else Icons.Default.VolumeUp,
            contentDescription = "Audio de latidos",
            tint = if (isMuted) Color.White.copy(alpha = 0.5f) else GoldSecondary,
            modifier = Modifier.size(16.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = if (isMuted) "Silenciado" else "Latidos de Cristo",
            color = Color.White.copy(alpha = 0.9f),
            style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp)
          )
        }
      }

      // Enter Button
      Button(
        onClick = { handleEnter() },
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = GranateButton,
          contentColor = Color.White
        ),
        border = androidx.compose.foundation.BorderStroke(1.2.dp, GranateButtonBorderDark.copy(alpha = 0.85f))
      ) {
        Text(
          text = "Entrar",
          style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold, color = Color.White)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = null,
          tint = Color.White,
          modifier = Modifier.size(14.dp)
        )
      }
    }


    // Bottom solemn caption
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.BottomCenter)
        .padding(horizontal = 24.dp, vertical = 28.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Surface(
        shape = RoundedCornerShape(50.dp),
        color = Color(0x44000000),
        border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.6f))
      ) {
        Text(
          text = "✝ Cristo de San Juan de la Cruz",
          color = GoldSecondary,
          style = MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
          ),
          modifier = Modifier.padding(horizontal = 14.dp, vertical = 5.dp)
        )
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = "«En la Cruz está la vida y el consuelo, y ella sola es el camino para el cielo»",
        style = MaterialTheme.typography.bodyMedium.copy(
          fontFamily = FontFamily.Serif,
          fontStyle = FontStyle.Italic,
          lineHeight = 22.sp
        ),
        color = Color.White.copy(alpha = 0.95f),
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = "— San Juan de la Cruz",
        style = MaterialTheme.typography.labelSmall,
        color = Color.White.copy(alpha = 0.75f)
      )

      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = "Dios Te Dice Hoy",
        style = MaterialTheme.typography.titleLarge.copy(
          fontFamily = FontFamily.Serif,
          fontWeight = FontWeight.Bold,
          letterSpacing = 2.sp
        ),
        color = GoldSecondary
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = "Toca la pantalla para entrar",
        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
        color = Color.White.copy(alpha = 0.5f)
      )
    }
  }
}
