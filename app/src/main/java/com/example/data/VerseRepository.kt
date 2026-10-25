package com.example.data

import com.example.model.BibleVerse
import com.example.model.VerseCategory
import java.util.Calendar
import kotlin.random.Random

object VerseRepository {

  val verses: List<BibleVerse> = listOf(
    BibleVerse(
      id = "jer_29_11",
      citation = "Jeremías 29:11",
      text = "«Porque yo sé muy bien los planes que tengo para ustedes —afirma el Señor—, planes de bienestar y no de calamidad, a fin de darles un futuro y una esperanza.»",
      category = VerseCategory.ESPERANZA,
      godSaysToday = "Hijo mío, tus pasos no están a la deriva. Tengo preparado un camino de paz para ti; confía en mi providencia incluso cuando no veas el horizonte.",
      modernMeaning = "En una sociedad acelerada donde la incertidumbre laboral, económica y personal provoca ansiedad por el futuro, Dios te recuerda que tu vida no depende del azar o las crisis del mundo, sino de un diseño amoroso que busca tu bien integral y tu salvación.",
      practicalApplication = "Hoy, cuando sientas urgencia o preocupación por los próximos meses o años, haz una pausa de 1 minuto, respira profundamente y repite: «Señor, en tus manos pongo mis proyectos». Concéntrate en dar lo mejor en la tarea que tienes frente a ti ahora.",
      virtue = "Esperanza",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "is_41_10",
      citation = "Isaías 41:10",
      text = "«No temas, porque yo estoy contigo; no te angusties, porque yo soy tu Dios. Te fortaleceré y te ayudaré; te sostendré con mi diestra victoriosa.»",
      category = VerseCategory.FORTALEZA,
      godSaysToday = "No cargues solo con tus temores. Mi mano firme te sostiene en cada momento. Descansa en mi poder y camina sin miedo.",
      modernMeaning = "El miedo paraliza, desgasta la mente e impide tomar decisiones sabias. Este pasaje nos revela que el antídoto contra el temor moderno no es la autosuficiencia humana, sino la presencia viva y constante de Dios en medio de la prueba.",
      practicalApplication = "Identifica la conversación, reunión o situación que más te asusta enfrentar hoy. Antes de entrar o responder, visualiza la mano de Dios cubriendo tu hombro y di interiormente: «Dios está conmigo, no temo nada».",
      virtue = "Fortaleza",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "fil_4_6_7",
      citation = "Filipenses 4:6-7",
      text = "«No se inquieten por nada; más bien, en toda ocasión, con oración y ruego, presenten sus peticiones a Dios y denle gracias. Y la paz de Dios, que sobrepasa todo entendimiento, cuidará sus corazones y sus pensamientos en Cristo Jesús.»",
      category = VerseCategory.PAZ,
      godSaysToday = "Respira hondo y entrégame tus agobios. Nada se escapa de mi mirada de Padre. Mi paz custodiará tu mente hoy.",
      modernMeaning = "El estrés crónico y el bombardeo constante de notificaciones saturan nuestros pensamientos. San Pablo nos enseña a transformar la preocupación destructiva en oración constructiva acompañada de agradecimiento.",
      practicalApplication = "Cada vez que sientas que un pensamiento repetitivo te roba la tranquilidad hoy, anótalo en una nota o en tu cuaderno de oraciones, dale gracias a Dios por tres cosas buenas que sí tienes hoy y di: «Jesús, en Ti confío».",
      virtue = "Paz",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "sal_23_1_3",
      citation = "Salmo 23:1-3",
      text = "«El Señor es mi pastor, nada me falta; en verdes pastos me hace reposar. Hacia aguas tranquilas me guía; reconforta mi alma.»",
      category = VerseCategory.PAZ,
      godSaysToday = "Permíteme conducirte a aguas de reposo. En medio de los ruidos del mundo, déjate abrazar por mi ternura infinita.",
      modernMeaning = "La cultura actual nos empuja al consumo infinito y a sentir que siempre nos falta algo para ser felices. El Buen Pastor nos enseña que la verdadera plenitud espiritual no viene de acumular, sino de dejarse cuidar por Aquel que da descanso a la mente.",
      practicalApplication = "Dedica 5 minutos de tu jornada a desconectarte de pantallas y redes sociales. Sal a caminar o contempla en silencio el cielo, agradeciendo que Dios es tu pastor y suple lo que realmente necesitas.",
      virtue = "Paz",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "mat_11_28",
      citation = "Mateo 11:28",
      text = "«Vengan a mí todos ustedes que están cansados y agobiados, y yo les daré descanso.»",
      category = VerseCategory.CONSUELO,
      godSaysToday = "Sé cuánto te ha pesado la jornada. Ven a mi Sagrado Corazón; aquí hay un oasis de misericordia esperándote.",
      modernMeaning = "El síndrome del burnout y el cansancio emocional no se curan solo durmiendo, sino descansando el alma en Jesús. Él no nos juzga por estar agotados; nos ofrece un refugio seguro donde recuperar la alegría de vivir.",
      practicalApplication = "Al terminar tus labores o antes de dormir, no te quedes rumiando los pendientes de mañana. Cierra los ojos, exhala todo el peso del día y dile: «Jesús, te entrego mi cansancio, renueva mis fuerzas mientras duermo».",
      virtue = "Consuelo",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "jn_14_27",
      citation = "Juan 14:27",
      text = "«La paz les dejo; mi paz les doy. Yo no se la doy a ustedes como la da el mundo. No se angustien ni se acobarden.»",
      category = VerseCategory.PAZ,
      godSaysToday = "El mundo te ofrece seguridades pasajeras; Yo te entrego una paz que no depende de las circunstancias. Acógela hoy en tu corazón.",
      modernMeaning = "La paz del mundo es frágil y depende de que 'todo salga bien'. La paz de Cristo es un ancla profunda que permanece firme incluso en medio de tormentas, desilusiones o imprevistos.",
      practicalApplication = "Si hoy surge un imprevisto en el trabajo o en casa, no reacciones con ira ni pánico. Tómate 10 segundos antes de hablar y recuerda: «Tengo la paz de Cristo, ninguna tormenta exterior puede apagar mi calma interior».",
      virtue = "Paz",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "jos_1_9",
      citation = "Josué 1:9",
      text = "«Mira que te mando que te esfuerces y seas valiente; no temas ni desmayes, porque el Señor tu Dios estará contigo dondequiera que vayas.»",
      category = VerseCategory.FORTALEZA,
      godSaysToday = "Levanta tu mirada. Has sido creado para grandes cosas. Adelante, camina con fe pues Yo marcho a tu lado.",
      modernMeaning = "La valentía cristiana no es la ausencia de miedo, sino la decisión de actuar con rectitud y determinación sabiendo que Dios es tu escudo. Ningún reto que enfrentes hoy es más grande que el Dios que camina contigo.",
      practicalApplication = "Atrévete a dar ese paso que has venido postergando: esa llamada pendiente, ese proyecto postergado o esa reconciliación necesaria. Hazlo hoy con la confianza de que el Señor respalda tu esfuerzo honesto.",
      virtue = "Valor",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "rom_8_28",
      citation = "Romanos 8:28",
      text = "«Sabemos que Dios dispone todas las cosas para el bien de quienes lo aman, de los que han sido llamados de acuerdo con su propósito.»",
      category = VerseCategory.FE,
      godSaysToday = "Aun de las dificultades y las pruebas haré brotar bendición y madurez para tu alma. No te desanimes.",
      modernMeaning = "Nada en tu vida ocurre fuera del alcance de la misericordia divina. Incluso los errores cometidos, las pérdidas o las puertas cerradas son transformadas por Dios en instrumentos de crecimiento, sabiduría y gracia futura.",
      practicalApplication = "Frente a un contratiempo de hoy (un rechazo, una demora o un malentendido), cambia la queja por fe diciendo: «Señor, no entiendo por qué pasó esto, pero sé que Tú sacarás un bien mayor de esta situación».",
      virtue = "Confianza",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "sal_91_1_2",
      citation = "Salmo 91:1-2",
      text = "«Tú que habitas al amparo del Altísimo y moras a la sombra del Todopoderoso, dile al Señor: “Mi refugio, mi fortaleza, mi Dios en quien confío”.»",
      category = VerseCategory.PROTECCION,
      godSaysToday = "Bajo mis alas estás seguro. Ninguna sombra puede apagar la luz que he puesto en ti. Eres mi hijo muy amado.",
      modernMeaning = "Habitar al amparo del Altísimo significa hacer de la oración tu hogar diario, no una rueda de auxilio ocasional. Cuando tu mente permanece anclada en Dios, los peligros espirituales y la maldad pierden poder sobre ti.",
      practicalApplication = "Al salir de casa o empezar tu jornada, reza mentalmente: «Señor, sella mi mente, mi cuerpo y a mi familia con tu bendición. Eres mi escudo y mi refugio hoy».",
      virtue = "Protección",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "1cor_13_4_7",
      citation = "1 Corintios 13:4, 7",
      text = "«El amor es paciente, es bondadoso. No es envidioso ni jactancioso ni orgulloso. Todo lo disculpa, todo lo cree, todo lo espera, todo lo soporta.»",
      category = VerseCategory.AMOR,
      godSaysToday = "Ama sin medida hoy. Cuando eres instrumento de mi caridad, el Reino de los Cielos se hace tangible a tu alrededor.",
      modernMeaning = "El amor cristiano no es un simple sentimiento pasajero; es un compromiso activo de paciencia, empatía y perdón diario, especialmente hacia quienes piensan diferente o nos resultan difíciles de tratar.",
      practicalApplication = "Elige hoy a una persona que te cueste trabajo tolerar (un colega, un familiar o un vecino). Haz un acto deliberado de amabilidad hacia ella o reza una breve oración en secreto pidiendo bendiciones para su vida.",
      virtue = "Amor",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "prov_3_5_6",
      citation = "Proverbios 3:5-6",
      text = "«Confía en el Señor de todo corazón, y no en tu propia inteligencia. Reconócelo en todos tus caminos, y él allanará tus sendas.»",
      category = VerseCategory.SABIDURIA,
      godSaysToday = "Suelta la necesidad de controlarlo todo. Confía en mi sabiduría y déjame enderezar lo que parece torcido.",
      modernMeaning = "Nuestra inteligencia humana es valiosa, pero limitada. Caemos en el error cuando creemos que podemos calcularlo y solucionarlo todo por nosotros mismos sin consultar la voluntad divina.",
      practicalApplication = "Antes de tomar una decisión importante hoy (financiera, laboral o familiar), eleva una breve plegaria: «Espíritu Santo, ilumina mi mente para elegir lo que agrada a Dios y edifica mi prójimo».",
      virtue = "Sabiduría",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "is_40_31",
      citation = "Isaías 40:31",
      text = "«Pero los que confían en el Señor renovarán sus fuerzas; volarán como las águilas: correrán y no se fatigarán, caminarán y no se cansarán.»",
      category = VerseCategory.FORTALEZA,
      godSaysToday = "Cuando sientas que tus fuerzas se agotan, acude a mí en silencio. Te daré alas para sobrevolar las tormentas.",
      modernMeaning = "La fatiga espiritual y física se acumula cuando intentamos vivir con nuestras propias reservas de energía. La promesa divina es una recarga sobrenatural de ánimo, paciencia y vigor para perseverar.",
      practicalApplication = "Si a mitad de la tarde sientes que ya no puedes más, detente 3 minutos. No tomes más cafeína con prisa; bebe agua con calma, eleva tus ojos y dile a Dios: «Renueva mis fuerzas Señor, sé mi energía hoy».",
      virtue = "Fortaleza",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "sal_119_105",
      citation = "Salmo 119:105",
      text = "«Tu palabra es una lámpara a mis pies y una luz en mi camino.»",
      category = VerseCategory.SABIDURIA,
      godSaysToday = "Deja que mi Palabra ilumine tus dudas. En la oscuridad, soy la antorcha que nunca vacila ni se apaga.",
      modernMeaning = "La lámpara antigua no iluminaba 10 kilómetros por adelantado; iluminaba exactamente el siguiente paso para no tropezar. Dios no siempre te muestra el final del camino, pero siempre te da la luz necesaria para el día de hoy.",
      practicalApplication = "No te obsesiones con resolver todo el año de una sola vez. Concéntrate en dar con rectitud y bondad el paso que te corresponde dar hoy.",
      virtue = "Guía",
      testament = "Antiguo Testamento"
    ),
    BibleVerse(
      id = "gal_5_22_23",
      citation = "Gálatas 5:22-23",
      text = "«El fruto del Espíritu es amor, alegría, paz, paciencia, amabilidad, bondad, fidelidad, humildad y dominio propio.»",
      category = VerseCategory.AMOR,
      godSaysToday = "Siembra hoy una sonrisa, un gesto bondadoso y una palabra de aliento. Mi Espíritu florecerá a tu alrededor.",
      modernMeaning = "El verdadero termómetro de la vida espiritual no son las palabras pomposas, sino el trato cotidiano con las personas que nos rodean: la paciencia en el tráfico, la amabilidad en el trato y el autocontrol frente a la provocación.",
      practicalApplication = "Elige uno de los frutos del Espíritu (por ejemplo, la amabilidad o la paciencia) y conviértelo en tu lema personal durante las próximas 12 horas.",
      virtue = "Amor",
      testament = "Nuevo Testamento"
    ),
    BibleVerse(
      id = "1ped_5_7",
      citation = "1 Pedro 5:7",
      text = "«Depositen en él toda su ansiedad, porque él cuida de ustedes.»",
      category = VerseCategory.CONSUELO,
      godSaysToday = "Descarga tu mochila en mi regazo. Me importas tú, tu familia y cada lágrima secreta. Yo me encargo.",
      modernMeaning = "San Pedro utiliza un verbo que significa literalmente 'lanzar hacia arriba'. Dios no quiere que cargues con la mochila de preocupaciones que no puedes solucionar. Quiere que se la entregues activamente a Él.",
      practicalApplication = "Haz el ejercicio consciente de soltar: cuando sientas tensión en los hombros o mandíbula, relaja el cuerpo y repite: «Señor, me ocupo de lo que puedo y te entrego lo que no controlo».",
      virtue = "Consuelo",
      testament = "Nuevo Testamento"
    )
  )

  fun getDailyVerse(): BibleVerse {
    val cal = Calendar.getInstance()
    val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
    val year = cal.get(Calendar.YEAR)
    val index = (dayOfYear + year * 7) % verses.size
    return verses[index]
  }

  fun getRandomVerse(excludeId: String? = null): BibleVerse {
    val candidates = if (excludeId != null && verses.size > 1) {
      verses.filter { it.id != excludeId }
    } else {
      verses
    }
    return candidates[Random.nextInt(candidates.size)]
  }

  fun getVerseByVirtue(virtueName: String): BibleVerse {
    val matching = verses.filter { it.virtue.equals(virtueName, ignoreCase = true) }
    return if (matching.isNotEmpty()) {
      matching[Random.nextInt(matching.size)]
    } else {
      getRandomVerse()
    }
  }

  fun getVerseByCategory(category: VerseCategory): BibleVerse {
    val matching = verses.filter { it.category == category }
    return if (matching.isNotEmpty()) {
      matching[Random.nextInt(matching.size)]
    } else {
      getRandomVerse()
    }
  }

  fun getVerseById(id: String): BibleVerse? {
    return verses.find { it.id == id }
  }
}
