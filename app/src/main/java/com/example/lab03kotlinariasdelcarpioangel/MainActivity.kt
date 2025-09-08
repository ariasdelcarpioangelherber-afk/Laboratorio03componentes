package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    MyTextExamples()
                }
            }
        }
    }
}

@Composable
fun MyTextExamples() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Texto Básico
        Text("Este es un texto simple")

        // 2. Texto con color
        Text(
            "Texto de color primario",
            color = MaterialTheme.colorScheme.primary
        )

        // 3. Texto con otro color
        Text(
            "Texto de color rojo",
            color = Color.Red
        )

        // 4. Texto con tamaño de fuente (sp)
        Text(
            "Texto grande",
            fontSize = 30.sp
        )

        // 5. Texto en negrita (Bold)
        Text(
            "Texto en negrita",
            fontWeight = FontWeight.Bold
        )

        // 6. Texto en cursiva (Italic)
        Text(
            "Texto en cursiva",
            fontStyle = FontStyle.Italic
        )

        // 7. Texto con alineación centrada
        Text(
            "Este texto está centrado dentro de su propio espacio. Para que esto funcione, el texto necesita ocupar un ancho específico y luego se centra dentro de ese ancho.",
            modifier = Modifier.width(300.dp), // Le damos un ancho para que se pueda centrar
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyTextExamples()
    }
}