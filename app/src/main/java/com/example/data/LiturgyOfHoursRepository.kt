package com.example.data

data class LiturgyHour(
  val id: String,
  val name: String,
  val subtitle: String,
  val icon: String,
  val invocation: String,
  val hymn: String,
  val psalmodyCitation: String,
  val psalmodyText: String,
  val shortReadingCitation: String,
  val shortReadingText: String,
  val gospelCanticleTitle: String,
  val gospelCanticleText: String,
  val intercessions: List<String>,
  val concludingPrayer: String
)

object LiturgyOfHoursRepository {

  val hours: List<LiturgyHour> = listOf(
    // 1. LAUDES (Oración de la Mañana)
    LiturgyHour(
      id = "laudes",
      name = "Laudes",
      subtitle = "Oración litúrgica de la Mañana al rayar el alba",
      icon = "🌅",
      invocation = "V/. Dios mío, ven en mi auxilio.\nR/. Señor, date prisa en socorrerme.\n\nGloria al Padre, y al Hijo, y al Espíritu Santo. Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén. Aleluya.",
      hymn = """Al filo de la mañana,
Dios mío, te busco a Ti;
al despertar mi alma
te alaba con gozo sin fin.

Tú que disipas la noche
y enciendes la luz del sol,
ilumina nuestra senda
con el fuego de tu amor.

A Ti la gloria, oh Padre,
a Ti, Cristo Salvador,
con el Espíritu Santo
por los siglos en unión. Amén.""",
      psalmodyCitation = "Salmo 62: El alma sedienta de Dios",
      psalmodyText = """¡Oh Dios, tú eres mi Dios, por ti madrugo!
Mi alma está sedienta de ti;
mi carne tiene ansia de ti,
como tierra reseca, agostada, sin agua.

¡Cómo te contemplaba en el santuario
viendo tu fuerza y tu gloria!
Tu gracia vale más que la vida,
te alabarán mis labios.

Toda mi vida te bendeciré
y alzaré las manos invocándote.
Mi alma está unida a ti,
y tu diestra me sostiene.""",
      shortReadingCitation = "Romanos 13:11-13",
      shortReadingText = "Ya es hora de despertar del sueño, porque ahora la salvación está más cerca de nosotros que cuando abrazamos la fe. La noche está avanzada, el día se echa encima: despojémonos de las obras de las tinieblas y revistámonos de las armas de la luz.",
      gospelCanticleTitle = "Cántico de Zacarías (Benedictus) — Lc 1:68-79",
      gospelCanticleText = """Bendito sea el Señor, Dios de Israel,
porque ha visitado y redimido a su pueblo,
suscitándonos una fuerza de salvación
en la casa de David, su siervo.

Por la entrañable misericordia de nuestro Dios,
nos visitará el sol que nace de lo alto,
para iluminar a los que viven en tinieblas
y en sombra de muerte,
para guiar nuestros pasos por el camino de la paz.

Gloria al Padre, y al Hijo, y al Espíritu Santo.
Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén.""",
      intercessions = listOf(
        "Al comenzar este nuevo día, demos gracias a Cristo que nos llama a su luz admirable: — R/. Señor, guíanos con tu amor.",
        "Conserva en nosotros la gracia del bautismo y la fidelidad a tus mandamientos: — R/. Señor, guíanos con tu amor.",
        "Bendice nuestras tareas, trabajos y familias con la paz y la concordia: — R/. Señor, guíanos con tu amor.",
        "Ten piedad de los enfermos, los angustiados y los que no tienen esperanza: — R/. Señor, guíanos con tu amor."
      ),
      concludingPrayer = "Señor Dios todopoderoso, que nos has hecho llegar al comienzo de este día: sálvanos hoy con tu poder, para que no caigamos en ningún pecado, sino que nuestras palabras, pensamientos y obras se dirijan siempre al cumplimiento de tu santa voluntad. Por nuestro Señor Jesucristo, tu Hijo, que vive y reina contigo en la unidad del Espíritu Santo y es Dios por los siglos de los siglos. R/. Amén."
    ),

    // 2. VÍSPERAS (Oración de la Tarde)
    LiturgyHour(
      id = "visperas",
      name = "Vísperas",
      subtitle = "Oración litúrgica del Atardecer y puesta de sol",
      icon = "🌇",
      invocation = "V/. Dios mío, ven en mi auxilio.\nR/. Señor, date prisa en socorrerme.\n\nGloria al Padre, y al Hijo, y al Espíritu Santo. Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén. Aleluya.",
      hymn = """Al declinar la tarde,
Señor de la bondad,
te ofrecemos las fatigas
del día que se va.

Gracias por tus mercedes,
por el pan y el perdón,
por la cruz que redime
y salva al pecador.

Descienda sobre el mundo
tu santa bendición,
y en la noche que llega
sé nuestro protector. Amén.""",
      psalmodyCitation = "Salmo 140: Oración en el peligro",
      psalmodyText = """Señor, te estoy llamando, ven de prisa;
escucha mi voz cuando te invoco.
Suba mi oración como incienso en tu presencia,
el alzar de mis manos como ofrenda de la tarde.

Pon, Señor, una guardia en mi boca,
un centinela a la puerta de mis labios.
Hacia ti, Señor, se vuelven mis ojos;
en ti me refugio, no me dejes indefenso.""",
      shortReadingCitation = "1 Pedro 5:5-7",
      shortReadingText = "Hermanos: Revestíos todos de humildad en el trato mutuo, porque Dios resiste a los soberbios, pero da su gracia a los humildes. Humillaos, pues, bajo la poderosa mano de Dios, para que él os ensalce a su debido tiempo. Descargad en él todas vuestras preocupaciones, porque él cuida de vosotros.",
      gospelCanticleTitle = "Cántico de la Santísima Virgen María (Magníficat) — Lc 1:46-55",
      gospelCanticleText = """Proclama mi alma la grandeza del Señor,
se alegra mi espíritu en Dios, mi Salvador;
porque ha mirado la humillación de su esclava.

Desde ahora me felicitarán todas las generaciones,
porque el Poderoso ha hecho obras grandes por mí:
su nombre es santo,
y su misericordia llega a sus fieles
de generación en generación.

Él derriba del trono a los poderosos
y enaltece a los humildes,
a los hambrientos los colma de bienes
y a los ricos los despide vacíos.

Auxilia a Israel, su siervo,
acordándose de la misericordia,
como lo había prometido a nuestros padres,
en favor de Abrahán y su descendencia por siempre.

Gloria al Padre, y al Hijo, y al Espíritu Santo.
Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén.""",
      intercessions = listOf(
        "Al caer de la tarde, oremos con confianza a Cristo, luz sin ocaso: — R/. Quédate con nosotros, Señor.",
        "Por los pecadores y los que viven lejos de tu Iglesia: para que encuentren el camino de regreso al Padre. — R/. Quédate con nosotros, Señor.",
        "Por los que hoy han terminado su peregrinación terrena: para que gocen de la luz perpetua en el cielo. — R/. Quédate con nosotros, Señor.",
        "Por la paz entre las naciones y la protección de los hogares: — R/. Quédate con nosotros, Señor."
      ),
      concludingPrayer = "Señor Jesús, que en la tarde del primer día de la semana te hiciste presente en medio de tus discípulos trayéndoles la paz, quédate con nosotros ahora que atardece; ilumina las tinieblas de nuestra noche y haz que descansemos en tu amor. Tú que vives y reinas por los siglos de los siglos. R/. Amén."
    ),

    // 3. COMPLETAS (Oración de la Noche antes del descanso)
    LiturgyHour(
      id = "completas",
      name = "Completas",
      subtitle = "Oración litúrgica de la Noche antes de dormir",
      icon = "🌙",
      invocation = "V/. Concédenos, Señor omnipotente, una noche tranquila y una santa muerte.\nR/. Amén.\n\nV/. Hermanos, reconozcamos con sinceridad nuestros pecados en silencio.\n(Breve examen de conciencia de la jornada transcurrida):\nYo confieso ante Dios todopoderoso y ante vosotros hermanos...",
      hymn = """Antes que la luz se apague,
Creador del universo,
te pedimos con fervor
que nos guardes en tu seno.

Aparta los malos sueños,
las sombras de la impureza,
para que en alma y cuerpo
conservemos la pureza.

Escúchanos, Padre amado,
por Jesucristo tu Hijo,
que con el Santo Espíritu
reina por siglos eternos. Amén.""",
      psalmodyCitation = "Salmo 90: Bajo las alas del Altísimo",
      psalmodyText = """Tú que habitas al amparo del Altísimo,
que vives a la sombra del Omnipotente,
di al Señor: «Refugio mío, alcázar mío,
Dios mío en quien confío».

Él te librará de la red del cazador,
de la peste funesta;
te cubrirá con sus plumas,
bajo sus alas te refugiarás:
su brazo es escudo y armadura.

No temerás el espanto nocturno,
ni la flecha que vuela de día,
ni la peste que avanza en las tinieblas,
ni la plaga que azota a mediodía.

No se te acercará la desgracia,
ni la plaga llegará a tu tienda,
porque a sus ángeles ha dado órdenes
para que te guarden en todos tus caminos.""",
      shortReadingCitation = "1 Tesalonicenses 5:9-10",
      shortReadingText = "Dios no nos ha destinado a la ira, sino a obtener la salvación por medio de nuestro Señor Jesucristo, que murió por nosotros, para que, tanto si velamos como si dormimos, vivamos juntos con él.",
      gospelCanticleTitle = "Cántico de Simeón (Nunc Dimittis) — Lc 2:29-32",
      gospelCanticleText = """Antífona: Sálvanos, Señor, despiertos, custódianos dormidos, para que velemos con Cristo y descansemos en paz.

Ahora, Señor, según tu promesa,
puedes dejar a tu siervo irse en paz.
Porque mis ojos han visto a tu Salvador,
a quien has presentado ante todos los pueblos:
luz para alumbrar a las naciones
y gloria de tu pueblo Israel.

Gloria al Padre, y al Hijo, y al Espíritu Santo.
Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén.

Antífona: Sálvanos, Señor, despiertos, custódianos dormidos, para que velemos con Cristo y descansemos en paz.""",
      intercessions = listOf(
        "V/. En tus manos, Señor, encomiendo mi espíritu. — R/. En tus manos, Señor, encomiendo mi espíritu.",
        "V/. Tú nos redimiste, Señor, Dios de verdad. — R/. Te encomiendo mi espíritu.",
        "V/. Gloria al Padre, y al Hijo, y al Espíritu Santo. — R/. En tus manos, Señor, encomiendo mi espíritu."
      ),
      concludingPrayer = "Visita, Señor, esta morada y aleja de ella todas las insidias del enemigo; que tus santos ángeles habiten en ella para guardarnos en paz, y que tu bendición santa permanezca siempre con nosotros. Por Jesucristo, nuestro Señor. R/. Amén.\n\nAntífona Mariana Final:\nDios te salve, Reina y Madre de misericordia, vida, dulzura y esperanza nuestra: Dios te salve. A ti llamamos los desterrados hijos de Eva; a ti suspiramos, gimiendo y llorando en este valle de lágrimas. Ea, pues, Señora, abogada nuestra, vuelve a nosotros esos tus ojos misericordiosos; y después de este destierro muéstranos a Jesús, fruto bendito de tu vientre. ¡Oh clementísima, oh piadosa, oh dulce Virgen María! Ruega por nosotros, Santa Madre de Dios, para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo. Amén."
    ),

    // 4. OFICIO DE LECTURA (Oración y Meditación Espiritual)
    LiturgyHour(
      id = "oficio_lectura",
      name = "Oficio de Lectura",
      subtitle = "Salmodia y contemplación de la Sagrada Escritura y los Padres",
      icon = "📜",
      invocation = "V/. Señor, abre mis labios.\nR/. Y mi boca proclamará tu alabanza.\n\nGloria al Padre, y al Hijo, y al Espíritu Santo. Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén. Aleluya.",
      hymn = """La noche cede el paso
al resplandor divino;
el corazón despierta
para adorar a Cristo.

Callen las vanidades,
cese el rumor terreno,
hable la santa Palabra
en el silencio eterno.

A Dios Padre la gloria,
al Hijo Salvador,
con el Espíritu Santo
por los siglos en unión. Amén.""",
      psalmodyCitation = "Salmo 18: La gloria de Dios en la creación y la Ley",
      psalmodyText = """El cielo proclama la gloria de Dios,
el firmamento pregona la obra de sus manos:
el día al día le pasa el mensaje,
la noche a la noche se lo susurra.

La ley del Señor es perfecta
y es descanso del alma;
el precepto del Señor es fiel
e instruye a los sencillos;
los mandatos del Señor son rectos
y alegran el corazón;
la norma del Señor es límpida
y da luz a los ojos.""",
      shortReadingCitation = "Hebreos 4:12-13",
      shortReadingText = "La palabra de Dios es viva, eficaz y más cortante que una espada de dos filos; penetra hasta la división entre alma y espíritu, articulaciones y médulas; y discierne los sentimientos y pensamientos del corazón. No hay ser creado que escape a su vista; todo está al desnudo y al descubierto a los ojos de aquel a quien hemos de dar cuenta.",
      gospelCanticleTitle = "Cántico de Alabanza (Te Deum)",
      gospelCanticleText = """A ti, oh Dios, te alabamos,
a ti, Señor, te reconocemos.
A ti, eterno Padre,
te venera toda la creación.

Los ángeles todos, los cielos
y todas las potestades te honran.
Los querubines y serafines
te cantan sin cesar:
Santo, Santo, Santo es el Señor,
Dios del universo.

Tú eres el Rey de la gloria, Cristo.
Tú eres el Hijo único del Padre.
Tú, para liberar al hombre,
no desdeñaste el seno de la Virgen.
Tú venciste el aguijón de la muerte
y abriste a los creyentes el reino de los cielos.

Salva a tu pueblo, Señor,
y bendice tu heredad.
Sé su pastor y ensálzalo eternamente.
En ti, Señor, confié,
no me veré defraudado para siempre. Amén.""",
      intercessions = listOf(
        "V/. Te alabamos, Señor, por tu Palabra viva. — R/. Ella es lámpara para nuestros pasos.",
        "V/. Ilumina las mentes de los teólogos y pastores. — R/. Para que proclamen tu verdad con fidelidad.",
        "V/. Danos un corazón dócil y contemplativo. — R/. Que guarde tus mandamientos día y noche."
      ),
      concludingPrayer = "Dios todopoderoso, concédenos que la meditación continua de tu verdad nos transforme a imagen de tu Hijo, para que resplandezcamos como testigos de tu caridad en medio del mundo. Por Jesucristo, nuestro Señor. R/. Amén."
    )
  )

  fun getHourById(id: String): LiturgyHour {
    return hours.find { it.id == id } ?: hours.first()
  }
}
