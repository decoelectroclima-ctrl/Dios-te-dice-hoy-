package com.example.data

import com.example.data.sanctorale.SanctoraleQ1
import com.example.data.sanctorale.SanctoraleQ2
import com.example.data.sanctorale.SanctoraleQ3
import com.example.data.sanctorale.SanctoraleQ4
import com.example.model.CatholicCalendarDay
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor
import java.util.Calendar

object CatholicCalendarRepository {

  data class SaintTemplate(
    val title: String,
    val saintName: String,
    val biography: String,
    val patronage: String,
    val rank: CelebrationRank,
    val color: LiturgicalColor,
    val isHolyDay: Boolean = false,
    val prayer: String
  )

  /**
   * Complete Roman Catholic Sanctorale for all 365/366 days of the year (Q1 + Q2 + Q3 + Q4)
   */
  val fixedSaints: Map<Pair<Int, Int>, SaintTemplate> by lazy {
    SanctoraleQ1.saints + SanctoraleQ2.saints + SanctoraleQ3.saints + SanctoraleQ4.saints
  }

  /**
   * Returns today's liturgical calendar day and saint
   */
  fun getTodayDay(): CatholicCalendarDay {
    val cal = Calendar.getInstance()
    val y = cal.get(Calendar.YEAR)
    val m = cal.get(Calendar.MONTH) + 1
    val d = cal.get(Calendar.DAY_OF_MONTH)
    val monthList = getMonthCalendar(y, m)
    return monthList.firstOrNull { it.day == d } ?: monthList.first()
  }

  /**
   * Generates calendar days for an entire month (1-indexed month: 1=Jan, 12=Dec)
   */
  fun getMonthCalendar(year: Int, month: Int): List<CatholicCalendarDay> {
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    cal.set(Calendar.MONTH, month - 1)
    cal.set(Calendar.DAY_OF_MONTH, 1)

    val maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    val list = mutableListOf<CatholicCalendarDay>()

    for (d in 1..maxDays) {
      cal.set(Calendar.DAY_OF_MONTH, d)
      val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
      val isSunday = dayOfWeek == Calendar.SUNDAY
      val isFriday = dayOfWeek == Calendar.FRIDAY

      // Determine liturgical season based on month/day approximation
      val (season, defaultColor) = determineLiturgicalSeason(month, d)

      val fixed = fixedSaints[Pair(month, d)]

      val rank = when {
        isSunday -> CelebrationRank.DOMINGO
        fixed != null -> fixed.rank
        else -> CelebrationRank.FERIAL
      }

      val color = when {
        isSunday -> if (season == "Tiempo Ordinario") LiturgicalColor.VERDE else defaultColor
        fixed != null -> fixed.color
        else -> defaultColor
      }

      val title = when {
        isSunday -> "Domingo — Día del Señor ($season)"
        fixed != null -> fixed.title
        else -> "Feria del $season"
      }

      val saintName = fixed?.saintName ?: when {
        isSunday -> "Día del Señor: La Resurrección de Cristo"
        isFriday -> "Conmemoración de la Pasión del Señor"
        else -> "Santos del Martirologio Romano"
      }

      val bio = fixed?.biography ?: when {
        isSunday -> "El domingo es la Pascua semanal de los cristianos, día de descanso santo, Eucaristía y alabanza al Creador."
        isFriday -> "Día penitencial tradicional en la Iglesia Católica en recuerdo de la muerte de Cristo en la Cruz."
        else -> "La Iglesia conmemora hoy a los santos, confesores y testigos de la fe que vivieron el Evangelio en su jornada terrena."
      }

      val patronage = fixed?.patronage ?: when {
        isSunday -> "Día de precepto dominical y caridad fraterna"
        isFriday -> "Abstinencia y penitencia en honor a la Pasión"
        else -> "Intercesión de todos los santos de Dios"
      }

      val isHolyDay = isSunday || (fixed?.isHolyDay ?: false)
      val isAbstinence = isFriday && rank != CelebrationRank.SOLEMNIDAD

      val readings = generateReadingsForDay(month, d, isSunday)

      val prayer = fixed?.prayer ?: when {
        isSunday -> "Señor Jesús, gracias por el don del domingo. Renueva nuestra fe en tu victoria sobre la muerte y acompáñanos toda la semana."
        isFriday -> "Por tu santa Cruz nos redimiste, Señor. Te ofrecemos nuestros pequeños sacrificios y penitencias de este viernes."
        else -> "Te alabamos, Señor, por tus santos. Concédenos caminar hoy en tu amor y cumplir fielmente tu santa voluntad."
      }

      list.add(
        CatholicCalendarDay(
          day = d,
          month = month,
          year = year,
          title = title,
          saintName = saintName,
          saintBiography = bio,
          saintPatronage = patronage,
          rank = rank,
          liturgicalSeason = season,
          liturgicalColor = color,
          isHolyDayOfObligation = isHolyDay,
          isAbstinenceDay = isAbstinence,
          firstReadingCitation = readings.first,
          firstReadingSummary = readings.second,
          psalmCitation = readings.third,
          psalmResponse = readings.fourth,
          secondReadingCitation = if (isSunday) readings.fifth else null,
          secondReadingSummary = if (isSunday) readings.sixth else null,
          gospelCitation = readings.seventh,
          gospelSummary = readings.eighth,
          dailyPrayer = prayer
        )
      )
    }

    return list
  }

