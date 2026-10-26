package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.LocalFontSizeScale

private val DarkColorScheme =
  darkColorScheme(
    primary = WinePrimaryDark,
    onPrimary = WineOnPrimaryDark,
    primaryContainer = WinePrimaryContainerDark,
    onPrimaryContainer = WineOnPrimaryContainerDark,
    secondary = GoldSecondaryDark,
    onSecondary = GoldOnSecondaryDark,
    secondaryContainer = GoldSecondaryContainerDark,
    onSecondaryContainer = GoldOnSecondaryContainerDark,
    tertiary = MarianTertiaryDark,
    onTertiary = MarianOnTertiaryDark,
    tertiaryContainer = MarianTertiaryContainerDark,
    onTertiaryContainer = MarianOnTertiaryContainerDark,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
  )

private val LightColorScheme =
  lightColorScheme(
    primary = WinePrimary,
    onPrimary = WineOnPrimary,
    primaryContainer = WinePrimaryContainer,
    onPrimaryContainer = WineOnPrimaryContainer,
    secondary = GoldSecondary,
    onSecondary = GoldOnSecondary,
    secondaryContainer = GoldSecondaryContainer,
    onSecondaryContainer = GoldOnSecondaryContainer,
    tertiary = MarianTertiary,
    onTertiary = MarianOnTertiary,
    tertiaryContainer = MarianTertiaryContainer,
    onTertiaryContainer = MarianOnTertiaryContainer,
    background = ParchmentBackground,
    onBackground = ParchmentOnBackground,
    surface = SacredSurface,
    onSurface = SacredOnSurface,
    surfaceVariant = SacredSurfaceVariant,
    onSurfaceVariant = SacredOnSurfaceVariant,
    outline = SacredOutline,
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  fontSizeScale: Float = 1.0f,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  CompositionLocalProvider(LocalFontSizeScale provides fontSizeScale) {
      MaterialTheme(colorScheme = colorScheme, typography = getTypography(fontSizeScale), content = content)
  }
}
