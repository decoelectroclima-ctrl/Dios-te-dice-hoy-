package com.example.data

import com.example.model.DiosTeDiceMessage
import java.util.Calendar

object VerseRepository {

  val verses: List<DiosTeDiceMessage> = listOf(
    DiosTeDiceMessage(
      id = "isaias_41_10",
      citation = "Isaías 41:10",
      verseText = "«No temas, porque yo estoy contigo; no desmayes, porque yo soy tu Dios que te esfuerzo; siempre te ayudaré, siempre te sustentaré con la diestra de mi justicia.»",
      godSaysToday = "Hijo mío, no permitas que la ansiedad de lo que vendrá te robe la paz del presente. Yo camino a tu lado en cada hora de este día. Lo que parece imposible para tus fuerzas, está en mis manos omnipotentes. Suelta tus cargas y descansa en mi abrazo de Padre.",
      modernMeaning = "El miedo y el desánimo surgen cuando nos sentimos aislados o impotentes ante los problemas. Dios nos recuerda que su presencia no es una idea lejana, sino una compañía real que renueva nuestras fuerzas.",
      practicalApplication = "Hoy, cada vez que sientas prisa o agobio, haz una pausa de 30 segundos, respira hondo y repite en tu corazón: «Señor, confío en Ti; Tú vas delante de mí».",
      virtue = "Confianza",
      emoji = "🛡️"
    ),
    DiosTeDiceMessage(
      id = "mateo_11_28",
      citation = "San Mateo 11:28-29",
      verseText = "«Venid a mí todos los que estáis trabajados y cargados, y yo os haré descansar. Llevad mi yugo sobre vosotros y aprended de mí, que soy manso y humilde de corazón, y hallaréis descanso para vuestras almas.»",
      godSaysToday = "No tienes que sostener todo el peso del mundo solo. Conozco el cansancio de tu mente y las preocupaciones que guardas en silencio. Ven a mi Sagrado Corazón; permíteme ser tu refugio hoy. En mi mansedumbre encontrarás la serenidad que el mundo no puede darte.",
      modernMeaning = "El ajetreo moderno y las expectativas ajenas nos agotan interiormente. Cristo no nos impone pesadez, sino que nos invita a compartir nuestra vida con Él en humildad y verdad.",
      practicalApplication = "Dedica hoy diez minutos de silencio contemplativo, sin pantallas, entregándole a Jesús una preocupación puntual que te esté quitando el sueño.",
      virtue = "Paz",
      emoji = "🕊️"
    ),
    DiosTeDiceMessage(
      id = "filipenses_4_6",
      citation = "Filipenses 4:6-7",
      verseText = "«Por nada estéis afanosos, sino sean conocidas vuestras peticiones delante de Dios en toda oración y ruego, con acción de gracias. Y la paz de Dios, que sobrepasa todo entendimiento, guardará vuestros corazones y vuestros pensamientos en Cristo Jesús.»",
      godSaysToday = "Transforma tu preocupación en oración y tu incertidumbre en gratitud. Cuando me confías lo que te inquieta, te regalo mi paz: una calma profunda que ningún problema exterior puede quebrantar.",
      modernMeaning = "La ansiedad disminuye cuando aprendemos a agradecer por anticipado y a volcar nuestras necesidades ante Dios como hijos confiados.",
      practicalApplication = "Escribe o nombra tres cosas sencillas que recibiste hoy y da gracias a Dios por ellas antes de pedir nada más.",
      virtue = "Paz",
      emoji = "✨"
    ),
    DiosTeDiceMessage(
      id = "jeremias_29_11",
      citation = "Jeremías 29:11",
      verseText = "«Porque yo sé los pensamientos que tengo acerca de vosotros, dice el Señor, pensamientos de paz y no de mal, para daros el fin que esperáis.»",
      godSaysToday = "Aunque hoy no comprendas el rumbo de algunas circunstancias, no dudes de mi bondad. Mis planes para tu vida están tejidos de misericordia y esperanza. Nada en tu historia está fuera de mi mirada de amor.",
      modernMeaning = "Dios nunca improvisa con nuestra vida. Incluso en las demoras o contratiempos, su Providencia divina prepara caminos de gracia y madurez espiritual.",
      practicalApplication = "Acepta con una sonrisa o una plegaria interior cualquier imprevisto que cambie tus planes hoy, sabiendo que Dios cuida de ti.",
      virtue = "Esperanza",
      emoji = "🌱"
    ),
    DiosTeDiceMessage(
      id = "salmo_23_1",
      citation = "Salmo 23:1-3",
      verseText = "«El Señor es mi pastor; nada me faltará. En lugares de delicados pastos me hará descansar; junto a aguas de reposo me pastoreará. Confortará mi alma.»",
      godSaysToday = "Yo soy tu Buen Pastor. Conozco tu nombre, tus heridas y tus anhelos más íntimos. Nunca te dejaré en desamparo. Déjate guiar hoy por mi voz que susurra en tu interior.",
      modernMeaning = "Tener al Señor como pastor no significa ausencia de valles oscuros, sino la seguridad absoluta de que Él nos acompaña y renueva nuestra alma en cada tramo.",
      practicalApplication = "Camina hoy con la dignidad de quien se sabe cuidado por el Rey del Universo. Trata con bondad y serenidad a la primera persona que te cruces.",
      virtue = "Confianza",
      emoji = "🐑"
    ),
    DiosTeDiceMessage(
      id = "romanos_8_28",
      citation = "Romanos 8:28",
      verseText = "«Y sabemos que a los que aman a Dios, todas las cosas les ayudan a bien, esto es, a los que conforme a su propósito son llamados.»",
      godSaysToday = "Nada se pierde en mi corazón misericordioso. Aún tus errores pasados, tus lágrimas y los momentos difíciles son transformados por mi gracia en sabiduría, compasión y luz para otros. Confía en mi obra.",
      modernMeaning = "En el misterio de la fe, Dios tiene el poder de sacar bendición incluso de las pruebas más duras si permanecemos unidos a Él en el amor.",
      practicalApplication = "Recuerda una dificultad superada en el pasado y agradece la lección y fortaleza que Dios te dejó a través de ella.",
      virtue = "Fortaleza",
      emoji = "⚓"
    ),
    DiosTeDiceMessage(
      id = "juan_14_27",
      citation = "San Juan 14:27",
      verseText = "«La paz os dejo, mi paz os doy; yo no os la doy como el mundo la da. No se turbe vuestro corazón, ni tenga miedo.»",
      godSaysToday = "La paz del mundo depende de que todo salga perfecto; mi paz, en cambio, habita en medio de la tormenta. Si me tienes a mí, tienes todo lo necesario. Mantén tus ojos fijos en mi amor.",
      modernMeaning = "La paz de Cristo es un don espiritual interior inmutable, fundamentado en su victoria sobre el dolor, la soledad y la muerte.",
      practicalApplication = "Cuando sientas agitación en tu entorno laboral o familiar, sé portador de calma hablando con voz suave y paciencia.",
      virtue = "Paz",
      emoji = "🕯️"
    ),
    DiosTeDiceMessage(
      id = "josue_1_9",
      citation = "Josué 1:9",
      verseText = "«Mira que te mando que te esfuerces y seas valiente; no temas ni desmayes, porque el Señor tu Dios estará contigo en dondequiera que vayas.»",
      godSaysToday = "Levántate con valentía. No mires el tamaño del obstáculo, sino la grandeza de mi fidelidad. Yo derramo sobre ti el don de fortaleza del Espíritu Santo. Da el siguiente paso sin dudar.",
      modernMeaning = "La valentía cristiana no es temeridad, sino avanzar haciendo el bien guiados por la certeza de que Dios respalda nuestras obras justas.",
      practicalApplication = "Afronta hoy esa tarea o conversación pendiente que has estado postergando por temor o pereza.",
      virtue = "Fortaleza",
      emoji = "🔥"
    ),
    DiosTeDiceMessage(
      id = "corintios_13_4",
      citation = "1 Corintios 13:4-7",
      verseText = "«El amor es sufrido, es benigno; el amor no tiene envidia, el amor no es jactancioso, no se envanece; no hace nada indebido, no busca lo suyo, no se irrita, no guarda rencor... Todo lo sufre, todo lo cree, todo lo espera, todo lo soporta.»",
      godSaysToday = "Mírame en la Cruz y descubre la medida de mi amor por ti. Hoy te envío a ser mi reflejo para quienes te rodean: ama con paciencia, disculpa las faltas ajenas y derrama ternura donde haya aspereza.",
      modernMeaning = "El amor cristiano no es solo un sentimiento pasajero, sino una decisión diaria de querer el bien del prójimo y perdonar con generosidad.",
      practicalApplication = "Realiza hoy un gesto discreto de caridad o amabilidad hacia alguien que no te caiga bien o que no pueda retribuírtelo.",
      virtue = "Amor",
      emoji = "❤️"
    ),
    DiosTeDiceMessage(
      id = "mateo_6_33",
      citation = "San Mateo 6:33-34",
      verseText = "«Mas buscad primeramente el reino de Dios y su justicia, y todas estas cosas os serán añadidas. Así que, no os afanéis por el día de mañana, porque el día de mañana traerá su afán. Basta a cada día su propio mal.»",
      godSaysToday = "Pon a Dios en el centro de tus decisiones y verás cómo lo demás encuentra su justo orden. No te desgastes sufriendo por días que aún no existen. Vive la gracia de este día con plenitud.",
      modernMeaning = "Ordenar nuestras prioridades espirituales disipa la obsesión por el control y nos devuelve la libertad interior de los hijos de Dios.",
      practicalApplication = "Comienza tus tareas del día ofreciéndoselas a Dios con una pequeña jaculatoria: «Todo por Ti, Sagrado Corazón de Jesús».",
      virtue = "Confianza",
      emoji = "👑"
    ),
    DiosTeDiceMessage(
      id = "salmo_46_1",
      citation = "Salmo 46:1-2",
      verseText = "«Dios es nuestro amparo y fortaleza, nuestro pronto auxilio en las tribulaciones. Por tanto, no temeremos, aunque la tierra sea removida y se traspasen los montes al corazón del mar.»",
      godSaysToday = "Cuando todo a tu alrededor parezca tambalearse, recuerda que tu cimiento soy Yo, la Roca Eterna. En mi misericordia estás seguro. Respira mi gracia y mantente firme.",
      modernMeaning = "La seguridad verdadera no proviene del dinero o de las seguridades humanas, sino del amparo providente del Creador.",
      practicalApplication = "En momentos de tensión, haz mentalmente la señal de la cruz recordando que estás protegido bajo el manto del Padre.",
      virtue = "Fortaleza",
      emoji = "🏰"
    ),
    DiosTeDiceMessage(
      id = "colosenses_3_13",
      citation = "Colosenses 3:12-13",
      verseText = "«Vestíos, pues, como escogidos de Dios, santos y amados, de entrañable misericordia, de benignidad, de humildad, de mansedumbre, de paciencia; soportándoos con amor unos a otros, y perdonándoos unos a otros si alguno tuviere queja contra otro. De la manera que Cristo os perdonó, así también hacedlo vosotros.»",
      godSaysToday = "Perdonar es abrir la puerta de tu corazón a mi bendición. El rencor ata tu alma al pasado; el perdón te libera y te asemeja a Mí. Suelta esa ofensa y déjamela a Mí; Yo sanaré tu herida.",
      modernMeaning = "El perdón no justifica el error del otro, sino que desata las cadenas del resentimiento y restaura la armonía interior.",
      practicalApplication = "Reza un Avemaría pidiendo bendiciones de salud y paz para una persona con quien hayas tenido un desencuentro.",
      virtue = "Perdón",
      emoji = "🕊️"
    ),
    DiosTeDiceMessage(
      id = "salmo_103_1",
      citation = "Salmo 103:1-4",
      verseText = "«Bendice, alma mía, al Señor, y bendiga todo mi ser su santo nombre. Bendice, alma mía, al Señor, y no olvides ninguno de sus beneficios. Él es quien perdona todas tus iniquidades, el que sana todas tus dolencias; el que rescata del hoyo tu vida, el que te corona de favores y misericordias.»",
      godSaysToday = "No dejes pasar este día sin reconocer cuántas gracias discretas he derramado en tu camino. La vida, el aire, el pan, los seres queridos: todo es don de mi amor. Llena tu boca de alabanza.",
      modernMeaning = "La gratitud abre los ojos del alma para percibir la acción constante de Dios en lo cotidiano y ahuyenta la queja estéril.",
      practicalApplication = "Envía un mensaje de agradecimiento sincero a un familiar, amigo o compañero que te haya brindado apoyo recientemente.",
      virtue = "Gratitud",
      emoji = "🙏"
    ),
    DiosTeDiceMessage(
      id = "proverbios_3_5",
      citation = "Proverbios 3:5-6",
      verseText = "«Fíate del Señor de todo tu corazón, y no te apoyes en tu propia prudencia. Reconócelo en todos tus caminos, y él enderezará tus veredas.»",
      godSaysToday = "A veces tu mente humana no logra ver la salida; pero Yo veo el principio y el fin de los tiempos. Pon tus proyectos bajo mi luz y déjate orientar por el Espíritu Santo.",
      modernMeaning = "La fe viva nos invita a no idolatrar nuestros propios razonamientos, sino a consultar a Dios en la oración antes de tomar decisiones.",
      practicalApplication = "Antes de tomar una decisión importante hoy, reza la oración del Cardenal Verdier pidiendo luz al Espíritu Santo.",
      virtue = "Sabiduría",
      emoji = "🧭"
    ),
    DiosTeDiceMessage(
      id = "santiago_1_5",
      citation = "Santiago 1:5",
      verseText = "«Y si alguno de vosotros tiene falta de sabiduría, pídala a Dios, el cual da a todos abundantemente y sin reproche, y le será dada.»",
      godSaysToday = "No temas pedirme claridad. No me canso de escuchar tus dudas. Si buscas con corazón sincero la verdad y el bien, Yo derramaré en ti el don de consejo y entendimiento.",
      modernMeaning = "Dios es un Padre generoso que desea iluminar nuestros discernimientos cuando acudimos a Él con humildad.",
      practicalApplication = "Pide hoy la gracia de saber callar a tiempo y escuchar con atención a quien necesite desahogarse contigo.",
      virtue = "Sabiduría",
      emoji = "💡"
    ),
    DiosTeDiceMessage(
      id = "lucas_1_38",
      citation = "San Lucas 1:38",
      verseText = "«Dijo entonces María: He aquí la esclava del Señor; hágase en mí según tu palabra. Y el ángel se retiró de su presencia.»",
      godSaysToday = "Aprende de mi Madre Santa el valor del 'Sí' confiado. Cuando renuncias a querer controlarlo todo y te abandonas a mi providencia, das lugar a los mayores milagros de la gracia en tu vida cotidiana.",
      modernMeaning = "El abandono confiado en las manos de Dios no es resignación pasiva, sino valentía activa para acoger la voluntad divina con fe inquebrantable.",
      practicalApplication = "Reza hoy un Avemaría entregándole a la Virgen María esa preocupación que más te inquieta, diciendo: «Hágase en mí según tu palabra».",
      virtue = "Confianza",
      emoji = "🌹"
    ),
    DiosTeDiceMessage(
      id = "juan_15_5",
      citation = "San Juan 15:5",
      verseText = "«Yo soy la vid, vosotros los sarmientos; el que permanece en mí, y yo en él, este lleva mucho fruto; porque separados de mí nada podéis hacer.»",
      godSaysToday = "No intentes vivir tu fe con tus solas fuerzas humanas. Permanece unido a Mí en la oración sincera, en los sacramentos y en el amor al prójimo. De Mí brotará la savia que colmará tu vida de frutos de santidad.",
      modernMeaning = "Nuestra fecundidad espiritual depende enteramente de la intimidad cotidiana con Cristo vivo en el corazón y en la Eucaristía.",
      practicalApplication = "Haz una visita breve ante el Sagrario de una parroquia o cinco minutos de adoración espiritual en silencio en tu hogar.",
      virtue = "Amor",
      emoji = "🍇"
    ),
    DiosTeDiceMessage(
      id = "mateo_5_3",
      citation = "San Mateo 5:3-8",
      verseText = "«Bienaventurados los pobres en el espíritu, porque de ellos es el reino de los cielos. Bienaventurados los mansos, porque ellos recibirán la tierra por heredad. Bienaventurados los de limpio corazón, porque ellos verán a Dios.»",
      godSaysToday = "Las bienaventuranzas son el retrato de mi Corazón. No busques la felicidad en las vanidades pasajeras del mundo, sino en la sencillez, en la pureza de intención y en la misericordia con los que sufren.",
      modernMeaning = "Jesús propone una escala de valores inversa a la del éxito terrenal, prometiendo la alegría auténtica a los sencillos y compasivos.",
      practicalApplication = "Elige hoy la mansedumbre: no respondas con enojo ante una provocación o crítica en tu jornada.",
      virtue = "Paz",
      emoji = "⛰️"
    ),
    DiosTeDiceMessage(
      id = "salmo_27_1",
      citation = "Salmo 27:1",
      verseText = "«El Señor es mi luz y mi salvación; ¿de quién temeré? El Señor es la fortaleza de mi vida; ¿de quién he de atemorizarme?»",
      godSaysToday = "Ninguna oscuridad es más fuerte que mi luz. Cuando sientas dudas o soledad, mira mi Cruz y acuérdate de que ya vencí al mundo. Yo soy tu escudo y tu fortaleza permanente.",
      modernMeaning = "El temor se disipa cuando ponemos la mirada en la grandeza de Dios en lugar de magnificar las dificultades que atravesamos.",
      practicalApplication = "Enciende una vela ante una imagen de Cristo o la Virgen y reza un Padrenuestro pidiendo paz para tu familia.",
      virtue = "Fortaleza",
      emoji = "🕯️"
    ),
    DiosTeDiceMessage(
      id = "juan_6_35",
      citation = "San Juan 6:35",
      verseText = "«Jesús les dijo: Yo soy el pan de vida; el que a mí viene, nunca tendrá hambre; y el que en mí cree, no tendrá sed jamás.»",
      godSaysToday = "Tu alma tiene sed de infinito y nada de este mundo la saciará del todo. Búscame a Mí en el Pan Eucarístico. Yo me entrego a ti entero para alimentarte en el camino hacia la vida eterna.",
      modernMeaning = "La Eucaristía es el centro y cumbre de la vida de la Iglesia, fuente de renovación espiritual para nuestras fatigas diarias.",
      practicalApplication = "Planifica tu participación en la Santa Misa dominical y agradece a Jesús su presencia real en el Santísimo Sacramento.",
      virtue = "Gratitud",
      emoji = "🍞"
    ),
    DiosTeDiceMessage(
      id = "filipenses_4_13",
      citation = "Filipenses 4:13",
      verseText = "«Todo lo puedo en Cristo que me fortalece.»",
      godSaysToday = "Cuando te sientas sin fuerzas o creas que no eres capaz, acuérdate de que mi gracia sobreabunda donde tus fuerzas terminan. No vas solo; mi poder camina dentro de ti.",
      modernMeaning = "La fortaleza cristiana no radica en la autosuficiencia, sino en apoyarse con humildad en el vigor que brota de la comunión con Cristo.",
      practicalApplication = "Antes de comenzar tu mayor reto de hoy, repite tres veces con devoción: «Todo lo puedo en Cristo que me fortalece».",
      virtue = "Fortaleza",
      emoji = "💪"
    ),
    DiosTeDiceMessage(
      id = "pedro_5_7",
      citation = "1 San Pedro 5:6-7",
      verseText = "«Humillaos, pues, bajo la poderosa mano de Dios, para que él os exalte cuando fuere tiempo; echando toda vuestra ansiedad sobre él, porque él tiene cuidado de vosotros.»",
      godSaysToday = "No cargues con fardos pesados que no te corresponden. Echa sobre mis hombros tus angustias y desvelos. Yo sé lo que necesitas antes de que me lo pidas y cuido de ti en cada instante.",
      modernMeaning = "La humildad nos permite reconocer nuestros límites humanos y depositar nuestras ansiedades en la providencia paternal del Creador.",
      practicalApplication = "Al acostarte esta noche, haz un acto de entrega silencioso y duerme sabiendo que Dios vela tu descanso.",
      virtue = "Esperanza",
      emoji = "🌙"
    ),
    DiosTeDiceMessage(
      id = "lucas_15_20",
      citation = "San Lucas 15:20-24",
      verseText = "«Y levantándose, vino a su padre. Y cuando aún estaba lejos, lo vio su padre, y fue movido a misericordia, y corrió, y se echó sobre su cuello, y le besó.»",
      godSaysToday = "Nunca pienses que tus caídas o faltas te alejan para siempre de mi amor. Mi misericordia es infinita. Apenas das un paso hacia Mí con corazón contrito, Yo salgo corriendo a estrecharte en un abrazo de perdón.",
      modernMeaning = "Dios nunca se cansa de perdonar; somos nosotros los que nos cansamos de pedir perdón. La reconciliación nos devuelve la dignidad de hijos.",
      practicalApplication = "Examina hoy con serenidad tu conciencia y prepárate para acercarte al sacramento de la Confesión cuando te sea posible.",
      virtue = "Perdón",
      emoji = "❤️"
    ),
    DiosTeDiceMessage(
      id = "juan_8_12",
      citation = "San Juan 8:12",
      verseText = "«Otra vez Jesús les habló, diciendo: Yo soy la luz del mundo; el que me sigue, no andará en tinieblas, sino que tendrá la luz de la vida.»",
      godSaysToday = "Aunque a veces los problemas o la confusión nublen tu horizonte, mi Evangelio es antorcha para tus pasos. Sígueme en la verdad, en el perdón y en la caridad fraterna, y nunca caminarás a oscuras.",
      modernMeaning = "Seguir a Cristo disipa el engaño y nos da claridad moral y serenidad para guiar nuestros pasos con rectitud de corazón.",
      practicalApplication = "Sé luz para alguien hoy: saluda con amabilidad, sonríe a quien esté desanimado y regala una palabra de consuelo.",
      virtue = "Sabiduría",
      emoji = "☀️"
    ),
    DiosTeDiceMessage(
      id = "mateo_28_20",
      citation = "San Mateo 28:20",
      verseText = "«Y he aquí yo estoy con vosotros todos los días, hasta el fin del mundo. Amén.»",
      godSaysToday = "Esta es mi promesa solemne y eterna: jamás te dejaré solo. En los días de júbilo y en las noches de dolor, en tu juventud y en tu vejez, mi presencia camina a tu lado. Descansa en mi fidelidad.",
      modernMeaning = "La fidelidad de Dios trasciende el paso del tiempo y las vicisitudes de la vida, garantizándonos su auxilio continuo.",
      practicalApplication = "Ofrece una oración de agradecimiento por el don de la fe y pide perseverancia para mantenerte firme en la Iglesia.",
      virtue = "Esperanza",
      emoji = "🌍"
    ),
    DiosTeDiceMessage(
      id = "salmo_91_1",
      citation = "Salmo 91:1-4",
      verseText = "«El que habita al abrigo del Altísimo morará bajo la sombra del Omnipotente. Con sus plumas te cubrirá, y debajo de sus alas estarás seguro; escudo y adarga es su verdad.»",
      godSaysToday = "Acude a Mí como tu morada y tu refugio. Bajo mi protección paternal no hay peligro que pueda arrebatarte la paz del alma. Vive con la serenidad de quien se sabe amado por Dios.",
      modernMeaning = "La protección divina no nos aísla de las pruebas, pero nos asegura la custodia de los Santos Ángeles y la gracia para vencer toda adversidad.",
      practicalApplication = "Invoca hoy a tu Santo Ángel de la Guarda para que te asista, ilumine y libre de todo peligro del alma y del cuerpo.",
      virtue = "Confianza",
      emoji = "🪽"
    ),
    DiosTeDiceMessage(
      id = "corintios_12_9",
      citation = "2 Corintios 12:9",
      verseText = "«Y me ha dicho: Bástate mi gracia; porque mi poder se perfecciona en la debilidad. Por tanto, de buena gana me gloriaré más bien en mis debilidades, para que repose sobre mí el poder de Cristo.»",
      godSaysToday = "No te avergüences de tus limitaciones humanas. Cuando reconoces tu fragilidad y me la entregas, es allí donde mi poder obra maravillas. Mi gracia es más que suficiente para ti.",
      modernMeaning = "Nuestra insuficiencia abre las puertas a la omnipotencia de la gracia; quien reconoce su debilidad se fortalece en Dios.",
      practicalApplication = "No te reproches con dureza tus cansancios de hoy; ofrécelos al Señor como sacrificio agradable de humildad.",
      virtue = "Fortaleza",
      emoji = "🌿"
    ),
    DiosTeDiceMessage(
      id = "marcos_4_39",
      citation = "San Marcos 4:39",
      verseText = "«Y levantándose, reprendió al viento, y dijo al mar: Calla, enmudece. Y cesó el viento, y se hizo grande bonanza.»",
      godSaysToday = "¿Por qué dudas si estoy contigo en la barca de tu vida? Aunque parezca que las olas rugen y los vientos arrecian, mi voz tiene el poder de calmar cualquier tormenta. Mantén tu fe firme.",
      modernMeaning = "En las crisis personales o familiares, la serenidad nace de recordar que Jesús viaja con nosotros y manda sobre las tempestades.",
      practicalApplication = "Cuando sientas miedo o zozobra en el día, repite interiormente: «¡Jesús, confío en Ti; Tú estás en mi barca!».",
      virtue = "Paz",
      emoji = "⛵"
    ),
    DiosTeDiceMessage(
      id = "galatas_5_22",
      citation = "Gálatas 5:22-23",
      verseText = "«Mas el fruto del Espíritu es amor, gozo, paz, paciencia, benignidad, bondad, fe, mansedumbre, templanza; contra tales cosas no hay ley.»",
      godSaysToday = "Abre tu alma a la brisa del Espíritu Santo. Deja que Él fructifique en ti con alegría, paciencia y ternura. Esos frutos serán testimonio vivo de mi presencia para tu hogar y tu trabajo.",
      modernMeaning = "La vida en el Espíritu transforma nuestro carácter desde dentro, llenándonos de dones que edifican a la comunidad y a la familia.",
      practicalApplication = "Pide hoy al Espíritu Santo de manera especial el don de la paciencia para tratar con dulzura a quienes conviven contigo.",
      virtue = "Amor",
      emoji = "🕊️"
    ),
    DiosTeDiceMessage(
      id = "hebreos_13_8",
      citation = "Hebreos 13:8",
      verseText = "«Jesucristo es el mismo ayer, y hoy, y por los siglos.»",
      godSaysToday = "En un mundo donde todo cambia, donde las modas y las opiniones pasan rápidamente, Yo permanezco inmutable. Mi amor por ti es eterno y mi fidelidad no tiene ocaso. Aférrate a Mí.",
      modernMeaning = "Cristo es la roca inconmovible de la historia y de nuestra propia vida; en Él encontramos una verdad y un amor que jamás defraudan.",
      practicalApplication = "Haz la señal de la cruz con reverencia y ofrece el descanso de esta noche a Cristo, Rey de los siglos.",
      virtue = "Confianza",
      emoji = "✝️"
    )
  )

  fun getDailyVerse(): DiosTeDiceMessage {
    val cal = Calendar.getInstance()
    val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
    return verses[dayOfYear % verses.size]
  }

  fun getRandomVerse(): DiosTeDiceMessage {
    return verses.random()
  }

  fun getVerseById(id: String): DiosTeDiceMessage? {
    return verses.find { it.id == id }
  }

  fun getVerseByVirtue(virtue: String): DiosTeDiceMessage? {
    return verses.find { it.virtue.equals(virtue, ignoreCase = true) }
  }

  fun getVersesByVirtue(virtue: String): List<DiosTeDiceMessage> {
    return verses.filter { it.virtue.equals(virtue, ignoreCase = true) }
  }

  fun getAllVirtues(): List<String> {
    return listOf("Paz", "Confianza", "Fortaleza", "Esperanza", "Amor", "Gratitud", "Perdón", "Sabiduría")
  }
}
