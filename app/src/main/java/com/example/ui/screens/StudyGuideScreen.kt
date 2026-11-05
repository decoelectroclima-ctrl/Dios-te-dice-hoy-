package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.data.StudyRepository
import com.example.data.UserPreferences
import com.example.model.StudyBook
import com.example.ui.components.TimelineSchema
import com.example.ui.components.TreeSchema
import com.example.ui.components.FlowSchema
import com.example.ui.components.ComparisonSchema
import com.example.ui.components.CycleSchema
import com.example.model.SchemaType
import androidx.compose.ui.platform.LocalContext

@Composable
fun StudyGuideScreen(onBack: () -> Unit) {
    var selectedBook by remember { mutableStateOf<StudyBook?>(null) }
    
    if (selectedBook == null) {
        LazyColumn {
            items(StudyRepository.books) { book ->
                ListItem(
                    headlineContent = { Text(book.name) },
                    modifier = Modifier.clickable { selectedBook = book }
                )
            }
        }
    } else {
        StudyBookDetail(book = selectedBook!!, onBack = { selectedBook = null })
    }
}

@Composable
fun StudyBookDetail(book: StudyBook, onBack: () -> Unit) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val prefs = remember { UserPreferences(context) }

    Column {
        TextButton(onClick = onBack) { Text("Atrás") }
        Text(book.name, style = MaterialTheme.typography.headlineMedium)
        
        TabRow(selectedTabIndex = selectedTab) {
            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("Resumen") })
            Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("Estructura") })
            Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }, text = { Text("Esquema") })
            Tab(selected = selectedTab == 3, onClick = { selectedTab = 3 }, text = { Text("Capítulos") })
        }
        
        when (selectedTab) {
            0 -> Text(book.summary)
            1 -> Column { book.outline.forEach { Text("${it.title}: ${it.range}") } }
            2 -> {
                when(book.chapters.firstOrNull()?.schema) {
                    SchemaType.TIMELINE -> TimelineSchema()
                    SchemaType.TREE -> TreeSchema()
                    SchemaType.FLOW -> FlowSchema()
                    SchemaType.COMPARISON -> ComparisonSchema()
                    SchemaType.CYCLE -> CycleSchema()
                    else -> {}
                }
            }
            3 -> LazyColumn {
                items(book.chapters) { chapter ->
                    val isStudied = prefs.isChapterStudied("${book.id}_${chapter.number}")
                    Card(modifier = Modifier.padding(8.dp)) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(chapter.title)
                            Text(chapter.observation)
                            Button(onClick = { prefs.toggleChapterStudied("${book.id}_${chapter.number}") }) {
                                Text(if (isStudied) "Estudiado" else "Marcar como estudiado")
                            }
                        }
                    }
                }
            }
        }
    }
}
