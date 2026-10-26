package com.example.data

import com.example.model.CatholicPrayer
import com.example.model.PrayerCategory
import com.example.model.PrayerPurpose

object PrayerRepository {

  val prayers: List<CatholicPrayer> = listOf(
    // ==================== APARTADO ESPECIAL DEL ESPÍRITU SANTO ====================
    CatholicPrayer(
      id = "oracion_cardenal_verdier",
      title = "Oración al Espíritu Santo (Cardenal Verdier)",
      latinTitle = "Oratio ad Spiritum Sanctum (Cardinalis Verdier)",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """¡Oh Espíritu Santo, Amor del Padre y del Hijo!
Inspírame siempre lo que debo pensar,
lo que debo decir, cómo debo decirlo,
lo que debo callar, lo que debo escribir,
cómo debo actuar, lo que debo hacer,
para procurar vuestra gloria,
el bien de las almas y mi propia santificación.

¡Oh Jesús, toda mi confianza está en Ti!
¡Oh María, Templo del Espíritu Santo, ruega por nosotros!
Amén.""",
      description = "Célebre oración del Cardenal Jean Verdier (Arzobispo de París). Plegaria imprescindible de discernimiento para iluminar los pensamientos, palabras y obras bajo el fuego del Espíritu Santo."
    ),
    CatholicPrayer(
      id = "veni_sancte_spiritus",
      title = "Secuencia de Pentecostés",
      latinTitle = "Veni Sancte Spiritus",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Ven, Espíritu Santo,
y envía desde el cielo
un rayo de tu luz.

Ven, Padre de los pobres,
ven, dador de las gracias,
ven, luz de los corazones.

Consolador magnífico,
dulce huésped del alma,
suave alivio.

En la fatiga, descanso;
en el ardor, sosiego;
en el llanto, consuelo.

¡Oh luz santísima!,
llena lo más íntimo
de los corazones de tus fieles.

Sin tu ayuda,
nada hay en el hombre,
nada que sea inocente.

Lava lo que está manchado,
riega lo que es árido,
cura lo que está enfermo.

Doblega lo que es rígido,
calienta lo que es frío,
endereza lo que está extraviado.

Concede a tus fieles,
que en Ti confían,
tus siete sagrados dones.

Dales el mérito de la virtud,
dales el puerto de la salvación,
dales el gozo eterno.
Amén. Aleluya.""",
      description = "La 'Secuencia de Oro' de la Iglesia universal; invocación de inmensa unción para recibir el consuelo y la luz divina.",
      isTraditionLatinAvailable = true,
      latinContent = """Veni, Sancte Spiritus,
et emitte caelitus
lucis tuae radium.

Veni, pater pauperum,
veni, dator munerum,
veni, lumen cordium.

Consolator optime,
dulcis hospes animae,
dulce refrigerium.

In labore requies,
in aestu temperies,
in fletu solacium.

O lux beatissima,
reple cordis intima
tuorum fidelium.

Sine tuo numine,
nihil est in homine,
nihil est innoxium.

Lava quod est sordidum,
riga quod est aridum,
sana quod est saucium.

Flecte quod est rigidum,
fove quod est frigidum,
rege quod est devium.

Da tuis fidelibus,
in te confidentibus,
sacrum septenarium.

Da virtutis meritum,
da salutis exitum,
da perenne gaudium.
Amen. Alleluia."""
    ),
    CatholicPrayer(
      id = "veni_creator_spiritus",
      title = "Ven Creador Espíritu",
      latinTitle = "Veni Creator Spiritus",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Ven, Espíritu Creador,
visita las almas de tus fieles
y llena de la divina gracia
los corazones que Tú mismo creaste.

Tú eres nuestro Consolador,
don de Dios Altísimo,
fuente viva, fuego, caridad
y espiritual unción.

Tú derramas sobre nosotros los siete dones;
Tú, el dedo de la mano de Dios;
Tú, el prometido del Padre;
Tú, que pones en nuestros labios los tesoros de tu palabra.

Enciende con tu luz nuestros sentidos;
infunde tu amor en nuestros corazones;
y, con tu perpetuo auxilio,
fortalece nuestra débil carne.

Aleja de nosotros al enemigo,
danos pronto la paz,
sé Tú mismo nuestro guía,
y puestos bajo tu dirección, evitaremos todo mal.

Por Ti conozcamos al Padre,
y también al Hijo;
y en Ti, Espíritu de entrambos,
creamos en todo tiempo.

Gloria a Dios Padre,
y al Hijo que resucitó de entre los muertos,
y al Espíritu Consolador,
por los siglos de los siglos.
Amén.""",
      description = "Himno milenario atribuido a Rábano Mauro (siglo IX), cantado en momentos decisivos, cónclaves y ordenaciones para pedir la guía divina."
    ),
    CatholicPrayer(
      id = "oracion_siete_dones_espiritu",
      title = "Oración por los 7 Dones del Espíritu Santo",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Ven, Espíritu Santo, derrama sobre mi alma tus siete dones:

1. Ven, Espíritu de Sabiduría: enséñame a valorar las cosas eternas por encima de las pasajeras y a saborear el amor de Dios.
2. Ven, Espíritu de Entendimiento: ilumina mi mente para comprender las verdades de la fe y el sentido de mi vida.
3. Ven, Espíritu de Consejo: guíame en mis dudas para discernir siempre el camino correcto que agrada al Señor.
4. Ven, Espíritu de Fortaleza: dame valor para superar las pruebas, vencer las tentaciones y cargar mi cruz de cada día.
5. Ven, Espíritu de Ciencia: hazme ver la huella de Dios en la creación y la hermosura de sus obras.
6. Ven, Espíritu de Piedad: enciende en mi corazón un amor filial y tierno hacia Dios Padre y compasión sincera por mi prójimo.
7. Ven, Espíritu de Santo Temor de Dios: lléname de reverencia sagrada para no ofender jamás a quien tanto me ama.

Quédate conmigo hoy y guía cada una de mis palabras, pensamientos y acciones.
Amén.""",
      description = "Súplica para recibir la plenitud de los dones santificadores anunciados por el profeta Isaías (Isaías 11:2)."
    ),
    CatholicPrayer(
      id = "espiritu_santo_discernimiento",
      title = "Invocación para Tomar Decisiones (Discernimiento)",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Espíritu Santo, Luz divina que esclarece toda sombra:
Ante esta encrucijada que hoy se presenta en mi camino,
acudo a Ti con humildad y corazón abierto.

Apaga en mí la prisa, la vanidad y el temor humano.
Purifica mis intenciones para no buscar mi capricho, sino la santa voluntad del Padre.
Haz brillar la verdad y enséñame a ver las cosas no como aparentan en el mundo, sino como Tú las ves.

Pon tus palabras en mi boca, tu prudencia en mis decisiones y tu paz en mi espíritu.
No permitas que dé un paso que me aparte de Dios ni dañe a mi prójimo.
Guíame de tu mano, hoy y siempre.
Amén.""",
      description = "Oración especial para momentos en que necesitas elegir con claridad laboral, afectiva o familiar."
    ),
    CatholicPrayer(
      id = "san_agustin_espiritu_santo",
      title = "Invocación de San Agustín al Espíritu Santo",
      latinTitle = "Respira in me, Sancte Spiritus",
      category = PrayerCategory.ESPIRITU_SANTO,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Respira en mí, ¡oh Espíritu Santo!, para que mis pensamientos puedan ser todos santos.
Actúa en mí, ¡oh Espíritu Santo!, para que mi trabajo, también, pueda ser santo.
Atrae mi corazón, ¡oh Espíritu Santo!, para que solo ame lo que es santo.
Fortaléceme, ¡oh Espíritu Santo!, para que defienda todo lo que es santo.
Guárdame, ¡oh Espíritu Santo!, para que yo siempre pueda ser santo.
Amén.""",
      description = "Plegaria mística de San Agustín de Hipona (Doctor de la Gracia) para unirse al fuego de la santidad."
    ),

    // ==================== COMENZAR Y TERMINAR EL DÍA ====================
    CatholicPrayer(
      id = "ofrecimiento_manana",
      title = "Ofrecimiento de Obras del Día",
      category = PrayerCategory.MOMENTOS_DEL_DIA,
      purpose = PrayerPurpose.DIA_Y_NOCHE,
      content = """Señor Dios Todopoderoso,
que nos has hecho llegar al principio de este nuevo día;
sálvanos hoy con tu poder,
para que no caigamos en ningún pecado,
sino que nuestras palabras, pensamientos y acciones
se dirijan siempre al cumplimiento de tu santa Ley.

Te ofrezco, ¡oh Corazón Divino de Jesús!,
por medio del Corazón Inmaculado de María,
todas las oraciones, obras, trabajos, alegrías y sufrimientos
de este día, en unión con el Santo Sacrificio de la Misa
que se celebra en todo el orbe,
en reparación de nuestros pecados,
por las intenciones del Santo Padre
y la santificación de todas las almas.
Amén.""",
      description = "Oración matutina tradicional para consagrar toda la jornada laboral y familiar al Señor."
    ),
    CatholicPrayer(
      id = "examen_noche",
      title = "Oración de la Noche y Completas",
      category = PrayerCategory.MOMENTOS_DEL_DIA,
      purpose = PrayerPurpose.DIA_Y_NOCHE,
      content = """Quédate con nosotros, Señor, porque atardece y el día ya va de caída.

(Silencio para hacer examen de conciencia de las faltas cometidas hoy)
Señor, me arrepiento de corazón de todo lo que no fue agradable a tus ojos. Concédeme tu perdón y la gracia de enmendarme.

En tus manos, Señor, encomiendo mi espíritu.
Tú nos redimiste, Señor, Dios de verdad.
Sálvanos, Señor, despiertos,
protégenos mientras dormimos,
para que velemos con Cristo
y descansemos en paz.

Visita, Señor, esta habitación
y aleja de ella todas las insidias del enemigo;
que tus santos ángeles habiten en ella y nos guarden en paz,
y que tu bendición permanezca siempre sobre nosotros.
Por Cristo Nuestro Señor.
Amén.""",
      description = "Oración nocturna de entrega, purificación de la memoria y descanso confiado en Dios."
    ),
    CatholicPrayer(
      id = "bendicion_alimentos",
      title = "Bendición de la Mesa",
      category = PrayerCategory.MOMENTOS_DEL_DIA,
      purpose = PrayerPurpose.DIA_Y_NOCHE,
      content = """Antes de comer:
Bendícenos, Señor, y bendice estos alimentos
que por tu bondad vamos a tomar de tu generosa mano.
Da pan a los que tienen hambre,
y hambre de Ti a los que tienen pan.
Por Cristo Nuestro Señor.
Amén.

Después de comer:
Te damos gracias, Señor,
por todos tus dones y beneficios,
Tú que vives y reinas por los siglos de los siglos.
Que las almas de todos los fieles difuntos,
por la misericordia de Dios, descansen en paz.
Amén.""",
      description = "Gesto familiar y eucarístico de gratitud por el sustento cotidiano en la mesa."
    ),

    // ==================== PROTECCIÓN Y BATALLA ESPIRITUAL ====================
    CatholicPrayer(
      id = "san_miguel_arcangel",
      title = "San Miguel Arcángel",
      latinTitle = "Sancte Michael Archangele",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """San Miguel Arcángel,
defiéndenos en la batalla.
Sé nuestro amparo contra la perversidad
y las asechanzas del demonio.

Que Dios manifieste sobre él su poder, es nuestra humilde súplica;
y tú, ¡oh Príncipe de la Milicia Celestial!,
con el poder que Dios te ha conferido,
arroja al infierno a Satanás
y a todos los espíritus malignos
que vagan por el mundo para la perdición de las almas.
Amén.""",
      description = "Oración prescrita por el Papa León XIII en 1886 para implorar la protección del Príncipe celestial contra el mal."
    ),
    CatholicPrayer(
      id = "salmo_91",
      title = "Salmo 91 (Protección Suprema)",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """Tú que habitas al amparo del Altísimo,
que vives a la sombra del Omnipotente,
di al Señor: «Refugio mío, alcázar mío,
Dios mío, en quien confío».

Él te librará de la red del cazador,
de la peste funesta.
Te cubrirá con sus plumas,
bajo sus alas te refugiarás:
su brazo es escudo y armadura.

No temerás el espanto nocturno,
ni la flecha que vuela de día,
ni la peste que avanza en las tinieblas,
ni la plaga que azota a pleno sol.

Caerán a tu izquierda mil,
diez mil a tu derecha;
a ti no te alcanzará.
Tan solo abre tus ojos,
verás la paga de los malvados,
porque hiciste del Señor tu refugio,
tomaste al Altísimo por defensa.

No se te acercará la desgracia,
ni la plaga llegará a tu tienda,
porque a sus ángeles ha dado órdenes
para que te guarden en tus caminos;
te llevarán en sus palmas,
para que tu pie no tropiece en la piedra.

«Se puso junto a mí: lo libraré;
lo protegeré porque conoce mi nombre;
me invocará y lo escucharé.
Con él estaré en la tribulación,
lo defenderé, lo glorificaré;
lo saciaré de largos días,
y le haré ver mi salvación».
Amén.""",
      description = "La mayor oración bíblica de amparo y seguridad bajo la providencia del Dios Altísimo."
    ),
    CatholicPrayer(
      id = "cruz_san_benito",
      title = "Oración y Cruz de San Benito",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """La Santa Cruz sea mi luz,
y no sea el demonio mi guía.
¡Apártate, Satanás!
No me sugieras cosas vanas,
malas son las cosas que tú brindas,
bebe tú mismo tu propio veneno.

En el nombre del Padre, y del Hijo, y del Espíritu Santo.
Amén.

(Siglas de la Medalla de San Benito:
C.S.P.B.: Crux Sancti Patris Benedicti
C.S.S.M.L.: Crux Sacra Sit Mihi Lux
N.D.S.M.D.: Non Draco Sit Mihi Dux
V.R.S.: Vade Retro Satana
N.S.M.V.: Non Suade Mihi Vana
S.M.Q.L.: Sunt Mala Quae Libas
I.V.B.: Ipse Venena Bibas)""",
      description = "Poderoso exorcismo e invocación contra el engaño del maligno y las acechanzas espirituales."
    ),
    CatholicPrayer(
      id = "angel_de_la_guarda",
      title = "Ángel de la Guarda",
      latinTitle = "Angele Dei",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """Ángel de mi guarda,
dulce compañía,
no me desampares,
ni de noche ni de día,
no me dejes solo,
que me perdería,
hasta que amanezca
en los brazos de Jesús, José y María.
Amén.""",
      description = "Tierna invocación al santo ángel custodio que Dios asigna a cada alma para guiarla hacia la salvación."
    ),

    // ==================== PAZ INTERIOR Y SERENIDAD ====================
    CatholicPrayer(
      id = "nada_te_turbe",
      title = "Nada te Turbe",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Nada te turbe,
nada te espante,
todo se pasa,
Dios no se muda.

La paciencia
todo lo alcanza;
quien a Dios tiene
nada le falta:
¡Solo Dios basta!
Amén.""",
      description = "Poema místico hallado en el breviario de Santa Teresa de Jesús (Doctora de la Iglesia), bálsamo para el alma en aflicción."
    ),
    CatholicPrayer(
      id = "oracion_san_francisco",
      title = "Oración de San Francisco de Asís",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Señor, hazme un instrumento de tu paz:
donde haya odio, ponga yo amor;
donde haya ofensa, ponga yo perdón;
donde haya discordia, ponga yo unión;
donde haya error, ponga yo verdad;
donde haya duda, ponga yo la fe;
donde haya desesperación, ponga yo esperanza;
donde haya tinieblas, ponga yo la luz;
donde haya tristeza, ponga yo alegría.

¡Oh Maestro!, que no busque yo tanto
ser consolado como consolar,
ser comprendido como comprender,
ser amado como amar.

Porque dando es como se recibe,
olvidando es como se encuentra,
perdonando es como se es perdonado,
y muriendo es como se resucita a la vida eterna.
Amén.""",
      description = "Magnífica plegaria de desprendimiento y bienaventuranza del Pobrecillo de Asís."
    ),
    CatholicPrayer(
      id = "oracion_abandono",
      title = "Oración de Abandono",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Padre mío, me pongo en tus manos;
haz de mí lo que quieras.
Sea lo que sea, te doy las gracias.
Estoy dispuesto a todo, lo acepto todo,
con tal de que tu voluntad se haga en mí
y en todas tus criaturas.
No deseo nada más, Padre.

Te confío mi alma, te la doy
con todo el amor de que soy capaz,
porque te amo y necesito darme a Ti,
ponerme en tus manos sin medida,
con una infinita confianza,
porque Tú eres mi Padre.
Amén.""",
      description = "Escrita por el mártir San Carlos de Foucauld, máxima expresión de confianza y descanso filial en Dios."
    ),

    // ==================== PERDÓN Y RECONCILIACIÓN ====================
    CatholicPrayer(
      id = "acto_de_contricion",
      title = "Acto de Contrición",
      latinTitle = "Actus Contritionis",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.PERDON_Y_MISERICORDIA,
      content = """Señor mío Jesucristo, Dios y Hombre verdadero,
Creador, Padre y Redentor mío;
por ser Vos quien sois, Bondad infinita,
y porque os amo sobre todas las cosas,
me pesa de todo corazón haberos ofendido.

También me pesa porque podéis castigarme con las penas del infierno.
Ayudado de vuestra divina gracia,
propongo firmemente nunca más pecar,
confesarme y cumplir la penitencia que me fuere impuesta.
Amén.""",
      description = "Plegaria de arrepentimiento sincero indispensable antes de la Confesión y al concluir la jornada."
    ),
    CatholicPrayer(
      id = "coronilla_divina_misericordia",
      title = "Coronilla de la Divina Misericordia",
      category = PrayerCategory.DIVINA_MISERICORDIA,
      purpose = PrayerPurpose.PERDON_Y_MISERICORDIA,
      content = """Se reza utilizando las cuentas del Santo Rosario:

1. Señal de la Cruz: En el nombre del Padre, del Hijo y del Espíritu Santo. Amén.
2. Oraciones iniciales: Padre Nuestro, Ave María y Credo de los Apóstoles.

3. En la cuenta grande antes de cada decena:
«Padre Eterno, te ofrezco el Cuerpo y la Sangre, el Alma y la Divinidad de tu amadísimo Hijo, nuestro Señor Jesucristo, como propiciación de nuestros pecados y los del mundo entero.»

4. En las diez cuentas pequeñas de cada decena (10 veces):
«Por su dolorosa Pasión, ten misericordia de nosotros y del mundo entero.»

5. Al terminar las 5 decenas (repetir 3 veces):
«Santo Dios, Santo Fuerte, Santo Inmortal, ten piedad de nosotros y del mundo entero.»

Oración final:
«Oh Sangre y Agua que brotaste del Corazón de Jesús como una Fuente de Misericordia para nosotros, en Ti confío.»""",
      description = "Revelada por Jesucristo a Santa Faustina Kowalska en 1935 con la promesa de inmensas gracias a las 3:00 p.m.",
      hasCounter = true,
      counterTotal = 50
    ),

    // ==================== ALABANZA Y SANTÍSIMO SACRAMENTO ====================
    CatholicPrayer(
      id = "padre_nuestro",
      title = "Padre Nuestro",
      latinTitle = "Pater Noster",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Padre nuestro, que estás en el cielo,
santificado sea tu Nombre;
venga a nosotros tu Reino;
hágase tu voluntad en la tierra como en el cielo.

Danos hoy nuestro pan de cada día;
perdona nuestras ofensas,
como también nosotros perdonamos a los que nos ofenden;
no nos dejes caer en la tentación,
y líbranos del mal.
Amén.""",
      description = "La oración que el Señor Jesús enseñó directamente a sus apóstoles (Mateo 6:9-13). Base de toda la vida cristiana.",
      isTraditionLatinAvailable = true,
      latinContent = """Pater noster, qui es in caelis,
sanctificetur nomen tuum.
Adveniat regnum tuum.
Fiat voluntas tua, sicut in caelo et in terra.

Panem nostrum cotidianum da nobis hodie,
et dimitte nobis debita nostra,
sicut et nos dimittimus debitoribus nostris.
Et ne nos inducas in tentationem,
sed libera nos a malo.
Amen."""
    ),
    CatholicPrayer(
      id = "gloria_al_padre",
      title = "Gloria al Padre",
      latinTitle = "Gloria Patri",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Gloria al Padre, y al Hijo, y al Espíritu Santo.
Como era en el principio, ahora y siempre,
por los siglos de los siglos.
Amén.""",
      description = "Doxología solemne a la Santísima Trinidad proclamada al final de cada salmo y misterio.",
      isTraditionLatinAvailable = true,
      latinContent = """Gloria Patri, et Filio, et Spiritui Sancto.
Sicut erat in principio, et nunc, et semper,
et in saecula saeculorum.
Amen."""
    ),
    CatholicPrayer(
      id = "credo_apostolico",
      title = "Credo de los Apóstoles",
      latinTitle = "Symbolum Apostolorum",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Creo en Dios, Padre todopoderoso,
Creador del cielo y de la tierra.

Creo en Jesucristo, su único Hijo, nuestro Señor,
que fue concebido por obra y gracia del Espíritu Santo,
nació de Santa María Virgen,
padeció bajo el poder de Poncio Pilato,
fue crucificado, muerto y sepultado,
descendió a los infiernos,
al tercer día resucitó de entre los muertos,
subió a los cielos
y está sentado a la derecha de Dios, Padre todopoderoso.
Desde allí ha de venir a juzgar a vivos y muertos.

Creo en el Espíritu Santo,
la santa Iglesia católica,
la comunión de los santos,
el perdón de los pecados,
la resurrección de la carne
y la vida eterna.
Amén.""",
      description = "Resumen fiel de la fe apostólica guardada por la Iglesia desde los primeros siglos."
    ),
    CatholicPrayer(
      id = "alma_de_cristo",
      title = "Alma de Cristo",
      latinTitle = "Anima Christi",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Alma de Cristo, santifícame.
Cuerpo de Cristo, sálvame.
Sangre de Cristo, embriágame.
Agua del costado de Cristo, lávame.
Pasión de Cristo, confórtame.
¡Oh, buen Jesús!, óyeme.
Dentro de tus llagas, escóndeme.
No permitas que me aparte de Ti.
Del enemigo maligno, defiéndeme.
En la hora de mi muerte, llámame.
Y mándame ir a Ti,
para que con tus santos te alabe,
por los siglos de los siglos.
Amén.""",
      description = "Invocación de íntima unión tras recibir la Sagrada Eucaristía, atribuida a San Ignacio de Loyola."
    ),
    CatholicPrayer(
      id = "comunion_espiritual",
      title = "Comunión Espiritual",
      latinTitle = "Communio Spiritualis",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Creo, Jesús mío,
que estás real y verdaderamente presente
en el Santísimo Sacramento del Altar.

Te amo sobre todas las cosas
y deseo ardientemente recibirte dentro de mi alma;
pero no pudiendo hacerlo ahora sacramentalmente,
ven al menos espiritualmente a mi corazón.

Y como si ya te hubiese recibido,
te abrazo y me uno del todo a Ti;
no permitas, Señor, que jamás me separe de Ti.
Amén.""",
      description = "Oración de San Alfonso María de Ligorio para unirse espiritualmente a Cristo cuando no es posible comulgar físicamente."
    ),

    // ==================== VIRGEN MARÍA Y SANTO ROSARIO ====================
    CatholicPrayer(
      id = "ave_maria",
      title = "Ave María",
      latinTitle = "Ave Maria",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Dios te salve, María, llena eres de gracia;
el Señor es contigo.
Bendita tú eres entre todas las mujeres,
y bendito es el fruto de tu vientre, Jesús.

Santa María, Madre de Dios,
ruega por nosotros, pecadores,
ahora y en la hora de nuestra muerte.
Amén.""",
      description = "Salutación angélica inspirada en San Gabriel Arcángel y Santa Isabel (Lucas 1).",
      isTraditionLatinAvailable = true,
      latinContent = """Ave Maria, gratia plena,
Dominus tecum.
Benedicta tu in mulieribus,
et benedictus fructus ventris tui, Iesus.

Sancta Maria, Mater Dei,
ora pro nobis peccatoribus,
nunc et in hora mortis nostrae.
Amen."""
    ),
    CatholicPrayer(
      id = "salve_regina",
      title = "La Salve",
      latinTitle = "Salve Regina",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Dios te salve, Reina y Madre de misericordia,
vida, dulzura y esperanza nuestra; Dios te salve.
A ti clamamos los desterrados hijos de Eva;
a ti suspiramos, gimiendo y llorando,
en este valle de lágrimas.

Ella, pues, Señora, abogada nuestra,
vuelve a nosotros esos tus ojos misericordiosos;
y después de este destierro muéstranos a Jesús,
fruto bendito de tu vientre.
¡Oh clemente, oh piadosa, oh dulce Virgen María!

V. Ruega por nosotros, Santa Madre de Dios.
R. Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo.
Amén.""",
      description = "Antífona mariana del siglo XI entonada devotamente al finalizar el Santo Rosario."
    ),
    CatholicPrayer(
      id = "santo_rosario_guia",
      title = "Santo Rosario (Estructura y Misterios)",
      category = PrayerCategory.ROSARIO,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Guía de los Santos Misterios por día de la semana:

• LUNES Y SÁBADOS - Misterios Gozosos:
1. La Anunciación del Ángel a María y la Encarnación del Hijo de Dios.
2. La Visitación de Nuestra Señora a su prima Santa Isabel.
3. El Nacimiento del Niño Jesús en el portal de Belén.
4. La Presentación del Niño Jesús en el Templo y Purificación de María.
5. El Niño Jesús perdido y hallado en el Templo entre los doctores.

• MARTES Y VIERNES - Misterios Dolorosos:
1. La Agonía y Oración de Jesús en el Huerto de Getsemaní.
2. La Flagelación de Nuestro Señor atado a la columna.
3. La Coronación de espinas y ultraje a Nuestro Rey.
4. Jesús con la Cruz a cuestas camino al Calvario.
5. La Crucifixión, Agonía y Muerte de Nuestro Señor Jesucristo.

• MIÉRCOLES Y DOMINGOS - Misterios Gloriosos:
1. La Triunfante Resurrección de Nuestro Señor de entre los muertos.
2. La gloriosa Ascensión de Jesús a los Cielos.
3. La Venida del Espíritu Santo en Pentecostés sobre María y los Apóstoles.
4. La Asunción de la Santísima Virgen María en cuerpo y alma a los cielos.
5. La Coronación de María Santísima como Reina de cielos y tierra.

• JUEVES - Misterios Luminosos (San Juan Pablo II):
1. El Bautismo de Nuestro Señor Jesucristo en el río Jordán.
2. La Autorrevelación de Jesús en las Bodas de Caná.
3. El Anuncio del Reino de Dios invitando a la conversión.
4. La Transfiguración del Señor en el monte Tabor.
5. La Institución de la Sagrada Eucaristía en la Última Cena.

Cada decena se compone de:
1 Padre Nuestro + 10 Ave Marías + 1 Gloria al Padre + Jaculatoria de Fátima:
«¡Oh Jesús mío, perdona nuestros pecados, líbranos del fuego del infierno, lleva al cielo a todas las almas, especialmente a las más necesitadas de tu misericordia!»""",
      description = "El compendio evangélico y contemplativo entregado por la Virgen María a Santo Domingo de Guzmán.",
      hasCounter = true,
      counterTotal = 50
    ),
    CatholicPrayer(
      id = "magnificat",
      title = "El Magníficat (Cántico de María)",
      latinTitle = "Magnificat",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Proclama mi alma la grandeza del Señor,
se alegra mi espíritu en Dios, mi Salvador;
porque ha mirado la humillación de su esclava.

Desde ahora me felicitarán todas las generaciones,
porque el Poderoso ha hecho obras grandes por mí:
su nombre es santo,
y su misericordia llega a sus fieles
de generación en generación.

Él hace proezas con su brazo:
dispersa a los soberbios de corazón,
derriba del trono a los poderosos
y enaltece a los humildes,
a los hambrientos los colma de bienes
y a los ricos los despide vacíos.

Auxilia a Israel, su siervo,
acordándose de la misericordia
—como lo había prometido a nuestros padres—
en favor de Abrahán y su descendencia por siempre.
Amén.""",
      description = "Cántico glorioso de María en casa de su prima Isabel (Lucas 1:46-55)."
    ),
    CatholicPrayer(
      id = "memorare_acordaos",
      title = "El Acordaos",
      latinTitle = "Memorare",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Acordaos, ¡oh piadosísima Virgen María!,
que jamás se ha oído decir
que ninguno de los que han acudido a vuestra protección,
implorado vuestra asistencia
y reclamado vuestro socorro,
haya sido desamparado de Vos.

Animado con esta confianza, a Vos acudo,
¡oh Madre, Virgen de las vírgenes!;
a Vos vengo, delante de Vos me presento,
pecador y compungido.

¡Oh Madre del Verbo encarnado!,
no despreciéis mis súplicas,
antes bien, escuchadlas favorablemente y acogedlas con piedad.
Amén.""",
      description = "Oración mariana atribuida a San Bernardo de Claraval, de inquebrantable confianza filial."
    ),

    // ==================== POR LOS DIFUNTOS ====================
    CatholicPrayer(
      id = "por_los_difuntos",
      title = "Oración por los Fieles Difuntos (Réquiem)",
      latinTitle = "Requiem Aeternam",
      category = PrayerCategory.DIFUNTOS,
      purpose = PrayerPurpose.DIFUNTOS,
      content = """Dale, Señor, el descanso eterno,
y brille para ellos la luz perpetua.

Que las almas de todos los fieles difuntos,
por la infinita misericordia de Dios,
descansen en paz.
Amén.

Salmo 130 (De Profundis):
Desde lo más profundo a ti grito, Señor;
Señor, escucha mi voz;
estén tus oídos atentos
a la voz de mi súplica.

Si llevas cuenta de los delitos, Señor,
¿quién podrá resistir?
Pero de ti procede el perdón,
y así infundes respeto.

Mi alma espera en el Señor,
espera en su palabra;
mi alma aguarda al Señor,
más que los centinelas la aurora.
Amén.""",
      description = "Plegaria de sufragio de la Iglesia por el descanso de las almas en el purgatorio."
    ),

    // ==================== NUEVAS ORACIONES APROBADAS POR LA IGLESIA ====================
    CatholicPrayer(
      id = "adoro_te_devote",
      title = "Adoro Te Devote (Te adoro con devoción)",
      latinTitle = "Adoro Te Devote",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Te adoro con devoción, Dios escondido,
que bajo estas formas realmente te ocultas;
a Ti mi corazón se rinde por entero,
porque al contemplarte todo desfallece.

Al juzgar de Ti se engañan la vista, el tacto, el gusto;
pero solo con el oído se te cree con firmeza;
creo todo lo que dijo el Hijo de Dios:
nada es más verdadero que esta palabra de Verdad.

En la Cruz se escondía solo la Divinidad,
pero aquí se esconde también la Humanidad;
creo y confieso ambas cosas,
y pido lo que pidió el ladrón arrepentido.

No veo las llagas como vio Tomás,
pero confieso que eres mi Dios;
haz que yo crea siempre más en Ti,
que en Ti espere y te ame.

¡Oh Memorial de la Muerte del Señor!
Pan vivo que das la vida al hombre:
concede a mi alma que de Ti viva
y que siempre le seas dulce.

Jesús piadoso, Cordero de Dios,
límpiame a mí, inmundo, con tu Sangre,
de la que una sola gota puede salvar
al mundo entero de todo pecado.

Jesús, a quien ahora contemplo oculto,
te ruego que se cumpla lo que tanto ansío:
que al mirar tu rostro al descubierto,
sea yo bienaventurado contemplando tu gloria.
Amén.""",
      description = "Himno eucarístico compuesto por Santo Tomás de Aquino en 1264 a petición del Papa Urbano IV para la fiesta del Corpus Christi.",
      isTraditionLatinAvailable = true,
      latinContent = """Adoro te devote, latens Deitas,
Quae sub his figuris vere latitas:
Tibi se cor meum totum subiicit,
Quia te contemplans totum deficit.

Visus, tactus, gustus in te fallitur,
Sed auditu solo tuto creditur.
Credo quidquid dixit Dei Filius:
Nil hoc verbo Veritatis verius.

Iesu, quem velatum nunc aspicio,
Oro fiat illud quod tam sitio;
Ut te revelata cernens facie,
Visu sim beatus tuae gloriae. Amen."""
    ),
    CatholicPrayer(
      id = "tantum_ergo",
      title = "Tantum Ergo (Bendición Eucarística)",
      latinTitle = "Tantum Ergo Sacramentum",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Adoremos, pues, postrados
a tan grande Sacramento;
y la antigua figura
ceda el paso al nuevo rito;
supla la fe el defecto
de nuestros sentidos.

Al Padre y al Hijo
sean dadas alabanzas y júbilo,
salud, honor, poder
y bendición;
y al que procede de entrambos
se dé una gloria igual.
Amén.

V. Les diste pan del cielo.
R. Que contiene en sí todo deleite.

Oración:
Oh Dios, que en este sacramento admirable nos dejaste el memorial de tu pasión: concédenos venerar de tal modo los sagrados misterios de tu Cuerpo y de tu Sangre, que experimentemos constantemente en nosotros el fruto de tu redención. Tú que vives y reinas por los siglos de los siglos.
Amén.""",
      description = "Las dos últimas estrofas del himno Pange Lingua de Santo Tomás de Aquino, entonado durante la bendición solemne con el Santísimo Sacramento.",
      isTraditionLatinAvailable = true,
      latinContent = """Tantum ergo Sacramentum
veneremur cernui:
et antiquum documentum
novo cedat ritui:
praestet fides supplementum
sensuum defectui.

Genitori, Genitoque
laus et iubilatio,
salus, honor, virtus quoque
sit et benedictio:
Procedenti ab utroque
compar sit laudatio.
Amen."""
    ),
    CatholicPrayer(
      id = "te_deum",
      title = "Te Deum (A ti, oh Dios, te alabamos)",
      latinTitle = "Te Deum Laudamus",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """A ti, oh Dios, te alabamos, a ti, Señor, te reconocemos.
A ti, eterno Padre, te venera toda la creación.
Los ángeles todos, los cielos y todas las potestades te honran;
los querubines y serafines te cantan sin cesar:
Santo, Santo, Santo es el Señor, Dios del universo.
Llenos están los cielos y la tierra de la majestad de tu gloria.

A ti te ensalza el glorioso coro de los apóstoles,
la multitud admirable de los profetas,
el blanco ejército de los mártires.
A ti te confiesa la santa Iglesia extendida por toda la tierra:
Padre de inmensa majestad,
Hijo único y verdadero, digno de adoración,
Espíritu Santo, Defensor y Consolador.

Tú eres el Rey de la gloria, Cristo.
Tú eres el Hijo eterno del Padre.
Tú, para librar al hombre, no te horrorizaste del seno de la Virgen.
Tú, vencida la muerte, abriste a los creyentes el Reino de los Cielos.
Tú estás sentado a la derecha de Dios en la gloria del Padre.
Creemos que vendrás como juez.

Te rogamos, pues, que ayudes a tus siervos,
a quienes redimiste con tu preciosa Sangre.
Haz que en la gloria eterna seamos contados entre tus santos.
Salva a tu pueblo, Señor, y bendice tu heredad.
Sé su pastor y ensálzalo por siempre.
Día tras día te bendecimos y alabamos tu nombre por los siglos de los siglos.
Dígnate, Señor, en este día guardarnos sin pecado.
Ten piedad de nosotros, Señor, ten piedad de nosotros.
Que tu misericordia, Señor, venga sobre nosotros, como lo esperamos de Ti.
En Ti, Señor, he confiado: no quede yo defraudado para siempre.
Amén.""",
      description = "El himno solemne de acción de gracias de la Iglesia universal por excelencia, cantado en solemnidades, año nuevo y ordenaciones."
    ),
    CatholicPrayer(
      id = "actos_teologales",
      title = "Actos de Fe, Esperanza y Caridad",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Acto de Fe:
Dios mío, creo firmemente en Ti, que eres un solo Dios en tres Personas divinas: Padre, Hijo y Espíritu Santo. Creo que el Hijo se hizo hombre, padeció y murió en la cruz por nuestra salvación y resucitó al tercer día. Creo todo lo que la Santa Iglesia Católica enseña, porque Tú, Verdad infalible, lo has revelado. Señor, aumenta mi fe.

Acto de Esperanza:
Dios mío, porque eres infinitamente bueno, fiel a tus promesas y todopoderoso, espero alcanzar por los méritos de Jesucristo el perdón de mis pecados, tu divina gracia y la vida eterna bienaventurada. En Ti, Señor, he puesto mi esperanza.

Acto de Caridad:
Dios mío, te amo con todo mi corazón, con toda mi alma y con todas mis fuerzas, sobre todas las cosas, porque eres infinitamente bueno y digno de ser amado; y por amor a Ti amo a mi prójimo como a mí mismo y perdono de corazón todas las ofensas recibidas. Señor, enciende en mí el fuego de tu santo amor.
Amén.""",
      description = "Plegarias tradicionales de las virtudes teologales infundidas en el Bautismo para fortalecer la vida interior diaria."
    ),
    CatholicPrayer(
      id = "letanias_lauretanas",
      title = "Letanías Lauretanas de la Santísima Virgen",
      latinTitle = "Litaniae Lauretanae",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Señor, ten piedad. Cristo, ten piedad. Señor, ten piedad.
Cristo, óyenos. Cristo, escúchanos.

Dios, Padre celestial, ten piedad de nosotros.
Dios, Hijo, Redentor del mundo, ten piedad de nosotros.
Dios, Espíritu Santo, ten piedad de nosotros.
Santísima Trinidad, un solo Dios, ten piedad de nosotros.

Santa María, *ruega por nosotros.*
Santa Madre de Dios, *ruega por nosotros.*
Santa Virgen de las Vírgenes, *ruega por nosotros.*
Madre de Cristo, Madre de la Iglesia, Madre de la misericordia,
Madre de la divina gracia, Madre de la esperanza,
Madre purísima, Madre castísima, Madre incorrupta,
Madre inmaculada, Madre amable, Madre admirable,
Madre del buen consejo, Madre del Creador, Madre del Salvador,
Virgen prudentísima, Virgen digna de veneración, Virgen digna de alabanza,
Virgen poderosa, Virgen clemente, Virgen fiel,
Espejo de justicia, Trono de la sabiduría, Causa de nuestra alegría,
Vaso espiritual, Vaso de honor, Vaso insigne de devoción,
Rosa mística, Torre de David, Torre de marfil,
Casa de oro, Arca de la Alianza, Puerta del cielo,
Estrella de la mañana, Salud de los enfermos, Refugio de los pecadores,
Consuelo de los migrantes, Consoladora de los afligidos, Auxilio de los cristianos,
Reina de los Ángeles, Reina de los Patriarcas, Reina de los Profetas,
Reina de los Apóstoles, Reina de los Mártires, Reina de los Confesores,
Reina de las Vírgenes, Reina de todos los Santos,
Reina concebida sin pecado original, Reina asunta a los Cielos,
Reina del Santísimo Rosario, Reina de la familia, Reina de la paz.

Cordero de Dios, que quitas el pecado del mundo, perdónanos, Señor.
Cordero de Dios, que quitas el pecado del mundo, escúchanos, Señor.
Cordero de Dios, que quitas el pecado del mundo, ten piedad de nosotros.

V. Ruega por nosotros, Santa Madre de Dios.
R. Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo.
Amén.""",
      description = "Súplicas marianas aprobadas por el Papa Sixto V en 1587, rezadas habitualmente al concluir el Santo Rosario."
    ),
    CatholicPrayer(
      id = "virgen_de_guadalupe",
      title = "A Nuestra Señora de Guadalupe",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """¡Oh Virgen Inmaculada, Madre del verdadero Dios y Madre de la Iglesia!
Tú que desde el Tepeyac manifiestas tu clemencia y compasión a cuantos solicitan tu amparo:
escucha el ruego que con filial confianza te dirigimos y preséntalo ante tu Hijo Jesús, nuestro único Redentor.

Madre de misericordia, Maestra del sacrificio escondido y silencioso:
a Ti, que sales al encuentro de nosotros, los pecadores, consagramos en este día todo nuestro ser y todo nuestro amor.
Consagramos también nuestras familias, nuestro trabajo y nuestras patrias.

Danos paz, justicia y prosperidad; haz que nuestras vidas se conformen cada día más al Santo Evangelio.
Guarda nuestras almas en la pureza de la fe y alcánzanos la gracia de perseverar en el amor de Dios hasta el fin.
Amén.""",
      description = "Oración solemne a la Patrona de América y Emperatriz de las Américas proclamada por San Juan Pablo II."
    ),
    CatholicPrayer(
      id = "virgen_del_carmen",
      title = "A Nuestra Señora del Carmen (Flor del Carmelo)",
      latinTitle = "Flos Carmeli",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """¡Oh Flor del Carmelo, viña florida,
esplendor del cielo, Virgen fecunda, singular!
¡Oh Madre dulce, de varón no conocida,
a los carmelitas da tu favor, Estrella del mar!

Bajo tu Santo Escapulario nos cobijamos, Señora:
sé nuestra defensa en los peligros,
nuestro auxilio en las tentaciones
y nuestro consuelo en la hora de la muerte.

Que tu manto maternal nos guarde en la gracia santificante,
y por tus méritos seamos liberados de las penas del purgatorio
para contemplarte junto a tu Hijo en la gloria celestial.
Amén.""",
      description = "Súplica secular vinculada al don del Santo Escapulario entregado por la Virgen a San Simón Stock."
    ),
    CatholicPrayer(
      id = "san_jose_patris_corde",
      title = "A San José (Papa Francisco - Patris Corde)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PROTECCION,
      content = """Salve, custodio del Redentor
y esposo de la Virgen María.
A ti Dios confió a su Hijo,
en ti María depositó su confianza,
contigo Cristo se forjó como hombre.

Oh, bienaventurado José,
muéstrate padre también a nosotros
y guíanos en el camino de la vida.
Concédenos gracia, misericordia y valentía,
y defiéndenos de todo mal.
Amén.""",
      description = "Oración escrita por el Papa Francisco en la Carta Apostólica Patris Corde para honrar al Santo Patriarca custodio de la Iglesia."
    ),
    CatholicPrayer(
      id = "san_judas_tadeo",
      title = "A San Judas Tadeo (Causas Difíciles)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Oh glorioso Apóstol San Judas Tadeo, fiel siervo y amigo de Jesús!
El nombre del traidor ha sido la causa de que muchos te hayan olvidado, pero la Iglesia te honra e invoca universalmente como el celestial patrón de los casos difíciles y desesperados.

Ruega por mí, que soy tan necesitado. Haz uso, te ruego, de ese privilegio especial a ti concedido de socorrer pronto y visiblemente cuando casi se ha perdido toda esperanza.

Ven en mi ayuda en esta gran necesidad, para que pueda recibir los consuelos y el socorro del cielo en todas mis tribulaciones y sufrimientos, y para que pueda bendecir a Dios contigo y con todos los escogidos por toda la eternidad.

Te prometo, glorioso San Judas, acordarme siempre de este gran favor, honrarte siempre como mi especial y poderoso protector, y hacer con todo fervor cuanto pueda para fomentar tu devoción.
Amén.""",
      description = "Súplica secular de intercesión al Santo Apóstol protector en circunstancias de extrema angustia o causa perdida."
    ),
    CatholicPrayer(
      id = "oracion_salud_enfermos",
      title = "Oración por la Salud y los Enfermos",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """Señor Jesús, Médico divino de los cuerpos y de las almas:
Tú que pasaste haciendo el bien, sanando toda dolencia y aliviando con ternura a los que sufrían:
mira con ojos de infinita misericordia a nuestros hermanos enfermos, ancianos y afligidos.

Te encomendamos sus dolores, sus angustias y sus noches de inquietud.
Renueva sus fuerzas, devuelve la salud a sus cuerpos si es para gloria tuya y bien de sus almas,
y concede a sus corazones la paz y la fortaleza sobrenatural para unir sus sufrimientos a tu Santa Cruz redentora.

Bendice las manos de los médicos, enfermeros, cuidadores y familiares,
para que sean reflejo vivo de tu consuelo y caridad.
Virgen María, Salud de los Enfermos y Consuelo de los Afligidos, ruega por nosotros.
Amén.""",
      description = "Invocación de sanación física y espiritual confiando en la compasión de Cristo y el cuidado de los que sufren."
    ),
    CatholicPrayer(
      id = "san_antonio_de_padua",
      title = "A San Antonio de Padua (Doctor Evangélico)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """¡Oh bendito San Antonio de Padua, lirio de castidad y gloria de la Iglesia!
Tú que mereciste tener en tus brazos al Niño Jesús y proclamaste el Evangelio con ardor y caridad inagotables:
vuelve a mí tu mirada compasiva.

Ayúdame a recuperar la gracia y amistad de Dios si la he perdido por el pecado;
socórreme en mis necesidades materiales y espirituales;
y alcánzame fortaleza para conservar la fe intacta en medio de las pruebas del mundo.

Tú que eres invocado por el pueblo cristiano para hallar lo que se ha extraviado,
encuéntrame en mis momentos de duda, tentación o desaliento, y guíame de vuelta al camino de la Verdad,
para que amando a Dios sobre todas las cosas, llegue a gozar de su presencia en la eternidad.
Amén.""",
      description = "Famosa plegaria al Taumaturgo de Padua para hallar consuelo, recuperar la fe y recibir socorro en las necesidades."
    ),
    CatholicPrayer(
      id = "consagracion_sagrado_corazon",
      title = "Consagración al Sagrado Corazón de Jesús",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Rendido a tus pies, ¡oh Jesús mío!, considerando las inefables muestras de amor que me has dado y las sublimes virtudes de tu adorable Corazón, te pido humildemente la gracia de conocerte, amarte y servirte fielmente todos los días de mi vida.

Yo me entrego y consagro enteramente a tu Sagrado Corazón: mi alma, mi cuerpo, mis acciones, alegrías, penas y sufrimientos, para no querer servirme de ninguna parte de mi ser sino para honrarte, amarte y glorificarte.

Sé, pues, ¡oh Corazón bondadoso!, mi único refugio en la vida y mi amparo seguro en la hora de mi muerte; la reparación de mis culpas, la defensa en mis tentaciones y la santificación de mi familia.
¡Sagrado Corazón de Jesús, en Ti confío!
Amén.""",
      description = "Oración de consagración y entrega filial inspirada en las revelaciones de Paray-le-Monial a Santa Margarita María Alacoque."
    ),
    CatholicPrayer(
      id = "angelus_domini",
      title = "El Ángelus (Salutación Mariana)",
      latinTitle = "Angelus Domini",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.DIA_Y_NOCHE,
      content = """V. El Ángel del Señor anunció a María.
R. Y concibió por obra y gracia del Espíritu Santo.
(Dios te salve, María...)

V. He aquí la esclava del Señor.
R. Hágase en mí según tu palabra.
(Dios te salve, María...)

V. Y el Verbo de Dios se hizo carne.
R. Y habitó entre nosotros.
(Dios te salve, María...)

V. Ruega por nosotros, Santa Madre de Dios.
R. Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo.

Oración:
Te rogamos, Señor, que derrames tu gracia en nuestras almas; para que los que, por el anuncio del Ángel, hemos conocido la encarnación de tu Hijo Jesucristo, por los méritos de su pasión y cruz seamos llevados a la gloria de su resurrección. Por el mismo Jesucristo Nuestro Señor.
Amén.""",
      description = "Milenaria oración mariana que la Iglesia reza al alba, al mediodía (12:00 m.) y al atardecer para honrar la Encarnación del Salvador.",
      isTraditionLatinAvailable = true,
      latinContent = """V. Angelus Domini nuntiavit Mariae.
R. Et concepit de Spiritu Sancto.
(Ave Maria...)

V. Ecce ancilla Domini.
R. Fiat mihi secundum verbum tuum.
(Ave Maria...)

V. Et Verbum caro factum est.
R. Et habitavit in nobis.
(Ave Maria...)

V. Ora pro nobis, Sancta Dei Genetrix.
R. Ut digni efficiamur promissionibus Christi.

Oremus:
Gratiam tuam, quaesumus, Domine, mentibus nostris infunde; ut qui, Angelo nuntiante, Christi Filii tui incarnationem cognovimus, per passionem eius et crucem ad resurrectionis gloriam perducamur. Per eundem Christum Dominum nostrum.
Amen."""
    ),
    CatholicPrayer(
      id = "regina_caeli",
      title = "Reina del Cielo (Tiempo Pascual)",
      latinTitle = "Regina Caeli, Laetare",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Reina del cielo, alégrate, ¡aleluya!,
porque el Señor, a quien mereciste llevar en tu seno, ¡aleluya!,
ha resucitado, según su palabra, ¡aleluya!
Ruega al Señor por nosotros, ¡aleluya!

V. Gózate y alégrate, Virgen María, ¡aleluya!
R. Porque verdaderamente ha resucitado el Señor, ¡aleluya!

Oración:
¡Oh Dios!, que por la gloriosa resurrección de tu Hijo, nuestro Señor Jesucristo, te dignaste llenar de júbilo al mundo entero: concédenos, por intercesión de su Madre, la Santísima Virgen María, llegar a alcanzar los gozos de la vida eterna. Por el mismo Jesucristo Nuestro Señor.
Amén.""",
      description = "Antífona mariana que sustituye al Ángelus durante el santo Tiempo de Pascua, celebrando el triunfo victorioso de Cristo sobre la muerte.",
      isTraditionLatinAvailable = true,
      latinContent = """Regina caeli, laetare, alleluia;
Quia quem meruisti portare, alleluia,
Resurrexit sicut dixit, alleluia:
Ora pro nobis Deum, alleluia.

V. Gaude et laetare, Virgo Maria, alleluia.
R. Quia surrexit Dominus vere, alleluia.

Oremus:
Deus, qui per resurrectionem Filii tui, Domini nostri Iesu Christi, mundum laetificare dignatus es: praesta, quaesumus, ut per eius Genetricem Virginem Mariam, perpetuae capiamus gaudia vitae. Per eundem Christum Dominum nostrum.
Amen."""
    ),
    CatholicPrayer(
      id = "san_cayetano_trabajo",
      title = "A San Cayetano (Pan, Paz y Trabajo)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Oh glorioso San Cayetano, Padre de la Divina Providencia!
Tú que viviste confiando plenamente en la bondad paternal de Dios,
sin atesorar grandezas terrenales y consagrando tu corazón entero a los pobres, enfermos y desamparados:
mira con bondad a nuestra familia en este día.

Danos, Señor, por intercesión de San Cayetano, salud de alma y cuerpo, paz en el espíritu y trabajo honrado y digno.
Que nunca falte el pan de cada día en nuestra mesa,
ni la concordia en nuestro hogar, ni la justicia en nuestra sociedad.

Aleja de nuestro corazón el desaliento y la queja en momentos de dificultad económica,
y concédenos buscar siempre primero el Reino de Dios y su justicia, seguros de que tu infinita providencia nunca nos abandonará.
Amén.""",
      description = "Oración tradicional al Santo de la Providencia para implorar trabajo honrado, sustento cotidiano y paz en el hogar."
    ),
    CatholicPrayer(
      id = "suscipe_domine_san_ignacio",
      title = "Tomad, Señor, y Recibid (San Ignacio)",
      latinTitle = "Suscipe, Domine",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Tomad, Señor, y recibid
toda mi libertad, mi memoria,
mi entendimiento y toda mi voluntad;
todo mi haber y mi poseer.

Vos me lo disteis, a Vos, Señor, lo torno;
todo es vuestro, disponed a toda vuestra voluntad.

Dadme vuestro amor y gracia,
que ésta me basta.
Amén.""",
      description = "La sublime oración de entrega total y contemplación para alcanzar amor de San Ignacio de Loyola (Ejercicios Espirituales).",
      isTraditionLatinAvailable = true,
      latinContent = """Suscipe, Domine, universam meam libertatem.
Accipe memoriam, intellectum atque voluntatem omnem.
Quidquid habeo vel possideo mihi largitus es;
id tibi totum restituo,
ac tuae prorsus voluntati trado gubernandum.
Amorem tui solum cum gratia tua mihi dones,
et dives sum satis,
nec sit quod praeterea requiram.
Amen."""
    ),
    CatholicPrayer(
      id = "santa_rita_de_casia",
      title = "A Santa Rita de Casia (Causas Imposibles)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PROTECCION,
      content = """Bajo el peso de la angustia y de la prueba,
a ti recurro, ¡oh gloriosa Santa Rita de Casia!,
a quien la devoción de los fieles llama la abogada de los casos desesperados y patrona de las causas imposibles.

Líbrame, te lo ruego, de la pesadumbre que agobia mi corazón,
y alcánzame de Dios la paz, el consuelo y la serenidad que tanto anhelo.
Tú que fuiste favorecida con la llaga viva de la espina del Crucificado en tu frente:
haz valer tu intercesión amorosa ante el Trono del Altísimo.

Si mis faltas y debilidades son un obstáculo para recibir lo que imploro,
alcánzame de Dios un sincero arrepentimiento, el perdón de mis pecados y la gracia de una vida santa.
No permitas que caiga en la desesperación,
sino enséñame a confiar siempre en la infinita bondad de Dios.
Amén.""",
      description = "Invocación a la insigne santa agustina de Casia, abogada celestial ante aflicciones graves e imposibles humanos."
    ),
    CatholicPrayer(
      id = "oracion_santo_tomas_estudio",
      title = "Oración de Santo Tomás para el Estudio y Trabajo",
      latinTitle = "Creator Ineffabilis",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.ESPIRITU_SANTO,
      content = """Creador inefable,
que de los tesoros de tu sabiduría ordenaste con admirable providencia el universo entero
y repartiste con divina armonía todas sus partes:

Tú, que eres llamado verdadera Fuente de Luz y Principio soberano de toda Sabiduría,
dígnate derramar sobre las tinieblas de mi inteligencia un rayo de tu claridad,
apartando de mí la doble penumbra de mi alma: el pecado y la ignorancia.

Tú, que haces hablar con sabiduría a los sencillos,
educa mi lengua e infunde en mis labios la gracia de tu bendición celestial.
Dame agudeza para entender, capacidad para retener,
método y facilidad para aprender, sutileza para interpretar
y gracia fecunda para expresarme.

Dame acierto al empezar, dirección y prudencia al progresar, y perfección al concluir.
Tú que eres verdadero Dios y verdadero Hombre,
que vives y reinas por los siglos de los siglos.
Amén.""",
      description = "Célebre oración de Santo Tomás de Aquino rezada por estudiantes, opositores y trabajadores antes de su jornada."
    ),
    CatholicPrayer(
      id = "coronilla_san_miguel_arcangel",
      title = "Coronilla a San Miguel y los 9 Coros Angélicos",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """Poderosa súplica revelada por el Arcángel San Miguel con la promesa de continua asistencia angélica durante la vida y protección especial en el momento de la muerte:

1. Por intercesión de San Miguel y el celestial Coro de los Serafines: El Señor nos haga dignos de arder en el fuego de la perfecta caridad.
(1 Padre Nuestro, 3 Ave Marías)

2. Por intercesión de San Miguel y el Coro de los Querubines: El Señor nos conceda la gracia de abandonar los caminos del pecado y correr por los de la perfección cristiana.
(1 Padre Nuestro, 3 Ave Marías)

3. Por intercesión de San Miguel y el Coro de los Tronos: El Señor infunda en nuestros corazones un sincero y humilde espíritu filial.
(1 Padre Nuestro, 3 Ave Marías)

4. Por intercesión de San Miguel y el Coro de las Dominaciones: El Señor nos dé la gracia de dominar nuestros sentidos e inclinaciones desordenadas.
(1 Padre Nuestro, 3 Ave Marías)

5. Por intercesión de San Miguel y el Coro de las Potestades: El Señor proteja nuestras almas contra las insidias y tentaciones del demonio.
(1 Padre Nuestro, 3 Ave Marías)

6. Por intercesión de San Miguel y el Coro de las Virtudes: El Señor nos preserve de todo mal y nos libre de caer en tentación.
(1 Padre Nuestro, 3 Ave Marías)

7. Por intercesión de San Miguel y el Coro de los Principados: El Señor llene nuestras almas de un verdadero y ferviente espíritu de obediencia.
(1 Padre Nuestro, 3 Ave Marías)

8. Por intercesión de San Miguel y el Coro de los Arcángeles: El Señor nos conceda la perseverancia final en la santa fe y en las buenas obras.
(1 Padre Nuestro, 3 Ave Marías)

9. Por intercesión de San Miguel y el Coro de los Ángeles: El Señor nos conceda ser custodiados por ellos durante esta vida y conducidos a la gloria eterna.
(1 Padre Nuestro, 3 Ave Marías)

Al finalizar se rezan 4 Padre Nuestros:
1º en honor a San Miguel, 2º a San Gabriel, 3º a San Rafael y 4º a nuestro Santo Ángel Custodio.
Amén.""",
      description = "Devoción aprobada por el Papa Pío IX en 1851 para honrar a los nueve coros angélicos e implorar su amparo continuo.",
      hasCounter = true,
      counterTotal = 9
    ),
    CatholicPrayer(
      id = "himno_te_deum",
      title = "Himno Te Deum (A Ti, Dios, te alabamos)",
      latinTitle = "Te Deum Laudamus",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """A Ti, Dios, te alabamos, a Ti, Señor, te reconocemos.
A Ti, eterno Padre, te venera toda la creación.
Los ángeles todos, los cielos y todas las potestades,
los querubines y serafines te cantan sin cesar:
¡Santo, Santo, Santo es el Señor, Dios del universo!
Llenos están los cielos y la tierra de la majestad de tu gloria.

A Ti te alaba el glorioso coro de los Apóstoles,
la multitud admirable de los Profetas,
el blanco ejército de los Mártires.
A Ti la Iglesia santa extendida por toda la tierra te confiesa:
Padre de inmensa majestad,
Hijo único y verdadero, digno de adoración,
Espíritu Santo Defensor.

Tú eres el Rey de la gloria, Cristo.
Tú eres el Hijo eterno del Padre.
Tú, para liberar al hombre, no dudaste en encarnarte en el seno de la Virgen.
Tú, vencida la espina de la muerte, abriste a los creyentes el reino de los cielos.
Tú estás sentado a la derecha de Dios en la gloria del Padre.
Creemos que has de venir como juez.

Te rogamos, pues, que ayudes a tus siervos,
a quienes redimiste con tu preciosa sangre.
Haz que seamos contados entre tus santos en la gloria eterna.
Salva a tu pueblo, Señor, y bendice tu heredad.
En Ti, Señor, he esperado; no quede yo defraudado para siempre.
Amén.""",
      description = "Solemne himno de acción de gracias de la Iglesia Católica, atribuido tradicionalmente a San Ambrosio y San Agustín, rezado en momentos de gran gozo y agradecimiento a Dios.",
      isTraditionLatinAvailable = true,
      latinContent = """Te Deum laudamus: te Dominum confitemur.
Te aeternum Patrem omnis terra veneratur.
Tibi omnes Angeli; tibi caeli et universae Potestates;
Tibi Cherubim et Seraphim incessabili voce proclamant:
Sanctus, Sanctus, Sanctus, Dominus Deus Sabaoth.
Pleni sunt caeli et terra maiestatis gloriae tuae.
Salvum fac populum tuum, Domine, et benedic hereditati tuae.
In te, Domine, speravi: non confundar in aeternum. Amen."""
    ),
    CatholicPrayer(
      id = "oracion_abandono_foucauld",
      title = "Oración de Abandono Filial (San Charles de Foucauld)",
      latinTitle = "Oratio Fiduciae et Deditionis",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Padre mío, me pongo en tus manos,
haz de mí lo que quieras,
sea lo que sea, te doy las gracias.
Estoy dispuesto a todo, lo acepto todo,
con tal que tu voluntad se haga en mí
y en todas tus criaturas.
No deseo nada más, Padre.

Te confío mi alma, te la doy
con todo el amor de que soy capaz,
porque te amo y necesito darme,
ponerme en tus manos sin medida,
con una infinita confianza,
porque Tú eres mi Padre.
Amén.""",
      description = "Plegaria cumbre de total confianza y abandono filial en las manos de Dios Padre, escrita por San Charles de Foucauld en el silencio del desierto."
    ),
    CatholicPrayer(
      id = "oracion_san_jose_terror_demonios",
      title = "Oración a San José, Terror de los Demonios",
      latinTitle = "Ad Sanctum Ioseph Terror Daemonum",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Oh San José, cuya protección es tan grande, tan fuerte y tan pronta ante el trono de Dios!
A Ti entrego todas mis intenciones y deseos.
San José, terror de los demonios, aleja de mí y de los míos todo espíritu de división, miedo, soberbia y desaliento.

Tú que defendiste a la Sagrada Familia de las asechanzas del enemigo,
sé escudo protector en todas mis batallas espirituales.
Asísteme en cada instante de mi vida y alcánzame una santa muerte en brazos de Jesús y de María.
Amén.""",
      description = "Invocación a San José bajo su poderosa advocación litúrgica como Terror de los Demonios y Protector de los hogares cristianos."
    ),
    CatholicPrayer(
      id = "oracion_santa_teresita_lluvia_rosas",
      title = "Oración a Santa Teresita del Niño Jesús (Lluvia de Rosas)",
      latinTitle = "Oratio ad Sanctam Theresiam a Iesu Infante",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """¡Oh Santa Teresita del Niño Jesús y de la Santa Faz!,
que prometiste pasar tu cielo haciendo el bien sobre la tierra
y derramar una lluvia de rosas sobre quienes acuden a ti:

Mira con ternura mis necesidades presentes y concédeme la gracia de vivir en el Pequeño Camino
de la santa infancia espiritual, confiando sin límites en la infinita misericordia de Dios.
Alcanza para mi corazón la pureza, la humildad y el amor ardiente a Jesús Eucaristía.
Derrama sobre mi vida las rosas de la paz, la sanación y la bendición del Señor.
Amén.""",
      description = "Plegaria a la Doctora de la Iglesia y patrona de las misiones para alcanzar consuelo y la gracia de la pequeñez evangélica."
    ),
    CatholicPrayer(
      id = "oracion_san_judas_tadeo_casos_dificiles",
      title = "Plegaria a San Judas Tadeo para Casos Imposibles",
      latinTitle = "Ad Sanctum Iudam Thaddaeum",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Oh Glorioso Apóstol San Judas Tadeo, siervo fiel y amigo de Jesús!
La Iglesia te honra e invoca universalmente como el patrón de las causas difíciles y desesperadas.

Ruega por mí, que me encuentro en gran tribulación y desconsuelo.
Haz uso, te lo ruego, del singular privilegio a ti concedido de socorrer pronto y visiblemente
donde casi toda esperanza se ha perdido.
Ven en mi ayuda en esta gran necesidad, para que reciba el consuelo y el auxilio del Cielo
en todas mis congojas, tribulaciones y sufrimientos, y para que pueda alabar a Dios contigo y con todos los elegidos por toda la eternidad.

Te prometo, bienaventurado San Judas, recordar siempre este gran favor,
honrarte siempre como a mi especial y poderoso patrono,
y fomentar con celo tu devoción.
Amén.""",
      description = "Oración tradicional de inmensa eficacia para pedir intercesión apostólica en momentos de angustia apremiante y causas que parecen insolubles."
    ),
    CatholicPrayer(
      id = "oracion_santa_monica_hijos",
      title = "Oración de Santa Mónica por los Hijos y la Familia",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """¡Oh Santa Mónica, modelo de esposas y madres cristianas!,
que con lágrimas y perseverante oración obtuviste del Señor la conversión de tu esposo Patricio y de tu hijo San Agustín:

Vuelve tus ojos de misericordia hacia mi familia y hacia mis seres queridos.
Tú que conoces el dolor de ver extraviados a quienes amas,
toma bajo tu custodia el corazón de mis hijos y familiares.
Obtén para ellos la luz de la fe verdadera, la rectitud en sus conciencias y el regreso a los sacramentos de la Iglesia.
Enséñame tu paciencia inquebrantable y tu absoluta confianza en la Divina Providencia.
Por Jesucristo Nuestro Señor.
Amén.""",
      description = "Plegaria dirigida a Santa Mónica, madre de San Agustín, patrona de las madres que oran con lágrimas por la conversión y salvación de sus hijos."
    ),
    CatholicPrayer(
      id = "oracion_san_peregrino_enfermos",
      title = "Oración a San Peregrino por los Enfermos y la Salud",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Glorioso San Peregrino!, tú que respondiste a la llamada divina con gran devoción
y sobrellevaste con heroica paciencia el cáncer que consumía tu pierna,
siendo curado milagrosamente por una caricia del crucifijo:

Intercede ante Jesús, el Divino Médico de almas y cuerpos,
por todos los que sufren enfermedades graves, cáncer y dolores intensos.
Alcánzanos la salud si conviene para la salvación de nuestras almas,
y la fortaleza serena para ofrecer nuestros sufrimientos unidos a la Pasión de Cristo.
Amén.""",
      description = "San Peregrino Laziosi es el patrono celestial de los enfermos de cáncer y dolencias graves de la piel y extremidades."
    ),
    CatholicPrayer(
      id = "oracion_virgen_desatanudos",
      title = "Oración a Nuestra Señora Desatadora de Nudos",
      latinTitle = "Ad Beatam Mariam Virginem Nodos Dissolventem",
      category = PrayerCategory.VIRGEN_MARIA,
      purpose = PrayerPurpose.MARIA_Y_ROSARIO,
      content = """Santa María, llena de la presencia de Dios, durante los días de tu vida aceptaste con toda humildad la voluntad del Padre, y el maligno nunca fue capaz de enredarte con sus confusiones.
Ya junto a tu Hijo intercediste por nuestras dificultades y, con toda sencillez y paciencia, nos diste ejemplo de cómo desenredar la madeja de nuestras vidas.

Madre amorosa, pongo en tus manos maternales los nudos que asfixian mi vida y me impiden unirme plenamente a Dios:
desata las ataduras de mi egoísmo, el nudo de mis rencores, la confusión en mis decisiones y las discordias en mi hogar.
Por tu gracia y tu poder intercesor ante Jesús, líbrame de todo mal y desata los nudos que me atan,
para que, libre de todo engaño, pueda alabar al Señor siempre y en todo lugar.
Amén.""",
      description = "Devoción mariana entrañable, profundamente difundida por el Papa Francisco, para desenredar los problemas, conflictos familiares y ataduras espirituales."
    ),
    CatholicPrayer(
      id = "salmo_51_miserere",
      title = "Salmo 51: Miserere (Piedad de mí, Señor)",
      latinTitle = "Miserere Mei, Deus",
      category = PrayerCategory.BASICAS,
      purpose = PrayerPurpose.PERDON_Y_MISERICORDIA,
      content = """Piedad de mí, Señor, por tu bondad;
por tu gran compasión borra mi culpa.
Lávame a fondo de mi iniquidad
y purifícame de mi pecado.

Pues yo reconozco mi falta,
tengo siempre presente mi pecado.
Contra Ti, contra Ti solo he pecado,
he hecho lo que es malo a tus ojos.

Crea en mí, oh Dios, un corazón puro,
renueva en mi interior un espíritu firme;
no me rechaces lejos de tu rostro,
no retires de mí tu Santo Espíritu.

Devuélveme la alegría de tu salvación,
afiánzame con espíritu generoso.
Señor, ábreme los labios
y mi boca proclamará tu alabanza.
Amén.""",
      description = "El salmo penitencial por excelencia compuesto por el Rey David, súplica de corazón contrito que implora la purificación y la renovación del alma.",
      isTraditionLatinAvailable = true,
      latinContent = """Miserere mei, Deus, secundum magnam misericordiam tuam;
et secundum multitudinem miserationum tuarum dele iniquitatem meam.
Amplius lava me ab iniquitate mea, et a peccato meo munda me.
Quoniam iniquitatem meam ego cognosco, et peccatum meum contra me est semper.
Tibi soli peccavi, et malum coram te feci.
Cor mundum crea in me, Deus, et spiritum rectum innova in visceribus meis.
Amen."""
    ),
    CatholicPrayer(
      id = "oracion_san_pio_quedate_conmigo",
      title = "Oración de San Pío: «Quédate conmigo, Señor»",
      category = PrayerCategory.EUCARISTIA,
      purpose = PrayerPurpose.ALABANZA_Y_EUCARISTIA,
      content = """Quédate conmigo, Señor, porque es necesario tenerte presente para no olvidarte.
Tú sabes con cuánta facilidad te abandono.

Quédate conmigo, Señor, porque soy débil y necesito de tu fuerza para no caer tantas veces.
Quédate conmigo, Señor, porque Tú eres mi vida, y sin Ti me falta el fervor.
Quédate conmigo, Señor, porque Tú eres mi luz, y sin Ti estoy en tinieblas.

Quédate conmigo, Señor, para mostrarme tu voluntad.
Quédate conmigo, Señor, para que escuche tu voz y te siga.
Quédate conmigo, Jesús, porque aunque mi alma sea pobrísima, desea ser para Ti una morada de consuelo y un nido de amor.
Haz que te reconozca como tus discípulos al partir el pan, y que la Eucaristía sea la luz que disipe las tinieblas y la fuerza de mi vida.
Amén.""",
      description = "Conmovedora súplica que San Pío de Pietrelcina rezaba tras celebrar la Santa Misa, implorando la presencia constante de Jesús en el alma."
    ),
    CatholicPrayer(
      id = "oracion_san_rafael_arcangel",
      title = "Oración al Arcángel San Rafael (Medicina de Dios)",
      latinTitle = "Ad Sanctum Raphaelem Archangelum",
      category = PrayerCategory.PROTECCION,
      purpose = PrayerPurpose.PROTECCION,
      content = """¡Oh glorioso Arcángel San Rafael, medicina de Dios y guía de los caminantes!
Tú que sanaste la ceguera de Tobías y lo guiaste sano y salvo en su largo viaje:

Ven en mi ayuda y acompáñame en el viaje de mi vida terrena.
Sana las heridas de mi cuerpo y las llagas de mi alma.
Presérvame de los peligros del camino, de los accidentes y de las trampas del demonio.
Condúceme siempre por sendas de virtud, pureza y paz, hasta contemplar con los santos el rostro de Dios en el cielo.
Amén.""",
      description = "Plegaria al Arcángel San Rafael, compañero de viaje providencial, patrono de médicos, enfermeros, ciegos y viajeros."
    ),
    CatholicPrayer(
      id = "oracion_santo_cura_ars",
      title = "Acto de Amor a Dios (Santo Cura de Ars)",
      category = PrayerCategory.SANTOS,
      purpose = PrayerPurpose.PAZ_INTERIOR,
      content = """Te amo, oh mi Dios, y mi único deseo es amarte hasta el último suspiro de mi vida.
Te amo, oh Dios infinitamente amable, y prefiero morir amándote que vivir un solo instante sin amarte.

Te amo, Señor, y la única gracia que te pido es amarte eternamente.
Dios mío, si mi lengua no puede decir a cada instante que te amo,
quiero que mi corazón te lo repita tantas veces cuantas respiro.
Te amo, mi divino Salvador, porque has sido crucificado por mí;
y me tienes aquí, crucificado contigo.
Dios mío, dame la gracia de morir amándote y sintiendo que te amo.
Amén.""",
      description = "Hermosísima plegaria de San Juan María Vianney (el Santo Cura de Ars), patrono de todos los sacerdotes, modelo de entrega y ardiente caridad hacia Dios."
    )
  )

  fun getAllPrayers(): List<CatholicPrayer> = prayers

  fun getPrayersByPurpose(purpose: PrayerPurpose): List<CatholicPrayer> =
    prayers.filter { it.purpose == purpose }

  fun getHolySpiritPrayers(): List<CatholicPrayer> =
    prayers.filter { it.purpose == PrayerPurpose.ESPIRITU_SANTO }

  fun getFavoritePrayers(favoriteIds: Set<String>): List<CatholicPrayer> =
    prayers.filter { favoriteIds.contains(it.id) }

  fun searchPrayers(query: String, subset: List<CatholicPrayer>? = null): List<CatholicPrayer> {
    val q = query.trim().lowercase()
    val source = subset ?: prayers
    if (q.isEmpty()) return source
    return source.filter {
      it.title.lowercase().contains(q) ||
        (it.latinTitle?.lowercase()?.contains(q) == true) ||
        it.content.lowercase().contains(q) ||
        it.description.lowercase().contains(q)
    }
  }

  fun getPrayerById(id: String): CatholicPrayer? =
    prayers.find { it.id == id }
}

