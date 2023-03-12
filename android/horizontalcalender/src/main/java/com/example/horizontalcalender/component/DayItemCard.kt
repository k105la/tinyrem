package com.example.horizontalcalender.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.horizontalcalender.model.Day

@Composable
fun DayItemCard(
    modifier: Modifier,
    day: Day,
    onClick: (Day) -> Unit = {},
    isSelected: (String) -> Boolean,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color
) {
    Card(
        modifier = Modifier.wrapContentSize().padding(2.dp)
            .clickable { onClick(day) },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected(day.fullDate)) {
                selectedCardColor
            } else {
                unSelectedCardColor
            }

        )
    ) {
        Box(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = day.dayShortName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(day.fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    }
                )
                Text( text = day.displayData,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = if (isSelected(day.fullDate)) {
                        selectedTextColor
                    } else {
                        unSelectedTextColor
                    })
            }
        }
    }
}