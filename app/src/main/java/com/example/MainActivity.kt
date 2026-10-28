package com.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserPreferences
import com.example.model.PrayerPurpose
import com.example.notification.NotificationHelper
import com.example.ui.components.SacredTopBar
import com.example.ui.screens.BibleReaderScreen
import com.example.ui.screens.ConfessionScreen
import com.example.ui.screens.FreeWillScreen
import com.example.ui.screens.HandOfGodScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LiturgyScreen
import com.example.ui.screens.ParishScreen
import com.example.ui.screens.PrayersScreen
import com.example.ui.screens.SacredMusicScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SpiritualLifeScreen
import com.example.ui.screens.HolySpiritScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.WinePrimary

import androidx.fragment.app.FragmentActivity
import com.example.ui.screens.AuthLockScreen
import com.example.ui.screens.AuthMode
import com.example.widget.DailyVerseWidgetProvider
import kotlinx.coroutines.launch

enum class SubScreen {
  FREE_WILL,
  HAND_OF_GOD,
  HOLY_SPIRIT,
  SETTINGS,
  AUTH_SETUP,
  SPOTIFY_MUSIC
}

class MainActivity : FragmentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    try {
      // Initialize notification channels and schedule morning & night alarms
      NotificationHelper.createNotificationChannels(this)
      val prefs = UserPreferences(this)
      if (prefs.isNotificationEnabled()) {
        NotificationHelper.scheduleDailyAlarm(this)
      }
      if (prefs.isNightNotificationEnabled()) {
        NotificationHelper.scheduleNightAlarm(this)
      }

