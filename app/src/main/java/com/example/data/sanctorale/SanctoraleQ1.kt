package com.example.data.sanctorale

import com.example.data.CatholicCalendarRepository.SaintTemplate
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor

object SanctoraleQ1 {

  val saints: Map<Pair<Int, Int>, SaintTemplate> = mapOf(
    // ==========================================
    // ENERO (31 días)
    // ==========================================
    Pair(1, 1) to SaintTemplate(
      title = "Santa María, Madre de Dios",
      saintName = "Solemnidad de Santa María, Madre de Dios",
      biography = "Celebramos el dogma fundamental de la divina maternidad de María (Theotokos), proclamado solemnemente en el Concilio de Éfeso en el año 431. María es verdaderamente Madre del Verbo Encarnado y Madre espiritual de todos los redimidos.",
      patronage = "Madre de la Iglesia, Reina de la Paz y de la Humanidad",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Santa María, Madre de Dios y Madre nuestra, encomendamos a tu corazón inmaculado el inicio de este nuevo año. Guía nuestros pasos en la fe y alcánzanos la paz."
    ),
    Pair(1, 2) to SaintTemplate(
      title = "Santos Basilio Magno y Gregorio Nacianceno",
      saintName = "Santos Basilio Magno y Gregorio Nacianceno, obispos y doctores",
      biography = "Grandes padres capadocios de la Iglesia oriental del siglo IV. Amigos entrañables que consagraron su genio teológico a defender la divinidad del Espíritu Santo y la verdad trinitaria contra el arrianismo.",
      patronage = "Teólogos, maestros de la fe y sana amistad cristiana",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, ilumina tu Iglesia con las enseñanzas de San Basilio y San Gregorio para que amemos con ardor la verdad del Evangelio y vivamos en santa concordia."
    ),
    Pair(1, 3) to SaintTemplate(
      title = "Santísimo Nombre de Jesús",
      saintName = "Memoria del Santísimo Nombre de Jesús",
      biography = "Honramos el Nombre santísimo ante el cual toda rodilla se dobla en el cielo, en la tierra y en el abismo. Nombre revelado por el Ángel Gabriel que significa «Dios salva». San Bernardino de Siena y San Juan de Capistrano extendieron su devoción.",
      patronage = "Salvación de los pecadores y auxilio en las tentaciones",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "¡Oh dulcísimo Jesús!, que tu santo Nombre sea siempre la luz de mi entendimiento, el gozo de mi corazón y mi fortaleza en toda adversidad."
    ),
    Pair(1, 4) to SaintTemplate(
      title = "Santa Isabel Ana Bayley Seton",
      saintName = "Santa Isabel Ana Seton, religiosa",
      biography = "Primera santa nacida en Estados Unidos. Esposa, madre viuda y conversa al catolicismo, fundó las Hermanas de la Caridad de San José y sentó las bases del sistema educativo católico parroquial.",
      patronage = "Educadores, viudas, conversos y escuelas católicas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Dios, que inspiraste a Santa Isabel Ana Seton el amor a la Eucaristía y la entrega generosa a la enseñanza cristiana, concédenos servirte con fidelidad."
    ),
    Pair(1, 5) to SaintTemplate(
      title = "San Juan Nepomuceno Neumann",
      saintName = "San Juan Nepomuceno Neumann, obispo",
      biography = "Misionero redentorista nacido en Bohemia y cuarto obispo de Filadelfia. Hombre de penitencia incansable, organizó la primera red escolar diocesana e introdujo las Cuarenta Horas de adoración eucarística.",
      patronage = "Inmigrantes, niños de catequesis y sacerdotes diocesanos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que llenaste a San Juan Neumann de celo apostólico por las almas, ayúdanos a anunciar tu Evangelio a los más necesitados."
    ),
    Pair(1, 6) to SaintTemplate(
      title = "La Epifanía del Señor",
      saintName = "Solemnidad de la Epifanía del Señor (Los Santos Reyes Magos)",
      biography = "Manifestación gloriosa de Jesucristo como Salvador de todas las naciones, simbolizada en la adoración de los sabios de Oriente que le ofrecieron oro como Rey, incienso como Dios y mirra como hombre redentor.",
      patronage = "Universalidad de la Iglesia, misiones y peregrinos de la fe",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Jesús, que te manifestaste a los pueblos de la tierra, concédenos contemplar tu gloria y adorarte con humildad de corazón ofreciéndote la pureza de nuestra vida."
    ),
    Pair(1, 7) to SaintTemplate(
      title = "San Raimundo de Peñafort",
      saintName = "San Raimundo de Peñafort, presbítero",
      biography = "Dominico catalán, maestro de derecho canónico y confesor de reyes y papas. Recopiló las Decretales de Gregorio IX y alentó a Santo Tomás de Aquino a redactar la Suma contra los Gentiles.",
      patronage = "Abogados, canonistas, juristas y confesores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios de infinita justicia y misericordia, que hiciste a San Raimundo insigne maestro de caridad y verdad, concédenos obrar siempre con rectitud."
    ),
    Pair(1, 8) to SaintTemplate(
      title = "San Severino de Nórico",
      saintName = "San Severino, presbítero y apóstol de Nórico",
      biography = "Monje y ermitaño del siglo V que evangelizó la provincia romana de Nórico (actual Austria). Protegió a los pobladores de las invasiones bárbaras, fundó monasterios y rescató incontables cautivos.",
      patronage = "Refugiados, cautivos, socorro en catástrofes y Austria",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que sostuviste a San Severino en medio de la tribulación de su pueblo, fortalece nuestra esperanza en los momentos de prueba."
    ),
    Pair(1, 9) to SaintTemplate(
      title = "Santa Eulalia de Barcelona",
      saintName = "Santa Eulalia de Barcelona, virgen y mártir",
      biography = "Joven de trece años que confesó con valentía inquebrantable su fe en Cristo durante las persecuciones de Diocleciano. Soportó trece crueles tormentos antes de entregar su alma en la cruz en forma de aspa.",
      patronage = "Ciudad de Barcelona, navegantes y jóvenes cristianas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Eulalia, que con candor y fortaleza diste testimonio del Señor hasta el martirio, alcánzanos una fe viva que no tema las dificultades del mundo."
    ),
    Pair(1, 10) to SaintTemplate(
      title = "San Gregorio de Nisa",
      saintName = "San Gregorio de Nisa, obispo y padre de la Iglesia",
      biography = "Hermano menor de San Basilio Magno y teólogo de profunda elevación mística. Escribió sobre la ascensión del alma hacia Dios y defendió la ortodoxia en el Concilio de Constantinopla I.",
      patronage = "Buscadores de la contemplación, místicos y filósofos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios Padre, que concediste a San Gregorio penetrar en las profundidades de tu misterio, atráenos hacia la contemplación de tu gloria infinita."
    ),
    Pair(1, 11) to SaintTemplate(
      title = "San Teodosio Cenobiarca",
      saintName = "San Teodosio Cenobiarca, abad",
      biography = "Monje palestino del siglo V que organizó la vida en comunidad de miles de eremitas cerca de Belén. Fundó hospitales para ancianos, enfermos y pobres, viviendo en rigurosa pobreza y oración continua.",
      patronage = "Vida comunitaria, hospitales de caridad y ancianos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesucristo, enséñanos a vivir en fraternidad y servicio silencioso a los más débiles, a ejemplo de San Teodosio."
    ),
    Pair(1, 12) to SaintTemplate(
      title = "San Antonio María Pucci",
      saintName = "San Antonio María Pucci, presbítero siervo de María",
      biography = "Párroco infatigable de Viareggio durante casi medio siglo. Dedicó su sacerdocio a confesar, asistir a los huérfanos y cuidar con heroica caridad a los enfermos de cólera sin temer el contagio.",
      patronage = "Párrocos celosos, obras de misericordia y enfermos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Antonio María Pucci, alcánzanos el amor a la Virgen María y la caridad solícita para atender a quienes sufren soledad y abandono."
    ),
    Pair(1, 13) to SaintTemplate(
      title = "San Hilario de Poitiers",
      saintName = "San Hilario de Poitiers, obispo y doctor de la Iglesia",
      biography = "Llamado «el Atanasio de Occidente». Defendió con ardor y sabiduría la divinidad de Jesucristo frente al emperador y los arrianos. Desterrado a Oriente, escribió su célebre tratado sobre la Trinidad.",
      patronage = "Teólogos, defensores de la fe y contra las picaduras de serpiente",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, concédenos confesar con fidelidad inmutable la divinidad de tu Hijo amado, tal como la enseñó tu santo obispo Hilario."
    ),
    Pair(1, 14) to SaintTemplate(
      title = "San Félix de Nola",
      saintName = "San Félix de Nola, presbítero y confesor de la fe",
      biography = "Sacerdote del sur de Italia en el siglo III que sufrió prisión y tormentos por confesar a Cristo. Liberado milagrosamente, distribuyó sus bienes entre los pobres y fue admirado por San Paulino de Nola.",
      patronage = "Campesinos, inocentes acusados falsamente y animales domésticos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Félix de Nola, que encontraste en la pobreza evangélica tu mayor riqueza, ayúdanos a desprendernos de lo terrenal para amar a Dios."
    ),
    Pair(1, 15) to SaintTemplate(
      title = "San Pablo el Primer Ermitaño",
      saintName = "San Pablo de Tebas, primer eremita",
      biography = "Retirado en el desierto egipcio durante la persecución de Decio, vivió casi un siglo en rigurosa soledad, alimentado milagrosamente por un cuervo que le llevaba pan. Fue visitado antes de morir por San Antonio Abad.",
      patronage = "Eremitas, vida contemplativa y tejedores de esteras",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que enseñaste a San Pablo a encontrar tu dulce compañía en el silencio del desierto, regálanos momentos de recogimiento interior para escucharte."
    ),
    Pair(1, 16) to SaintTemplate(
      title = "San Marcelo I, papa y mártir",
      saintName = "San Marcelo I, papa y mártir",
      biography = "Pontífice durante las sangrientas persecuciones romanas. Reorganizó las parroquias romanas y exigió penitencia canónica a los apóstatas (lapsi). Fue desterrado y obligado a servir como esclavo en las caballerizas imperiales.",
      patronage = "Cuidadores de caballos, firmeza en la disciplina de la Iglesia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que coronaste a San Marcelo con el martirio de la fidelidad a tu rebaño, guarda a tu Santa Iglesia en la verdad y en la caridad."
    ),
    Pair(1, 17) to SaintTemplate(
      title = "San Antonio Abad",
      saintName = "San Antonio Abad, abad y padre de los monjes",
      biography = "Padre del monaquismo cristiano. Al escuchar en la iglesia «Si quieres ser perfecto, ve, vende lo que tienes y dalo a los pobres», se retiró al desierto de Egipto. Superó atroces tentaciones del demonio con oración y ayuno.",
      patronage = "Animales domésticos, agricultores, ermitaños y cesteros",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que concediste a San Antonio la victoria sobre las trampas del enemigo mediante la oración perseverante, purifica nuestro corazón."
    ),
    Pair(1, 18) to SaintTemplate(
      title = "Santa Prisca, virgen y mártir",
      saintName = "Santa Prisca, virgen y mártir romana",
      biography = "Joven romana del siglo I bautizada según la tradición por San Pedro Apóstol. Arrojada a los leones en el anfiteatro, las fieras se postraron a sus pies; fue finalmente decapitada proclamando su amor por Cristo.",
      patronage = "Jóvenes, fidelidad en el bautismo y pureza",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Prisca, que diste tu tierna juventud por amor al Redentor, enséñanos a poner a Jesús por encima de todas las cosas del mundo."
    ),
    Pair(1, 19) to SaintTemplate(
      title = "Santos Mario, Marta, Audifaz y Ábaco",
      saintName = "Santos Mario, Marta, Audifaz y Ábaco, mártires",
      biography = "Familia cristiana persa que peregrinó a Roma para venerar las tumbas de los apóstoles. Consagrados a sepultar a los mártires cristianos y socorrer a los encarcelados, fueron arrestados y martirizados juntos.",
      patronage = "Familias cristianas unidas en la fe y sepultureros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que bendijiste a esta santa familia con la corona del martirio en unión fraterna, fortalece la fe y el amor en todos nuestros hogares."
    ),
    Pair(1, 20) to SaintTemplate(
      title = "San Fabián y San Sebastián",
      saintName = "San Fabián, papa, y San Sebastián, mártires",
      biography = "San Fabián gobernó la Iglesia con prudencia admirable antes de ser martirizado. San Sebastián, oficial de la guardia pretoriana, confortó en secreto a los cristianos antes de ser asaeteado por confesar a Cristo Rey.",
      patronage = "Atletas, militares, arqueros, policías y contra las pestes",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Sebastián y San Fabián, interceded por nosotros para que nunca nos avergoncemos de la Cruz de Cristo y resistamos con valentía toda prueba."
    ),
    Pair(1, 21) to SaintTemplate(
      title = "Santa Inés, virgen y mártir",
      saintName = "Santa Inés, virgen y mártir de Roma",
      biography = "A los doce años de edad prefirió morir degollada antes que renunciar a su consagración total a Jesucristo como Esposo místico. Es símbolo universal de la inocencia cristiana y de la pureza inmaculada.",
      patronage = "Muchachas jóvenes, pureza, víctimas de violencia y novias",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Inés, cordero puro de Cristo, ruega por los jóvenes de hoy para que descubran el valor sagrado de la pureza y la castidad."
    ),
    Pair(1, 22) to SaintTemplate(
      title = "San Vicente, diácono y mártir",
      saintName = "San Vicente, diácono y protomártir de España",
      biography = "Diácono del obispo Valero de Zaragoza. Soportó con serenidad sobrehumana la flagelación, la parrilla ardiente y las cadenas en Valencia bajo el tirano Daciano, proclamando la gloria inquebrantable de Cristo.",
      patronage = "Diáconos, vinateros, Valencia y Zaragoza",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Vicente diácono, alcánzanos la gracia de servir al Señor con fidelidad generosa y de entregar la vida en alabanza a su santo Nombre."
    ),
    Pair(1, 23) to SaintTemplate(
      title = "San Ildefonso de Toledo",
      saintName = "San Ildefonso, arzobispo de Toledo",
      biography = "Padre de la Iglesia hispanogoda y celoso devoto de la Santísima Virgen. Defendió con brillantez teológica la virginidad perpetua de María, quien se le apareció en la catedral toledana imponiéndole una casulla celestial.",
      patronage = "Arzobispado de Toledo, escritores marianos y teólogos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ildefonso, siervo fidelísimo de Santa María, alcánzanos una devoción filial, tierna y perseverante hacia nuestra Madre del Cielo."
    ),
    Pair(1, 24) to SaintTemplate(
      title = "San Francisco de Sales",
      saintName = "San Francisco de Sales, obispo y doctor de la Iglesia",
      biography = "Obispo de Ginebra, apóstol de la mansedumbre y autor de la «Introducción a la vida devota». Fundador de la Visitación junto a Santa Juana de Chantal, enseñó que la santidad es accesible a todos los estados de vida.",
      patronage = "Periodistas, escritores, comunicadores católicos y sordomudos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco de Sales, maestro de mansedumbre, enséñanos a hablar con caridad y a ganar los corazones para Cristo con la dulzura del amor."
    ),
    Pair(1, 25) to SaintTemplate(
      title = "Conversión de San Pablo",
      saintName = "Fiesta de la Conversión de San Pablo, apóstol",
      biography = "En el camino a Damasco, Saulo es derribado por la luz resplandeciente de Cristo: «Saulo, Saulo, ¿por qué me persigues?». El fiero perseguidor se transforma en el Apóstol de los Gentiles, entregado por entero a la cruz.",
      patronage = "Misioneros, conversos, evangelizadores y unidad de los cristianos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesús, que transformaste al perseguidor Saulo en el gran apóstol Pablo, convierte nuestro corazón para que vivamos solo para Ti."
    ),
    Pair(1, 26) to SaintTemplate(
      title = "Santos Timoteo y Tito",
      saintName = "Santos Timoteo y Tito, obispos y discípulos de San Pablo",
      biography = "Colaboradores íntimos del Apóstol San Pablo. Timoteo pastoreó la Iglesia de Éfeso y Tito la comunidad cristiana de Creta. Ambos recibieron las célebres cartas pastorales del Nuevo Testamento.",
      patronage = "Obispos, formadores sacerdotales y misioneros diocesanos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios nuestro, que enriqueciste con virtudes apostólicas a los santos Timoteo y Tito, concédenos vivir en santidad y justicia en este mundo."
    ),
    Pair(1, 27) to SaintTemplate(
      title = "Santa Ángela de Mérici",
      saintName = "Santa Ángela de Mérici, virgen y fundadora",
      biography = "Terciaria franciscana italiana que fundó la Compañía de Santa Úrsula (Ursulinas), primera congregación de mujeres consagradas dedicada a la educación de niñas pobres fuera de la clausura monástica.",
      patronage = "Educadoras, huérfanos, maestras y personas con discapacidad",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Ángela de Mérici, alcánzanos tu celo educador y tu ternura maternal para formar a las nuevas generaciones en el amor a Cristo."
    ),
    Pair(1, 28) to SaintTemplate(
      title = "Santo Tomás de Aquino",
      saintName = "Santo Tomás de Aquino, presbítero y doctor de la Iglesia",
      biography = "El «Doctor Angélico». Fraile dominico cuya Suma Teológica unió de forma insuperable la fe y la razón filosófica. Compuso los sublimes himnos eucarísticos de la fiesta del Corpus Christi (Pange Lingua, Adoro Te Devote).",
      patronage = "Universidades, escuelas católicas, estudiantes y teólogos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Tomás de Aquino, concédenos amar la verdad divina y discernir con pureza de mente las riquezas de la doctrina de la Santa Iglesia."
    ),
    Pair(1, 29) to SaintTemplate(
      title = "San Valero de Zaragoza",
      saintName = "San Valero, obispo y confesor de la fe",
      biography = "Obispo de Zaragoza en el siglo IV. De habla impedida, encomendaba a su diácono San Vicente la predicación pública. Desterrado por el tirano Daciano, murió pacíficamente en el exilio confesando la fe católica.",
      patronage = "Zaragoza, Aragón y personas con dificultades de dicción",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Valero obispo, que con tu paciencia y silencio diste gloria a Dios, ayúdanos a soportar las contradicciones de la vida con paz interior."
    ),
    Pair(1, 30) to SaintTemplate(
      title = "Santa Martina",
      saintName = "Santa Martina, virgen y mártir romana",
      biography = "Noble romana del siglo III que distribuyó su cuantiosa herencia a los pobres y se consagró a Cristo. Llevada a los templos paganos, los ídolos cayeron por tierra tras su oración antes de recibir la corona del martirio.",
      patronage = "Roma, la juventud consagrada y amparo de los desvalidos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Martina, concédenos rechazar los falsos ídolos del mundo moderno para adorar con corazón indiviso al único Dios verdadero."
    ),
    Pair(1, 31) to SaintTemplate(
      title = "San Juan Bosco",
      saintName = "San Juan Bosco, presbítero y padre de la juventud",
      biography = "Fundador de los Salesianos y de las Hijas de María Auxiliadora. Rescató a miles de jóvenes huérfanos y obreros en el Turín del siglo XIX con su célebre sistema preventivo: razón, religión y amoroso afecto.",
      patronage = "Jóvenes, educadores, aprendices de oficios, editores e ilusionistas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Bosco, amigo entrañable de la juventud, enséñanos a guiar a niños y jóvenes por el camino de la alegría santa y los sacramentos."
    ),

    // ==========================================
    // FEBRERO (28/29 días)
    // ==========================================
    Pair(2, 1) to SaintTemplate(
      title = "Santa Brígida de Kildare",
      saintName = "Santa Brígida de Irlanda, abadesa",
      biography = "Patrona de Irlanda junto a San Patricio. Fundó el monasterio mixto de Kildare en el siglo V, célebre por su caridad inagotable con los mendigos, su sabiduría pastoral y su profunda oración.",
      patronage = "Irlanda, recién nacidos, lecheros y obras de caridad",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Brígida, mujer de generosidad sin límites, enciende en nuestras almas el fuego de la caridad para compartir el pan con los necesitados."
    ),
    Pair(2, 2) to SaintTemplate(
      title = "Presentación del Señor",
      saintName = "Fiesta de la Presentación del Señor (Nuestra Señora de la Candelaria)",
      biography = "A los cuarenta días del nacimiento de Jesús, María y José lo presentan en el Templo de Jerusalén. El anciano Simeón lo proclama «Luz para iluminar a las naciones y gloria de tu pueblo Israel».",
      patronage = "Vida consagrada, bendición de las velas y la pureza infantil",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Cristo Jesús, Luz del mundo, alumbra nuestras almas y disipa las tinieblas del pecado para que caminemos siempre bajo tu resplandor santo."
    ),
    Pair(2, 3) to SaintTemplate(
      title = "San Blas, obispo y mártir",
      saintName = "San Blas, obispo y mártir",
      biography = "Obispo armenio y médico de almas y cuerpos. Salvó milagrosamente a un niño que se asfixiaba con una espina en la garganta. Tras crueles tormentos fue degollado por su fidelidad al Señor.",
      patronage = "Enfermos de la garganta, otorrinolaringólogos y pastores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Por intercesión de San Blas, obispo y mártir, líbranos, Señor, de los males de la garganta y de cualquier otro mal del cuerpo y del alma."
    ),
    Pair(2, 4) to SaintTemplate(
      title = "San Juan de Brito",
      saintName = "San Juan de Brito, presbítero jesuita y mártir",
      biography = "Misionero portugués que evangelizó el sur de la India adaptándose a las costumbres de los ascetas brahmanes. Convirtió a miles de personas antes de ser decapitado por defender la indisolubilidad del matrimonio.",
      patronage = "Misioneros en Asia, fidelidad matrimonial y catequistas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Juan de Brito, que diste tu sangre por la verdad del Evangelio, enciende en nosotros el ardor misionero para anunciar a Cristo."
    ),
    Pair(2, 5) to SaintTemplate(
      title = "Santa Águeda (Ágata)",
      saintName = "Santa Águeda, virgen y mártir de Catania",
      biography = "Joven siciliana de noble linaje que consagró su virginidad a Cristo. Al rechazar las propuestas del prefecto Quinciano fue sometida a crueles suplicios, sufriendo el corte de sus pechos antes de expirar orando a Dios.",
      patronage = "Enfermas de cáncer de mama, enfermeras, fundidores y bomberos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Águeda, virgen mártir invencible, intercede por todas las mujeres que sufren enfermedades corporales y consérvanos puros en el Señor."
    ),
    Pair(2, 6) to SaintTemplate(
      title = "San Pablo Miki y compañeros",
      saintName = "San Pablo Miki y compañeros mártires de Japón",
      biography = "Veintiséis mártires crucificados y atravesados con lanzas en una colina de Nagasaki en 1597. Pablo Miki, jesuita japonés, perdonó a sus verdugos y predicó a Cristo crucificado colgado de su propia cruz.",
      patronage = "Iglesia de Japón, misioneros asiáticos y fortaleza en la persecución",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que coronaste con la gloria del martirio a San Pablo Miki y sus compañeros, haz fecunda la semilla de la fe en todos los continentes."
    ),
    Pair(2, 7) to SaintTemplate(
      title = "Beato Pío IX, papa",
      saintName = "Beato Pío IX, papa",
      biography = "Pontífice de largo y fecundo reinado en el siglo XIX. Proclamó solemnemente el dogma de la Inmaculada Concepción de María (1854) y convocó el Concilio Vaticano I, promoviendo el amor a la Eucaristía y al Sagrado Corazón.",
      patronage = "Pastores de la Iglesia, fidelidad doctrinal y papado",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que concediste al Beato Pío IX guiar la barca de Pedro con firmeza y amor mariano, protege a tu Iglesia en toda borrasca."
    ),
    Pair(2, 8) to SaintTemplate(
      title = "San Jerónimo Emiliani y Santa Josefina Bakhita",
      saintName = "San Jerónimo Emiliani y Santa Josefina Bakhita",
      biography = "San Jerónimo Emiliani fundó a los Somascos para acoger a los huérfanos. Santa Josefina Bakhita, esclava sudanesa liberada y convertida, ingresó con las Hijas de la Caridad Canossianas, perdonando a sus antiguos captores.",
      patronage = "Huérfanos, víctimas de trata de personas y esclavitud moderna",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que en Santa Josefina Bakhita mostraste la grandeza del perdón cristiano, libera a todos los oprimidos y haz que vivamos en tu paz."
    ),
    Pair(2, 9) to SaintTemplate(
      title = "Santa Apolonia",
      saintName = "Santa Apolonia, virgen y mártir de Alejandría",
      biography = "Diaconisa anciana de Alejandría que durante una violenta turba anticristiana sufrió la extracción brutal de todos sus dientes; amenazada con la hoguera si no blasfemaba, se arrojó libremente a las llamas.",
      patronage = "Dentistas, odontólogos y dolores de muelas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Apolonia, que preferiste el fuego antes que negar a Cristo, líbranos del dolor y alcánzanos una confesión sincera de nuestra fe."
    ),
    Pair(2, 10) to SaintTemplate(
      title = "Santa Escolástica",
      saintName = "Santa Escolástica, virgen (hermana de San Benito)",
      biography = "Hermana gemela de San Benito. Consagrada a Dios desde la infancia, compartía con su hermano santos coloquios sobre el cielo una vez al año. Su oración ardiente alcanzó una lluvia milagrosa para prolongar su diálogo espiritual.",
      patronage = "Monjas benedictinas, niños con convulsiones y contra tormentas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Escolástica, que demostraste que el amor a Dios puede más que las reglas humanas, inflama nuestro corazón en el deseo del Cielo."
    ),
    Pair(2, 11) to SaintTemplate(
      title = "Nuestra Señora de Lourdes",
      saintName = "Nuestra Señora de Lourdes (Jornada Mundial del Enfermo)",
      biography = "En 1858 la Santísima Virgen se apareció dieciocho veces a la humilde pastora Bernardita Soubirous en la gruta de Massabielle, proclamando «Yo soy la Inmaculada Concepción» e invitando a la oración y penitencia.",
      patronage = "Enfermos corporales y espirituales, médicos y agentes sanitarios",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen purísima de Lourdes, salud de los enfermos y consuelo de los afligidos, alivia los dolores de quienes sufren y renueva su esperanza."
    ),
    Pair(2, 12) to SaintTemplate(
      title = "Santa Eulalia de Mérida",
      saintName = "Santa Eulalia de Mérida, virgen y mártir",
      biography = "Niña mártir de doce años en la Lusitania romana. Se presentó voluntariamente ante el gobernador Daciano para reprocharle la crueldad con que perseguía a los cristianos. Fue quemada viva, brotando una paloma blanca de su boca.",
      patronage = "Mérida, Extremadura, jóvenes mártires y viajeros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Eulalia de Mérida, que con valor divino defendiste la santidad de Dios, alcánzanos pureza de alma y fortaleza en el testimonio."
    ),
    Pair(2, 13) to SaintTemplate(
      title = "San Benigno de Todi",
      saintName = "San Benigno, presbítero y mártir",
      biography = "Sacerdote umbro del siglo IV que durante las persecuciones de Diocleciano recorrió las aldeas bautizando a conversos y fortaleciendo a los prisioneros. Fue martirizado tras negarse a ofrecer incienso a las deidades paganas.",
      patronage = "Sacerdotes misioneros, presos y fortaleza en la fe",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Benigno, que diste tu vida por alimentar a las almas con los sacramentos, bendice a nuestros sacerdotes con santidad y celo pastoral."
    ),
    Pair(2, 14) to SaintTemplate(
      title = "Santos Cirilo y Metodio",
      saintName = "Santos Cirilo y Metodio, patronos de Europa",
      biography = "Hermanos griegos de Tesalónica del siglo IX. Apóstoles de los pueblos eslavos, crearon el alfabeto cirílico y tradujeron las Sagradas Escrituras y la Santa Misa a la lengua eslava con aprobación pontificia.",
      patronage = "Patronos de Europa, ecumenismo, traductores y unidad de los pueblos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios de infinita bondad, que llevaste a los pueblos eslavos a la luz del Evangelio mediante Cirilo y Metodio, une a todos los cristianos en un solo rebaño."
    ),
    Pair(2, 15) to SaintTemplate(
      title = "San Claudio de la Colombière",
      saintName = "San Claudio de la Colombière, presbítero jesuita",
      biography = "Director espiritual de Santa Margarita María Alacoque en Paray-le-Monial. Declarado por Jesús «fiel servidor y perfecto amigo», consagró su ministerio a propagar por Europa el culto al Sagrado Corazón de Jesús.",
      patronage = "Directores espirituales, confesores y devotos del Sagrado Corazón",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Claudio de la Colombière, enséñanos a confiar ciegamente en el Sagrado Corazón de Jesús y a abandonarnos por completo en su Providencia."
    ),
    Pair(2, 16) to SaintTemplate(
      title = "Santa Juliana de Nicomedia",
      saintName = "Santa Juliana, virgen y mártir",
      biography = "Virgen asiática que prefirió padecer azotes, cadenas y tormentos antes de contraer matrimonio con un senador pagano que le exigía renunciar a su fe en Cristo. Murió decapitada en el año 305.",
      patronage = "Mujeres de parto, amparo contra fiebres y pureza",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Juliana, que despreciaste las vanidades del mundo por seguir al Cordero divino, danos valor para vivir según el Evangelio."
    ),
    Pair(2, 17) to SaintTemplate(
      title = "Los Siete Santos Fundadores",
      saintName = "Los Siete Santos Fundadores de la Orden de los Siervos de María",
      biography = "Siete nobles mercaderes florentinos del siglo XIII que abandonaron riquezas y honores para retirarse al Monte Senario a orar, fundando la Orden de los Servitas consagrados a honrar los dolores de la Virgen María.",
      patronage = "Vida contemplativa, fraternidad religiosa y devoción a la Dolorosa",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Dios, infunde en nosotros el espíritu de oración y amor filial a la Virgen Dolorosa que concediste a los Siete Santos Fundadores."
    ),
    Pair(2, 18) to SaintTemplate(
      title = "San Flaviano de Constantinopla",
      saintName = "San Flaviano, patriarca y mártir",
      biography = "Patriarca de Constantinopla en el siglo V. Defendió con heroísmo la verdadera humanidad y divinidad de Cristo frente a la herejía monofisita, sufriendo ultrajes y golpes que le causaron la muerte en el destierro.",
      patronage = "Defensores de la verdad católica y obispos probados en la fe",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Flaviano, mártir de la recta doctrina de Cristo, protege a los pastores de la Santa Iglesia de los errores del mundo."
    ),
    Pair(2, 19) to SaintTemplate(
      title = "San Conrado de Piacenza",
      saintName = "San Conrado de Piacenza, eremita franciscano",
      biography = "Noble cazador italiano que tras causar accidentalmente un devastador incendio pagó con todos sus bienes las pérdidas; arrepentido, ingresó a la Tercera Orden franciscana viviendo cuarenta años en austera penitencia.",
      patronage = "Cazadores, penitentes, enfermos de hernia y bomberos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Conrado, modelo de reparación y humildad sincera, ayúdanos a reparar nuestras faltas con obras de auténtica caridad fraterna."
    ),
    Pair(2, 20) to SaintTemplate(
      title = "Santos Jacinta y Francisco Marto",
      saintName = "Santos Jacinta y Francisco Marto, videntes de Fátima",
      biography = "Pastorcitos portugueses a quienes se apareció la Santísima Virgen en Cova da Iria en 1917. Con apenas diez y nueve años ofrecieron sus sufrimientos y oraciones por la conversión de los pecadores y por el Santo Padre.",
      patronage = "Niños, enfermos infantiles y reparación al Inmaculado Corazón",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos Francisco y Jacinta, enseñadnos a rezar el Rosario con devoción y a ofrecer sacrificios diarios por la paz del mundo y la salvación de las almas."
    ),
    Pair(2, 21) to SaintTemplate(
      title = "San Pedro Damián",
      saintName = "San Pedro Damián, obispo y doctor de la Iglesia",
      biography = "Monje camaldulense del siglo XI que llegó a cardenal de la Iglesia. Severo reformador de las costumbres eclesiásticas, combatió la simonía y la relajación moral, promoviendo el rigor ascético y la santidad sacerdotal.",
      patronage = "Reformadores de la Iglesia, contemplativos y confesores",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro Damián, alcánzanos del Señor sacerdotes santos, castos y celosos que pastoreen al pueblo con ejemplo de vida irreprochable."
    ),
    Pair(2, 22) to SaintTemplate(
      title = "La Cátedra de San Pedro",
      saintName = "Fiesta de la Cátedra de San Pedro, apóstol",
      biography = "Celebramos la misión magisterial y pastoral que Cristo confirió a San Pedro y a sus sucesores los Romanos Pontífices como fundamento visible y roca inconmovible de la unidad de la Santa Iglesia católica.",
      patronage = "El Papa, la Santa Sede y la comunión eclesial",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Jesucristo, que sobre la roca de Pedro edificaste tu Iglesia, haz que permanezcamos siempre firmes en la doctrina de los apóstoles y en comunión con el Papa."
    ),
    Pair(2, 23) to SaintTemplate(
      title = "San Policarpo de Esmirna",
      saintName = "San Policarpo, obispo y mártir",
      biography = "Discípulo del apóstol San Juan y venerable obispo de Esmirna. A los ochenta y seis años, intimado a maldecir a Cristo, respondió: «Ochenta y seis años le he servido y ningún mal me ha hecho, ¿cómo podría blasfemar de mi Rey?». Murió en la hoguera.",
      patronage = "Ancianos, fidelidad hasta la muerte y contra incendios",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Policarpo, maestro inquebrantable de la fe primitiva, consérvanos fieles al Salvador en toda circunstancia de la vida."
    ),
    Pair(2, 24) to SaintTemplate(
      title = "San Modesto de Tréveris",
      saintName = "San Modesto, obispo de Tréveris",
      biography = "Obispo de Tréveris en el siglo V durante el turbulento período de las invasiones francas. Consoló al pueblo hambriento, reconstruyó templos destruidos y defendió la fe con mansedumbre paternal.",
      patronage = "Poblaciones devastadas por la guerra y caridad pastoral",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Modesto, que reconstruiste la fe en tiempos de ruina y desolación, renueva en nuestros pueblos el amor a la casa de Dios."
    ),
    Pair(2, 25) to SaintTemplate(
      title = "San Cesáreo de Nacianzo",
      saintName = "San Cesáreo de Nacianzo, médico",
      biography = "Hermano de San Gregorio Nacianceno. Médico imperial en Constantinopla de probada sabiduría y castidad. Renunció a los honores terrenales y distribuyó todos sus bienes a los enfermos indigentes antes de expirar.",
      patronage = "Médicos católicos, profesionales de la salud y laicos comprometidos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Cesáreo, médico cristiano ejemplar, bendice a quienes cuidan de los enfermos para que vean en cada paciente el rostro llagado de Cristo."
    ),
    Pair(2, 26) to SaintTemplate(
      title = "San Porfirio de Gaza",
      saintName = "San Porfirio, obispo de Gaza",
      biography = "Monje de origen macedonio que vivió en el desierto egipcio y cerca del Jordán. Elegido obispo de Gaza, destruyó con paciencia y oración los templos idólatras, convirtiendo a la población entera con obras de caridad.",
      patronage = "Misioneros en tierras hostiles y protectores de las cosechas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que concediste a San Porfirio la paciencia apostólica para desterrar el error, ayúdanos a proclamar la verdad con mansedumbre."
    ),
    Pair(2, 27) to SaintTemplate(
      title = "San Gabriel de la Dolorosa",
      saintName = "San Gabriel de la Dolorosa, religioso pasionista",
      biography = "Joven italiano pasionista fallecido a los veinticuatro años de tuberculosis. Brilló por su amor extraordinario a la Virgen de los Dolores y por transformar cada pequeño deber cotidiano en un acto de sublime caridad.",
      patronage = "Jóvenes, seminaristas, novicios y estudiantes católicos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Gabriel de la Dolorosa, que encontraste tu alegría en contemplar a la Virgen junto a la Cruz, despierta en los jóvenes el amor a la oración santa."
    ),
    Pair(2, 28) to SaintTemplate(
      title = "San Román de Condat",
      saintName = "San Román de Condat, abad",
      biography = "Con treinta y cinco años se retiró a los bosques de los montes del Jura en Francia para vivir como solitario. Atrajo a cientos de discípulos, entre ellos su hermano Lupicino, fundando abadías modelo de trabajo y alabanza divina.",
      patronage = "Monjes, enfermos mentales y ahogados",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Román abad, enséñanos el valor del silencio, la sobriedad y el trabajo cotidiano ofrecido al Señor."
    ),
    Pair(2, 29) to SaintTemplate(
      title = "San Dositeo de Gaza",
      saintName = "San Dositeo de Gaza, monje y modelo de obediencia",
      biography = "Joven soldado que al convertirse al cristianismo ingresó en el monasterio de San Doroteo en Gaza. En apenas cinco años alcanzó una altísima santidad mediante el corte continuo de la propia voluntad y la humilde obediencia.",
      patronage = "Años bisiestos, novicios, enfermos de pulmón y obediencia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Dositeo, que en la sencillez de la obediencia encontraste el camino real hacia el Reino de los Cielos, haz nuestro corazón dócil a la gracia de Dios."
    ),

    // ==========================================
    // MARZO (31 días)
    // ==========================================
    Pair(3, 1) to SaintTemplate(
      title = "San David de Gales",
      saintName = "San David, obispo y patrono de Gales",
      biography = "Monje y obispo del siglo VI que fundó numerosos monasterios en Gales. Célebre por su austeridad (no bebía más que agua y comía solo pan y hierbas) y por su mandato final: «Sed alegres, conservad la fe y haced las pequeñas cosas».",
      patronage = "Gales, vegetarianos y monjes celtas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San David de Gales, recuérdanos la importancia de santificar las pequeñas cosas cotidianas con alegría y profunda fe en el Señor."
    ),
    Pair(3, 2) to SaintTemplate(
      title = "Santa Inés de Bohemia",
      saintName = "Santa Inés de Praga, abadesa clarisa",
      biography = "Princesa real de Bohemia que rechazó matrimonios de conveniencia con reyes y emperadores para fundar un hospital y abrazar la pobreza franciscana, carteándose asiduamente con Santa Clara de Asís.",
      patronage = "República Checa, donantes de hospitales y jóvenes consagradas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Inés de Bohemia, que cambiaste una corona terrena por el velo de la pobreza de Cristo, enséñanos a valorar las riquezas del Cielo."
    ),
    Pair(3, 3) to SaintTemplate(
      title = "Santa Catalina Drexel",
      saintName = "Santa Catalina Drexel, virgen y fundadora",
      biography = "Riquísima heredera de Filadelfia que consagró su fortuna entera y su vida a socorrer y educar a los indígenas y afroamericanos marginados, fundando las Hermanas del Santísimo Sacramento.",
      patronage = "Filántropos, justicia racial e igualdad de los pueblos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Catalina Drexel, que viste en los más discriminados la presencia viva de Jesús Eucaristía, enciende en nosotros el celo por la justicia fraterna."
    ),
    Pair(3, 4) to SaintTemplate(
      title = "San Casimiro",
      saintName = "San Casimiro, príncipe de Polonia",
      biography = "Hijo del rey de Polonia, brilló en la corte por su piedad inaudita, su devoción apasionada a la Santísima Virgen (rezaba diariamente el himno Omni die dic Mariae) y su pureza angelical hasta su temprana muerte.",
      patronage = "Polonia, Lituania, jóvenes en el servicio público y castidad",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Casimiro, príncipe santo, alcánzanos pureza de costumbres y fidelidad a Dios por encima de todos los atractivos del poder terrenal."
    ),
    Pair(3, 5) to SaintTemplate(
      title = "San Juan José de la Cruz",
      saintName = "San Juan José de la Cruz, fraile franciscano alcantarino",
      biography = "Sacerdote franciscano italiano maestro de ascetas. Vivió en rigurosa penitencia y oración ininterrumpida en Nápoles, gozando de carismas milagrosos, profecías y un tierno amor a los pecadores.",
      patronage = "Isla de Isquia, penitentes y confesores caritativos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan José de la Cruz, que cargaste con amor la cruz de la penitencia, haz que aceptemos los sufrimientos de la vida con alegría pascual."
    ),
    Pair(3, 6) to SaintTemplate(
      title = "San Olegario de Barcelona",
      saintName = "San Olegario, obispo de Barcelona y arzobispo de Tarragona",
      biography = "Prelado catalán del siglo XII insigne por su santidad y austeridad personal. Pacificador de nobles, reformó el clero y restauró la sede metropolitana de Tarragona tras la Reconquista.",
      patronage = "Barcelona, Tarragona y la concordia ciudadana",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Olegario, pastor lleno de prudencia y celo, intercede por la paz y la concordia en nuestras comunidades y familias."
    ),
    Pair(3, 7) to SaintTemplate(
      title = "Santas Perpetua y Felicidad",
      saintName = "Santas Perpetua y Felicidad, mártires de Cartago",
      biography = "Joven noble romana y su esclava recién dada a luz que se unieron en fraterno abrazo en la arena de Cartago en el año 203. Afrontaron fieras y gladiadores sin renunciar a su fe viva en Cristo.",
      patronage = "Madres, embarazadas, carniceros y mártires africanos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santas Perpetua y Felicidad, que mostrasteis un valor sublime sellando vuestra fe con el martirio, alcanzadnos constancia en el seguimiento de Jesús."
    ),
    Pair(3, 8) to SaintTemplate(
      title = "San Juan de Dios",
      saintName = "San Juan de Dios, religioso y fundador de los Hermanos Hospitalarios",
      biography = "Soldado y comerciante portugués que tras escuchar una prédica de San Juan de Ávila se convirtió radicalmente. Fundó en Granada los Hermanos Hospitalarios para servir a enfermos y desvalidos: «Haced bien, hermanos, a vosotros mismos».",
      patronage = "Hospitales, enfermos, enfermeros, bomberos y libreros",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan de Dios, corazón encendido de caridad hacia los más pobres y enfermos, alcánzanos una compasión viva para servir a Cristo en el dolor del prójimo."
    ),
    Pair(3, 9) to SaintTemplate(
      title = "Santa Francisca Romana",
      saintName = "Santa Francisca Romana, religiosa",
      biography = "Noble matrona romana del siglo XV. Esposa ejemplar y madre tierna, atendió a los enfermos en peste y fundó las Oblatas de Tor de' Specchi. Fue bendecida con la visión continua y protectora de su Ángel de la Guarda.",
      patronage = "Automovilistas, viudas, amas de casa y Roma",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Francisca Romana, modelo en el matrimonio y en la vida consagrada, enséñanos a vivir en la presencia constante de Dios y de su Santo Ángel."
    ),
    Pair(3, 10) to SaintTemplate(
      title = "San Macario de Jerusalén",
      saintName = "San Macario, obispo de Jerusalén",
      biography = "Obispo del siglo IV que asistió al Concilio de Nicea combatiendo el arrianismo. Dirigió junto a Santa Elena las excavaciones en el Calvario que culminaron con el hallazgo de la Vera Cruz de Nuestro Señor.",
      patronage = "Custodia de los Santos Lugares de Jerusalén y arqueólogos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Macario, testigo del triunfo de la Santa Cruz, ayúdanos a abrazar la cruz de cada día como el camino bendito hacia la Resurrección."
    ),
    Pair(3, 11) to SaintTemplate(
      title = "San Eulogio de Córdoba",
      saintName = "San Eulogio de Córdoba, obispo y mártir",
      biography = "Sacerdote mozárabe del siglo IX en la Córdoba califal. Consolador de los mártires cristianos encarcelados y autor del Memorial de los Santos. Fue decapitado por defender públicamente la divinidad de Cristo.",
      patronage = "Córdoba, escritores católicos y libertad religiosa",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Eulogio mártir, que diste testimonio valeroso de Cristo en medio de la opresión, concede fortaleza a todos los cristianos perseguidos en el mundo."
    ),
    Pair(3, 12) to SaintTemplate(
      title = "San Inocencio I, papa",
      saintName = "San Inocencio I, papa",
      biography = "Pontífice durante el devastador saqueo de Roma por los visigodos de Alarico en el año 410. Confirmó las condenas contra el pelagianismo proclamando que de la Sede Apostólica brotan las decisiones doctrinales para toda la Iglesia.",
      patronage = "Roma, firmeza pontificia y socorro a víctimas de la guerra",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que en tiempos de angustia pusiste a San Inocencio al frente de tu rebaño, libra a nuestro mundo de la guerra y danos tu santa paz."
    ),
    Pair(3, 13) to SaintTemplate(
      title = "San Rodrigo de Córdoba",
      saintName = "San Rodrigo, presbítero y mártir",
      biography = "Sacerdote de Cabra (Córdoba) martirizado en el año 857. Acusado falsamente por su propio hermano apóstata de haber renegado del islam, prefirió la cárcel y el degüello antes que mentir sobre su fidelidad absoluta a Cristo.",
      patronage = "Sacerdotes incomprendidos, víctimas de calumnias y la verdad",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Rodrigo, que no temiste las falsas acusaciones de los hombres por permanecer fiel a la verdad, ayúdanos a vivir con rectitud de conciencia."
    ),
    Pair(3, 14) to SaintTemplate(
      title = "Santa Matilde, reina",
      saintName = "Santa Matilde, reina de Alemania",
      biography = "Esposa del rey Enrique I de Germania y madre del emperador Otón I. Famosa por su humildad y caridad ilimitada: visitaba hospitales, liberaba esclavos y pasaba las noches en vela orando por los difuntos.",
      patronage = "Familias numerosas, viudas, reinas santas y paciencia con los hijos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Matilde, que usaste el poder de la corona para socorrer a los desvalidos, alcánzanos generosidad para compartir con los que nada tienen."
    ),
    Pair(3, 15) to SaintTemplate(
      title = "Santa Luisa de Marillac",
      saintName = "Santa Luisa de Marillac, fundadora de las Hijas de la Caridad",
      biography = "Colaboradora insustituible de San Vicente de Paúl. Fundó las Hijas de la Caridad, enviando a las hermanas a los suburbios, prisiones y campos de batalla a cuidar a los enfermos y huérfanos con heroica entrega.",
      patronage = "Asistentes sociales, obras sociales cristianas y viudas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Luisa de Marillac, alcánzanos un corazón abierto a las miserias de nuestros hermanos y la gracia de ver a Cristo en los más desamparados."
    ),
    Pair(3, 16) to SaintTemplate(
      title = "San Heriberto de Colonia",
      saintName = "San Heriberto, arzobispo de Colonia",
      biography = "Canciller del emperador Otón III y celoso arzobispo. Durante una gravísima sequía que azotó a la región de Colonia, sus oraciones públicas y procesiones penitenciales alcanzaron una lluvia milagrosa salvando a la población.",
      patronage = "Lluvia en tiempos de sequía y Colonia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Heriberto, que con tu ardiente oración trajiste el alivio del cielo a tu pueblo sediento, alcánzanos de Dios las bendiciones que necesitamos."
    ),
    Pair(3, 17) to SaintTemplate(
      title = "San Patricio",
      saintName = "San Patricio, obispo y apóstol de Irlanda",
      biography = "Secuestrado en su juventud por piratas irlandeses, aprendió la lengua celta. Tras escapar y ordenarse sacerdote, regresó a Irlanda como obispo, bautizando a miles de personas y usando el trébol para explicar el misterio de la Santísima Trinidad.",
      patronage = "Irlanda, ingenieros, personas que luchan contra serpientes y la fe trinitaria",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Patricio, gran apóstol de Irlanda, fortalece nuestra fe en el Padre, en el Hijo y en el Espíritu Santo, y enséñanos a proclamar la verdad sin temor."
    ),
    Pair(3, 18) to SaintTemplate(
      title = "San Cirilo de Jerusalén",
      saintName = "San Cirilo de Jerusalén, obispo y doctor de la Iglesia",
      biography = "Obispo del siglo IV célebre por sus «Catequesis mistagógicas», donde explicó con incomparable belleza a los catecúmenos los misterios del Bautismo, la Confirmación y la Sagrada Eucaristía.",
      patronage = "Catequistas, catecúmenos y teología de los sacramentos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Cirilo de Jerusalén, maestro admirable de la doctrina cristiana, alcánzanos venerar con profundo asombro los sagrados misterios de la Eucaristía."
    ),
    Pair(3, 19) to SaintTemplate(
      title = "San José, Esposo de la Virgen",
      saintName = "Solemnidad de San José, Esposo de la Santísima Virgen María",
      biography = "Varón justo del linaje de David a quien Dios confió la custodia de sus mayores tesoros: Jesús y María. Modelo de trabajador silencioso, padre nutricio prudente y Patrono universal de la Iglesia Católica.",
      patronage = "Iglesia Universal, familias, padres, trabajadores y la buena muerte",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Glorioso San José, custodio de la Sagrada Familia y protector de la Iglesia, protege a nuestros hogares, bendice nuestro trabajo y asístenos en la hora de nuestra muerte."
    ),
    Pair(3, 20) to SaintTemplate(
      title = "San Cutberto de Lindisfarne",
      saintName = "San Cutberto, obispo y monje",
      biography = "Monje y obispo inglés del siglo VII, insigne por su santidad humilde, su amor por la soledad de la isla de Farne y su predicación ardiente por las comarcas más montañosas de Northumbria.",
      patronage = "Marineros del norte, pastores y protección de la fauna",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Cutberto, pastor solícito de las almas alejadas, despierta en nosotros el celo misionero para llevar la luz de Cristo a todos los rincones."
    ),
    Pair(3, 21) to SaintTemplate(
      title = "San Nicolás de Flüe",
      saintName = "San Nicolás de Flüe (Hermano Klaus), ermitaño y patrono de Suiza",
      biography = "Padre de diez hijos, magistrado y soldado que con consentimiento mutuo familiar se retiró a una garganta montañosa para orar, subsistiendo durante veinte años solo con la Sagrada Eucaristía y pacificando a su patria.",
      patronage = "Suiza, pacificadores, gobernantes y la paz civil",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«Señor mío y Dios mío, quita de mí todo lo que me aleje de Ti; dame todo lo que me acerque a Ti; tómame a mí y hazme totalmente tuyo». Amén."
    ),
    Pair(3, 22) to SaintTemplate(
      title = "San Epafrodito",
      saintName = "San Epafrodito, colaborador de San Pablo",
      biography = "Discípulo elogiado por San Pablo como «mi hermano, colaborador y compañero de lucha». Enviado por los filipenses para servir a Pablo en prisión, enfermó gravemente de muerte por la obra de Cristo.",
      patronage = "Colaboradores pastorales, voluntarios de cárceles y misioneros",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, concédenos la generosidad de San Epafrodito para desgastarnos sin reservas por la causa del Evangelio y el socorro a nuestros pastores."
    ),
    Pair(3, 23) to SaintTemplate(
      title = "Santo Toribio de Mogrovejo",
      saintName = "Santo Toribio de Mogrovejo, arzobispo de Lima",
      biography = "Gran evangelizador del Perú y organizador de la Iglesia en América del Sur. Recorrió a pie miles de kilómetros en tres sínodos provinciales, aprendió quechua, defendió a los indígenas y confirmó a Santa Rosa y San Martín de Porres.",
      patronage = "Episcopado latinoamericano, Perú y misioneros",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Toribio de Mogrovejo, pastor incansable de los pueblos americanos, intercede por la fe y la justicia en todas las naciones de habla hispana."
    ),
    Pair(3, 24) to SaintTemplate(
      title = "San Óscar Arnulfo Romero",
      saintName = "San Óscar Romero, arzobispo y mártir",
      biography = "Arzobispo de San Salvador. Voz valiente de los pobres y oprimidos en El Salvador, fue asesinado en el altar mientras celebraba la Santa Misa el 24 de marzo de 1980, sellando su ministerio con la sangre del martirio.",
      patronage = "Defensa de los derechos humanos, América Central y los pobres",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Óscar Romero, pastor que diste la vida junto al cáliz del Señor, enséñanos a defender la dignidad de todo ser humano con la fuerza del Evangelio."
    ),
    Pair(3, 25) to SaintTemplate(
      title = "La Anunciación del Señor",
      saintName = "Solemnidad de la Anunciación del Señor (La Encarnación)",
      biography = "El Arcángel San Gabriel anuncia a la Virgen María que será la Madre del Salvador. Ante el humilde «Fiat» de María («Hágase en mí según tu palabra»), el Verbo Eterno de Dios se encarnó en sus purísimas entrañas para nuestra redención.",
      patronage = "Jornada por la Vida, niños por nacer, madres gestantes y la Encarnación",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Te damos gracias, Padre celestial, porque por el «Sí» generoso de la Virgen María tu Hijo se hizo carne entre nosotros. Haznos dóciles a tu santa voluntad."
    ),
    Pair(3, 26) to SaintTemplate(
      title = "San Braulio de Zaragoza",
      saintName = "San Braulio, obispo de Zaragoza",
      biography = "Insigne prelado hispanovisigodo del siglo VII. Gran amigo y consejero de San Isidoro de Sevilla, a quien impulsó a escribir las Etimologías. Destacó por su sabiduría bíblica, el cuidado de los pobres y su elocuencia pastoral.",
      patronage = "Aragón, bibliotecarios, estudiantes y escritores cristianos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Braulio de Zaragoza, maestro de ciencia santa, ruega por los estudiosos y educadores para que pongan sus talentos al servicio del Reino de Dios."
    ),
    Pair(3, 27) to SaintTemplate(
      title = "San Ruperto de Salzburgo",
      saintName = "San Ruperto, obispo y evangelizador de Baviera",
      biography = "Obispo de Worms que evangelizó el sur de Alemania y Austria en el siglo VIII. Fundó la ciudad de Salzburgo y su célebre abadía de San Pedro, impulsando la explotación de las minas de sal para sostener a los indigentes.",
      patronage = "Salzburgo, mineros de la sal y Austria",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ruperto, que fundaste ciudades sobre el cimiento inquebrantable de la fe en Cristo, bendice nuestras poblaciones con el don de la fe."
    ),
    Pair(3, 28) to SaintTemplate(
      title = "San Esteban Harding",
      saintName = "San Esteban Harding, abad de Císter",
      biography = "Monje inglés cofundador de la Orden del Císter junto a San Roberto y San Alberico. Redactó la Carta de la Caridad y acogió a San Bernardo de Claraval con treinta compañeros, haciendo florecer la renovación monástica.",
      patronage = "Monasterios cistercienses, escribas y calígrafos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Esteban Harding, amante de la santa regla y del rigor evangélico, enséñanos a buscar a Dios con un corazón puro y desprendido."
    ),
    Pair(3, 29) to SaintTemplate(
      title = "San Eustasio de Luxeuil",
      saintName = "San Eustasio, abad",
      biography = "Discípulo predilecto de San Columbano y segundo abad del monasterio de Luxeuil en la Galia merovingia. Bajo su guía se formaron más de seiscientos monjes que evangelizaron amplias regiones de Baviera.",
      patronage = "Formadores religiosos y misioneros rurales",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Eustasio, que formaste a verdaderos apóstoles de Cristo con tu testimonio santo, haz florecer santas vocaciones consagradas en la Iglesia."
    ),
    Pair(3, 30) to SaintTemplate(
      title = "San Juan Clímaco",
      saintName = "San Juan Clímaco, abad del Sinaí",
      biography = "Monje del monasterio de Santa Catalina en el Monte Sinaí en el siglo VI. Autor de la inmortal obra «La Escala del Paraíso» (Clímax), que describe los treinta peldaños de las virtudes para ascender al amor perfecto de Dios.",
      patronage = "Monjes, ascetas, directores espirituales y orantes",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Clímaco, que trazaste los peldaños de la humildad y la pureza para subir a Dios, ayúdanos a vencer nuestras pasiones y vivir en santidad."
    ),
    Pair(3, 31) to SaintTemplate(
      title = "San Benjamín, diácono y mártir",
      saintName = "San Benjamín, diácono y mártir de Persia",
      biography = "Diácono persa martirizado en el siglo V. Habiendo sido liberado con la condición de no predicar el Evangelio, respondió: «No puedo callar la luz del Señor». Fue sometido a crueles tormentos clavándole astillas bajo las uñas antes de morir.",
      patronage = "Diáconos, valentía evangélica y perseverancia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Benjamín diácono, alcánzanos la santa osadía de proclamar a Cristo resucitado sin dejarnos intimidar por los respetos humanos."
    )
  )
}
