package com.example.horizontalcalender.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.horizontalcalender.model.Day
import com.example.horizontalcalender.theme.DodgerBlue
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HorizontalCalendarComponent(
    modifier: Modifier,
    days: Flow<PagingData<Day>>,
    onClick: (Day) -> Unit = {},
    isSelected: (String) -> Boolean,
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color
) {
    val allDays = days.collectAsLazyPagingItems()

    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        val monthAndYear = remember { mutableStateOf("") }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = monthAndYear.value,
            color = DodgerBlue,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.End
        )

        allDays.itemSnapshotList.items.forEachIndexed { index, day ->
            if (day.fullDate == dateFormat.format(calendar.time)) {

                val daysLazyRowState = rememberLazyListState(
                    initialFirstVisibleItemIndex = index,
                    initialFirstVisibleItemScrollOffset = 0
                )

                LazyRow(
                    state = daysLazyRowState,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    content = {
                        itemsIndexed(allDays) { i, day ->
                            if (daysLazyRowState.firstVisibleItemIndex == i) {
                                monthAndYear.value = "${day?.monthShortName}, ${day?.year}"
                            }
                            day?.let {
                                DayItemCard(
                                    modifier = modifier,
                                    day = it,
                                    isSelected = isSelected,
                                    onClick = onClick,
                                    selectedCardColor = selectedCardColor,
                                    unSelectedCardColor = unSelectedCardColor,
                                    selectedTextColor = selectedTextColor,
                                    unSelectedTextColor = unSelectedTextColor
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}