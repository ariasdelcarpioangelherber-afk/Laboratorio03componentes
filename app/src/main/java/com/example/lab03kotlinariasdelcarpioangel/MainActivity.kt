package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab03kotlinariasdelcarpioangel.ui.theme.Lab03KotlinAriasDelCarpioAngelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyRadioButtonExample()
                }
            }
        }
    }
}

@Composable
fun MyRadioButtonExample() {
    // 1. Lista de opciones que mostraremos.
    val languages = listOf("Kotlin", "Java", "Swift")
    // 2. Estado para guardar la opción seleccionada. Empieza con la primera.
    var selectedLanguage by remember { mutableStateOf(languages[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¿Cuál es tu lenguaje de programación favorito?", style = MaterialTheme.typography.titleLarge)

        // 3. Creamos un RadioButton para cada opción en la lista.
        languages.forEach { language ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    // Hacemos que toda la fila sea clickeable para mejor UX
                    .clickable { selectedLanguage = language }
            ) {
                RadioButton(
                    // El botón está seleccionado si el lenguaje actual es el que está guardado en el estado.
                    selected = (language == selectedLanguage),
                    onClick = { selectedLanguage = language }
                )
                Text(text = language, modifier = Modifier.padding(start = 8.dp))
            }
        }

        // 4. Mostramos un texto con la selección actual.
        Text(
            text = "Seleccionado: $selectedLanguage",
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyRadioButtonExample()
    }
}