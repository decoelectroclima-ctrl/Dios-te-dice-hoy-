package com.example.data

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

  // Curated Roman Catholic Sanctorale by Month (1-12) and Day (1-31)
  private val fixedSaints: Map<Pair<Int, Int>, SaintTemplate> = mapOf(
    // ENERO
    Pair(1, 1) to SaintTemplate(
      title = "Santa María, Madre de Dios",
      saintName = "Solemnidad de Santa María, Madre de Dios",
      biography = "Celebramos el dogma de la divina maternidad de María (Theotokos), proclamado en el Concilio de Éfeso. Ella es Madre del Redentor y Madre nuestra.",
      patronage = "Madre de la Iglesia y Reina de la Paz",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Santa María, Madre de Dios y Madre nuestra, encomendamos a tu corazón inmaculado este nuevo año. Guía nuestros pasos hacia Jesús."
    ),
    Pair(1, 2) to SaintTemplate(
      title = "Santos Basilio Magno y Gregorio Nacianceno",
      saintName = "Santos Basilio Magno y Gregorio Nacianceno, obispos y doctores",
      biography = "Grandes padres capadocios de la Iglesia oriental que defendieron la divinidad del Espíritu Santo y la verdad trinitaria contra las herejías.",
      patronage = "Teólogos y maestros de la fe",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, ilumina tu Iglesia con las enseñanzas de San Basilio y San Gregorio para que amemos con ardor la verdad del Evangelio."
    ),
    Pair(1, 6) to SaintTemplate(
      title = "La Epifanía del Señor",
      saintName = "Solemnidad de la Epifanía del Señor (Los Reyes Magos)",
      biography = "Manifestación de Jesús como Salvador de todas las naciones, simbolizada en la adoración de los Sabios de Oriente que ofrecieron oro, incienso y mirra.",
      patronage = "Universalidad de la Iglesia y las Misiones",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Jesús, que te manifestaste a los pueblos de la tierra, concédenos contemplar tu gloria y adorarte con humildad de corazón."
    ),
    Pair(1, 17) to SaintTemplate(
      title = "San Antonio Abad",
      saintName = "San Antonio Abad, ermitaño",
      biography = "Padre del monaquismo cristiano. Tras escuchar el Evangelio, vendió todos sus bienes y se retiró al desierto de Egipto para vivir en oración y vigilia.",
      patronage = "Patrono de los animales, el campo y la vida contemplativa",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que concediste a San Antonio la victoria sobre las tentaciones, fortalece nuestro espíritu en la oración diaria."
    ),
    Pair(1, 25) to SaintTemplate(
      title = "Conversión de San Pablo",
      saintName = "Fiesta de la Conversión de San Pablo, apóstol",
      biography = "En el camino a Damasco, Saulo es derribado por la luz de Cristo resucitado, transformando al perseguidor en el incansable Apóstol de los Gentiles.",
      patronage = "Misioneros, evangelizadores y unidad de los cristianos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, que derribaste a Saulo para levantarlo apóstol, transforma nuestro corazón para proclamar tu salvación sin descanso."
    ),
    Pair(1, 28) to SaintTemplate(
      title = "Santo Tomás de Aquino",
      saintName = "Santo Tomás de Aquino, presbítero y doctor de la Iglesia",
      biography = "El 'Doctor Angélico'. Fraile dominico cuya obra cumbre, la Suma Teológica, unió fe y razón, autor además de los himnos eucarísticos del Corpus Christi.",
      patronage = "Universidades católicas, estudiantes y teólogos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Concédonos, Señor, comprender lo que Santo Tomás enseñó y seguir el camino de santidad que él recorrió."
    ),
    Pair(1, 31) to SaintTemplate(
      title = "San Juan Bosco",
      saintName = "San Juan Bosco, presbítero",
      biography = "Padre y maestro de la juventud. Fundador de los Salesianos, dedicó su vida a rescatar a niños y jóvenes en Turín con el sistema preventivo: razón, religión y amor.",
      patronage = "Jóvenes, educadores y aprendices",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Bosco, ruega por nuestros jóvenes y niños para que crezcan en gracia, alegría y temor de Dios."
    ),

    // FEBRERO
    Pair(2, 2) to SaintTemplate(
      title = "Presentación del Señor",
      saintName = "Fiesta de la Presentación del Señor (Nuestra Señora de la Candelaria)",
      biography = "A los cuarenta días del nacimiento, María y José presentan a Jesús en el Templo. El anciano Simeón lo proclama como 'Luz para alumbrar a las naciones'.",
      patronage = "Vida consagrada y bendición de las velas",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Cristo Jesús, Luz del mundo, disipa las sombras de nuestra vida y alumbra nuestro camino hacia el Padre."
    ),
    Pair(2, 11) to SaintTemplate(
      title = "Nuestra Señora de Lourdes",
      saintName = "Nuestra Señora de Lourdes — Jornada Mundial del Enfermo",
      biography = "En 1858 la Santísima Virgen se apareció a Santa Bernardita en la gruta de Massabielle presentándose como 'la Inmaculada Concepción' e invitando a la oración.",
      patronage = "Los enfermos y el personal sanitario",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen de Lourdes, consuelo de los afligidos y salud de los enfermos, extiende tu manto protector sobre quienes sufren en cuerpo y alma."
    ),
    Pair(2, 14) to SaintTemplate(
      title = "Santos Cirilo y Metodio",
      saintName = "Santos Cirilo y Metodio, patronos de Europa",
      biography = "Hermanos misioneros que evangelizaron los pueblos eslavos traduciendo la liturgia y la Biblia a su lengua materna.",
      patronage = "Patronos de Europa y de la inculturación del Evangelio",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Que la intercesión de los santos Cirilo y Metodio renueve la fe de Europa y mantenga a los pueblos en paz y concordia."
    ),
    Pair(2, 22) to SaintTemplate(
      title = "Cátedra de San Pedro",
      saintName = "Fiesta de la Cátedra de San Pedro, apóstol",
      biography = "Signo visible de la autoridad pastoral y del ministerio de unidad confiado por Cristo al Apóstol Pedro y a sus sucesores en la sede de Roma.",
      patronage = "El Papa y la unidad de la Iglesia católica",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, protege al Santo Padre y a tu rebaño para que perseveremos fieles en la comunión de la fe apostólica."
    ),

    // MARZO
    Pair(3, 19) to SaintTemplate(
      title = "San José, Esposo de la Virgen",
      saintName = "Solemnidad de San José, Esposo de la Santísima Virgen María",
      biography = "Varón justo, custodio fiel de la Sagrada Familia y protector de la Iglesia Universal. Padre nutricio de Jesús en la tierra.",
      patronage = "Patrono de la Iglesia Universal, los padres y los trabajadores",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Glorioso San José, custodio del Redentor y de la Virgen María, cuida de nuestras familias y acompáñanos en la hora de nuestra partida."
    ),
    Pair(3, 25) to SaintTemplate(
      title = "La Anunciación del Señor",
      saintName = "Solemnidad de la Anunciación del Señor (Encarnación)",
      biography = "El Arcángel Gabriel anuncia a María que concebirá por obra del Espíritu Santo al Hijo de Dios. El Verbo se hizo carne en sus entrañas virginales.",
      patronage = "Defensa de la vida concebida y las madres embarazadas",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      prayer = "«He aquí la esclava del Señor, hágase en mí según tu palabra.» Señor, enséñanos a decir 'Sí' a tu voluntad cada día."
    ),

    // ABRIL
    Pair(4, 25) to SaintTemplate(
      title = "San Marcos, Evangelista",
      saintName = "Fiesta de San Marcos, evangelista",
      biography = "Discípulo de San Pedro y redactor del segundo Evangelio, donde retrata con viveza la humanidad y los milagros de Jesús el Mesías.",
      patronage = "Escritores, notarios y la ciudad de Venecia",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, por intercesión de San Marcos, concédenos profundizar en el Santo Evangelio y proclamarlo con nuestras vidas."
    ),
    Pair(4, 29) to SaintTemplate(
      title = "Santa Catalina de Siena",
      saintName = "Santa Catalina de Siena, virgen y doctora de la Iglesia",
      biography = "Laica terciaria dominica que con amor ardiente a Cristo y a la Iglesia aconsejó a reyes y al Papa Gregorio XI para su regreso a Roma.",
      patronage = "Copatrona de Europa e Italia, y las enfermeras",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Catalina, inflamada de amor por la Preciosísima Sangre de Cristo, alcánzanos una entrega apasionada a la Santa Iglesia."
    ),

    // MAYO
    Pair(5, 1) to SaintTemplate(
      title = "San José Obrero",
      saintName = "San José Obrero — Dignidad del Trabajo",
      biography = "Fiesta instituida por el Papa Pío XII para santificar el trabajo humano a ejemplo de San José, humilde carpintero de Nazaret.",
      patronage = "Trabajadores, obreros y artesanos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San José Obrero, bendice el pan y el trabajo en nuestros hogares, y ayuda a quienes buscan un empleo digno."
    ),
    Pair(5, 13) to SaintTemplate(
      title = "Nuestra Señora de Fátima",
      saintName = "Nuestra Señora del Rosario de Fátima",
      biography = "En 1917, la Virgen María se apareció en Cova da Iria (Portugal) a los pastorcitos Lucía, Francisco y Jacinta pidiendo rezar el Rosario y la penitencia por la paz.",
      patronage = "La paz en el mundo y la conversión de los pecadores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Nuestra Señora de Fátima, enséñanos a rezar el Santo Rosario con devoción y a ofrecer sacrificios por la salvación de las almas."
    ),
    Pair(5, 22) to SaintTemplate(
      title = "Santa Rita de Casia",
      saintName = "Santa Rita de Casia, religiosa",
      biography = "Esposa, madre y luego monja agustina. Llevó en su frente una espina de la Pasión de Cristo y perdonó a los asesinos de su esposo.",
      patronage = "Abogada de las causas imposibles y de las familias en dificultad",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Rita, abogada de los imposibles, intercede ante el Corazón de Jesús por la gracia difícil que hoy con fe te suplico."
    ),
    Pair(5, 31) to SaintTemplate(
      title = "Visitación de la Virgen María",
      saintName = "Fiesta de la Visitación de la Santísima Virgen María",
      biography = "María, embarazada de Jesús, viaja presurosa a las montañas de Judea para servir a su prima Santa Isabel. Allí brota el himno sublime del Magníficat.",
      patronage = "La caridad cristiana y el servicio a los necesitados",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Proclama mi alma la grandeza del Señor y mi espíritu se alegra en Dios mi Salvador.» María, llévanos a servir al prójimo con prisa amorosa."
    ),

    // JUNIO
    Pair(6, 13) to SaintTemplate(
      title = "San Antonio de Padua",
      saintName = "San Antonio de Padua, presbítero y doctor de la Iglesia",
      biography = "Fraile franciscano portugués, predicador insigne de la Sagrada Escritura, modelo de ternura hacia el Niño Jesús y protector de los pobres.",
      patronage = "Cosas perdidas, los pobres, causas urgentes y matrimonios",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Glorioso San Antonio, que tuviste en tus brazos al Niño Jesús, alcánzanos pureza de alma y auxilio en nuestras necesidades temporales y eternas."
    ),
    Pair(6, 24) to SaintTemplate(
      title = "Natividad de San Juan Bautista",
      saintName = "Solemnidad de la Natividad de San Juan Bautista",
      biography = "El Precursor del Mesías. Hijo de Zacarías e Isabel, el mayor de los nacidos de mujer, que señaló a Cristo diciendo: 'He ahí el Cordero de Dios'.",
      patronage = "Los convertidos y los profetas de la verdad",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que enviaste a San Juan Bautista a preparar el camino a tu Hijo, haz que sepamos menguar para que Cristo crezca en nosotros."
    ),
    Pair(6, 29) to SaintTemplate(
      title = "Santos Pedro y Pablo",
      saintName = "Solemnidad de San Pedro y San Pablo, apóstoles",
      biography = "Las dos columnas insignes de la Iglesia. Pedro, vicario de Cristo y primer Papa; Pablo, maestro y misionero insigne de las naciones.",
      patronage = "La Santa Iglesia Católica y la Sede Apostólica",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.ROJO,
      isHolyDay = true,
      prayer = "Señor Dios nuestro, que cimentaste tu Iglesia sobre el testimonio apostólico de Pedro y Pablo, mantén a tu pueblo en la verdad inmutable de la fe."
    ),

    // JULIO
    Pair(7, 11) to SaintTemplate(
      title = "San Benito de Nursia",
      saintName = "San Benito, abad y patrono de Europa",
      biography = "Padre del monaquismo occidental y autor de la Santa Regla: 'Ora et Labora' (Reza y Trabaja). Fundador de la abadía de Montecasino.",
      patronage = "Patrono de Europa, exorcistas y estudiantes",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Benito, líbranos de todo lazo del enemigo y enséñanos a poner a Cristo por encima de todas las cosas."
    ),
    Pair(7, 16) to SaintTemplate(
      title = "Nuestra Señora del Carmen",
      saintName = "Nuestra Señora del Carmen (Virgen del Carmen)",
      biography = "Madre y protectora de la Orden de los Carmelitas. Entregó el Santo Escapulario a San Simón Stock como signo de protección maternal y salvación.",
      patronage = "Gente de mar, las almas del Purgatorio y los carmelitas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Flor del Carmelo, viña florida, esplendor del cielo, Virgen fecunda y singular, sé nuestro amparo maternal en todo momento."
    ),
    Pair(7, 22) to SaintTemplate(
      title = "Santa María Magdalena",
      saintName = "Fiesta de Santa María Magdalena",
      biography = "Apóstol de los apóstoles. Liberada por Jesús, lo acompañó al Calvario y fue la primera en contemplarlo resucitado en el jardín de la tumba vacía.",
      patronage = "Penitentes, contemplativos y testigos de la Resurrección",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, por la ferviente intercesión de María Magdalena, concédenos buscarte con amor ardiente y anunciarte vivo y victorioso."
    ),
    Pair(7, 25) to SaintTemplate(
      title = "Santiago Apóstol",
      saintName = "Fiesta de Santiago Apóstol (El Mayor)",
      biography = "Hijo del Zebedeo, hermano de San Juan. Evangelizador de Hispania y primer apóstol mártir en Jerusalén. Su sepulcro en Compostela es meta de peregrinación.",
      patronage = "Patrono de España, los peregrinos y caballeros",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Santiago Apóstol, alcánzanos la audacia de llevar la luz del Evangelio a todas partes y la fidelidad hasta el final de la peregrinación terrena."
    ),
    Pair(7, 31) to SaintTemplate(
      title = "San Ignacio de Loyola",
      saintName = "San Ignacio de Loyola, presbítero",
      biography = "Caballero herido en Pamplona que entregó su espada a la Virgen de Montserrat. Fundó la Compañía de Jesús y escribió los Ejercicios Espirituales.",
      patronage = "Ejercicios espirituales, soldados y jesuitas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Tomad, Señor, y recibid toda mi libertad, mi memoria, mi entendimiento y toda mi voluntad. Todo es vuestro, disponed a vuestra voluntad.»"
    ),

    // AGOSTO
    Pair(8, 6) to SaintTemplate(
      title = "Transfiguración del Señor",
      saintName = "Fiesta de la Transfiguración del Señor",
      biography = "En el monte Tabor, el rostro de Jesús brilló como el sol ante Pedro, Santiago y Juan. La voz del Padre tronó: 'Éste es mi Hijo amado, escuchadlo'.",
      patronage = "La contemplación de la gloria divina",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, que en el monte Tabor revelaste tu divinidad, transforma nuestra fragilidad humana a imagen de tu gloria celestial."
    ),
    Pair(8, 8) to SaintTemplate(
      title = "Santo Domingo de Guzmán",
      saintName = "Santo Domingo de Guzmán, presbítero",
      biography = "Fundador de la Orden de Predicadores (Dominicos). Promotor del rezo del Santo Rosario y apóstol incansable de la verdad evangélica.",
      patronage = "Predicadores, astrónomos y teólogos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Domingo, que hablabas solo con Dios o de Dios, enciende en nuestro corazón el fuego de la predicación de la verdad."
    ),
    Pair(8, 14) to SaintTemplate(
      title = "San Maximiliano María Kolbe",
      saintName = "San Maximiliano María Kolbe, presbítero y mártir",
      biography = "Fraile franciscano polaco y apóstol de la Inmaculada. En el campo de concentración de Auschwitz ofreció su vida a cambio de un padre de familia condenado.",
      patronage = "Periodistas, prisioneros y mártires de la caridad",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Maximiliano Kolbe, enséñanos que solo el amor es fecundo y que no hay mayor amor que dar la vida por los hermanos."
    ),
    Pair(8, 15) to SaintTemplate(
      title = "Asunción de la Virgen María",
      saintName = "Solemnidad de la Asunción de la Santísima Virgen María",
      biography = "Dogma de fe: al terminar su vida terrena, la Inmaculada Madre de Dios fue asunta en cuerpo y alma a la gloria del cielo.",
      patronage = "Reina del Cielo y de todos los Santos",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Reina asunta a los cielos, vuelve a nosotros tus ojos misericordiosos y guía nuestro peregrinar hacia la patria eterna."
    ),
    Pair(8, 27) to SaintTemplate(
      title = "Santa Mónica",
      saintName = "Santa Mónica, madre cristiana",
      biography = "Modelo heroico de madre creyente. Durante más de 30 años derramó lágrimas y oraciones ante el sagrario por la conversión de su hijo San Agustín.",
      patronage = "Madres de familia, matrimonios en dificultad y conversiones",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Mónica, alcánzanos una fe perseverante que jamás desfallezca en orar por nuestros hijos y seres queridos."
    ),
    Pair(8, 28) to SaintTemplate(
      title = "San Agustín de Hipona",
      saintName = "San Agustín de Hipona, obispo y doctor de la Iglesia",
      biography = "Gran lumbrera de Occidente. Tras una juventud disoluta, se convirtió a la fe católica. Autor de las 'Confesiones' y 'La Ciudad de Dios'.",
      patronage = "Teólogos, filósofos y buscadores de la verdad",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Nos hiciste, Señor, para ti, y nuestro corazón está inquieto hasta que descanse en ti.» San Agustín, enséñanos a amar la Belleza infinita."
    ),

    // SEPTIEMBRE
    Pair(9, 8) to SaintTemplate(
      title = "Natividad de la Virgen María",
      saintName = "Fiesta de la Natividad de la Santísima Virgen María",
      biography = "El nacimiento de la Virgen María anuncia al mundo la llegada del Salvador como la aurora que precede al Sol de justicia.",
      patronage = "Todas las advocaciones de la Niña María",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "En tu nacimiento, oh Virgen Santa, amaneció la esperanza para el género humano. Bendice a nuestras familias con tu pureza."
    ),
    Pair(9, 14) to SaintTemplate(
      title = "Exaltación de la Santa Cruz",
      saintName = "Fiesta de la Exaltación de la Santa Cruz",
      biography = "La Cruz no es signo de derrota, sino árbol de vida y trofeo glorioso donde Cristo venció a la muerte y al pecado.",
      patronage = "La Redención y salvación de las almas",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "«Te adoramos, oh Cristo, y te bendecimos, porque por tu santa cruz redimiste al mundo.» Danos fuerza para abrazar nuestra cruz diaria."
    ),
    Pair(9, 15) to SaintTemplate(
      title = "Nuestra Señora de los Dolores",
      saintName = "Memoria de Nuestra Señora de los Dolores",
      biography = "Conmemoración de los dolores de la Virgen María junto a la Cruz del Redentor, cumpliéndose la profecía de Simeón: 'Una espada atravesará tu alma'.",
      patronage = "Los que sufren pérdidas, duelos y aflicciones",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen Dolorosa, junto a la Cruz nos recibiste como hijos. Acompáñanos en las horas de dolor y aflicción."
    ),
    Pair(9, 23) to SaintTemplate(
      title = "San Pío de Pietrelcina",
      saintName = "San Pío de Pietrelcina (Padre Pío), presbítero",
      biography = "Sacerdote capuchino italiano que llevó en su cuerpo los estigmas de la Pasión durante 50 años. Apóstol del confesionario y hombre de incesante oración.",
      patronage = "Confesores, voluntarios y los que sufren incomprensiones",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Reza, ten fe y no te preocupes.» San Pío, intercede por nosotros para que amemos la Eucaristía y la confesión como fuentes de vida."
    ),
    Pair(9, 29) to SaintTemplate(
      title = "Santos Arcángeles",
      saintName = "Fiesta de los Santos Arcángeles Miguel, Gabriel y Rafael",
      biography = "Miguel ('¿Quién como Dios?'), vencedor de Satanás; Gabriel ('Fortaleza de Dios'), mensajero de la Encarnación; Rafael ('Medicina de Dios'), sanador y guía.",
      patronage = "Protección espiritual, sanación y buenas noticias",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Miguel Arcángel, defiéndenos en la batalla. Santos Arcángeles Gabriel y Rafael, protejan nuestros hogares de todo peligro."
    ),

    // OCTUBRE
    Pair(10, 1) to SaintTemplate(
      title = "Santa Teresita del Niño Jesús",
      saintName = "Santa Teresa del Niño Jesús, virgen y doctora de la Iglesia",
      biography = "Monja carmelita descalza de Lisieux. Maestra del 'caminito espiritual' de la infancia evangélica: amar a Dios en lo pequeño y con total abandono.",
      patronage = "Patrona Universal de las Misiones y los enfermos de tuberculosis",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Teresita, derrama tu lluvia de rosas celestiales sobre nuestras necesidades y enséñanos a ser pequeños ante el Padre celestial."
    ),
    Pair(10, 2) to SaintTemplate(
      title = "Santos Ángeles Custodios",
      saintName = "Memoria de los Santos Ángeles Custodios",
      biography = "Mensajeros celestiales puestos por Dios junto a cada ser humano desde el nacimiento para iluminar, guardar y conducir hacia el cielo.",
      patronage = "Protección de cada cristiano en su vida diaria",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Ángel de mi guarda, dulce compañía, no me desampares ni de noche ni de día. No me dejes solo, que me perdería."
    ),
    Pair(10, 4) to SaintTemplate(
      title = "San Francisco de Asís",
      saintName = "San Francisco de Asís, fundador",
      biography = "El 'Pobrecillo de Asís'. Desposado con la Dama Pobreza, reconstruyó la Iglesia de Cristo con su sencillez, fundó los Franciscanos y recibió los sagrados estigmas.",
      patronage = "Patrono de la paz, la creación, la ecología y los pobres",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Señor, hazme un instrumento de tu paz: donde haya odio, siembre yo amor; donde haya ofensa, perdón; donde haya duda, fe.»"
    ),
    Pair(10, 7) to SaintTemplate(
      title = "Nuestra Señora del Rosario",
      saintName = "Memoria de Nuestra Señora del Rosario",
      biography = "Conmemoración de la victoria de la fe por el rezo del Rosario. María invita a contemplar los misterios de la vida, pasión y gloria de Cristo.",
      patronage = "El rezo diario del Rosario y la protección de la Iglesia",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Madre del Santo Rosario, ayúdanos a meditar los misterios de tu Hijo con un corazón puro y devoto."
    ),
    Pair(10, 12) to SaintTemplate(
      title = "Nuestra Señora del Pilar",
      saintName = "Nuestra Señora del Pilar — Patrona de la Hispanidad",
      biography = "La Virgen María se apareció en carne mortal al Apóstol Santiago a orillas del río Ebro para alentarle en la evangelización, dejando una columna de jaspe como símbolo de fe firme.",
      patronage = "España, los pueblos hispanos y la Guardia Civil",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen del Pilar, mantén inconmovible la fe en nuestros pueblos y protégenos bajo tu bendito manto maternal."
    ),
    Pair(10, 15) to SaintTemplate(
      title = "Santa Teresa de Jesús",
      saintName = "Santa Teresa de Jesús (de Ávila), virgen y doctora de la Iglesia",
      biography = "Gran mística española, reformadora del Carmelo descalzo junto a San Juan de la Cruz y primera doctora de la Iglesia. Autora del 'Castillo Interior'.",
      patronage = "Escritores católicos, religiosos y los contemplativos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Nada te turbe, nada te espante, todo se pasa, Dios no se muda; la paciencia todo lo alcanza; quien a Dios tiene nada le falta: Sólo Dios basta.»"
    ),
    Pair(10, 18) to SaintTemplate(
      title = "San Lucas, Evangelista",
      saintName = "Fiesta de San Lucas, evangelista",
      biography = "Médico sirio de Antioquía, compañero de viajes de San Pablo. Autor del tercer Evangelio (el Evangelio de la Misericordia y de la Virgen) y de los Hechos de los Apóstoles.",
      patronage = "Médicos, artistas, pintores y cirujanos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, por intercesión de San Lucas, médico de almas, derrama tu bálsamo sanador sobre todos los enfermos."
    ),
    Pair(10, 22) to SaintTemplate(
      title = "San Juan Pablo II",
      saintName = "San Juan Pablo II (Karol Wojtyła), papa",
      biography = "Pastor infatigable que guio a la Iglesia al tercer milenio. Peregrino por más de 129 países, apóstol de la Divina Misericordia y promotor de la juventud.",
      patronage = "Jóvenes, familias y Jornadas Mundiales de la Juventud",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«¡No tengáis miedo! ¡Abrid de par en par las puertas a Cristo!» San Juan Pablo II, ruega por las familias y por la paz del mundo."
    ),
    Pair(10, 28) to SaintTemplate(
      title = "Santos Simón y Judas Tadeo",
      saintName = "Fiesta de los Santos Simón y Judas Tadeo, apóstoles",
      biography = "Apóstoles de Cristo que predicaron valientemente el Evangelio en Persia y sufrieron juntos el martirio por amor a Jesús.",
      patronage = "San Judas Tadeo es patrono de los casos desesperados y causas difíciles",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Apóstol San Judas Tadeo, socorro de los que están en trance difícil, haz que en mis aflicciones experimente la ternura consoladora de Dios."
    ),

    // NOVIEMBRE
    Pair(11, 1) to SaintTemplate(
      title = "Todos los Santos",
      saintName = "Solemnidad de Todos los Santos",
      biography = "Celebración solemne de la multitud inmensa de santos canonizados y anónimos que ya gozan de la visión beatífica en el cielo junto a Dios.",
      patronage = "La vocación universal a la santidad de todos los bautizados",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Bienaventurados todos los santos del cielo, que lavaron sus vestiduras en la Sangre del Cordero, intercedan por nosotros para que alcancemos la santidad."
    ),
    Pair(11, 2) to SaintTemplate(
      title = "Fieles Difuntos",
      saintName = "Conmemoración de Todos los Fieles Difuntos",
      biography = "La Iglesia peregrina en la tierra ofrece la Santa Misa, oraciones e indulgencias por el eterno descanso y purificación de las benditas ánimas del Purgatorio.",
      patronage = "Las ánimas benditas del Purgatorio",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.MORADO,
      prayer = "Dales, Señor, el descanso eterno, y brille para ellos la luz perpetua. Que las almas de todos los fieles difuntos descansen en paz. Amén."
    ),
    Pair(11, 3) to SaintTemplate(
      title = "San Martín de Porres",
      saintName = "San Martín de Porres (Fray Escoba), religioso",
      biography = "Fraile dominico mulato en Lima (Perú). Modelo sublime de humildad heroica, caridad desbordante con los enfermos y amistad con toda criatura.",
      patronage = "Justicia social, los barberos, peluqueros y la concordia racial",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Martín de Porres, enséñanos a servir con humildad silenciosa a los más olvidados y pobres de la sociedad."
    ),
    Pair(11, 22) to SaintTemplate(
      title = "Santa Cecilia",
      saintName = "Santa Cecilia, virgen y mártir",
      biography = "Noble romana que consagró su virginidad a Cristo. Mientras los músicos tocaban en sus nupcias, ella cantaba a Dios en su corazón. Sufrió el martirio con serenidad.",
      patronage = "Patrona de la música sacra, los músicos, cantantes y poetas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Cecilia, que con tu canto alabaste al Señor hasta en el martirio, haz que nuestras melodías eleven las almas hacia el trono de Dios."
    ),
    Pair(11, 30) to SaintTemplate(
      title = "San Andrés Apóstol",
      saintName = "Fiesta de San Andrés, apóstol",
      biography = "Hermano de Simón Pedro y primer apóstol llamado por Jesús ('el Proclitos'). Llevó a su propio hermano a Cristo y murió en una cruz en forma de aspa (X).",
      patronage = "Pescadores, Escocia, Rusia y la Iglesia Ortodoxa",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "San Andrés Apóstol, tú que corriste a llevar a Pedro al Salvador, danos celo apostólico para presentar a Jesús a nuestros hermanos."
    ),

    // DICIEMBRE
    Pair(12, 3) to SaintTemplate(
      title = "San Francisco Javier",
      saintName = "San Francisco Javier, presbítero",
      biography = "Jesuita navarro, el 'Gigante de las Misiones'. Llevó el Evangelio a la India, Malaca y Japón bautizando a cientos de miles con ardiente celo apostólico.",
      patronage = "Patrono universal de todas las misiones y de los misioneros",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco Javier, que consumiste tu vida por la salvación de las almas, despierta en la Iglesia un nuevo ardor misionero."
    ),
    Pair(12, 8) to SaintTemplate(
      title = "Inmaculada Concepción",
      saintName = "Solemnidad de la Inmaculada Concepción de la Virgen María",
      biography = "La Virgen María fue preservada inmune de toda mancha de pecado original desde el primer instante de su concepción por los méritos de Cristo.",
      patronage = "Patrona de España, Estados Unidos y la pureza cristiana",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "«Bendita sea tu pureza y eternamente lo sea, pues todo un Dios se recrea en tan graciosa belleza. A ti, celestial Princesa, Virgen sagrada María, te ofrezco en este día alma, vida y corazón.»"
    ),
    Pair(12, 12) to SaintTemplate(
      title = "Nuestra Señora de Guadalupe",
      saintName = "Fiesta de Nuestra Señora de Guadalupe",
      biography = "En 1531 la Virgen se apareció al indígena San Juan Diego en el Tepeyac, dejando su sagrada imagen plasmada milagrosamente en el ayate de tilma.",
      patronage = "Reina de México y Emperatriz de toda América",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«¿Acaso no estoy yo aquí, que tengo el honor de ser tu Madre?» Virgen de Guadalupe, ampara con tu ternura maternal al continente de la esperanza."
    ),
    Pair(12, 14) to SaintTemplate(
      title = "San Juan de la Cruz",
      saintName = "San Juan de la Cruz, presbítero y doctor de la Iglesia",
      biography = "Poeta cumbre de la lengua castellana y místico supremo. Reformador carmelita junto a Santa Teresa. Autor de 'Noche Oscura' y 'Cántico Espiritual'.",
      patronage = "Poetas, contemplativos y místicos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«En el atardecer de la vida seremos examinados en el amor.» San Juan de la Cruz, guíanos por la senda de la santa contemplación."
    ),
    Pair(12, 25) to SaintTemplate(
      title = "Natividad del Señor",
      saintName = "Solemnidad de la Natividad de Nuestro Señor Jesucristo (Navidad)",
      biography = "El misterio inefable de la Encarnación: Dios se hace niño frágil en el pesebre de Belén para salvarnos del pecado e iluminar la historia humana.",
      patronage = "La salvación de todo el género humano",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Gloria a Dios en las alturas y en la tierra paz a los hombres de buena voluntad. Niño Jesús, nace de nuevo en nuestro corazón."
    ),
    Pair(12, 26) to SaintTemplate(
      title = "San Esteban, Protomártir",
      saintName = "Fiesta de San Esteban, protomártir",
      biography = "Primer mártir del cristianismo. Diácono lleno de gracia y poder que, al morir apedreado en Jerusalén, perdonó a sus verdugos orando por ellos.",
      patronage = "Diáconos, albañiles y los perseguidos por la fe",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor Jesús, concédenos a ejemplo de San Esteban perdonar de corazón a quienes nos ofenden y confiar plenamente en tus manos."
    ),
    Pair(12, 27) to SaintTemplate(
      title = "San Juan, Apóstol y Evangelista",
      saintName = "Fiesta de San Juan, apóstol y evangelista",
      biography = "El discípulo amado que reclinó su cabeza en el pecho de Jesús durante la Última Cena y recibió a la Virgen María al pie de la Cruz.",
      patronage = "Teólogos, amigos fieles y la contemplación amorosa",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan, apóstol del amor, alcánzanos una íntima amistad con Cristo y una fe inquebrantable en su divinidad."
    ),
    Pair(12, 28) to SaintTemplate(
      title = "Los Santos Inocentes",
      saintName = "Fiesta de los Santos Inocentes, mártires",
      biography = "Los niños de Belén asesinados por el rey Herodes en su intento de matar al Mesías. Testigos de Cristo no con palabras sino con su sangre inocente.",
      patronage = "Los niños no nacidos y la defensa de la vida inocente",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, protege a los niños más desamparados y a los no nacidos, y danos pureza e inocencia de corazón."
    )
  )

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

  private fun generateReadingsForDay(month: Int, day: Int, isSunday: Boolean): DayReadingsTuple {
    if (isSunday) {
      return DayReadingsTuple(
        first = "Éxodo 17:3-7",
        second = "Moisés golpea la roca en el desierto y brota agua viva para el pueblo.",
        third = "Salmo 94 (95)",
        fourth = "R/. Ojalá escuchéis hoy su voz: «No endurezcáis el corazón».",
        fifth = "Romanos 5:1-2, 5-8",
        sixth = "El amor de Dios ha sido derramado en nuestros corazones por el Espíritu Santo.",
        seventh = "San Juan 4:5-14",
        eighth = "Jesús y la samaritana en el pozo de Sicar: «El agua que yo le daré se convertirá en manantial hasta la vida eterna»."
      )
    }

    val dailyGospels = listOf(
      Pair("San Mateo 5:1-12", "Las Bienaventuranzas: Dichosos los pobres en el espíritu, porque de ellos es el Reino de los Cielos."),
      Pair("San Mateo 6:7-15", "La oración del Padre Nuestro y el perdón fraterno."),
      Pair("San Lucas 1:26-38", "La Anunciación del Ángel Gabriel a la Virgen María: «Hágase en mí según tu palabra»."),
      Pair("San Juan 15:1-8", "La Vid y los sarmientos: «Permaneced en mí y yo en vosotros; el que permanece en mí da mucho fruto»."),
      Pair("San Marcos 10:13-16", "Dejad que los niños vengan a mí y no se lo impidáis, porque de ellos es el Reino de Dios."),
      Pair("San Lucas 15:11-32", "La parábola del Padre Misericordioso y el hijo pródigo."),
      Pair("San Juan 6:35-40", "«Yo soy el pan de vida: el que viene a mí no pasará hambre; el que cree en mí no tendrá sed jamás».")
    )

    val idx = (month * 31 + day) % dailyGospels.size
    val g = dailyGospels[idx]

    return DayReadingsTuple(
      first = "Filipenses 4:4-9",
      second = "«Alegraos siempre en el Señor; el Señor está cerca. En toda oración presentad a Dios vuestras peticiones con acción de gracias».",
      third = "Salmo 22 (23)",
      fourth = "R/. El Señor es mi pastor, nada me falta.",
      fifth = "",
      sixth = "",
      seventh = g.first,
      eighth = g.second
    )
  }
}
