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
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
                    MyProgressBarExamples()
                }
            }
        }
    }
}

@Composable
fun MyProgressBarExamples() {
    // 1. Estado para controlar el progreso de las barras determinadas
    var progress by remember { mutableFloatStateOf(0.1f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Barras de Progreso Indeterminadas (Carga infinita)")
        Spacer(modifier = Modifier.height(16.dp))

        // 2. Barra de progreso circular indeterminada
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))

        // 3. Barra de progreso lineal indeterminada
        LinearProgressIndicator()

        Spacer(modifier = Modifier.height(32.dp))

        Text("Barras de Progreso Determinadas (Progreso controlado)")
        Spacer(modifier = Modifier.height(16.dp))

        // 4. Barra de progreso circular determinada
        CircularProgressIndicator(progress = progress)
        Spacer(modifier = Modifier.height(16.dp))

        // 5. Barra de progreso lineal determinada
        LinearProgressIndicator(progress = progress)
        Spacer(modifier = Modifier.height(16.dp))

        // 6. Botón para simular el avance del progreso
        Button(onClick = {
            if (progress < 1f) {
                progress += 0.1f
            } else {
                progress = 0.1f // Reinicia si llega al final
            }
        }) {
            Text("Aumentar Progreso")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyProgressBarExamples()
    }
}