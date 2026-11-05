package com.example.data

import com.example.model.*

object StudyRepository {
    private val disclaimer = "Material de estudio propio, para contrastar con el texto bíblico y con tu lectura personal."

    val books = listOf(
        StudyBook(
            id = "genesis",
            name = "Génesis",
            testament = "Antiguo Testamento",
            summary = "El libro de los orígenes narra la creación del mundo, la caída del hombre, el diluvio y la historia de los patriarcas, estableciendo las bases de la alianza entre Dios y su pueblo elegido.",
            historicalContext = "Tradicionalmente atribuido a Moisés. Escrito probablemente durante el Éxodo. Relata eventos muy antiguos, desde la creación hasta la estancia en Egipto.",
            authorAndDate = "Moisés (tradición). Siglo XV-XIII a.C. (estimación).",
            keyThemes = listOf("Creación", "Caída", "Pacto", "Elección"),
            outline = listOf(
                OutlineSection("Creación y Caída", "1-11", listOf("Creación", "Adán y Eva", "Diluvio")),
                OutlineSection(" Patriarcas", "12-50", listOf("Abraham", "Isaac", "Jacob", "José"))
            ),
            chapters = listOf(
                StudyChapter(1, "La Creación", listOf(VerseRef("Génesis", 1, 1, "En el principio creó Dios los cielos y la tierra.", "Torres Amat")), "Dios ordena el caos.", listOf("¿Qué nos dice el orden de la creación?", "¿Qué implica la imagen de Dios?"), "¿Cómo reflejas a Dios?", "Señor, gracias.", SchemaType.TREE),
                StudyChapter(12, "Llamado de Abraham", listOf(VerseRef("Génesis", 12, 1, "Vete de tu tierra.", "Torres Amat")), "Dios llama a Abraham.", listOf("¿Por qué Abraham confió?", "¿A qué te llama Dios?"), "¿Confías?", "Señor, heme aquí.", SchemaType.FLOW),
                StudyChapter(22, "Sacrificio de Isaac", listOf(VerseRef("Génesis", 22, 1, "Dios probó a Abraham.", "Torres Amat")), "Prueba de fe.", listOf("¿Qué es lo más importante para ti?", "¿Qué es la fe?"), "¿Qué darías por Dios?", "Señor, tú eres mi todo.", SchemaType.COMPARISON)
            )
        ),
        StudyBook(
            id = "exodo",
            name = "Éxodo",
            testament = "Antiguo Testamento",
            summary = "Relata la liberación de los israelitas de la esclavitud en Egipto, la entrega de la Ley en el Sinaí y la construcción del Tabernáculo.",
            historicalContext = "Escrito por Moisés (tradición). Narra eventos que llevaron a la formación de Israel como nación bajo la guía de Dios.",
            authorAndDate = "Moisés (tradición).",
            keyThemes = listOf("Liberación", "Ley", "Presencia de Dios"),
            outline = listOf(
                OutlineSection("Esclavitud y Liberación", "1-15", listOf("Plagas", "Pascua", "Mar Rojo")),
                OutlineSection("Ley y Alianza", "16-40", listOf("Sinaí", "Diez Mandamientos", "Tabernáculo"))
            ),
            chapters = listOf(
                StudyChapter(3, "La Zarza Ardiente", listOf(VerseRef("Éxodo", 3, 14, "Yo soy el que soy.", "Torres Amat")), "Dios se revela a Moisés.", listOf("¿Por qué Moisés temió?", "¿Qué representa el fuego?"), "¿Escuchas a Dios?", "Señor, guíame.", SchemaType.FLOW),
                StudyChapter(14, "El Mar Rojo", listOf(VerseRef("Éxodo", 14, 13, "No temáis; estad firmes.", "Torres Amat")), "Dios abre camino.", listOf("¿Cuál es tu mar?", "¿Confías en el plan?"), "¿Confías?", "Señor, abre camino.", SchemaType.FLOW),
                StudyChapter(20, "Los Diez Mandamientos", listOf(VerseRef("Éxodo", 20, 2, "Yo soy el Señor tu Dios.", "Torres Amat")), "La Ley del pacto.", listOf("¿Qué mandamiento te cuesta más?", "¿Por qué ley?"), "¿Vives su amor?", "Señor, enséñame.", SchemaType.FLOW)
            )
        ),
        StudyBook(
            id = "salmos",
            name = "Salmos",
            testament = "Antiguo Testamento",
            summary = "Una colección de oraciones y alabanzas que expresan toda la gama de experiencias humanas ante Dios.",
            historicalContext = "Escritos por varios autores, principalmente David. Abarcan siglos de historia de Israel.",
            authorAndDate = "David, Asaf, hijos de Coré, Salomón, etc.",
            keyThemes = listOf("Alabanza", "Lamento", "Confianza"),
            outline = listOf(
                OutlineSection("Salmos del 1 al 150", "1-150", listOf("Libros I-V"))
            ),
            chapters = listOf(
                StudyChapter(23, "El Señor es mi Pastor", listOf(VerseRef("Salmo", 23, 1, "El Señor es mi pastor, nada me faltará.", "Torres Amat")), "La confianza absoluta del salmista.", listOf("¿Cómo te sientes al imaginar a Dios como tu pastor?", "¿Qué representa el valle?"), "Descansa en Dios.", "Señor, gracias.", SchemaType.CYCLE),
                StudyChapter(91, "Bajo su amparo", listOf(VerseRef("Salmo", 91, 1, "El que habita al abrigo del Altísimo.", "Torres Amat")), "Refugio en Dios.", listOf("¿Qué significa 'habitar al abrigo'?", "¿Confías en su protección?"), "Busca su refugio.", "Señor, eres mi escudo.", SchemaType.CYCLE)
            )
        ),
        StudyBook("levitico", "Levítico", "Antiguo Testamento", "Leyes de santidad.", "Sinaí (revisar).", "Moisés (tradición).", listOf("Santidad"), listOf(OutlineSection("Leyes", "1-27", listOf("Sacrificios"))), listOf(StudyChapter(16, "Día de Expiación", emptyList(), "Purificación", listOf("¿Por qué es necesario el perdón?"), "¿Buscas pureza?", "Perdóname.", SchemaType.TREE))),
        StudyBook("numeros", "Números", "Antiguo Testamento", "Peregrinaje desierto.", "Desierto (revisar).", "Moisés (tradición).", listOf("Peregrinaje"), listOf(OutlineSection("Censo", "1-36", listOf("Viaje"))), listOf(StudyChapter(13, "Espías", emptyList(), "Miedo vs fe", listOf("¿Por qué temieron?"), "¿Confías en Dios?", "Fe, Señor.", SchemaType.TREE))),
        StudyBook("deuteronomio", "Deuteronomio", "Antiguo Testamento", "Segunda Ley.", "Discursos finales.", "Moisés (tradición).", listOf("Amor a Dios"), listOf(OutlineSection("Ley", "1-34", listOf("Shemá"))), listOf(StudyChapter(6, "El Shemá", listOf(VerseRef("Deuteronomio", 6, 5, "Amarás al Señor tu Dios.", "Torres Amat")), "Amor total.", listOf("¿Qué significa amar a Dios?"), "¿Lo amas hoy?", "Señor, ámame.", SchemaType.COMPARISON))),
        StudyBook("mateo", "Mateo", "Nuevo Testamento", "Jesús Mesías.", "Judíos (revisar).", "Mateo.", listOf("Reino"), listOf(OutlineSection("Vida", "1-28", listOf("Sermón"))), listOf(StudyChapter(5, "Bienaventuranzas", listOf(VerseRef("Mateo", 5, 3, "Bienaventurados los pobres.", "Torres Amat")), "Reino de Dios.", listOf("¿Qué es ser pobre de espíritu?"), "¿Vives su Reino?", "Señor, enséñame.", SchemaType.TREE))),
        StudyBook("marcos", "Marcos", "Nuevo Testamento", "Jesús Siervo.", "Romanos (revisar).", "Marcos.", listOf("Acción"), listOf(OutlineSection("Acción", "1-16", listOf("Milagros"))), listOf(StudyChapter(1, "Llamado", emptyList(), "Acción inmediata.", listOf("¿Cómo respondes al llamado?"), "¿Respondes ya?", "Heme aquí.", SchemaType.FLOW))),
        StudyBook("juan", "Juan", "Nuevo Testamento", "Jesús Divino.", "Universal (revisar).", "Juan.", listOf("Luz", "Verdad"), listOf(OutlineSection("Divinidad", "1-21", listOf("Logos"))), listOf(StudyChapter(1, "El Logos", listOf(VerseRef("Juan", 1, 1, "El Verbo era Dios.", "Torres Amat")), "Cristo Dios.", listOf("¿Quién es Jesús para ti?"), "¿Lo reconoces?", "Señor, creo.", SchemaType.TREE))),
        StudyBook("hechos", "Hechos", "Nuevo Testamento", "Espíritu Santo.", "Iglesia.", "Lucas.", listOf("Espíritu", "Testimonio"), listOf(OutlineSection("Iglesia", "1-28", listOf("Pentecostés"))), listOf(StudyChapter(2, "Pentecostés", emptyList(), "Poder del Espíritu.", listOf("¿Dónde está el Espíritu hoy?"), "¿Vives su poder?", "Ven, Espíritu.", SchemaType.FLOW))),
        StudyBook("romanos", "Romanos", "Nuevo Testamento", "Justificación.", "Iglesia Roma.", "Pablo.", listOf("Justicia", "Fe"), listOf(OutlineSection("Salvación", "1-16", listOf("Gracia"))), listOf(StudyChapter(8, "Vida en el Espíritu", emptyList(), "No condenación.", listOf("¿Qué significa 'no hay condenación'?"), "¿Vives libre?", "Gracias, Señor.", SchemaType.COMPARISON)))
    )
}
