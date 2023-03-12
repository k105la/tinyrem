package com.example.pulsetracker.ui.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pulsetracker.ui.views.components.*

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            PulseTrackerLogo()
            Spacer(modifier = Modifier.height(25.dp))

            UserNameTextField()
            PasswordTextField()

            Spacer(modifier = Modifier.height(25.dp))
            LoginButton()
            Spacer(modifier = Modifier.height(25.dp))
            SignupButton()
        }
    }

}