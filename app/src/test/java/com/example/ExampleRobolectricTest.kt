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
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Dios Te Dice", appName)
  }

  @Test
  fun `verify bible verses repository`() {
    val verses = VerseRepository.verses
    assertTrue("Should contain curated verses", verses.size >= 12)

    val daily = VerseRepository.getDailyVerse()
    assertNotNull("Daily verse must not be null", daily)
    assertTrue(daily.citation.isNotBlank())
    assertTrue(daily.godSaysToday.isNotBlank())
    assertTrue(daily.modernMeaning.isNotBlank())
    assertTrue(daily.practicalApplication.isNotBlank())

    val randomVerse = VerseRepository.getRandomVerse()
    assertNotNull(randomVerse)

    val virtueVerse = VerseRepository.getVerseByVirtue("Paz")
    assertNotNull(virtueVerse)
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
    assertTrue(verdier!!.content.contains("Amor del Padre y del Hijo"))
    assertTrue(verdier.content.contains("Inspírame siempre lo que debo pensar"))

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
  fun `verify daily verse widget provider updates`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    // Calling updateAllWidgets should execute safely without crashing
    com.example.widget.DailyVerseWidgetProvider.updateAllWidgets(context)
    val daily = VerseRepository.getDailyVerse()
    assertNotNull(daily)
  }
}
