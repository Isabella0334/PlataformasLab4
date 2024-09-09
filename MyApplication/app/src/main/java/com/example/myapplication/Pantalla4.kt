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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class Pantalla4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Pantalla4Content()
            }
        }
    }
}

@Composable
fun Pantalla4Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBarEmergencyContacts()

        Spacer(modifier = Modifier.height(16.dp))
        
        EmergencyContact(
            iconRes = R.drawable.ic_emergency,
            title = "Emergencias",
            description = "Si se presenta un incidente o un percance, por favor marca el número de emergencia y rápidamente te apoyamos.",
            phoneNumber = "5978-1736"
        )

        Spacer(modifier = Modifier.height(16.dp))

        EmergencyContact(
            iconRes = R.drawable.ic_clinic,
            title = "Clínica UVG",
            description = """
                La Clínica UVG presta los siguientes servicios:
                - Atención a Emergencias
                - Atención Primaria a Enfermedades Comunes
                - Plan Educacional sobre Enfermedades
            """.trimIndent(),
            phoneNumber = "2507-1500 ex 21312",
            additionalInfo = "Horario de Atención: 7:00 a.m. a 8:30 p.m.\nCampus Central Edificio F 119-120"
        )
    }
}

@Composable
fun TopBarEmergencyContacts() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Acción para volver */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        Text(
            text = "Emergency Contacts",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "Settings",
                tint = Color.Black
            )
        }
    }
}

@Composable
fun EmergencyContact(iconRes: Int, title: String, description: String, phoneNumber: String, additionalInfo: String = "") {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* Acción de llamada */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Call $phoneNumber")
        }

        if (additionalInfo.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = additionalInfo,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla4Preview() {
    MyApplicationTheme {
        Pantalla4Content()
    }
}
