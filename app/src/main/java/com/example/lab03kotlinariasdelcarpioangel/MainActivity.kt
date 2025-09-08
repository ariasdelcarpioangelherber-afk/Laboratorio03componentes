package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03kotlinariasdelcarpioangel.ui.theme.Lab03KotlinAriasDelCarpioAngelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                Scaffold(

                    modifier = Modifier.fillMaxSize()



                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        GreetingCard()
                    }
                }
            }
        }
    }
}

// Aquí está el nuevo código de la tarjeta
@Composable
fun GreetingCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tarjeta de presentación
        Image(
            painter = painterResource(id = R.drawable.mono),
            contentDescription = "Android Logo",
            modifier = Modifier.size(400.dp)
        )
        Text(
            text = "Arias Angel Herber",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 20.sp,
            color = Color(0xFF3DDC84) // Un verde similar al del logo de Android
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Sección de contacto
        Column(horizontalAlignment = Alignment.Start) {
            // Teléfono
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mono), // Reemplaza con tu ícono de teléfono
                    contentDescription = "Phone",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "+11 (123) 444 555 666",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            // Compartir
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mono), // Reemplaza con tu ícono de compartir
                    contentDescription = "Share",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "@AndroidDev",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            // Correo electrónico
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mono), // Reemplaza con tu ícono de correo electrónico
                    contentDescription = "Email",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "jen.doe@android.com",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        GreetingCard()
    }
}
