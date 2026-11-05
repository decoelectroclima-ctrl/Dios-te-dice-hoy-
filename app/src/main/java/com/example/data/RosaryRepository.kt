package com.example.data

import com.example.model.RosaryGroup
import com.example.model.RosaryMystery
import com.example.model.RosaryMysteryType
import java.util.Calendar

object RosaryRepository {

  val gozosos = RosaryGroup(
    type = RosaryMysteryType.GOZOSOS,
    mysteries = listOf(
      RosaryMystery(1, "La Encarnación del Hijo de Dios", "La humildad", "San Lucas 1:26-38", "«El ángel le dijo: No temas, María, porque has hallado gracia delante de Dios... He aquí la esclava del Señor, hágase en mí según tu palabra.»", "Meditamos la humildad de la Virgen al recibir el anuncio de que sería la Madre del Redentor."),
      RosaryMystery(2, "La Visitación de Nuestra Señora a Santa Isabel", "La caridad fraterna", "San Lucas 1:39-45", "«¿De dónde a mí esto, que la madre de mi Señor venga a mí?... Bienaventurada la que creyó.»", "María viaja con prisa para servir a su prima, enseñándonos el amor solícito hacia el prójimo."),
      RosaryMystery(3, "El Nacimiento del Hijo de Dios en Belén", "El desprendimiento y la sencillez", "San Lucas 2:6-7", "«Y dio a luz a su hijo primogénito, y lo envolvió en pañales, y lo acostó en un pesebre.»", "Dios se hace niño en la pobreza de Belén para hacernos partícipes de su divinidad."),
      RosaryMystery(4, "La Presentación del Niño Jesús en el Templo", "La obediencia y la pureza", "San Lucas 2:22-24", "«Llevaron a Jesús a Jerusalén para presentarle al Señor, como está escrito en la ley.»", "Jesús es ofrecido al Padre en el Templo y Simeón profetiza la espada de dolor para María."),
      RosaryMystery(5, "El Niño Jesús perdido y hallado en el Templo", "La búsqueda constante de Dios", "San Lucas 2:46-49", "«¿Por qué me buscabais? ¿No sabíais que en los negocios de mi Padre me es necesario estar?»", "Contemplamos la alegría de María y José al reencontrar al Salvador en medio de los doctores.")
    )
  )

  val luminosos = RosaryGroup(
    type = RosaryMysteryType.LUMINOSOS,
    mysteries = listOf(
      RosaryMystery(1, "El Bautismo de Jesús en el Jordán", "La fidelidad a las promesas bautismales", "San Mateo 3:16-17", "«Y hubo una voz de los cielos que decía: Éste es mi Hijo amado, en quien tengo complacencia.»", "Cristo, inocente, desciende a las aguas del Jordán santificándolas para nuestro renacimiento."),
      RosaryMystery(2, "La autorrevelación en las Bodas de Caná", "La confianza en la intercesión de María", "San Juan 2:1-11", "«Su madre dijo a los que servían: Haced todo lo que él os diga.»", "Por ruego de María, Jesús realiza su primer milagro transformando el agua en vino generoso."),
      RosaryMystery(3, "El Anuncio del Reino de Dios y la conversión", "El arrepentimiento y la fe viva", "San Marcos 1:14-15", "«El tiempo se ha cumplido, y el reino de Dios se ha acercado; arrepentíos, y creed en el evangelio.»", "Jesús proclama la bienaventuranza y el perdón a todos los corazones contritos."),
      RosaryMystery(4, "La Transfiguración del Señor en el Tabor", "El anhelo del cielo y la contemplación", "San Lucas 9:28-35", "«Y mientras oraba, la apariencia de su rostro se hizo otra, y su vestido blanco y resplandeciente.»", "Jesús muestra su gloria a Pedro, Santiago y Juan para fortalecerlos ante el escándalo de la Cruz."),
      RosaryMystery(5, "La Institución de la Sagrada Eucaristía", "El amor a la Santa Misa y al Sagrario", "San Mateo 26:26-28", "«Tomad, comed; esto es mi cuerpo... Bebed de ella todos; porque esto es mi sangre del nuevo pacto.»", "En la Última Cena, Cristo se entrega a Sí mismo como alimento de vida eterna para su Iglesia.")
    )
  )

