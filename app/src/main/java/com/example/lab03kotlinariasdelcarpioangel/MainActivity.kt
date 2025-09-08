package com.example.lab03kotlinariasdelcarpioangel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.lab03kotlinariasdelcarpioangel.ui.theme.Lab03KotlinAriasDelCarpioAngelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab03KotlinAriasDelCarpioAngelTheme {
                MyConstraintLayout()
            }
        }
    }
}

@Composable
fun MyConstraintLayout() {
    // 1. Envuelve tu UI en el contenedor ConstraintLayout
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // 2. Crea referencias para cada componente que quieras posicionar
        val (button, text) = createRefs()

        // 3. Asigna la referencia al componente y define sus restricciones
        Button(
            onClick = { /*TODO*/ },
            // Usa el modificador `constrainAs` para vincular la referencia
            modifier = Modifier.constrainAs(button) {
                // Centra el botón en medio de la pantalla (el padre)
                centerTo(parent)
            }
        ) {
            Text("Click Me")
        }

        Text(
            "Hello World!",
            // Vincula la referencia del texto
            modifier = Modifier.constrainAs(text) {
                // Posiciona la parte inferior del texto anclada a la parte superior del botón
                bottom.linkTo(button.top, margin = 16.dp)
                // Centra el texto horizontalmente con respecto a la pantalla
                centerHorizontallyTo(parent)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03KotlinAriasDelCarpioAngelTheme {
        MyConstraintLayout()
    }
}