      // Refresh home screen daily widget on launch
      DailyVerseWidgetProvider.updateAllWidgets(this)
    } catch (e: Throwable) {
      android.util.Log.e("MainActivity", "Error initializing background services on launch", e)
    }

    val openTabExtra = intent?.getStringExtra("OPEN_TAB")

    setContent {
      android.util.Log.e("MainActivity", "Starting setContent")
      val context = LocalContext.current
      val userPrefs = remember { UserPreferences(context) }
      var currentThemeMode by remember { mutableStateOf(userPrefs.getThemeMode()) }
      var fontSizeScale by remember { mutableStateOf(userPrefs.getFontSize()) }
      var isAppUnlocked by remember { mutableStateOf(!userPrefs.isAppLockEnabled()) }

      val isDark = when (currentThemeMode) {
        UserPreferences.THEME_LIGHT -> false
        UserPreferences.THEME_DARK -> true
        else -> isSystemInDarkTheme()
      }

      MyApplicationTheme(darkTheme = isDark, fontSizeScale = fontSizeScale) {
        var showSplash by remember { mutableStateOf(openTabExtra == null) }

        if (showSplash) {
          SplashScreen(onFinish = { showSplash = false })
        } else if (!isAppUnlocked) {
          AuthLockScreen(
            mode = AuthMode.UNLOCK,
            onUnlocked = { isAppUnlocked = true }
          )
        } else {
          MainAppContent(
            initialSubScreen = if (openTabExtra == "HAND_OF_GOD") SubScreen.HAND_OF_GOD else null,
            currentThemeMode = currentThemeMode,
            onThemeModeChanged = { newMode ->
              currentThemeMode = newMode
            },
            onFontSizeChanged = { newScale ->
              fontSizeScale = newScale
            }
          )
        }
      }
    }
  }

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)
    setIntent(intent)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContent(
  initialSubScreen: SubScreen? = null,
  currentThemeMode: String,
  onThemeModeChanged: (String) -> Unit,
  onFontSizeChanged: (Float) -> Unit
) {
  android.util.Log.e("MainAppContent", "Starting MainAppContent")
  val context = LocalContext.current
  val userPrefs = remember { UserPreferences(context) }
  val snackbarHostState = remember { SnackbarHostState() }
  val scope = rememberCoroutineScope()
  var currentTabIndex by remember { mutableIntStateOf(0) }
  var subScreen by remember { mutableStateOf<SubScreen?>(initialSubScreen) }
  var prayersInitialPurpose by remember { mutableStateOf<PrayerPurpose?>(null) }

  // Request notification permission on Android 13+ upon launching
  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    val permissionLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
      contract = androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
    ) { granted ->
      if (granted) {
        scope.launch {
          snackbarHostState.showSnackbar("¡Permiso de notificaciones concedido!")
        }
      }
    }

    androidx.compose.runtime.LaunchedEffect(Unit) {
      if (androidx.core.content.ContextCompat.checkSelfPermission(
          context,
          android.Manifest.permission.POST_NOTIFICATIONS
        ) != android.content.pm.PackageManager.PERMISSION_GRANTED
      ) {
        permissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
      }
    }
  }

  // Handle hardware / gesture back button
  BackHandler(enabled = subScreen != null || currentTabIndex != 0) {
    if (subScreen != null) {
      subScreen = null
    } else {
      currentTabIndex = 0
    }
  }

    val navItems = listOf(
      NavigationDestination(
        title = "Hoy",
        icon = Icons.Default.AutoAwesome,
        subtitle = "Dios te dice hoy"
      ),
      NavigationDestination(
        title = "Liturgia",
        icon = Icons.Default.MenuBook,
        subtitle = "Calendario, Santoral y Santa Misa"
      ),
      NavigationDestination(
        title = "Oraciones",
        icon = Icons.Default.VolunteerActivism,
        subtitle = "Compendio y Espíritu Santo"
      ),
      NavigationDestination(
        title = "Confesión",
        icon = Icons.Default.CleaningServices,
        subtitle = "Examen de Conciencia y Cardenal Verdier"
      ),
      NavigationDestination(
        title = "Biblia",
        icon = Icons.Default.Book,
        subtitle = "Lectura completa"
      ),
      NavigationDestination(
        title = "Espiritual",
        icon = Icons.Default.LocalFireDepartment,
        subtitle = "Vida Espiritual"
      ),
      NavigationDestination(
        title = "Parroquias",
        icon = Icons.Default.LocationOn,
        subtitle = "Buscador de Misas"
      )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
          if (subScreen != null) {
            TopAppBar(
              title = {
                Text(
                  text = when (subScreen) {
                    SubScreen.SETTINGS -> "Configuración"
                    SubScreen.FREE_WILL -> "Libre Albedrío"
                    SubScreen.HAND_OF_GOD -> "La Mano de Dios"
                    SubScreen.HOLY_SPIRIT -> "Apartado del Espíritu Santo"
                    SubScreen.AUTH_SETUP -> "Seguridad y PIN"
                    SubScreen.SPOTIFY_MUSIC -> "Música Sacra en Spotify"
                    null -> ""
                  },
                  style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                  )
                )
              },
              navigationIcon = {
                IconButton(
                  onClick = { subScreen = null },
                  modifier = Modifier.testTag("subscreen_back_button")
                ) {
                  Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver"
                  )
                }
              },
              colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onSurface,
                navigationIconContentColor = MaterialTheme.colorScheme.primary
              )
            )
          } else {
            SacredTopBar(
              title = "Dios Te Dice Hoy",
              subtitle = navItems[currentTabIndex].subtitle,
              onSettingsClick = {
                subScreen = SubScreen.SETTINGS
              }
            )
          }
        },
        bottomBar = {
          if (subScreen == null) {
            NavigationBar(
              containerColor = MaterialTheme.colorScheme.surface,
              tonalElevation = 6.dp
            ) {
              navItems.forEachIndexed { index, item ->
                val isSelected = currentTabIndex == index
                NavigationBarItem(
                  modifier = Modifier.testTag("nav_item_$index"),
                  selected = isSelected,
                  onClick = {
                    currentTabIndex = index
                  },
                  icon = {
                    Icon(
                      imageVector = item.icon,
                      contentDescription = item.title
                    )
                  },
                  label = {
                    Text(
                      text = item.title,
                      style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                      ),
                      maxLines = 1
                    )
                  },
                  colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = WinePrimary,
                    selectedTextColor = WinePrimary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    unselectedIconColor = MaterialTheme.colorScheme.outline,
                    unselectedTextColor = MaterialTheme.colorScheme.outline
                  )
                )
              }
            }
          }
        },
        snackbarHost = {
          SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Crossfade(
            targetState = subScreen to currentTabIndex,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { (activeSubScreen, activeTab) ->
            if (activeSubScreen != null) {
                when (activeSubScreen) {
                    SubScreen.SETTINGS -> SettingsScreen(
                        snackbarHostState = snackbarHostState,
                        onThemeChanged = onThemeModeChanged,
                        onFontSizeChanged = onFontSizeChanged,
                        onOpenPinSetup = { subScreen = SubScreen.AUTH_SETUP }
                    )
                    SubScreen.FREE_WILL -> FreeWillScreen(
                        snackbarHostState = snackbarHostState
                    )
                    SubScreen.HAND_OF_GOD -> HandOfGodScreen(
                        snackbarHostState = snackbarHostState
                    )
                    SubScreen.HOLY_SPIRIT -> HolySpiritScreen()
                    SubScreen.AUTH_SETUP -> {
                        AuthLockScreen(
                            mode = if (userPrefs.hasPinSet()) AuthMode.CHANGE_PIN else AuthMode.SETUP_NEW,
                            onUnlocked = {
                                subScreen = null
                                scope.launch {
                                    snackbarHostState.showSnackbar("¡Clave de 4 dígitos configurada con éxito!")
                                }
                            },
                            onCancel = {
                                subScreen = null
                            }
                        )
                    }
                    SubScreen.SPOTIFY_MUSIC -> SacredMusicScreen(
                        snackbarHostState = snackbarHostState
                    )
                }
            } else {
                when (activeTab) {
                    0 -> HomeScreen(
                        snackbarHostState = snackbarHostState,
                        currentThemeMode = currentThemeMode,
                        onThemeModeChanged = onThemeModeChanged,
                        onNavigateToLiturgy = { currentTabIndex = 1 }
                    )
                    1 -> LiturgyScreen(
                        snackbarHostState = snackbarHostState
                    )
                    2 -> PrayersScreen(
                        snackbarHostState = snackbarHostState,
                        initialPurposeFilter = null
                    )
                    3 -> ConfessionScreen(
                        snackbarHostState = snackbarHostState
                    )
                    4 -> BibleReaderScreen()
                    5 -> SpiritualLifeScreen(
                        onNavigateToFreeWill = { subScreen = SubScreen.FREE_WILL },
                        onNavigateToHolySpirit = { subScreen = SubScreen.HOLY_SPIRIT },
                        onNavigateToConfession = { currentTabIndex = 3 },
                        onNavigateToHandOfGod = { subScreen = SubScreen.HAND_OF_GOD },
                        onNavigateToSpotify = { subScreen = SubScreen.SPOTIFY_MUSIC }
                    )
                    6 -> ParishScreen(
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}

data class NavigationDestination(
  val title: String,
  val icon: androidx.compose.ui.graphics.vector.ImageVector,
  val subtitle: String
)