  val dolorosos = RosaryGroup(
    type = RosaryMysteryType.DOLOROSOS,
    mysteries = listOf(
      RosaryMystery(1, "La Oración de Jesús en el Huerto de Getsemaní", "La conformidad con la voluntad de Dios", "San Lucas 22:41-44", "«Padre, si quieres, pasa de mí esta copa; pero no se haga mi voluntad, sino la tuya.»", "Jesús experimenta la angustia interior y el sudor de sangre, aceptando el designio del Padre."),
      RosaryMystery(2, "La Flagelación de Nuestro Señor", "La pureza de los sentidos y la templanza", "San Juan 19:1", "«Así que, entonces tomó Pilato a Jesús, y le azotó.»", "Cristo entrega su carne sacratísima a los azotes crueles para expiar nuestros pecados de impureza."),
      RosaryMystery(3, "La Coronación de Espinas", "La humildad y la rectitud de pensamiento", "San Mateo 27:28-29", "«Y pusieron sobre su cabeza una corona tejida de espinas, y una caña en su mano derecha.»", "El Rey de Reyes es burlado y ultrajado por nosotros con una corona sangrienta de espinas."),
      RosaryMystery(4, "Jesús con la Cruz a Cuestas camino al Calvario", "La paciencia ante las adversidades", "San Juan 19:17", "«Y él, cargando su cruz, salió al lugar llamado de la Calavera.»", "Jesús sube la Vía Dolorosa con mansedumbre inaudita, enseñándonos a sobrellevar nuestras penas."),
      RosaryMystery(5, "La Crucifixión y Muerte de Nuestro Señor", "La entrega de la vida y la salvación de las almas", "San Lucas 23:44-46", "«Padre, en tus manos encomiendo mi espíritu. Y habiendo dicho esto, expiró.»", "Jesús nos entrega a María como Madre al pie de la Cruz y derrama su última gota de sangre.")
    )
  )

  val gloriosos = RosaryGroup(
    type = RosaryMysteryType.GLORIOSOS,
    mysteries = listOf(
      RosaryMystery(1, "La Triunfante Resurrección del Señor", "La fe y la alegría pascual", "San Mateo 28:5-6", "«No temáis vosotras; porque yo sé que buscáis a Jesús, el que fue crucificado. No está aquí, pues ha resucitado.»", "Cristo vence a la muerte y al pecado, abriéndonos las puertas de la inmortalidad."),
      RosaryMystery(2, "La Ascensión del Señor a los Cielos", "La esperanza y el deseo de las cosas celestiales", "San Marcos 16:19", "«Y el Señor, después que les habló, fue recibido arriba en el cielo, y se sentó a la diestra de Dios.»", "Jesús sube glorioso al Padre para preparar una morada eterna a los que le aman."),
      RosaryMystery(3, "La Venida del Espíritu Santo en Pentecostés", "El celo apostólico y el amor a Dios", "Hechos 2:1-4", "«Y se les aparecieron lenguas repartidas, como de fuego... Y fueron todos llenos del Espíritu Santo.»", "El Espíritu Consolador desciende sobre María y los Apóstoles, llenando a la Iglesia de fortaleza."),
      RosaryMystery(4, "La Asunción de la Virgen María en cuerpo y alma al Cielo", "La pureza de alma y la buena muerte", "Cantar de los Cantares 2:10", "«Levántate, amada mía, hermosa mía, y ven.»", "La Inmaculada Madre de Dios es elevada en gloria al cielo sin conocer la corrupción del sepulcro."),
      RosaryMystery(5, "La Coronación de la Virgen María como Reina de la Creación", "La confianza filial en María", "Apocalipsis 12:1", "«Apareció en el cielo una gran señal: una mujer vestida del sol, con la luna debajo de sus pies, y sobre su cabeza una corona de doce estrellas.»", "María es ensalzada como Reina de los Ángeles y de los Hombres, Mediadora de todas las gracias.")
    )
  )

  fun getMysteryForToday(): RosaryGroup {
    val cal = Calendar.getInstance()
    return when (cal.get(Calendar.DAY_OF_WEEK)) {
      Calendar.MONDAY, Calendar.SATURDAY -> gozosos
      Calendar.THURSDAY -> luminosos
      Calendar.TUESDAY, Calendar.FRIDAY -> dolorosos
      Calendar.WEDNESDAY, Calendar.SUNDAY -> gloriosos
      else -> gozosos
    }
  }

  fun getGroupByEnum(type: RosaryMysteryType): RosaryGroup {
    return when (type) {
      RosaryMysteryType.GOZOSOS -> gozosos
      RosaryMysteryType.LUMINOSOS -> luminosos
      RosaryMysteryType.DOLOROSOS -> dolorosos
      RosaryMysteryType.GLORIOSOS -> gloriosos
    }
  }

  const val FATIMA_EJACULATION = "«¡Oh Jesús mío, perdona nuestros pecados, líbranos del fuego del infierno, lleva al cielo a todas las almas, especialmente a las más necesitadas de tu infinita misericordia! Amén.»"

