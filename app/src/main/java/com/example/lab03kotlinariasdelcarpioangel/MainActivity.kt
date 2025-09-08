package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab03kotlinariasdelcarpioangel.ui.theme.Lab03KotlinAriasDelCarpioAngelTheme

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                MyFlowRowExample()
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyFlowRowExample() {
    // 1. Creamos una lista de strings para nuestras etiquetas
    val topics = listOf(
        "Kotlin", "Jetpack Compose", "Android", "UI/UX", "Desarrollo de Apps",
        "Material Design 3", "Coroutines", "API", "Firebase", "ViewModel",
        "Pruebas Unitarias", "Retrofit"
    )

    // 2. Usamos el contenedor FlowRow
    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        // Espaciado horizontal y vertical entre los elementos
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // 3. Creamos un Chip para cada tópico en la lista
        topics.forEach { topic ->
            ElevatedSuggestionChip(
                onClick = { /* Acción para el chip */ },
                label = { Text(topic) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyFlowRowExample()
    }
}