  private fun determineLiturgicalSeason(month: Int, day: Int): Pair<String, LiturgicalColor> {
    return when {
      // Diciembre: Adviento o Navidad
      month == 12 && day < 25 -> Pair("Tiempo de Adviento", LiturgicalColor.MORADO)
      month == 12 && day >= 25 -> Pair("Tiempo de Navidad", LiturgicalColor.BLANCO)
      // Enero: Navidad (hasta Epifanía / Bautismo) luego Tiempo Ordinario
      month == 1 && day <= 12 -> Pair("Tiempo de Navidad", LiturgicalColor.BLANCO)
      month == 1 || month == 2 -> Pair("Tiempo Ordinario", LiturgicalColor.VERDE)
      // Cuaresma (aproximación marzo/abril)
      month == 3 -> Pair("Tiempo de Cuaresma", LiturgicalColor.MORADO)
      month == 4 && day <= 15 -> Pair("Semana Santa y Pascua", LiturgicalColor.BLANCO)
      month == 4 || month == 5 -> Pair("Tiempo Pascual", LiturgicalColor.BLANCO)
      // Tiempo Ordinario
      else -> Pair("Tiempo Ordinario", LiturgicalColor.VERDE)
    }
  }

  private data class DayReadingsTuple(
    val first: String, val second: String,
    val third: String, val fourth: String,
    val fifth: String, val sixth: String,
    val seventh: String, val eighth: String
  )

