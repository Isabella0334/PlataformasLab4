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

class Pantalla3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Pantalla3Content()
            }
        }
    }
}

@Composable
fun Pantalla3Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBarSettings()

        Spacer(modifier = Modifier.height(16.dp))

        SettingOption(iconRes = R.drawable.profile_pic, text = "Edit Profile")
        SettingOption(iconRes = R.drawable.ic_email, text = "Email Addresses")
        SettingOption(iconRes = R.drawable.ic_notifications, text = "Notifications")
        SettingOption(iconRes = R.drawable.ic_privacy, text = "Privacy")

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        SettingOption(iconRes = R.drawable.ic_help, text = "Help & Feedback")
        SettingOption(iconRes = R.drawable.ic_about, text = "About")

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Logout",
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun TopBarSettings() {
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
            text = "Settings",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        IconButton(onClick = { /* Acción de ajustes */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "Settings",
                tint = Color.Black
            )
        }
    }
}

@Composable
fun SettingOption(iconRes: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla3Preview() {
    MyApplicationTheme {
        Pantalla3Content()
    }
}
