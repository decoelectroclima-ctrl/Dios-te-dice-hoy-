package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.data.BibleRepository
import com.example.data.BibleVerseEntity
import androidx.compose.ui.platform.LocalContext

@Composable
fun BibleReaderScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val repository = remember { BibleRepository(context) }
    var verses by remember { mutableStateOf<List<BibleVerseEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        verses = repository.getVerses()
    }

    LazyColumn(modifier = modifier.fillMaxSize().padding(16.dp)) {
        item {
            Text("Lectura Bíblica", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(verses.size) { index ->
            val verse = verses[index]
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(verse.citation, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(verse.text, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
