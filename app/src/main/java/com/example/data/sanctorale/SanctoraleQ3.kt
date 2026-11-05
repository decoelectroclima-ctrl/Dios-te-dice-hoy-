package com.example.data.sanctorale

import com.example.data.CatholicCalendarRepository.SaintTemplate
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor

object SanctoraleQ3 {

  val saints: Map<Pair<Int, Int>, SaintTemplate> = mapOf(
    // ==========================================
    // JULIO (31 días)
    // ==========================================
    Pair(7, 1) to SaintTemplate(
      title = "San Junípero Serra",
      saintName = "San Junípero Serra, presbítero franciscano",
      biography = "Fraile franciscano mallorquín del siglo XVIII llamado el «Apóstol de California». Fundó nueve misiones desde San Diego hasta San Francisco con su lema «¡Siempre adelante y nunca retroceder!», defendiendo los derechos de los nativos americanos.",
      patronage = "California, misioneros hispanos, vocaciones y peregrinos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Junípero Serra, que caminaste miles de leguas para llevar la Cruz y el perdón a los pueblos aborígenes, danos celo misionero para ir siempre adelante."
    ),
    Pair(7, 2) to SaintTemplate(
      title = "San Bernardino Realino",
      saintName = "San Bernardino Realino, presbítero jesuita",
      biography = "Magistrado italiano del siglo XVI que atraído por la vida religiosa ingresó a la Compañía de Jesús. Pasó más de cuarenta años en Lecce confesando, pacificando querellas y socorriendo a los enfermos con heroica paciencia.",
      patronage = "Magistrados, abogados, Lecce y directores de conciencias",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Bernardino Realino, espejo de bondad y rectitud, ayúdanos a juzgar a nuestros hermanos con la misericordia de Dios."
    ),
    Pair(7, 3) to SaintTemplate(
      title = "Santo Tomás, apóstol",
      saintName = "Fiesta de Santo Tomás, apóstol",
      biography = "El apóstol que, al dudar de la resurrección, fue invitado por Cristo a meter sus dedos en las llagas de los clavos y su mano en el costado abierto, exclamando la más profunda profesión de fe del Nuevo Testamento: «¡Señor mío y Dios mío!». Evangelizó la India.",
      patronage = "India, arquitectos, constructores, topógrafos y personas con dudas de fe",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Santo Tomás apóstol, alcánzanos una fe viva y ardiente para que, adorando a Jesús en el misterio de sus santas llagas, proclamemos: «¡Señor mío y Dios mío!»."
    ),
    Pair(7, 4) to SaintTemplate(
      title = "Santa Isabel de Portugal",
      saintName = "Santa Isabel de Portugal, reina y pacificadora",
      biography = "Reina de Portugal del siglo XIV y sobrina de Santa Isabel de Hungría. Modelo de paciencia con su infiel esposo y mediadora de paz en las guerras entre reyes. Tras enviudar, vistió el hábito franciscano dedicándose a los leprosos.",
      patronage = "Pacificadores, reinas, novias, discordias familiares y Portugal",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Isabel de Portugal, reina de la paz y de la concordia familiar, intercede por la reconciliación en los hogares divididos por el odio o el rencor."
    ),
    Pair(7, 5) to SaintTemplate(
      title = "San Antonio María Zaccaria",
      saintName = "San Antonio María Zaccaria, presbítero y médico",
      biography = "Médico de Cremona del siglo XVI ordenado sacerdote que fundó los Clérigos Regulares de San Pablo (Barnabitas). Introdujo en Milán la devoción solemne de las Cuarenta Horas de adoración eucarística pública.",
      patronage = "Médicos sacerdotes, adoradores eucarísticos y los Barnabitas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Antonio María Zaccaria, apóstol de la Eucaristía y de la palabra paulina, suscita en nuestras almas una sed insaciable de adorar al Señor en el Sagrario."
    ),
    Pair(7, 6) to SaintTemplate(
      title = "Santa María Goretti",
      saintName = "Santa María Goretti, virgen y mártir de la pureza",
      biography = "Niña campesina italiana de once años en 1902. Al ser asaltada por su vecino Alessandro Serenelli, prefirió morir apuñalada catorce veces antes que cometer pecado impuro: «Es pecado, Dios no lo quiere». Antes de morir en el hospital perdonó a su asesino.",
      patronage = "Juventud, pureza, víctimas de agresiones sexuales y el perdón cristiano",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santa María Goretti, mártir de la pureza virginal y del perdón heroico, protege a los niños del mundo y danos fortaleza para huir del pecado."
    ),
    Pair(7, 7) to SaintTemplate(
      title = "San Fermín de Amiens",
      saintName = "San Fermín, obispo y mártir",
      biography = "Nacido en Pamplona en el siglo III, hijo del senador Firmo bautizado por San Saturnino. Marchó a las Galias predicando con ardor la fe cristiana hasta ser consagrado obispo de Amiens, donde fue decapitado en prisión bajo Diocleciano.",
      patronage = "Pamplona, Navarra, boteros, toneleros y viajeros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Fermín mártir, que derramaste tu sangre por sembrar el Evangelio en las tierras de Europa, cuida de nuestras familias y aviva la fe en nuestro pueblo."
    ),
    Pair(7, 8) to SaintTemplate(
      title = "Santos Áquila y Priscila",
      saintName = "Santos Áquila y Priscila, esposos y colaboradores de San Pablo",
      biography = "Matrimonio judeocristiano de Corinto, fabricantes de tiendas. Acogieron en su hogar a San Pablo, colaboraron con él en Éfeso y Roma, instruyeron a Apolo en la fe y arriesgaron su propio cuello para salvar la vida del Apóstol.",
      patronage = "Matrimonios santos, laicos misioneros y hospitalidad cristiana",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos Áquila y Priscila, esposos según el Corazón de Dios, haced de nuestros hogares verdaderas iglesias domésticas abiertas a la hospitalidad y al amor."
    ),
    Pair(7, 9) to SaintTemplate(
      title = "San Agustín Zhao Rong y compañeros",
      saintName = "San Agustín Zhao Rong y 119 compañeros mártires de China",
      biography = "Soldado imperial chino que escoltó a un obispo mártir hacia su ejecución; impresionado por su serenidad y caridad, se bautizó y ordenó sacerdote. Murió en prisión en 1815 junto a obispos, sacerdotes, catequistas y niños mártires.",
      patronage = "Iglesia católica en China, conversos de familias no cristianas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Agustín Zhao Rong y santos mártires de China, regad con vuestra gloriosa intercesión el florecimiento de la fe y la paz en el inmenso continente asiático."
    ),
    Pair(7, 10) to SaintTemplate(
      title = "San Cristóbal, mártir",
      saintName = "San Cristóbal, mártir (el portador de Cristo)",
      biography = "Hombre de gigantesca estatura en el siglo III que se consagró a vadear un peligroso río llevando a los viajeros sobre sus hombros. Un día cargó a un niño que se volvía cada vez más pesado: era Jesús cargando los pecados del mundo.",
      patronage = "Conductores, choferes, transportistas, automovilistas y viajeros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Cristóbal, protector de los caminos, acompáñanos en nuestros viajes cotidianos, líbranos de todo accidente y llévanos con bien al puerto de la salvación."
    ),
    Pair(7, 11) to SaintTemplate(
      title = "San Benito Abad",
      saintName = "Fiesta de San Benito Abad, patriarca de los monjes y patrono de Europa",
      biography = "Nacido en Nursia en el siglo V, se retiró a la cueva de Subiaco antes de fundar Montecasino. Su Santa Regla («Ora et Labora») salvó la civilización europea del caos bárbaro; su célebre Medalla cruciforme es escudo contra el demonio.",
      patronage = "Patrono de Europa, monjes, agricultores, espeleólogos y contra venenos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Benito Abad, padre y maestro de la vida monástica, concédenos poner a Cristo por encima de todo amor y líbranos de los engaños del maligno."
    ),
    Pair(7, 12) to SaintTemplate(
      title = "Santos Luis Martin y Celia Guérin",
      saintName = "Santos Luis y Celia Martin, padres de Santa Teresita del Niño Jesús",
      biography = "Primer matrimonio canonizado juntos como esposos. Relojero y encajera de Alençon en el siglo XIX, vivieron su matrimonio en oración constante y caridad fraterna, consagrando a sus cinco hijas a la vida religiosa.",
      patronage = "Matrimonios cristianos, padres de familia, enfermos de cáncer y duelo",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos esposos Luis y Celia Martin, interceded por todos los matrimonios del mundo para que eduquen a sus hijos en el amor vivo a Jesucristo."
    ),
    Pair(7, 13) to SaintTemplate(
      title = "San Enrique, emperador",
      saintName = "San Enrique, emperador del Sacro Imperio",
      biography = "Emperador germánico del siglo XI y esposo de Santa Cunegunda. Gobernó con justicia irreprochable, reformó la vida monástica y el clero, fundó la diócesis de Bamberg y asistió a los sínodos papales con profunda sumisión filial.",
      patronage = "Gobernantes, reyes católicos, personas con discapacidad física y Bamberg",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Enrique emperador, que supiste compaginar el peso del gobierno imperial con la más alta santidad cristiana, guía a nuestros gobernantes por el bien común."
    ),
    Pair(7, 14) to SaintTemplate(
      title = "San Camilo de Lelis",
      saintName = "San Camilo de Lelis, presbítero de los enfermos",
      biography = "Soldado italiano jugador y pendenciero que se convirtió radicalmente en el hospital de incurables de Roma. Fundó la Orden de los Ministros de los Enfermos (Camilos) con el emblema de la Cruz Roja, sirviendo a los moribundos como a Cristo.",
      patronage = "Hospitales, enfermos, enfermeros, personal sanitario y moribundos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Camilo de Lelis, que veías en cada enfermo la carne doliente de Jesús, concede a los sanitarios ternura compasiva para cuidar a los enfermos terminales."
    ),
    Pair(7, 15) to SaintTemplate(
      title = "San Buenaventura",
      saintName = "San Buenaventura, obispo y doctor de la Iglesia (Doctor Seráfico)",
      biography = "Fraile franciscano italiano, Ministro General de la Orden y cardenal de Albano. Gran teólogo místico de la Universidad de París, compuso la biografía oficial de San Francisco (Leyenda Mayor) y el «Itinerario de la mente hacia Dios».",
      patronage = "Teólogos místicos, la orden franciscana y estudiantes",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Buenaventura, Doctor Seráfico, atráenos por la vía del amor ardiente a contemplar a Dios en la creación y en la Cruz salvadora de Cristo."
    ),
    Pair(7, 16) to SaintTemplate(
      title = "Nuestra Señora del Carmen",
      saintName = "Memoria de la Santísima Virgen María del Monte Carmelo (Virgen del Carmen)",
      biography = "Celebra la protección maternal de María sobre la Orden de los ermitaños del Monte Carmelo en Tierra Santa. Reina y hermosura del Carmelo, entregó el Santo Escapulario a San Simón Stock como signo de alianza y auxilio en el purgatorio.",
      patronage = "Gente de mar, marineros, pescadores, ánimas del purgatorio y la Armada",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Flor del Carmelo, viña florida, esplendor del cielo, Virgen fecunda y singular: a los carmelitas da tus favores, Estrella del mar, ruega por nosotros."
    ),
    Pair(7, 17) to SaintTemplate(
      title = "San Alejo, mendigo de Dios",
      saintName = "San Alejo, confesor de la fe",
      biography = "Noble romano del siglo V que la noche de sus bodas huyó por inspiración divina a Edesa en Siria, viviendo diecisiete años como mendigo junto a la basílica mariana. Regresó a Roma viviendo desconocido bajo la escalera de su propia casa paterna.",
      patronage = "Mendigos, vagabundos, personas que sufren desprecio y humildad",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Alejo, que preferiste las burlas del mundo y el desprecio de los hombres antes que perder la amistad de Dios, enséñanos a amar la santa humildad."
    ),
    Pair(7, 18) to SaintTemplate(
      title = "San Federico de Utrecht",
      saintName = "San Federico, obispo y mártir",
      biography = "Obispo holandés del siglo IX. Evangelizador celoso de los frisones, combatió sin miedo las costumbres paganas y censuró valientemente la conducta adúltera de la emperatriz Judith, muriendo asesinado al pie del altar tras celebrar la Misa.",
      patronage = "Personas con sordera, defensores de la moral y los Países Bajos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Federico, mártir de la santidad del matrimonio y de la dignidad pastoral, concede valentía a los pastores de la Iglesia para anunciar la verdad."
    ),
    Pair(7, 19) to SaintTemplate(
      title = "San Arsenio el Grande",
      saintName = "San Arsenio, ermitaño de Egipto",
      biography = "Tutor noble de los hijos del emperador Teodosio en Constantinopla. Escuchó una voz divina que le decía: «Huye, calla, vive en silencio; ésas son las fuentes de la salvación». Vivió cincuenta y cinco años en el desierto de Scete en oración continua.",
      patronage = "Educadores arrepentidos de la vanidad, contemplativos y el silencio",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Arsenio el Grande, maestro de recogimiento interior, enséñanos a guardar silencio ante los ruidos del mundo para escuchar la voz de Dios."
    ),
    Pair(7, 20) to SaintTemplate(
      title = "San Elías profeta",
      saintName = "San Elías, profeta de fuego",
      biography = "Padre espiritual del Monte Carmelo. Defendió con celo abrasador el honor del Dios único en el Monte Carmelo frente a los cuatrocientos cincuenta falsos profetas de Baal, escuchando a Dios en el susurro de una brisa suave en el Horeb.",
      patronage = "Orden del Carmen, profetas, celo por el Señor y ermitaños",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "«¡Viva el Señor, en cuya presencia estoy!». San Elías profeta, enciende en nuestras almas el celo por el honor de Dios y la defensa de la verdad."
    ),
    Pair(7, 21) to SaintTemplate(
      title = "San Lorenzo de Brindisi",
      saintName = "San Lorenzo de Brindisi, presbítero y doctor de la Iglesia",
      biography = "Fraile capuchino italiano del siglo XVI dotado de un prodigioso conocimiento de lenguas bíblicas. Con la sola cruz en la mano animó a las tropas cristianas en la batalla de Albarregal; doctor apostólico por su inmensa obra mariana y bíblica.",
      patronage = "Capuchinos, teólogos marianos, Brindisi y predicadores bíblicos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Lorenzo de Brindisi, que con tu palabra santa convertiste los corazones al Evangelio, alcánzanos una sed profunda de meditar la Sagrada Escritura."
    ),
    Pair(7, 22) to SaintTemplate(
      title = "Santa María Magdalena",
      saintName = "Fiesta de Santa María Magdalena, apóstol de los apóstoles",
      biography = "Liberada por Jesús de siete demonios, lo siguió fielmente hasta el pie de la Cruz en el Calvario. Fue la primera testigo de la gloriosa Resurrección en la mañana de Pascua y enviada por Cristo para anunciar la Buena Nueva a los Apóstoles.",
      patronage = "Mujeres penitentes, pecadores arrepentidos, contemplativos y boticarios",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa María Magdalena, que amaste a Cristo con fidelidad inquebrantable hasta el sepulcro vacío, alcánzanos lágrimas de sincera conversión y fe pascual."
    ),
    Pair(7, 23) to SaintTemplate(
      title = "Santa Brígida de Suecia",
      saintName = "Fiesta de Santa Brígida de Suecia, religiosa y patrona de Europa",
      biography = "Noble sueca, madre de ocho hijos (entre ellos Santa Catalina de Suecia). Tras enviudar fundó la Orden del Santísimo Salvador (Brigidinas). Célebre por sus revelaciones celestiales sobre la Pasión de Cristo y sus oraciones al crucificado.",
      patronage = "Patrona de Europa, Suecia, viudas y peregrinos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Brígida de Suecia, que meditaste sin cesar en los dolores y llagas de Cristo, haz que grabemos en nuestra memoria el infinito amor de la Cruz."
    ),
    Pair(7, 24) to SaintTemplate(
      title = "San Chárbel Makhlouf",
      saintName = "San Chárbel Makhlouf, ermitaño maronita de Annaya",
      biography = "Sacerdote y monje ermitaño del Líbano del siglo XIX. Pasó veintitrés años en la soledad del yermo de Annaya en rigurosa penitencia y adoración incesante a la Eucaristía. Su tumba sigue derramando prodigiosos milagros de sanación física y espiritual.",
      patronage = "El Líbano, enfermos desahuciados, causas difíciles y contemplativos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Chárbel, prodigioso taumaturgo del Líbano, intercede ante el Corazón de Jesús por la salud de los enfermos y por la paz en Medio Oriente."
    ),
    Pair(7, 25) to SaintTemplate(
      title = "Santiago el Mayor, apóstol",
      saintName = "Fiesta de Santiago el Mayor, apóstol y patrono de España",
      biography = "Hijo de Zebedeo y hermano de San Juan. Testigo de la Transfiguración y de la agonía en Getsemaní. Proclamó el Evangelio en Hispania; primer apóstol en derramar su sangre decapitado en Jerusalén bajo Herodes Agripa. Su sepulcro en Compostela congrega a millones.",
      patronage = "España, peregrinos, jinetes, soldados y la evangelización hispana",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Santo Apóstol Santiago, protector de las Españas y guía de los peregrinos, fortalece nuestra fe para caminar con paso firme hacia la patria celestial."
    ),
    Pair(7, 26) to SaintTemplate(
      title = "Santos Joaquín y Ana",
      saintName = "Santos Joaquín y Ana, padres de la Santísima Virgen María",
      biography = "Esposos fieles del linaje de David a quienes Dios bendijo en su ancianidad concediéndoles ser los padres de la Inmaculada Virgen María y abuelos terrenales de Nuestro Señor Jesucristo. Modelo de fidelidad en la madurez conyugal.",
      patronage = "Abuelos, personas mayores, educadores familiares y mujeres estériles",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos Joaquín y Ana, abuelos de Jesús, bendecid a nuestros mayores y enseñad a nuestras familias a transmitir la fe cristiana a las futuras generaciones."
    ),
    Pair(7, 27) to SaintTemplate(
      title = "San Pantaleón, médico y mártir",
      saintName = "San Pantaleón de Nicomedia, médico y mártir",
      biography = "Médico imperial de Nicomedia en el siglo IV. Convertido por el sacerdote Hermolao, atendía gratuitamente a los pobres («Pantaleón» significa «el que se compadece de todos»). Fue clavado a un olivo y decapitado por confesar a Cristo.",
      patronage = "Médicos, comadronas, enfermos de dolores crónicos y Nicomedia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Pantaleón, que uniste la ciencia médica con la caridad cristiana, alivia los padecimientos de quienes sufren enfermedades corporales."
    ),
    Pair(7, 28) to SaintTemplate(
      title = "San Pedro Poveda",
      saintName = "San Pedro Poveda, presbítero, educador y mártir",
      biography = "Sacerdote español que evangelizó las cuevas de Guadix y fundó la Institución Teresiana para la formación de profesores laicos católicos. Asesinado en Madrid en 1936 confesando: «Soy sacerdote de Jesucristo».",
      patronage = "Educadores católicos, profesores, laicos comprometidos y Guadix",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Pedro Poveda, mártir de la educación cristiana, alcánzanos valentía para testimoniar el Evangelio en las aulas y en la cultura contemporánea."
    ),
    Pair(7, 29) to SaintTemplate(
      title = "Santos Marta, María y Lázaro",
      saintName = "Memoria de los Santos Marta, María y Lázaro de Betania",
      biography = "Los santos hermanos de Betania que acogieron con entrañable cariño a Jesús en su hogar. Marta representa la caridad activa en el servicio; María la escucha contemplativa a los pies del Maestro; y Lázaro el testigo resucitado del poder divino.",
      patronage = "Hospitalidad, cocineros, hoteleros, vida contemplativa y sirvientes",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos Marta, María y Lázaro, enseñadnos a conjugar la acción solícita y la contemplación orante en el servicio generoso a Jesucristo."
    ),
    Pair(7, 30) to SaintTemplate(
      title = "San Pedro Crisólogo",
      saintName = "San Pedro Crisólogo, obispo de Rávena y doctor de la Iglesia",
      biography = "Obispo del siglo V apodado «Crisólogo» (palabra de oro) por la brillante brevedad y unción celestial de sus homilías. Explicó con claridad magistral la unión de las dos naturalezas en Cristo y la divina maternidad de María.",
      patronage = "Predicadores de homilías, Rávena y teólogos de la Encarnación",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro Crisólogo, que alimentaste a tu rebaño con sermones de oro celestial, haz que acojamos con amor y provecho la Palabra divina."
    ),
    Pair(7, 31) to SaintTemplate(
      title = "San Ignacio de Loyola",
      saintName = "Memoria de San Ignacio de Loyola, presbítero y fundador de la Compañía de Jesús",
      biography = "Soldado vasco que convaleciente en Loyola se convirtió leyendo la vida de Cristo y de los santos. Fundó la Compañía de Jesús (Jesuitas) con sus célebres «Ejercicios Espirituales», viviendo consagrado «Para la mayor gloria de Dios» (A.M.D.G.).",
      patronage = "Ejercicios espirituales, soldados, la Compañía de Jesús y el discernimiento",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Tomad, Señor, y recibid toda mi libertad, mi memoria, mi entendimiento y toda mi voluntad. Todo es vuestro; disponed a vuestra voluntad. Dadme vuestro amor y gracia, que esto me basta». Amén."
    ),

    // ==========================================
    // AGOSTO (31 días)
    // ==========================================
    Pair(8, 1) to SaintTemplate(
      title = "San Alfonso María de Ligorio",
      saintName = "San Alfonso María de Ligorio, obispo y doctor de la Iglesia",
      biography = "Brillante abogado napolitano que renunció a su carrera para ordenarse sacerdote. Fundó la Congregación del Santísimo Redentor (Redentoristas); autor de «Las Glorias de María» y de la Teología Moral, patrono de confesores y moralistas.",
      patronage = "Confesores, moralistas, Nápoles, enfermos de artritis y la prensa católica",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Alfonso María de Ligorio, maestro insigne de la oración y de la teología moral, enséñanos a acudir filialmente a María en toda tentación."
    ),
    Pair(8, 2) to SaintTemplate(
      title = "San Eusebio de Vercelli y San Pedro Julián Eymard",
      saintName = "San Eusebio de Vercelli, obispo, y San Pedro Julián Eymard, presbítero",
      biography = "San Eusebio combatió el arrianismo sufriendo destierros. San Pedro Julián Eymard fundó los Sacerdotes del Santísimo Sacramento consagrando su vida a la adoración perpetua a la Eucaristía.",
      patronage = "Adoradores nocturnos, apóstoles de la Eucaristía y Piamonte",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro Julián Eymard, apóstol de la Eucaristía, enciende en la Iglesia un amor abrasador hacia la presencia real de Jesús en el Sagrario."
    ),
    Pair(8, 3) to SaintTemplate(
      title = "Santa Lidia de Tiatira",
      saintName = "Santa Lidia de Tiatira, primera cristiana de Europa",
      biography = "Comerciante de púrpura en Filipos (Macedonia). Escuchó la predicación de San Pablo junto al río; el Señor abrió su corazón para que aceptara el Evangelio, siendo bautizada con toda su casa y hospedando a los apóstoles.",
      patronage = "Tintoreros, comerciantes de telas, laicos colaboradores y conversos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Lidia, que abriste tu corazón a la gracia y tu hogar a los apóstoles de Cristo, enséñanos a ser generosos con las cosas de Dios."
    ),
    Pair(8, 4) to SaintTemplate(
      title = "San Juan María Vianney (El Santo Cura de Ars)",
      saintName = "San Juan María Vianney, presbítero y patrono universal de los párrocos",
      biography = "Párroco del diminuto pueblo de Ars en Francia en el siglo XIX. Pasaba hasta dieciséis horas diarias en el confesonario acogiendo a peregrinos de toda Europa; modelo heroico de oración, ayuno y caridad sacerdotal inagotable.",
      patronage = "Párrocos de todo el mundo, sacerdotes diocesanos y confesores",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan María Vianney, Santo Cura de Ars, ruega por nuestros sacerdotes para que sean santos pastores celosos y amantes del perdón divino."
    ),
    Pair(8, 5) to SaintTemplate(
      title = "Dedicación de la Basílica de Santa María la Mayor",
      saintName = "Dedicación de la Basílica de Santa María la Mayor (Nuestra Señora de las Nieves)",
      biography = "La basílica mariana más antigua de Occidente en Roma, erigida por Sixto III tras el Concilio de Éfeso para glorificar la Maternidad Divina de María. Una nevada milagrosa en agosto señaló al Papa Liberio el lugar exacto de su construcción.",
      patronage = "Roma, templos dedicados a la Virgen y la maternidad divina",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa María, Madre de Dios y Señora de las Nieves, cubre con tu manto purísimo nuestras vidas y consérvanos puros de cuerpo y alma."
    ),
    Pair(8, 6) to SaintTemplate(
      title = "La Transfiguración del Señor",
      saintName = "Fiesta de la Transfiguración del Señor en el Monte Tabor",
      biography = "Jesús subió al monte Tabor con Pedro, Santiago y Juan y se transfiguró ante ellos: su rostro brilló como el sol y sus vestiduras se volvieron blancas como la luz, revelando su gloria divina antes del escándalo de la Cruz.",
      patronage = "Místicos, contemplativos, la vida de oración y la gloria pascual",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, que en el monte Tabor revelaste tu gloria a los apóstoles, transfórmanos con tu gracia para que seamos reflejo vivo de tu santidad."
    ),
    Pair(8, 7) to SaintTemplate(
      title = "San Sixto II y San Cayetano de Thiene",
      saintName = "San Sixto II, papa mártir, y San Cayetano de Thiene, patrono del pan y del trabajo",
      biography = "San Sixto II fue martirizado en las catacumbas de Roma. San Cayetano, noble vicentino del siglo XVI, fundó los Teatinos viviendo en radical desprendimiento y confiando ciegamente en la Divina Providencia sin pedir limosna.",
      patronage = "Cayetano: desempleados, pan, trabajo y Providencia divina; Sixto: Roma",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Cayetano, padre de la Providencia, atiende a los que sufren falta de pan o de trabajo digno, y acrecienta nuestra confianza en el amor del Padre."
    ),
    Pair(8, 8) to SaintTemplate(
      title = "Santo Domingo de Guzmán",
      saintName = "Santo Domingo de Guzmán, presbítero y fundador de la Orden de Predicadores",
      biography = "Sacerdote castellano del siglo XIII que fundó la Orden de Predicadores (Dominicos) para combatir las herejías mediante la predicación doctrinal, el estudio riguroso, la pobreza mendicante y la difusión del Santo Rosario entregado por la Virgen.",
      patronage = "Predicadores, teólogos, dominicos, astrónomos y la oración del Rosario",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Domingo de Guzmán, hombre evangélico que sólo hablaba con Dios o de Dios, inflama nuestras almas en el celo por proclamar la Verdad."
    ),
    Pair(8, 9) to SaintTemplate(
      title = "Santa Teresa Benedicta de la Cruz (Edith Stein)",
      saintName = "Fiesta de Santa Teresa Benedicta de la Cruz (Edith Stein), mártir y patrona de Europa",
      biography = "Brillante filósofa judía alemana y discípula de Husserl convertida al catolicismo tras leer la autobiografía de Santa Teresa de Jesús. Monja carmelita descalza, fue deportada y asesinada en las cámaras de gas de Auschwitz en 1942.",
      patronage = "Patrona de Europa, filósofos, mártires del Holocausto y conversos judíos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Teresa Benedicta de la Cruz, que hallaste en la Cruz de Cristo la respuesta suprema a tu búsqueda de la Verdad, intercede por la paz en Europa."
    ),
    Pair(8, 10) to SaintTemplate(
      title = "San Lorenzo, diácono y mártir",
      saintName = "Fiesta de San Lorenzo, diácono y mártir de Roma",
      biography = "Primer diácono de la Iglesia de Roma encargado de administrar los bienes y las limosnas a los pobres. Intimado por el prefecto imperial a entregar los tesoros de la Iglesia, congregó a los ciegos, lisiados y mendigos diciendo: «Éstos son los tesoros de la Iglesia». Asado vivo sobre una parrilla ardiente.",
      patronage = "Diáconos, pobres, bomberos, cocineros, asadores y bibliotecarios",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "San Lorenzo mártir, que con amor ardiente consumiste tu vida en la parrilla por servir a los pobres, haznos generosos con los necesitados."
    ),
    Pair(8, 11) to SaintTemplate(
      title = "Santa Clara de Asís",
      saintName = "Santa Clara de Asís, virgen y fundadora de las Clarisas",
      biography = "Noble doncella de Asís que a los dieciocho años huyó para consagrarse a Cristo en manos de San Francisco. Fundó las Clarisas, defendiendo heroicamente el «privilegio de la altísima pobreza». Puso en fuga a los sarracenos mostrando el Santísimo Sacramento.",
      patronage = "Televisión, telecomunicaciones, clarisas y enfermedades de los ojos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Clara de Asís, enamorada de la pobreza de Cristo y de su presencia en la Eucaristía, haz que pongamos nuestro corazón solo en los bienes celestiales."
    ),
    Pair(8, 12) to SaintTemplate(
      title = "Santa Juana Francisca de Chantal",
      saintName = "Santa Juana Francisca de Chantal, religiosa y cofundadora",
      biography = "Baronesa francesa, madre ejemplar de seis hijos. Tras quedar viuda conoció a San Francisco de Sales, con quien fundó la Orden de la Visitación de Santa María, brillando por su abnegación, humildad y caridad silenciosa.",
      patronage = "Viudas, madres de familia, la Visitación y paciencia ante las pruebas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Juana Francisca de Chantal, que encontraste en la voluntad de Dios tu mayor consuelo, concédenos aceptar las pruebas con fe serena."
    ),
    Pair(8, 13) to SaintTemplate(
      title = "Santos Ponciano e Hipólito",
      saintName = "Santos Ponciano, papa, e Hipólito, presbítero, mártires",
      biography = "El Papa Ponciano y el insigne teólogo Hipólito sufrieron divisiones en Roma pero, desterrados juntos a las minas insalubres de Cerdeña por el emperador Maximino, se reconciliaron fraternalmente en la fe antes de morir mártires.",
      patronage = "Reconciliación sacerdotal, presos en minas y la unidad eclesial",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que uniste en el perdón y en la gloria del martirio a los santos Ponciano e Hipólito, aleja de tu Iglesia toda semilla de discordia."
    ),
    Pair(8, 14) to SaintTemplate(
      title = "San Maximiliano María Kolbe",
      saintName = "San Maximiliano María Kolbe, presbítero y mártir de la caridad",
      biography = "Fraile franciscano conventual polaco y apóstol de la Inmaculada (fundador de la Milicia de la Inmaculada). Prisionero en el campo nazi de Auschwitz, ofreció voluntariamente su vida para salvar a un padre de familia condenado a morir de hambre en el búnker.",
      patronage = "Periodistas católicos, prisioneros, familias y la devoción a la Inmaculada",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Maximiliano Kolbe, mártir de la caridad suprema que diste tu vida por un hermano, enséñanos a amar como Cristo nos amó."
    ),
    Pair(8, 15) to SaintTemplate(
      title = "La Asunción de la Virgen María",
      saintName = "Solemnidad de la Asunción de la Santísima Virgen María en cuerpo y alma al Cielo",
      biography = "Dogma de fe definido solemnemente por Pío XII en 1950: concluida su vida terrena, la Inmaculada Madre de Dios fue asunta en cuerpo y alma a la gloria del cielo, donde reina como Reina del Universo junto a su divino Hijo.",
      patronage = "Patrona de Francia, de miles de pueblos católicos y prenda de nuestra resurrección",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Santa María Asunta al Cielo, Reina de los Ángeles y de los hombres, vuelve hacia nosotros tus ojos misericordiosos y guía nuestros pasos a la gloria eterna."
    ),
    Pair(8, 16) to SaintTemplate(
      title = "San Esteban de Hungría y San Roque",
      saintName = "San Esteban de Hungría, rey, y San Roque, peregrino",
      biography = "San Esteban cristianizó Hungría consagrando su corona a la Virgen. San Roque, peregrino provenzal del siglo XIV, cuidó apestados en Italia contagiándose de la peste; refugiado en un bosque, un perro le llevaba pan diariamente.",
      patronage = "Esteban: Hungría y gobernantes; Roque: contra pestes, epidemias y perros",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Roque bendito, líbranos de epidemias y contagios corporales y espirituales; San Esteban, protege la fe de los pueblos cristianos."
    ),
    Pair(8, 17) to SaintTemplate(
      title = "San Jacinto de Cracovia",
      saintName = "San Jacinto de Cracovia, presbítero dominico",
      biography = "El «Apóstol del Norte». Dominico polaco que evangelizó Polonia, Prusia y Rusia. Durante una invasión tártara en Kiev salvó el copón del Santísimo Sacramento y una pesada estatua de alabastro de la Virgen que se volvió milagrosamente liviana.",
      patronage = "Polonia, salvamento de ahogados y la devoción eucarística y mariana",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Jacinto de Cracovia, que cruzaste ríos con la Eucaristía y la imagen de María en tus brazos, defiéndenos del peligro y la tribulación."
    ),
    Pair(8, 18) to SaintTemplate(
      title = "Santa Elena, emperatriz",
      saintName = "Santa Elena, emperatriz augusta",
      biography = "Madre del emperador Constantino el Grande. Siendo anciana peregrinó a Tierra Santa en el siglo IV, edificando basílicas sobre la Gruta de Belén y el Monte de los Olivos y hallando en las excavaciones del Gólgota la Vera Cruz de Nuestro Señor.",
      patronage = "Arqueólogos, descubridores, matrimonios rotos y la Santa Cruz",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Elena emperatriz, que con incansable amor buscaste el madero sagrado de la Cruz del Salvador, enséñanos a gloriarnos solo en la Cruz de Cristo."
    ),
    Pair(8, 19) to SaintTemplate(
      title = "San Juan Eudes",
      saintName = "San Juan Eudes, presbítero y doctor de los Sagrados Corazones",
      biography = "Sacerdote normando del siglo XVII, gran misionero popular. Fundó la Congregación de Jesús y María (Eudistas) y la Orden de Nuestra Señora de la Caridad, siendo el primer propagador del culto litúrgico a los Sagrados Corazones de Jesús y María.",
      patronage = "Misioneros populares, seminarios y devotos de los Sagrados Corazones",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Eudes, que proclamaste el amor inmenso de los Corazones de Jesús y María, haznos vivir consagrados a su divina ternura."
    ),
    Pair(8, 20) to SaintTemplate(
      title = "San Bernardo de Claraval",
      saintName = "San Bernardo de Claraval, abad y doctor de la Iglesia (Doctor Melifluo)",
      biography = "Monje cisterciense francés del siglo XII, lumbrera de la cristiandad y fundador de Claraval. Pacificador de reyes y papas, insigne cantor de las glorias de la Virgen («Acuérdate, oh piadosísima Virgen María») y teólogo del amor divino.",
      patronage = "Gibraltar, apicultores, cereros, orden cisterciense y oradores",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Bernardo abad, Doctor Melifluo, alcánzanos una devoción tierna y filial hacia la Virgen María, para que recurramos siempre a su amparo maternal."
    ),
    Pair(8, 21) to SaintTemplate(
      title = "San Pío X, papa",
      saintName = "San Pío X, papa de la Eucaristía",
      biography = "Giuseppe Sarto, hijo de campesinos que llegó a la Cátedra de Pedro con el lema «Restaurar todo en Cristo». Promovió la Comunión temprana y frecuente de los niños, reformó el derecho canónico y la música sacra y combatió el modernismo.",
      patronage = "Primeros comulgantes, párrocos humildes, catequistas y Treviso",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pío X, pontífice humilde y santo, custodia la pureza de la fe en la Iglesia y renueva en nosotros el amor apasionado al Pan de la Eucaristía."
    ),
    Pair(8, 22) to SaintTemplate(
      title = "Santa María Reina",
      saintName = "Memoria de Santa María Reina (El Reinado de María)",
      biography = "Instituida por Pío XII como corona litúrgica de la fiesta de la Asunción. María, ensalzada por Dios sobre todas las jerarquías angélicas, reina con Jesucristo como Reina de cielos y tierra, ejerciendo su misericordiosa intercesión materna.",
      patronage = "Reinado universal de Cristo y de su Madre, socorro a las almas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "¡Salve, Reina y Madre de misericordia! Reina en nuestros corazones, en nuestras familias y en todas las naciones con la dulzura de tu paz."
    ),
    Pair(8, 23) to SaintTemplate(
      title = "Santa Rosa de Lima",
      saintName = "Santa Rosa de Lima, virgen y patrona principal de América",
      biography = "Terciaria dominica limeña del siglo XVII, primera santa canonizada de América. Dedicó su vida a la penitencia rigurosa, la adoración eucarística, el cuidado de enfermos indígenas y esclavos y la oración contemplativa en su ermita del huerto.",
      patronage = "América, Filipinas, Lima, Perú, jardineros y floristas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Rosa de Lima, rosa hermosa del jardín de Dios en tierras americanas, alcánzanos pureza de alma y amor ardiente a Cristo crucificado."
    ),
    Pair(8, 24) to SaintTemplate(
      title = "San Bartolomé, apóstol",
      saintName = "Fiesta de San Bartolomé (Natanael), apóstol",
      biography = "El apóstol Natanael de Caná de Galilea, de quien Jesús dijo: «Ahí tenéis a un verdadero israelita, en quien no hay engaño». Proclamó el Evangelio en la India y Armenia, donde sufrió el crudelísimo martirio de ser desollado vivo por confesar a Cristo.",
      patronage = "Armenia, curtidores, carniceros, peleteros y zapateros",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "San Bartolomé apóstol, hombre sincero y sin engaño, danos un corazón limpio y transparente para seguir a Cristo con fidelidad hasta el final."
    ),
    Pair(8, 25) to SaintTemplate(
      title = "San Luis, rey, y San José de Calasanz",
      saintName = "San Luis, rey de Francia, y San José de Calasanz, presbítero",
      biography = "San Luis IX gobernó con justicia incomparable, fundó hospitales y rescató la Corona de Espinas. San José de Calasanz, sacerdote aragonés en Roma, fundó las Escuelas Pías (Escolapios) para educar gratuitamente a los niños pobres.",
      patronage = "Luis: gobernantes y terciarios franciscanos; Calasanz: escuelas pías y educadores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Luis rey y San José de Calasanz, que consagrasteis vuestros dones a los más pobres, concedednos buscar siempre el bien común y la fe de los niños."
    ),
    Pair(8, 26) to SaintTemplate(
      title = "Santa Teresa de Jesús Jornet",
      saintName = "Santa Teresa de Jesús Jornet e Ibars, virgen y fundadora",
      biography = "Maestra española que fundó las Hermanitas de los Ancianos Desamparados. Dedicó su vida entera a acoger, lavar, alimentar y consolar con infinita ternura maternal a los ancianos abandonados en sus asilos: «Cuidar los cuerpos para salvar las almas».",
      patronage = "Ancianos desamparados, geriátricos, asilos y personal gerontológico",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Teresa Jornet, madre de los ancianos solitarios, bendice a nuestros abuelos y despierta en la sociedad el respeto sagrado a la vejez."
    ),
    Pair(8, 27) to SaintTemplate(
      title = "Santa Mónica",
      saintName = "Santa Mónica, madre ejemplar y modelo de oración",
      biography = "Madre de San Agustín nacida en Tagaste (África). Durante más de treinta años oró, lloró y ayunó sin desfallecer por la conversión de su díscolo hijo, recibiendo el consuelo de San Ambrosio: «Es imposible que se pierda el hijo de tantas lágrimas».",
      patronage = "Madres de familia, esposas sufridas, hijos alejados de la fe y viudas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Mónica, modelo insigne de paciencia y plegaria perseverante, atiende las lágrimas de las madres que sufren por sus hijos y alcánzales la conversión."
    ),
    Pair(8, 28) to SaintTemplate(
      title = "San Agustín de Hipona",
      saintName = "San Agustín de Hipona, obispo y doctor de la Iglesia (Doctor de la Gracia)",
      biography = "Una de las mentes más brillantes de la humanidad. Convertido en Milán tras sus desvaríos juveniles, fue obispo de Hipona en el norte de África. Autor de las inmortales «Confesiones» («Nos hiciste, Señor, para Ti, y nuestro corazón está inquieto hasta que descanse en Ti»).",
      patronage = "Teólogos, filósofos, impresores, conversos y buscadores de la verdad",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«¡Tarde te amé, Hermosura tan antigua y tan nueva, tarde te amé!». San Agustín, sacia la sed de nuestras almas con el agua viva del amor divino."
    ),
    Pair(8, 29) to SaintTemplate(
      title = "Martirio de San Juan Bautista",
      saintName = "Memoria del Martirio de San Juan Bautista (La Degollación del Precursor)",
      biography = "El heraldo de Cristo selló su misión profética con el martirio por defender la santidad del matrimonio ante Herodes Antipas («No te es lícito tener la mujer de tu hermano»). Decapitado en la fortaleza de Maqueronte por el capricho de Salomé y Herodías.",
      patronage = "Mártires de la verdad, defensa de la moral conyugal y conversiones",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Juan Bautista, mártir invicto de la verdad y de la moral de Dios, danos valentía para denunciar el pecado y ser fieles a Cristo hasta el fin."
    ),
    Pair(8, 30) to SaintTemplate(
      title = "San Fiacro y Santa Margarita Ward",
      saintName = "San Fiacro de Breuil, eremita, y Santa Margarita Ward, mártir",
      biography = "San Fiacro, monje irlandés que cultivó un célebre huerto medicinal en Francia para curar gratis a los enfermos. Santa Margarita Ward, dama inglesa ahorcada en Tyburn en 1588 por ayudar a escapar de prisión a un sacerdote católico perseguido.",
      patronage = "Fiacro: jardineros, taxistas y hortelanos; Margarita: mujeres valientes",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Fiacro y Santa Margarita Ward, interceded por nosotros para que usemos los dones de la naturaleza y de la libertad al servicio de Dios."
    ),
    Pair(8, 31) to SaintTemplate(
      title = "San Ramón Nonato",
      saintName = "San Ramón Nonato, religioso mercedario y cardenal",
      biography = "Extraído del vientre de su madre muerta en Cataluña («no nato»). Religioso de la Merced, marchó a Argel a rescatar cautivos cristianos; acabados los fondos, se quedó como rehén sufriendo tormentos y el candado en sus labios para que no predicara.",
      patronage = "Embarazadas, partos difíciles, matronas, recién nacidos y falsas acusaciones",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ramón Nonato, celestial protector de las madres gestantes, cuida la vida del niño que crece en el seno materno y alcánzale un parto feliz."
    ),

    // ==========================================
    // SEPTIEMBRE (30 días)
    // ==========================================
    Pair(9, 1) to SaintTemplate(
      title = "San Gil abad (Egidio)",
      saintName = "San Gil abad, eremita",
      biography = "Noble ateniense del siglo VIII que repartió sus bienes y se retiró a los bosques del sur de Francia, alimentado por la leche de una cierva. El rey de los godos lo hirió accidentalmente al cazar y, conmovido por su santidad, le erigió un monasterio.",
      patronage = "Lisiados, mendigos, pastores, bosques y contra el pánico nocturno",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Gil abad, protector de los débiles y enfermos lisiados, concédenos tu paciencia serena para sobrellevar las dolencias corporales."
    ),
    Pair(9, 2) to SaintTemplate(
      title = "Beatos Mártires de Septiembre de París",
      saintName = "Los Beatos Mártires de las Prisiones de París",
      biography = "Ciento noventa y un obispos, sacerdotes y religiosos masacrados en París en 1792 durante la Revolución Francesa por negarse a prestar el juramento de la Constitución Civil del Clero cismática, perdonando a sus ejecutores.",
      patronage = "Fidelidad a Roma, libertad religiosa y mártires contemporáneos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Beatos mártires de París, que no dudasteis en entregar la vida antes que romper la comunión con el Vicario de Cristo, guardad a la Iglesia en fidelidad."
    ),
    Pair(9, 3) to SaintTemplate(
      title = "San Gregorio Magno",
      saintName = "San Gregorio Magno, papa y doctor de la Iglesia",
      biography = "Prefecto de Roma que convirtió su palacio en monasterio y se hizo monje. Elegido Papa en el siglo VI, adoptó el título de «Siervo de los siervos de Dios», alimentó a Roma en la peste y hambruna, promovió el Canto Gregoriano y evangelizó Inglaterra.",
      patronage = "Papas, maestros, cantores, músicos sacros y albañiles",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Gregorio Magno, pastor admirable según el Corazón de Dios, enséñanos a gobernar con humildad y a buscar el consuelo de los afligidos."
    ),
    Pair(9, 4) to SaintTemplate(
      title = "Santa Rosalía de Palermo",
      saintName = "Santa Rosalía de Palermo, virgen y eremita",
      biography = "Noble doncella siciliana del siglo XII que abandonó la corte para vivir en rigurosa soledad en una gruta del Monte Pellegrino. Siglos después, el hallazgo de sus restos y su procesión libraron milagrosamente a Palermo de una peste mortífera.",
      patronage = "Palermo, Sicilia, contra la peste, epidemias y aislamiento",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Rosalía, lirio solitario del amor divino, protege a nuestras ciudades de todo mal y peste del cuerpo y del alma."
    ),
    Pair(9, 5) to SaintTemplate(
      title = "Santa Teresa de Calcuta (Madre Teresa)",
      saintName = "Santa Teresa de Calcuta, fundadora de las Misioneras de la Caridad",
      biography = "Religiosa albanesa que en las calles de Calcuta escuchó la «sed de Jesús». Fundó las Misioneras de la Caridad para acoger a los moribundos abandonados en las aceras, a los leprosos y huérfanos, viviendo con profunda alegría y noche oscura interior.",
      patronage = "Misioneros de la caridad, los no nacidos, moribundos y voluntarios sociales",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Teresa de Calcuta, que saciaste la sed de Jesús en la Cruz amando a los más pobres entre los pobres, enséñanos a amar hasta que nos duela."
    ),
    Pair(9, 6) to SaintTemplate(
      title = "San Zacarías, profeta",
      saintName = "San Zacarías, profeta del Antiguo Testamento",
      biography = "Profeta que alentó la reconstrucción del Templo de Jerusalén tras el exilio de Babilonia y profetizó con sublime precisión la entrada mesiánica de Jesús en Jerusalén montado en un asno y las treinta monedas de plata.",
      patronage = "Profetas, esperanzas mesiánicas y constructores de templos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que anunciaste por los profetas la venida de tu Hijo Jesucristo, haz que preparemos nuestro corazón para recibir su paz."
    ),
    Pair(9, 7) to SaintTemplate(
      title = "Santa Regina, virgen y mártir",
      saintName = "Santa Regina (Reine) de Autun, virgen y mártir",
      biography = "Joven gala del siglo III hija de paganos, convertida por su nodriza cristiana. Al ser descubierta por el prefecto Olibrio apacentando ovejas, se negó a desposarse con él y a adorar a los ídolos, sufriendo prisión y martirio con heroica serenidad.",
      patronage = "Pastores, víctimas de tortura, Autun y Borgoña",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Regina, virgen fiel a Cristo Redentor, alcánzanos firmeza en el bautismo y pureza para agradar a Dios en todas nuestras acciones."
    ),
    Pair(9, 8) to SaintTemplate(
      title = "La Natividad de la Virgen María",
      saintName = "Fiesta de la Natividad de la Santísima Virgen María",
      biography = "Nacimiento bendito de la aurora de nuestra salvación, la Inmaculada Niña María, nacida de los ancianos Joaquín y Ana. De Ella nacerá el Sol de Justicia, Cristo nuestro Dios, que quitó la maldición y nos dio la bendición eterna.",
      patronage = "Maternidades, recién nacidas, alfareros, tejedores y patrona de incontables pueblos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "¡Bendita sea tu santa cuna, oh Niña María! Tu nacimiento llenó de alegría a la tierra y al cielo, porque de Ti nació el Salvador del mundo."
    ),
    Pair(9, 9) to SaintTemplate(
      title = "San Pedro Claver",
      saintName = "San Pedro Claver, presbítero jesuita y esclavo de los esclavos",
      biography = "Misionero catalán en Cartagena de Indias (Colombia) en el siglo XVII. Hizo voto solemne de ser «esclavo de los negros para siempre». Bajaba a las pestilentes bodegas de los barcos negreros con comida y medicinas, bautizando a más de trescientas mil almas.",
      patronage = "Misiones entre afroamericanos, Colombia, derechos humanos e igualdad racial",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro Claver, esclavo por amor de los más despreciados del mundo, enséñanos a reconocer y amar a Cristo en los marginados de hoy."
    ),
    Pair(9, 10) to SaintTemplate(
      title = "San Nicolás de Tolentino",
      saintName = "San Nicolás de Tolentino, presbítero agustino",
      biography = "Fraile agustino italiano del siglo XIII célebre por sus ayunos, penitencias y dulzura con los afligidos. Consagrado a celebrar la Misa por las benditas almas del Purgatorio, por lo que fue proclamado patrono universal del Purgatorio.",
      patronage = "Benditas ánimas del Purgatorio, enfermos, panaderos y Tolentino",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Nicolás de Tolentino, celoso intercesor de las almas del Purgatorio, presenta nuestras oraciones ante el trono de Dios por los difuntos olvidados."
    ),
    Pair(9, 11) to SaintTemplate(
      title = "San Juan Gabriel Perboyre",
      saintName = "San Juan Gabriel Perboyre, presbítero paúl y mártir en China",
      biography = "Misionero lazarista francés en la China del siglo XIX. Traicionado por uno de sus catecúmenos por dinero, sufrió meses de crueles interrogatorios antes de morir colgado de una horca en forma de cruz un viernes a las tres de la tarde.",
      patronage = "Misioneros en Asia, lazaristas y contra la traición",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Juan Gabriel Perboyre, que te configuraste con Cristo crucificado hasta el último aliento, infunde celo misionero en los jóvenes católicos."
    ),
    Pair(9, 12) to SaintTemplate(
      title = "El Dulce Nombre de María",
      saintName = "Memoria del Santísimo Nombre de la Virgen María",
      biography = "Instituida en acción de gracias por la milagrosa liberación de Viena en 1683 ante el asedio otomano gracias a la intercesión de la Virgen invocada por el rey Juan Sobieski. El nombre de María es estrella de los mares, medicina y alegría del cristiano.",
      patronage = "Todos los devotos marianos, navegantes y auxilio en las tempestades",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«¡Oh clementísima, oh piadosa, oh dulce Virgen María! Que tu santísimo Nombre esté siempre en mis labios y en mi corazón en la vida y en la muerte»."
    ),
    Pair(9, 13) to SaintTemplate(
      title = "San Juan Crisóstomo",
      saintName = "San Juan Crisóstomo, patriarca y doctor de la Iglesia",
      biography = "«Boca de Oro». Patriarca de Constantinopla en el siglo IV, insigne comentarista bíblico y orador elocuente. Denunció con valentía el lujo desmedido y la corrupción cortesana, sufriendo crueles destierros en los que murió con sus famosas palabras: «¡Gloria a Dios por todo!»",
      patronage = "Predicadores sagrados, oradores, locutores y la Iglesia de Oriente",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Crisóstomo, maestro de la predicación evangélica, enséñanos a dar gloria a Dios en los éxitos y en los sufrimientos cotidianos."
    ),
    Pair(9, 14) to SaintTemplate(
      title = "La Exaltación de la Santa Cruz",
      saintName = "Fiesta de la Exaltación de la Santa Cruz",
      biography = "Conmemoración de la recuperación de la Vera Cruz por el emperador Heraclio en el año 628 y dedicación de la basílica del Santo Sepulcro en Jerusalén. La Cruz, antes instrumento de ignominia, es el trono glorioso del triunfo de Cristo sobre la muerte.",
      patronage = "Toda la Iglesia, devotos de la Pasión de Cristo y ebanistas",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "«Te adoramos, oh Cristo, y te bendecimos, que por tu santa Cruz redimiste al mundo». Enséñanos, Señor, a abrazar nuestra cruz de cada día."
    ),
    Pair(9, 15) to SaintTemplate(
      title = "Nuestra Señora de los Dolores",
      saintName = "Memoria de Nuestra Señora de los Dolores (La Virgen de la Piedad)",
      biography = "Al día siguiente de la Santa Cruz, contemplamos a la Madre corredentora unida a los padecimientos de su divino Hijo. Traspasada por la espada de dolor profetizada por Simeón, María nos acogió a todos como hijos al pie del Calvario.",
      patronage = "Madres desconsoladas, dolientes, personas en duelo y la Semana Santa",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Madre Dolorosa, junto a la Cruz del Salvador estuviste de pie sin desmayar. Consuela nuestras penas y enséñanos a acompañar el dolor de los que sufren."
    ),
    Pair(9, 16) to SaintTemplate(
      title = "Santos Cornelio y Cipriano",
      saintName = "Santos Cornelio, papa, y Cipriano, obispo, mártires",
      biography = "Cornelio, Papa que defendió la misericordia eclesial con los que habían caído en la persecución; Cipriano, insigne obispo de Cartago y maestro de la unidad de la Iglesia («No puede tener a Dios por Padre quien no tiene a la Iglesia por Madre»). Ambos mártires.",
      patronage = "Unidad eclesial, Cartago y la reconciliación penitencial",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Cornelio y Cipriano, que con la sangre del martirio sellasteis vuestra fidelidad a la Iglesia, guardad al pueblo cristiano en santa unidad."
    ),
    Pair(9, 17) to SaintTemplate(
      title = "San Roberto Belarmino e Impresión de las Llagas de San Francisco",
      saintName = "San Roberto Belarmino, cardenal y doctor, y Llagas de San Francisco",
      biography = "San Roberto Belarmino, jesuita italiano, maestro de controversias teológicas y catequista de niños. Hoy se conmemora también la milagrosa impresión de los estigmas de Cristo en el cuerpo de San Francisco de Asís en el Monte Alverna en 1224.",
      patronage = "Catequistas, canonistas, teólogos y devotos de los estigmas franciscanos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesucristo, que imprimiste en el cuerpo de San Francisco las llagas de tu Pasión, inflama nuestros corazones en el fuego de tu amor divino."
    ),
    Pair(9, 18) to SaintTemplate(
      title = "San José de Cupertino",
      saintName = "San José de Cupertino, fraile franciscano levitador",
      biography = "Fraile franciscano menor conventual italiano del siglo XVII. De torpe inteligencia natural, experimentaba éxtasis y levitaciones públicas al oír hablar de Dios o de la Virgen María; aprobó milagrosamente sus exámenes sacerdotales.",
      patronage = "Estudiantes en época de exámenes, aviadores, viajeros aéreos y personas con dificultades de aprendizaje",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San José de Cupertino, humilde siervo de Dios y protector de los estudiantes, ilumina la mente de los jóvenes que rinden exámenes y dales paz."
    ),
    Pair(9, 19) to SaintTemplate(
      title = "San Jenaro, obispo y mártir",
      saintName = "San Jenaro, obispo de Benevento y mártir de Nápoles",
      biography = "Obispo degollado bajo Diocleciano en Pozzuoli en el año 305 tras salir ileso del horno ardiente y de las fieras. Su sangre, conservada en una ampolla de cristal en la catedral de Nápoles, se licúa milagrosamente de forma reiterada a lo largo de los siglos.",
      patronage = "Nápoles, donantes de sangre y protección contra erupciones volcánicas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Jenaro mártir, celoso testigo del Salvador del mundo, protege a las familias napolitanas y a todos los que confían en tu intercesión."
    ),
    Pair(9, 20) to SaintTemplate(
      title = "San Andrés Kim Taegon y compañeros",
      saintName = "San Andrés Kim Taegon, San Pablo Chong Hasang y 101 mártires de Corea",
      biography = "Andrés Kim, primer sacerdote nativo coreano, y Pablo Chong, laico insigne. Junto a decenas de laicos casados, ancianos y niños, fueron decapitados o asfixiados en las brutales persecuciones del siglo XIX, haciendo florecer la fe en Corea.",
      patronage = "Corea, sacerdotes nativos, laicos misioneros y clero oriental",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires de Corea, que plantasteis el Evangelio en vuestra patria con la ofrenda de vuestras vidas, bendecid a las familias coreanas con la fe y la paz."
    ),
    Pair(9, 21) to SaintTemplate(
      title = "San Mateo, apóstol y evangelista",
      saintName = "Fiesta de San Mateo, apóstol y evangelista",
      biography = "Publicano cobrador de impuestos en Cafarnaúm llamado Leví. Al escuchar la llamada irresistible de Jesús: «Sígueme», lo dejó todo inmediatamente y organizó un gran banquete para que otros pecadores conocieran al Salvador; autor del primer Evangelio.",
      patronage = "Contables, banqueros, aduaneros, recaudadores de impuestos y agentes fiscales",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Dios de infinita misericordia, que en tu apóstol Mateo elegiste a un pecador para ser evangelista insigne, haz que sepamos acoger tu llamada sin demora."
    ),
    Pair(9, 22) to SaintTemplate(
      title = "San Mauricio y los mártires de la Legión Tebana",
      saintName = "San Mauricio y compañeros de la Legión Tebana, mártires",
      biography = "Comandante de una legión romana reclutada en Egipto enteramente cristiana en el siglo III. En Agauno (Suiza), se negaron rotundamente a sacrificar a los dioses y a masacrar a civiles cristianos, muriendo degollados seis mil soldados fieles a Cristo.",
      patronage = "Soldados, guardias suizos, tintoreros, tejedores y Suiza",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Mauricio y valientes soldados de Cristo, conceded a los militares de hoy rectitud de conciencia para defender la justicia y la paz."
    ),
    Pair(9, 23) to SaintTemplate(
      title = "San Pío de Pietrelcina (Padre Pío)",
      saintName = "San Pío de Pietrelcina, presbítero capuchino estigmatizado",
      biography = "Fraile capuchino italiano del siglo XX que llevó en su cuerpo visiblemente los estigmas de la Pasión de Cristo durante cincuenta años. Confesaba hasta dieciocho horas al día en San Giovanni Rotondo, fundó la Casa Alivio del Sufrimiento y oraba incesantemente el Rosario.",
      patronage = "Confesores, personas en dolor físico, voluntarios de caridad y devotos del Rosario",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pío de Pietrelcina, enamorado de la Cruz y del Rosario, enséñanos a orar, a esperar y a no preocuparnos, confiando ciegamente en la misericordia de Dios."
    ),
    Pair(9, 24) to SaintTemplate(
      title = "Nuestra Señora de la Merced",
      saintName = "Nuestra Señora de la Merced (Virgen de las Mercedes)",
      biography = "En 1218 la Santísima Virgen se apareció a San Pedro Nolasco, San Raimundo de Peñafort y al rey Jaime I de Aragón inspirando la fundación de la Orden de la Merced, consagrada con un cuarto voto a entregarse como rehenes si fuera necesario para liberar cautivos.",
      patronage = "Presos, cautivos, presos de adicciones, Barcelona, Perú y la República Dominicana",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen de la Merced, redentora de cautivos, rompe las cadenas del pecado y de las adicciones que atan nuestras almas y devuelve la libertad a los presos."
    ),
    Pair(9, 25) to SaintTemplate(
      title = "San Cleofás y San Fermín de Pamplona",
      saintName = "San Cleofás, discípulo de Emaús, y San Fermín",
      biography = "Cleofás, uno de los dos discípulos a quienes Jesús resucitado acompañó en el camino de Emaús, ardiendo su corazón al escucharle explicar las Escrituras y reconociéndole al partir el pan. San Fermín, veneradísimo obispo pamplonés.",
      patronage = "Caminantes desanimados, reconocimiento de Cristo en la Eucaristía y Pamplona",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, como a los discípulos de Emaús, acompáñanos en nuestros caminos cansados y quédate con nosotros, porque atardece."
    ),
    Pair(9, 26) to SaintTemplate(
      title = "Santos Cosme y Damián",
      saintName = "Santos Cosme y Damián, médicos y mártires",
      biography = "Hermanos gemelos nacidos en Arabia que ejercieron la medicina en Siria sin cobrar honorarios a nadie («Anárgiros»). Curaban enfermos orando en el Nombre de Jesucristo y fueron decapitados bajo Diocleciano en el año 303.",
      patronage = "Médicos, cirujanos, farmacéuticos, dentistas y gemelos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos médicos Cosme y Damián, que sanasteis los cuerpos para salvar las almas, alcanzad salud y alivio a todos los enfermos que hoy sufren."
    ),
    Pair(9, 27) to SaintTemplate(
      title = "San Vicente de Paúl",
      saintName = "San Vicente de Paúl, presbítero y apóstol universal de la caridad",
      biography = "Sacerdote francés del siglo XVII que consagró su existencia a los galeotes, campesinos pobres y niños expósitos. Fundó la Congregación de la Misión (Paúles) y las Hijas de la Caridad con Santa Luisa de Marillac: «Los pobres son nuestros amos y señores».",
      patronage = "Todas las obras de caridad de la Iglesia, voluntarios sociales y pobres",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Vicente de Paúl, padre de los pobres y maestro de caridad, concédenos amar a nuestros hermanos necesitados no solo con palabras, sino con obras verdaderas."
    ),
    Pair(9, 28) to SaintTemplate(
      title = "San Wenceslao y San Lorenzo Ruiz",
      saintName = "San Wenceslao, duque y mártir de Bohemia, y San Lorenzo Ruiz",
      biography = "San Wenceslao, gobernante piadoso asesinado a traición por su hermano pagano. San Lorenzo Ruiz, laico filipino martirizado en Nagasaki en 1637: «Si tuviera mil vidas, todas las daría gustoso por Cristo».",
      patronage = "Bohemia, Filipinas, laicos misioneros y gobernantes justos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires Wenceslao y Lorenzo Ruiz, que antepusisteis el amor de Dios a vuestras propias vidas, concedednos fidelidad incondicional al Señor."
    ),
    Pair(9, 29) to SaintTemplate(
      title = "Los Santos Arcángeles Miguel, Gabriel y Rafael",
      saintName = "Fiesta de los Santos Arcángeles Miguel, Gabriel y Rafael",
      biography = "San Miguel («¿Quién como Dios?»), príncipe de los ejércitos celestiales y vencedor de Satanás; San Gabriel («Fortaleza de Dios»), embajador supremo de la Encarnación a María; San Rafael («Medicina de Dios»), protector y guía de Tobías.",
      patronage = "Policías, militares, mensajeros, médicos, farmacéuticos, viajeros y enfermos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Miguel, defiéndenos en la batalla. San Gabriel, tráenos buenas noticias de Dios. San Rafael, cura nuestras heridas y guía nuestros pasos por el camino de la paz."
    ),
    Pair(9, 30) to SaintTemplate(
      title = "San Jerónimo",
      saintName = "San Jerónimo, presbítero y doctor de la Iglesia",
      biography = "Tradujo la Sagrada Escritura directamente del hebreo y griego al latín (la célebre Vulgata) durante tres décadas en la cueva de Belén junto a la gruta del Nacimiento. Célebre por su máxima: «Desconocer las Escrituras es desconocer a Cristo».",
      patronage = "Biblistas, traductores, arqueólogos bíblicos, bibliotecarios y estudiantes",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Jerónimo, doctor excelso de la Santa Biblia, concédenos leer, amar y meditar diariamente la Sagrada Escritura para encontrar en ella a Jesucristo."
    )
  )
}
