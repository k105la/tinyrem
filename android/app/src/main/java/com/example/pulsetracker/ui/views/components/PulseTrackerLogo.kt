package com.example.pulsetracker.ui.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pulsetracker.R

@Composable
fun PulseTrackerLogo() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 25.dp),
        painter = painterResource(id = R.drawable.full_pulse_logo),
        contentDescription = "PulseTracker logo"
    )
}