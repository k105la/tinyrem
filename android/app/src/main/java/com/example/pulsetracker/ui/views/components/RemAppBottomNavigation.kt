package com.example.pulsetracker.ui.views.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.pulsetracker.R
import com.example.pulsetracker.ui.theme.DodgerBlue

@Composable
fun RemAppBottomNavigation(
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(DodgerBlue),
                icon = { Icon(painterResource(id = screen.icon), null) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = false,
                onClick = {

                }
            )
        }
    }
}

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: Int
) {

    object Home : BottomNavigationScreens("Home", R.string.home_route, R.drawable.ic_baseline_home_24)
    object Sleep : BottomNavigationScreens("Sleep", R.string.sleep_route, R.drawable.moon)

    object Wellness :
        BottomNavigationScreens("Wellness", R.string.alarm_route, R.drawable.ic_baseline_alarm_24)

}
