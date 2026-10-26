package com.example.data

object BibleData {

  data class BibleVersionInfo(
    val code: String,
    val name: String,
    val shortName: String,
    val description: String,
    val isCatholic: Boolean,
    val yearOrTradition: String
  )

  val availableVersions: List<BibleVersionInfo> = listOf(
    BibleVersionInfo(
      code = "JERUSALEN",
      name = "Biblia de Jerusalén",
      shortName = "Jerusalén",
      description = "Traducción católica de referencia para estudio bíblico, liturgia y exégesis rigurosa.",
      isCatholic = true,
      yearOrTradition = "Edición Litúrgica y de Estudio"
    ),
    BibleVersionInfo(
      code = "TORRES_AMAT",
      name = "Torres Amat (Vulgata Latina)",
      shortName = "Torres Amat",
      description = "Traducción tradicional católica de la Vulgata por el obispo Félix Torres Amat y el P. Petisco.",
      isCatholic = true,
      yearOrTradition = "Tradicional Clásica Católica"
    ),
    BibleVersionInfo(
      code = "LATINOAMERICANA",
      name = "Biblia Latinoamericana",
      shortName = "Latinoamericana",
      description = "Edición pastoral católica con lenguaje accesible y cercano para la oración.",
      isCatholic = true,
      yearOrTradition = "Edición Pastoral San Pablo"
    ),
    BibleVersionInfo(
      code = "DHHED",
      name = "Dios Habla Hoy (Católica)",
      shortName = "Dios Habla Hoy",
      description = "Versión en lenguaje claro y actual con deuterocanónicos aprobados por el CELAM.",
      isCatholic = true,
      yearOrTradition = "Edición Ecuménica con Deuterocanónicos"
    ),
    BibleVersionInfo(
      code = "RVR1960",
      name = "Reina-Valera 1960",
      shortName = "Reina-Valera",
      description = "Clásica traducción castellana con solemne elegancia y veneración.",
      isCatholic = false,
      yearOrTradition = "Revisión Histórica 1960"
    )
  )

  fun getVersionInfo(code: String): BibleVersionInfo {
    return availableVersions.find { it.code.equals(code, ignoreCase = true) } ?: availableVersions[0]
  }

  data class BibleChapter(
    val book: String,
    val testament: String, // "Antiguo Testamento" o "Nuevo Testamento"
    val chapter: Int,
    val title: String,
    val verses: List<Pair<Int, String>> // Versículo número -> Texto
  )

