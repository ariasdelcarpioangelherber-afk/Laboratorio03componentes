package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab03kotlinariasdelcarpioangel.ui.theme.Lab03KotlinAriasDelCarpioAngelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                MySurfaceExample()
            }
        }
    }
}

@Composable
fun MySurfaceExample() {
    // Usamos un Box para centrar nuestro Surface en la pantalla
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // 1. Este es el Surface que estamos personalizando
        Surface(
            modifier = Modifier.size(200.dp), // Le damos un tamaño fijo
            // 2. Le damos un color de fondo
            color = MaterialTheme.colorScheme.surfaceVariant,
            // 3. Redondeamos sus esquinas
            shape = RoundedCornerShape(16.dp),
            // 4. Añadimos una sombra (elevación)
            shadowElevation = 10.dp,
            // 5. Añadimos un borde
            border = BorderStroke(2.dp, Color.Red)
        ) {
            // Ponemos un texto dentro del Surface para que se vea el contenido
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hola, Surface!",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MySurfaceExample()
    }
}