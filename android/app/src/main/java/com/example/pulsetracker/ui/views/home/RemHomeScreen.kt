package com.example.pulsetracker.ui.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.horizontalcalender.HorizontalCalendarView
import com.example.pulsetracker.ui.theme.DodgerBlue
import com.example.pulsetracker.ui.views.components.BottomNavigationScreens
import com.example.pulsetracker.ui.views.components.HeartRateGraphCard
import com.example.pulsetracker.ui.views.components.RemAppBottomNavigation
import com.example.pulsetracker.ui.views.components.RemTopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Preview
@Composable
fun RemHomeScreen() {
    val systemUiController = rememberSystemUiController()
    //systemUiController.isNavigationBarVisible = false
    //systemUiController.setStatusBarColor(Color(0xFF2094FC))
    //systemUiController.setNavigationBarColor(Color(0xFF2094FC))

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Sleep,
        BottomNavigationScreens.Wellness,

        )
    Scaffold(backgroundColor = Color(0xFFE9F4FF), topBar = {
        RemTopAppBar()
    }, content = {
        // Home screen
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalCalendarView(
                modifier = Modifier,
                selectedCardColor = DodgerBlue,
                unSelectedCardColor = Color.White ,
                selectedTextColor = Color.White,
                unSelectedTextColor = DodgerBlue
            )
            Spacer(modifier = Modifier.height(20.dp))
            HeartRateGraphCard()
        }

    },
        bottomBar = {
            RemAppBottomNavigation(bottomNavigationItems)
        }
    )
}

