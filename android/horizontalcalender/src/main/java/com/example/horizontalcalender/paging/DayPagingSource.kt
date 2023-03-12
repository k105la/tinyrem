package com.example.horizontalcalender.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.horizontalcalender.model.Day
import java.text.SimpleDateFormat
import java.util.*

class DayPagingSource(private val startYear: Int = 2023, private val endYear: Int = 2040) :
    PagingSource<Int, Day>() {

    private val calendar = Calendar.getInstance()

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Day> {
        val page = params.key ?: startYear
        val days = mutableListOf<Day>()


        for (month in 0..11) {
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.YEAR, page)

            val numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            for (day in 1..numDaysInMonth) {
                calendar.set(Calendar.DAY_OF_MONTH, day)
                val dayOfWeek = calendar.getDisplayName(
                    Calendar.DAY_OF_WEEK,
                    Calendar.SHORT,
                    Locale.getDefault()
                )
                val displayDate = String.format("%02d", day)
                val fullDate = dateFormat.format(calendar.time)
                val displayMonth = calendar.getDisplayName(
                    Calendar.MONTH,
                    Calendar.SHORT,
                    Locale.getDefault()
                )
                val year = calendar.get(Calendar.YEAR).toString()
                val day = Day(dayOfWeek, displayDate, fullDate, displayMonth, year)
                days.add(day)
            }
        }
        return LoadResult.Page(
            data = days,
            prevKey = if (page > startYear) page - 1 else null,
            nextKey = if (page < endYear) page + 1 else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Day>): Int? {
        return null
    }
}