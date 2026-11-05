package com.example.data

import com.example.model.ViaCrucisStation

object ViaCrucisRepository {

  const val OPENING_PRAYER = "Por la señal de la Santa Cruz, de nuestros enemigos líbranos Señor, Dios nuestro. En el nombre del Padre, y del Hijo, y del Espíritu Santo. Amén.\n\nActo de Contrición:\nSeñor mío Jesucristo, Dios y Hombre verdadero, Creador, Padre y Redentor mío; por ser Vos quien sois, bondad infinita, y porque os amo sobre todas las cosas, me pesa de todo corazón haberos ofendido. Me propongo firmemente nunca más pecar, confesarme y cumplir la penitencia que me fuere impuesta. Amén."

  const val stationInvocationV = "V/. Te adoramos, oh Cristo, y te bendecimos."
  const val stationInvocationR = "R/. Porque por tu santa cruz redimiste al mundo."

  const val CLOSING_PRAYER = "Oración Final:\nTe damos gracias, Señor Jesús, porque con tu Pasión, Muerte y Resurrección nos has rescatado del pecado y de la muerte. Graba en nuestros corazones las huellas de tus llagas, para que abrazando con amor nuestra cruz de cada día, merezcamos resucitar contigo en la gloria celestial. Tú que vives y reinas por los siglos de los siglos. Amén.\n\nPadre Nuestro, Ave María y Gloria por las intenciones del Santo Padre el Papa."

