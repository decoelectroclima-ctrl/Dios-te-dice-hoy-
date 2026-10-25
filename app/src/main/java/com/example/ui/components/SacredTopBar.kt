package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.WinePrimary

@Composable
fun SacredTopBar(
  title: String,
  subtitle: String? = null,
  onSettingsClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier.fillMaxWidth(),
    color = MaterialTheme.colorScheme.surface,
    tonalElevation = 3.dp,
    shadowElevation = 2.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Sacred emblem badge
        Box(
          modifier = Modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(
              Brush.radialGradient(
                colors = listOf(GoldSecondary, WinePrimary)
              )
            ),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "✝",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
          )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Serif,
              letterSpacing = 0.5.sp
            ),
            color = MaterialTheme.colorScheme.onSurface
          )
          if (!subtitle.isNullOrEmpty()) {
            Text(
              text = subtitle,
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.primary
            )
          }
        }

        IconButton(
          onClick = onSettingsClick,
          modifier = Modifier
            .size(42.dp)
            .testTag("settings_button")
        ) {
          Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Configuración",
            tint = MaterialTheme.colorScheme.secondary
          )
        }
      }

      // Thin sacred gold accent line
      Spacer(modifier = Modifier.height(8.dp))
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(1.5.dp)
          .background(
            Brush.horizontalGradient(
              listOf(
                Color.Transparent,
                GoldSecondary.copy(alpha = 0.6f),
                WinePrimary.copy(alpha = 0.4f),
                Color.Transparent
              )
            )
          )
      )
    }
  }
}
