package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class Pantalla2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Pantalla2Content()
            }
        }
    }
}

@Composable
fun Pantalla2Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Sección superior con imagen de fondo y el contenido
        ProfileHeader()

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de opciones del perfil
        ProfileOptionItem(iconRes = R.drawable.ic_campus, text = "My Campus", subtitle = "Campus Central")
        ProfileOptionItem(iconRes = R.drawable.ic_friends, text = "My Friends")
        ProfileOptionItem(iconRes = R.drawable.ic_calendar, text = "My Calendar")
        ProfileOptionItem(iconRes = R.drawable.ic_courses, text = "My Courses")
        ProfileOptionItem(iconRes = R.drawable.ic_grades, text = "My Grades")
        ProfileOptionItem(iconRes = R.drawable.ic_groups, text = "My Groups")
        ProfileOptionItem(iconRes = R.drawable.ic_events, text = "My Upcoming Events")
    }
}

@Composable
fun ProfileHeader() {
    // Stack para superponer imagen de fondo y contenido
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // Ajuste de la altura para acomodar mejor el contenido
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.background_profile), // Imagen de fondo
            contentDescription = "Fondo de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenido superpuesto (nombre, ícono de perfil y configuración)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp)
        ) {
            // Barra blanca superior con título
            TopBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen de perfil redonda
            Image(
                painter = painterResource(id = R.drawable.profile_pic), // Imagen de perfil
                contentDescription = "Imagen de perfil",
                modifier = Modifier
                    .size(120.dp) // Tamaño de la imagen de perfil ajustado
                    .clip(CircleShape)
                    .background(Color.White, CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre de usuario con color blanco para mejor visibilidad
            Text(
                text = "FRANCISCO ROGELIO ANZUETO MARROQUIN",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White, // Texto en blanco para destacar sobre el fondo
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White) // Fondo blanco para la barra superior
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Título de la pantalla
            Text(
                text = "My Profile",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black // Texto en negro sobre el fondo blanco
            )

            // Icono de configuración
            IconButton(onClick = { /* Acción de configuración */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings), // Icono de configuración
                    contentDescription = "Icono de configuración",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun ProfileOptionItem(iconRes: Int, text: String, subtitle: String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono del item
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Texto principal
        Column {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            // Subtítulo si existe
            if (subtitle.isNotEmpty()) {
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla2Preview() {
    MyApplicationTheme {
        Pantalla2Content()
    }
}
