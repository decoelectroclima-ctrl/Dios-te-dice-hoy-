package com.example.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.GoldSecondary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
  onFinish: () -> Unit,
  modifier: Modifier = Modifier
) {
  val alpha = remember { Animatable(0f) }
  val scale = remember { Animatable(1.04f) }

  val haptic = androidx.compose.ui.platform.LocalHapticFeedback.current

  LaunchedEffect(Unit) {
    try {
      haptic.performHapticFeedback(androidx.compose.ui.hapticfeedback.HapticFeedbackType.LongPress)
    } catch (_: Throwable) {}

    alpha.animateTo(
      targetValue = 1f,
      animationSpec = tween(durationMillis = 600)
    )
    scale.animateTo(
      targetValue = 1.0f,
      animationSpec = tween(durationMillis = 1400, easing = LinearEasing)
    )
    onFinish()
  }

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(Color(0xFF090B10))
  ) {
    // Majestic Painting Image
    Image(
      painter = painterResource(id = R.drawable.cristo_intro),
      contentDescription = "Cristo de San Juan de la Cruz",
      modifier = Modifier
        .fillMaxSize()
        .scale(scale.value)
        .alpha(alpha.value),
      contentScale = ContentScale.Crop
    )

    // Dark gradient overlay at top and bottom for readability
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(
          Brush.verticalGradient(
            colors = listOf(
              Color(0x99000000),
              Color.Transparent,
              Color.Transparent,
              Color(0xEE090B10)
            )
          )
        )
    )

    // Top Bar with Skip button
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(horizontal = 16.dp, vertical = 8.dp),
      contentAlignment = Alignment.TopEnd
    ) {
      TextButton(
        onClick = onFinish,
        shape = RoundedCornerShape(20.dp)
      ) {
        Text(
          text = "Entrar",
          color = Color.White.copy(alpha = 0.85f),
          style = MaterialTheme.typography.labelMedium
        )
      }
    }

    // Bottom solemn caption
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.BottomCenter)
        .padding(horizontal = 24.dp, vertical = 32.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Surface(
        shape = RoundedCornerShape(50.dp),
        color = Color(0x33000000),
        border = androidx.compose.foundation.BorderStroke(1.dp, GoldSecondary.copy(alpha = 0.5f))
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

      Spacer(modifier = Modifier.height(12.dp))

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

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = "— San Juan de la Cruz",
        style = MaterialTheme.typography.labelSmall,
        color = Color.White.copy(alpha = 0.7f)
      )

      Spacer(modifier = Modifier.height(14.dp))

      Text(
        text = "Dios Te Dice Hoy",
        style = MaterialTheme.typography.titleLarge.copy(
          fontFamily = FontFamily.Serif,
          fontWeight = FontWeight.Bold,
          letterSpacing = 2.sp
        ),
        color = GoldSecondary
      )
    }
  }
}
