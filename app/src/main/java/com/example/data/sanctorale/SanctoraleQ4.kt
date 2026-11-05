package com.example.data.sanctorale

import com.example.data.CatholicCalendarRepository.SaintTemplate
import com.example.model.CelebrationRank
import com.example.model.LiturgicalColor

object SanctoraleQ4 {

  val saints: Map<Pair<Int, Int>, SaintTemplate> = mapOf(
    // ==========================================
    // OCTUBRE (31 días)
    // ==========================================
    Pair(10, 1) to SaintTemplate(
      title = "Santa Teresita del Niño Jesús",
      saintName = "Fiesta de Santa Teresita del Niño Jesús, virgen y doctora de la Iglesia",
      biography = "Monja carmelita descalza de Lisieux fallecida a los veinticuatro años. Autora de «Historia de un alma», enseñó el «Caminito de la infancia espiritual»: la confianza ciega y el abandono total en los brazos misericordiosos del Padre: «En el corazón de la Iglesia, yo seré el amor».",
      patronage = "Patrona universal de las misiones (junto a San Francisco Javier), floristas y Francia",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Teresita del Niño Jesús, derrama desde el cielo una lluvia incesante de rosas sobre nuestras almas y enséñanos tu caminito de amor y abandono en Dios."
    ),
    Pair(10, 2) to SaintTemplate(
      title = "Los Santos Ángeles Custodios",
      saintName = "Memoria de los Santos Ángeles Custodios (El Ángel de la Guarda)",
      biography = "Celebramos a los bienaventurados espíritus celestiales que Dios, en su infinita Providencia paternal, asigna a cada ser humano desde el instante de su concepción para protegerlo, iluminarlo, guiarlo en los peligros y conducirlo a la vida eterna.",
      patronage = "Protección de los niños, caminantes, contra el mal y la soledad",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Ángel de mi guarda, dulce compañía, no me desampares ni de noche ni de día. No me dejes solo, que me perdería, hasta que descanse en los brazos de Jesús, José y María». Amén."
    ),
    Pair(10, 3) to SaintTemplate(
      title = "San Francisco de Borja",
      saintName = "San Francisco de Borja, presbítero jesuita",
      biography = "Duque de Gandía y virrey de Cataluña. Tras contemplar el cadáver descompuesto de la emperatriz Isabel pronunció: «Nunca más serviré a señor que se me pueda morir». Al enviudar ingresó en los Jesuitas, llegando a ser su tercer Prepósito General.",
      patronage = "Gandía, nobles convertidos y desprendimiento de grandezas humanas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco de Borja, que comprendiste la vanidad de los honores del mundo, enséñanos a no poner nuestro corazón sino en el Dios eterno."
    ),
    Pair(10, 4) to SaintTemplate(
      title = "San Francisco de Asís",
      saintName = "Fiesta de San Francisco de Asís, fundador de los Franciscanos",
      biography = "Hijo de un rico mercader de Asís que se despojó de todo ante el obispo para seguir a Cristo pobre («El Pobrecillo de Asís»). Restaurador de la Iglesia, amante de toda criatura (Cántico del Hermano Sol) y estigmatizado con las llagas de Jesús en el Monte Alverna.",
      patronage = "Patrono de Italia, ecología, animales, comerciantes, franciscanos y la paz",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Señor, hazme un instrumento de tu paz: donde haya odio, siembre yo amor; donde haya ofensa, perdón; donde haya duda, fe; donde haya desesperación, esperanza». Amén."
    ),
    Pair(10, 5) to SaintTemplate(
      title = "Santa Faustina Kowalska",
      saintName = "Santa Faustina Kowalska, apóstol de la Divina Misericordia",
      biography = "Religiosa polaca de las Hermanas de Nuestra Señora de la Misericordia. Recibió las revelaciones de Jesús Misericordioso («Pinta una imagen según el modelo que ves, con la inscripción: Jesús, en Ti confío»), transmitiendo la Coronilla y la Fiesta de la Misericordia.",
      patronage = "Apóstoles de la Divina Misericordia, Polonia y pecadores desesperados",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Jesús, en Ti confío. Santa Faustina, secretaria de la Divina Misericordia, ruega por nosotros para que nunca dudemos del perdón infinito de Dios."
    ),
    Pair(10, 6) to SaintTemplate(
      title = "San Bruno",
      saintName = "San Bruno, presbítero y fundador de los Cartujos",
      biography = "Canciller de la diócesis de Reims del siglo XI. Con seis compañeros se retiró al valle desierto de la Cartuja en los Alpes franceses para fundar la Orden Cartujana, viviendo en soledad absoluta, silencio perpetuo y contemplación de Dios.",
      patronage = "Orden Cartujana, contemplativos, ermitaños y Calabria",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Bruno, que encontraste en la soledad y el silencio el remanso de la presencia divina, concédenos momentos de quietud para buscar a Dios."
    ),
    Pair(10, 7) to SaintTemplate(
      title = "Nuestra Señora del Rosario",
      saintName = "Memoria de Nuestra Señora del Rosario (Victoria de Lepanto)",
      biography = "Instituida por San Pío V en acción de gracias por la victoria de la armada cristiana en Lepanto en 1571 mientras el pueblo fiel rezaba el Rosario. El Santo Rosario es compendio del Evangelio y arma celestial de conversión y paz familiar.",
      patronage = "Rezadores del Rosario, la Orden Dominica y la victoria sobre el mal",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen del Santo Rosario, dulce Madre de Dios, ata nuestras vidas a tu corazón con los misterios sagrados del Rosario y llena de paz a nuestras familias."
    ),
    Pair(10, 8) to SaintTemplate(
      title = "Santa Pelagia de Antioquía",
      saintName = "Santa Pelagia de Antioquía, penitente",
      biography = "Famosa actriz y cortesana pagana de Antioquía en el siglo V de escandalosa vida. Al escuchar predicar al obispo San Nono sobre el Juicio Final, rompió a llorar amargamente arrepentida, se bautizó y vivió en penitencia solitaria en el Monte de los Olivos.",
      patronage = "Pecadores arrepentidos, actrices, penitentes y actores",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Pelagia penitente, que mostraste cómo la gracia transforma al pecador en flor de santidad, alcánzanos una sincera y radical conversión de vida."
    ),
    Pair(10, 9) to SaintTemplate(
      title = "San Dionisio de París y San Juan Leonardi",
      saintName = "San Dionisio, obispo y mártir, y San Juan Leonardi, presbítero",
      biography = "San Dionisio, primer obispo de París martirizado en Montmartre en el siglo III. San Juan Leonardi fundó los Clérigos Regulares de la Madre de Dios y fue cofundador del Colegio de Propaganda Fide en Roma.",
      patronage = "París, misioneros de Propaganda Fide y defensores de la fe",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Dionisio y Juan Leonardi, interceded por la evangelización del mundo para que la luz del Evangelio alcance a todos los pueblos."
    ),
    Pair(10, 10) to SaintTemplate(
      title = "Santo Tomás de Villanueva",
      saintName = "Santo Tomás de Villanueva, arzobispo de Valencia",
      biography = "Fraile agustino español del siglo XVI llamado «el Limosnero de Dios». Arzobispo de Valencia, dormía en una jergón de paja y destinaba todas sus rentas a dotar doncellas pobres, acoger expósitos y fundar colegios para huérfanos.",
      patronage = "Valencia, Villanueva de los Infantes y obras caritativas diocesanas",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santo Tomás de Villanueva, padre solícito de los desvalidos, alcánzanos desprendimiento de los bienes terrenales y amor entrañable a los pobres."
    ),
    Pair(10, 11) to SaintTemplate(
      title = "San Juan XXIII, papa",
      saintName = "San Juan XXIII, el Papa Bueno del Concilio Vaticano II",
      biography = "Angelo Giuseppe Roncalli, elegido Papa en 1958. Con humilde sencillez y bondad conquistó los corazones del mundo, convocando por inspiración del Espíritu Santo el Concilio Vaticano II y publicando la profética encíclica «Pacem in Terris».",
      patronage = "El Concilio Vaticano II, la paz universal y párrocos bondadosos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan XXIII, Papa Bueno, enséñanos a mirar al mundo con los ojos compasivos de Jesús y a ser sembradores incansables de bondad y fraternidad."
    ),
    Pair(10, 12) to SaintTemplate(
      title = "Nuestra Señora del Pilar",
      saintName = "Fiesta de Nuestra Señora del Pilar (Zaragoza y la Hispanidad)",
      biography = "Según antiquísima tradición, la Virgen María vino en carne mortal a orillas del Ebro en Zaragoza en el año 40 para confortar al Apóstol Santiago cuando se sentía desanimado, dejándole una columna de jaspe como signo imperecedero de su protección.",
      patronage = "Patrona de la Hispanidad, Guardia Civil, Zaragoza, Aragón y navegantes",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen del Pilar, columna firme de nuestra fe, conforta a los desalentados, bendice a las naciones hermanas de habla hispana y guíanos siempre a Jesús."
    ),
    Pair(10, 13) to SaintTemplate(
      title = "San Eduardo el Confesor",
      saintName = "San Eduardo el Confesor, rey de Inglaterra",
      biography = "Último rey anglosajón de Inglaterra antes de la conquista normanda. Amado por su pueblo por su justicia paternal, suplicó a Dios el perdón de sus enemigos y fundó la monumental Abadía de Westminster en Londres.",
      patronage = "Inglaterra, Westminster, reyes pacíficos y matrimonios difíciles",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Eduardo, rey humilde y piadoso, haz que quienes ostentan cargos de autoridad busquen el bien de los ciudadanos en el temor santo de Dios."
    ),
    Pair(10, 14) to SaintTemplate(
      title = "San Calixto I, papa y mártir",
      saintName = "San Calixto I, papa y mártir de las catacumbas",
      biography = "Antiguo esclavo que fue nombrado diácono por el Papa Ceferino para administrar las célebres catacumbas romanas de la Vía Apia (Catacumbas de San Calixto). Como Papa, acogió con infinita misericordia a los pecadores arrepentidos.",
      patronage = "Cementerios católicos, enterradores y pecadores arrepentidos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Calixto, pontífice de la divina misericordia, ruega por nosotros para que nunca cerremos las puertas del perdón a quien busca volver a Dios."
    ),
    Pair(10, 15) to SaintTemplate(
      title = "Santa Teresa de Jesús (Teresa de Ávila)",
      saintName = "Fiesta de Santa Teresa de Jesús, virgen y doctora de la Iglesia",
      biography = "Monja carmelita abulense del siglo XVI, cumbre del misticismo y primera mujer proclamada Doctora de la Iglesia. Reformó el Carmelo fundando diecisiete palomarcitos de descalzas y escribió «El Castillo Interior» y «Camino de Perfección».",
      patronage = "Escritores católicos, España, carmelitas y la oración contemplativa",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Nada te turbe, nada te espante, todo se pasa, Dios no se muda; la paciencia todo lo alcanza; quien a Dios tiene nada le falta: sólo Dios basta». Amén."
    ),
    Pair(10, 16) to SaintTemplate(
      title = "Santa Margarita María Alacoque y San Gerardo Mayela",
      saintName = "Santa Margarita María Alacoque, virgen, y San Gerardo Mayela, religioso",
      biography = "Santa Margarita María, monja de la Visitación en Paray-le-Monial a quien Jesús mostró su Corazón traspasado de amor por los hombres. San Gerardo Mayela, humilde redentorista italiano venerado como celestial protector de las parturientas.",
      patronage = "Margarita: Sagrado Corazón; Gerardo: madres embarazadas y recién nacidos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "¡Sagrado Corazón de Jesús, en Ti confío! Santa Margarita María, enséñanos a reparar la ingratitud del mundo con un amor incondicional a Cristo."
    ),
    Pair(10, 17) to SaintTemplate(
      title = "San Ignacio de Antioquía",
      saintName = "San Ignacio de Antioquía, obispo y mártir",
      biography = "Discípulo del apóstol San Juan y tercer obispo de Antioquía. Conducido encadenado a Roma bajo Trajano, escribió siete célebres cartas pastorales: «Soy trigo de Dios y he de ser molido por los dientes de las fieras para ser pan puro de Cristo».",
      patronage = "Unidad eclesial, martirio heroico y la Iglesia en Oriente",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "San Ignacio de Antioquía, trigo puro de Cristo triturado en el martirio, alcánzanos permanecer unidos a nuestros obispos en la caridad y la verdad."
    ),
    Pair(10, 18) to SaintTemplate(
      title = "San Lucas, evangelista",
      saintName = "Fiesta de San Lucas, evangelista y médico",
      biography = "Médico de Antioquía, compañero fidelísimo de San Pablo en sus viajes misioneros («Lucas, el médico querido, es el único que está conmigo»). Autor del tercer Evangelio (el Evangelio de la Misericordia y de la Virgen María) y de los Hechos de los Apóstoles.",
      patronage = "Médicos, cirujanos, pintores, artistas y sanitarios",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "San Lucas evangelista, que retrataste con ternura la compasión de Jesús y el corazón de María, bendice a los médicos para que sanen con amor cristiano."
    ),
    Pair(10, 19) to SaintTemplate(
      title = "Santos Juan de Brébeuf, Isaac Jogues y San Pablo de la Cruz",
      saintName = "Santos Mártires de América del Norte y San Pablo de la Cruz, fundador pasionista",
      biography = "Los jesuitas franceses Brébeuf y Jogues fueron atrozmente martirizados por los iroqueses en Canadá. San Pablo de la Cruz fundó los Pasionistas en el siglo XVIII para promover la memoria de la Pasión de Cristo.",
      patronage = "Canadá, misioneros en Norteamérica y la contemplación de la Pasión",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires y San Pablo de la Cruz, concedednos grabar en nuestras almas la bendita Pasión de Jesús como remedio para todos nuestros males."
    ),
    Pair(10, 20) to SaintTemplate(
      title = "San Pedro de Alcántara",
      saintName = "San Pedro de Alcántara, fraile franciscano penitente",
      biography = "Místico y reformador franciscano español del siglo XVI. Vivió en asombrosa penitencia (dormía hora y media sentado con la cabeza apoyada en un madero), consejero y confesor de Santa Teresa de Jesús en la reforma carmelitana.",
      patronage = "Extremadura, celadores nocturnos, penitentes y confesores",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro de Alcántara, maestro de austeridad evangélica, enséñanos a dominar nuestros caprichos para que el alma sea libre para amar a Dios."
    ),
    Pair(10, 21) to SaintTemplate(
      title = "Santa Úrsula y compañeras",
      saintName = "Santa Úrsula y compañeras mártires de Colonia",
      biography = "Princesa británica del siglo IV que peregrinó a Roma con un cortejo de jóvenes cristianas. A su regreso fueron interceptadas en Colonia por las huestes bárbaras de Atila, prefiriendo morir atravesadas por flechas antes que ceder su pureza.",
      patronage = "Estudiantes universitarias, educadoras ursulinas y Colonia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Úrsula y santas vírgenes mártires, interceded por la juventud femenina para que descubra la hermosura de la fidelidad a Cristo."
    ),
    Pair(10, 22) to SaintTemplate(
      title = "San Juan Pablo II, papa",
      saintName = "San Juan Pablo II, el Papa peregrino de la esperanza y la juventud",
      biography = "Karol Wojtyła, pontífice polaco de 1978 a 2005. Recorrió el planeta llevando a Cristo con su grito inaugural: «¡No tengáis miedo, abrid de par en par las puertas a Cristo!». Fundó las Jornadas Mundiales de la Juventud y sobrevivió al atentado de Fátima.",
      patronage = "Familias, Jornadas Mundiales de la Juventud, Polonia y la esperanza",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Pablo II, apóstol intrépido de la verdad y defensor heroico de la familia, ayúdanos a no tener miedo y a ser testigos de Cristo en el mundo."
    ),
    Pair(10, 23) to SaintTemplate(
      title = "San Juan de Capistrano",
      saintName = "San Juan de Capistrano, presbítero franciscano",
      biography = "Jurista italiano que ingresó a los Franciscanos tras una crisis interior. Predicador formidable por media Europa, a los setenta años lideró con la cruz en la mano a los ejércitos cristianos en la defensa de Belgrado contra el asedio turco en 1456.",
      patronage = "Capellanes militares, juristas y jueces",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan de Capistrano, que con la fuerza de la Cruz defendiste la cristiandad, infunde en nuestros corazones valor para combatir el buen combate de la fe."
    ),
    Pair(10, 24) to SaintTemplate(
      title = "San Antonio María Claret",
      saintName = "San Antonio María Claret, arzobispo y fundador de los Misioneros Claretianos",
      biography = "Tejedor catalán ordenado sacerdote, misionero popular incansable. Fundó los Misioneros Hijos del Inmaculado Corazón de María (Claretianos), fue arzobispo de Santiago de Cuba donde defendió a los esclavos y confesor de la reina Isabel II.",
      patronage = "Misioneros claretianos, tejedores, editores católicos y Cuba",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Antonio María Claret, encendido en el fuego del Corazón de María, concédenos propagar con valentía la Buena Nueva por medio de la buena prensa."
    ),
    Pair(10, 25) to SaintTemplate(
      title = "Santos Crispín y Crispiniano y San Frutos",
      saintName = "Santos Crispín y Crispiniano, mártires, y San Frutos de Segovia",
      biography = "Crispín y Crispiniano, nobles romanos que ejercieron el oficio de zapateros en Soissons para sostener a los pobres mientras les enseñaban la fe, martirizados bajo Maximiano. San Frutos, eremita segoviano en las hoces del río Duratón.",
      patronage = "Zapateros, curtidores, Segovia y trabajadores del calzado",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santos zapateros Crispín y Crispiniano, que santificasteis vuestro oficio manual, bendecid a los trabajadores para que obren con honradez y fe."
    ),
    Pair(10, 26) to SaintTemplate(
      title = "San Evaristo, papa y mártir",
      saintName = "San Evaristo, papa y mártir de Roma",
      biography = "Quinto sucesor de San Pedro en Roma a comienzos del siglo II, de ascendencia judía helenística. Asignó títulos parroquiales a los presbíteros romanos y dispuso la bendición solemne de los matrimonios cristianos.",
      patronage = "Pastores de la Iglesia, estabilidad pastoral y bodas cristianas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Evaristo papa, pastor solícito de la Iglesia en Roma, intercede por la santidad y fidelidad de los matrimonios que se unen en el Señor."
    ),
    Pair(10, 27) to SaintTemplate(
      title = "San Frumencio de Etiopía",
      saintName = "San Frumencio, obispo y apóstol de Etiopía",
      biography = "Náufrago cristiano en las costas del Mar Rojo en el siglo IV. Por su sabiduría y bondad llegó a ministro del reino de Axum; viajó a Alejandría y San Atanasio lo consagró obispo, bautizando al rey Ezana y convirtiendo a Etiopía entera.",
      patronage = "Etiopía y misioneros en el Cuerno de África",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Frumencio, que llevaste la luz de Cristo a las tierras de Etiopía, haz que en todos los pueblos germine el Evangelio de la salvación."
    ),
    Pair(10, 28) to SaintTemplate(
      title = "Santos Simón y Judas Tadeo, apóstoles",
      saintName = "Fiesta de los Santos Simón y Judas Tadeo, apóstoles",
      biography = "Simón el Cananeo (Zelotes), apasionado por la Ley de Dios; Judas Tadeo, hermano de Santiago el Menor y autor de la Epístola de Judas («¿Por qué te manifiestas a nosotros y no al mundo?»). Mártires gloriosos en Persia; San Judas es el abogado universal de causas difíciles.",
      patronage = "Causas difíciles, desesperadas y perdidas, fabricantes de paños y curtidores",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Glorioso Apóstol San Judas Tadeo, fiel siervo y amigo de Jesús, socórreme en esta necesidad angustiosa y alcánzanos una fe invencible en las promesas del Señor."
    ),
    Pair(10, 29) to SaintTemplate(
      title = "San Narciso de Jerusalén",
      saintName = "San Narciso, patriarca de Jerusalén",
      biography = "Venerable obispo de Jerusalén en el siglo II que gobernó su sede hasta superar los cien años. Calumniado vilmente por hombres impíos, se retiró al desierto perdonándolos, hasta que la divina justicia vindicó su inocencia y fue restituido con júbilo.",
      patronage = "Víctimas de calumnias y ancianos venerables",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Narciso, que con tu paciencia heroica venciste las insidias de la falsedad, consuela a quienes sufren acusaciones injustas en el mundo."
    ),
    Pair(10, 30) to SaintTemplate(
      title = "San Marcelo el Centurión",
      saintName = "San Marcelo el Centurión, mártir de León",
      biography = "Oficial de la legión romana estacionada en León (España). Durante los festejos del cumpleaños del emperador Maximiano, arrojó públicamente sus armas y condecoraciones militares proclamando: «Soy soldado de Jesucristo, no puedo servir a vuestros dioses».",
      patronage = "León, objetores de conciencia por la fe y militares cristianos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Marcelo mártir, que antepusiste la lealtad a Cristo a todos los ascensos mundanos, danos firmeza para no pactar con el pecado."
    ),
    Pair(10, 31) to SaintTemplate(
      title = "San Alfonso Rodríguez",
      saintName = "San Alfonso Rodríguez, religioso jesuita",
      biography = "Comerciante segoviano que tras la muerte dolorosa de su esposa e hijos ingresó como hermano lego en la Compañía de Jesús a los cuarenta años. Portero del colegio de Mallorca durante cuatro décadas, abría la puerta diciendo: «¡Ya voy, Señor!». Fue guía espiritual de San Pedro Claver.",
      patronage = "Porteros, personas que sufren duelos familiares y la humildad en el servicio",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Alfonso Rodríguez, que veías en cada persona que llamaba a tu puerta al mismo Cristo, enséñanos a acoger al prójimo con amor reverente."
    ),

    // ==========================================
    // NOVIEMBRE (30 días)
    // ==========================================
    Pair(11, 1) to SaintTemplate(
      title = "Todos los Santos",
      saintName = "Solemnidad de Todos los Santos",
      biography = "Celebramos con júbilo celestial a la multitud innumerable de los santos de toda tribu, lengua y nación que contemplan a Dios cara a cara en el Cielo: no solo los canonizados, sino tantos padres, madres, jóvenes y humildes servidores fieles a Cristo.",
      patronage = "Toda la Iglesia peregrina, santidad universal y el Reino celestial",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "Dios todopoderoso y eterno, que nos concedes celebrar en una sola fiesta los méritos de todos los Santos, concédenos, por su multitudinaria intercesión, la anhelada santidad de vida."
    ),
    Pair(11, 2) to SaintTemplate(
      title = "Conmemoración de los Fieles Difuntos",
      saintName = "Conmemoración de Todos los Fieles Difuntos (Día de las Ánimas)",
      biography = "La Iglesia peregrina en la tierra abraza en sufragio de caridad a las almas benditas del Purgatorio que se purifican antes de entrar a la gloria. Mediante la Santa Misa, indulgencias y oraciones suplicamos que alcancen el descanso eterno.",
      patronage = "Benditas almas del Purgatorio, difuntos familiares y orantes por los muertos",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.MORADO,
      prayer = "«Dales, Señor, el descanso eterno, y brille para ellos la luz perpetua. Que las almas de todos los fieles difuntos, por la misericordia de Dios, descansen en paz». Amén."
    ),
    Pair(11, 3) to SaintTemplate(
      title = "San Martín de Porres (Fray Escoba)",
      saintName = "San Martín de Porres, hermano lego dominico",
      biography = "Religioso mulato de Lima del siglo XVII hijo de noble español y esclava liberta panameña. Con su humilde escoba sanaba enfermos de toda condición, daba de comer a los necesitados e incluso amansaba en un mismo plato a perros, gatos y ratones con inmensa caridad.",
      patronage = "Justicia racial, barberos, barrenderos, farmacéuticos, Perú y animales",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Martín de Porres, Fray Escoba de la caridad y la humildad sin límites, alcánzanos tu corazón puro para servir a los más pobres sin distinción alguna."
    ),
    Pair(11, 4) to SaintTemplate(
      title = "San Carlos Borromeo",
      saintName = "San Carlos Borromeo, arzobispo de Milán y cardenal",
      biography = "Gigante de la Contrarreforma católica en el siglo XVI. Sobrino del Papa Pío IV, concluyó y aplicó el Concilio de Trento, redactó el Catecismo Romano, fundó seminarios para el clero y vendió su vajilla de plata para dar de comer a los apestados de Milán.",
      patronage = "Seminarios, catequistas, obispos reformadores, Milán y directores espirituales",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Carlos Borromeo, modelo de pastor según el Evangelio, infunde en nuestros obispos y sacerdotes celo incansable por la salvación de las almas."
    ),
    Pair(11, 5) to SaintTemplate(
      title = "Santos Zacarías e Isabel",
      saintName = "Santos Zacarías e Isabel, padres de San Juan Bautista",
      biography = "El sacerdote Zacarías y su esposa Isabel vivieron «irreprochables según todos los mandamientos del Señor». En su ancianidad recibieron el milagro de concebir al Precursor, entonando Zacarías el cántico del Benedictus e Isabel el «¡Bendita tú entre las mujeres!» a María.",
      patronage = "Matrimonios ancianos, mujeres estériles y padres de sacerdotes",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santos Zacarías e Isabel, que esperasteis con santa paciencia el cumplimiento de las promesas de Dios, conceded fe inquebrantable a nuestras familias."
    ),
    Pair(11, 6) to SaintTemplate(
      title = "San Severo de Barcelona",
      saintName = "San Severo, obispo de Barcelona y mártir",
      biography = "Obispo barcelonés del siglo IV. Durante la persecución de Diocleciano huyó para no dejar a su rebaño sin pastor, pero al ver martirizar a los cristianos se entregó voluntariamente al gobernador Daciano, siendo martirizado traspasándole la cabeza con clavos.",
      patronage = "Barcelona, tejedores y firmeza pastoral",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Severo obispo, que diste tu vida por alentar la fe de tu grey, protege a nuestras diócesis de las asechanzas del mal."
    ),
    Pair(11, 7) to SaintTemplate(
      title = "San Willibrordo",
      saintName = "San Willibrordo, obispo y apóstol de los Países Bajos",
      biography = "Monje benedictino inglés del siglo VII enviado por el Papa Sergio I para evangelizar a los frisones y holandeses. Fundó la abadía de Echternach en Luxemburgo y la sede primada de Utrecht, extirpando el paganismo con mansedumbre santa.",
      patronage = "Países Bajos, Luxemburgo, Utrecht y enfermos de epilepsia",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Willibrordo, misionero incansable de Cristo en el norte de Europa, reaviva la fe en las naciones de tradición cristiana."
    ),
    Pair(11, 8) to SaintTemplate(
      title = "Los Cuatro Santos Coronados",
      saintName = "Los Cuatro Santos Mártires Coronados de Roma",
      biography = "Escultores cristianos de Panonia (Claudio, Nicóstrato, Sinforiano y Castorio) en el siglo IV. Artistas insignes, se negaron rotundamente a esculpir una estatua del dios Esculapio para Diocleciano, siendo encerrados vivos en cajas de plomo y arrojados al río.",
      patronage = "Escultores, albañiles, canteros, picapedreros y artistas plásticos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Cuatro Coronados, que supisteis que ningún arte es verdadero si glorifica la falsedad, bendecid a los artistas para que eleven las almas hacia Dios."
    ),
    Pair(11, 9) to SaintTemplate(
      title = "Dedicación de la Basílica de Letrán",
      saintName = "Fiesta de la Dedicación de la Basílica de San Juan de Letrán",
      biography = "Catedral del Papa como Obispo de Roma, llamada «Madre y Cabeza de todas las iglesias de la Urbe y del Orbe». Donada por Constantino, esta fiesta celebra la unidad visible de la Iglesia Católica universal en torno a la Sede de Pedro.",
      patronage = "La Cátedra papal, la unidad de la Iglesia y los templos católicos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios nuestro, que con piedras vivas y elegidas preparas una morada eterna para tu gloria, acrecienta en tu Iglesia los dones del Espíritu Santo."
    ),
    Pair(11, 10) to SaintTemplate(
      title = "San León Magno, papa y doctor",
      saintName = "San León Magno, papa y doctor de la Iglesia",
      biography = "Pontífice del siglo V que con su célebre Carta a Flaviano (Tomus ad Flavianum) definió en el Concilio de Calcedonia las dos naturalezas en la única persona de Cristo. Salió desarmado al encuentro de Atila el Huno, deteniendo milagrosamente su invasión sobre Roma.",
      patronage = "Papas, diplomáticos de la paz, Roma y defensores de la ortodoxia",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Dios todopoderoso, que edificaste a tu Iglesia sobre la firmeza de la roca apostólica, guárdala siempre en la verdad por intercesión de San León Magno."
    ),
    Pair(11, 11) to SaintTemplate(
      title = "San Martín de Tours",
      saintName = "San Martín de Tours, obispo de la caridad",
      biography = "Soldado romano en Amiens que en un crudo invierno partió su manto militar en dos con su espada para cubrir a un mendigo tiritando de frío; esa noche vio en sueños a Cristo revestido con su medio manto. Bautizado y hecho monje, fue obispo de Tours.",
      patronage = "Soldados, pobres, jinetes, tejedores, sastres y Francia",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Martín de Tours, que viste a Jesucristo en el pobre harapiento del camino, abre nuestros ojos para compartir con alegría lo que tenemos con los necesitados."
    ),
    Pair(11, 12) to SaintTemplate(
      title = "San Josafat, obispo y mártir",
      saintName = "San Josafat Kuncewicz, obispo y mártir de la unidad",
      biography = "Monje basiliano y arzobispo greco-católico de Pólotsk (Bielorrusia/Ucrania) en el siglo XVII. Dedicó su vida a promover la unión de la Iglesia eslava oriental con la Sede de Roma (Unión de Brest), siendo asesinado por fanáticos cismáticos.",
      patronage = "La unidad ecuménica de los cristianos, Ucrania y Bielorrusia",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Señor, que derramaste en San Josafat el celo santo por la unidad de tu Iglesia, haz que todos los cristianos seamos un solo rebaño bajo un solo Pastor."
    ),
    Pair(11, 13) to SaintTemplate(
      title = "San Diego de Alcalá y Santa Francisca Javiera Cabrini",
      saintName = "San Diego de Alcalá, fraile lego, y Santa Francisca Javiera Cabrini",
      biography = "San Diego de Alcalá, humilde hermano lego franciscano taumaturgo en Sevilla, Roma y Alcalá. Santa Francisca Cabrini, primera ciudadana estadounidense canonizada, madre de los inmigrantes en Nueva York y fundadora de sesenta y siete obras sociales.",
      patronage = "Diego: franciscanos y pobres; Cabrini: inmigrantes y refugiados",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Diego de Alcalá y Santa Francisca Cabrini, interceded por los inmigrantes y los humildes para que encuentren pan, acogida y la dignidad del Evangelio."
    ),
    Pair(11, 14) to SaintTemplate(
      title = "San José Pignatelli y San Serapión",
      saintName = "San José Pignatelli, restaurador jesuita, y San Serapión mártir",
      biography = "San José Pignatelli, jesuita aragonés que en el siglo XVIII mantuvo encendida la llama de la Compañía de Jesús durante sus cuarenta años de supresión. San Serapión, soldado cruzado inglés e ilustre mártir mercedario crucificado en Argel por rescatar cautivos.",
      patronage = "Jesuítas, cautivos, presos y perseverancia en el dolor",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San José Pignatelli y San Serapión, que en medio de persecuciones permanecisteis fieles a vuestra vocación, alcánzanos fidelidad perenne al Señor."
    ),
    Pair(11, 15) to SaintTemplate(
      title = "San Alberto Magno",
      saintName = "San Alberto Magno, obispo y doctor de la Iglesia (Doctor Universal)",
      biography = "Fraile dominico alemán del siglo XIII, una de las mentes científicas y teológicas más prodigiosas de la cristiandad. Maestro de Santo Tomás de Aquino en París y Colonia, integró la botánica, zoología y física con la contemplación mística de Dios.",
      patronage = "Científicos católicos, estudiantes de ciencias naturales y químicos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Alberto Magno, Doctor Universal, enséñanos a admirar la huella del Creador en las maravillas de la naturaleza y a poner la ciencia al servicio del bien."
    ),
    Pair(11, 16) to SaintTemplate(
      title = "Santa Margarita de Escocia y Santa Gertrudis la Magna",
      saintName = "Santa Margarita de Escocia y Santa Gertrudis, virgen mística",
      biography = "Santa Margarita, reina santa de caridad insigne. Santa Gertrudis la Magna, monja benedictina alemana del siglo XIII, precursora mística de la devoción al Sagrado Corazón de Jesús («El Heraldo del amor divino»).",
      patronage = "Gertrudis: almas del purgatorio y devotos del Sagrado Corazón",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Gertrudis la Magna, que escuchaste los latidos del Corazón divino de Jesús, sumerge nuestras vidas en el océano de su misericordia infinita."
    ),
    Pair(11, 17) to SaintTemplate(
      title = "Santa Isabel de Hungría",
      saintName = "Santa Isabel de Hungría, princesa de los pobres",
      biography = "Hija del rey de Hungría y esposa del landgrave de Turingia. Tras enviudar muy joven, vistió el sayal franciscano consagrando su inmensa fortuna a edificar un hospital en Marburgo donde ella misma lavaba las llagas de los leprosos.",
      patronage = "Caritas, obras de caridad católica, viudas, panaderos y terciarios franciscanos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Isabel de Hungría, que transformaste tu alcurnia en servicio abnegado a los más enfermos y necesitados, enséñanos a amar a Jesús en los pobres."
    ),
    Pair(11, 18) to SaintTemplate(
      title = "Dedicación de las Basílicas de San Pedro y San Pablo",
      saintName = "Dedicación de las Basílicas de los Santos Apóstoles Pedro y Pablo en Roma",
      biography = "Conmemoración de la erección de las dos basílicas patriarcales romanas levantadas por el emperador Constantino en el siglo IV sobre las tumbas de San Pedro en la Colina Vaticana y de San Pablo en la Vía Ostiense.",
      patronage = "Los santos apóstoles, Roma y la comunión apostólica universal",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, protege a tu Iglesia bajo el patrocinio constante de tus apóstoles Pedro y Pablo, que la fecundaron con su predicación y su sangre mártir."
    ),
    Pair(11, 19) to SaintTemplate(
      title = "San Abdías, profeta",
      saintName = "San Abdías, profeta del Antiguo Testamento",
      biography = "Profeta bíblico que proclamó la justicia ineludible de Dios sobre las naciones arrogantes y la salvación mesiánica del pueblo elegido en el Monte Sión: «Y el Reino será del Señor».",
      patronage = "Profetas bíblicos y defensores de la justicia divina",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor Dios de los profetas, purifica nuestros pensamientos para que busquemos únicamente el triunfo de tu Reino de justicia, amor y paz."
    ),
    Pair(11, 20) to SaintTemplate(
      title = "San Félix de Valois",
      saintName = "San Félix de Valois, ermitaño y cofundador de los Trinitarios",
      biography = "Príncipe de sangre real francesa que se retiró a los bosques de Meaux como solitario. Junto a San Juan de Mata fundó la Orden de la Santísima Trinidad para la redención de cautivos cristianos en tierras sarracenas.",
      patronage = "La Orden Trinitaria, redención de esclavos y presos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Félix de Valois, heraldo de la Santa Trinidad en el rescate de los cautivos, socorre a quienes sufren cadenas de injusticia en el mundo."
    ),
    Pair(11, 21) to SaintTemplate(
      title = "Presentación de la Virgen María",
      saintName = "Memoria de la Presentación de la Santísima Virgen María en el Templo",
      biography = "Celebra la entrega total y consagración incondicional de la Niña María a Dios en el Templo de Jerusalén. Desde el alba de su existencia, María se ofreció como templo vivo e inmaculado donde habitaría el Verbo Encarnado.",
      patronage = "Monjas contemplativas de clausura (Jornada Pro Orantibus) y vidas consagradas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa María, que en el Templo te consagraste por entero a Dios, bendice a las religiosas contemplativas que sostienen al mundo con su oración oculta."
    ),
    Pair(11, 22) to SaintTemplate(
      title = "Santa Cecilia, virgen y mártir",
      saintName = "Santa Cecilia, virgen y patrona universal de la música",
      biography = "Noble romana del siglo III que consagró su virginidad a Cristo; el día de su matrimonio con Valeriano cantaba en su corazón al Señor diciendo: «Consérvese puro mi corazón». Convirtió a su esposo y a su cuñado; fue degollada en su casa confesando la Trinidad.",
      patronage = "Músicos, cantantes, compositores, coros parroquiales y organistas",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Cecilia, que alabaste al Señor con la música del corazón y la melodía del martirio, bendice a nuestros músicos para que canten a la gloria de Dios."
    ),
    Pair(11, 23) to SaintTemplate(
      title = "San Clemente I y San Columbano",
      saintName = "San Clemente I, papa mártir, y San Columbano, abad misionero",
      biography = "San Clemente, tercer sucesor de Pedro, autor de la famosa Carta a los Corintios; desterrado a Crimea y arrojado al mar atado a un ancla. San Columbano, vigoroso monje irlandés que evangelizó Francia, Suiza e Italia fundando Bobbio.",
      patronage = "Clemente: marineros y picapedreros; Columbano: motociclistas e Irlanda",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Clemente y Columbano, que sembrasteis el Evangelio con ardor monástico y sangre martirial, fortaleced la fe de nuestras comunidades."
    ),
    Pair(11, 24) to SaintTemplate(
      title = "Santos Andrés Dung-Lac y compañeros mártires",
      saintName = "San Andrés Dung-Lac y 116 compañeros mártires de Vietnam",
      biography = "Obispos, sacerdotes y laicos vietnamitas martirizados entre los siglos XVII y XIX bajo atroces tormentos (decapitados, descuartizados, estrangulados). Andrés Dung-Lac cambió su nombre para continuar administrando los sacramentos en secreto.",
      patronage = "Vietnam, clero asiático y fortaleza ante la persecución",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santos mártires de Vietnam, semilla gloriosa de cristianos en Asia, alcanzad para la Iglesia en Oriente libertad para proclamar el Evangelio."
    ),
    Pair(11, 25) to SaintTemplate(
      title = "Santa Catalina de Alejandría",
      saintName = "Santa Catalina de Alejandría, virgen y mártir",
      biography = "Joven de extraordinaria sabiduría que en el siglo IV confundió con sus argumentos teológicos a cincuenta sabios filósofos enviados por el emperador Maximino, convirtiéndolos a todos. Condenada al suplicio de la rueda con cuchillas, ésta se quebró milagrosamente.",
      patronage = "Filósofos, estudiantes, muchachas solteras, abogados y carreteros",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Catalina de Alejandría, que uniste la sabiduría intelectual con la pureza inquebrantable de la fe, ayuda a nuestros jóvenes universitarios."
    ),
    Pair(11, 26) to SaintTemplate(
      title = "San Leonardo de Porto Mauricio",
      saintName = "San Leonardo de Porto Mauricio, presbítero franciscano",
      biography = "Fraile menor franciscano italiano del siglo XVIII, apodado el «gran predicador de Roma». Erigió más de quinientos Vía Crucis por toda Italia, entre ellos el célebre Vía Crucis del Coliseo romano bendecido por el Papa Benedicto XIV.",
      patronage = "Predicadores de misiones populares y devotos del Vía Crucis",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Leonardo de Porto Mauricio, apóstol del Vía Crucis, graba en nuestras almas el recuerdo constante de la Pasión de Cristo para amar la Cruz."
    ),
    Pair(11, 27) to SaintTemplate(
      title = "Nuestra Señora de la Medalla Milagrosa",
      saintName = "Nuestra Señora de la Medalla Milagrosa",
      biography = "El 27 de noviembre de 1830, en la capilla de la calle del Bac en París, la Virgen María se apareció a Santa Catalina Labouré, mostrándole el modelo de la Medalla Milagrosa con rayos de gracia brotando de sus manos y la jaculatoria santa.",
      patronage = "Enfermos, devotos de la Medalla Milagrosa y gracias espirituales",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«¡Oh María, sin pecado concebida, rogad por nosotros que recurrimos a Vos!». Derrama los rayos de tu gracia celestial sobre todos los que llevan tu medalla."
    ),
    Pair(11, 28) to SaintTemplate(
      title = "Santa Catalina Labouré y San Jaime de la Marca",
      saintName = "Santa Catalina Labouré, vidente de la Medalla Milagrosa, y San Jaime de la Marca",
      biography = "Santa Catalina Labouré pasó cuarenta y seis años en absoluto anonimato sirviendo a los ancianos desamparados tras recibir las apariciones de la Medalla Milagrosa. San Jaime de la Marca, gran predicador franciscano penitente del siglo XV.",
      patronage = "Hijas de la Caridad, ancianos y predicadores populares",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Catalina Labouré, modelo de humildad y silencio fecundo, enséñanos a trabajar por el Reino de Dios sin buscar el aplauso de los hombres."
    ),
    Pair(11, 29) to SaintTemplate(
      title = "San Saturnino de Tolosa",
      saintName = "San Saturnino (Sernin), obispo y mártir",
      biography = "Primer obispo de Tolosa (Francia) en el siglo III. Se negó a sacrificar en el capitolio pagano; enfurecida, la multitud lo ató por los pies a un toro salvaje que lo arrastró escaleras abajo destrozando su cráneo por confesar a Cristo.",
      patronage = "Tolosa, Navarra y amparo contra dolores de cabeza",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "San Saturnino mártir, que diste tu vida por proclamar la verdad a tu grey, alcánzanos firmeza inquebrantable en nuestras convicciones cristianas."
    ),
    Pair(11, 30) to SaintTemplate(
      title = "San Andrés, apóstol",
      saintName = "Fiesta de San Andrés, apóstol",
      biography = "Hermano de Simón Pedro y pescador de Betsaida. Discípulo del Bautista, al ver pasar a Jesús lo siguió de inmediato y corrió a decirle a su hermano: «¡Hemos encontrado al Mesías!». Evangelizó Grecia y fue crucificado en Patras en una cruz en forma de aspa (Cruz de San Andrés).",
      patronage = "Escocia, Grecia, Rusia, pescadores, solteronas y la Iglesia Ortodoxa",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "«¡Salve, oh Cruz santa, que recibiste los miembros de mi Señor Jesucristo!». San Andrés apóstol, alcánzanos amar la cruz y llevar a nuestros hermanos a Jesús."
    ),

    // ==========================================
    // DICIEMBRE (31 días)
    // ==========================================
    Pair(12, 1) to SaintTemplate(
      title = "San Carlos de Foucauld y San Eloy",
      saintName = "San Carlos de Foucauld, hermano universal del desierto, y San Eloy",
      biography = "San Carlos de Foucauld, aristócrata y explorador francés convertido que se retiró al desierto del Sahara viviendo en extrema pobreza y adoración eucarística entre los tuareg. San Eloy, orfebre real que llegó a obispo de Noyon en el siglo VII.",
      patronage = "Foucauld: el desierto, la adoración silenciosa; Eloy: orfebres, herreros y veterinarios",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«Padre mío, me pongo en tus manos, haz de mí lo que quieras; sea lo que sea, te doy las gracias». San Carlos de Foucauld, haznos hermanos universales."
    ),
    Pair(12, 2) to SaintTemplate(
      title = "Santa Bibiana (Viviana)",
      saintName = "Santa Bibiana, virgen y mártir romana",
      biography = "Doncella romana del siglo IV de noble familia cristiana martirizada bajo Juliano el Apóstata. Encerrada en una casa de mala reputación, guardó milagrosamente su pureza antes de ser atada a una columna y flagelada con plomadas hasta expirar.",
      patronage = "Enfermos de epilepsia, jaquecas, alcoholismo y pérdida del juicio",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Bibiana, mártir de la pureza y de la templanza, protege a los jóvenes de los vicios y alcánzanos una mente sana y equilibrada en Dios."
    ),
    Pair(12, 3) to SaintTemplate(
      title = "San Francisco Javier",
      saintName = "Fiesta de San Francisco Javier, presbítero jesuita y patrono de las misiones",
      biography = "Noble navarro y cofundador de la Compañía de Jesús («¿De qué le sirve al hombre ganar el mundo entero si pierde su alma?»). El «Gigante de las Misiones»: navegó miles de leguas bautizando a cientos de miles en India, Malaca y Japón; murió a las puertas de China.",
      patronage = "Patrono universal de las misiones católicas, Navarra, turismo y navegantes",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Francisco Javier, encendido en el fuego del amor misionero, suscita en la juventud cristiana el celo por llevar la luz de Cristo a todas las almas."
    ),
    Pair(12, 4) to SaintTemplate(
      title = "San Juan Damasceno y Santa Bárbara",
      saintName = "San Juan Damasceno, doctor de la Iglesia, y Santa Bárbara, mártir",
      biography = "San Juan Damasceno defendió con brillantez teológica la veneración de los santos iconos sagrados frente a los iconoclastas. Santa Bárbara, virgen mártir degollada por su propio padre pagano tras consagrarse a la Santísima Trinidad.",
      patronage = "Bárbara: artilleros, mineros, bomberos y contra rayos; Damasceno: pintores de iconos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Bárbara bendita, defiéndenos de las tempestades y de la muerte repentina; San Juan Damasceno, haz que veneremos a Dios en sus santos misterios."
    ),
    Pair(12, 5) to SaintTemplate(
      title = "San Sabas abad",
      saintName = "San Sabas, abad en Tierra Santa",
      biography = "Monje capadocio del siglo V que fundó en el desierto de Judea la célebre Gran Laura (monasterio de Mar Saba). Hombre de oración penitente y de diplomacia santa ante los emperadores en defensa del Concilio de Calcedonia.",
      patronage = "Tierra Santa, monjes eremitas y pacificación de conflictos",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Sabas abad, que floreciste en el desierto como palma de virtud, custodia a los cristianos que habitan en los Santos Lugares."
    ),
    Pair(12, 6) to SaintTemplate(
      title = "San Nicolás de Bari",
      saintName = "San Nicolás de Bari, obispo de Mira",
      biography = "Obispo de Mira (Asia Menor) en el siglo IV famoso por su bondad universal con los niños y pobres. Proporcionó secretamente tres bolsas de oro como dote a tres doncellas pobres para salvarlas de la deshonra; defendió la fe en Nicea.",
      patronage = "Niños, marineros, Grecia, Rusia, novias, prestamistas y cautivos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Nicolás de Bari, padre bondadoso de los niños y socorro en la necesidad, infunde en nuestros corazones generosidad para compartir con los necesitados."
    ),
    Pair(12, 7) to SaintTemplate(
      title = "San Ambrosio de Milán",
      saintName = "San Ambrosio, obispo de Milán y doctor de la Iglesia",
      biography = "Gobernador romano aclamado obispo de Milán cuando aún era catecúmeno en el año 374. Administró con sabiduría pastoral, defendió la libertad de la Iglesia ante emperadores, compuso sublimes himnos litúrgicos y bautizó a San Agustín.",
      patronage = "Milán, apicultores, obispos, predicadores y fabricantes de cera",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Ambrosio de Milán, pastor intrépido y doctor de la verdad católica, haz que sepamos defender la fe con sabiduría y dulzura evangélica."
    ),
    Pair(12, 8) to SaintTemplate(
      title = "La Inmaculada Concepción",
      saintName = "Solemnidad de la Inmaculada Concepción de la Santísima Virgen María",
      biography = "Dogma proclamado por Pío IX en 1854: por singular gracia y privilegio de Dios omnipotente y en previsión de los méritos de Jesucristo, la Virgen María fue preservada inmune de toda mancha de pecado original desde el primer instante de su concepción.",
      patronage = "Patrona de España, Estados Unidos, Corea, Filipinas y de la orden franciscana",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "«Bendita sea tu pureza y eternamente lo sea, pues todo un Dios se recrea en tan graciosa belleza. A ti, celestial Princesa, Virgen Sagrada María, yo te ofrezco en este día alma, vida y corazón»."
    ),
    Pair(12, 9) to SaintTemplate(
      title = "San Juan Diego Cuauhtlatoatzin",
      saintName = "San Juan Diego, vidente del Tepeyac",
      biography = "Indígena chichimeca de México a quien la Virgen de Guadalupe se apareció en 1531 en el cerro del Tepeyac («¿Acaso no estoy yo aquí que soy tu Madre?»). Llevó en su humilde tilma las rosas de Castilla impresas con el rostro milagroso de la Virgen.",
      patronage = "Pueblos indígenas de América, laicos humildes y México",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan Diego, embajador sencillo de la Morenita del Tepeyac, alcánzanos una fe humilde y un amor filial entrañable hacia la Virgen de Guadalupe."
    ),
    Pair(12, 10) to SaintTemplate(
      title = "Nuestra Señora de Loreto",
      saintName = "Memoria de Nuestra Señora de Loreto (La Santa Casa de Nazaret)",
      biography = "Celebra la veneración de la humilde morada de piedra de Nazaret donde la Virgen María nació, recibió la Anunciación del Ángel y educó al Niño Jesús, trasladada milagrosamente según la tradición a las colinas de Loreto en Italia.",
      patronage = "Aviadores, pilotos, tripulaciones aéreas, viajeros por aire y familias",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Virgen de Loreto, en cuya Santa Casa habitó el Verbo Encarnado, bendice a nuestros hogares para que sean remanso de paz, oración y mutuo amor."
    ),
    Pair(12, 11) to SaintTemplate(
      title = "San Dámaso I, papa",
      saintName = "San Dámaso I, papa de las catacumbas",
      biography = "Pontífice hispano del siglo IV que encargó a su secretario San Jerónimo la traducción de la Vulgata. Descubrió, restauró y adornó las tumbas de los mártires en las catacumbas romanas grabando sublimes inscripciones métricas en mármol.",
      patronage = "Arqueólogos católicos, poetas de lápidas y las catacumbas de Roma",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Dámaso papa, amante devoto de los mártires de Cristo, enséñanos a honrar con piedad la memoria de los testigos de nuestra santa fe."
    ),
    Pair(12, 12) to SaintTemplate(
      title = "Nuestra Señora de Guadalupe",
      saintName = "Fiesta de Nuestra Señora de Guadalupe, Emperatriz de América",
      biography = "Aparición de la Madre de Dios en 1531 al indio San Juan Diego en México, reconciliando milagrosamente a dos mundos y dando origen a la mayor ola de conversiones cristianas de la historia. Imagen no hecha por mano humana que protege el continente americano.",
      patronage = "Emperatriz de América, Filipinas, defensa de la vida por nacer y madres gestantes",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "«¿No estoy yo aquí, que tengo el honor y la dicha de ser tu Madre?». Virgen de Guadalupe, Reina de la Paz, cuida a los niños no nacidos y bendice a nuestras familias."
    ),
    Pair(12, 13) to SaintTemplate(
      title = "Santa Lucía, virgen y mártir",
      saintName = "Santa Lucía de Siracusa, virgen y mártir",
      biography = "Joven doncella de Siracusa (Sicilia) en el siglo IV que repartió su cuantiosa dote a los pobres. Denunciada por su pretendiente pagano, fue degollada por confesar a Cristo sin que ni bueyes ni llamas pudieran moverla de su sitio.",
      patronage = "Enfermos de la vista, oftalmólogos, ciegos, modistas y fotógrafos",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.ROJO,
      prayer = "Santa Lucía, cuyo nombre evoca la luz de Dios, conserva sana la vista de nuestros ojos y alcánzanos la luz interior de la gracia para no tropezar en el mal."
    ),
    Pair(12, 14) to SaintTemplate(
      title = "San Juan de la Cruz",
      saintName = "San Juan de la Cruz, presbítero y doctor místico de la Iglesia",
      biography = "Fraile carmelita castellano del siglo XVI, cumbre de la lírica española y reformador del Carmelo descalzo junto a Santa Teresa. En la oscura prisión de Toledo compuso sus sublimes poemas («Cántico Espiritual», «Noche Oscura», «Llama de amor viva»).",
      patronage = "Poetas místicos españoles, la vida contemplativa y directores espirituales",
      rank = CelebrationRank.MEMORIA_OBLIGATORIA,
      color = LiturgicalColor.BLANCO,
      prayer = "«Al atardecer de la vida seremos examinados en el amor». San Juan de la Cruz, doctor místico, purifica nuestras almas para amar a Dios sin reservas."
    ),
    Pair(12, 15) to SaintTemplate(
      title = "Santa María Crucificada di Rosa",
      saintName = "Santa María Crucificada di Rosa, fundadora",
      biography = "Noble italiana de Brescia del siglo XIX que durante la epidemia de cólera fundó las Esclavas de la Caridad, atendiendo noche y día a los enfermos terminales y a los heridos en los campos de batalla de la guerra civil.",
      patronage = "Enfermeras de guerra, esclavas de la caridad y Brescia",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa María Crucificada, que encontraste en la Cruz de Jesús la fuerza para servir a los apestados, enciende en nosotros una caridad que no tema el sacrificio."
    ),
    Pair(12, 16) to SaintTemplate(
      title = "Santa Adelaida, emperatriz",
      saintName = "Santa Adelaida de Borgoña, emperatriz augusta",
      biography = "Emperatriz del Sacro Imperio en el siglo X y abuela de Otón III. Modelo de paciencia ante las intrigas cortesanas, perdonó a sus perseguidores y destinó las riquezas del imperio a erigir monasterios y saciar el hambre de los campesinos.",
      patronage = "Familias políticas difíciles, viudas, prisioneros y reinas santas",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Adelaida, que en medio de la corte viviste con el corazón puesto en el Cielo, alcánzanos serenidad y perdón ante las ofensas recibidas."
    ),
    Pair(12, 17) to SaintTemplate(
      title = "San Juan de Mata y San Daniel profeta",
      saintName = "San Juan de Mata, fundador de la Orden Trinitaria",
      biography = "Sacerdote provenzal del siglo XII a quien en su primera Misa se le apareció Cristo sosteniendo a dos cautivos, uno blanco y otro negro. Fundó con San Félix de Valois los Trinitarios para redimir cautivos cristianos mediante limosnas y rescates.",
      patronage = "Cautivos, presos políticos, redención y la Orden Trinitaria",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan de Mata, apóstol de la caridad redentora, libra a nuestros hermanos que sufren persecución y cautiverio por su fidelidad al Señor."
    ),
    Pair(12, 18) to SaintTemplate(
      title = "La Virgen de la Esperanza (Nuestra Señora de la O)",
      saintName = "Fiesta de Nuestra Señora de la Esperanza (La Expectación del Parto)",
      biography = "Conmemoración antiquísima hispana de la dulce espera de la Virgen María en los últimos días de su gestación, anhelando dar a luz al Redentor del mundo. Coincide con las grandes Antífonas de la O del Adviento («¡Oh Sabiduría!», «¡Oh Emmanuel!»).",
      patronage = "Madres gestantes, partos inminentes, la esperanza cristiana y Sevilla",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "¡Oh Virgen de la Esperanza, Madre del Adviento bendito!, prepara nuestros corazones para acoger al Divino Niño Jesús en la Noche Santa de Navidad."
    ),
    Pair(12, 19) to SaintTemplate(
      title = "San Urbano V, papa",
      saintName = "Beato Urbano V, papa benedictino",
      biography = "Monje y abad benedictino elegido Papa en Aviñón en el siglo XIV. Austero en su celda papal, intentó restablecer la sede en Roma y promovió con pasión los estudios teológicos y la paz entre los príncipes cristianos.",
      patronage = "Monjes benedictinos, reformadores papales y Avignon",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "Señor, que concediste a Urbano V gobernar a tu Iglesia con espíritu monástico y humilde, haz florecer en el pueblo cristiano la piedad sincera."
    ),
    Pair(12, 20) to SaintTemplate(
      title = "San Domingo de Silos",
      saintName = "San Domingo de Silos, abad benedictino",
      biography = "Pastor riojano y abad del monasterio de Silos en el siglo XI. Restauró el cenobio en ruinas y liberó a más de trescientos cautivos cristianos con sus oraciones. Siglos después, la madre de Santo Domingo de Guzmán oró ante su sepulcro antes de concebir.",
      patronage = "Silos, Burgos, cautivos, partos seguros y vida monástica",
      rank = CelebrationRank.FERIAL,
      color = LiturgicalColor.BLANCO,
      prayer = "San Domingo de Silos, maestro de la alabanza divina y socorro de cautivos, alcánzanos una oración perseverante que rompa las cadenas del pecado."
    ),
    Pair(12, 21) to SaintTemplate(
      title = "San Pedro Canisio",
      saintName = "San Pedro Canisio, presbítero jesuita y doctor de la Iglesia",
      biography = "El «Segundo Apóstol de Alemania». Jesuita holandés del siglo XVI que recorrió Centroeuropa a pie defendiendo la fe católica frente a la Reforma. Escribió el célebre Catecismo católico traducido a docenas de idiomas y fundó numerosos colegios.",
      patronage = "Catequistas, escritores católicos, Alemania y los Países Bajos",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Pedro Canisio, heraldo de la recta doctrina de la Iglesia, danos amor por la catequesis y fidelidad al Magisterio apostólico."
    ),
    Pair(12, 22) to SaintTemplate(
      title = "Santa Francisca Javiera Cabrini",
      saintName = "Santa Francisca Javiera Cabrini, patrona universal de los inmigrantes",
      biography = "Religiosa italiana que fundó las Misioneras del Sagrado Corazón. Enviada por León XIII a América («No a Oriente, sino a Occidente»), cruzó veintiocho veces el océano fundando orfanatos, escuelas y hospitales para millones de inmigrantes.",
      patronage = "Inmigrantes, refugiados, viajeros, huérfanos y administradores hospitalarios",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "Santa Francisca Cabrini, madre entrañable de los desarraigados y migrantes, protege a las familias que dejan su patria buscando un porvenir digno."
    ),
    Pair(12, 23) to SaintTemplate(
      title = "San Juan de Kety (Cancio)",
      saintName = "San Juan de Kety, presbítero y profesor universitario",
      biography = "Profesor de Sagrada Escritura en la Universidad Jagellónica de Cracovia en el siglo XV. Famoso por su humildad y caridad extrema: regalaba sus ropas a los mendigos en la nieve y peregrinó cuatro veces a pie a Roma cargando sus pertenencias.",
      patronage = "Cracovia, Polonia, profesores universitarios y estudiantes",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan de Kety, que uniste la ciencia teológica con la caridad más desinteresada hacia los pobres, enséñanos a vivir con sencillez evangélica."
    ),
    Pair(12, 24) to SaintTemplate(
      title = "Los Santos Antepasados de Jesús (Nochebuena)",
      saintName = "Conmemoración de Todos los Santos Antepasados de Jesucristo y Vigilia de Navidad",
      biography = "En la víspera bendita del Nacimiento del Señor, la Iglesia conmemora a los patriarcas, reyes y justos del Antiguo Testamento (Adán, Abrahán, David, Isaías) que esperaron con ardiente fe la venida del Mesías esperado de las naciones.",
      patronage = "Familias en la Nochebuena, la espera mesiánica y la paz en el hogar",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "¡Ven, Señor Jesús, no tardes más! Purifica nuestros hogares y llena de paz nuestros corazones en esta Noche Santa en que la luz de tu amor disipa las tinieblas."
    ),
    Pair(12, 25) to SaintTemplate(
      title = "La Natividad del Señor",
      saintName = "Solemnidad de la Natividad de Nuestro Señor Jesucristo (Santa Navidad)",
      biography = "«Y el Verbo se hizo carne y habitó entre nosotros». El Creador del Universo nace como un tierno niño en la pobreza de un establo en Belén, envuelto en pañales y recostado en un pesebre por la Virgen María, trayendo la salvación eterna al mundo.",
      patronage = "Toda la humanidad, la paz mundial, los recién nacidos y los pobres",
      rank = CelebrationRank.SOLEMNIDAD,
      color = LiturgicalColor.BLANCO,
      isHolyDay = true,
      prayer = "¡Gloria a Dios en el cielo y en la tierra paz a los hombres que ama el Señor! Dulce Niño Jesús de Belén, nace de nuevo en nuestros corazones con tu divina paz."
    ),
    Pair(12, 26) to SaintTemplate(
      title = "San Esteban, protomártir",
      saintName = "Fiesta de San Esteban, diácono y protomártir",
      biography = "Uno de los siete primeros diáconos de Jerusalén. Lleno de gracia y de poder del Espíritu Santo, contempló los cielos abiertos antes de ser lapidado por el Sanedrín, muriendo de rodillas mientras oraba: «Señor, no les tomes en cuenta este pecado».",
      patronage = "Diáconos, canteros, albañiles y perdón a los enemigos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "San Esteban protomártir, que moriste perdonando a tus lapidadores a imitación de Cristo, alcánzanos un corazón libre de rencor y generoso para perdonar."
    ),
    Pair(12, 27) to SaintTemplate(
      title = "San Juan, apóstol y evangelista",
      saintName = "Fiesta de San Juan, apóstol y evangelista",
      biography = "El «discípulo a quien Jesús amaba». Reclinó su cabeza en el pecho del Maestro en la Última Cena y permaneció firme al pie de la Cruz, recibiendo a María como Madre de manos del Salvador. Escribió el cuarto Evangelio, tres epístolas y el Apocalipsis.",
      patronage = "Teólogos, escritores, amistad cristiana, Asia Menor y la devoción al Corazón de Jesús",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "San Juan apóstol y evangelista, que contemplaste el misterio inefable del Verbo de Vida, enséñanos a amar a Jesús y a María como tú los amaste."
    ),
    Pair(12, 28) to SaintTemplate(
      title = "Los Santos Inocentes, mártires",
      saintName = "Fiesta de los Santos Inocentes, mártires",
      biography = "Los tiernos niños de Belén menores de dos años degollados por la crueldad tiránica de Herodes para intentar matar al recién nacido Rey de los Judíos. Confesaron a Cristo no con sus palabras, sino con su sangre derramada en los albores de la redención.",
      patronage = "Niños no nacidos, infancia desvalida, huérfanos y monaguillos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.ROJO,
      prayer = "Santos Niños Inocentes, primicias de los mártires de Cristo, defended la vida sagrada de todos los niños por nacer y erradicad la violencia de la tierra."
    ),
    Pair(12, 29) to SaintTemplate(
      title = "San Tomás Becket, obispo y mártir",
      saintName = "San Tomás Becket, arzobispo de Canterbury y mártir",
      biography = "Canciller del rey Enrique II de Inglaterra consagrado arzobispo de Canterbury. Defendió con heroica firmeza la libertad de la Iglesia frente a las intromisiones del poder temporal, siendo asesinado por caballeros reales en su propia catedral en 1170.",
      patronage = "Clero secular, la libertad religiosa e Inglaterra",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.ROJO,
      prayer = "San Tomás Becket mártir, que no dudaste en entregar tu sangre por defender la libertad de la Iglesia de Dios, fortalece a nuestros pastores ante las presiones del mundo."
    ),
    Pair(12, 30) to SaintTemplate(
      title = "La Sagrada Familia de Nazaret",
      saintName = "Fiesta de la Sagrada Familia: Jesús, María y José",
      biography = "Hogar santísimo de Nazaret donde el Hijo de Dios creció en edad, sabiduría y gracia bajo la mirada virginal de María y el desvelo paternal de San José. Modelo perfecto e insustituible para todos los hogares cristianos de la tierra.",
      patronage = "Todas las familias del mundo, matrimonios, padres e hijos",
      rank = CelebrationRank.FIESTA,
      color = LiturgicalColor.BLANCO,
      prayer = "Jesús, María y José, en vosotros contemplamos el esplendor del verdadero amor. Sagrada Familia de Nazaret, haz que nuestros hogares sean remansos de comunión, oración y fidelidad."
    ),
    Pair(12, 31) to SaintTemplate(
      title = "San Silvestre I, papa",
      saintName = "San Silvestre I, papa (Fin de Año y Te Deum)",
      biography = "Pontífice durante el reinado de Constantino el Grande en el siglo IV. Vio nacer la paz de la Iglesia tras los siglos de catacumbas y confirmó los decretos del Concilio de Nicea (325). En la nochevieja se canta el himno Te Deum en acción de gracias a Dios.",
      patronage = "Fin de año, acción de gracias, albañiles y Roma",
      rank = CelebrationRank.MEMORIA_LIBRE,
      color = LiturgicalColor.BLANCO,
      prayer = "«A Ti, oh Dios, te alabamos; a Ti, Señor, te reconocemos». Gracias por todas las bendiciones recibidas a lo largo de este año y concédenos un año venidero lleno de tu paz y amor."
    )
  )
}
