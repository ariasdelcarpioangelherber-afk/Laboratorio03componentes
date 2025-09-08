package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                BackdropPatternExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackdropPatternExample() {
    // 1. Estado para controlar si la capa frontal está visible/expandida
    var frontLayerVisible by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Patrón Backdrop M3") },
                navigationIcon = {
                    // 2. Botón para mostrar/ocultar la capa frontal
                    IconButton(onClick = { frontLayerVisible = !frontLayerVisible }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 3. Capa Trasera (Back Layer) - Siempre visible
            BackLayerContent()

            // 4. Capa Frontal (Front Layer) - Su visibilidad es animada
            AnimatedVisibility(visible = frontLayerVisible) {
                FrontLayerContent()
            }
        }
    }
}

@Composable
fun BackLayerContent() {
    // La capa trasera usualmente tiene opciones o filtros
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Esta es la Capa Trasera")
        Text("Aquí van las opciones principales")
    }
}

@Composable
fun FrontLayerContent() {
    // La capa frontal muestra el contenido principal
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp), // Un margen superior para que se vea la capa trasera
        shape = CardDefaults.shape, // Esquinas redondeadas por defecto
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Esta es la Capa Frontal")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        BackdropPatternExample()
    }
}