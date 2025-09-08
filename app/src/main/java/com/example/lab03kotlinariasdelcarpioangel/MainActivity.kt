package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                // Usamos un Surface para que el fondo de la app sea del color del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Aquí implementamos nuestro LazyColumn
                    MyLazyColumn()
                }
            }
        }
    }
}

@Composable
fun MyLazyColumn() {
    // 1. Creamos una lista de datos (en este caso, 50 strings)
    val items = (1..50).map { "Item número $it" }

    // 2. Usamos el componente LazyColumn
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // 3. Usamos la función `items` para construir la lista dinámicamente
        items(items) { item ->
            // Para cada 'item' en nuestra lista, creamos un Text
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Añadimos un poco de espacio
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyLazyColumn()
    }
}