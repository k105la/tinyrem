package com.example.horizontalcalender

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.horizontalcalender.component.HorizontalCalendarComponent
import com.example.horizontalcalender.model.Day
import com.example.horizontalcalender.paging.DayPagingSource
import com.example.horizontalcalender.viewmodel.HorizontalCalendarViewModel


@Composable
fun HorizontalCalendarView(
    modifier: Modifier,
    onClick: (Day) -> Unit = {},
    selectedCardColor: Color,
    unSelectedCardColor: Color,
    selectedTextColor: Color,
    unSelectedTextColor: Color
) {
    val viewModel: HorizontalCalendarViewModel = viewModel()

    val days = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 4),
        pagingSourceFactory = {
            DayPagingSource()
        }
    ).flow
    

    HorizontalCalendarComponent(
        modifier = modifier,
        days = days,
        isSelected = { fullDate -> viewModel.selectedDate.value == fullDate },
        onClick = { day ->
            viewModel.setSelectedDateState(day.fullDate)
            onClick(day)
        },
        selectedTextColor = selectedTextColor,
        unSelectedTextColor = unSelectedTextColor,
        selectedCardColor = selectedCardColor,
        unSelectedCardColor = unSelectedCardColor
    )
}