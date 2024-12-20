package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Pantalla1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Pantalla1Content()
            }
        }
    }
}

@Composable
fun Pantalla1Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal "Campus Central"
        Text(
            text = "Campus Central",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Imagen principal del campus
        Image(
            painter = painterResource(id = R.drawable.campus), // Reemplaza con la imagen correspondiente
            contentDescription = "Imagen del Campus",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        // Sección "DESTACADOS"
        Text(
            text = "DESTACADOS",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 8.dp)
        )

        // Fila de destacados
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FeaturedItem(
                imageRes = R.drawable.uvg1, // Reemplaza con la imagen correspondiente
                buttonText = "Service Now",
                buttonColor = Color(0xFF4CAF50) // Verde
            )
            FeaturedItem(
                imageRes = R.drawable.uvg2, // Reemplaza con la imagen correspondiente
                buttonText = "Actualidad UVG",
                buttonColor = Color(0xFFB0BEC5) // Gris
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección "SERVICIOS Y RECURSOS"
        Text(
            text = "SERVICIOS Y RECURSOS",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 8.dp)
        )

        // Fila de servicios y recursos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FeaturedItem(
                imageRes = R.drawable.uvg3, // Reemplaza con la imagen correspondiente
                buttonText = "Directorio de Servicios",
                buttonColor = Color(0xFF4CAF50) // Verde
            )
            FeaturedItem(
                imageRes = R.drawable.uvg4, // Reemplaza con la imagen correspondiente
                buttonText = "Portal Web Bibliotecas UVG",
                buttonColor = Color(0xFFB0BEC5) // Gris
            )
        }
    }
}

@Composable
fun FeaturedItem(imageRes: Int, buttonText: String, buttonColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(150.dp) // Ancho consistente para cada ítem
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
        )
        Button(
            onClick = { /* Acción cuando se presiona el botón */ },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor), // Corregido: containerColor
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = buttonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla1Preview() {
    MyApplicationTheme {
        Pantalla1Content()
    }
}