  val stations: List<ViaCrucisStation> = listOf(
    ViaCrucisStation(
      number = 1,
      romanNumeral = "I",
      title = "Jesús es condenado a muerte",
      latinTitle = "Iesus condemnatur ad mortem",
      scriptureCitation = "San Mateo 27:22-26",
      scriptureText = "«Pilato les dijo: “¿Qué haré, pues, con Jesús, llamado el Cristo?”. Todos dijeron: “¡Sea crucificado!”. Entonces les soltó a Barrabás; y habiendo azotado a Jesús, lo entregó para ser crucificado.»",
      meditation = "El Inocente supremo guarda silencio ante el tribunal humano. Jesús calla por amor a ti, aceptando la condena injusta para liberarte de la muerte eterna.",
      prayer = "Señor Jesús, concédeme la gracia de no juzgar temerariamente a mi prójimo y de aceptar con paciencia las incomprensiones de la vida, uniendo mis dolores a tu santa Pasión.",
      virtue = "Humildad y Mansedumbre"
    ),
    ViaCrucisStation(
      number = 2,
      romanNumeral = "II",
      title = "Jesús carga con la Cruz",
      latinTitle = "Iesus cruce oneratur",
      scriptureCitation = "San Juan 19:16-17",
      scriptureText = "«Tomaron, pues, a Jesús, y cargando con su cruz, salió hacia el lugar llamado de la Calavera, que en hebreo se dice Gólgota.»",
      meditation = "Sobre sus hombros heridos se coloca el madero pesado de nuestras culpas. Cristo no rechaza la cruz; la abraza como el altar de nuestra redención.",
      prayer = "Jesús amado, enséñame a no huir de mis deberes diarios ni de mis sufrimientos. Dame fortaleza para abrazar mi cruz y seguir tus pasos con fidelidad.",
      virtue = "Aceptación generosa"
    ),
    ViaCrucisStation(
      number = 3,
      romanNumeral = "III",
      title = "Jesús cae por primera vez",
      latinTitle = "Iesus prima vice sub cruce cadit",
      scriptureCitation = "Isaías 53:4-5",
      scriptureText = "«Ciertamente llevó él nuestras enfermedades, y sufrió nuestros dolores; herido fue por nuestras rebeliones, molido por nuestros pecados; el castigo de nuestra paz fue sobre él.»",
      meditation = "El Hijo de Dios cae exhausto en el polvo del camino. Pero con infinito esfuerzo se levanta para enseñarte que ninguna caída es definitiva mientras acudas a su perdón.",
      prayer = "Señor, cuando la debilidad me venza y caiga en el pecado, no permitas que me quede postrado en el desánimo. Dame tu mano para levantarme pronto mediante la santa Confesión.",
      virtue = "Arrepentimiento sincero"
    ),
    ViaCrucisStation(
      number = 4,
      romanNumeral = "IV",
      title = "Jesús encuentra a su Santísima Madre",
      latinTitle = "Iesus matri suae occurrit",
      scriptureCitation = "San Lucas 2:34-35",
      scriptureText = "«Simeón les bendijo, y dijo a su madre María: “Una espada traspasará tu misma alma, para que sean descubiertos los pensamientos de muchos corazones”.»",
      meditation = "Las miradas de Jesús y de María se cruzan en medio de la multitud. Dos corazones unidos en un solo dolor por la salvación del mundo entero.",
      prayer = "Virgen Dolorosa, Madre de misericordia, alcánzame la gracia de permanecer fiel al pie de la cruz de Jesús y acompáñame en todas las horas de aflicción.",
      virtue = "Fidelidad y Consuelo"
    ),
    ViaCrucisStation(
      number = 5,
      romanNumeral = "V",
      title = "Simón de Cirene ayuda a Jesús",
      latinTitle = "Simon Cyrenaeus Iesum adiuvat",
      scriptureCitation = "San Lucas 23:26",
      scriptureText = "«Y llevándole, tomaron a cierto Simón de Cirene, que venía del campo, y le pusieron encima la cruz para que la llevase tras Jesús.»",
      meditation = "El Cireneo fue obligado al principio, pero al mirar el rostro de Cristo comprendió el privilegio inmenso de aliviar el dolor del Salvador en los que sufren.",
      prayer = "Señor, abre mis ojos y mi corazón para descubrirte en los enfermos, en los ancianos y en los necesitados. Hazme un cireneo dispuesto para mis hermanos.",
      virtue = "Caridad activa"
    ),
    ViaCrucisStation(
      number = 6,
      romanNumeral = "VI",
      title = "La Verónica enjuga el rostro de Jesús",
      latinTitle = "Veronica faciem Iesu sudario abstergit",
      scriptureCitation = "Salmo 27:8-9",
      scriptureText = "«Mi corazón ha dicho de ti: Buscad mi rostro. Tu rostro buscaré, oh Señor; no escondas tu rostro de mí.»",
      meditation = "Una mujer valiente rompe el cerco de soldados para limpiar el sudor y la sangre del Señor. Jesús premia su ternura estampando su Santo Rostro en el lienzo.",
      prayer = "Jesús mío, graba en mi alma los rasgos de tu rostro misericordioso, para que en todas mis obras refleje tu amor y consuele a los atribulados.",
      virtue = "Valentía y Delicadeza"
    ),
    ViaCrucisStation(
      number = 7,
      romanNumeral = "VII",
      title = "Jesús cae por segunda vez",
      latinTitle = "Iesus iterum sub cruce cadit",
      scriptureCitation = "Lamentaciones 3:1-3",
      scriptureText = "«Yo soy el hombre que ha visto aflicción bajo el látigo de su enojo. Me guió y me llevó en tinieblas, y no en luz; ciertamente contra mí volvió su mano todo el día.»",
      meditation = "La fatiga agota su cuerpo santísimo. El peso de nuestras reincidencias en el pecado lo derriba de nuevo. Sin embargo, su amor no desiste; se vuelve a alzar por ti.",
      prayer = "Cristo redentor, perdona mis recaídas e infidelidades. Infunde en mí la gracia de la perseverancia final para no cansarme nunca de recomenzar el camino.",
      virtue = "Perseverancia"
    ),
    ViaCrucisStation(
      number = 8,
      romanNumeral = "VIII",
      title = "Jesús consuela a las santas mujeres",
      latinTitle = "Iesus filias Ierusalem alloquitur",
      scriptureCitation = "San Lucas 23:27-28",
      scriptureText = "«Y le seguía una gran multitud del pueblo, y de mujeres que lloraban y hacían lamentación por él. Pero Jesús, vuelto hacia ellas, les dijo: “Hijas de Jerusalén, no lloréis por mí, sino llorad por vosotras mismas y por vuestros hijos”.»",
      meditation = "Jesús olvida su propio tormento para orientar el llanto hacia la verdadera conversión. El dolor debe transformarse en cambio de vida y oración por la salvación de las almas.",
      prayer = "Señor, concédeme el don de lágrimas santas para llorar mis pecados y la gracia de interceder siempre por la conversión de mi familia y del mundo entero.",
      virtue = "Compunción de corazón"
    ),
    ViaCrucisStation(
      number = 9,
      romanNumeral = "IX",
      title = "Jesús cae por tercera vez",
      latinTitle = "Iesus tertia vice sub cruce cadit",
      scriptureCitation = "Salmo 119:25-28",
      scriptureText = "«Abatida hasta el polvo está mi alma; vivifícame según tu palabra. Te he manifestado mis caminos, y me has respondido; enséñame tus estatutos.»",
      meditation = "Al pie del monte Calvario, Jesús cae por tercera vez, casi sin aliento vital. Con su último aliento de fuerzas humanas se arrastra y levanta para consumar el sacrificio.",
      prayer = "Jesús, ante mis momentos de mayor abatimiento, cuando sienta que las fuerzas me abandonan, recuérdame tu tercera caída y concédeme la fuerza del Espíritu Santo.",
      virtue = "Fortaleza heroica"
    ),
    ViaCrucisStation(
      number = 10,
      romanNumeral = "X",
      title = "Jesús es despojado de sus vestiduras",
      latinTitle = "Iesus vestibus spoliatur",
      scriptureCitation = "San Mateo 27:35",
      scriptureText = "«Cuando le hubieron crucificado, repartieron entre sí sus vestidos, echando suertes, para que se cumpliese lo dicho por el profeta: Repartieron entre sí mis vestidos, y sobre mi ropa echaron suertes.»",
      meditation = "Le arrancan las ropas pegadas a sus llagas vivas. El Señor de los cielos queda despojado de todo para revestirte de la gracia y de la pureza de los hijos de Dios.",
      prayer = "Despójame, Señor Jesús, de la vanidad, del apego desordenado a las cosas del mundo y de toda soberbia. Revísteme con tu pureza y tu sencillez evangélica.",
      virtue = "Desprendimiento y Pureza"
    ),
    ViaCrucisStation(
      number = 11,
      romanNumeral = "XI",
      title = "Jesús es clavado en la Cruz",
      latinTitle = "Iesus cruci affigitur",
      scriptureCitation = "San Lucas 23:33-34",
      scriptureText = "«Y cuando llegaron al lugar llamado de la Calavera, le crucificaron allí. Y Jesús decía: “Padre, perdónalos, porque no saben lo que hacen”.»",
      meditation = "Los clavos desgarran sus manos creadoras y sus pies bienhechores. Desde el lecho del dolor extremo, su primera palabra es de perdón hacia sus verdugos.",
      prayer = "Señor crucificado, clava en tu Cruz mis deseos egoístas y concédeme un corazón capaz de perdonar de verdad a quienes me hayan ofendido o herido.",
      virtue = "Perdón generoso"
    ),
    ViaCrucisStation(
      number = 12,
      romanNumeral = "XII",
      title = "Jesús muere en la Cruz",
      latinTitle = "Iesus in cruce moritur",
      scriptureCitation = "San Juan 19:28-30",
      scriptureText = "«Jesús, inclinando la cabeza, entregó el espíritu. Todo está consumado.»",
      meditation = "(Momento de silencio de rodillas). El Hijo de Dios entrega su vida por ti. Las tinieblas cubren la tierra y el velo del templo se rasga: el cielo queda abierto para siempre.",
      prayer = "Cristo mío crucificado, por tu sagrada muerte y por tu preciosísima Sangre derramada, acoge mi alma en la hora de mi muerte y concédeme la vida eterna.",
      virtue = "Amor supremo y Adoración"
    ),
    ViaCrucisStation(
      number = 13,
      romanNumeral = "XIII",
      title = "Jesús es bajado de la Cruz",
      latinTitle = "Iesus de cruce deponitur",
      scriptureCitation = "San Juan 19:38",
      scriptureText = "«Después de todo esto, José de Arimatea rogó a Pilato que le permitiese quitar el cuerpo de Jesús; y Pilato se lo concedió. Entonces vino, y quitó el cuerpo de Jesús.»",
      meditation = "El cuerpo inerte del Redentor es depositado en los brazos de María Santísima. La Virgen acoge a su Hijo con infinita ternura, ofreciendo su inmenso dolor al Padre.",
      prayer = "Madre Dolorosa, recibe en tus brazos virginales mi alma herida y alcánzame del Corazón de tu Hijo el consuelo en las pruebas y la pureza en el obrar.",
      virtue = "Esperanza confiada"
    ),
    ViaCrucisStation(
      number = 14,
      romanNumeral = "XIV",
      title = "Jesús es colocado en el Sepulcro",
      latinTitle = "Iesus in sepulcro deponitur",
      scriptureCitation = "San Mateo 27:59-60",
      scriptureText = "«Y tomando José el cuerpo, lo envolvió en una sábana limpia, y lo puso en su sepulcro nuevo, que había labrado en la peña; y después de hacer rodar una gran piedra a la entrada del sepulcro, se fue.»",
      meditation = "El grano de trigo cae en tierra para germinar en vida inmortal. En la noche del Sábado Santo, la Iglesia vigila con María esperando el alba gloriosa de la Resurrección.",
      prayer = "Señor Jesús, concédeme la gracia de sepultar en tu tumba mis vicios y pecados, para que renazca a una vida santa y camine en la luz de tu Resurrección.",
      virtue = "Paz y Fe inquebrantable"
    )
  )
}
