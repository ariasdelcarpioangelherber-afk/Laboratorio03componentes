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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
                    MyButtonExamples()
                }
            }
        }
    }
}

@Composable
fun MyButtonExamples() {
    // 1. Estado para guardar el número de clics
    var clickCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Botones presionados: $clickCount",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 2. Botón estándar (Button)
        Button(onClick = { clickCount++ }) {
            Text("Botón Estándar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Botón con elevación (ElevatedButton)
        ElevatedButton(onClick = { clickCount++ }) {
            Text("Botón con Elevación")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 4. Botón con borde (OutlinedButton)
        OutlinedButton(onClick = { clickCount++ }) {
            Text("Botón con Borde")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 5. Botón de texto (TextButton)
        TextButton(onClick = { clickCount++ }) {
            Text("Botón de Texto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 6. Botón con icono
        Button(onClick = { clickCount++ }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Icono de añadir",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text("Añadir")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyButtonExamples()
    }
}