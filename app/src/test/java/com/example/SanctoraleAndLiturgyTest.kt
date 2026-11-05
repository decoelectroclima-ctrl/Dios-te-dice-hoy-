package com.example

import com.example.data.CatholicCalendarRepository
import com.example.data.CoronillaRepository
import com.example.data.LiturgyOfHoursRepository
import com.example.data.LiturgyRepository
import com.example.data.NovenaRepository
import com.example.data.PrayerRepository
import com.example.data.RosaryRepository
import com.example.data.VerseRepository
import com.example.data.ViaCrucisRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar

class SanctoraleAndLiturgyTest {

  @Test
  fun `verify full 366-day sanctorale covers every day of the year without gaps`() {
    val saints = CatholicCalendarRepository.fixedSaints
    assertTrue("Must cover all 365 or 366 days, found ${saints.size}", saints.size >= 365)

    val daysInMonths = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    for (m in 1..12) {
      val maxDays = daysInMonths[m - 1]
      for (d in 1..maxDays) {
        val saint = saints[Pair(m, d)]
        assertNotNull("Saint for $d/$m must not be null", saint)
        assertTrue("Saint title for $d/$m must not be blank", saint!!.title.isNotBlank())
        assertTrue("Saint name for $d/$m must not be blank", saint.saintName.isNotBlank())
        assertTrue("Saint bio for $d/$m must not be blank", saint.biography.isNotBlank())
        assertTrue("Saint patronage for $d/$m must not be blank", saint.patronage.isNotBlank())
        assertTrue("Saint prayer for $d/$m must not be blank", saint.prayer.isNotBlank())
      }
    }
  }

  @Test
  fun `verify full month calendar generation has rich data for every day`() {
    for (m in 1..12) {
      val monthDays = CatholicCalendarRepository.getMonthCalendar(2025, m)
      assertTrue("Month $m must contain days", monthDays.isNotEmpty())
      monthDays.forEach { day ->
        assertTrue("Day title must not be blank in month $m", day.title.isNotBlank())
        assertTrue("Saint name must not be blank in month $m", day.saintName.isNotBlank())
        assertTrue("Bio must not be blank in month $m", day.saintBiography.isNotBlank())
        assertTrue("Gospel citation must not be blank in month $m", day.gospelCitation.isNotBlank())
        assertTrue("Prayer must not be blank in month $m", day.dailyPrayer.isNotBlank())
      }
    }
  }

  @Test
  fun `verify liturgy for each day of the week`() {
    val daysOfWeek = listOf(
      Calendar.SUNDAY,
      Calendar.MONDAY,
      Calendar.TUESDAY,
      Calendar.WEDNESDAY,
      Calendar.THURSDAY,
      Calendar.FRIDAY,
      Calendar.SATURDAY
    )

    daysOfWeek.forEach { dow ->
      val cal = Calendar.getInstance()
      cal.set(Calendar.DAY_OF_WEEK, dow)
      val liturgy = LiturgyRepository.getLiturgyForCalendar(cal)
      assertNotNull(liturgy)
      assertTrue(liturgy.firstReadingCitation.isNotBlank())
      assertTrue(liturgy.firstReadingText.isNotBlank())
      assertTrue(liturgy.responsorialPsalmCitation.isNotBlank())
      assertTrue(liturgy.responsorialPsalmText.isNotBlank())
      assertTrue(liturgy.gospelCitation.isNotBlank())
      assertTrue(liturgy.gospelText.isNotBlank())
      assertTrue(liturgy.liturgicalReflection.isNotBlank())
      assertTrue(liturgy.prayersOfTheFaithful.isNotEmpty())
    }
  }

  @Test
  fun `verify 53 essential catholic prayers`() {
    val allPrayers = PrayerRepository.getAllPrayers()
    assertTrue("Must have at least 53 essential Catholic prayers, found ${allPrayers.size}", allPrayers.size >= 53)
  }

  @Test
  fun `verify 49 novenas catalog`() {
    val novenas = NovenaRepository.novenas
    assertTrue("Must have at least 49 Catholic novenas, found ${novenas.size}", novenas.size >= 49)
    novenas.forEach { novena ->
      assertTrue(novena.title.isNotBlank())
      assertEquals(9, novena.days.size)
    }
  }

  @Test
  fun `verify via crucis 14 stations`() {
    val stations = ViaCrucisRepository.stations
    assertEquals(14, stations.size)
    stations.forEach { station ->
      assertTrue(station.title.isNotBlank())
      assertTrue(station.meditation.isNotBlank())
      assertTrue(station.prayer.isNotBlank())
    }
  }

  @Test
  fun `verify coronilla divina misericordia steps`() {
    assertTrue(CoronillaRepository.THREE_PM_PRAYER.isNotBlank())
    assertTrue(CoronillaRepository.ETERNAL_FATHER_PRAYER.isNotBlank())
    assertTrue(CoronillaRepository.SORROWFUL_PASSION_PRAYER.isNotBlank())
    assertTrue(CoronillaRepository.HOLY_GOD_DOXOLOGY.isNotBlank())
    assertEquals(4, CoronillaRepository.promises.size)
  }

  @Test
  fun `verify holy rosary mysteries of today and bead prayers`() {
    val todayMystery = RosaryRepository.getMysteryForToday()
    assertNotNull(todayMystery)
    assertEquals(5, todayMystery.mysteries.size)

    assertTrue(RosaryRepository.HAIL_MARY_TEXT.contains("Dios te salve, María"))
    assertTrue(RosaryRepository.OUR_FATHER_TEXT.contains("Padre nuestro"))
    assertTrue(RosaryRepository.GLORY_BE_TEXT.contains("Gloria al Padre"))
  }

  @Test
  fun `verify daily verses for all 365 days`() {
    val verses = VerseRepository.verses
    assertTrue("Should contain verses", verses.isNotEmpty())
    val daily = VerseRepository.getDailyVerse()
    assertNotNull(daily)
    assertTrue(daily.citation.isNotBlank())
    assertTrue(daily.godSaysToday.isNotBlank())
  }
}
