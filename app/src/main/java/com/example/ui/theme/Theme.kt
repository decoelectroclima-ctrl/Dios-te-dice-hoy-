package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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

  CompositionLocalProvider(
    LocalFontSizeScale provides fontSizeScale,
    LocalIsDarkTheme provides darkTheme
  ) {
    MaterialTheme(colorScheme = colorScheme, typography = getTypography(fontSizeScale), content = content)
  }
}

@Composable
fun isAppInDarkTheme(): Boolean = LocalIsDarkTheme.current

/**
 * Dynamic liturgical wine/rose color that guarantees high contrast:
 * - In Light mode: rich royal Burgundy (WinePrimary - #AD2737)
 * - In Dark mode: radiant, luminous rose/coral (WinePrimaryDark - #FF9EAA) with >9:1 contrast against black/dark backgrounds.
 */
@Composable
fun appWineColor(): Color {
  return if (LocalIsDarkTheme.current) GranateButtonDark else WinePrimary
}

/**
 * Unified liturgical Granate / Burdeos Oscuro Button Colors:
 * - Deep noble Granate / Burdeos Oscuro container
 * - Pure WHITE text (Color.White) with strong contrast across all screens
 */
@Composable
fun appButtonColors(): ButtonColors {
  return ButtonDefaults.buttonColors(
    containerColor = if (LocalIsDarkTheme.current) GranateButtonDark else GranateButton,
    contentColor = Color.White
  )
}

/**
 * Liturgical Button Border for dark mode:
 * On black/dark backgrounds, gives Granate buttons a crisp, luminous Gold outline so the button boundaries
 * and rich granate fill are sharply distinguished and appreciated against the black surface.
 */
@Composable
fun appButtonBorder(): BorderStroke? {
  return if (LocalIsDarkTheme.current) {
    BorderStroke(1.2.dp, GranateButtonBorderDark.copy(alpha = 0.85f))
  } else {
    null
  }
}

