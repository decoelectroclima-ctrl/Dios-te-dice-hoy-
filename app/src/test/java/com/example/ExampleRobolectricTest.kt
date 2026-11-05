package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.LiturgyRepository
import com.example.data.ParishRepository
import com.example.data.PrayerRepository
import com.example.data.UserPreferences
import com.example.data.VerseRepository
import com.example.model.ConfessionItem
import com.example.model.HandOfGodEntry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Dios Te Dice Hoy", appName)
  }

  @Test
  fun `launch main activity successfully`() {
    val controller = org.robolectric.Robolectric.buildActivity(MainActivity::class.java)
    controller.create().start().resume()
    assertNotNull(controller.get())
  }

  @Test
  fun `verify dios te dice hoy messages repository`() {
    val verses = VerseRepository.verses
    assertTrue("Should contain curated messages", verses.size >= 12)

    val daily = VerseRepository.getDailyVerse()
    assertNotNull("Daily message must not be null", daily)
    assertTrue(daily.citation.isNotBlank())
    assertTrue(daily.godSaysToday.isNotBlank())
    assertTrue(daily.modernMeaning.isNotBlank())
    assertTrue(daily.practicalApplication.isNotBlank())

    val randomVerse = VerseRepository.getRandomVerse()
    assertNotNull(randomVerse)

    val peaceVerse = VerseRepository.getVerseByVirtue("Paz")
    assertNotNull(peaceVerse)
  }

  @Test
  fun `verify catholic prayers including cardenal verdier and liturgical hymns`() {
    val prayers = PrayerRepository.getAllPrayers()
    assertTrue("Should have extensive Catholic prayers", prayers.size >= 24)

    val padreNuestro = PrayerRepository.getPrayerById("padre_nuestro")
    assertNotNull("Padre Nuestro must exist", padreNuestro)
    assertTrue(padreNuestro!!.content.contains("Padre nuestro"))

    // Verify Oracion al Espiritu Santo del Cardenal Verdier
    val verdier = PrayerRepository.getPrayerById("oracion_cardenal_verdier")
    assertNotNull("Cardenal Verdier prayer must exist", verdier)
    assertTrue(verdier!!.content.contains("Amor del Padre y del Hijo,"))
    assertTrue(verdier.content.contains("inspírame siempre lo que debo pensar"))

    // Verify Adoro Te Devote and Te Deum
    val adoroTe = PrayerRepository.getPrayerById("adoro_te_devote")
    assertNotNull("Adoro Te Devote must exist", adoroTe)
    assertTrue(adoroTe!!.content.contains("Te adoro con devoción"))
    assertTrue(adoroTe.description.contains("Santo Tomás de Aquino"))

    val teDeum = PrayerRepository.getPrayerById("te_deum")
    assertNotNull("Te Deum must exist", teDeum)
    assertTrue(teDeum!!.content.contains("A ti, oh Dios, te alabamos"))

    val holySpiritPrayers = PrayerRepository.getHolySpiritPrayers()
    assertTrue("Must have Holy Spirit prayers", holySpiritPrayers.isNotEmpty())
  }

  @Test
  fun `verify liturgy repository and ordinary of the mass`() {
    val liturgy = LiturgyRepository.getTodayLiturgy()
    assertNotNull("Today liturgy must not be null", liturgy)
    assertTrue(liturgy.firstReadingText.isNotBlank())
    assertTrue(liturgy.responsorialPsalmText.isNotBlank())
    assertTrue(liturgy.gospelText.isNotBlank())
    assertTrue(liturgy.celebrationName.isNotBlank())

    val ordinary = LiturgyRepository.getOrdinaryOfTheMass()
    assertTrue("Ordinary must have all liturgical parts", ordinary.size >= 8)

    val penitentialAct = ordinary.find { it.id == "acto_penitencial" }
    assertNotNull("Penitential act must exist", penitentialAct)
    assertTrue(penitentialAct!!.peopleResponse.contains("Yo confieso"))

    val consagracion = ordinary.find { it.id == "consagracion_plegaria" }
    assertNotNull("Consecration must exist", consagracion)
    assertNotNull(consagracion!!.latinPeopleResponse)
  }

  @Test
  fun `verify parish directory and maps helper`() {
    val parishes = ParishRepository.getAllParishes()
    assertTrue("Parishes list should not be empty", parishes.isNotEmpty())

    val firstParish = parishes.first()
    assertTrue(firstParish.name.isNotBlank())
    assertTrue(firstParish.weekdayMasses.isNotEmpty())
    assertTrue(firstParish.sundayMasses.isNotEmpty())

    val searchResults = ParishRepository.searchParishes("Catedral")
    assertTrue("Should find Cathedral in search", searchResults.isNotEmpty())
  }

  @Test
  fun `verify confession hand of god and theme preferences`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val prefs = UserPreferences(context)

    // Theme switching test
    prefs.setThemeMode(UserPreferences.THEME_DARK)
    assertEquals(UserPreferences.THEME_DARK, prefs.getThemeMode())
    prefs.setThemeMode(UserPreferences.THEME_LIGHT)
    assertEquals(UserPreferences.THEME_LIGHT, prefs.getThemeMode())
    prefs.setThemeMode(UserPreferences.THEME_SYSTEM)
    assertEquals(UserPreferences.THEME_SYSTEM, prefs.getThemeMode())

    // Confession item
    val item = ConfessionItem(
      id = "test_sin",
      text = "Falta de paciencia",
      category = "Palabra",
      isConfessed = false,
      dateAdded = "24 Oct"
    )
    prefs.addConfessionItem(item)
    val confessionList = prefs.getConfessionItems()
    assertTrue(confessionList.any { it.id == "test_sin" })

    // Hand of God entry
    val entry = HandOfGodEntry(
      id = "test_entry",
      date = "24 de Octubre",
      text = "Sentí la paz de Dios en una llamada",
      category = "Paz en la prueba"
    )
    prefs.addHandOfGodEntry(entry)
    val entries = prefs.getHandOfGodEntries()
    assertTrue(entries.any { it.id == "test_entry" })
  }

  @Test
  fun `verify 4-digit PIN security hashing and verification`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val prefs = UserPreferences(context)

    // Initially no PIN set
    prefs.removePin()
    assertTrue(!prefs.hasPinSet())
    assertTrue(!prefs.isAppLockEnabled())

    // Set 4-digit PIN "1234"
    prefs.setPin("1234")
    assertTrue(prefs.hasPinSet())
    assertTrue(prefs.isAppLockEnabled())

    // Verify correct PIN
    assertTrue(prefs.verifyPin("1234"))

    // Verify incorrect PINs fail
    assertTrue(!prefs.verifyPin("0000"))
    assertTrue(!prefs.verifyPin("1235"))
    assertTrue(!prefs.verifyPin("4321"))

    // Biometric preference
    prefs.setBiometricEnabled(true)
    assertTrue(prefs.isBiometricEnabled())
    prefs.setBiometricEnabled(false)
    assertTrue(!prefs.isBiometricEnabled())

    // Clean up
    prefs.removePin()
    assertTrue(!prefs.hasPinSet())
    assertTrue(!prefs.isAppLockEnabled())
  }

  @Test
  fun `verify widget provider update and sync functionality`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val verse = com.example.widget.DiosTeDiceWidgetProvider.updateAllWidgets(context, newRandomVerse = true)
    assertNotNull("Updated verse from widget provider should not be null", verse)
    assertTrue("Widget verse citation should not be blank", verse.citation.isNotBlank())
    assertTrue("Widget verse text should not be blank", verse.verseText.isNotBlank())
  }

  @Test
  fun `verify free will random scripture and preference storage`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val prefs = UserPreferences(context)
    val randomVerse = VerseRepository.getRandomVerse()
    assertNotNull(randomVerse)
    prefs.setLastFreeWillVerseId(randomVerse.id)
    assertEquals(randomVerse.id, prefs.getLastFreeWillVerseId())
  }

  @Test
  fun `verify all 49 catholic novenas with 9 days each and reminders`() {
    val novenas = com.example.data.NovenaRepository.novenas
    assertEquals("Should contain exactly 49 authentic Catholic Novenas", 49, novenas.size)

    novenas.forEach { novena ->
      assertTrue("Novena ${novena.id} title must not be blank", novena.title.isNotBlank())
      assertTrue("Novena ${novena.id} must have exactly 9 days", novena.days.size == 9)
      assertTrue("Novena ${novena.id} initial prayer must not be blank", novena.openingPrayer.isNotBlank())
      assertTrue("Novena ${novena.id} final prayer must not be blank", novena.closingPrayer.isNotBlank())
      novena.days.forEach { day ->
        assertEquals(novena.days.indexOf(day) + 1, day.dayNumber)
        assertTrue("Day ${day.dayNumber} theme in ${novena.id} must not be blank", day.title.isNotBlank())
        assertTrue("Day ${day.dayNumber} meditation in ${novena.id} must not be blank", day.meditation.isNotBlank())
        assertTrue("Day ${day.dayNumber} prayer in ${novena.id} must not be blank", day.dailyPrayer.isNotBlank())
      }
    }

    val context = ApplicationProvider.getApplicationContext<Context>()
    val prefs = UserPreferences(context)
    val testNovena = novenas.first()
    assertEquals(1, prefs.getNovenaCurrentDay(testNovena.id))
    prefs.setNovenaCurrentDay(testNovena.id, 5)
    assertEquals(5, prefs.getNovenaCurrentDay(testNovena.id))

    prefs.setNovenaReminderEnabled(testNovena.id, true)
    assertTrue(prefs.isNovenaReminderEnabled(testNovena.id))
    prefs.setNovenaReminderTime(testNovena.id, 18, 30)
    val (hour, minute) = prefs.getNovenaReminderTime(testNovena.id)
    assertEquals(18, hour)
    assertEquals(30, minute)
  }

  @Test
  fun `verify chaplet of divine mercy with prayers and promises`() {
    val threePmPrayer = com.example.data.CoronillaRepository.THREE_PM_PRAYER
    assertTrue(threePmPrayer.contains("Expiraste, Jesús"))

    val promises = com.example.data.CoronillaRepository.promises
    assertTrue("Must have promises of Divine Mercy", promises.isNotEmpty())

    val padreEterno = com.example.data.CoronillaRepository.ETERNAL_FATHER_PRAYER
    assertTrue(padreEterno.contains("Padre Eterno, te ofrezco"))

    val dolorosaPasion = com.example.data.CoronillaRepository.SORROWFUL_PASSION_PRAYER
    assertTrue(dolorosaPasion.contains("Por su dolorosa Pasión"))

    val doxology = com.example.data.CoronillaRepository.HOLY_GOD_DOXOLOGY
    assertTrue(doxology.contains("Santo Dios"))

    val concluding = com.example.data.CoronillaRepository.CONCLUDING_PRAYER
    assertTrue(concluding.contains("Oh Dios Eterno"))
  }

  @Test
  fun `verify liturgy of the hours with laudes visperas completas and oficio`() {
    val hours = com.example.data.LiturgyOfHoursRepository.hours
    assertEquals(4, hours.size)

    val laudes = hours.find { it.id == "laudes" }
    assertNotNull(laudes)
    assertTrue(laudes!!.gospelCanticleTitle.contains("Benedictus"))

    val visperas = hours.find { it.id == "visperas" }
    assertNotNull(visperas)
    assertTrue(visperas!!.gospelCanticleTitle.contains("Magníficat"))

    val completas = hours.find { it.id == "completas" }
    assertNotNull(completas)
    assertTrue(completas!!.gospelCanticleTitle.contains("Nunc Dimittis"))

    val oficio = hours.find { it.id == "oficio_lectura" }
    assertNotNull(oficio)
    assertTrue(oficio!!.gospelCanticleTitle.contains("Te Deum"))
  }

  @Test
  fun `verify holy rosary mysteries of today and bead prayers`() {
    val todayMystery = com.example.data.RosaryRepository.getMysteryForToday()
    assertNotNull(todayMystery)
    assertEquals(5, todayMystery.mysteries.size)

    assertTrue(com.example.data.RosaryRepository.HAIL_MARY_TEXT.contains("Dios te salve, María"))
    assertTrue(com.example.data.RosaryRepository.OUR_FATHER_TEXT.contains("Padre nuestro"))
    assertTrue(com.example.data.RosaryRepository.GLORY_BE_TEXT.contains("Gloria al Padre"))
    assertTrue(com.example.data.RosaryRepository.FATIMA_EJACULATION.contains("perdona nuestros pecados"))
    assertTrue(com.example.data.RosaryRepository.SALVE_REGINA_TEXT.contains("Dios te salve, Reina y Madre"))
  }

  @Test
  fun `verify saint of the day with history and bio`() {
    val todayDay = com.example.data.CatholicCalendarRepository.getTodayDay()
    assertNotNull(todayDay)
    assertTrue(todayDay.saintName.isNotBlank())
    assertTrue(todayDay.saintBiography.isNotBlank())
    assertTrue(todayDay.saintPatronage.isNotBlank())
    assertTrue(todayDay.dailyPrayer.isNotBlank())
  }

  @Test
  fun `verify 53 essential catholic prayers`() {
    val allPrayers = PrayerRepository.getAllPrayers()
    assertTrue("Must have at least 53 essential Catholic prayers, found ${allPrayers.size}", allPrayers.size >= 53)
  }

  @Test
  fun `verify via crucis 14 stations`() {
    val stations = com.example.data.ViaCrucisRepository.stations
    assertEquals(14, stations.size)
    stations.forEach { station ->
      assertTrue(station.title.isNotBlank())
      assertTrue(station.meditation.isNotBlank())
      assertTrue(station.prayer.isNotBlank())
    }
  }
}
