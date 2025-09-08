package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Ahora llamamos a nuestra nueva función LazyRow
                    MyLazyRow()
                }
            }
        }
    }
}

@Composable
fun MyLazyRow() {
    // 1. La lista de datos es la misma
    val items = (1..50).map { "Item $it" }

    // 2. Cambiamos LazyColumn por LazyRow
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        // 3. La construcción de los items es idéntica
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(16.dp) // El padding ahora separa horizontalmente
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyLazyRow()
    }
}