  private val scriptureCycles: List<DayReadingsTuple> = listOf(
    DayReadingsTuple(
      first = "Isaías 61:1-3",
      second = "«El Espíritu del Señor está sobre mí, porque me ha ungido para anunciar la buena nueva a los pobres».",
      third = "Salmo 1",
      fourth = "R/. Dichoso el hombre que confía en el Señor.",
      fifth = "", sixth = "",
      seventh = "San Mateo 5:1-12",
      eighth = "Las Bienaventuranzas: Dichosos los pobres en el espíritu, porque de ellos es el Reino de los Cielos."
    ),
    DayReadingsTuple(
      first = "Filipenses 4:4-9",
      second = "«Alegraos siempre en el Señor; el Señor está cerca. En toda oración presentad vuestras peticiones con acción de gracias».",
      third = "Salmo 26 (27)",
      fourth = "R/. El Señor es mi luz y mi salvación, ¿a quién temeré?",
      fifth = "", sixth = "",
      seventh = "San Mateo 6:7-15",
      eighth = "La oración del Padre Nuestro y la llamada al perdón fraterno de todo corazón."
    ),
    DayReadingsTuple(
      first = "1 Juan 4:7-16",
      second = "«Queridos hermanos, amémonos unos a otros, porque el amor es de Dios. Quien no ama no ha conocido a Dios, porque Dios es amor».",
      third = "Salmo 33 (34)",
      fourth = "R/. Gustad y ved qué bueno es el Señor.",
      fifth = "", sixth = "",
      seventh = "San Juan 15:1-8",
      eighth = "La Vid y los sarmientos: «El que permanece en mí y yo en él, ése da mucho fruto; porque separados de mí nada podéis hacer»."
    ),
    DayReadingsTuple(
      first = "1 Corintios 11:23-26",
      second = "«Yo recibí del Señor lo que os he transmitido: que el Señor Jesús, la noche en que era entregado, tomó pan y dijo: Este es mi Cuerpo».",
      third = "Salmo 115 (116)",
      fourth = "R/. El cáliz de la bendición es comunión con la Sangre de Cristo.",
      fifth = "", sixth = "",
      seventh = "San Juan 6:35-40",
      eighth = "«Yo soy el pan de vida: el que viene a mí no pasará hambre; el que cree en mí no tendrá sed jamás»."
    ),
    DayReadingsTuple(
      first = "Isaías 52:13—53:12",
      second = "«Él soportó nuestros sufrimientos y aguantó nuestros dolores... Por sus llagas hemos sido sanados».",
      third = "Salmo 21 (22)",
      fourth = "R/. Dios mío, Dios mío, ¿por qué me has abandonado?",
      fifth = "", sixth = "",
      seventh = "San Marcos 8:34-38",
      eighth = "«El que quiera venir en pos de mí, que se niegue a sí mismo, que cargue con su cruz y que me siga»."
    ),
    DayReadingsTuple(
      first = "Gálatas 4:4-7",
      second = "«Cuando llegó la plenitud del tiempo, envió Dios a su Hijo, nacido de mujer, para que recibiéramos la adopción filial».",
      third = "Salmo Magníficat (Lucas 1)",
      fourth = "R/. Se alegra mi espíritu en Dios mi Salvador.",
      fifth = "", sixth = "",
      seventh = "San Lucas 1:26-38",
      eighth = "La Anunciación a la Santísima Virgen: «He aquí la sierva del Señor; hágase en mí según tu palabra»."
    ),
    DayReadingsTuple(
      first = "Efesios 2:4-10",
      second = "«Dios, rico en misericordia, por el gran amor con que nos amó, nos dio vida juntamente con Cristo».",
      third = "Salmo 102 (103)",
      fourth = "R/. El Señor es compasivo y misericordioso.",
      fifth = "", sixth = "",
      seventh = "San Lucas 15:11-32",
      eighth = "La parábola del Padre Misericordioso: «Había que hacer fiesta, porque este hermano tuyo estaba muerto y ha vuelto a la vida»."
    ),
    DayReadingsTuple(
      first = "Colosenses 3:12-17",
      second = "«Vestíos de compasión entrañable, bondad, humildad, mansedumbre y paciencia. Sobre todo, vestíos del amor, que es el vínculo de la perfección».",
      third = "Salmo 144 (145)",
      fourth = "R/. El Señor es bueno con todos, es cariñoso con todas sus criaturas.",
      fifth = "", sixth = "",
      seventh = "San Mateo 11:28-30",
      eighth = "«Venid a mí todos los que estáis cansados y agobiados, y yo os aliviaré. Cargad con mi yugo y aprended de mí, que soy manso y humilde de corazón»."
    ),
    DayReadingsTuple(
      first = "Romanos 8:31-39",
      second = "«¿Quién nos separará del amor de Cristo? ¿La tribulación, la angustia, la persecución?... En todo esto vencemos fácilmente por Aquel que nos amó».",
      third = "Salmo 90 (91)",
      fourth = "R/. Tú que habitas al amparo del Altísimo, que vives a la sombra del Omnipotente.",
      fifth = "", sixth = "",
      seventh = "San Marcos 4:35-41",
      eighth = "La tempestad calmada: «¿Por qué tenéis tanto miedo? ¿Aún no tenéis fe? Y el viento cesó y vino una gran calma»."
    ),
    DayReadingsTuple(
      first = "Jeremías 29:11-14",
      second = "«Yo conozco mis designios sobre vosotros —oráculo del Señor—: designios de paz y no de aflicción, para daros un porvenir lleno de esperanza».",
      third = "Salmo 62 (63)",
      fourth = "R/. Mi alma tiene sed de ti, Dios de mi vida.",
      fifth = "", sixth = "",
      seventh = "San Juan 10:11-18",
      eighth = "El Buen Pastor: «Yo soy el Buen Pastor. El buen pastor da la vida por las ovejas... Mis ovejas escuchan mi voz y me siguen»."
    ),
    DayReadingsTuple(
      first = "1 Pedro 1:3-9",
      second = "«Bendito sea el Dios y Padre de nuestro Señor Jesucristo, que por su gran misericordia nos ha hecho renacer a una esperanza viva por la resurrección».",
      third = "Salmo 15 (16)",
      fourth = "R/. Protégeme, Dios mío, que me refugio en ti.",
      fifth = "", sixth = "",
      seventh = "San Lucas 24:13-35",
      eighth = "Los discípulos de Emaús: «¿No ardía nuestro corazón mientras nos hablaba en el camino y nos explicaba las Escrituras?»."
    ),
    DayReadingsTuple(
      first = "Santiago 1:19-27",
      second = "«Poned en práctica la Palabra y no os contentéis con oírla... La religión pura e intachable ante Dios Padre es visitar a huérfanos y viudas en su tribulación».",
      third = "Salmo 118 (119)",
      fourth = "R/. Tu Palabra es antorcha para mis pasos, Señor.",
      fifth = "", sixth = "",
      seventh = "San Mateo 7:21-27",
      eighth = "La casa sobre roca: «El que escucha estas palabras mías y las pone en práctica se parece a aquel hombre prudente que edificó su casa sobre roca»."
    )
  )

  private fun generateReadingsForDay(month: Int, day: Int, isSunday: Boolean): DayReadingsTuple {
    if (isSunday) {
      return DayReadingsTuple(
        first = "Éxodo 17:3-7",
        second = "Moisés golpea la roca en el desierto y brota agua viva para saciar la sed del pueblo de Dios.",
        third = "Salmo 94 (95)",
        fourth = "R/. Ojalá escuchéis hoy su voz: «No endurezcáis el corazón».",
        fifth = "Romanos 5:1-2, 5-8",
        sixth = "El amor de Dios ha sido derramado en nuestros corazones por el Espíritu Santo que se nos ha dado.",
        seventh = "San Juan 4:5-14",
        eighth = "Jesús y la samaritana en el pozo de Jacob: «El agua que yo le daré se convertirá en él en manantial que salta hasta la vida eterna»."
      )
    }

    val idx = (month * 31 + day) % scriptureCycles.size
    return scriptureCycles[idx]
  }
}
