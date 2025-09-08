package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    // Llamamos a nuestra nueva función de Grid
                    MyLazyVerticalGrid()
                }
            }
        }
    }
}

@Composable
fun MyLazyVerticalGrid() {
    // 1. La lista de datos sigue siendo la misma
    val items = (1..50).map { "Item $it" }

    // 2. Usamos el componente LazyVerticalGrid
    LazyVerticalGrid(
        // 3. Aquí definimos el número de columnas
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        // Opcional: añade espaciado entre los elementos
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 4. La construcción de los items es similar a las listas
        items(items) { item ->
            // Para que se vea mejor, cada item tendrá su propio fondo
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = item,
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
        MyLazyVerticalGrid()
    }
}