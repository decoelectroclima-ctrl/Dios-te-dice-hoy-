package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun TimelineSchema() {
    Canvas(modifier = Modifier.size(300.dp, 100.dp)) {
        drawLine(Color.Black, Offset(0f, 50f), Offset(size.width, 50f), strokeWidth = 2f)
        drawCircle(Color.Red, 10f, Offset(50f, 50f))
        drawCircle(Color.Red, 10f, Offset(250f, 50f))
    }
}

@Composable
fun TreeSchema() {
    Canvas(modifier = Modifier.size(300.dp, 200.dp)) {
        drawLine(Color.Black, Offset(150f, 0f), Offset(150f, 50f), strokeWidth = 2f)
        drawLine(Color.Black, Offset(150f, 50f), Offset(50f, 150f), strokeWidth = 2f)
        drawLine(Color.Black, Offset(150f, 50f), Offset(250f, 150f), strokeWidth = 2f)
    }
}

@Composable
fun FlowSchema() {
    Canvas(modifier = Modifier.size(300.dp, 150.dp)) {
        drawRect(Color.Blue, Offset(10f, 50f), size = androidx.compose.ui.geometry.Size(80f, 50f), style = Stroke(2f))
        drawLine(Color.Black, Offset(90f, 75f), Offset(120f, 75f), strokeWidth = 2f)
        drawRect(Color.Blue, Offset(120f, 50f), size = androidx.compose.ui.geometry.Size(80f, 50f), style = Stroke(2f))
    }
}

@Composable
fun ComparisonSchema() {
    Canvas(modifier = Modifier.size(300.dp, 200.dp)) {
        drawLine(Color.Black, Offset(150f, 0f), Offset(150f, 200f), strokeWidth = 2f)
        // Columna 1
        drawRect(Color.Gray, Offset(20f, 50f), size = androidx.compose.ui.geometry.Size(100f, 100f), style = Stroke(2f))
        // Columna 2
        drawRect(Color.Gray, Offset(180f, 50f), size = androidx.compose.ui.geometry.Size(100f, 100f), style = Stroke(2f))
    }
}

@Composable
fun CycleSchema() {
    Canvas(modifier = Modifier.size(200.dp, 200.dp)) {
        drawCircle(Color.Green, 80f, Offset(100f, 100f), style = Stroke(2f))
    }
}
