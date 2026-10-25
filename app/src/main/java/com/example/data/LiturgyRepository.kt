package com.example.data

import com.example.model.DailyLiturgy
import com.example.model.LiturgicalColor
import com.example.model.OrdinaryPart
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object LiturgyRepository {

  fun getTodayLiturgy(): DailyLiturgy {
    val cal = Calendar.getInstance()
    val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
    val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)

    val dateFormat = SimpleDateFormat("EEEE, d 'de' MMMM", Locale("es", "ES"))
    val formattedDate = dateFormat.format(Date()).replaceFirstChar { it.uppercase() }

    // Curated rich liturgical cycles for weekdays and Sundays
    return when (dayOfWeek) {
      Calendar.SUNDAY -> DailyLiturgy(
        dayTitle = "Domingo — Día del Señor",
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Celebración Eucarística Dominical",
        entranceAntiphon = "Canten al Señor un cántico nuevo, cante al Señor toda la tierra. Hay honor y majestad en su presencia, fuerza y esplendor en su santuario.",
        firstReadingCitation = "Éxodo 17:3-7",
        firstReadingText = "En aquellos días, el pueblo tuvo sed y murmuró contra Moisés diciendo: «¿Por qué nos hiciste salir de Egipto para matarnos de sed a nosotros, a nuestros hijos y a nuestro ganado?». Moisés clamó al Señor, y el Señor le dijo: «Pasa adelante del pueblo y golpea la peña con tu bastón, y brotará agua para que beba el pueblo». Así lo hizo Moisés.",
        responsorialPsalmCitation = "Salmo 94 (95)",
        responsorialPsalmResponse = "R/. Ojalá escuchen hoy su voz: «No endurezcan el corazón».",
        responsorialPsalmText = "Vengan, aclamemos al Señor, demos vítores a la Roca que nos salva. Entremos a su presencia dándole gracias, aclamándolo con cantos. Vengan, postrémonos por tierra, bendiciendo al Señor, creador nuestro. Porque él es nuestro Dios, y nosotros su pueblo, el rebaño que él guía.",
        secondReadingCitation = "Romanos 5:1-2, 5-8",
        secondReadingText = "Hermanos: Ya que hemos sido justificados por la fe, estamos en paz con Dios por medio de nuestro Señor Jesucristo. Y la esperanza no defrauda, porque el amor de Dios ha sido derramado en nuestros corazones por el Espíritu Santo que nos ha sido dado.",
        gospelAcclamation = "«Señor, tú eres verdaderamente el Salvador del mundo; dame de esa agua viva, para que no tenga más sed.»",
        gospelCitation = "San Juan 4:5-14",
        gospelText = "En aquel tiempo, Jesús llegó a un pueblo de Samaria llamado Sicar. Fatigado del camino, se sentó junto al pozo de Jacob. Era alrededor del mediodía. Una mujer de Samaria fue a sacar agua, y Jesús le dijo: «Dame de beber». La samaritana le contestó: «¿Cómo tú, siendo judío, me pides de beber a mí, que soy samaritana?». Jesús le respondió: «Si conocieras el don de Dios y quién es el que te dice “Dame de beber”, tú le pedirías a él, y él te daría agua viva. El que beba del agua que yo le daré nunca más tendrá sed; el agua que yo le daré se convertirá en él en manantial de agua que salta hasta la vida eterna».",
        communionAntiphon = "«El que come mi carne y bebe mi sangre permanece en mí y yo en él —dice el Señor.» (Jn 6:57)",
        liturgicalReflection = "Jesús se presenta junto al pozo de nuestra rutina diaria. Conoce nuestras sedes más hondas y no ofrece soluciones superficiales, sino el manantial inagotable del Espíritu Santo."
      )
      else -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = if (dayOfYear % 5 == 0) LiturgicalColor.BLANCO else LiturgicalColor.VERDE,
        celebrationName = if (dayOfYear % 5 == 0) "Memoria de los Santos y Testigos de la Fe" else "Feria del Tiempo Ordinario",
        entranceAntiphon = "El Señor es mi fuerza y mi escudo, en él confió mi corazón y fui socorrido; mi carne floreció de nuevo y le doy gracias con mi canto.",
        firstReadingCitation = "Filipenses 2:1-5",
        firstReadingText = "Hermanos: Si hay algún consuelo en Cristo, algún estímulo de amor, alguna comunión en el Espíritu, alguna ternura y compasión, colmen mi gozo teniendo un mismo sentir, un mismo amor, unánimes en el espíritu, sintiendo una misma cosa. Nada hagan por rivalidad ni por vanagloria; antes bien, con humildad consideren a los demás como superiores a ustedes mismos, no buscando cada uno su propio interés, sino el de los demás. Tengan entre ustedes los mismos sentimientos que tuvo Cristo Jesús.",
        responsorialPsalmCitation = "Salmo 130 (131)",
        responsorialPsalmResponse = "R/. Guarda mi alma en tu paz, Señor.",
        responsorialPsalmText = "Señor, mi corazón no es engreído, ni mis ojos altaneros; no pretendo grandezas que superan mi capacidad. Al contrario, tengo mi alma en paz y silencio, como un niño destetado en el regazo de su madre. Espere Israel en el Señor, desde ahora y por siempre.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Mis ovejas escuchan mi voz, y yo las conozco y ellas me siguen, dice el Señor.»",
        gospelCitation = "San Lucas 14:12-14",
        gospelText = "En aquel tiempo, Jesús dijo al hombre que lo había invitado: «Cuando des una comida o una cena, no invites a tus amigos, ni a tus hermanos, ni a tus parientes, ni a vecinos ricos, no sea que ellos te inviten a su vez y tengas ya tu recompensa. Cuando des un banquete, invita a los pobres, a los lisiados, a los cojos y a los ciegos. Y serás dichoso, porque ellos no tienen con qué recompensarte; pues se te recompensará en la resurrección de los justos».",
        communionAntiphon = "«Gustad y ved qué bueno es el Señor; dichoso el hombre que se refugia en Él.» (Sal 33:9)",
        liturgicalReflection = "La generosidad del Evangelio no busca aplausos ni cálculos de reciprocidad. Amar y servir a quien nada nos puede devolver es el reflejo más puro del amor de Dios hacia nosotros."
      )
    }
  }

  fun getOrdinaryOfTheMass(): List<OrdinaryPart> = listOf(
    OrdinaryPart(
      id = "rito_inicial_senial",
      section = "Ritos Iniciales",
      title = "Señal de la Cruz y Saludo Inicial",
      priestDialogue = "En el nombre del Padre, y del Hijo, y del Espíritu Santo.\n\nEl sacerdote extiende las manos y saluda:\n«La gracia de nuestro Señor Jesucristo, el amor del Padre y la comunión del Espíritu Santo estén con todos vosotros.»",
      peopleResponse = "R/. Amén.\n\nR/. Y con tu espíritu.",
      rubric = "Los fieles se ponen de pie al iniciar la procesión de entrada y se persignan solemnemente.",
      latinTitle = "Signum Crucis et Salutatio",
      latinPeopleResponse = "R/. Amen.\n\nR/. Et cum spiritu tuo.",
      explanation = "Con la señal de la cruz recordamos nuestro bautismo y nos colocamos bajo la presencia de la Santísima Trinidad."
    ),
    OrdinaryPart(
      id = "acto_penitencial",
      section = "Ritos Iniciales",
      title = "Acto Penitencial (Confiteor)",
      priestDialogue = "Hermanos: para celebrar dignamente estos sagrados misterios, reconozcamos nuestros pecados.",
      peopleResponse = "R/. Yo confieso ante Dios todopoderoso y ante vosotros, hermanos, que he pecado mucho de pensamiento, palabra, obra y omisión.\n(Golpe de pecho tres veces):\nPor mi culpa, por mi culpa, por mi gran culpa.\nPor eso ruego a Santa María, siempre Virgen, a los ángeles, a los santos y a vosotros, hermanos, que intercedáis por mí ante Dios, nuestro Señor.\n\nSacerdote: Dios todopoderoso tenga misericordia de nosotros, perdone nuestros pecados y nos lleve a la vida eterna.\nR/. Amén.",
      rubric = "Momento de breve silencio de examen de conciencia, seguido por la humilde confesión comunitaria.",
      latinTitle = "Actus Paenitentialis",
      latinPeopleResponse = "R/. Confiteor Deo omnipotenti...",
      explanation = "Pedimos la misericordia del Señor antes de escuchar su Palabra y acercarnos al altar."
    ),
    OrdinaryPart(
      id = "kyrie_eleison",
      section = "Ritos Iniciales",
      title = "Señor, ten piedad (Kyrie Eleison)",
      priestDialogue = "Señor, ten piedad.\nCristo, ten piedad.\nSeñor, ten piedad.",
      peopleResponse = "R/. Señor, ten piedad.\nR/. Cristo, ten piedad.\nR/. Señor, ten piedad.",
      rubric = "Aclamación a Cristo Salvador.",
      latinTitle = "Kyrie, eleison",
      latinPeopleResponse = "R/. Kyrie, eleison.\nR/. Christe, eleison.\nR/. Kyrie, eleison.",
      explanation = "Súplica cantada o recitada conservando la venerable tradición griega primitiva de la Iglesia."
    ),
    OrdinaryPart(
      id = "gloria_misa",
      section = "Ritos Iniciales",
      title = "Himno del Gloria",
      priestDialogue = "Gloria a Dios en el cielo...",
      peopleResponse = "R/. Y en la tierra paz a los hombres que ama el Señor. Por tu inmensa gloria te alabamos, te bendecimos, te adoramos, te glorificamos, te damos gracias, Señor Dios, Rey celestial, Dios Padre todopoderoso. Señor, Hijo único, Jesucristo. Señor Dios, Cordero de Dios, Hijo del Padre: tú que quitas el pecado del mundo, ten piedad de nosotros; tú que quitas el pecado del mundo, atiende nuestra súplica; tú que estás sentado a la derecha del Padre, ten piedad de nosotros; porque sólo tú eres Santo, sólo tú Señor, sólo tú Altísimo, Jesucristo, con el Espíritu Santo en la gloria de Dios Padre. Amén.",
      rubric = "Se canta o recita los domingos fuera de Adviento y Cuaresma, y en las solemnidades y fiestas.",
      latinTitle = "Gloria in excelsis Deo",
      explanation = "Himno antiquísimo con el que la Iglesia glorifica a Dios Padre y al Cordero divino."
    ),
    OrdinaryPart(
      id = "liturgia_palabra_lecturas",
      section = "Liturgia de la Palabra",
      title = "Lecturas y Salmo Responsorial",
      priestDialogue = "Lector: Palabra de Dios.",
      peopleResponse = "R/. Te alabamos, Señor.\n\n(En el Evangelio):\nDiácono o Sacerdote: El Señor esté con vosotros.\nR/. Y con tu espíritu.\nProclamación del Santo Evangelio según San N.\nR/. Gloria a ti, Señor.\n\nAl terminar el Evangelio:\nDiácono o Sacerdote: Palabra del Señor.\nR/. Gloria a ti, Señor Jesús.",
      rubric = "Los fieles escuchan sentados la primera lectura y el salmo; se ponen de pie para la aclamación del Aleluya y el Evangelio persignándose la frente, los labios y el corazón.",
      latinTitle = "Liturgia Verbi",
      latinPeopleResponse = "R/. Deo gratias.\nR/. Laus tibi, Christe.",
      explanation = "Dios mismo habla a su pueblo reunido. En el Evangelio, Cristo se hace presente a través de su santa Palabra."
    ),
    OrdinaryPart(
      id = "ofertorio_dones",
      section = "Liturgia Eucarística",
      title = "Presentación de las Ofrendas (Ofertorio)",
      priestDialogue = "Bendito seas, Señor, Dios del universo, por este pan, fruto de la tierra y del trabajo del hombre...\nBendito seas, Señor, Dios del universo, por este vino, fruto de la vid...",
      peopleResponse = "R/. Bendito seas por siempre, Señor.\n\nEl sacerdote invita:\n«Orad, hermanos, para que este sacrificio mío y vuestro sea agradable a Dios, Padre todopoderoso.»\n\nR/. El Señor reciba de tus manos este sacrificio, para alabanza y gloria de su nombre, para nuestro bien y el de toda su santa Iglesia.",
      rubric = "Los fieles permanecen sentados durante la procesión de ofrendas y se ponen de pie ante la invitación a la oración.",
      latinTitle = "Offertorium",
      latinPeopleResponse = "R/. Suscipiat Dominus sacrificium de manibus tuis...",
      explanation = "Presentamos el pan y el vino que se convertirán en el Cuerpo y la Sangre de Cristo, junto con nuestras propias vidas y esfuerzos."
    ),
    OrdinaryPart(
      id = "prefacio_santo",
      section = "Liturgia Eucarística",
      title = "Prefacio y Santo (Sanctus)",
      priestDialogue = "El Señor esté con vosotros.\nR/. Y con tu espíritu.\nLevantemos el corazón.\nR/. Lo tenemos levantado hacia el Señor.\nDemos gracias al Señor, nuestro Dios.\nR/. Es justo y necesario.\n\nEl sacerdote proclama el Prefacio y concluye aclamando:",
      peopleResponse = "R/. Santo, Santo, Santo es el Señor, Dios del Universo. Llenos están el cielo y la tierra de tu gloria. ¡Hosanna en el cielo! Bendito el que viene en nombre del Señor. ¡Hosanna en el cielo!",
      rubric = "Los fieles permanecen de pie durante el diálogo del prefacio.",
      latinTitle = "Sanctus",
      latinPeopleResponse = "R/. Sanctus, Sanctus, Sanctus Dominus Deus Sabaoth. Pleni sunt caeli et terra gloria tua. Hosanna in excelsis. Benedictus qui venit in nomine Domini. Hosanna in excelsis.",
      explanation = "Nos unimos a los coros de los ángeles en el cielo para cantar la santidad perfecta de Dios."
    ),
    OrdinaryPart(
      id = "consagracion_plegaria",
      section = "Liturgia Eucarística",
      title = "Consagración y Misterio de la Fe",
      priestDialogue = "El sacerdote pronuncia las palabras solemnes de Cristo:\n«TOMAD Y COMED TODOS DE ÉL, PORQUE ESTO ES MI CUERPO, QUE SERÁ ENTREGADO POR VOSOTROS.»\n\n«TOMAD Y BEBED TODOS DE ÉL, PORQUE ÉSTE ES EL CÁLIZ DE MI SANGRE, SANGRE DE LA ALIANZA NUEVA Y ETERNA, QUE SERÁ DERRAMADA POR VOSOTROS Y POR MUCHOS PARA EL PERDÓN DE LOS PECADOS. HACED ESTO EN CONMEMORACIÓN MÍA.»\n\nSacerdote: Éste es el Sacramento de nuestra fe (o Misterio de la fe).",
      peopleResponse = "R/. Anunciamos tu muerte, proclamamos tu resurrección. ¡Ven, Señor Jesús!\n\n(O bien):\nR/. Cada vez que comemos de este pan y bebemos de este cáliz, anunciamos tu muerte, Señor, hasta que vuelvas.",
      rubric = "Los fieles se arrodillan durante la consagración en señal de profunda adoración ante el milagro de la Transubstanciación.",
      latinTitle = "Consecratio et Mysterium Fidei",
      latinPeopleResponse = "R/. Mortem tuam annuntiamus, Domine, et tuam resurrectionem confitemur, donec venias.",
      explanation = "Momento supremo de la Santa Misa: por obra del Espíritu Santo, el pan y el vino se convierten real y sustancialmente en el Cuerpo, Sangre, Alma y Divinidad de Jesús."
    ),
    OrdinaryPart(
      id = "padre_nuestro_paz",
      section = "Rito de Comunión",
      title = "Padre Nuestro y Rito de la Paz",
      priestDialogue = "Fieles a la recomendación del Salvador y siguiendo su divina enseñanza, nos atrevemos a decir:\n\nPadre nuestro...\n\nSacerdote: Líbranos de todos los males, Señor...",
      peopleResponse = "R/. Padre nuestro, que estás en el cielo...\n\nR/. Tuyo es el reino, tuyo el poder y la gloria, por siempre, Señor.\n\n(En la Paz):\nSacerdote: La paz del Señor esté siempre con vosotros.\nR/. Y con tu espíritu.\nDiácono o Sacerdote: Daos fraternalmente la paz.",
      rubric = "Los fieles se ponen de pie para orar juntos al Padre celestial e intercambiar un gesto fraterno de paz.",
      latinTitle = "Pater Noster et Ritus Pacis",
      latinPeopleResponse = "R/. Sed libera nos a malo...\nR/. Quia tuum est regnum, et potestas, et gloria in saecula.",
      explanation = "Oramos con la oración que Cristo nos regaló y pedimos la paz antes de comulgar su Cuerpo Santo."
    ),
    OrdinaryPart(
      id = "cordero_dios_comunion",
      section = "Rito de Comunión",
      title = "Fracción del Pan y Comunión",
      priestDialogue = "El sacerdote parte el pan consagrado y deja caer una parte en el cáliz.\n\nSacerdote: Éste es el Cordero de Dios, que quita el pecado del mundo. Dichosos los invitados a la cena del Señor.",
      peopleResponse = "R/. Cordero de Dios, que quitas el pecado del mundo, ten piedad de nosotros.\nCordero de Dios, que quitas el pecado del mundo, ten piedad de nosotros.\nCordero de Dios, que quitas el pecado del mundo, danos la paz.\n\nAnte el Cordero de Dios:\nR/. Señor, no soy digno de que entres en mi casa, pero una palabra tuya bastará para sanarme.",
      rubric = "Momento solemne para acercarse a comulgar en gracia de Dios, o hacer un acto de Comunión Espiritual.",
      latinTitle = "Agnus Dei",
      latinPeopleResponse = "R/. Agnus Dei, qui tollis peccata mundi...\nR/. Domine, non sum dignus ut intres sub tectum meum, sed tantum dic verbo et sanabitur anima mea.",
      explanation = "Reconocemos a Jesús como el Cordero pascual inmolado por nuestros pecados que alimenta nuestras almas."
    ),
    OrdinaryPart(
      id = "ritos_conclusion_despedida",
      section = "Ritos de Conclusión",
      title = "Bendición Final y Despedida",
      priestDialogue = "El Señor esté con vosotros.\nR/. Y con tu espíritu.\n\nLa bendición de Dios todopoderoso, Padre, Hijo y Espíritu Santo, descienda sobre vosotros y os acompañe siempre.\nR/. Amén.\n\nDiácono o Sacerdote: Podéis ir en paz.",
      peopleResponse = "R/. Demos gracias a Dios.",
      rubric = "Los fieles reciben la bendición de Dios inclinando respetuosamente la cabeza y se santiguan.",
      latinTitle = "Ritus Conclusionis et Ite, Missa Est",
      latinPeopleResponse = "R/. Deo gratias.",
      explanation = "Somos enviados al mundo como testigos del Resucitado para vivir la Eucaristía en nuestras obras cotidianas."
    )
  )
}
