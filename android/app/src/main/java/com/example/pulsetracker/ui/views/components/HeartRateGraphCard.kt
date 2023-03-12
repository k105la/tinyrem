package com.example.pulsetracker.ui.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pulsetracker.ui.theme.DodgerBlue
import kotlin.random.Random

@Composable
fun HeartRateGraphCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Heart rate",
                    fontWeight = FontWeight.SemiBold,
                    color = DodgerBlue
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = DodgerBlue,
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable { }
                )

            }
            // Canvas for graph
            val yStep = 15
            val random = Random
            /* to test with random points */
            val points = (0..9).map {
                var num = random.nextInt(100)
                if (num <= 50)
                    num += 50
                num.toFloat()
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
            ) {
                Graph(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    xValues = (0..9).map { it + 1 },
                    yValues = (0..9).map { (it + 1) * yStep },
                    points = points,
                    paddingSpace = 16.dp,
                    verticalStep = yStep
                )
            }
        }
    }
}