  val chapters: List<BibleChapter> = listOf(
    // --- ANTIGUO TESTAMENTO ---
    BibleChapter(
      book = "Génesis",
      testament = "Antiguo Testamento",
      chapter = 1,
      title = "La Creación del Cielo y de la Tierra",
      verses = listOf(
        1 to "En el principio creó Dios los cielos y la tierra.",
        2 to "La tierra estaba desordenada y vacía, y las tinieblas estaban sobre la faz del abismo, y el Espíritu de Dios se movía sobre la faz de las aguas.",
        3 to "Y dijo Dios: «Sea la luz»; y fue la luz.",
        4 to "Y vio Dios que la luz era buena; y separó Dios la luz de las tinieblas.",
        5 to "Y llamó Dios a la luz «Día», y a las tinieblas llamó «Noche». Y fue la tarde y la mañana un día.",
        26 to "Entonces dijo Dios: «Hagamos al hombre a nuestra imagen, conforme a nuestra semejanza; y señoree en los peces del mar, en las aves de los cielos y en las bestias».",
        27 to "Y creó Dios al hombre a su imagen, a imagen de Dios lo creó; varón y hembra los creó.",
        31 to "Y vio Dios todo lo que había hecho, y he aquí que era bueno en gran manera. Y fue la tarde y la mañana el día sexto."
      )
    ),
    BibleChapter(
      book = "Éxodo",
      testament = "Antiguo Testamento",
      chapter = 3,
      title = "La Zarza Ardiente y la Revelación de Dios",
      verses = listOf(
        1 to "Apacentando Moisés las ovejas de Jetro su suegro, sacerdote de Madián, llevó las ovejas a través del desierto, y llegó hasta Horeb, monte de Dios.",
        2 to "Y se le apareció el Ángel del Señor en una llama de fuego en medio de una zarza; y él miró, y vio que la zarza ardía en fuego, y la zarza no se consumía.",
        4 to "Viendo el Señor que él iba a ver, lo llamó Dios de en medio de la zarza, y dijo: «¡Moisés, Moisés!» Y él respondió: «Heme aquí».",
        5 to "Y dijo: «No te acerques; quita tu calzado de tus pies, porque el lugar en que tú estás, tierra santa es».",
        14 to "Y respondió Dios a Moisés: «YO SOY EL QUE SOY». Y dijo: «Así dirás a los hijos de Israel: “YO SOY me envió a ustedes”»."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 23,
      title = "El Señor es mi Pastor",
      verses = listOf(
        1 to "El Señor es mi pastor; nada me faltará.",
        2 to "En lugares de delicados pastos me hará descansar; junto a aguas de reposo me pastoreará.",
        3 to "Confortará mi alma; me guiará por sendas de justicia por amor de su nombre.",
        4 to "Aunque ande en valle de sombra de muerte, no temeré mal alguno, porque tú estarás conmigo; tu vara y tu cayado me infundirán aliento.",
        5 to "Aderezas mesa delante de mí en presencia de mis angustiadores; unges mi cabeza con aceite; mi copa está rebosando.",
        6 to "Ciertamente el bien y la misericordia me seguirán todos los días de mi vida, y en la casa del Señor moraré por largos días."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 91,
      title = "Bajo las Alas del Altísimo",
      verses = listOf(
        1 to "El que habita al abrigo del Altísimo morará bajo la sombra del Omnipotente.",
        2 to "Diré yo al Señor: «Esperanza mía, y castillo mío; mi Dios, en quien confiaré».",
        3 to "Él te librará del lazo del cazador, de la peste destructora.",
        4 to "Con sus plumas te cubrirá, y debajo de sus alas estarás seguro; escudo y adarga es su verdad.",
        11 to "Pues a sus ángeles mandará cerca de ti, que te guarden en todos tus caminos.",
        14 to "«Por cuanto en mí ha puesto su amor, yo también lo libraré; le pondré en alto, por cuanto ha conocido mi nombre»."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 119,
      title = "La Excelencia de la Palabra de Dios",
      verses = listOf(
        105 to "Lámpara es a mis pies tu palabra, y lumbrera a mi camino.",
        114 to "Mi escondedero y mi escudo eres tú; en tu palabra he esperado.",
        130 to "La exposición de tus palabras alumbra; hace entender a los simples.",
        165 to "Mucha paz tienen los que aman tu ley, y no hay para ellos tropiezo."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 121,
      title = "El Guardián de Israel",
      verses = listOf(
        1 to "Alzaré mis ojos a los montes: ¿De dónde vendrá mi socorro?",
        2 to "Mi socorro viene del Señor, que hizo los cielos y la tierra.",
        3 to "No dará tu pie al resbaladero, ni se dormirá el que te guarda.",
        5 to "El Señor es tu guardador; el Señor es tu sombra a tu mano derecha.",
        7 to "El Señor te guardará de todo mal; él guardará tu alma.",
        8 to "El Señor guardará tu salida y tu entrada desde ahora y para siempre."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 139,
      title = "Dios lo Sabe y lo Ve Todo",
      verses = listOf(
        1 to "Señor, tú me has examinado y conocido.",
        2 to "Tú has conocido mi sentarme y mi levantarme; has entendido desde lejos mis pensamientos.",
        3 to "Has escudriñado mi andar y mi reposo, y todos mis caminos te son conocidos.",
        13 to "Porque tú formaste mis entrañas; tú me hiciste en el vientre de mi madre.",
        14 to "Te alabaré; porque formidables, maravillosas son tus obras; estoy maravillado.",
        23 to "Examíname, oh Dios, y conoce mi corazón; pruébame y conoce mis pensamientos."
      )
    ),
    BibleChapter(
      book = "Proverbios",
      testament = "Antiguo Testamento",
      chapter = 3,
      title = "Confianza Plena en el Señor",
      verses = listOf(
        5 to "Confía en el Señor de todo tu corazón, y no te apoyes en tu propia prudencia.",
        6 to "Reconócelo en todos tus caminos, y él enderezará tus veredas.",
        7 to "No seas sabio en tu propia opinión; teme al Señor, y apártate del mal.",
        13 to "Bienaventurado el hombre que halla la sabiduría, y que obtiene la inteligencia."
      )
    ),
    BibleChapter(
      book = "Isaías",
      testament = "Antiguo Testamento",
      chapter = 40,
      title = "Consolad a mi Pueblo",
      verses = listOf(
        1 to "«Consolaos, consolaos, pueblo mío», dice vuestro Dios.",
        29 to "Él da esfuerzo al cansado, y multiplica las fuerzas al que no tiene ningunas.",
        30 to "Los muchachos se fatigan y se cansan, los jóvenes flaquean y caen;",
        31 to "pero los que esperan en el Señor tendrán nuevas fuerzas; levantarán alas como las águilas; correrán, y no se cansarán; caminarán, y no se fatigarán."
      )
    ),
    BibleChapter(
      book = "Isaías",
      testament = "Antiguo Testamento",
      chapter = 41,
      title = "No Temas, Yo te Ayudo",
      verses = listOf(
        10 to "No temas, porque yo estoy contigo; no desmayes, porque yo soy tu Dios que te esfuerzo; siempre te ayudaré, siempre te sustentaré con la diestra de mi justicia.",
        13 to "Porque yo, el Señor tu Dios, sostengo tu mano derecha, y te digo: «No temas, yo te ayudo»."
      )
    ),
    BibleChapter(
      book = "Jeremías",
      testament = "Antiguo Testamento",
      chapter = 29,
      title = "Planes de Bienestar y Esperanza",
      verses = listOf(
        11 to "«Porque yo sé los pensamientos que tengo acerca de ustedes», dice el Señor, «pensamientos de paz, y no de mal, para darles el fin que esperan».",
        12 to "«Entonces me invocarán, y vendrán y orarán a mí, y yo los oiré;»",
        13 to "«y me buscarán y me hallarán, porque me buscarán de todo vuestro corazón»."
      )
    ),

    // --- NUEVO TESTAMENTO ---
    BibleChapter(
      book = "San Mateo",
      testament = "Nuevo Testamento",
      chapter = 5,
      title = "El Sermón de la Montaña: Las Bienaventuranzas",
      verses = listOf(
        1 to "Viendo la multitud, subió al monte; y sentándose, vinieron a él sus discípulos.",
        2 to "Y abriendo su boca les enseñaba, diciendo:",
        3 to "«Bienaventurados los pobres en espíritu, porque de ellos es el reino de los cielos.",
        4 to "Bienaventurados los que lloran, porque ellos recibirán consolación.",
        5 to "Bienaventurados los mansos, porque ellos recibirán la tierra por heredad.",
        6 to "Bienaventurados los que tienen hambre y sed de justicia, porque ellos serán saciados.",
        7 to "Bienaventurados los misericordiosos, porque ellos alcanzarán misericordia.",
        8 to "Bienaventurados los de limpio corazón, porque ellos verán a Dios.",
        9 to "Bienaventurados los pacificadores, porque ellos serán llamados hijos de Dios.",
        14 to "Ustedes son la luz del mundo; una ciudad asentada sobre un monte no se puede esconder.",
        16 to "Así alumbre vuestra luz delante de los hombres, para que vean vuestras buenas obras, y glorifiquen a vuestro Padre que está en los cielos»."
      )
    ),
    BibleChapter(
      book = "San Mateo",
      testament = "Nuevo Testamento",
      chapter = 6,
      title = "La Oración del Padre Nuestro y el Afán",
      verses = listOf(
        9 to "«Ustedes, pues, orarán así: Padre nuestro que estás en los cielos, santificado sea tu nombre.",
        10 to "Venga tu reino. Hágase tu voluntad, como en el cielo, así también en la tierra.",
        11 to "El pan nuestro de cada día, dánoslo hoy.",
        12 to "Y perdónanos nuestras deudas, como también nosotros perdonamos a nuestros deudores.",
        13 to "Y no nos metas en tentación, mas líbranos del mal; porque tuyo es el reino, y el poder, y la gloria, por todos los siglos. Amén».",
        25 to "«Por tanto les digo: No se afanen por vuestra vida, qué han de comer o qué han de beber; ni por vuestro cuerpo, qué han de vestir. ¿No es la vida más que el alimento, y el cuerpo más que el vestido?»",
        33 to "«Buscad primeramente el reino de Dios y su justicia, y todas estas cosas os serán añadidas»."
      )
    ),
    BibleChapter(
      book = "San Lucas",
      testament = "Nuevo Testamento",
      chapter = 1,
      title = "La Anunciación a la Virgen María y el Magníficat",
      verses = listOf(
        26 to "Al sexto mes el ángel Gabriel fue enviado por Dios a una ciudad de Galilea, llamada Nazaret,",
        27 to "a una virgen desposada con un varón que se llamaba José, de la casa de David; y el nombre de la virgen era María.",
        28 to "Y entrando el ángel en donde ella estaba, dijo: «¡Alégrate, llena de gracia! El Señor es contigo; bendita tú entre las mujeres».",
        38 to "Entonces María dijo: «He aquí la sierva del Señor; hágase conmigo conforme a tu palabra». Y el ángel se fue de su presencia.",
        46 to "Entonces María dijo: «Engrandece mi alma al Señor;»",
        47 to "«y mi espíritu se regocija en Dios mi Salvador,",
        48 to "porque ha mirado la bajeza de su sierva; pues he aquí, desde ahora me dirán bienaventurada todas las generaciones»."
      )
    ),
    BibleChapter(
      book = "San Lucas",
      testament = "Nuevo Testamento",
      chapter = 15,
      title = "La Parábola del Hijo Pródigo y la Misericordia",
      verses = listOf(
        11 to "También dijo: «Un hombre tenía dos hijos;",
        12 to "y el menor de ellos dijo a su padre: Padre, dame la parte de los bienes que me corresponde; y les repartió los bienes».",
        18 to "«Me levantaré e iré a mi padre, y le diré: Padre, he pecado contra el cielo y contra ti».",
        20 to "«Y levantándose, vino a su padre. Y cuando aún estaba lejos, lo vio su padre, y fue movido a misericordia, y corrió, y se echó sobre su cuello, y le besó».",
        24 to "«Porque este mi hijo muerto era, y ha revivido; se había perdido, y es hallado. Y comenzaron a regocijarse»."
      )
    ),
    BibleChapter(
      book = "San Juan",
      testament = "Nuevo Testamento",
      chapter = 1,
      title = "El Verbo Hecho Carne",
      verses = listOf(
        1 to "En el principio era el Verbo, y el Verbo era con Dios, y el Verbo era Dios.",
        2 to "Este era en el principio con Dios.",
        3 to "Todas las cosas por él fueron hechas, y sin él nada de lo que ha sido hecho, fue hecho.",
        4 to "En él estaba la vida, y la vida era la luz de los hombres.",
        5 to "La luz en las tinieblas resplandece, y las tinieblas no prevalecieron contra ella.",
        14 to "Y aquel Verbo fue hecho carne, y habitó entre nosotros (y vimos su gloria, gloria como del unigénito del Padre), lleno de gracia y de verdad."
      )
    ),
    BibleChapter(
      book = "San Juan",
      testament = "Nuevo Testamento",
      chapter = 14,
      title = "Jesús, el Camino, la Verdad y la Vida",
      verses = listOf(
        1 to "«No se turbe vuestro corazón; creéis en Dios, creed también en mí.",
        2 to "En la casa de mi Padre muchas moradas hay; si así no fuera, yo os lo hubiera dicho; voy, pues, a preparar lugar para vosotros».",
        6 to "Jesús le dijo: «Yo soy el camino, y la verdad, y la vida; nadie viene al Padre, sino por mí».",
        27 to "«La paz os dejo, mi paz os doy; yo no os la doy como el mundo la da. No se turbe vuestro corazón, ni tenga miedo»."
      )
    ),
    BibleChapter(
      book = "Romanos",
      testament = "Nuevo Testamento",
      chapter = 8,
      title = "La Vida en el Espíritu y el Amor Inseparable",
      verses = listOf(
        1 to "Ahora, pues, ninguna condenación hay para los que están en Cristo Jesús, los que no andan conforme a la carne, sino conforme al Espíritu.",
        28 to "Y sabemos que a los que aman a Dios, todas las cosas les ayudan a bien, esto es, a los que conforme a su propósito son llamados.",
        31 to "¿Qué, pues, diremos a esto? Si Dios es por nosotros, ¿quién contra nosotros?",
        38 to "Por lo cual estoy seguro de que ni la muerte, ni la vida, ni ángeles, ni principados, ni potestades, ni lo presente, ni lo por venir,",
        39 to "ni lo alto, ni lo profundo, ni ninguna otra cosa creada nos podrá separar del amor de Dios, que es en Cristo Jesús Señor nuestro."
      )
    ),
    BibleChapter(
      book = "1 Corintios",
      testament = "Nuevo Testamento",
      chapter = 13,
      title = "El Himno del Amor y la Caridad",
      verses = listOf(
        1 to "Si yo hablase lenguas humanas y angélicas, y no tengo amor, vengo a ser como metal que resuena, o címbalo que retiñe.",
        4 to "El amor es sufrido, es benigno; el amor no tiene envidia, el amor no es jactancioso, no se envanece;",
        5 to "no hace nada indebido, no busca lo suyo, no se irrita, no guarda rencor;",
        6 to "no se goza de la injusticia, mas se goza de la verdad.",
        7 to "Todo lo sufre, todo lo cree, todo lo espera, todo lo soporta.",
        8 to "El amor nunca deja de ser.",
        13 to "Y ahora permanecen la fe, la esperanza y el amor, estos tres; pero el mayor de ellos es el amor."
      )
    ),
    BibleChapter(
      book = "Filipenses",
      testament = "Nuevo Testamento",
      chapter = 4,
      title = "Regocijo en el Señor y Paz Divina",
      verses = listOf(
        4 to "Regocijaos en el Señor siempre. Otra vez digo: ¡Regocijaos!",
        6 to "Por nada estéis afanosos, sino sean conocidas vuestras peticiones delante de Dios en toda oración y ruego, con acción de gracias.",
        7 to "Y la paz de Dios, que sobrepasa todo entendimiento, guardará vuestros corazones y vuestros pensamientos en Cristo Jesús.",
        13 to "Todo lo puedo en Cristo que me fortalece."
      )
    ),
    BibleChapter(
      book = "Apocalipsis",
      testament = "Nuevo Testamento",
      chapter = 21,
      title = "Cielo Nuevo y Tierra Nueva",
      verses = listOf(
        1 to "Vi un cielo nuevo y una tierra nueva; porque el primer cielo y la primera tierra pasaron, y el mar ya no existía más.",
        3 to "Y oí una gran voz del cielo que decía: «He aquí el tabernáculo de Dios con los hombres, y él morará con ellos; y ellos serán su pueblo, y Dios mismo estará con ellos como su Dios».",
        4 to "«Enjugará Dios toda lágrima de los ojos de ellos; y ya no habrá muerte, ni habrá más llanto, ni clamor, ni dolor; porque las primeras cosas pasaron».",
        5 to "Y el que estaba sentado en el trono dijo: «He aquí, yo hago nuevas todas las cosas». Y me dijo: «Escribe; porque estas palabras son fieles y verdaderas»."
      )
    ),
    BibleChapter(
      book = "Génesis",
      testament = "Antiguo Testamento",
      chapter = 2,
      title = "La Creación del Hombre y la Mujer",
      verses = listOf(
        7 to "Entonces el Señor Dios formó al hombre del polvo de la tierra, y sopló en su nariz aliento de vida, y fue el hombre un ser viviente.",
        22 to "Y de la costilla que el Señor Dios tomó del hombre, hizo una mujer, y la trajo al hombre."
      )
    ),
    BibleChapter(
      book = "Éxodo",
      testament = "Antiguo Testamento",
      chapter = 20,
      title = "Los Diez Mandamientos",
      verses = listOf(
        2 to "«Yo soy el Señor tu Dios, que te saqué de la tierra de Egipto, de casa de servidumbre.",
        3 to "No tendrás dioses ajenos delante de mí»."
      )
    ),
    BibleChapter(
      book = "Salmos",
      testament = "Antiguo Testamento",
      chapter = 27,
      title = "El Señor es mi luz y mi salvación",
      verses = listOf(
        1 to "El Señor es mi luz y mi salvación; ¿de quién temeré? El Señor es la fortaleza de mi vida; ¿de quién he de atemorizarme?"
      )
    )
  )

  fun getAllVersesAsEntities(version: String): List<BibleVerseEntity> {
    val list = mutableListOf<BibleVerseEntity>()
    chapters.forEach { ch ->
      ch.verses.forEach { (verseNum, text) ->
        val citation = "${ch.book} ${ch.chapter}:$verseNum"
        val id = "${ch.book.lowercase().replace(" ", "_")}_${ch.chapter}_${verseNum}_$version"
        list.add(
          BibleVerseEntity(
            id = id,
            version = version,
            citation = citation,
            text = text,
            category = "SAGRADA ESCRITURA",
            godSaysToday = "Mi palabra es vida para ti.",
            modernMeaning = "El pasaje de $citation nos recuerda la fidelidad de Dios.",
            practicalApplication = "Medita hoy en esta enseñanza.",
            virtue = "Fe y Esperanza",
            testament = ch.testament
          )
        )
      }
    }
    return list
  }
}
