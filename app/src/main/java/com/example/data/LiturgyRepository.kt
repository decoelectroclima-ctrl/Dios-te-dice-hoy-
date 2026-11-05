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
    return getLiturgyForCalendar(Calendar.getInstance())
  }

  fun getLiturgyForCalendar(cal: Calendar): DailyLiturgy {
    val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
    val month = cal.get(Calendar.MONTH) + 1
    val day = cal.get(Calendar.DAY_OF_MONTH)

    val dateFormat = SimpleDateFormat("EEEE, d 'de' MMMM", Locale("es", "ES"))
    val formattedDate = dateFormat.format(cal.time).replaceFirstChar { it.uppercase() }

    return when (dayOfWeek) {
      Calendar.SUNDAY -> DailyLiturgy(
        dayTitle = "Domingo — Día del Señor",
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Celebración Eucarística Dominical",
        entranceAntiphon = "Canten al Señor un cántico nuevo, cante al Señor toda la tierra. Hay honor y majestad en su presencia, fuerza y esplendor en su santuario.",
        collectPrayer = "Dios todopoderoso y eterno, aumenta en nosotros los dones de tu gracia, para que, esperando con fe viva tus promesas celestiales, alcancemos la plenitud de tu reino. Por nuestro Señor Jesucristo, tu Hijo, que vive y reina contigo en la unidad del Espíritu Santo y es Dios por los siglos de los siglos. R/. Amén.",
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
        prayersOfTheFaithful = listOf(
          "Por la Santa Iglesia y por nuestro Santo Padre el Papa: para que sea faro de esperanza, caridad y verdad para toda la humanidad. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los gobernantes y legisladores: para que promuevan la paz, defiendan la vida desde su concepción y protejan a los más vulnerables. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los atribulados, los enfermos y los que sufren hambre o guerra: para que la presencia viva de Cristo y la solidaridad fraterna alivien sus dolores. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por nuestra asamblea dominical y nuestras familias: para que alimentados de la Eucaristía seamos sal y luz en el mundo. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Mira, Señor, complacido, las ofrendas que ponemos sobre tu altar en este día sagrado, y concédenos que este santo sacrificio nos obtenga la salvación y la paz eterna. Por Jesucristo, nuestro Señor. R/. Amén.",
        communionAntiphon = "«El que come mi carne y bebe mi sangre permanece en mí y yo en él —dice el Señor.» (Jn 6:57)",
        prayerAfterCommunion = "Saciados con los sacramentos del cielo, te pedimos, Señor, que nos asista siempre el auxilio de tu gracia para dar testimonio de tu verdad con obras de amor fraterno. Por Jesucristo, nuestro Señor. R/. Amén.",
        liturgicalReflection = "Jesús se presenta junto al pozo de nuestra rutina diaria. Conoce nuestras sedes más hondas y no ofrece soluciones superficiales, sino el manantial inagotable del Espíritu Santo."
      )

      Calendar.MONDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Feria del Tiempo Ordinario — Las Bienaventuranzas",
        entranceAntiphon = "El Señor es mi fuerza y mi escudo, en él confió mi corazón y fui socorrido; mi carne floreció de nuevo y le doy gracias con mi canto.",
        collectPrayer = "Dios omnipotente, de quien procede todo don perfecto, infunde en nuestros corazones el amor de tu nombre, para que, aumentando en nosotros la piedad, fortalezcas lo que es bueno y lo conserves con tu providencia solícita. Por Jesucristo nuestro Señor. R/. Amén.",
        firstReadingCitation = "Isaías 61:1-3",
        firstReadingText = "El Espíritu del Señor Dios está sobre mí, porque el Señor me ha ungido. Me ha enviado para dar la buena noticia a los pobres, para vendar los corazones desgarrados, para proclamar la amnistía a los cautivos, a los prisioneros la libertad, para proclamar el año de gracia del Señor y consolar a los afligidos.",
        responsorialPsalmCitation = "Salmo 1",
        responsorialPsalmResponse = "R/. Dichoso el hombre que confía en el Señor.",
        responsorialPsalmText = "Dichoso el hombre que no sigue el consejo de los impíos, ni entra en el camino de los pecadores, sino que su gozo es la ley del Señor y medita su ley día y noche. Será como un árbol plantado al borde de la acequia: da fruto en su sazón y no se marchitan sus hojas.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Alegraos y regocijaos, porque vuestra recompensa será grande en el cielo.»",
        gospelCitation = "San Mateo 5:1-12",
        gospelText = "En aquel tiempo, al ver Jesús el gentío, subió a la montaña, se sentó, y se acercaron sus discípulos; y él se puso a hablar y les enseñaba diciendo: «Dichosos los pobres en el espíritu, porque de ellos es el Reino de los Cielos. Dichosos los mansos, porque ellos heredarán la tierra. Dichosos los que lloran, porque ellos serán consolados. Dichosos los que tienen hambre y sed de justicia, porque ellos quedarán saciados. Dichosos los misericordiosos, porque ellos alcanzarán misericordia. Dichosos los limpios de corazón, porque ellos verán a Dios. Dichosos los que trabajan por la paz, porque ellos serán llamados hijos de Dios».",
        prayersOfTheFaithful = listOf(
          "Por la Iglesia: para que sea siempre hogar acogedor para los pobres y afligidos. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los gobernantes: para que busquen el bien común y la justicia distributiva. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por quienes sufren injusticias o persecución: para que sientan la bienaventuranza de la cercanía divina. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por nosotros: para que vivamos con pureza y mansedumbre de corazón en el trabajo y en la familia. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Acepta, Señor, estos dones que te presentamos en el umbral de esta nueva semana de trabajo y haz que fructifiquen en obras de justicia. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«Dichosos los limpios de corazón, porque ellos verán a Dios.» (Mt 5:8)",
        prayerAfterCommunion = "Habiendo participado de tu banquete sagrado, te suplicamos, Señor, que vivamos las Bienaventuranzas en nuestro quehacer diario. Por Jesucristo nuestro Señor. R/. Amén.",
        liturgicalReflection = "Las Bienaventuranzas son el retrato mismo de Jesús. Vivirlas es dejarse transformar por la lógica del Reino frente a las pretensiones de poder y autosuficiencia del mundo."
      )

      Calendar.TUESDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Feria del Tiempo Ordinario — La Plegaria Filial y el Perdón",
        entranceAntiphon = "Inclina tu oído hacia mí, Señor, y escúchame; salva a tu siervo que confía en ti. Ten piedad de mí, Señor, que a ti te invoco todo el día.",
        collectPrayer = "Señor Dios, concédenos a tus siervos gozar siempre de salud de alma y cuerpo, y por la intercesión gloriosa de la Madre de tu Hijo, vernos libres de las tristezas presentes y disfrutar de las alegrías eternas. Por nuestro Señor Jesucristo. R/. Amén.",
        firstReadingCitation = "Filipenses 4:4-9",
        firstReadingText = "Hermanos: Alegraos siempre en el Señor; os lo repito, alegraos. Que vuestra mesura la conozca todo el mundo. El Señor está cerca. Nada os preocupe; sino que, en toda ocasión, en la oración y en la súplica, con acción de gracias, vuestras peticiones sean presentadas a Dios. Y la paz de Dios, que sobrepasa todo juicio, custodiará vuestros corazones y vuestros pensamientos en Cristo Jesús.",
        responsorialPsalmCitation = "Salmo 26 (27)",
        responsorialPsalmResponse = "R/. El Señor es mi luz y mi salvación, ¿a quién temeré?",
        responsorialPsalmText = "El Señor es mi luz y mi salvación, ¿a quién temeré? El Señor es la defensa de mi vida, ¿quién me hará temblar? Una cosa pido al Señor, eso buscaré: habitar en la casa del Señor por los días de mi vida, gozando de la dulzura del Señor.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Habéis recibido un espíritu de hijos adoptivos, que nos hace gritar: ¡Abba, Padre!»",
        gospelCitation = "San Mateo 6:7-15",
        gospelText = "En aquel tiempo, dijo Jesús a sus discípulos: «Cuando recéis, no uséis muchas palabras, como los gentiles, que se imaginan que por hablar mucho les harán caso. Vosotros rezad así: Padre nuestro que estás en el cielo, santificado sea tu nombre; venga a nosotros tu reino; hágase tu voluntad en la tierra como en el cielo. Danos hoy nuestro pan de cada día; perdona nuestras ofensas, como también nosotros perdonamos a los que nos ofenden; no nos dejes caer en la tentación, y líbranos del mal».",
        prayersOfTheFaithful = listOf(
          "Para que la oración del Padre Nuestro nos una fraternalmente a todos los creyentes. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Para que seamos generosos en el perdón sincero ante las ofensas recibidas. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Para que no falte el pan de la mesa ni el pan del trabajo digno a ningún hogar. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Para que el Señor preserve a nuestras comunidades de la soberbia y de la discordia. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Que este sacrificio, Padre de bondad, nos obtenga la gracia del perdón fraterno y nos reconcilie en tu santa paz. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«El que pide recibe, el que busca encuentra, y al que llama se le abrirá —dice el Señor.»",
        prayerAfterCommunion = "Fortalecidos con el Pan de los fuertes, te pedimos, Señor, que sepamos perdonar como Tú nos perdonas y orar con filial ternura. Por Jesucristo nuestro Señor. R/. Amén.",
        liturgicalReflection = "En el Padre Nuestro, Jesús nos revela que Dios no es un juez distante sino un Padre entrañable. Perdonar a los hermanos es la puerta indispensable para experimentar su infinita misericordia."
      )

      Calendar.WEDNESDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Feria del Tiempo Ordinario — La Vid Verdadera y el Amor Fraterno",
        entranceAntiphon = "Canten al Señor, proclamen su amor; cuenten de día en día su salvación, publiquen a los pueblos su gloria.",
        collectPrayer = "Dios providente, que no permites que los que esperan en ti sean confundidos, concédenos permanecer íntimamente unidos a la Vid divina para que nuestra vida sea abundancia de frutos de caridad. Por Jesucristo nuestro Señor. R/. Amén.",
        firstReadingCitation = "1 Juan 4:7-16",
        firstReadingText = "Queridos hermanos: Amémonos unos a otros, ya que el amor es de Dios, y todo el que ama ha nacido de Dios y conoce a Dios. Quien no ama no ha conocido a Dios, porque Dios es amor. En esto se manifestó el amor que Dios nos tiene: en que Dios envió al mundo a su Hijo único, para que vivamos por medio de él. Si nos amamos unos a otros, Dios permanece en nosotros y su amor ha llegado en nosotros a su plenitud.",
        responsorialPsalmCitation = "Salmo 33 (34)",
        responsorialPsalmResponse = "R/. Gustad y ved qué bueno es el Señor.",
        responsorialPsalmText = "Bendigo al Señor en todo momento, su alabanza está siempre en mi boca; mi alma se gloría en el Señor: que los humildes lo escuchen y se alegren. Proclamad conmigo la grandeza del Señor, ensalcemos juntos su nombre.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Permaneced en mí y yo en vosotros, dice el Señor; el que permanece en mí da mucho fruto.»",
        gospelCitation = "San Juan 15:1-8",
        gospelText = "En aquel tiempo, dijo Jesús a sus discípulos: «Yo soy la verdadera vid, y mi Padre es el labrador. Al sarmiento que no da fruto en mí, lo arranca; y al que da fruto, lo poda para que dé más fruto. Vosotros ya estáis limpios por la palabra que os he hablado; permaneced en mí, y yo en vosotros. Como el sarmiento no puede dar fruto por sí mismo, si no permanece en la vid, así tampoco vosotros, si no permanecéis en mí. Yo soy la vid, vosotros los sarmientos; el que permanece en mí y yo en él, ese da fruto abundante; porque sin mí no podéis hacer nada».",
        prayersOfTheFaithful = listOf(
          "Por la Iglesia extendida en el mundo: para que permanezca unida a Cristo como los sarmientos a la vid. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los misioneros y agentes de pastoral: para que su testimonio fructifique en conversiones. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los enfermos y solitarios: para que se sientan amados y sostenidos por la oración de la comunidad. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por nuestras familias: para que vivamos en concordia y apoyo mutuo. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Recibe, Señor, las ofrendas de tus siervos y haz que, al participar de este sacramento de unidad, crezcamos en el amor fraterno. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«El que permanece en mí y yo en él, ése da fruto abundante.» (Jn 15:5)",
        prayerAfterCommunion = "Señor Jesús, concédenos perseverar en tu amistad santa, nutriéndonos con tu gracia para dar frutos duraderos en el mundo. Tú que vives y reinas por los siglos de los siglos. R/. Amén.",
        liturgicalReflection = "«Sin mí no podéis hacer nada». La vida cristiana no es autosuficiencia ética, sino una inserción vital en Cristo. Permanecer en su amor mediante los sacramentos y la oración es el manantial de toda fecundidad."
      )

      Calendar.THURSDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.BLANCO,
        celebrationName = "Feria del Tiempo Ordinario — Memoria de la Sagrada Eucaristía",
        entranceAntiphon = "Los alimentó con flor de harina y los sació con miel de la peña.",
        collectPrayer = "Oh Dios, que en este sacramento admirable nos dejaste el memorial de tu pasión, concédenos venerar de tal modo los sagrados misterios de tu Cuerpo y de tu Sangre, que experimentemos constantemente en nosotros el fruto de tu redención. Tú que vives y reinas por los siglos de los siglos. R/. Amén.",
        firstReadingCitation = "1 Corintios 11:23-26",
        firstReadingText = "Hermanos: Yo recibí del Señor lo que os he transmitido: que el Señor Jesús, la noche en que iba a ser entregado, tomó pan y, pronunciando la acción de gracias, lo partió y dijo: «Esto es mi cuerpo, que se entrega por vosotros. Haced esto en memoria mía». Asimismo, después de cenar, tomó el cáliz, diciendo: «Este cáliz es la nueva alianza en mi sangre. Haced esto cada vez que lo bebáis, en memoria mía». Porque cada vez que coméis este pan y bebéis el cáliz, proclamáis la muerte del Señor, hasta que vuelva.",
        responsorialPsalmCitation = "Salmo 115 (116)",
        responsorialPsalmResponse = "R/. El cáliz de la bendición es comunión con la Sangre de Cristo.",
        responsorialPsalmText = "¿Cómo pagaré al Señor todo el bien que me ha hecho? Alzaré la copa de la salvación, invocando el nombre del Señor. Mucho le cuesta al Señor la muerte de sus fieles. Cumpliré al Señor mis votos en presencia de todo su pueblo.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Yo soy el pan vivo que ha bajado del cielo; el que coma de este pan vivirá para siempre.»",
        gospelCitation = "San Juan 6:35-40",
        gospelText = "En aquel tiempo, dijo Jesús a la multitud: «Yo soy el pan de la vida. El que viene a mí no pasará hambre, y el que cree en mí nunca más tendrá sed. Todo lo que me da el Padre vendrá a mí, y al que venga a mí no lo echaré fuera; porque he bajado del cielo no para hacer mi voluntad, sino la voluntad del que me ha enviado. Y esta es la voluntad del que me ha enviado: que no pierda nada de lo que me dio, sino que lo resucite en el último día».",
        prayersOfTheFaithful = listOf(
          "Por todos los sacerdotes de la Iglesia: para que sean santos y fieles custodios de la Eucaristía. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por las vocaciones al ministerio sacerdotal y a la vida consagrada. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los niños que se preparan a recibir su Primera Comunión: para que amen a Jesús eucarístico toda la vida. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por quienes hoy comulgamos: para que nos transformemos en Cristo y seamos pan partido para los demás. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Concede benigno a tu Iglesia, Señor, los dones de la paz y de la unidad, místicamente significados en las ofrendas que consagramos sobre tu santo altar. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«El que come mi carne y bebe mi sangre tiene vida eterna, y yo lo resucitaré en el último día.» (Jn 6:54)",
        prayerAfterCommunion = "Haz, Señor Jesús, que la comunión en tu Cuerpo y Sangre nos llene de tu caridad divina y nos prepare para el banquete eterno del cielo. Tú que vives y reinas por los siglos de los siglos. R/. Amén.",
        liturgicalReflection = "Cada jueves honramos el regalo eucarístico del Cenáculo. En el pan consagrado, Jesús no nos deja un símbolo lejano, sino su propia presencia viva, derramando su gracia sobre nuestras flaquezas."
      )

      Calendar.FRIDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.ROJO,
        celebrationName = "Feria del Tiempo Ordinario — La Pasión del Señor y la Divina Misericordia",
        entranceAntiphon = "Nosotros hemos de gloriarnos en la cruz de nuestro Señor Jesucristo, en quien está nuestra salvación, vida y resurrección.",
        collectPrayer = "Dios todopoderoso y eterno, que quisiste que nuestro Salvador se hiciera hombre y padeciera en la Cruz para darnos ejemplo de humildad, concédenos bondadoso imitar las enseñanzas de su Pasión y participar de su gloriosa resurrección. Por nuestro Señor Jesucristo. R/. Amén.",
        firstReadingCitation = "Isaías 52:13—53:12",
        firstReadingText = "Él soportó nuestros sufrimientos y aguantó nuestros dolores... Fue traspasado por nuestras rebeliones, triturado por nuestros crímenes. El castigo de nuestra salvación pesó sobre él, y en sus llagas hemos sido curados. Todos errábamos como ovejas, cada uno siguiendo su camino; y el Señor cargó sobre él todos nuestros pecados.",
        responsorialPsalmCitation = "Salmo 21 (22)",
        responsorialPsalmResponse = "R/. Dios mío, Dios mío, ¿por qué me has abandonado?",
        responsorialPsalmText = "Al verme se burlan de mí, hacen visajes, menean la cabeza: «Acudió al Señor, que lo libre; que lo salve si tanto lo quiere». Me acorrala una jauría de mastines, me cerca una banda de malhechores; me taladran las manos y los pies, puedo contar todos mis huesos.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Cristo se hizo por nosotros obediente hasta la muerte, y una muerte de cruz; por eso Dios lo levantó sobre todo.»",
        gospelCitation = "San Marcos 8:34-38",
        gospelText = "En aquel tiempo, llamando a la gente y a sus discípulos, Jesús les dijo: «Si alguno quiere venir en pos de mí, que se niegue a sí mismo, tome su cruz y me siga. Porque quien quiera salvar su vida, la perderá; pero el que pierda su vida por mí y por el Evangelio, la salvará. Pues ¿de qué le sirve a un hombre ganar el mundo entero y perder su alma? ¿O qué podrá dar uno a cambio de su alma?».",
        prayersOfTheFaithful = listOf(
          "Por los que sufren persecución, cárcel o violencia a causa de la justicia. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los agonizantes y enfermos terminales: para que experimenten el abrazo misericordioso de Cristo en la Cruz. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por la conversión de los pecadores y la paz en los pueblos desolados por la guerra. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por nosotros: para que abracemos con paciencia y fe nuestras cruces cotidianas. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Que este sacrificio, Señor, en el que se renueva el memorial de la Pasión salvadora de tu Hijo, borre nuestras culpas y nos alcance la salvación. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«Padre, si no puede pasar este cáliz sin que yo lo beba, hágase tu voluntad.» (Mt 26:42)",
        prayerAfterCommunion = "Alimentados con el Cuerpo inmolado de tu Hijo, te suplicamos, Padre, que permanezcamos fieles al pie de su Cruz para alcanzar la gloria de la Pascua. Por Jesucristo nuestro Señor. R/. Amén.",
        liturgicalReflection = "El viernes es día penitencial y de memoria agradecida. Mirar al Crucificado desvanece nuestras quejas y nos infunde valentía para donar la vida por amor a Dios y a los hermanos."
      )

      Calendar.SATURDAY -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.BLANCO,
        celebrationName = "Memoria de Santa María Virgen en Sábado",
        entranceAntiphon = "Dichosa eres, Virgen María, que llevaste en tu seno al Creador del universo; diste a luz al que te creó y permaneces Virgen para siempre.",
        collectPrayer = "Dios todopoderoso, concédenos a tus fieles, que celebramos con gozo la memoria de la Santísima Virgen María, ser liberados de los males de esta vida terrena y gozar de la bienaventuranza eterna en el cielo. Por Jesucristo nuestro Señor. R/. Amén.",
        firstReadingCitation = "Gálatas 4:4-7",
        firstReadingText = "Hermanos: Cuando llegó la plenitud del tiempo, envió Dios a su Hijo, nacido de mujer, nacido bajo la ley, para rescatar a los que estaban bajo la ley, para que recibiéramos la adopción filial. Y como sois hijos, Dios envió a nuestros corazones el Espíritu de su Hijo, que clama: «¡Abba, Padre!». De modo que ya no eres esclavo, sino hijo; y si eres hijo, eres también heredero por voluntad de Dios.",
        responsorialPsalmCitation = "Salmo Magníficat (Lucas 1)",
        responsorialPsalmResponse = "R/. Se alegra mi espíritu en Dios, mi Salvador.",
        responsorialPsalmText = "Proclama mi alma la grandeza del Señor, se alegra mi espíritu en Dios, mi salvador; porque ha mirado la humildad de su esclava. Desde ahora me felicitarán todas las generaciones, porque el Poderoso ha hecho obras grandes por mí: su nombre es santo, y su misericordia llega a sus fieles de generación en generación.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Dichosa tú, Virgen María, que creíste, porque lo que te ha dicho el Señor se cumplirá.»",
        gospelCitation = "San Lucas 1:26-38",
        gospelText = "En aquel tiempo, el ángel Gabriel fue enviado por Dios a una ciudad de Galilea llamada Nazaret, a una virgen desposada con un hombre llamado José, de la casa de David; el nombre de la virgen era María. El ángel, entrando en su presencia, dijo: «Alégrate, llena de gracia, el Señor está contigo». Ella se turbó ante estas palabras, pero el ángel le dijo: «No temas, María, porque has encontrado gracia ante Dios. Concebirás en tu vientre y darás a luz un hijo, y le pondrás por nombre Jesús». María contestó: «He aquí la esclava del Señor; hágase en mí según tu palabra».",
        prayersOfTheFaithful = listOf(
          "Por la Santa Madre Iglesia: para que guiada por el modelo de María sea dócil a la Palabra de Dios. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por las madres de familia: para que eduquen a sus hijos con amor, paciencia y fe cristiana. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por los jóvenes que dudan de su vocación: para que respondan con generosidad como María: «Hágase en mí». Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por nosotros: para que encontremos en María consuelo en nuestras penas y auxilio en la tentación. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Al venerar la memoria de la Madre de tu Hijo, te pedimos, Señor, que esta ofrenda nos transforme en don perpetuo para Ti. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«Proclama mi alma la grandeza del Señor, porque el Poderoso ha hecho obras grandes por mí.» (Lc 1:46.49)",
        prayerAfterCommunion = "Saciados con este alimento celestial, imploramos tu clemencia, Señor, para que, imitando a la Santísima Virgen María, cumplamos siempre tu voluntad. Por Jesucristo nuestro Señor. R/. Amén.",
        liturgicalReflection = "El sábado une la memoria de la soledad esperanzada de María tras la Cruz con la certeza del domingo de Resurrección. Ella es modelo de perseverancia en la fe en medio de la oscuridad."
      )

      else -> DailyLiturgy(
        dayTitle = formattedDate,
        liturgicalSeason = "Tiempo Ordinario",
        liturgicalColor = LiturgicalColor.VERDE,
        celebrationName = "Feria del Tiempo Ordinario",
        entranceAntiphon = "El Señor es mi fuerza y mi escudo, en él confió mi corazón y fui socorrido.",
        collectPrayer = "Dios omnipotente, infunde en nuestros corazones el amor de tu nombre para que vivamos en tu santa paz. Por Jesucristo nuestro Señor. R/. Amén.",
        firstReadingCitation = "Filipenses 2:1-5",
        firstReadingText = "Hermanos: Si hay algún consuelo en Cristo, colmen mi gozo teniendo un mismo sentir y un mismo amor, considerando a los demás como superiores a ustedes mismos.",
        responsorialPsalmCitation = "Salmo 130 (131)",
        responsorialPsalmResponse = "R/. Guarda mi alma en tu paz, Señor.",
        responsorialPsalmText = "Señor, mi corazón no es engreído, ni mis ojos altaneros. Tengo mi alma en paz y silencio, como un niño en el regazo de su madre.",
        secondReadingCitation = null,
        secondReadingText = null,
        gospelAcclamation = "«Mis ovejas escuchan mi voz, y yo las conozco y ellas me siguen, dice el Señor.»",
        gospelCitation = "San Lucas 14:12-14",
        gospelText = "En aquel tiempo, Jesús dijo: «Cuando des un banquete, invita a los pobres, a los lisiados, a los cojos y a los ciegos. Y serás dichoso, porque ellos no tienen con qué recompensarte; pues se te recompensará en la resurrección de los justos».",
        prayersOfTheFaithful = listOf(
          "Por la Santa Iglesia y por todos sus pastores. Roguemos al Señor. — R/. Te rogamos, óyenos.",
          "Por la concordia y el entendimiento en nuestras familias. Roguemos al Señor. — R/. Te rogamos, óyenos."
        ),
        prayerOverOfferings = "Que este sacrificio eucarístico, Señor, nos purifique de nuestras faltas. Por Jesucristo nuestro Señor. R/. Amén.",
        communionAntiphon = "«Gustad y ved qué bueno es el Señor.» (Sal 33:9)",
        prayerAfterCommunion = "Renovados con el pan de vida, te suplicamos, Padre, que alcancemos la gloria eterna. Por Jesucristo nuestro Señor. R/. Amén.",
        liturgicalReflection = "Amar y servir a quien nada nos puede devolver es el reflejo más puro del amor de Dios hacia nosotros."
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
      id = "credo_profesion_fe",
      section = "Liturgia de la Palabra",
      title = "Profesión de Fe (Credo)",
      priestDialogue = "Creo en un solo Dios...",
      peopleResponse = "R/. Padre todopoderoso, Creador del cielo y de la tierra, de todo lo visible y lo invisible.\n\nCreo en un solo Señor, Jesucristo, Hijo único de Dios, nacido del Padre antes de todos los siglos: Dios de Dios, Luz de Luz, Dios verdadero de Dios verdadero, engendrado, no creado, de la misma naturaleza del Padre, por quien todo fue hecho; que por nosotros, los hombres, y por nuestra salvación bajó del cielo,\n(todos se inclinan con reverencia)\ny por obra del Espíritu Santo se encarnó de María, la Virgen, y se hizo hombre;\ny por nuestra causa fue crucificado en tiempos de Poncio Pilato; padeció y fue sepultado, y resucitó al tercer día, según las Escrituras, y subió al cielo, y está sentado a la derecha del Padre; y de nuevo vendrá con gloria para juzgar a vivos y muertos, y su reino no tendrá fin.\n\nCreo en el Espíritu Santo, Señor y dador de vida, que procede del Padre y del Hijo, que con el Padre y el Hijo recibe una misma adoración y gloria, y que habló por los profetas.\n\nCreo en la Iglesia, que es una, santa, católica y apostólica. Confieso que hay un solo Bautismo para el perdón de los pecados. Espero la resurrección de los muertos y la vida del mundo futuro. Amén.",
      rubric = "Los fieles se ponen de pie para proclamar las verdades de fe los domingos y solemnidades. Todos se inclinan profundamente al proclamar la Encarnación del Señor.",
      latinTitle = "Symbolum Nicaenum-Constantinopolitanum",
      latinPeopleResponse = "R/. Credo in unum Deum, Patrem omnipotentem, factorem caeli et terrae, visibilium omnium et invisibilium. Et in unum Dominum Iesum Christum, Filium Dei unigenitum, et ex Patre natum ante omnia saecula...",
      explanation = "Resumen sublime de la fe apostólica proclamado comunitariamente en respuesta y adhesión a la Palabra de Dios."
    ),
    OrdinaryPart(
      id = "oracion_universal_fieles",
      section = "Liturgia de la Palabra",
      title = "Oración Universal (Plegaria de los Fieles)",
      priestDialogue = "El sacerdote invita a la plegaria:\n«Oremos, hermanos, a Dios Padre todopoderoso por las necesidades de la Santa Iglesia y del mundo entero.»\n\nEl lector proclama las intenciones:\n«Por... Roguemos al Señor.»",
      peopleResponse = "R/. Te rogamos, óyenos.\n(O bien: «Escúchanos, Señor»).\n\nEl sacerdote concluye:\n«Dios y Padre nuestro, atiende con amor las súplicas de tu Iglesia. Por Jesucristo, nuestro Señor.»\nR/. Amén.",
      rubric = "Los fieles permanecen de pie y responden con fe a cada intención por las necesidades de la Iglesia y del mundo.",
      latinTitle = "Oratio Universalis",
      latinPeopleResponse = "R/. Te rogamus, audi nos.",
      explanation = "El pueblo sacerdotal bautizado ejerce su intercesión por la humanidad entera."
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
      id = "doxologia_gran_amen",
      section = "Liturgia Eucarística",
      title = "Doxología Final y Gran Amén",
      priestDialogue = "El sacerdote eleva solemnemente la patena con la Hostia Consagrada y el Cáliz con la Preciosa Sangre, proclamando:\n«POR CRISTO, CON ÉL Y EN ÉL, A TI, DIOS PADRE OMNIPOTENTE, EN LA UNIDAD DEL ESPÍRITU SANTO, TODO HONOR Y TODA GLORIA POR LOS SIGLOS DE LOS SIGLOS.»",
      peopleResponse = "R/. ¡AMÉN!\n(Respuesta comunitaria solemne ratificando la ofrenda salvífica de Cristo).",
      rubric = "Los fieles contemplan la elevación de las especies sagradas y aclaman con el Gran Amén de la asamblea.",
      latinTitle = "Doxologia Finalis",
      latinPeopleResponse = "R/. Amen.",
      explanation = "Culmen de la Plegaria Eucarística: todo el homenaje y gloria son tributados a la Trinidad Santa."
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
