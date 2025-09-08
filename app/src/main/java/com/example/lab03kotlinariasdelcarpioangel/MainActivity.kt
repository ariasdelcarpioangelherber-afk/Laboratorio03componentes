package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
                    MyTextFieldExamples()
                }
            }
        }
    }
}

@Composable
fun MyTextFieldExamples() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Creamos un 'estado' para guardar el texto del primer TextField.
        var textValue1 by remember { mutableStateOf("") }

        Text(
            "¡Hola, ${textValue1}!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. TextField estándar
        TextField(
            value = textValue1, // El valor que muestra es nuestro estado.
            onValueChange = { newText ->
                textValue1 = newText // Al cambiar, actualizamos nuestro estado.
            },
            label = { Text("Escribe tu nombre") }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // --- Ejemplo con OutlinedTextField ---
        var textValue2 by remember { mutableStateOf("") }

        // 3. TextField con borde
        OutlinedTextField(
            value = textValue2,
            onValueChange = { textValue2 = it }, // "it" es una forma corta de referirse a newText
            label = { Text("Escribe tu apellido") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyTextFieldExamples()
    }
}