  const val HAIL_MARY_TEXT = "Dios te salve, María, llena eres de gracia; el Señor es contigo. Bendita tú eres entre todas las mujeres, y bendito es el fruto de tu vientre, Jesús.\n\nSanta María, Madre de Dios, ruega por nosotros, pecadores, ahora y en la hora de nuestra muerte. Amén."

  const val OUR_FATHER_TEXT = "Padre nuestro, que estás en el cielo, santificado sea tu Nombre; venga a nosotros tu Reino; hágase tu voluntad en la tierra como en el cielo. Danos hoy nuestro pan de cada día; perdona nuestras ofensas, como también nosotros perdonamos a los que nos ofenden; no nos dejes caer en la tentación, y líbranos del mal. Amén."

  const val GLORY_BE_TEXT = "Gloria al Padre, y al Hijo, y al Espíritu Santo. Como era en el principio, ahora y siempre, por los siglos de los siglos. Amén."

  const val SALVE_REGINA_TEXT = "Dios te salve, Reina y Madre de misericordia, vida, dulzura y esperanza nuestra; Dios te salve. A ti llamamos los desterrados hijos de Eva; a ti suspiramos, gimiendo y llorando, en este valle de lágrimas. Ea, pues, Señora, abogada nuestra, vuelve a nosotros esos tus ojos misericordiosos; y después de este destierro muéstranos a Jesús, fruto bendito de tu vientre. ¡Oh clementísima, oh piadosa, oh dulce Virgen María!\n\nV/. Ruega por nosotros, Santa Madre de Dios.\nR/. Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo. Amén."

  val litanyOfLoreto = listOf(
    "Santa María — Ruega por nosotros.",
    "Santa Madre de Dios — Ruega por nosotros.",
    "Santa Virgen de las Vírgenes — Ruega por nosotros.",
    "Madre de Cristo — Ruega por nosotros.",
    "Madre de la Iglesia — Ruega por nosotros.",
    "Madre de la divina gracia — Ruega por nosotros.",
    "Madre de la esperanza — Ruega por nosotros.",
    "Madre purísima — Ruega por nosotros.",
    "Madre castísima — Ruega por nosotros.",
    "Madre inmaculada — Ruega por nosotros.",
    "Madre amable — Ruega por nosotros.",
    "Madre admirable — Ruega por nosotros.",
    "Madre del buen consejo — Ruega por nosotros.",
    "Madre del Creador — Ruega por nosotros.",
    "Madre del Salvador — Ruega por nosotros.",
    "Virgen prudentísima — Ruega por nosotros.",
    "Virgen venerable — Ruega por nosotros.",
    "Virgen digna de alabanza — Ruega por nosotros.",
    "Virgen poderosa — Ruega por nosotros.",
    "Virgen clemente — Ruega por nosotros.",
    "Virgen fiel — Ruega por nosotros.",
    "Espejo de justicia — Ruega por nosotros.",
    "Trono de la sabiduría — Ruega por nosotros.",
    "Causa de nuestra alegría — Ruega por nosotros.",
    "Vaso espiritual — Ruega por nosotros.",
    "Vaso honorable — Ruega por nosotros.",
    "Vaso insigne de devoción — Ruega por nosotros.",
    "Rosa mística — Ruega por nosotros.",
    "Torre de David — Ruega por nosotros.",
    "Torre de marfil — Ruega por nosotros.",
    "Casa de oro — Ruega por nosotros.",
    "Arca de la Alianza — Ruega por nosotros.",
    "Puerta del cielo — Ruega por nosotros.",
    "Estrella de la mañana — Ruega por nosotros.",
    "Salud de los enfermos — Ruega por nosotros.",
    "Refugio de los pecadores — Ruega por nosotros.",
    "Consuelo de los migrantes — Ruega por nosotros.",
    "Consoladora de los afligidos — Ruega por nosotros.",
    "Auxilio de los cristianos — Ruega por nosotros.",
    "Reina de los Ángeles — Ruega por nosotros.",
    "Reina de los Patriarcas — Ruega por nosotros.",
    "Reina de los Profetas — Ruega por nosotros.",
    "Reina de los Apóstoles — Ruega por nosotros.",
    "Reina de los Mártires — Ruega por nosotros.",
    "Reina de los Confesores — Ruega por nosotros.",
    "Reina de las Vírgenes — Ruega por nosotros.",
    "Reina de todos los Santos — Ruega por nosotros.",
    "Reina concebida sin pecado original — Ruega por nosotros.",
    "Reina asunta al Cielo — Ruega por nosotros.",
    "Reina del Santo Rosario — Ruega por nosotros.",
    "Reina de la familia — Ruega por nosotros.",
    "Reina de la paz — Ruega por nosotros."
  )
}
