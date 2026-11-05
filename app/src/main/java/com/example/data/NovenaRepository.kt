package com.example.data

import com.example.model.CatholicNovena
import com.example.model.NovenaDay

object NovenaRepository {

  private fun create9Days(
    prefix: String,
    intentions: List<Pair<String, String>>,
    closingInvocations: String
  ): List<NovenaDay> {
    return intentions.mapIndexed { idx, pair ->
      val dayNum = idx + 1
      NovenaDay(
        dayNumber = dayNum,
        title = "Día $dayNum: ${pair.first}",
        meditation = pair.second,
        dailyPrayer = "Por los méritos de $prefix, te suplicamos Señor atiendas nuestra súplica en este día: ${pair.first}. $closingInvocations Padre Nuestro, Ave María y Gloria."
      )
    }
  }

  val novenas: List<CatholicNovena> = listOf(
    // 1. DIVINA MISERICORDIA
    CatholicNovena(
      id = "novena_divina_misericordia",
      title = "Novena a la Divina Misericordia",
      saintOrAdvocation = "Jesucristo Misericordioso",
      category = "Jesucristo",
      feastDate = "Segundo Domingo de Pascua (Fiesta de la Misericordia)",
      description = "Dictada por Jesús a Santa Faustina Kowalska para sumergir a toda la humanidad en el océano de su infinita misericordia.",
      openingPrayer = "Oh Dios eterno, en quien la misericordia es infinita y el tesoro de compasión inagotable, vuelve a nosotros tu mirada bondadosa y multiplica en nosotros tu misericordia, para que en los momentos difíciles no nos desesperemos ni desalentemos, sino que con gran confianza nos sometamos a tu santa voluntad, que es el Amor y la Misericordia mismos. Amén.",
      days = create9Days(
        "la Divina Misericordia",
        listOf(
          "Toda la humanidad y en especial los pecadores" to "Hoy tráeme a toda la humanidad, especialmente a todos los pecadores, y sumérgelos en el mar de mi misericordia. Así me aliviarás de la amarga tristeza en que me sume la pérdida de las almas.",
          "Las almas de los sacerdotes y religiosos" to "Hoy tráeme a las almas de los sacerdotes y religiosos, y sumérgelas en mi misericordia insondable. Ellas me dieron la fuerza para soportar mi amarga pasión.",
          "Las almas devotas y fieles" to "Hoy tráeme a todas las almas devotas y fieles, y sumérgelas en el mar de mi misericordia. Estas almas me consolaron en el camino del Calvario.",
          "Los que aún no conocen a Dios" to "Hoy tráeme a los paganos y a los que todavía no me conocen. También pensaba en ellos durante mi amarga pasión y su celo futuro consoló mi corazón.",
          "Las almas separadas de la Iglesia" to "Hoy tráeme a las almas de los que se han separado de mi Iglesia y sumérgelas en el mar de mi misericordia. Ellas desgarraban mi cuerpo y mi corazón.",
          "Las almas mansas y humildes y los niños" to "Hoy tráeme a las almas mansas y humildes, y a las almas de los niños pequeños, y sumérgelas en mi misericordia. Estas almas son las más semejantes a mi Corazón.",
          "Las almas que veneran mi misericordia" to "Hoy tráeme a las almas que veneran y ensalzan de modo particular mi misericordia. Ellas son copias vivas de mi compasión.",
          "Las almas del Purgatorio" to "Hoy tráeme a las almas que están en la cárcel del Purgatorio y sumérgelas en el abismo de mi misericordia. Que los torrentes de mi Sangre refresquen su ardor.",
          "Las almas tibias" to "Hoy tráeme a las almas tibias y sumérgelas en el abismo de mi misericordia. Estas almas son las que más dolorosamente hieren mi Corazón."
        ),
        "Jesús, en Ti confío."
      ),
      closingPrayer = "Señor Jesús, concédenos vivir siempre en la certeza de tu perdón y derramar tu amor hacia los hermanos más necesitados. Amén."
    ),

    // 2. SAGRADO CORAZÓN DE JESÚS
    CatholicNovena(
      id = "novena_sagrado_corazon",
      title = "Novena al Sagrado Corazón de Jesús",
      saintOrAdvocation = "Sagrado Corazón de Jesús",
      category = "Jesucristo",
      feastDate = "Viernes posterior al segundo domingo después de Pentecostés",
      description = "Consagración de amor y reparación al Corazón de Cristo que tanto ha amado a los hombres.",
      openingPrayer = "¡Oh Corazón divino de Jesús, digno de la adoración de los hombres y de los ángeles! Me postro ante ti para consagrarte mis afectos, mis pensamientos y toda mi existencia.",
      days = create9Days(
        "el Sagrado Corazón de Jesús",
        listOf(
          "Amor incondicional de Cristo" to "Meditamos cómo Jesús nos amó hasta el extremo, entregando su vida por nuestra redención eterna.",
          "Reparación por la indiferencia humana" to "Pedimos perdón por las ingratitudes y frialdades del mundo ante el Santísimo Sacramento.",
          "Confianza en sus promesas" to "Recordamos la promesa de consolar a las familias que veneren su Sagrado Corazón.",
          "Paz en los hogares y corazones" to "Suplicamos la bendición y concordia para nuestros hogares.",
          "Refugio en la tentación" to "Nos refugiamos en la herida del costado de Cristo frente al mal.",
          "Fervor en la vida de gracia" to "Pedimos renovar nuestro celo por la santidad y la oración.",
          "Consuelo a los afligidos" to "Presentamos el dolor de los enfermos, desamparados y desolados.",
          "Perseverancia final" to "Pedimos la gracia de morir en amistad con Dios y recibir los Santos Sacramentos.",
          "Reinado de amor en el mundo" to "Oramos para que el Corazón de Jesús reine en todas las naciones."
        ),
        "¡Sagrado Corazón de Jesús, en Vos confío!"
      ),
      closingPrayer = "Oh Dios, que en el Corazón de tu Hijo nos revelaste las infinitas riquezas de tu amor, concédenos amarlo en el prójimo. Amén."
    ),

    // 3. VIRGEN DESATANUDOS
    CatholicNovena(
      id = "novena_virgen_desatanudos",
      title = "Novena a la Virgen Desatanudos",
      saintOrAdvocation = "Nuestra Señora Desatadora de Nudos",
      category = "Virgen María",
      feastDate = "8 de Diciembre y 28 de Septiembre",
      description = "Para desatar los nudos de problemas familiares, angustias, vicios y dificultades que parecen insuperables.",
      openingPrayer = "Santa María, llena de la presencia de Dios, durante los días de tu vida aceptaste con gran humildad la santa voluntad del Padre. Te suplicamos tomes en tus manos maternales los nudos que asfixian nuestra vida.",
      days = create9Days(
        "María Desatanudos",
        listOf(
          "El nudo de la desesperanza" to "Entregamos a María la falta de fe para que con su ternura devuelva la esperanza a nuestro corazón.",
          "El nudo de los rencores" to "Pedimos la gracia del perdón sincero hacia quienes nos han herido.",
          "El nudo de los conflictos familiares" to "Presentamos las discordias y divisiones para que reine la paz de Cristo.",
          "El nudo de la soledad y la tristeza" to "Pedimos el consuelo maternal para los corazones abatidos.",
          "El nudo de las preocupaciones económicas" to "Confiamos nuestras necesidades de trabajo y sustento honesto.",
          "El nudo de las enfermedades" to "Suplicamos la sanación del cuerpo y la fortaleza en el sufrimiento.",
          "El nudo de las adicciones y ataduras" to "Pedimos la liberación de vicios y hábitos destructivos.",
          "El nudo de las dudas en la fe" to "Oramos por una fe firme y dócil al Espíritu Santo.",
          "La libertad de los hijos de Dios" to "Damos gracias a María por su auxilio y nos consagramos a su corazón."
        ),
        "Virgen Desatanudos, ruega por nosotros."
      ),
      closingPrayer = "Madre amada, desata los nudos que nos impiden avanzar en el amor a Dios y a los hermanos. Por Jesucristo Nuestro Señor. Amén."
    ),

    // 4. SAN JUDAS TADEO
    CatholicNovena(
      id = "novena_san_judas_tadeo",
      title = "Novena a San Judas Tadeo",
      saintOrAdvocation = "San Judas Tadeo, Apóstol",
      category = "Causas Urgentes e Imposibles",
      feastDate = "28 de Octubre",
      description = "El gran apóstol y patrón de las causas difíciles, angustiosas y desesperadas.",
      openingPrayer = "¡Santo Apóstol San Judas Tadeo, fiel siervo y amigo de Jesús! La Iglesia te honra universalmente como el patrón de los casos difíciles y desesperados. Ruega por mí en esta tribulación.",
      days = create9Days(
        "San Judas Tadeo",
        listOf(
          "Llamado y vocación apostólica" to "Meditamos la prontitud de San Judas para dejarlo todo y seguir las huellas de Cristo.",
          "Amor ferviente al Maestro" to "Contemplamos el ardor con que San Judas consoló a Cristo en la Última Cena.",
          "Fe inquebrantable" to "Pedimos una fe viva que no vacile ante las pruebas de este mundo.",
          "Celo por la salvación de las almas" to "Suplicamos entusiasmo misionero para dar testimonio del Evangelio.",
          "Constancia en el martirio" to "Recordamos su glorioso martirio derramando su sangre por amor a Cristo.",
          "Auxilio en la angustia" to "Acudimos a su valiosa intercesión cuando todas las puertas humanas parecen cerradas.",
          "Fortaleza en el sufrimiento" to "Pedimos la paciencia de los santos ante las aflicciones.",
          "Conversión de los pecadores" to "Oramos por los que viven alejados de la gracia divina.",
          "Agradecimiento por las gracias recibidas" to "Renovamos nuestra devoción prometiendo dar a conocer su nombre."
        ),
        "San Judas Tadeo, apóstol glorioso, haz que mis penas se conviertan en gozo."
      ),
      closingPrayer = "Glorioso San Judas Tadeo, haz que sintamos tu socorro celestial y alcancemos la gloria eterna. Amén."
    ),

    // 5. SAN JOSÉ
    CatholicNovena(
      id = "novena_san_jose",
      title = "Novena a San José",
      saintOrAdvocation = "San José, Castísimo Esposo de María",
      category = "Santos Intercesores",
      feastDate = "19 de Marzo y 1 de Mayo (San José Obrero)",
      description = "Custodio del Redentor y Patrono Universal de la Iglesia, de los trabajadores y de la buena muerte.",
      openingPrayer = "¡Oh glorioso Patriarca San José, a cuyo poder Dios confió a Jesús y a María! Sé nuestro protector en la tierra y alcánzanos una vida pura y una santa muerte.",
      days = create9Days(
        "San José",
        listOf(
          "Hombre justo y obediente" to "Meditamos la santidad silenciosa de José ante el misterio de la Encarnación.",
          "Custodio de la Sagrada Familia" to "Contemplamos su entrega solícita protegiendo al Niño en Belén y Egipto.",
          "Dignidad del trabajo" to "Oramos por los trabajadores y por quienes carecen de empleo digno.",
          "Pureza y castidad" to "Pedimos un corazón limpio de toda malicia terrena.",
          "Modelo de padre y esposo" to "Suplicamos por la fidelidad y santificación de los matrimonios.",
          "Silencio y vida interior" to "Pedimos amor al recogimiento y a la oración sin ostentación.",
          "Terror de los demonios" to "Nos acogemos a su amparo contra las acechanzas del infierno.",
          "Protector de la Santa Iglesia" to "Oramos por el Papa, los obispos y todo el pueblo de Dios.",
          "Patrono de la buena muerte" to "Pedimos expirar en brazos de Jesús, María y José."
        ),
        "San José, padre nutricio del Señor, ruega por nosotros."
      ),
      closingPrayer = "San José, protector nuestro, enséñanos a vivir cerca de Jesús y María en el quehacer de cada día. Amén."
    ),

    // 6. ESPÍRITU SANTO
    CatholicNovena(
      id = "novena_espiritu_santo",
      title = "Novena al Espíritu Santo",
      saintOrAdvocation = "El Espíritu Santo Consolador",
      category = "Jesucristo",
      feastDate = "Solemnidad de Pentecostés",
      description = "La novena original de la Iglesia, rezada con María en el Cenáculo esperando el fuego de Pentecostés.",
      openingPrayer = "Ven, Espíritu Santo, llena los corazones de tus fieles y enciende en ellos el fuego de tu amor. Envía tu Espíritu y serán creados, y renovarás la faz de la tierra.",
      days = create9Days(
        "el Espíritu Santo",
        listOf(
          "Don de Sabiduría" to "Para saborear las cosas divinas por encima de las vanidades del mundo.",
          "Don de Entendimiento" to "Para penetrar con fe viva las verdades reveladas en la Escritura.",
          "Don de Consejo" to "Para discernir siempre el camino recto en las encrucijadas de la vida.",
          "Don de Fortaleza" to "Para sobrellevar las pruebas con valentía cristiana.",
          "Don de Ciencia" to "Para reconocer la huella del Creador en toda la creación.",
          "Don de Piedad" to "Para amar a Dios como Padre tierno y al prójimo como hermano.",
          "Don de Temor de Dios" to "Para evitar el pecado por amor filial a nuestro Señor.",
          "Los Doce Frutos del Espíritu" to "Pedimos caridad, gozo, paz, paciencia, bondad y templanza.",
          "Fuego renovador de Pentecostés" to "Suplicamos un nuevo Pentecostés sobre la Iglesia entera."
        ),
        "¡Espíritu Santo, ilumínanos y santifícanos!"
      ),
      closingPrayer = "Dios omnipotente, derrama sobre nosotros los dones de tu Espíritu Santo para ser testigos fieles de Cristo. Amén."
    ),

    // 7. VIRGEN DE GUADALUPE
    CatholicNovena(
      id = "novena_virgen_guadalupe",
      title = "Novena a la Virgen de Guadalupe",
      saintOrAdvocation = "Nuestra Señora de Guadalupe",
      category = "Virgen María",
      feastDate = "12 de Diciembre",
      description = "«¿No estoy yo aquí que soy tu Madre?». Amparo, consuelo y protección para todos sus hijos.",
      openingPrayer = "Virgen Santísima de Guadalupe, Madre del verdadero Dios por quien se vive. Humildemente nos postramos ante tu bendita imagen grabada en el ayate de Juan Diego.",
      days = create9Days(
        "la Virgen de Guadalupe",
        listOf(
          "Aparición en el Tepeyac" to "Recordamos las palabras de ternura dirigidas al humilde San Juan Diego.",
          "«¿No estoy yo aquí que soy tu Madre?»" to "Descansamos nuestras angustias en su regazo maternal.",
          "Defensa de la vida humana" to "Pedimos por la protección de los niños no nacidos y de los ancianos.",
          "Unidad de las familias" to "Oramos por la reconciliación y fraternidad en nuestros hogares.",
          "Consuelo en la enfermedad" to "Suplicamos la salud como curó al tío Juan Bernardino.",
          "Conversión de los corazones" to "Pedimos que su amor atraiga a todos los que viven en tinieblas.",
          "Paz en nuestras patrias" to "Rogamos por el fin de la violencia y la injusticia social.",
          "Celo misionero" to "Nos comprometemos a llevar el Evangelio de Jesús a los demás.",
          "Fidelidad hasta el cielo" to "Pedimos ser recibidos por Ella al final de nuestra peregrinación terrena."
        ),
        "Santa María de Guadalupe, Reina de México y Emperatriz de América, ruega por nosotros."
      ),
      closingPrayer = "Madre de Guadalupe, quédate con nosotros y bendice a nuestras familias hoy y siempre. Amén."
    ),

    // 8. SAN MIGUEL ARCÁNGEL
    CatholicNovena(
      id = "novena_san_miguel",
      title = "Novena a San Miguel Arcángel",
      saintOrAdvocation = "San Miguel Arcángel",
      category = "Arcángeles y Ángeles",
      feastDate = "29 de Septiembre",
      description = "«¿Quién como Dios?». Defensor supremo en la batalla espiritual contra el demonio y las fuerzas del mal.",
      openingPrayer = "San Miguel Arcángel, defiéndenos en la lucha. Sé nuestro amparo contra la perversidad y las acechanzas del demonio. Que Dios manifieste sobre él su poder, es nuestra humilde súplica.",
      days = create9Days(
        "San Miguel Arcángel",
        listOf(
          "Victoria en el cielo: «¿Quién como Dios?»" to "Meditamos la fidelidad absoluta de San Miguel ante la rebelión de Lucifer.",
          "Defensor del pueblo de Dios" to "Confiamos la Iglesia a su espada protectora frente a los errores del mundo.",
          "Auxilio en las tentaciones" to "Pedimos su escudo de luz cuando el enemigo intente sembrar la duda.",
          "Pesador de las almas" to "Oramos por nuestra alma para que comparezca limpia ante el juicio divino.",
          "Guardián de la fe católica" to "Suplicamos fortaleza para profesar el Credo sin avergonzarnos.",
          "Consuelo de las almas del Purgatorio" to "Pedimos a San Miguel que conduzca a los difuntos a la presencia de Dios.",
          "Protección de nuestros hogares" to "Colocamos a nuestras familias bajo sus alas protectoras.",
          "Humildad y obediencia" to "Aprendemos de San Miguel a rendir toda gloria a Dios Padre.",
          "Triunfo final de Cristo" to "Nos unimos al clamor angélico adorando a la Santísima Trinidad."
        ),
        "Príncipe de la Milicia Celestial, arroja al infierno con el divino poder a Satanás."
      ),
      closingPrayer = "Oh Dios, que con admirable providencia dispones los ministerios de ángeles y hombres, concédenos el auxilio de San Miguel en la tierra. Amén."
    ),

    // 9. VIRGEN DEL CARMEN
    CatholicNovena(
      id = "novena_virgen_carmen",
      title = "Novena a la Virgen del Carmen",
      saintOrAdvocation = "Nuestra Señora del Monte Carmelo",
      category = "Virgen María",
      feastDate = "16 de Julio",
      description = "Madre, Reina y Hermosura del Carmelo. Promesa de salvación a través del Santo Escapulario.",
      openingPrayer = "¡Oh Virgen María, Madre y Reina del Carmelo! Humildemente te ofrecemos esta novena en señal de filial amor, agradeciéndote el don de tu Santo Escapulario.",
      days = create9Days(
        "la Virgen del Carmen",
        listOf(
          "Estrella del Mar" to "Guía a nuestras almas en medio de las tempestades de la vida presente.",
          "El Santo Escapulario" to "Vestimos tu insignia consagrándote nuestra pureza y nuestras obras.",
          "Privilegio Sabatino" to "Oramos por la pronta liberación de las almas del Purgatorio.",
          "Vida de oración continua" to "Aprendemos de los ermitaños del Carmelo la unión íntima con Dios.",
          "Pureza de corazón" to "Pedimos la blancura inmaculada en nuestros pensamientos y afectos.",
          "Protección en los peligros" to "Nos acogemos a tu manto maternal ante las adversidades temporales.",
          "Consuelo en la agonía" to "Sé nuestro amparo en la hora suprema de nuestra partida.",
          "Celo apostólico" to "Deseamos extender tu devoción por el mundo entero.",
          "Coronación celestial" to "Esperamos alabarte eternamente en la patria celestial."
        ),
        "Flor del Carmelo, vid florida, corona del cielo, ruega por nosotros."
      ),
      closingPrayer = "Madre del Carmen, cúbrenos con tu escapulario y llévanos al encuentro de Jesús. Amén."
    ),

    // 10. NIÑO JESÚS DE PRAGA
    CatholicNovena(
      id = "novena_nino_jesus_praga",
      title = "Novena al Niño Jesús de Praga",
      saintOrAdvocation = "Milagroso Niño Jesús de Praga",
      category = "Jesucristo",
      feastDate = "Primer Domingo de Mayo y 25 de Diciembre",
      description = "«Cuanto más me honréis, tanto más os bendeciré». Auxilio en las dificultades financieras, de salud y familiares.",
      openingPrayer = "¡Oh Divino Niño Jesús de Praga, Rey de los cielos y de la tierra! Me postro ante tu sagrada imagen reconociendo mi debilidad y proclamando tu infinita omnipotencia.",
      days = create9Days(
        "el Niño Jesús de Praga",
        listOf(
          "Humildad y sencillez de la infancia" to "Aprendemos a hacernos como niños para entrar en el Reino de los Cielos.",
          "Mano derecha que bendice" to "Pedimos que extienda su santa mano sobre nuestras vidas y proyectos.",
          "El orbe en su mano izquierda" to "Reconocemos que el universo entero se sostiene por su palabra divina.",
          "Confianza plena en su Providencia" to "Depositamos nuestras necesidades materiales y espirituales en su bondad.",
          "Paz en las familias y con los vecinos" to "Suplicamos la dulce paz del pesebre en nuestros hogares.",
          "Sanación de los enfermos" to "Pedimos alivio y salud para los que sufren en el cuerpo o en el alma.",
          "Protección de los niños del mundo" to "Oramos por la inocencia y el cuidado de la niñez desamparada.",
          "Perdón y reconciliación" to "Acudimos a su misericordia implorando la gracia del arrepentimiento.",
          "Bendición perpetua" to "Prometemos difundir su devoción y confiar siempre en su realeza divina."
        ),
        "¡Divino Niño Jesús de Praga, bendícenos y sálvanos!"
      ),
      closingPrayer = "Dulce Niño Jesús, atiende nuestros ruegos y concédenos la paz en esta vida y la gloria en la otra. Amén."
    ),

    // 11. SANTA RITA DE CASIA
    CatholicNovena(
      id = "novena_santa_rita",
      title = "Novena a Santa Rita de Casia",
      saintOrAdvocation = "Santa Rita de Casia, Viuda y Religiosa",
      category = "Causas Urgentes e Imposibles",
      feastDate = "22 de Mayo",
      description = "La santa de los imposibles y de los casos desesperados. Esposa paciente, madre y religiosa estigmatizada con la espina.",
      openingPrayer = "¡Oh gloriosa Santa Rita, abogada de los imposibles! Desde el trono de gloria donde estás, vuelve tus ojos compasivos hacia mí, que me encuentro en angustiosa necesidad.",
      days = create9Days(
        "Santa Rita de Casia",
        listOf(
          "Paciencia inagotable" to "Meditamos cómo soportó con dulzura las asperezas de su matrimonio logrando la conversión de su esposo.",
          "Madre ejemplar" to "Contemplamos su amor heroico prefiriendo la muerte inocente de sus hijos antes que verlos pecar.",
          "Amor a la reconciliación" to "Aprendemos a ser constructores de paz extinguiendo todo rencor.",
          "Vocación religiosa milagrosa" to "Admiramos su entrada prodigiosa en el convento de las agustinas de Casia.",
          "La espina en la frente" to "Meditamos su unión mística con Cristo recibiendo la llaga de la Pasión.",
          "Consuelo en la soledad" to "Nos refugiamos en su intercesión cuando nos sintamos incomprendidos.",
          "La rosa y los higos en el invierno" to "Confiamos en que Dios puede hacer florecer prodigios en medio de nuestra aridez.",
          "Poder ante el trono divino" to "Presentamos el caso imposible que hoy aflige nuestro corazón.",
          "Corona de santidad" to "Pedimos la perseverancia en la fe hasta nuestro último aliento."
        ),
        "Santa Rita, abogada de los imposibles, ruega por nosotros."
      ),
      closingPrayer = "Santa Rita bendita, que nada te es negado por el Señor, alcánzanos la gracia que con fe te pedimos. Amén."
    ),

    // 12. SAN BENITO ABAD
    CatholicNovena(
      id = "novena_san_benito",
      title = "Novena a San Benito Abad",
      saintOrAdvocation = "San Benito de Nursia, Patriarca de los Monjes",
      category = "Santos Intercesores",
      feastDate = "11 de Julio",
      description = "Protección contra asechanzas del enemigo, envidias, venenos y peligros para el alma. «Ora et Labora».",
      openingPrayer = "¡Glorioso San Benito, padre de monjes y maestro de la vida espiritual! Te suplicamos que con la Santa Cruz alejes de nosotros todo mal, tentación y discordia.",
      days = create9Days(
        "San Benito Abad",
        listOf(
          "Oración y trabajo («Ora et Labora»)" to "Para santificar el tiempo cotidiano con el orden y la oración constante.",
          "Poder de la Santa Cruz" to "Que la Cruz sagrada sea nuestra luz («Crux Sacra Sit Mihi Lux»).",
          "Rechazo del maligno" to "Que el dragón infernal no sea nuestro guía («Non Draco Sit Mihi Dux»).",
          "Victoria sobre el veneno del pecado" to "Recordamos cómo el cáliz con veneno se quebró ante la señal de la cruz de San Benito.",
          "Silencio y paz interior" to "Para escuchar la voz de Dios en el sosiego del corazón.",
          "Caridad y hospitalidad" to "Para acoger a los pobres y peregrinos como al mismo Cristo.",
          "Discernimiento de espíritus" to "Para no dejarnos engañar por las falsas ilusiones del mundo.",
          "Protección de nuestros hogares" to "Para que los hogares queden sellados contra todo maleficio y división.",
          "Tránsito glorioso al cielo" to "Para expirar de pie, alimentados con el Cuerpo del Señor."
        ),
        "San Benito glorioso, líbranos de todo mal."
      ),
      closingPrayer = "Señor, por intercesión de San Benito, haz que busquemos tu gloria por encima de todas las cosas. Amén."
    ),

    // 13. SANTA TERESITA DEL NIÑO JESÚS
    CatholicNovena(
      id = "novena_santa_teresita",
      title = "Novena a Santa Teresita del Niño Jesús",
      saintOrAdvocation = "Santa Teresita de Lisieux (Doctora de la Iglesia)",
      category = "Santos Intercesores",
      feastDate = "1 de Octubre",
      description = "La Novena de las Rosas. «Pasaré mi cielo haciendo el bien en la tierra; enviaré una lluvia de rosas».",
      openingPrayer = "¡Oh Santa Teresita del Niño Jesús, florecilla blanca del Carmelo! Me acerco a ti con filial confianza, implorando alcances de Dios la lluvia de rosas de sus gracias sobre mi vida.",
      days = create9Days(
        "Santa Teresita",
        listOf(
          "El Caminito de la infancia espiritual" to "Para confiar en Dios como un niño pequeño en brazos de su padre.",
          "Amor en el corazón de la Iglesia" to "«¡En el corazón de la Iglesia, mi Madre, yo seré el amor!»",
          "Santificar los pequeños detalles" to "Para realizar con infinito amor las labores más sencillas del día.",
          "Abandono total a la Divina Voluntad" to "Para aceptar con gozo las contrariedades y las cruces secretas.",
          "Celo por los sacerdotes y misioneros" to "Oramos por la fidelidad y santidad del clero en todo el mundo.",
          "Sonreír en medio del sufrimiento" to "Para transformar las penas en ofrenda silenciosa de expiación.",
          "Confianza ciega en la misericordia" to "Para no desanimarnos jamás a causa de nuestras debilidades.",
          "Lluvia de rosas del cielo" to "Pedimos la gracia de recibir la rosa prometida de su intercesión.",
          "Entrada en la Vida Eterna" to "«¡Dios mío, te amo!». Para morir pronunciando el dulce nombre de Jesús."
        ),
        "Santa Teresita del Niño Jesús, ruega por nosotros."
      ),
      closingPrayer = "Santa Teresita, derrama tu lluvia de rosas y ayúdanos a amar a Jesús como tú le amaste. Amén."
    ),

    // 14. SAN ANTONIO DE PADUA
    CatholicNovena(
      id = "novena_san_antonio",
      title = "Novena a San Antonio de Padua",
      saintOrAdvocation = "San Antonio de Padua, Doctor Evangélico",
      category = "Santos Intercesores",
      feastDate = "13 de Junio",
      description = "Patrono de los pobres, auxilio para encontrar cosas perdidas y protector de las causas familiares.",
      openingPrayer = "¡Oh bendito San Antonio, espejo de pureza y prodigio de caridad! Por el tierno amor con que abrazaste al Niño Jesús en tus brazos, acoge con bondad mis súplicas.",
      days = create9Days(
        "San Antonio de Padua",
        listOf(
          "Hallar la gracia perdida" to "Para reencontrar la amistad con Dios si la hemos perdido por el pecado.",
          "Pureza de corazón" to "Para conservar el lirio de la pureza en medio del mundo.",
          "Amor a las Sagradas Escrituras" to "Para meditar con fervor la Palabra viva de Dios.",
          "Caridad con los necesitados" to "Para practicar el Pan de San Antonio compartiendo con el hambriento.",
          "Paz en los matrimonios y noviazgos" to "Para bendecir a las parejas con fidelidad, respeto y amor santo.",
          "Milagros y prodigios de Dios" to "Para recordar que el Señor escucha la oración de los sencillos.",
          "Humildad y mansedumbre" to "Para vencer el orgullo y la soberbia en nuestras relaciones.",
          "Protección de los que viajan" to "Para guiar nuestros pasos por senderos de paz y seguridad.",
          "Corona de gloria eterna" to "Para un día alabar a la Santísima Trinidad en el paraíso."
        ),
        "San Antonio glorioso, alcánzanos lo que con fe pedimos."
      ),
      closingPrayer = "Señor Dios, haz que la intercesión de San Antonio nos llene de alegría y nos obtenga la gracia que solicitamos. Amén."
    ),

    // 15. VIRGEN DE FÁTIMA
    CatholicNovena(
      id = "novena_virgen_fatima",
      title = "Novena a la Virgen de Fátima",
      saintOrAdvocation = "Nuestra Señora del Rosario de Fátima",
      category = "Virgen María",
      feastDate = "13 de Mayo",
      description = "«Al final mi Inmaculado Corazón triunfará». Llamado a la oración del Santo Rosario, la penitencia y la consagración.",
      openingPrayer = "¡Oh Virgen de Fátima, Madre de misericordia y Reina del cielo! Nos postramos humildemente ante ti, recordando tu mensaje de paz, conversión y salvación para las almas.",
      days = create9Days(
        "la Virgen de Fátima",
        listOf(
          "Llamado a la conversión" to "Para volver nuestros corazones a Dios mediante el sacramento del perdón.",
          "Rezo diario del Santo Rosario" to "Para meditar cada día los misterios de la salvación por la paz del mundo.",
          "El ángel de la paz" to "«Dios mío, yo creo, adoro, espero y os amo; os pido perdón por los que no creen...»",
          "Consagración al Corazón Inmaculado" to "Consagramos nuestras vidas, familias y naciones a su amparo maternal.",
          "Reparación de los primeros sábados" to "Para consolar su Corazón herido por las ofensas y blasfemias.",
          "Oración por los pecadores" to "Para salvar a las almas del fuego del infierno con sacrificios diarios.",
          "El milagro del sol" to "Para confirmar nuestra fe en el triunfo soberano del Señor Jesús.",
          "Los santos pastorcitos Francisco y Jacinta" to "Para imitar su pureza, amor al Sagrario y generosidad heroica.",
          "Triunfo del Corazón de María" to "Esperamos con confianza la victoria final de la paz de Cristo en la tierra."
        ),
        "Nuestra Señora de Fátima, ruega por nosotros."
      ),
      closingPrayer = "Madre de Fátima, enséñanos a reparar los ultrajes cometidos contra el Señor y a vivir en su gracia. Amén."
    ),

    // 16. INMACULADA CONCEPCIÓN
    CatholicNovena(
      id = "novena_inmaculada_concepcion",
      title = "Novena a la Inmaculada Concepción",
      saintOrAdvocation = "La Inmaculada Concepción de María",
      category = "Virgen María",
      feastDate = "8 de Diciembre",
      description = "Preparación solemne para la gran fiesta de la Concepción purísima de María, preservada de toda mancha de pecado.",
      openingPrayer = "¡Bendita sea tu pureza y eternamente lo sea! Pues todo un Dios se recrea en tan graciosa belleza. A ti, celestial Princesa, Virgen Sagrada María, te ofrezco en este día alma, vida y corazón.",
      days = create9Days(
        "la Inmaculada Concepción",
        listOf(
          "Preservada del pecado original" to "Contemplamos a María llena de gracia desde el primer instante de su ser.",
          "La Aurora de la Redención" to "Ella anuncia la llegada del Sol de Justicia, Jesucristo Nuestro Salvador.",
          "Victoria sobre la serpiente antigua" to "«Pondré enemistad entre ti y la mujer... Ella te aplastará la cabeza».",
          "Belleza sin mancha («Tota Pulchra»)" to "«Toda hermosa eres, María, y en ti no hay mancha de pecado».",
          "Templo vivo del Espíritu Santo" to "Para que nuestras almas sean moradas limpias y agradables a Dios.",
          "Obediencia del «Hágase»" to "Para responder con generosidad absoluta al plan de Dios en nuestras vidas.",
          "Madre de los vivientes" to "Acogemos su maternidad espiritual al pie de la Cruz del Gólgota.",
          "Protectora de la juventud y las familias" to "Para custodiar la castidad y el pudor cristiano en la sociedad.",
          "Reina concebida sin pecado" to "Nos unimos al himno de la Iglesia glorificando al Padre por esta joya divina."
        ),
        "María Inmaculada, sin pecado concebida, ruega por nosotros que recurrimos a ti."
      ),
      closingPrayer = "Oh Dios, que por la Inmaculada Concepción de la Virgen preparaste una digna morada a tu Hijo, concédenos llegar limpios a tu presencia. Amén."
    ),

    // 17. SAN EXPEDITO
    CatholicNovena(
      id = "novena_san_expedito",
      title = "Novena a San Expedito",
      saintOrAdvocation = "San Expedito, Mártir",
      category = "Causas Urgentes e Imposibles",
      feastDate = "19 de Abril",
      description = "Mártir romano patrón de las causas urgentes, los pleitos justos y la superación de la postergación espiritual («¡Hodie! / ¡Hoy!»).",
      openingPrayer = "¡Señor Jesús, que premias a quienes te son fieles hasta el martirio! Acudimos con confianza a la intercesión de San Expedito para que nos auxilie con presteza en nuestras necesidades.",
      days = create9Days(
        "San Expedito",
        listOf(
          "No postergar la conversión: «¡Hodie!»" to "Para rechazar la tentación del maligno que dice «cras» (mañana) y elegir a Dios «hoy».",
          "Fidelidad del soldado de Cristo" to "Para defender nuestra fe con valentía en medio de las burlas del mundo.",
          "Auxilio en los momentos de angustia urgente" to "Para presentar los asuntos que requieren solución pronta conforme a la justicia.",
          "Paz en los conflictos y litigios" to "Para encontrar la concordia fraterna y resolver diferencias pacíficamente.",
          "Fortaleza ante el sufrimiento" to "Para imitar la firmeza del mártir que no reniega del nombre de Cristo.",
          "Esperanza en la Providencia divina" to "Para no desesperar cuando todo parece urgente y desbordante.",
          "Desprendimiento de las honras mundanas" to "Para anteponer la gloria de Dios a cualquier ascenso o vanidad terrena.",
          "Caridad con los necesitados" to "Para socorrer con prontitud al que padece frío, hambre o tristeza.",
          "Corona imperecedera" to "Para correr con constancia la carrera que nos conduce a la vida eterna."
        ),
        "San Expedito, noble mártir, atiéndenos con prontitud."
      ),
      closingPrayer = "San Expedito glorioso, alcánzanos una pronta respuesta a nuestras plegarias y la gracia de no dejar para mañana nuestra entrega a Dios. Amén."
    ),

    // 18. SAN JUAN PABLO II
    CatholicNovena(
      id = "novena_san_juan_pablo_ii",
      title = "Novena a San Juan Pablo II",
      saintOrAdvocation = "San Juan Pablo II, Papa",
      category = "Santos Intercesores",
      feastDate = "22 de Octubre",
      description = "«¡No tengáis miedo! Abrid de par en par las puertas a Cristo». Peregrino de la paz, apóstol de la familia y de la juventud.",
      openingPrayer = "¡Oh Dios, rico en misericordia, que llamaste al Papa San Juan Pablo II a guiar tu Iglesia universal! Concédenos, instruidos por sus enseñanzas, abrir con valentía el corazón a Cristo.",
      days = create9Days(
        "San Juan Pablo II",
        listOf(
          "«¡No tengáis miedo!»" to "Para vencer los temores humanos y proclamar a Cristo en la vida pública.",
          "Totus Tuus («Todo tuyo, María»)" to "Para consagrarnos enteramente a la Virgen María en todas nuestras acciones.",
          "El Evangelio de la Vida" to "Para defender la dignidad sagrada de toda vida humana desde la concepción.",
          "La familia: santuario de la vida" to "Oramos por la santidad y fortaleza de los hogares en el amor fecundo.",
          "Los jóvenes: esperanza de la Iglesia" to "Para que la juventud no se rinda ante la mediocridad y busque la santidad.",
          "El valor redentor del sufrimiento" to "Para unir nuestras dolencias a la Cruz redentora de Jesucristo.",
          "Apóstol de la Divina Misericordia" to "Para proclamar al mundo herido que el amor de Dios es más fuerte que el mal.",
          "Diálogo y civilización del amor" to "Para ser constructores de paz entre las naciones y los pueblos.",
          "«Me habéis buscado y he venido a vosotros»" to "Para cruzar el umbral de la esperanza y entrar en la gloria del Padre."
        ),
        "San Juan Pablo II, ruega por nosotros."
      ),
      closingPrayer = "Señor, por intercesión de San Juan Pablo II, renueva a la Iglesia y bendice a nuestras familias con tu gracia salvadora. Amén."
    ),

    // 19. VIRGEN DE LOURDES
    CatholicNovena(
      id = "novena_virgen_lourdes",
      title = "Novena a la Virgen de Lourdes",
      saintOrAdvocation = "Nuestra Señora de Lourdes",
      category = "Virgen María",
      feastDate = "11 de Febrero (Jornada Mundial del Enfermo)",
      description = "Salud de los enfermos y consuelo de los afligidos. «Yo soy la Inmaculada Concepción».",
      openingPrayer = "¡Oh Virgen de Lourdes, Madre de ternura y consuelo! Te presentamos nuestras enfermedades del cuerpo y del alma, confiando en las aguas vivas de la gracia divina.",
      days = create9Days(
        "la Virgen de Lourdes",
        listOf(
          "La gruta de Massabielle" to "Para encontrar a Dios en los lugares humildes y en la sencillez del corazón.",
          "La fuente de agua viva" to "Para purificarnos en las aguas bautismales y renovar nuestra devoción.",
          "Salud de los enfermos" to "Pedimos la sanación física de quienes padecen dolencias graves.",
          "Sanación interior y del alma" to "Para curar las heridas emocionales, el rencor y la angustia.",
          "La oración del Santo Rosario" to "Para sostener las cuentas del Rosario como hizo Santa Bernardita en la gruta.",
          "Penitencia y conversión" to "Para ofrecer pequeños sacrificios por la salvación de los pecadores.",
          "Compasión con los que sufren" to "Para acompañar con amor a los ancianos, enfermos y solos.",
          "Pureza de intención" to "Para buscar solo la gloria de Dios sin vanidad terrena.",
          "Consuelo en la prueba final" to "Para recibir con paz los sacramentos y esperar la resurrección dichosa."
        ),
        "Nuestra Señora de Lourdes, salud de los enfermos, ruega por nosotros."
      ),
      closingPrayer = "Madre de Lourdes, cura nuestras llagas, fortalece nuestra fe y condúcenos a tu divino Hijo Jesús. Amén."
    ),

    // 20. SANTA FILOMENA
    CatholicNovena(
      id = "novena_santa_filomena",
      title = "Novena a Santa Filomena",
      saintOrAdvocation = "Santa Filomena, Virgen y Mártir",
      category = "Causas Urgentes e Imposibles",
      feastDate = "11 de Agosto",
      description = "Virgen y mártir portentosa de las catacumbas romanas, amada por el Santo Cura de Ars por su infinito poder de intercesión.",
      openingPrayer = "¡Oh gloriosa Santa Filomena, virgen invencible y mártir intrépida! Por la pureza inmaculada con que te entregaste a Cristo y por tu martirio sangriento, dígnate interceder por mí.",
      days = create9Days(
        "Santa Filomena",
        listOf(
          "Amor heroico a Jesús" to "Para rechazar todas las promesas del mundo antes que ofender a nuestro Dios.",
          "Voto de virginidad" to "Para conservar el templo de nuestro cuerpo en santidad y pureza.",
          "Valentía en el tormento" to "Para permanecer firmes ante los azotes y las pruebas de la vida.",
          "Milagro de las flechas" to "Para que los dardos del maligno se vuelvan inofensivos ante la gracia divina.",
          "Poder de intercesión ilimitado" to "Para presentar ante Dios las causas que parecen no tener salida humana.",
          "Amiga de los niños y jóvenes" to "Para custodiar a la juventud de los peligros y seducciones del mundo.",
          "Espíritu de alabanza" to "Para cantar la gloria de Dios aun en medio de las cadenas y prisiones.",
          "Generosidad en la entrega" to "Para no escatimar sacrificios por amor a la salvación de las almas.",
          "Triunfo con la palma del martirio" to "Para compartir un día la bienaventuranza con todos los santos en el cielo."
        ),
        "Santa Filomena, poderosa intercesora con Dios, ruega por nosotros."
      ),
      closingPrayer = "Señor Dios todopoderoso, que coronaste a Santa Filomena con la pureza y el martirio, concédenos su auxilio en nuestras necesidades. Amén."
    ),

    // 21. SAN PÍO DE PIETRELCINA
    CatholicNovena(
      id = "novena_padre_pio",
      title = "Novena a San Pío de Pietrelcina",
      saintOrAdvocation = "Padre Pío de Pietrelcina (Estigmatizado)",
      category = "Santos Intercesores",
      feastDate = "23 de Septiembre",
      description = "«Ora, ten fe y no te preocupes». Sacerdote capuchino marcado con los estigmas de la Pasión de Cristo, apóstol del confesionario.",
      openingPrayer = "¡Oh amado San Pío de Pietrelcina, que llevaste en tu cuerpo las llagas de la Pasión de Nuestro Señor Jesucristo! Ayúdanos a orar con fervor y a confiar plenamente en la bondad divina.",
      days = create9Days(
        "el Padre Pío",
        listOf(
          "«Ora, ten fe y no te preocupes»" to "Para desterrar la angustia estéril y abandonarnos en las manos del Padre Celestial.",
          "Amor inmenso a la Santa Misa" to "Para vivir el Santo Sacrificio del altar con devoción y recogimiento sagrado.",
          "El Santo Rosario como arma invencible" to "Para rezar el Rosario con devoción cotidiana contra el maligno.",
          "Apóstol del confesionario" to "Para acudir con frecuencia y dolor de corazón al sacramento de la Reconciliación.",
          "Los estigmas de la Pasión" to "Para aprender a amar la cruz y ofrecer nuestros sufrimientos por la Iglesia.",
          "Caridad con los enfermos (Casa Alivio del Sufrimiento)" to "Para servir a Cristo en el prójimo necesitado y adolorido.",
          "Comunión con el Santo Ángel de la Guarda" to "Para invocar con frecuencia la ayuda de nuestro ángel custodio.",
          "Amor ardiente a la Virgen María" to "Para honrar a nuestra Madre celestial en todas las horas de la vida.",
          "«Quédate conmigo, Señor»" to "Para que la presencia de Jesús eucarístico sea el sol que ilumine nuestras almas."
        ),
        "San Pío de Pietrelcina, ruega por nosotros."
      ),
      closingPrayer = "Señor, que hiciste del Padre Pío un testigo admirable de tu Pasión, concédenos por su intercesión la gracia que te suplicamos. Amén."
    ),

    // 22. VIRGEN DE LA MEDALLA MILAGROSA
    CatholicNovena(
      id = "novena_medalla_milagrosa",
      title = "Novena a la Virgen de la Medalla Milagrosa",
      saintOrAdvocation = "Nuestra Señora de la Medalla Milagrosa",
      category = "Virgen María",
      feastDate = "27 de Noviembre",
      description = "Aparición a Santa Catalina Labouré. «Los rayos son las gracias que derramo sobre quienes las piden».",
      openingPrayer = "¡Oh Virgen Inmaculada de la Medalla Milagrosa! Postrados ante tu imagen, te damos gracias por los rayos de bendición que brotan de tus benditas manos sobre los que con fe te invocan.",
      days = create9Days(
        "la Medalla Milagrosa",
        listOf(
          "Los rayos luminosos" to "Para pedir con confianza las gracias divinas que muchas veces dejamos de recibir por no pedirlas.",
          "«¡Oh María sin pecado concebida!»" to "«Ruega por nosotros que recurrimos a ti». Proclamamos su pureza inmaculada.",
          "El globo del mundo en sus manos" to "Consagramos el mundo entero y nuestras vidas a su patrocinio.",
          "La Cruz y la M" to "Meditamos la íntima unión entre el sacrificio de Jesús y la compasión de María.",
          "Los dos Corazones" to "Contemplamos el Corazón de Jesús coronado de espinas y el de María traspasado por una espada.",
          "Las doce estrellas" to "Reconocemos a María como Reina de los Apóstoles y Corona de la Iglesia.",
          "Protección de los que portan la Medalla" to "Llevamos al cuello la santa medalla como escudo y compromiso de santidad.",
          "Conversión de los pecadores y de la familia" to "Oramos por los que viven alejados de los sacramentos.",
          "Promesa de auxilio eterno" to "Esperamos con gozo su amparo en la hora de nuestra muerte."
        ),
        "¡Oh María sin pecado concebida, ruega por nosotros que recurrimos a ti!"
      ),
      closingPrayer = "Santísima Virgen de la Medalla Milagrosa, derrama tus gracias sobre nuestros hogares y condúcenos al cielo. Amén."
    ),

    // 23. BENDITAS ÁNIMAS DEL PURGATORIO
    CatholicNovena(
      id = "novena_animas_purgatorio",
      title = "Novena por las Benditas Ánimas del Purgatorio",
      saintOrAdvocation = "Las Ánimas del Purgatorio",
      category = "Santos Intercesores",
      feastDate = "2 de Noviembre (Conmemoración de todos los Fieles Difuntos)",
      description = "Obra de suprema misericordia espiritual para aliviar y liberar a las almas santas que purgan sus faltas antes de contemplar a Dios.",
      openingPrayer = "¡Señor Dios omnipotente, Padre de bondad! Nos postramos ante tu infinita majestad para implorar tu perdón por las almas de nuestros hermanos difuntos que están purificándose en el Purgatorio.",
      days = create9Days(
        "las Benditas Ánimas",
        listOf(
          "Almas de nuestros familiares y bienhechores" to "Recordamos con piedad filial a padres, abuelos y seres queridos que nos precedieron en el signo de la fe.",
          "Almas más abandonadas y olvidadas" to "Oramos por aquellas por quienes nadie reza en este mundo para que hallen el consuelo de Dios.",
          "Almas de los sacerdotes y religiosos difuntos" to "Suplicamos por quienes consagraron su vida al ministerio sagrado del altar.",
          "Almas que están más cerca del Cielo" to "Pedimos que concluyan su purificación y entren hoy en el gozo del Paraíso.",
          "Almas que sufren mayores tormentos" to "Para que los méritos de la Sangre de Cristo apaguen su fuego de expiación.",
          "Purificación de la tibieza" to "Pedimos perdón por las faltas de fervor en las obras de caridad durante la vida terrena.",
          "El Santo Sacrificio de la Misa" to "Ofrecemos la Santa Misa como el sufragio más perfecto e infinito por los difuntos.",
          "Intercesión mutua de la Comunión de los Santos" to "Sabemos que las almas liberadas interceden fervorosamente por quienes rezaron por ellas.",
          "El descanso eterno en la luz celestial" to "«Dales, Señor, el descanso eterno, y brille para ellas la luz perpetua. Descansen en paz. Amén»."
        ),
        "¡Dales, Señor, el descanso eterno, y brille para ellas la luz perpetua!"
      ),
      closingPrayer = "Señor Jesucristo, Redentor nuestro, acoge en tu gloria a todas las benditas almas y líbralas del Purgatorio. Amén."
    ),

    // 24. SEÑOR DE LOS MILAGROS
    CatholicNovena(
      id = "novena_senor_milagros",
      title = "Novena al Señor de los Milagros",
      saintOrAdvocation = "El Señor de los Milagros (Cristo de Pachacamilla)",
      category = "Jesucristo",
      feastDate = "Octubre (Mes Morado y 18-28 de Octubre)",
      description = "Cristo crucificado pintado por un esclavo angoleño que resistió terremotos y prodigios. Esperanza de los afligidos.",
      openingPrayer = "¡Señor de los Milagros, Cristo del Calvario y de la reconciliación! Te adoramos clavado en la Cruz por nuestro amor. Míranos con piedad y concédenos tu bendición.",
      days = create9Days(
        "el Señor de los Milagros",
        listOf(
          "El Muro que no cayó" to "Para permanecer firmes en la fe ante los terremotos y tempestades de la vida.",
          "La Cruz redentora" to "Contemplamos las santas llagas de Jesús que manan perdón para todos.",
          "María al pie de la Cruz" to "Aprendemos de la Virgen a no abandonar jamás a Cristo en su agonía.",
          "El Padre Celestial en lo alto" to "Reconocemos que en Cristo se reconcilia el cielo y la tierra.",
          "El Espíritu Santo en forma de paloma" to "Pedimos la luz divina para nuestras decisiones cotidianas.",
          "Sanación de los enfermos" to "Suplicamos el toque milagroso del Señor sobre nuestras dolencias.",
          "Perdón y reconciliación" to "Para desterrar el odio y abrazar a nuestros semejantes como hermanos.",
          "Pan y sustento de los pobres" to "Oramos por los necesitados y por el amparo de la divina Providencia.",
          "Caminar tras sus huellas" to "Prometemos vestir el hábito morado de la penitencia interior y el amor a Dios."
        ),
        "¡Señor de los Milagros, bendícenos y sálvanos!"
      ),
      closingPrayer = "Señor de los Milagros, derrama tu gracia sobre nosotros y guía nuestros pasos hacia la vida eterna. Amén."
    ),

    // 25. SAN RAFAEL ARCÁNGEL
    CatholicNovena(
      id = "novena_san_rafael",
      title = "Novena a San Rafael Arcángel",
      saintOrAdvocation = "San Rafael Arcángel (Medicina de Dios)",
      category = "Arcángeles y Ángeles",
      feastDate = "29 de Septiembre y 24 de Octubre",
      description = "«Yo soy Rafael, uno de los siete ángeles que están delante de la gloria del Señor». Médico de Dios, guía de viajeros y protector de matrimonios.",
      openingPrayer = "¡Glorioso San Rafael Arcángel, medicina de Dios y guía fiel de Tobías! Te suplicamos nos acompañes en el viaje de esta vida terrena y cures nuestras dolencias físicas y espirituales.",
      days = create9Days(
        "San Rafael Arcángel",
        listOf(
          "Medicina de Dios" to "Para curar las enfermedades del cuerpo y sanar la ceguera del alma como curaste al anciano Tobit.",
          "Compañero fiel de camino" to "Para protegernos de peligros visibles e invisibles en nuestros traslados y viajes.",
          "Protector de los noviazgos y matrimonios" to "Para alejar el espíritu de discordia y bendecir las uniones santas como la de Tobías y Sara.",
          "Vencedor de Asmodeo" to "Para atar con el poder divino a los demonios que siembran la impureza y la división.",
          "Consuelo de los afligidos" to "Para secar las lágrimas de quienes padecen angustias y soledades.",
          "Alabanza constante a Dios" to "«Bendecid a Dios y proclamad ante todos los vivientes los bienes que os ha hecho».",
          "Pureza y rectitud de intención" to "Para presentar nuestras obras limpias delante del trono de la divina Majestad.",
          "Auxilio de los médicos y enfermeros" to "Para iluminar a quienes cuidan de la salud de los enfermos.",
          "Entrada en la Jerusalén Celestial" to "Para ser conducidos por tu mano amiga al banquete eterno de los cielos."
        ),
        "San Rafael Arcángel, medicina de Dios, cura nuestras almas y cuerpos."
      ),
      closingPrayer = "Dios todopoderoso, que diste al bienaventurado Rafael por custodio de tus fieles, concédenos su amparo constante. Amén."
    ),

    // 26. SAN GABRIEL ARCÁNGEL
    CatholicNovena(
      id = "novena_san_gabriel",
      title = "Novena a San Gabriel Arcángel",
      saintOrAdvocation = "San Gabriel Arcángel (Fortaleza de Dios)",
      category = "Arcángeles y Ángeles",
      feastDate = "29 de Septiembre y 24 de Marzo",
      description = "Embajador de la Encarnación y mensajero de la Buena Nueva a la Virgen María. Patrono de las comunicaciones.",
      openingPrayer = "¡Oh Santo Arcángel San Gabriel, fortaleza de Dios y mensajero de la salvación! Tú que saludaste a María con el «Ave», alcánzanos la gracia de acoger la Palabra divina con docilidad.",
      days = create9Days(
        "San Gabriel Arcángel",
        listOf(
          "El Mensajero de la Encarnación" to "Para postrarnos con reverencia ante el misterio del Verbo hecho Carne.",
          "«Alégrate, llena de gracia»" to "Para experimentar la alegría santa del Evangelio en nuestros corazones.",
          "Fortaleza en la debilidad" to "Para superar el desánimo recordando que «para Dios no hay nada imposible».",
          "Anuncio a Zacarías" to "Para esperar con paciencia el cumplimiento de los designios del Señor.",
          "Patrono de los comunicadores" to "Para que los medios de comunicación proclamen la verdad, la paz y el bien moral.",
          "Defensor de la fe y la oración" to "Para elevar nuestras plegarias como incienso suave ante el trono divino.",
          "Consuelo en la prueba" to "Para recibir el auxilio celestial cuando nos sintamos abrumados.",
          "Docilidad al plan de Dios" to "Para pronunciar con María nuestro «hágase según tu palabra».",
          "Alabanza de los coros celestiales" to "Para cantar eternamente el Santo, Santo, Santo en el Reino celestial."
        ),
        "San Gabriel Arcángel, fortaleza de Dios, fortalece nuestra fe."
      ),
      closingPrayer = "Señor Dios, que elegiste al arcángel Gabriel para anunciar la Encarnación de tu Hijo, concédenos gozar de su auxilio. Amén."
    ),

    // 27. SAN CAYETANO
    CatholicNovena(
      id = "novena_san_cayetano",
      title = "Novena a San Cayetano",
      saintOrAdvocation = "San Cayetano de Thiene",
      category = "Santos Intercesores",
      feastDate = "7 de Agosto",
      description = "Padre de la Providencia, patrono del pan, la salud y el trabajo digno. «No os preocupéis diciendo: ¿qué comeremos?... Vuestro Padre sabe lo que necesitáis».",
      openingPrayer = "¡Glorioso San Cayetano, padre de la Providencia! Tú que confiaste ciegamente en el cuidado paternal de Dios para con sus criaturas, alcánzanos el pan de cada día y el trabajo honrado.",
      days = create9Days(
        "San Cayetano",
        listOf(
          "Confianza ciega en la Providencia" to "Para no angustiarnos por el mañana y buscar primero el Reino de Dios y su justicia.",
          "El valor del trabajo digno" to "Oramos por quienes buscan empleo honrado para sustentar a sus familias con dignidad.",
          "Pan material y Pan de Vida" to "Para no olvidar que además del alimento del cuerpo necesitamos a Cristo en la Eucaristía.",
          "Desprendimiento de las riquezas" to "Para ser generosos y solidarios con los hermanos más desfavorecidos.",
          "Amor a la cruz y a la mortificación" to "Para purificar nuestras intenciones en el servicio a Dios y al prójimo.",
          "Paz y concordia laboral" to "Para que en los lugares de trabajo reine el respeto mutuo, la justicia y la fraternidad.",
          "Protección de los hogares necesitados" to "Para que ninguna familia sufra la penuria ni el desamparo material.",
          "Fervor en la caridad fraterna" to "Para visitar y consolar a los enfermos en los hospitales con amor cristiano.",
          "Muerte santa en la gracia de Dios" to "Para alcanzar la bienaventuranza eterna prometida a los siervos buenos y fieles."
        ),
        "San Cayetano, padre de providencia, danos pan, paz y trabajo."
      ),
      closingPrayer = "Dios de bondad, por los méritos de San Cayetano concédenos el sustento necesario y condúcenos a los bienes eternos. Amén."
    ),

    // 28. SANTA MÓNICA
    CatholicNovena(
      id = "novena_santa_monica",
      title = "Novena a Santa Mónica",
      saintOrAdvocation = "Santa Mónica, Madre",
      category = "Santos Intercesores",
      feastDate = "27 de Agosto",
      description = "Modelo de madres cristianas. Con perseverancia heroica de lágrimas y oración obtuvo la conversión de su hijo San Agustín.",
      openingPrayer = "¡Oh ejemplar Santa Mónica, espejo de esposas y madres cristianas! Por las lágrimas ardientes que derramaste ante Dios por la conversión de tu hijo Agustín, acoge mis súplicas por mis seres queridos.",
      days = create9Days(
        "Santa Mónica",
        listOf(
          "Oración perseverante sin desmayar" to "Para no cansarnos de rezar aunque parezca que Dios tarda en responder.",
          "«Un hijo de tantas lágrimas no puede perderse»" to "Confiamos a Dios a nuestros hijos, familiares y amigos que se han extraviado del buen camino.",
          "Mansedumbre en el hogar" to "Para vencer con dulzura las asperezas de temperamento de nuestros allegados.",
          "Amor a la Verdad divina" to "Para pedir la luz del Espíritu Santo sobre quienes están cegados por el error.",
          "Alegría en el arrepentimiento" to "Para celebrar el regreso del pecador con el banquete del perdón celestial.",
          "Éxtasis de Ostia" to "Para contemplar junto a nuestros seres queridos las maravillas de la vida eterna.",
          "Consuelo en las horas oscuras" to "Para encontrar refugio en el Corazón de Jesús cuando la tristeza nos invada.",
          "Entrega del alma en paz" to "«Enterrad mi cuerpo donde queráis... solo os pido que os acordéis de mí en el altar del Señor».",
          "Fruto bendito de santidad" to "Damos gracias a Dios por ver germinar la semilla de la fe en nuestras familias."
        ),
        "Santa Mónica, madre de la perseverancia, ruega por nuestros hijos y familias."
      ),
      closingPrayer = "Señor, que escuchaste las súplicas de Santa Mónica, concédenos la conversión de quienes amamos y la salvación de nuestras almas. Amén."
    ),

    // 29. SAN AGUSTÍN
    CatholicNovena(
      id = "novena_san_agustin",
      title = "Novena a San Agustín",
      saintOrAdvocation = "San Agustín de Hipona, Obispo y Doctor",
      category = "Santos Intercesores",
      feastDate = "28 de Agosto",
      description = "«Nos hiciste, Señor, para Ti, y nuestro corazón está inquieto hasta que descanse en Ti». Doctor de la Gracia y buscador apasionado de la Verdad.",
      openingPrayer = "¡Oh gran San Agustín, Doctor de la Gracia y obispo excelso! Tú que experimentaste la sed ardiente de la verdad y hallaste tu descanso en Dios, enséñanos a amar al Señor sobre todas las cosas.",
      days = create9Days(
        "San Agustín",
        listOf(
          "«Nos hiciste, Señor, para Ti»" to "Para reconocer que nada terrenal puede saciar el anhelo infinito de nuestra alma.",
          "«Tarde te amé, Hermosura tan antigua y tan nueva»" to "Para pedir perdón por el tiempo perdido lejos de la amistad divina.",
          "«Toma y lee» («Tolle et lege»)" to "Para acudir a las Sagradas Escrituras y dejarnos transformar por la Palabra viva.",
          "El valor de la gracia sobre la debilidad" to "Para comprender que no nos salvamos por nuestras solas fuerzas sino por la gracia de Cristo.",
          "Amor ferviente a la Iglesia" to "Para amar a la Santa Iglesia como Cuerpo Místico del Redentor y Madre nuestra.",
          "La Ciudad de Dios frente a la ciudad terrena" to "Para construir en nuestras vidas el reino del amor fraterno y la justicia.",
          "Pastor solícito de su grey" to "Oramos por los obispos y sacerdotes para que prediquen con valentía y caridad.",
          "Teología viva en el corazón" to "Para unir el estudio de la fe a la contemplación y a la oración ardiente.",
          "Descanso eterno en Dios" to "Para alcanzar un día la visión beatífica de la Trinidad Santísima en la paz del cielo."
        ),
        "San Agustín glorioso, enciende en nosotros el fuego de la Verdad divina."
      ),
      closingPrayer = "Dios todopoderoso, renueva en tu Iglesia el espíritu de San Agustín para que tengamos sed de ti, fuente de la sabiduría eterna. Amén."
    ),

    // 30. SANTA FAUSTINA KOWALSKA
    CatholicNovena(
      id = "novena_santa_faustina",
      title = "Novena a Santa Faustina Kowalska",
      saintOrAdvocation = "Santa Faustina Kowalska, Secretaria de la Misericordia",
      category = "Santos Intercesores",
      feastDate = "5 de Octubre",
      description = "Apóstol y secretaria de la Divina Misericordia. Recibió del Señor la revelación de la Coronilla, la Imagen y la Hora de la Misericordia.",
      openingPrayer = "¡Oh Jesús, que hiciste de Santa Faustina una ardiente apóstol de tu misericordia infinita! Concédenos por su intercesión acercarnos con confianza al trono de tu gracia.",
      days = create9Days(
        "Santa Faustina",
        listOf(
          "Llamado a la santidad humilde" to "Para servir al Señor en las tareas más ocultas del convento con gozo sobrenatural.",
          "La Imagen de Jesús Misericordioso" to "Contemplamos los rayos rojo y blanco que brotan del Corazón traspasado de Cristo.",
          "La Coronilla de la Divina Misericordia" to "Para ofrecer el Cuerpo, Sangre, Alma y Divinidad de Jesús por los pecadores.",
          "La Hora de la Misericordia (las 3 de la tarde)" to "Para sumergirnos cada tarde en la Pasión y Agonía de Cristo en la Cruz.",
          "Abandono total en la Divina Voluntad" to "«Jesús, en Ti confío»: lema de vida para vencer toda incertidumbre.",
          "Amor a los pecadores agonizantes" to "Para rezar junto a los moribundos implorando su salvación eterna.",
          "Sufrimiento ofrecido en silencio" to "Para ser hostia viva de expiación junto al Sacrificio eucarístico de Jesús.",
          "Devoción tierna a la Virgen de la Misericordia" to "Para aprender de María a guardar en el corazón los misterios de Dios.",
          "Promesa de misericordia para el mundo" to "Para proclamar que la misericordia de Dios no tiene límites para el alma contrita."
        ),
        "Santa Faustina Kowalska, secretaria de la Divina Misericordia, ruega por nosotros."
      ),
      closingPrayer = "Señor Jesús, por intercesión de Santa Faustina, haz que seamos misericordiosos de obra, de palabra y de oración con nuestro prójimo. Amén."
    ),

    // 31. SAN CHARBEL MAKHLOUF
    CatholicNovena(
      id = "novena_san_charbel",
      title = "Novena a San Charbel Makhlouf",
      saintOrAdvocation = "San Charbel Makhlouf, Ermitaño Maronita",
      category = "Santos Intercesores",
      feastDate = "Tercer Domingo de Julio y 24 de Diciembre",
      description = "Portentoso ermitaño del Líbano, prodigio de milagros, sanaciones corporales y paz interior. Adorador incansable del Santísimo.",
      openingPrayer = "¡Oh Dios admirable en tus santos, que atrajiste a San Charbel a la soledad de la ermita para unirse a Ti en continua oración! Dígnate concedernos por su valiosa mediación la gracia que te imploramos.",
      days = create9Days(
        "San Charbel",
        listOf(
          "El silencio y la oración contemplativa" to "Para callar los ruidos del mundo y escuchar la voz suave de Dios.",
          "Adoración perpétua de la Eucaristía" to "Para pasar horas santas de rodillas ante el Sagrario de nuestros templos.",
          "Sanación milagrosa de los cuerpos" to "Pedimos su óleo de bendición sobre los enfermos desahuciados por la ciencia.",
          "Obediencia y humildad monástica" to "Para doblegar el egoísmo y servir con sencillez a la comunidad.",
          "Amor a la cruz y a la penitencia" to "Para abrazar con paciencia los rigores del clima y las dificultades cotidianas.",
          "Paz en Oriente Medio y en el mundo" to "Oramos por la reconciliación entre los pueblos y el fin de los conflictos bélicos.",
          "Protección de los que sufren desesperación" to "Para devolver la serenidad a las mentes perturbadas y corazones angustiados.",
          "Luz resplandeciente desde su tumba" to "Para que la luz de Cristo resplandezca en las tinieblas de nuestra sociedad.",
          "Corona de los santos ermitaños" to "Para aspirar a la santidad oculta que solo Dios ve y premia."
        ),
        "San Charbel, ermitaño milagroso de la paz, ruega por nosotros."
      ),
      closingPrayer = "Oh Dios, que hiciste brillar a San Charbel con innumerables milagros, concédenos por sus méritos la salud del cuerpo y del alma. Amén."
    ),

    // 32. SAN IGNACIO DE LOYOLA
    CatholicNovena(
      id = "novena_san_ignacio",
      title = "Novena a San Ignacio de Loyola",
      saintOrAdvocation = "San Ignacio de Loyola, Fundador de la Compañía de Jesús",
      category = "Santos Intercesores",
      feastDate = "31 de Julio",
      description = "«A la Mayor Gloria de Dios» (AMDG). Maestro insigne del discernimiento espiritual, los Ejercicios Espirituales y la entrega incondicional.",
      openingPrayer = "¡Oh glorioso Patriarca San Ignacio de Loyola, soldado de Cristo y maestro de almas! Enséñanos a buscar y hallar la voluntad divina en todas las cosas, para la Mayor Gloria de Dios.",
      days = create9Days(
        "San Ignacio de Loyola",
        listOf(
          "La herida de Pamplona y la conversión" to "Para descubrir cómo Dios aprovecha nuestras caídas para transformar nuestras vidas.",
          "«¿De qué le sirve al hombre ganar el mundo entero si pierde su alma?»" to "Para elegir siempre los bienes eternos sobre las glorias pasajeras.",
          "Vigilia de armas en Montserrat" to "Para dejar nuestras armas mundanas a los pies de la Virgen María y ceñirnos la armadura de Cristo.",
          "La cueva de Manresa y el discernimiento" to "Para aprender a distinguir las mociones del buen espíritu de las trampas del enemigo.",
          "«En todo amar y servir»" to "Para convertir nuestra existencia en una ofrenda activa al servicio de Dios y del prójimo.",
          "Sentir con la Iglesia («Sentire cum Ecclesia»)" to "Para amar y obedecer filialmente a la Iglesia católica con corazón indiviso.",
          "Los Ejercicios Espirituales" to "Para renovar periódicamente nuestra vida en el silencio fecundo del retiro con Dios.",
          "Oración de entrega («Suscipe, Domine»)" to "«Tomad, Señor, y recibid toda mi libertad, mi memoria, mi entendimiento y toda mi voluntad...»",
          "A la Mayor Gloria de Dios («Ad Maiorem Dei Gloriam»)" to "Para que todo lo que hagamos, digamos o suframos sea únicamente para glorificar a Dios."
        ),
        "San Ignacio de Loyola, ruega por nosotros."
      ),
      closingPrayer = "Señor, concédenos por intercesión de San Ignacio combatir generosamente bajo la bandera de la Cruz para alcanzar la corona celestial. Amén."
    ),

    // 33. SANTA TERESA DE JESÚS
    CatholicNovena(
      id = "novena_santa_teresa_jesus",
      title = "Novena a Santa Teresa de Jesús",
      saintOrAdvocation = "Santa Teresa de Ávila, Doctora de la Iglesia",
      category = "Santos Intercesores",
      feastDate = "15 de Octubre",
      description = "«Nada te turbe, nada te espante; todo se pasa, Dios no se muda; la paciencia todo lo alcanza; quien a Dios tiene nada le falta: solo Dios basta».",
      openingPrayer = "¡Oh Santa Teresa de Jesús, madre de carmelitas y doctora de la oración mística! Enséñanos a tratar de amistad con Aquel que sabemos nos ama.",
      days = create9Days(
        "Santa Teresa de Jesús",
        listOf(
          "Tratar de amistad con Dios" to "Para orar no con fórmulas vacías sino con el corazón abierto al Amigo que nunca falla.",
          "«Solo Dios basta»" to "Para encontrar nuestra plenitud en Dios y no dejarnos turbar por las tempestades del mundo.",
          "El Castillo Interior y las moradas" to "Para entrar en lo más íntimo de nuestra alma donde habita la Santísima Trinidad.",
          "La Transverberación del corazón" to "Para ser heridos con el dardo de fuego del amor purísimo a Jesucristo.",
          "Determinada determinación" to "Para perseverar con valentía en el camino de la santidad sin mirar hacia atrás.",
          "Humildad como andar en verdad" to "Para reconocernos pequeños y necesitados de la misericordia divina.",
          "Amor a la Santa Humanidad de Jesús" to "Para contemplar a Cristo en el huerto, en la cruz y en la gloria.",
          "Reformar la vida con alegría" to "«Un santo triste es un triste santo». Para vivir la fe con gozo contagioso.",
          "«Al fin, muero hija de la Iglesia»" to "Para perseverar en el seno de la Iglesia católica hasta nuestro último suspiro."
        ),
        "Santa Teresa de Jesús, doctora de la Iglesia, ruega por nosotros."
      ),
      closingPrayer = "Dios omnipotente, que encendiste en Santa Teresa el fuego de tu amor, concédenos alimentar nuestras almas con su doctrina celestial. Amén."
    ),

    // 34. SAN FRANCISCO DE ASÍS
    CatholicNovena(
      id = "novena_san_francisco_asis",
      title = "Novena a San Francisco de Asís",
      saintOrAdvocation = "San Francisco de Asís, Patriarca de los Pobres",
      category = "Santos Intercesores",
      feastDate = "4 de Octubre",
      description = "«Señor, hazme un instrumento de tu paz». Hermano del sol, de las criaturas y enamorado de la Dama Pobreza.",
      openingPrayer = "¡Seráfico Padre San Francisco, fiel imitador de Cristo crucificado! Ayúdanos a despojarnos del egoísmo terrenal para abrazar con alegría la sencillez del Evangelio.",
      days = create9Days(
        "San Francisco de Asís",
        listOf(
          "«Francisco, repara mi Iglesia»" to "Para responder a la llamada del Crucifijo de San Damián purificando nuestra propia vida.",
          "Desposorios con la Dama Pobreza" to "Para valorar la sobriedad, la sencillez y el desprendimiento material.",
          "Instrumento de Paz" to "«Donde haya odio, ponga yo amor; donde haya ofensa, perdón; donde haya discordia, unión...»",
          "Cántico de las Criaturas" to "Para alabar a Dios por el hermano sol, la hermana luna y toda la belleza creada.",
          "El abrazo al leproso" to "Para ver el rostro dolorido de Cristo en los enfermos y marginados.",
          "El primer Belén en Greccio" to "Para conmovernos ante la ternura infinita del Niño Jesús nacido en la pobreza.",
          "Los Santos Estigmas en el Monte Alvernia" to "Para llevar en el corazón y en las obras las marcas del amor de Cristo.",
          "Paz con el lobo de Gubbio" to "Para desarmar la violencia con la mansedumbre del Evangelio.",
          "Bienvenida a la hermana muerte corporal" to "Para esperar la muerte no con espanto sino como la puerta que nos abre a la vida eterna."
        ),
        "San Francisco de Asís, padre seráfico, ruega por nosotros."
      ),
      closingPrayer = "Señor Dios, que hiciste a San Francisco semejante a tu Hijo en la pobreza y la humildad, concédenos seguir sus huellas. Amén."
    ),

    // 35. SANTO TOMÁS DE AQUINO
    CatholicNovena(
      id = "novena_santo_tomas_aquino",
      title = "Novena a Santo Tomás de Aquino",
      saintOrAdvocation = "Santo Tomás de Aquino, Doctor Angélico",
      category = "Santos Intercesores",
      feastDate = "28 de Enero",
      description = "Doctor Angélico y patrono de los estudiantes, teólogos, escuelas y universidades. Sabiduría iluminada por la Eucaristía.",
      openingPrayer = "¡Oh glorioso Santo Tomás, sol de sabiduría y de pureza angelical! Tú que uniste el estudio profundo con la más ardiente piedad eucarística, ilumina nuestra inteligencia y enciende nuestro corazón.",
      days = create9Days(
        "Santo Tomás de Aquino",
        listOf(
          "La pureza del cinto angelical" to "Para conservar el cuerpo y el alma limpios de toda mancha de impureza.",
          "«Solo a Ti, Señor» («Non nisi Te, Domine»)" to "«¿Qué quieres por lo que has escrito de mí? — Nada más que a Ti, Señor».",
          "Doctor de la Eucaristía («Pange Lingua»)" to "Para adorar el Sacramento del Altar con fe viva y asombro reverente.",
          "Auxilio de los estudiantes en los exámenes" to "Oramos por los jóvenes en sus estudios para que alcancen claridad y serenidad.",
          "La fe que busca entender" to "Para defender las verdades reveladas con razones sólidas y caridad fraterna.",
          "Humildad ante el Misterio divino" to "«Todo lo que he escrito me parece paja comparado con lo que he visto».",
          "Amor a la Verdad («Veritas»)" to "Para no dejarnos engañar por las ideologías y modas pasajeras del mundo.",
          "Orden y paz en el pensamiento" to "Para organizar nuestra vida en torno a lo que verdaderamente importa.",
          "Visión de Dios en la eternidad" to "Para gozar un día de la verdad plena en el banquete celestial."
        ),
        "Santo Tomás de Aquino, doctor angélico, ruega por nosotros."
      ),
      closingPrayer = "Dios todopoderoso, por intercesión de Santo Tomás concédenos comprender lo que enseñó e imitar lo que vivió. Amén."
    ),

    // 36. PRECIOSÍSIMA SANGRE DE CRISTO
    CatholicNovena(
      id = "novena_preciosas_sangre",
      title = "Novena a la Preciosísima Sangre de Cristo",
      saintOrAdvocation = "La Preciosísima Sangre de Jesucristo",
      category = "Jesucristo",
      feastDate = "1 de Julio",
      description = "Escudo protector contra todo mal y precio infinito de nuestra redención eterna.",
      openingPrayer = "¡Oh Sangre divina de mi Redentor, precio inestimable de nuestra salvación! Te adoro con profunda reverencia y me sumerjo en tus torrentes purificadores.",
      days = create9Days(
        "la Preciosísima Sangre",
        listOf(
          "Sangre de la Circuncisión" to "El primer dolor y la primera entrega de la inocencia del Divino Niño.",
          "Sangre del Sudor en Getsemaní" to "Para confortar a Cristo en su agonía por los pecados de la humanidad.",
          "Sangre de la Flagelación en la columna" to "Para reparar por nuestros pecados de sensualidad y vanidad corporal.",
          "Sangre de la Coronación de Espinas" to "Para extirpar la soberbia y los malos pensamientos de nuestra mente.",
          "Sangre de la Vía Dolorosa" to "Para seguir a Jesús llevando nuestra cruz con paciencia redentora.",
          "Sangre de la Clavazón en la Cruz" to "Para quedar clavados con Cristo en el amor y la obediencia al Padre.",
          "Sangre del Costado abierto por la lanza" to "Nacimiento de la Iglesia y de los Santos Sacramentos.",
          "Sangre del Cáliz Eucarístico" to "Alimento de vida eterna y medicina de inmortalidad para nuestras almas.",
          "Sello y protección de las familias" to "Para sellar nuestros hogares, hijos y bienes contra las asechanzas del maligno."
        ),
        "¡Sangre de Cristo, embriágame; Sangre de Cristo, sálvame y protégeme!"
      ),
      closingPrayer = "Señor Jesucristo, por el precio de tu Preciosísima Sangre, purifica a tu Iglesia y guárdanos de todo mal. Amén."
    ),

    // 37. VIRGEN DEL ROSARIO
    CatholicNovena(
      id = "novena_virgen_rosario",
      title = "Novena a la Virgen del Rosario",
      saintOrAdvocation = "Nuestra Señora del Rosario (Victoria de Lepanto)",
      category = "Virgen María",
      feastDate = "7 de Octubre",
      description = "Entregada a Santo Domingo de Guzmán como arma de paz y victoria de la fe cristiana.",
      openingPrayer = "¡Reina del Santísimo Rosario, Madre de Dios y auxilio nuestro! Nos postramos ante tu presencia para desgranar con amor las rosas de esta santa oración.",
      days = create9Days(
        "la Virgen del Rosario",
        listOf(
          "El Salterio de la Virgen" to "Para unirnos al saludo del ángel Gabriel que cambió la historia del mundo.",
          "Contemplar el rostro de Cristo con María" to "Para recorrer los misterios gozosos, luminosos, dolorosos y gloriosos.",
          "Victoria de la fe contra las herejías" to "Como Santo Domingo venció los errores mediante la predicación del Rosario.",
          "Auxilio en los combates espirituales" to "Para alcanzar la victoria de la paz en medio de las batallas de la vida.",
          "La corona de rosas místicas" to "Para tejer con nuestras oraciones una guirnalda de amor a los pies de María.",
          "Paz en las familias mediante el Rosario en el hogar" to "«Familia que reza unida, permanece unida».",
          "Consuelo en la tribulación" to "Para encontrar descanso en los brazos de María en las horas difíciles.",
          "Protección de los agonizantes" to "Para que la Virgen acuda en nuestro socorro «ahora y en la hora de nuestra muerte».",
          "La gloria del Reino eterno" to "Para participar un día en la corona de las doce estrellas junto a la Reina del cielo."
        ),
        "Reina del Santo Rosario, ruega por nosotros."
      ),
      closingPrayer = "Dios omnipotente, concédenos que al meditar los misterios del Rosario imitemos lo que contienen y alcancemos lo que prometen. Amén."
    ),

    // 38. SANTA BERNARDITA SOUBIROUS
    CatholicNovena(
      id = "novena_santa_bernardita",
      title = "Novena a Santa Bernardita Soubirous",
      saintOrAdvocation = "Santa Bernardita de Lourdes",
      category = "Santos Intercesores",
      feastDate = "16 de Abril",
      description = "Vidente de Lourdes, modelo de humildad inquebrantable, sencillez y paciente sufrimiento en el anonimato.",
      openingPrayer = "¡Oh humilde Santa Bernardita, elegida por la Santísima Virgen en la gruta de Lourdes! Enséñanos a amar la pequeñez evangélica y a soportar las pruebas con paciencia.",
      days = create9Days(
        "Santa Bernardita",
        listOf(
          "La elección de los pequeños" to "«Dios eligió lo débil del mundo para confundir a los sabios».",
          "Fidelidad al mensaje de la Señora" to "Para dar testimonio de la verdad sin temer las burlas de los hombres.",
          "La oración del Santo Rosario" to "Para pasar las cuentas del rosario con inocencia y amor filial.",
          "Barrer el convento y cuidar a los enfermos" to "Para encontrar la santidad en las tareas más humildes y desapercibidas.",
          "Paciencia en el asma y las enfermedades" to "Para ofrecer el dolor sin quejas como hostia viva de consagración.",
          "Amor a la Sagrada Eucaristía" to "Para comulgar con reverencia y adorar al Señor oculto en la Hostia Santa.",
          "Desprendimiento de las honras humanas" to "Para huir de la vanidad y buscar únicamente agradar a Dios.",
          "El cuerpo incorrupto" to "Testimonio milagroso de la pureza que vence a la corrupción de la muerte.",
          "La promesa de María: «No te prometo hacerte feliz en este mundo, sino en el otro»" to "Para poner nuestra esperanza en la bienaventuranza eterna."
        ),
        "Santa Bernardita Soubirous, ruega por nosotros."
      ),
      closingPrayer = "Señor, que otorgaste a Santa Bernardita la gracia de contemplar a la Virgen Inmaculada, concédenos su misma fe sencilla. Amén."
    ),

    // 39. SAN CRISTÓBAL
    CatholicNovena(
      id = "novena_san_cristobal",
      title = "Novena a San Cristóbal",
      saintOrAdvocation = "San Cristóbal, Mártir",
      category = "Santos Intercesores",
      feastDate = "10 de Julio / 25 de Julio",
      description = "El portador de Cristo («Christo-phorus»). Protector de conductores, choferes, viajeros y caminantes.",
      openingPrayer = "¡Oh glorioso mártir San Cristóbal, que tuviste la dicha insigne de llevar sobre tus hombros al Creador del mundo! Protégenos en todos nuestros caminos y viajes.",
      days = create9Days(
        "San Cristóbal",
        listOf(
          "El buscador del Rey más grande" to "Para no servir a señores indignos del mundo sino consagrar la vida solo a Cristo.",
          "Servir a Dios ayudando a cruzar el río" to "Para poner nuestra fuerza y talentos al servicio generoso de los necesitados.",
          "Llevar a Cristo sobre los hombros" to "Para descubrir el peso dulce del amor de Dios que todo lo sostiene.",
          "Protección en las carreteras y viajes" to "Oramos por la seguridad de conductores, transportistas y viajeros.",
          "Prudencia y respeto al volante" to "Para conducir con paciencia y salvaguardar la vida de los transeúntes.",
          "Auxilio ante accidentes y peligros" to "Para invocar su santa protección antes de emprender cualquier trayecto.",
          "Firmeza ante la persecución" to "Para no renunciar a la fe cristiana aun en los momentos de prueba suprema.",
          "El báculo florecido" to "Para que nuestra vida dé frutos abundantes de caridad y testimonio santo.",
          "El viaje definitivo a la Patria Celestial" to "Para llegar sanos y salvos al puerto de la salvación eterna."
        ),
        "San Cristóbal glorioso, guíanos en el camino con tu santa bendición."
      ),
      closingPrayer = "Señor Dios, concédenos por intercesión de San Cristóbal viajar seguros en este mundo y arribar al puerto de la vida eterna. Amén."
    ),

    // 40. SANTA LUCÍA
    CatholicNovena(
      id = "novena_santa_lucia",
      title = "Novena a Santa Lucía",
      saintOrAdvocation = "Santa Lucía de Siracusa, Virgen y Mártir",
      category = "Santos Intercesores",
      feastDate = "13 de Diciembre",
      description = "Protectora de la vista física y espiritual. «Luz» de Cristo que resplandece en las tinieblas del pecado.",
      openingPrayer = "¡Oh Santa Lucía, virgen y mártir admirable! Tú que preferiste perder la luz de tus ojos corporales antes que manchar la pureza de tu alma, protege nuestra vista y nuestra fe.",
      days = create9Days(
        "Santa Lucía",
        listOf(
          "Luz de la fe en el corazón" to "Para disipar las tinieblas de la duda y del error en nuestras vidas.",
          "Salud de la vista corporal" to "Oramos por la curación y preservación de nuestros ojos y de quienes sufren ceguera.",
          "Pureza de la mirada" to "Para apartar nuestros ojos de imágenes y vanidades que ofenden a Dios.",
          "Valentía ante los tiranos" to "Para permanecer inquebrantables en la profesión del nombre de Jesucristo.",
          "El templo inamovible del Espíritu Santo" to "Recordamos cómo ni mil hombres pudieron moverla de su sitio gracias a la fuerza divina.",
          "Caridad con los pobres de Siracusa" to "Para repartir nuestros bienes con los necesitados antes de partir de este mundo.",
          "La lámpara encendida del Evangelio" to "Para estar vigilantes esperando la venida del Esposo celestial.",
          "Intercesión por los médicos oftalmólogos" to "Para bendecir a quienes dedican su ciencia a curar las enfermedades de los ojos.",
          "Contemplación eterna de la Luz de Dios" to "Para contemplar un día cara a cara la gloria del Creador en el Paraíso."
        ),
        "Santa Lucía, conserva la luz de nuestros ojos y la pureza de nuestra fe."
      ),
      closingPrayer = "Señor, que nos alegras con la fiesta de Santa Lucía, concédenos contemplar un día tu gloria eterna. Amén."
    ),

    // 41. SANTA ÁGUEDA
    CatholicNovena(
      id = "novena_santa_agueda",
      title = "Novena a Santa Águeda",
      saintOrAdvocation = "Santa Águeda de Catania, Virgen y Mártir",
      category = "Santos Intercesores",
      feastDate = "5 de Febrero",
      description = "Protectora de las mujeres, amparo contra enfermedades de la mama, incendios y erupciones. Fortaleza invencible de la pureza.",
      openingPrayer = "¡Oh gloriosa Santa Águeda, virgen coronada con el martirio! Por el amor ardiente que profesaste a Cristo Esposo, acoge nuestras súplicas en las horas de enfermedad y prueba.",
      days = create9Days(
        "Santa Águeda",
        listOf(
          "Firmeza en la castidad" to "Para consagrar el corazón a Cristo despreciando las vanidades del mundo.",
          "Curación de San Pedro en la cárcel" to "Recordamos la visión consoladora del Apóstol sanando sus llagas en la prisión.",
          "Protección de las mujeres y madres" to "Oramos especialmente por la salud de las mujeres y la sanación del cáncer de mama.",
          "Defensa contra incendios y catástrofes" to "Invocamos su velo milagroso para apagar las llamas del odio y de los desastres.",
          "Paciencia en los tormentos corporales" to "Para no quejarnos en la enfermedad sino unir nuestros dolores a la Cruz.",
          "Confianza ciega en el Médico divino" to "«Tengo a Jesucristo por médico de mi cuerpo y de mi alma».",
          "Pureza de las costumbres cristianas" to "Para defender la dignidad sagrada de la mujer en la sociedad actual.",
          "Oración por los enfermos de los hospitales" to "Para llevar consuelo y esperanza a quienes sufren en camas de hospital.",
          "La corona de la gloria inmortal" to "Para alabar a Cristo Rey en la asamblea de las vírgenes prudentes."
        ),
        "Santa Águeda, virgen y mártir invicta, ruega por nosotros."
      ),
      closingPrayer = "Dios todopoderoso, por intercesión de Santa Águeda líbranos de todo mal del cuerpo y concédenos la salvación del alma. Amén."
    ),

    // 42. SAN JUAN BOSCO
    CatholicNovena(
      id = "novena_san_juan_bosco",
      title = "Novena a San Juan Bosco",
      saintOrAdvocation = "San Juan Bosco, Padre y Maestro de la Juventud",
      category = "Santos Intercesores",
      feastDate = "31 de Enero",
      description = "«Dadme almas y quitaos lo demás» (Da mihi animas). Fundador de los Salesianos, apóstol de los jóvenes y devoto de María Auxiliadora.",
      openingPrayer = "¡San Juan Bosco, padre y maestro de la juventud! Concédenos tu amor apasionado por Jesús Sacramentado y por María Auxiliadora, para salvar almas y formar buenos cristianos y honrados ciudadanos.",
      days = create9Days(
        "San Juan Bosco",
        listOf(
          "El sueño de los nueve años" to "Para comprender que el bien se vence no con golpes sino con la dulzura y el amor.",
          "El Sistema Preventivo (Razón, Religión y Amor)" to "Para educar a los hijos y jóvenes con paciencia y comprensión cristiana.",
          "Devoción ardiente a María Auxiliadora" to "«Ella lo ha hecho todo». Para acudir a la Virgen en toda necesidad.",
          "La Eucaristía y la Confesión frecuente" to "Las dos grandes columnas que sostienen la barca de nuestra salvación.",
          "Amor a los jóvenes más desfavorecidos" to "Para acoger a los chicos de la calle y enseñarles un oficio y la fe.",
          "Alegría salesiana" to "«Servite Domino in laetitia» (Servid al Señor con alegría). Para desterrar la tristeza.",
          "Defensa de la Iglesia y del Papa" to "Para ser hijos leales de la Santa Sede en tiempos difíciles.",
          "Celo misionero en el mundo entero" to "Para enviar misioneros a todos los rincones anunciando a Cristo.",
          "«Nos vemos en el Paraíso»" to "Para caminar juntos hacia la fiesta interminable de los santos en el cielo."
        ),
        "San Juan Bosco, padre y maestro de la juventud, ruega por nosotros."
      ),
      closingPrayer = "Señor Dios, que suscitaste a San Juan Bosco como maestro de la juventud, concédenos arder en su mismo celo por la salvación de las almas. Amén."
    ),

    // 43. SANTA CLARA DE ASÍS
    CatholicNovena(
      id = "novena_santa_clara",
      title = "Novena a Santa Clara de Asís",
      saintOrAdvocation = "Santa Clara de Asís, Virgen",
      category = "Santos Intercesores",
      feastDate = "11 de Agosto",
      description = "Plantita de San Francisco, fundadora de las Clarisas, enamorada de la Eucaristía que ahuyentó a los sarracenos con la Custodia.",
      openingPrayer = "¡Oh serena Santa Clara de Asís, espejo de pureza y adoradora fiel del Santísimo Sacramento! Te suplicamos que alcances para nuestros hogares la paz, la unidad y la presencia viva de Jesús Eucaristía.",
      days = create9Days(
        "Santa Clara de Asís",
        listOf(
          "La fuga del Domingo de Ramos" to "Para dejar atrás el oropel del mundo y consagrarnos por entero a Dios.",
          "El Privilegio de la Pobreza" to "Para aprender a depender únicamente de la bendita Providencia del Padre.",
          "El milagro de la Custodia" to "Recordamos cómo al alzar la Custodia con el Santísimo Sacramento los enemigos huyeron de Asís.",
          "Oración contemplativa en San Damián" to "Para hacer de nuestro corazón una clausura sagrada de intimidad divina.",
          "Hermana de San Francisco" to "Para vivir la fraternidad santa con sencillez evangélica.",
          "Paciencia en la larga enfermedad" to "Para transformar veintiocho años de dolencias en himno de acción de gracias.",
          "Patrona de la televisión y de las comunicaciones" to "Para que los medios audiovisuales transmitan contenidos limpios y constructivos.",
          "Bendición de Santa Clara a sus hermanas" to "«El Señor os bendiga y os guarde; os muestre su rostro y tenga misericordia de vosotras».",
          "«¡Gracias, Señor, porque me creaste!»" to "Para expirar agradeciendo el don infinito de la vida y de la fe."
        ),
        "Santa Clara de Asís, amante de la Eucaristía, ruega por nosotros."
      ),
      closingPrayer = "Dios omnipotente, que por Santa Clara nos diste ejemplo de pureza y amor al Sacramento, haz que contemplemos tu gloria celestial. Amén."
    ),

    // 44. SANTO ÁNGEL DE LA GUARDA
    CatholicNovena(
      id = "novena_angel_guarda",
      title = "Novena al Santo Ángel de la Guarda",
      saintOrAdvocation = "Los Santos Ángeles Custodios",
      category = "Arcángeles y Ángeles",
      feastDate = "2 de Octubre",
      description = "«Ángel de mi guarda, dulce compañía, no me desampares ni de noche ni de día». Guía, protector y amigo íntimo puesto por Dios a nuestro lado.",
      openingPrayer = "¡Santo Ángel de la Guarda, fiel custodio de mi alma y cuerpo! Te doy gracias porque desde el primer instante de mi vida me acompañas con paciencia y amor celestial. Sé mi escudo y mi maestro.",
      days = create9Days(
        "el Santo Ángel Custodio",
        listOf(
          "El regalo de un amigo celestial" to "Para agradecer a Dios la presencia constante de nuestro ángel protector.",
          "Escudo contra los peligros del cuerpo" to "Para librarnos de accidentes, tropiezos y asechanzas invisibles.",
          "Voz de la conciencia en el alma" to "Para escuchar sus santas inspiraciones que nos invitan a hacer el bien.",
          "Defensa en la hora de la tentación" to "Para invocar su auxilio pronto ante los ataques del enemigo infernal.",
          "Presentar nuestras oraciones ante el trono de Dios" to "Para que lleve nuestras súplicas como incienso perfumado al cielo.",
          "Compañero en la soledad" to "Para recordar que nunca estamos solos en las dificultades de la vida.",
          "Respeto y gratitud hacia nuestro ángel" to "Para no contristar su presencia con pensamientos o acciones indignas.",
          "Guía en la hora de la muerte" to "Para que tome nuestra alma de la mano y la conduzca a la presencia de Dios.",
          "Cántico de alabanza eterna" to "Para unirnos a los nueve coros angélicos proclamando la santidad de Dios."
        ),
        "Ángel de Dios, que eres mi custodio, ilumíname, guárdame, rígeme y gobiérname. Amén."
      ),
      closingPrayer = "Señor, que con providencia inefable envías a tus santos ángeles para nuestra custodia, concédenos gozar siempre de su protección. Amén."
    ),

    // 45. PERPETUO SOCORRO
    CatholicNovena(
      id = "novena_perpetuo_socorro",
      title = "Novena a Nuestra Señora del Perpetuo Socorro",
      saintOrAdvocation = "Nuestra Señora del Perpetuo Socorro",
      category = "Virgen María",
      feastDate = "27 de Junio",
      description = "El icono bizantino sagrado donde el Niño Jesús corre a refugiarse en los brazos de su Madre viendo los instrumentos de su Pasión.",
      openingPrayer = "¡Oh Madre del Perpetuo Socorro! Mira a este pobre pecador que a tus pies acude implorando tu auxilio. Sé mi perpetuo socorro en todas mis necesidades.",
      days = create9Days(
        "el Perpetuo Socorro",
        listOf(
          "Los ojos compasivos de la Virgen" to "Contemplamos la mirada tierna de María que no mira al Niño sino a nosotros, sus hijos en la tierra.",
          "El Niño que corre a los brazos maternos" to "Para acudir siempre a María con la prisa confiada de los niños pequeños.",
          "La sandalia desatada del Niño Jesús" to "Símbolo de que quien acude a la Madre no pierde la salvación eterna.",
          "Los Santos Arcángeles Miguel y Gabriel" to "Presentando la Cruz, la lanza y la esponja como instrumentos de redención.",
          "Auxilio en las tentaciones" to "Para pronunciar con fe el nombre de María en los momentos de mayor peligro moral.",
          "Consuelo en las aflicciones familiares" to "Para poner en sus manos los problemas del matrimonio, de los hijos y del trabajo.",
          "Esperanza de los pecadores" to "Para no desesperar jamás de la misericordia infinita de Dios.",
          "Fidelidad en el rezo cotidiano" to "Para ser constantes en honrar a nuestra Madre celestial cada día de nuestra vida.",
          "Socorro perpetuo en la última hora" to "«Madre del Perpetuo Socorro, no me desampares en la hora de mi muerte»."
        ),
        "¡Oh Madre del Perpetuo Socorro, sé mi socorro hoy y en la hora de mi muerte!"
      ),
      closingPrayer = "Virgen del Perpetuo Socorro, alcánzanos la gracia de acudir siempre a ti con filial confianza. Amén."
    ),

    // 46. SAN MARTÍN DE PORRES
    CatholicNovena(
      id = "novena_san_martin_porres",
      title = "Novena a San Martín de Porres",
      saintOrAdvocation = "San Martín de Porres (Fray Escoba)",
      category = "Santos Intercesores",
      feastDate = "3 de Noviembre",
      description = "El santo de la escoba, de la caridad universal y de la concordia. Hermano dominico amado por su humildad y compasión hacia los pobres y animales.",
      openingPrayer = "¡San Martín de Porres, humilde siervo del Señor y padre de los desamparados! Por tu amor encendido a Jesús Eucaristía y por tu corazón generoso hacia todos los afligidos, atiende mis humildes súplicas.",
      days = create9Days(
        "San Martín de Porres",
        listOf(
          "La escoba santa de la humildad" to "Para barrer de nuestro corazón la soberbia, el resentimiento y la arrogancia.",
          "Caridad heroica con los enfermos" to "Para curar las heridas de los necesitados con bálsamo de amor cristiano.",
          "Amor al Santísimo Sacramento" to "Para pasar noches enteras en oración ante el Sagrario de la iglesia.",
          "Concordia entre los hombres y la creación" to "Recordamos cómo reunió a comer en un mismo plato al perro, al pericote y al gato.",
          "Generosidad desprendida" to "Para repartir el pan con el hambriento sin guardar nada para sí.",
          "Paciencia ante los desprecios y humillaciones" to "Para no devolver mal por mal sino responder con bendición.",
          "Auxilio en las deudas y necesidades apremiantes" to "Para encomendar la providencia material de nuestras familias.",
          "Protección de los animales y la naturaleza" to "Para cuidar con respeto y bondad a todos los seres creados por Dios.",
          "Entrada triunfante en el Paraíso" to "Para gozar junto a San Martín de la eterna bienaventuranza de los santos."
        ),
        "San Martín de Porres, modelo de caridad y humildad, ruega por nosotros."
      ),
      closingPrayer = "Señor Dios, que exaltaste al humilde San Martín de Porres, concédenos imitar su caridad para alcanzar la gloria eterna. Amén."
    ),

    // 47. VIRGEN DE LA PAZ
    CatholicNovena(
      id = "novena_virgen_de_la_paz",
      title = "Novena a María, Reina de la Paz",
      saintOrAdvocation = "Nuestra Señora de la Paz",
      category = "Virgen María",
      feastDate = "24 de Enero y 1 de Enero",
      description = "«La paz os dejo, mi paz os doy». Para pedir el cese de las guerras, el fin de las discordias y la serenidad en los corazones.",
      openingPrayer = "¡Reina de la Paz y Madre de concordia! Postrados a tus pies en un mundo desgarrado por las divisiones y el odio, imploramos de tus manos el don celestial de la paz.",
      days = create9Days(
        "María Reina de la Paz",
        listOf(
          "Paz en el propio corazón" to "Para desterrar la amargura y encontrar el sosiego en la gracia divina.",
          "Paz en la familia" to "Para sanar las heridas entre padres e hijos, esposos y hermanos.",
          "Paz en los lugares de trabajo y convivencia" to "Para erradicar la envidia, las murmuraciones y las rencillas.",
          "Cese de las guerras y de la violencia armada" to "Oramos por las naciones en conflicto para que depongan las armas.",
          "Reconciliación y justicia social" to "Para que los gobernantes promuevan el bien común y la verdad.",
          "La paz que solo Cristo puede dar" to "Para recordar que la paz verdadera nace de un corazón reconciliado con Dios.",
          "El perdón que sana" to "Para tener la grandeza de perdonar a quienes nos ofenden como Cristo en la Cruz.",
          "Oración y ayuno por la paz" to "Para ofrecer sacrificios diarios que obtengan de Dios la pacificación de las almas.",
          "Reinado del Príncipe de la Paz" to "Para que Cristo Rey reine en todas las naciones y hogares del mundo entero."
        ),
        "Reina de la Paz, ruega por nosotros y da la paz al mundo entero."
      ),
      closingPrayer = "Señor Jesucristo, por intercesión de tu Santísima Madre, danos tu santa paz que sobrepasa todo entendimiento. Amén."
    ),

    // 48. SANTA MARTA
    CatholicNovena(
      id = "novena_santa_marta",
      title = "Novena a Santa Marta de Betania",
      saintOrAdvocation = "Santa Marta de Betania",
      category = "Causas Urgentes e Imposibles",
      feastDate = "29 de Julio",
      description = "Huésped del Señor Jesús en Betania. Amparo protector en las necesidades y dificultades urgentes del hogar.",
      openingPrayer = "¡Oh gloriosa Santa Marta, dichosa por haber hospedado tantas veces al Divino Redentor en tu casa de Betania! Atiende mi súplica confiada en esta grave necesidad.",
      days = create9Days(
        "Santa Marta",
        listOf(
          "El valor de la hospitalidad y el servicio" to "Para recibir a Cristo en la persona de los hermanos necesitados.",
          "Profesión de fe ante la muerte de Lázaro" to "«Sí, Señor; yo he creído que Tú eres el Cristo, el Hijo de Dios vivo».",
          "Unir el servicio activo a la contemplación" to "Para no perder la calma en medio de las tareas y escuchar a Jesús.",
          "Amparo en las necesidades del hogar" to "Oramos por la provisión, la armonía y la protección de nuestra casa.",
          "Vencer a las dificultades (El dragón de Tarascón)" to "Para someter con la señal de la cruz toda fiera de angustia y peligro.",
          "Fe en la Resurrección" to "Para tener la certeza de que Dios tiene la última palabra sobre el dolor y la muerte.",
          "Fortaleza femenina y laboriosidad" to "Para bendecir a las mujeres que cuidan incansablemente de sus familias.",
          "Paciencia ante las demoras de Dios" to "Para confiar plenamente en que los tiempos de Dios son siempre perfectos.",
          "La morada eterna en el cielo" to "Para ser acogidos por Jesús en las moradas del Reino de los Cielos."
        ),
        "Santa Marta milagrosa, atiéndeme en mis necesidades y vence mis dificultades."
      ),
      closingPrayer = "Santa Marta amada, que hospedaste al Señor Jesús, alcánzanos su bendición constante para nuestros hogares. Amén."
    ),

    // 49. NOVENA DE NAVIDAD (AL DIVINO NIÑO JESÚS)
    CatholicNovena(
      id = "novena_navidad",
      title = "Novena de Navidad (Al Divino Niño Jesús)",
      saintOrAdvocation = "El Divino Niño Jesús en el Pesebre",
      category = "Jesucristo",
      feastDate = "16 al 24 de Diciembre (Nochebuena)",
      description = "La entrañable Novena de Aguinaldos para preparar el corazón al Nacimiento del Redentor en Belén con gozo familiar.",
      openingPrayer = "¡Benignísimo Dios de infinita caridad, que tanto amaste a los hombres que les diste en tu Hijo la mejor prenda de tu amor! Te damos gracias por el misterio adorable de la Encarnación.",
      days = create9Days(
        "el Nacimiento de Jesús",
        listOf(
          "El Anuncio de los profetas" to "El pueblo que caminaba en tinieblas vio una gran luz en el horizonte.",
          "La anunciación a la Virgen María" to "El «Sí» generoso de la Madre que abrió las puertas de la redención.",
          "El viaje hacia Belén con San José" to "La santa fatiga de los esposos buscando posada en la noche fría.",
          "El pesebre pobre y humilde" to "Dios nace en la pobreza para enseñarnos que el verdadero tesoro es el amor.",
          "El coro de los santos Ángeles" to "«¡Gloria a Dios en las alturas y en la tierra paz a los hombres que ama el Señor!»",
          "La visita de los humildes pastores" to "Los sencillos son los primeros en adorar al Salvador del mundo.",
          "Los pañales del Divino Niño" to "El Creador de las estrellas se deja envolver en pañales por nuestro amor.",
          "La ternura de María y José" to "Contemplamos a la Sagrada Familia unida en adoración silenciosa.",
          "¡Nochebuena! Ha nacido el Salvador" to "«Ven, ven, Señor, no tardes; ven pronto, Señor, que te esperamos en el corazón»."
        ),
        "¡Dulce Jesús Mío, mi Niño adorado: ¡Ven a nuestras almas, ven no tardes tanto!"
      ),
      closingPrayer = "Soberano Niño Jesús, ven a nacer en nuestros corazones y bendice a nuestras familias con la paz santa de Belén. Amén."
    )
  )

  fun getNovenaById(id: String): CatholicNovena? {
    return novenas.find { it.id == id }
  }

  fun getCategories(): List<String> {
    return listOf("Todos", "Jesucristo", "Virgen María", "Santos Intercesores", "Causas Urgentes e Imposibles", "Arcángeles y Ángeles")
  }

  fun searchNovenas(query: String, category: String = "Todos"): List<CatholicNovena> {
    return novenas.filter { novena ->
      val matchesCategory = category == "Todos" || novena.category == category
      val matchesQuery = query.isBlank() ||
          novena.title.contains(query, ignoreCase = true) ||
          novena.saintOrAdvocation.contains(query, ignoreCase = true) ||
          novena.description.contains(query, ignoreCase = true)
      matchesCategory && matchesQuery
    }
  }
}
