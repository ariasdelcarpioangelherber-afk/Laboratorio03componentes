package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
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
import kotlin.math.roundToInt
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
                    MySliderExample()
                }
            }
        }
    }
}

@Composable
fun MySliderExample() {
    // 1. Estado para guardar el valor actual del slider (Float).
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 2. Texto que muestra el valor seleccionado (redondeado a entero).
        Text(
            text = "Valor seleccionado: ${sliderPosition.roundToInt()}",
            style = MaterialTheme.typography.headlineMedium
        )

        // 3. El componente Slider.
        Slider(
            value = sliderPosition,
            onValueChange = { newPosition ->
                sliderPosition = newPosition
            },
            // Opcional: Definimos el rango de valores.
            valueRange = 0f..100f,
            // Opcional: Definimos los "pasos" para que el slider se mueva en incrementos.
            // En este caso, se moverá de 5 en 5 (0, 5, 10...).
            // El número de pasos es (100-0)/5 - 1 = 19
            steps = 19
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MySliderExample()
    }
}