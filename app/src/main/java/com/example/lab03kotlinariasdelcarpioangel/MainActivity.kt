package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
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
                    MyCheckboxExample()
                }
            }
        }
    }
}

@Composable
fun MyCheckboxExample() {
    // 1. Estado para guardar si el checkbox está marcado o no.
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Usamos una Row para poner el Checkbox y el Text en la misma línea
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // 2. El componente Checkbox
            Checkbox(
                checked = isChecked, // El estado del checkbox depende de nuestra variable
                onCheckedChange = { newCheckedState ->
                    isChecked = newCheckedState // Al cambiar, actualizamos la variable
                }
            )
            Text("Acepto los términos y condiciones")
        }

        // 3. Mostramos un mensaje que depende del estado del checkbox
        val message = if (isChecked) "¡Gracias por aceptar!" else "Por favor, acepta los términos."
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyCheckboxExample()
    }
}