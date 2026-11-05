package com.example.data.sanctorale

import com.example.data.CatholicCalendarRepository.SaintTemplate
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor

object SanctoraleQ2 {

  val saints: Map<Pair<Int, Int>, SaintTemplate> = mapOf(
    // ==========================================
    // ABRIL (30 días)
    // ==========================================
    Pair(4, 1) to SaintTemplate(
      title = "San Hugo de Grenoble",
      saintName = "San Hugo, obispo de Grenoble",
      biography = "Obispo francés del siglo XI famoso por su santidad austera y su generosidad con los pobres. Donó a San Bruno y sus primeros compañeros el yermo de la Cartuja, fundando así la célebre Orden Cartujana.",
      patronage = "Cartujos, contra las fiebres y protectores de monjes",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Hugo de Grenoble, que amaste el silencio orante y el socorro a los indigentes, enséñanos a buscar la gloria de Dios en todo momento."
    ),
    Pair(4, 2) to SaintTemplate(
      title = "San Francisco de Paula",
      saintName = "San Francisco de Paula, ermitaño y fundador de los Mínimos",
      biography = "Ermitaño calabrés del siglo XV que fundó la Orden de los Mínimos, caracterizada por la perpetua abstinencia cuaresmal y la caridad extrema. Consejero de reyes, obró prodigios asombrosos y pacífico pueblos en guerra.",
      patronage = "Marineros, gente de mar, Calabria y contra la infertilidad",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco de Paula, amante de la santa humildad y de la penitencia cuaresmal, ayúdanos a hacernos pequeños para ser grandes en el Reino de Dios."
    ),
    Pair(4, 3) to SaintTemplate(
      title = "San Ricardo de Chichester",
      saintName = "San Ricardo de Chichester, obispo",
      biography = "Canciller de la Universidad de Oxford y obispo inglés del siglo XIII. Defendió con denuedo los derechos de la Iglesia frente al rey Enrique III y vivió con desprendimiento absoluto repartiendo sus rentas a los hambrientos.",
      patronage = "Cocheros, arrieros y Sussex",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "«Día tras día, Señor misericordioso, concédeme tres cosas: conocerte más claramente, amarte más tiernamente y seguirte más fielmente». Amén."
    ),
    Pair(4, 4) to SaintTemplate(
      title = "San Isidoro de Sevilla",
      saintName = "San Isidoro de Sevilla, obispo y doctor de la Iglesia",
      biography = "Arzobispo de Sevilla en la España visigoda, considerado el sabio más universal de su época. Presidió el IV Concilio de Toledo y compuso las monumentales «Etimologías», enciclopedia del saber antiguo que salvó la cultura para la cristiandad.",
      patronage = "Internet, informáticos, estudiantes y científicos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Isidoro de Sevilla, lumbrera de la Iglesia, ilumina la mente de quienes navegan en el mundo digital para que hallen la Verdad inmutable de Cristo."
    ),
    Pair(4, 5) to SaintTemplate(
      title = "San Vicente Ferrer",
      saintName = "San Vicente Ferrer, presbítero dominico",
      biography = "Dominico valenciano, apóstol itinerante de Europa en el siglo XIV. Dotado del don de lenguas y profecía, predicó incansablemente el Evangelio y el Juicio Final, logrando la conversión de decenas de miles de almas.",
      patronage = "Valencia, constructores, albañiles y oradores sagrados",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Vicente Ferrer, ángel del Apocalipsis y heraldo de penitencia, suscita en nosotros un sincero dolor de los pecados y un deseo ardiente del Cielo."
    ),
    Pair(4, 6) to SaintTemplate(
      title = "San Marcelino de Cartago",
      saintName = "San Marcelino, mártir y amigo de San Agustín",
      biography = "Tribuno romano en Cartago en el siglo V, de gran rectitud y piedad. Gran amigo de San Agustín, quien le dedicó «La Ciudad de Dios». Calumniado por los herejes donatistas, fue decapitado injustamente confesando a Cristo.",
      patronage = "Jueces rectos, funcionarios públicos y amistad cristiana",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Marcelino mártir, que diste ejemplo de honradez en el servicio público, inspira a los gobernantes a obrar con justicia y lealtad a Dios."
    ),
    Pair(4, 7) to SaintTemplate(
      title = "San Juan Bautista de La Salle",
      saintName = "San Juan Bautista de La Salle, presbítero y educador",
      biography = "Sacerdote francés del siglo XVII que renunció a su canonjía para fundar los Hermanos de las Escuelas Cristianas. Revolucionó la pedagogía moderna enseñando en lengua vernácula y ofreciendo escuela gratuita a los niños obreros.",
      patronage = "Educadores católicos, profesores, maestros y escuelas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Bautista de La Salle, patrono de los educadores, concede a los maestros paciencia y amor para formar a la juventud en el conocimiento de Cristo."
    ),
    Pair(4, 8) to SaintTemplate(
      title = "San Dionisio de Corinto",
      saintName = "San Dionisio, obispo de Corinto",
      biography = "Obispo del siglo II elogiado por Eusebio de Cesarea por sus cartas pastorales dirigidas a las iglesias de Roma, Atenas, Lacedemonia y Creta, exhortando a la pureza de vida, la penitencia y la concordia eclesial.",
      patronage = "Comunidades cristianas y correspondencia apostólica",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Dionisio de Corinto, que con tu palabra consolaste a tantas comunidades, alcánzanos una caridad fraterna que supere toda división."
    ),
    Pair(4, 9) to SaintTemplate(
      title = "Santa Casilda de Toledo",
      saintName = "Santa Casilda de Toledo, virgen",
      biography = "Hija del rey moro de Toledo en el siglo XI. Llevaba alimentos a escondidas a los prisioneros cristianos en las mazmorras; sorprendida por su padre, el pan de su cesta se transformó milagrosamente en rosas. Bautizada, vivió como anacoreta en Briviesca.",
      patronage = "Burgos, Toledo, enfermos de hemorragias y prisioneros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Casilda, que con ternura socorriste a los cautivos, alcánzanos generosidad para auxiliar a quienes sufren prisión corporal o espiritual."
    ),
    Pair(4, 10) to SaintTemplate(
      title = "San Fulberto de Chartres",
      saintName = "San Fulberto, obispo de Chartres",
      biography = "Obispo del siglo XI, célebre teólogo y poeta que reconstruyó la catedral de Chartres tras un voraz incendio. Compuso himnos pascuales sublimes y fomentó un tierno amor filial a la Santísima Virgen María.",
      patronage = "Arquitectos de templos, músicos sacros y Chartres",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Fulberto, cantor devoto de la Virgen María, enséñanos a alabar con cantos santos las maravillas que Dios realiza en nuestras vidas."
    ),
    Pair(4, 11) to SaintTemplate(
      title = "San Estanislao de Cracovia",
      saintName = "San Estanislao, obispo y mártir",
      biography = "Obispo de Cracovia y patrono principal de Polonia. Defendió con valentía a su pueblo frente a las tiranías y crueldades del rey Boleslao II. El propio monarca lo asesinó mientras celebraba la Santa Misa en el año 1079.",
      patronage = "Polonia, Cracovia, defensores de los oprimidos y obispos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Estanislao mártir, que no callaste ante la injusticia del poder terrenal, infunde en nuestros pastores valentía para defender la verdad evangélica."
    ),
    Pair(4, 12) to SaintTemplate(
      title = "San José Moscati",
      saintName = "San José Moscati, médico de los pobres",
      biography = "Médico napolitano del siglo XX, catedrático eminente e investigador. Antes de examinar a los enfermos rezaba por ellos, no cobraba a los indigentes y les dejaba dinero para sus medicinas, viendo en cada sufriente a Cristo mismo.",
      patronage = "Médicos, anatomistas, científicos y enfermos incurables",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San José Moscati, médico santo, bendice a los profesionales de la salud para que unan la ciencia con el amor y alivien el dolor de cuerpo y alma."
    ),
    Pair(4, 13) to SaintTemplate(
      title = "San Martín I, papa y mártir",
      saintName = "San Martín I, papa y mártir",
      biography = "Pontífice del siglo VII que convocó el Concilio de Letrán para condenar el monotelismo, defendiendo que Cristo tiene dos voluntades, divina y humana. Capturado por tropas imperiales bizantinas, murió agotado por hambre y malos tratos en Crimea.",
      patronage = "Presos políticos, exiliados y defensores de la ortodoxia",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Dios todopoderoso, que concediste al Papa San Martín no temer las amenazas de los poderosos por salvar la fe, consérvanos firmes en tu verdad."
    ),
    Pair(4, 14) to SaintTemplate(
      title = "San Benito José Labre",
      saintName = "San Benito José Labre, mendigo de Cristo",
      biography = "Joven francés del siglo XVIII que, rechazado por varios monasterios por su frágil salud, asumió la vocación de peregrino mendicante por los santuarios de Europa. Pasaba horas inmóvil en éxtasis ante el Sagrario en Roma.",
      patronage = "Personas sin hogar, mendigos, indigentes y peregrinos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Benito José Labre, enamorado del Santísimo Sacramento en la más absoluta pobreza, haznos descubrir que Dios es nuestro verdadero tesoro."
    ),
    Pair(4, 15) to SaintTemplate(
      title = "San Damián de Molokai",
      saintName = "San Damián de Veuster, presbítero de los leprosos",
      biography = "Misionero de los Sagrados Corazones que se ofreció voluntario para vivir en la isla hawaiana de Molokai, leprosario aislado del mundo. Construyó casas, vendó llagas y les dio dignidad humana y fe hasta contagiarse y morir leproso entre ellos.",
      patronage = "Enfermos de lepra, sida, marginados y misioneros sacrificados",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Damián de Molokai, que te hiciste leproso por amor a tus hermanos marginados, enséñanos a abrazar a los que el mundo rechaza."
    ),
    Pair(4, 16) to SaintTemplate(
      title = "Santa Bernardita Soubirous",
      saintName = "Santa Bernardita Soubirous, virgen (vidente de Lourdes)",
      biography = "Humilde y analfabeta pastora de catorce años a quien la Virgen Inmaculada se apareció en Lourdes. Tras las apariciones ingresó con las Hermanas de Nevers en Francia, viviendo en silenciosa oración y padeciendo asma y tuberculosis con heroico abandono.",
      patronage = "Enfermos corporales, pobres, pastores y Nevers",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Bernardita, que con pureza de corazón viste la belleza de la Virgen María, alcánzanos la gracia de la sencillez y la humildad cristiana."
    ),
    Pair(4, 17) to SaintTemplate(
      title = "San Roberto de Molesme",
      saintName = "San Roberto de Molesme, abad y fundador del Císter",
      biography = "Abad francés del siglo XI que anhelaba volver a la observancia estricta de la Regla de San Benito. Con veintiún monjes marchó a la soledad de Císter en 1098, iniciando la gloriosa reforma cisterciense centrada en la oración y el trabajo manual.",
      patronage = "Reformadores monásticos y amantes de la regla benedictina",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Roberto abad, concédenos renovar sin descanso nuestro fervor espiritual y no acostumbrarnos a la mediocridad en el servicio a Dios."
    ),
    Pair(4, 18) to SaintTemplate(
      title = "San Perfecto de Córdoba",
      saintName = "San Perfecto, presbítero y mártir",
      biography = "Sacerdote cordobés del siglo IX en Al-Ándalus. Interrogado en la calle por musulmanes sobre qué opinaba de Jesucristo y de Mahoma, expuso la fe con prudencia y valentía. Condenado a muerte, murió perdonando a sus ejecutores.",
      patronage = "Córdoba, sacerdotes calumniados y fidelidad al Bautismo",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Perfecto mártir, que con tu nombre sellaste la perfección del amor cristiano en el martirio, concédenos pureza de fe y caridad sincera."
    ),
    Pair(4, 19) to SaintTemplate(
      title = "San Expedito",
      saintName = "San Expedito, comandante y mártir",
      biography = "Comandante de la legión romana de Melitene en Armenia martirizado bajo Diocleciano en el año 303. Al decidir convertirse al cristianismo, el demonio en forma de cuervo le susurró «Cras» (mañana), pero él pisoteó al cuervo diciendo «Hodie» (hoy).",
      patronage = "Causas urgentes, causas que no admiten demora, estudiantes y jóvenes",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Expedito, soldado de Cristo que elegiste el «hoy» de Dios sin posponer la santidad, atiende nuestra súplica en esta necesidad apremiante."
    ),
    Pair(4, 20) to SaintTemplate(
      title = "Santa Inés de Montepulciano",
      saintName = "Santa Inés de Montepulciano, virgen dominica",
      biography = "Mística dominica italiana del siglo XIV. Nombrada superiora a los quince años por su madurez santa, fundó el monasterio de Montepulciano. Destacó por sus visiones de la Virgen y su constante oración por la Iglesia.",
      patronage = "Jóvenes superioras, contemplativas y Montepulciano",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Inés de Montepulciano, que fuiste templo vivo de pureza y adoración, alcánzanos del Señor un corazón humilde y orante."
    ),
    Pair(4, 21) to SaintTemplate(
      title = "San Anselmo de Canterbury",
      saintName = "San Anselmo, obispo y doctor de la Iglesia",
      biography = "Monje de Bec en Normandía y arzobispo de Canterbury. Padre de la teología escolástica («La fe que busca entender»), formuló el célebre argumento ontológico y defendió la libertad de la Iglesia ante los reyes normandos.",
      patronage = "Filósofos cristianos, teólogos y Canterbury",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Anselmo, enséñanos a buscar a Dios con el entendimiento y a amarlo con toda el alma, para que nuestra fe ilumine nuestras obras."
    ),
    Pair(4, 22) to SaintTemplate(
      title = "San Sotero y San Cayo",
      saintName = "Santos Sotero y Cayo, papas y mártires",
      biography = "Papas de los primeros siglos de la Iglesia. San Sotero destacó por su inmensa caridad enviando limosnas a los cristianos desterrados a las minas. San Cayo soportó con fortaleza las persecuciones de Diocleciano.",
      patronage = "Papas, socorro a encarcelados y Roma",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santos pontífices Sotero y Cayo, custodios de la fe en tiempos de tormenta, interceded por la Iglesia universal para que viva unida en el amor."
    ),
    Pair(4, 23) to SaintTemplate(
      title = "San Jorge, mártir",
      saintName = "San Jorge, mártir y soldado de Cristo",
      biography = "Soldado romano en Capadocia o Palestina martirizado bajo Diocleciano por negarse a perseguir a los cristianos. Célebre universalmente por la alegoría de la victoria sobre el dragón, símbolo del triunfo de la fe sobre el pecado y Satanás.",
      patronage = "Soldados, scouts, agricultores, caballeros, Inglaterra y Cataluña",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Jorge, valiente adalid de Cristo, ayúdanos a vencer el dragón del pecado y el desánimo con el escudo de la fe y la espada de la caridad."
    ),
    Pair(4, 24) to SaintTemplate(
      title = "San Fidel de Sigmaringa",
      saintName = "San Fidel de Sigmaringa, presbítero y protomártir de Propaganda Fide",
      biography = "Abogado caritativo («el abogado de los pobres») que ingresó a los Capuchinos. Enviado por la Santa Sede a Suiza para predicar a los calvinistas, fue asesinado por una turba armada tras negarse a renegar de la Eucaristía.",
      patronage = "Abogados, misioneros de la verdad y Capuchinos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Fidel de Sigmaringa, que sellaste con tu sangre el testimonio del catolicismo, alcánzanos una fe íntegra y caritativa con todos los hombres."
    ),
    Pair(4, 25) to SaintTemplate(
      title = "San Marcos, evangelista",
      saintName = "Fiesta de San Marcos, evangelista",
      biography = "Compañero de San Pedro en Roma y de San Pablo en sus viajes misioneros. Escribió el segundo Evangelio recogiendo la predicación directa de Pedro. Según la tradición fundó la Iglesia de Alejandría.",
      patronage = "Evangelistas, notarios, escribas, Venecia y vidrieros",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Dios todopoderoso, que ennobleciste a tu evangelista San Marcos con la gracia de proclamar la Buena Noticia, concédenos vivir según sus santos escritos."
    ),
    Pair(4, 26) to SaintTemplate(
      title = "San Cleto y San Marcelino",
      saintName = "Santos Cleto y Marcelino, papas y mártires",
      biography = "San Cleto (Anacleto), tercer sucesor de San Pedro en Roma, ordenó a los primeros veinticinco sacerdotes de la Urbe. San Marcelino gobernó la Iglesia en la tremenda persecución de Diocleciano sufriendo el martirio por Cristo.",
      patronage = "Roma, la sucesión apostólica y la perseverancia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que edificaste tu Iglesia sobre la sangre generosa de tus santos pastores Cleto y Marcelino, consérvala en paz y unidad perenne."
    ),
    Pair(4, 27) to SaintTemplate(
      title = "Santa Zita de Lucca",
      saintName = "Santa Zita de Lucca, virgen",
      biography = "Criada doméstica en Italia en el siglo XIII durante cuarenta y ocho años. Soportó maltratos iniciales con mansedumbre inaudita, santificando las tareas más humildes de la cocina y repartiendo su comida a los pobres.",
      patronage = "Empleadas de hogar, camareras, sirvientes y llaves perdidas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Zita, que santificaste las labores humildes del hogar con amor constante a Dios, enséñanos a servir con alegría en lo sencillo de cada día."
    ),
    Pair(4, 28) to SaintTemplate(
      title = "San Luis María Grignion de Montfort",
      saintName = "San Luis María Grignion de Montfort, presbítero",
      biography = "Misionero apostólico francés del siglo XVIII y autor del inmortal «Tratado de la verdadera devoción a la Santísima Virgen». Enseñó la consagración total a Jesucristo por medio de las manos purísimas de María (Totus Tuus).",
      patronage = "Misioneros marianos, predicadores populares y consagraciones marianas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Luis María Grignion de Montfort, enséñanos a entregarnos enteramente a Jesús por medio de María para ser santos en la presencia del Señor."
    ),
    Pair(4, 29) to SaintTemplate(
      title = "Santa Catalina de Siena",
      saintName = "Fiesta de Santa Catalina de Siena, virgen y doctora de la Iglesia",
      biography = "Terciaria dominica italiana del siglo XIV, mística estigmatizada y Patrona de Europa. Con valentía profética exhortó al Papa a regresar de Aviñón a Roma. Autora del sublime «Diálogo de la Divina Providencia».",
      patronage = "Patrona de Europa, Italia, enfermeras, bomberos y contra abortos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Catalina de Siena, enamorada ardiente de Cristo crucificado y de la Iglesia, alcánzanos tu amor intrépido por el Santo Padre y la salvación de las almas."
    ),
    Pair(4, 30) to SaintTemplate(
      title = "San Pío V, papa",
      saintName = "San Pío V, papa dominico",
      biography = "Pontífice del siglo XVI que aplicó los decretos del Concilio de Trento. Reformó el clero, publicó el Catecismo Romano, unificó el Misal Romano y convocó a toda la cristiandad a rezar el Rosario por la victoria de Lepanto.",
      patronage = "Dominicos, defensa de la fe y el Misal Romano",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pío V, pastor celoso de la fe y propagador del Santo Rosario, guarda a la Iglesia de toda herejía y alcánzanos fidelidad al magisterio."
    ),

    // ==========================================
    // MAYO (31 días)
    // ==========================================
    Pair(5, 1) to SaintTemplate(
      title = "San José Obrero",
      saintName = "San José Obrero, patrono de los trabajadores",
      biography = "Instituida por Pío XII para cristianizar la fiesta del trabajo. San José, carpintero de Nazaret, dignificó el esfuerzo cotidiano del hombre trabajando al lado del Redentor del mundo, enseñándonos a santificar el trabajo.",
      patronage = "Trabajadores, carpinteros, artesanos, obreros y la justicia social",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San José Obrero, bendice el trabajo de nuestras manos, concede empleo digno a quienes lo buscan y enséñanos a ofrecer nuestras fatigas a Dios."
    ),
    Pair(5, 2) to SaintTemplate(
      title = "San Atanasio de Alejandría",
      saintName = "San Atanasio de Alejandría, obispo y doctor de la Iglesia",
      biography = "«El Campeón de la Ortodoxia». Patriarca de Alejandría que sufrió cinco destierros por defender en Nicea la consustancialidad del Hijo con el Padre («Homoousios») frente a la feroz herejía arriana.",
      patronage = "Teólogos, defensores de la fe trinitaria y Alejandría",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que suscitaste a San Atanasio para defender con invicta fortaleza la divinidad de tu Hijo, fortalece nuestra fe en la Santísima Trinidad."
    ),
    Pair(5, 3) to SaintTemplate(
      title = "Santos Felipe y Santiago",
      saintName = "Fiesta de los Santos Felipe y Santiago el Menor, apóstoles",
      biography = "Felipe, de Betsaida, llevó a Natanael a Jesús («Ven y lo verás») y pidió al Señor en la Última Cena «Muéstranos al Padre». Santiago el Menor, pariente del Señor y primer obispo de Jerusalén, autor de la Epístola de Santiago.",
      patronage = "Sombrereros, pasteleros, Uruguay y los apóstoles",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que nos alegras hoy con la fiesta de tus apóstoles Felipe y Santiago, concédenos contemplar tu rostro y vivir según tus mandamientos."
    ),
    Pair(5, 4) to SaintTemplate(
      title = "San Florián de Lorch",
      saintName = "San Florián, oficial romano y mártir",
      biography = "Comandante del ejército imperial en Austria en el siglo IV. Confesó públicamente su fe cristiana para animar a sus soldados encarcelados; fue atado con una piedra de molino al cuello y arrojado a las aguas del río Enns.",
      patronage = "Bomberos, limpiachimeneas, amparo contra incendios y ahogamientos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Florián mártir, protege a nuestros hogares del fuego destructor y guarda a los bomberos que arriesgan su vida por auxiliar al prójimo."
    ),
    Pair(5, 5) to SaintTemplate(
      title = "San Ángel de Sicilia",
      saintName = "San Ángel de Sicilia, mártir carmelita",
      biography = "Nacido en Jerusalén de padres judíos convertidos. Carmelita en Palestina, marchó a Sicilia a predicar con ardor el Evangelio; fue herido de muerte por denunciar los abusos de un caballero adúltero, expirando mientras lo perdonaba.",
      patronage = "Sicilia, predicadores de conversión y la orden del Carmen",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Ángel de Sicilia, que moriste perdonando a tu asesino a imagen del Señor Jesús, enséñanos a responder con bien ante el mal."
    ),
    Pair(5, 6) to SaintTemplate(
      title = "Santo Domingo Savio",
      saintName = "Santo Domingo Savio, joven discípulo de Don Bosco",
      biography = "Joven italiano fallecido a los catorce años. Alumno predilecto de San Juan Bosco, adoptó como lema de su Primera Comunión: «La muerte antes que pecar». Modelo de santidad alegre en el oratorio salesiano.",
      patronage = "Monaguillos, niños cantores, madres gestantes y jóvenes",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Domingo Savio, que enseñaste que la santidad consiste en estar siempre alegres y cumplir con amor los propios deberes, ayuda a los jóvenes a buscar a Dios."
    ),
    Pair(5, 7) to SaintTemplate(
      title = "Santa Rosa Venerini",
      saintName = "Santa Rosa Venerini, virgen y educadora",
      biography = "Educadora italiana del siglo XVII que abrió las primeras escuelas públicas gratuitas para niñas en Italia, fundando las Maestras Pías Venerini con el lema de educar para salvar.",
      patronage = "Maestras de escuela, educación femenina y maestras pías",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Rosa Venerini, concédenos valorar la educación cristiana como manantial de virtud y dignificación humana para todos los niños."
    ),
    Pair(5, 8) to SaintTemplate(
      title = "Nuestra Señora de Luján",
      saintName = "Nuestra Señora de Luján, patrona de Argentina",
      biography = "En 1630, una carreta que transportaba dos imágenes marianas se detuvo milagrosamente a orillas del río Luján y los bueyes no quisieron avanzar hasta que se bajó la pequeña imagen de la Purísima Concepción, que quedó allí para siempre.",
      patronage = "Argentina, Uruguay, Paraguay y transportistas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen de Luján, Madre de la Patria y Madre nuestra, derrama tu manto maternal sobre todos los pueblos de América Latina y consérvanos en la fe."
    ),
    Pair(5, 9) to SaintTemplate(
      title = "San Pacomio",
      saintName = "San Pacomio, abad y padre del cenobitismo",
      biography = "Soldado egipcio que tras experimentar la caridad de los cristianos se convirtió y bautizó. Es el creador de la vida monástica cenobítica (comunitaria), redactando la primera regla monástica escrita de la cristiandad.",
      patronage = "Vida comunitaria cenobítica y monjes de Oriente y Occidente",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pacomio abad, enséñanos a caminar juntos en fraternidad sincera, corrigiéndonos con paciencia y amándonos con el amor de Cristo."
    ),
    Pair(5, 10) to SaintTemplate(
      title = "San Juan de Ávila",
      saintName = "San Juan de Ávila, presbítero y doctor de la Iglesia",
      biography = "El «Apóstol de Andalucía». Sacerdote diocesano español del siglo XVI, predicador insigne y maestro de santos (guió a San Juan de Dios, Santa Teresa, San Francisco de Borja). Patrono del clero secular español.",
      patronage = "Clero secular español, sacerdotes diocesanos y predicadores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan de Ávila, maestro de sacerdotes, infunde en nuestros presbíteros el amor ardiente a la Eucaristía y la caridad pastoral con los pecadores."
    ),
    Pair(5, 11) to SaintTemplate(
      title = "San Ignacio de Láconi",
      saintName = "San Ignacio de Láconi, religioso capuchino",
      biography = "Fraile capuchino de Cerdeña que durante cuarenta años ejerció como limosnero en Cagliari. Con su rosario en la mano, su humilde sonrisa y sus consejos sabios, pacificó rencores y convirtió a miles de almas.",
      patronage = "Cerdeña, limosneros, mendigos y religiosos legos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ignacio de Láconi, hombre de paz y sonrisa santa, enséñanos a sembrar consuelo y serenidad en medio de los afanes del mundo."
    ),
    Pair(5, 12) to SaintTemplate(
      title = "Santos Nereo, Aquileo y Pancracio",
      saintName = "Santos Nereo, Aquileo y Pancracio, mártires",
      biography = "Nereo y Aquileo, soldados romanos convertidos que renunciaron al ejército para servir al Rey pacífico. San Pancracio, joven mártir de catorce años decapitado en Roma bajo Diocleciano por negarse a rendir culto a los ídolos.",
      patronage = "Pancracio: salud, trabajo y jóvenes; Nereo y Aquileo: soldados pacifistas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Pancracio y santos mártires, interceded ante el Señor para que no nos falte nunca el pan del trabajo ni la salud del alma y del cuerpo."
    ),
    Pair(5, 13) to SaintTemplate(
      title = "Nuestra Señora de Fátima",
      saintName = "Nuestra Señora de Fátima (Aparición en Cova da Iria)",
      biography = "En 1917, la Santísima Virgen se apareció seis veces a Lucía, Francisco y Jacinta en Portugal, pidiendo la oración del Santo Rosario, la consagración a su Inmaculado Corazón y la penitencia por la paz mundial y la conversión de los pecadores.",
      patronage = "Paz mundial, rezadores del Rosario y conversión de los pecadores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Nuestra Señora de Fátima, enséñanos a rezar el Rosario todos los días con fervor para alcanzar la paz de nuestras familias y del mundo entero."
    ),
    Pair(5, 14) to SaintTemplate(
      title = "San Matías, apóstol",
      saintName = "Fiesta de San Matías, apóstol",
      biography = "Discípulo que acompañó a Jesús desde el Bautismo en el Jordán hasta la Ascensión. Elegido por los apóstoles tras la oración comunitaria para ocupar el lugar de Judas Iscariote y ser testigo de la Resurrección del Señor.",
      patronage = "Ingenieros de minas, alcohólicos en recuperación y la perseverancia",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Dios todopoderoso, que agregaste a San Matías al colegio de los apóstoles, concédenos experimentar la dulzura de tu amor redentor."
    ),
    Pair(5, 15) to SaintTemplate(
      title = "San Isidro Labrador",
      saintName = "San Isidro Labrador, esposo y patrono del campo",
      biography = "Campesino madrileño del siglo XII. Esposo de Santa María de la Cabeza, asistía diariamente a la Santa Misa antes de arar la tierra, mientras los ángeles le ayudaban en sus labores. Célebre por su caridad con los pobres y animales.",
      patronage = "Agricultores, campesinos, Madrid e ingenieros agrónomos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Isidro Labrador, que santificaste el surco de la tierra con la oración y el sudor, bendice las cosechas y danos amor a la Santa Misa diaria."
    ),
    Pair(5, 16) to SaintTemplate(
      title = "San Simón Stock",
      saintName = "San Simón Stock, presbítero y general carmelita",
      biography = "Religioso inglés del siglo XIII y Superior General de los Carmelitas. El 16 de julio de 1251 se le apareció la Santísima Virgen entregándole el Santo Escapulario del Carmen con la promesa de protección materna en vida y en la muerte.",
      patronage = "Devotos del Escapulario del Carmen y la orden carmelita",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Simón Stock, que recibiste de María el santo Escapulario, alcánzanos vivir revestidos de las virtudes de nuestra Madre del Cielo."
    ),
    Pair(5, 17) to SaintTemplate(
      title = "San Pascual Bailón",
      saintName = "San Pascual Bailón, religioso franciscano y patrono eucarístico",
      biography = "Humilde pastor aragonés que ingresó como hermano lego franciscano alcantarino. Pasaba noches enteras postrado en éxtasis ante el Sagrario. León XIII lo proclamó Patrono de todas las obras y congresos eucarísticos.",
      patronage = "Congresos eucarísticos, cocineros, pastores y adoradores nocturnos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pascual Bailón, adorador apasionado de Cristo en el Sagrario, enciende en nuestras almas una devoción viva y constante hacia la Eucaristía."
    ),
    Pair(5, 18) to SaintTemplate(
      title = "San Juan I, papa y mártir",
      saintName = "San Juan I, papa y mártir",
      biography = "Pontífice del siglo VI enviado a Constantinopla por el rey arriano Teodorico. A su regreso, el tirano desconfió de él y lo arrojó a una inmunda prisión en Rávena, donde murió exhausto de hambre y privaciones.",
      patronage = "Presos políticos, defensores de la paz y pontífices perseguidos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que premiaste la fidelidad del Papa San Juan con la palma del martirio en prisión, sostén a los que padecen injusticias por tu causa."
    ),
    Pair(5, 19) to SaintTemplate(
      title = "San Ivo de Kermartin",
      saintName = "San Ivo de Kermartin, patrono de los abogados",
      biography = "Sacerdote y juez eclesiástico bretón del siglo XIII. Llamado «el abogado de los pobres», defendía gratuitamente a huérfanos y viudas sin aceptar sobornos, transformando su casa en asilo de mendigos y enfermos.",
      patronage = "Abogados, jueces, juristas, huérfanos y Bretaña",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ivo, que pusiste tu saber jurídico al servicio de la justicia y de los más desvalidos, haz que en nuestros tribunales brille siempre la verdad."
    ),
    Pair(5, 20) to SaintTemplate(
      title = "San Bernardino de Siena",
      saintName = "San Bernardino de Siena, presbítero franciscano",
      biography = "Fraile franciscano y extraordinario predicador popular del siglo XV en Italia. Propagó el monograma IHS del Nombre de Jesús, pacificando ciudades enfrentadas y promoviendo la renovación moral y evangélica.",
      patronage = "Publicistas, comunicadores, anunciantes y contra el juego compulsivo",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Bernardino de Siena, que grabaste el Santo Nombre de Jesús en los corazones, haznos encontrar en Él nuestra salvación y fortaleza."
    ),
    Pair(5, 21) to SaintTemplate(
      title = "San Cristóbal Magallanes y compañeros",
      saintName = "San Cristóbal Magallanes y 24 compañeros mártires de México",
      biography = "Sacerdotes y laicos mexicanos ejecutados durante la persecución cristera al grito de «¡Viva Cristo Rey y Santa María de Guadalupe!». Magallanes perdonó a sus verdugos y regaló sus pertenencias antes de ser fusilado.",
      patronage = "México, sacerdotes perseguidos y la libertad religiosa",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires mexicanos, que disteis la vida con alegría por Cristo Rey, conceded a nuestras naciones fidelidad invicta al Evangelio."
    ),
    Pair(5, 22) to SaintTemplate(
      title = "Santa Rita de Casia",
      saintName = "Santa Rita de Casia, patrona de las causas imposibles",
      biography = "Santa de Umbría del siglo XV. Esposa paciente que convirtió a su esposo violento y perdonó a sus asesinos; viuda y monja agustina estigmatizada con una espina de la corona de Cristo en su frente durante quince años.",
      patronage = "Causas imposibles y desesperadas, matrimonios difíciles y heridas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Rita de Casia, abogada de los casos desesperados e imposibles, presenta al Señor nuestra congoja y alcánzanos la paz del corazón."
    ),
    Pair(5, 23) to SaintTemplate(
      title = "San Juan Bautista de Rossi",
      saintName = "San Juan Bautista de Rossi, presbítero",
      biography = "Sacerdote romano del siglo XVIII que consagró su ministerio a confesar a pastores, mendigos, enfermos y presidiarios. Pasaba horas interminables en el confesionario, siendo el consuelo de los más miserables de Roma.",
      patronage = "Confesores pacientes, necesitados y enfermos crónicos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Bautista de Rossi, heraldo de la infinita misericordia divina en el sacramento de la reconciliación, ruega por los pecadores."
    ),
    Pair(5, 24) to SaintTemplate(
      title = "María Auxiliadora de los Cristianos",
      saintName = "María Auxiliadora de los Cristianos",
      biography = "Advocación mariana que celebra la intercesión poderosa de la Virgen en los momentos más críticos de la historia de la Iglesia (Lepanto, Viena, liberación de Pío VII). San Juan Bosco la nombró patrona de la Familia Salesiana.",
      patronage = "Auxilio en las dificultades, familia salesiana y protección maternal",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«María, auxilio de los cristianos, ruega por nosotros. No nos desampares ni de noche ni de día, guíanos en el camino de la santidad»."
    ),
    Pair(5, 25) to SaintTemplate(
      title = "San Beda el Venerable y San Gregorio VII",
      saintName = "San Beda el Venerable y San Gregorio VII, papa",
      biography = "San Beda, monje benedictino inglés y doctor de la Iglesia, padre de la historia inglesa. San Gregorio VII, pontífice que defendió con heroísmo la libertad de la Iglesia ante el emperador: «Amé la justicia y odié la iniquidad».",
      patronage = "Historiadores, papas reformadores e intelectuales cristianos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que iluminaste a tu Iglesia con la sabiduría de San Beda y la firmeza de San Gregorio VII, concédenos amar la justicia en todo momento."
    ),
    Pair(5, 26) to SaintTemplate(
      title = "San Felipe Neri",
      saintName = "San Felipe Neri, el Apóstol de Roma y el santo de la alegría",
      biography = "Sacerdote florentino del siglo XVI en Roma. Fundó la Congregación del Oratorio; dotado de ardiente caridad (su corazón se dilataba físicamente por el fuego del Espíritu Santo), atrajo a ricos y mendigos con su santa alegría y confesionario.",
      patronage = "Roma, humoristas, educadores alegres y jóvenes del oratorio",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Felipe Neri, santo de la alegría evangélica, disipa nuestras tristezas y enséñanos a servir al Señor con júbilo en el corazón."
    ),
    Pair(5, 27) to SaintTemplate(
      title = "San Agustín de Canterbury",
      saintName = "San Agustín de Canterbury, obispo y apóstol de Inglaterra",
      biography = "Monje benedictino romano enviado por el Papa San Gregorio Magno con cuarenta compañeros para evangelizar a los anglosajones en el año 597. Convirtió al rey Etelberto de Kent y estableció la sede primada de Canterbury.",
      patronage = "Inglaterra, Canterbury y misioneros monásticos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios de infinita bondad, que llevaste a los pueblos de Inglaterra a la luz de Cristo por San Agustín, concede a tu Iglesia renacer en santidad."
    ),
    Pair(5, 28) to SaintTemplate(
      title = "San Germán de París",
      saintName = "San Germán de París, obispo",
      biography = "Obispo de París en el siglo VI llamado «padre de los pobres». Vendió los cálices de plata para rescatar cautivos y vestir a los harapientos; convirtió al rey Childeberto y fundó la abadía de Saint-Germain-des-Prés.",
      patronage = "París, prisioneros de guerra y caridad con mendigos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Germán de París, que no guardaste nada para ti por entregarlo a los pobres, haznos desprendidos y generosos con quienes sufren."
    ),
    Pair(5, 29) to SaintTemplate(
      title = "San Pablo VI, papa",
      saintName = "San Pablo VI, papa del Concilio y del diálogo",
      biography = "Giovanni Battista Montini guio a la Iglesia a través de las sesiones conclusivas del Concilio Vaticano II y de los turbulentos años postconciliares. Promulgó la profética encíclica «Humanae Vitae» y viajó incansable como peregrino de la paz.",
      patronage = "El diálogo ecuménico, la paz internacional y la vida humana naciente",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pablo VI, pastor valeroso que proclamaste la civilización del amor y defendiste la sacralidad de la vida humana, intercede por la Iglesia."
    ),
    Pair(5, 30) to SaintTemplate(
      title = "Santa Juana de Arco y San Fernando",
      saintName = "Santa Juana de Arco, virgen, y San Fernando, rey",
      biography = "Juana de Arco, joven campesina francesa guiada por voces celestiales para liberar a Francia, murió mártir en la hoguera a los diecinueve años mirando a la cruz. San Fernando III, rey santo de Castilla que reconquistó Córdoba y Sevilla con justicia.",
      patronage = "Juana: soldados, Francia y cautivos; Fernando: gobernantes y España",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Juana de Arco y San Fernando rey, conceded valor a los gobernantes para actuar siempre con pureza de intención y temor santo de Dios."
    ),
    Pair(5, 31) to SaintTemplate(
      title = "La Visitación de la Virgen María",
      saintName = "Fiesta de la Visitación de la Santísima Virgen María a Santa Isabel",
      biography = "María, llevando en su seno al Verbo Encarnado, viaja presurosa a las montañas de Judea para servir a su prima Isabel. Al escuchar su saludo, San Juan Bautista salta de gozo en el vientre materno y María entona el sublime himno del Magníficat.",
      patronage = "Misioneros de la caridad, madres gestantes y apostolado solícito",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Proclama mi alma la grandeza del Señor y se alegra mi espíritu en Dios, mi Salvador». Santa María de la Visitación, enséñanos a servir con prisa y alegría."
    ),

    // ==========================================
    // JUNIO (30 días)
    // ==========================================
    Pair(6, 1) to SaintTemplate(
      title = "San Justino, mártir",
      saintName = "San Justino, filósofo y mártir",
      biography = "Filósofo pagano nacido en Samaria que buscó incansablemente la verdad en las diversas escuelas filosóficas hasta encontrar a Cristo. Abrió en Roma la primera escuela de filosofía cristiana y fue decapitado en el año 165.",
      patronage = "Filósofos, conversos intelectuales y apologistas católicos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Dios de la verdad, que concediste a San Justino descubrir la sabiduría sublime de la Cruz, concédenos dar razón de nuestra esperanza con rectitud."
    ),
    Pair(6, 2) to SaintTemplate(
      title = "Santos Marcelino y Pedro",
      saintName = "Santos Marcelino, presbítero, y Pedro, exorcista, mártires",
      biography = "Clérigos romanos martirizados bajo Diocleciano en el año 304. En prisión convirtieron al carcelero y a su familia entera; fueron llevados a un bosque espeso para ser decapitados en secreto, convirtiéndose su tumba en centro de veneración.",
      patronage = "Roma, exorcistas y perseverancia en el martirio",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Marcelino y Pedro, que aún entre cadenas sembrasteis la semilla de la fe, libradnos de las acechanzas del maligno con vuestra intercesión."
    ),
    Pair(6, 3) to SaintTemplate(
      title = "San Carlos Lwanga y compañeros",
      saintName = "San Carlos Lwanga y compañeros mártires de Uganda",
      biography = "Veintidós jóvenes católicos cortesanos del rey Mwanga de Uganda. Prefirieron ser quemados vivos en Namugongo en 1886 antes que acceder a los requerimientos impuros del monarca o renunciar al bautismo.",
      patronage = "Juventud africana, pureza, scouts y la Acción Católica de África",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Carlos Lwanga y compañeros mártires, custodios invictos de la castidad y de la fe, bendecid a la juventud del mundo con valentía evangélica."
    ),
    Pair(6, 4) to SaintTemplate(
      title = "San Francisco Caracciolo",
      saintName = "San Francisco Caracciolo, presbítero y cofundador",
      biography = "Noble napolitano del siglo XVI que curado de lepra se consagró a Dios fundando los Clérigos Regulares Menores (Caracciolinos), caracterizados por la adoración perpetua al Santísimo Sacramento y el servicio a los galeotes.",
      patronage = "Cocineros italianos, adoradores del Santísimo y Nápoles",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco Caracciolo, apasionado amante de la Eucaristía, haz que nuestra vida sea un acto continuo de adoración y entrega al prójimo."
    ),
    Pair(6, 5) to SaintTemplate(
      title = "San Bonifacio",
      saintName = "San Bonifacio, obispo y mártir, apóstol de Alemania",
      biography = "Monje benedictino inglés que evangelizó los pueblos germánicos en el siglo VIII con mandato del Papa. Derribó el sagrado roble de Thor en Geismar sin que los dioses paganos lo tocaran; fue martirizado en Frisia.",
      patronage = "Alemania, cerveceros, leñadores y misioneros del norte",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Bonifacio, obispo y mártir, que con celo incansable plantaste la Cruz en tierras paganas, reaviva la fe en todos los pueblos de Europa."
    ),
    Pair(6, 6) to SaintTemplate(
      title = "San Norberto de Xanten",
      saintName = "San Norberto, obispo y fundador de los Premonstratenses",
      biography = "Noble canónigo alemán que tras sobrevivir a un rayo se convirtió a la vida de penitencia. Fundó en Prémontré la Orden Premonstratense (Norbertinos) uniendo la vida claustral con la predicación eucarística, siendo luego arzobispo de Magdeburgo.",
      patronage = "Adoración eucarística, mujeres embarazadas y Magdeburgo",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Norberto, apóstol infatigable de la Eucaristía y de la reconciliación, alcánzanos una fe ardiente en la presencia real de Cristo en el altar."
    ),
    Pair(6, 7) to SaintTemplate(
      title = "San Antonio María Gianelli",
      saintName = "San Antonio María Gianelli, obispo",
      biography = "Obispo de Bobbio en el siglo XIX. Celosísimo pastor, fundó las Hijas de María Santísima del Huerto para la atención de huérfanos y enfermos, y los Misioneros de San Alfonso, predicando con sencillez popular arrolladora.",
      patronage = "Educadores, enfermos de cólera y Chiàvari",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Antonio María Gianelli, que no diste descanso a tu celo pastoral por salvar a las almas, concede a tu Iglesia pastores según el Corazón de Jesús."
    ),
    Pair(6, 8) to SaintTemplate(
      title = "San Medardo de Noyon",
      saintName = "San Medardo, obispo de Noyon",
      biography = "Obispo galorromano del siglo VI célebre por su bondad paternal: regaló su caballo a un pobre que caminaba exhausto y perdonaba a los ladrones que intentaban robar en su huerto, coronando cada año a la doncella más virtuosa con una rosa.",
      patronage = "Campesinos, viñadores, amparo contra lluvias dañinas y Noyon",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Medardo, hombre de corazón manso y compasivo, ayúdanos a desterrar todo rencor y a pagar el mal con bendición y generosidad."
    ),
    Pair(6, 9) to SaintTemplate(
      title = "San Efrén de Siria",
      saintName = "San Efrén de Siria, diácono y doctor de la Iglesia",
      biography = "«El Arpa del Espíritu Santo». Diácono de Nísibis y Edesa en el siglo IV. Compuso himnos poéticos conmovedores para defender la fe y cantar las glorias de la Virgen María y de la Eucaristía, muriendo contagiado cuidando apestados.",
      patronage = "Poetas espirituales, himnógrafos y la Iglesia oriental",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Efrén, que con tus versos santos ensalzaste la pureza de la Madre de Dios, inspira en nuestras almas una oración de humilde adoración."
    ),
    Pair(6, 10) to SaintTemplate(
      title = "Santa Margarita de Escocia",
      saintName = "Santa Margarita, reina de Escocia",
      biography = "Princesa anglosajona refugiada en Escocia que contrajo matrimonio con el rey Malcolm III. Madre de ocho hijos santos, reformó la corte, asistió personalmente a los pobres y leprosos y renovó la vida eclesial escocesa.",
      patronage = "Escocia, reinas, familias cristianas y huérfanos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Margarita de Escocia, que transformaste tu palacio real en escuela de piedad y caridad fraterna, bendice a nuestros hogares cristianos."
    ),
    Pair(6, 11) to SaintTemplate(
      title = "San Bernabé, apóstol",
      saintName = "Fiesta de San Bernabé, apóstol",
      biography = "Levita chipriota llamado «hijo de la consolación». Vendió su campo para entregar el dinero a los apóstoles. Introdujo a San Pablo en la comunidad de Jerusalén y lo acompañó en su primer viaje misionero; murió mártir en Chipre.",
      patronage = "Chipre, pacificadores, consejeros y reconciliadores",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que llenaste a San Bernabé de fe y del Espíritu Santo para consolar a los hermanos, haznos testigos generosos de tu Evangelio."
    ),
    Pair(6, 12) to SaintTemplate(
      title = "San Onofre ermitaño",
      saintName = "San Onofre de Egipto, ermitaño",
      biography = "Eremita del siglo IV que vivió durante sesenta años en la más absoluta soledad del desierto egipcio de la Tebaida, cubierto únicamente por su barba y cabellos y alimentado por los frutos de una palmera y la comunión dominical angélica.",
      patronage = "Personas sin vivienda, tejedores, empleo y causas difíciles",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Onofre ermitaño, que encontraste en la soledad de Dios la mayor riqueza, enséñanos a confiar plenamente en la Providencia del Padre del Cielo."
    ),
    Pair(6, 13) to SaintTemplate(
      title = "San Antonio de Padua",
      saintName = "San Antonio de Padua, presbítero y doctor de la Iglesia",
      biography = "Fraile franciscano nacido en Lisboa, insigne predicador y taumaturgo universal. Llamado «Arca del Testamento» por el Papa Gregorio IX por su conocimiento bíblico prodigioso; venerado por sus incontables milagros y caridad con los pobres.",
      patronage = "Objetos perdidos, pobres (Pan de San Antonio), novios, viajeros y Portugal",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Glorioso San Antonio de Padua, dulce protector de los afligidos, alcánzanos del Niño Jesús la gracia que hoy te pedimos y el perdón de nuestras culpas."
    ),
    Pair(6, 14) to SaintTemplate(
      title = "San Eliseo profeta",
      saintName = "San Eliseo, profeta de Israel",
      biography = "Discípulo y sucesor del gran profeta Elías, de quien recibió una doble porción de su espíritu profético. Obró numerosos milagros en favor de los pobres, curó al leproso Naamán y proclamó la fidelidad al Dios vivo.",
      patronage = "Orden Carmelita, profetas y fidelidad a la vocación",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios de nuestros padres, que concediste a San Eliseo continuar con celo santo la misión profética, danos valentía para vivir conforme a tu Palabra."
    ),
    Pair(6, 15) to SaintTemplate(
      title = "Santa María Micaela del Santísimo Sacramento",
      saintName = "Santa María Micaela, vizcondesa y fundadora",
      biography = "Noble española del siglo XIX que abandonó los salones aristocráticos para fundar las Adoratrices Esclavas del Santísimo Sacramento, consagrándose a rescatar y rehabilitar a mujeres víctimas de la prostitución y la marginación.",
      patronage = "Mujeres rescatadas de la explotación, adoratrices y Madrid",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa María Micaela, enamorada de Jesús Sacramentado y defensora de las mujeres vulnerables, danos compasión para socorrer a quienes sufren explotación."
    ),
    Pair(6, 16) to SaintTemplate(
      title = "San Juan Francisco Régis",
      saintName = "San Juan Francisco Régis, presbítero jesuita",
      biography = "Misionero jesuita francés del siglo XVII que recorrió a pie las abruptas montañas del Velay en pleno invierno para confesar, alimentar hambrientos y acoger a jóvenes en peligro moral; murió exhausto en su misión de Lalouvesc.",
      patronage = "Misioneros rurales, confesores y personas sin hogar",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Francisco Régis, apóstol incansable de los senderos más duros, despierta en nosotros el deseo ardiente de acercar las almas al perdón de Dios."
    ),
    Pair(6, 17) to SaintTemplate(
      title = "San Alberto Chmielowski",
      saintName = "San Alberto Chmielowski (Hermano Alberto), apóstol de los mendigos",
      biography = "Pintor polaco célebre y veterano de guerra lisiado. Conmovido por la miseria de los vagabundos de Cracovia, abandonó el arte para fundar los Hermanos de la Tercera Orden de San Francisco (Albertinos), viviendo en los asilos nocturnos.",
      patronage = "Pintores, artistas, mendigos, Cracovia y albergues sociales",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Alberto Chmielowski, que nos enseñaste que «hay que ser buenos como el pan que se deja comer por todos», haznos servidores humildes de los pobres."
    ),
    Pair(6, 18) to SaintTemplate(
      title = "San Gregorio Barbarigo",
      saintName = "San Gregorio Barbarigo, obispo y cardenal",
      biography = "Obispo de Bérgamo y Padua en el siglo XVII. Aplicó rigurosamente la reforma de Trento, fundó un seminario modelo dotado de imprenta políglota para biblias e investigó personalmente las necesidades materiales de cada familia.",
      patronage = "Seminarios, catequesis popular y Padua",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Gregorio Barbarigo, pastor modelo de desvelo por la formación del clero, bendice a nuestros seminaristas y dales ciencia santa y caridad."
    ),
    Pair(6, 19) to SaintTemplate(
      title = "San Romualdo, abad",
      saintName = "San Romualdo, abad y fundador de los Camaldulenses",
      biography = "Noble de Rávena del siglo X que tras ver a su padre matar a un rival en un duelo abrazó la penitencia monástica. Fundó la Orden de los Eremitas Camaldulenses uniendo el eremitismo con la vida comunitaria benedictina.",
      patronage = "Eremitas, monjes de clausura y pacificadores de rencores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Romualdo, que en la celda solitaria hallaste el paraíso de la comunión con Dios, enséñanos a amar el silencio y la oración íntima."
    ),
    Pair(6, 20) to SaintTemplate(
      title = "San Silverio, papa y mártir",
      saintName = "San Silverio, papa y mártir",
      biography = "Pontífice del siglo VI desterrado injustamente a la isla desierta de Palmarola por negarse a rehabilitar a herejes monofisitas ante la presión de la emperatriz Teodora de Bizancio, muriendo de hambre por defender la fe católica.",
      patronage = "Isla de Ponza, presos injustos y fidelidad pontificia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Silverio, mártir de la independencia espiritual de la Iglesia de Dios, fortalece a todos los cristianos que sufren destierro o presiones políticas."
    ),
    Pair(6, 21) to SaintTemplate(
      title = "San Luis Gonzaga",
      saintName = "San Luis Gonzaga, religioso jesuita y patrono de la juventud",
      biography = "Heredero del marquesado de Castiglione que renunció a títulos, palacios y herencia para ingresar en la Compañía de Jesús. Murió a los veintitrés años en Roma contagiado de peste tras cargar sobre sus hombros a los apestados moribundos.",
      patronage = "Juventud cristiana, estudiantes, enfermos de sida y pureza de vida",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Luis Gonzaga, lirio de pureza y mártir de la caridad fraterna, preserva a los jóvenes de las trampas del pecado y enséñales a servir a los enfermos."
    ),
    Pair(6, 22) to SaintTemplate(
      title = "Santos Tomás Moro y Juan Fisher",
      saintName = "Santos Tomás Moro y Juan Fisher, mártires",
      biography = "San Juan Fisher, cardenal y obispo de Rochester. Santo Tomás Moro, Gran Canciller de Inglaterra, humanista y padre ejemplar. Ambos fueron decapitados por orden de Enrique VIII en 1535 por negarse a jurar contra la supremacía papal.",
      patronage = "Gobernantes, políticos, juristas, abogados y la libertad de conciencia",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santo Tomás Moro y San Juan Fisher, mártires de la recta conciencia, defended a los cristianos de la corrupción moral y dad valentía a nuestros líderes."
    ),
    Pair(6, 23) to SaintTemplate(
      title = "San José Cafasso",
      saintName = "San José Cafasso, sacerdote de los ahorcados",
      biography = "Sacerdote piamontés jorobado del siglo XIX y maestro espiritual de San Juan Bosco. Formador de sacerdotes y apóstol de las prisiones de Turín: acompañó al cadalso a más de sesenta condenados a muerte logrando la conversión de todos.",
      patronage = "Prisiones, encarcelados, capellanes de prisiones y condenados a muerte",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San José Cafasso, ministro de la misericordia divina ante el dolor humano, derrama tu consuelo sobre quienes purgan penas en las cárceles."
    ),
    Pair(6, 24) to SaintTemplate(
      title = "Natividad de San Juan Bautista",
      saintName = "Solemnidad de la Natividad de San Juan Bautista",
      biography = "Nacimiento milagroso del Precursor del Señor, hijo de los ancianos Zacarías e Isabel. Voz que clama en el desierto preparando los caminos de Cristo: «Es necesario que Él crezca y que yo disminuya».",
      patronage = "Bautismo, conversiones, sastres, curtidores y el Reino de Dios",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "San Juan Bautista, que desde el vientre materno reconociste al Redentor, ayúdanos a allanar los senderos de nuestra vida para acoger a Jesucristo."
    ),
    Pair(6, 25) to SaintTemplate(
      title = "San Guillermo de Vercelli",
      saintName = "San Guillermo de Montevérgine, abad",
      biography = "Peregrino a Compostela y ermitaño en los montes de Italia del siglo XII. Amansó milagrosamente a un lobo que había devorado a su asno y fundó el célebre monasterio mariano de Montevérgine.",
      patronage = "Irpinia, amansadores de fieras y peregrinos solitarios",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Guillermo abad, que encontraste paz santa en la cumbre de la montaña, eleva nuestros pensamientos terrenales hacia las cosas eternas del Cielo."
    ),
    Pair(6, 26) to SaintTemplate(
      title = "San Josemaría Escrivá",
      saintName = "San Josemaría Escrivá de Balaguer, presbítero y fundador",
      biography = "Sacerdote español del siglo XX que fundó el Opus Dei, proclamando la llamada universal a la santidad a través del trabajo profesional ordinario y de los deberes cotidianos del cristiano.",
      patronage = "Santificación del trabajo ordinario, laicos y diabéticos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Josemaría Escrivá, enséñanos a convertir el trabajo de cada día en oración continua, servicio al prójimo y camino real de santidad."
    ),
    Pair(6, 27) to SaintTemplate(
      title = "San Cirilo de Alejandría y Ntra. Sra. del Perpetuo Socorro",
      saintName = "San Cirilo de Alejandría, doctor de la Iglesia, y Ntra. Sra. del Perpetuo Socorro",
      biography = "San Cirilo presidió el Concilio de Éfeso (431) proclamando a María Madre de Dios (Theotokos) contra Nestorio. Hoy se venera también el célebre icono bizantino de Nuestra Señora del Perpetuo Socorro.",
      patronage = "Defensores del dogma mariano, socorro maternal en tribulaciones",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Madre del Perpetuo Socorro, acude en nuestro auxilio en toda necesidad. San Cirilo, custodia nuestra fe en el misterio de la Encarnación."
    ),
    Pair(6, 28) to SaintTemplate(
      title = "San Ireneo de Lyon",
      saintName = "San Ireneo de Lyon, obispo, mártir y doctor de la Unidad",
      biography = "Discípulo de San Policarpo (oyente del apóstol San Juan) y segundo obispo de Lyon. Escribió «Contra las Herejías», defendiendo la verdad revelada y la comunión con la Sede de Roma. Proclamado Doctor de la Unidad por el Papa Francisco.",
      patronage = "Unidad de los cristianos, teólogos y obispos mártires",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Ireneo de Lyon, que proclamaste que «la gloria de Dios es el hombre viviente», consérvanos en la unidad y en la pureza de la fe apostólica."
    ),
    Pair(6, 29) to SaintTemplate(
      title = "Santos Pedro y Pablo",
      saintName = "Solemnidad de los Santos Pedro y Pablo, apóstoles y columnas de la Iglesia",
      biography = "Pedro, Príncipe de los Apóstoles y primera Cabeza visible de la Iglesia crucificado boca abajo en el Vaticano; Pablo, Apóstol de los Gentiles decapitado en las Tres Fuentes. Ambos sellaron con su sangre el cimiento de la Iglesia en Roma.",
      patronage = "La Santa Iglesia Católica, Roma, el Papa, pescadores y misioneros",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.ROJO,
      isHolyDay = true,
      prayer = "Señor, que consagraste este día con el martirio de tus bienaventurados apóstoles Pedro y Pablo, concede a tu Iglesia seguir siempre sus enseñanzas."
    ),
    Pair(6, 30) to SaintTemplate(
      title = "Primeros Santos Mártires de Roma",
      saintName = "Los Primeros Santos Mártires de la Santa Iglesia Romana",
      biography = "Inmensa multitud de cristianos acusados falsamente por el tirano Nerón de haber incendiado Roma en el año 64. Cubiertos con pieles de fieras o transformados en teas vivientes para alumbrar los jardines imperiales, no renegaron de Cristo.",
      patronage = "Roma, víctimas de tiranías políticas y perseguidos de la fe",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires de Roma, que fecundasteis con vuestra sangre los albores de la Iglesia, alcanzadnos fidelidad invicta ante las persecuciones del mundo."
    )
  )
}
