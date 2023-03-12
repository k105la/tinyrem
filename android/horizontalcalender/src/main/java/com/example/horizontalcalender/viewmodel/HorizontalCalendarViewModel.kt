package com.example.horizontalcalender.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.horizontalcalender.util.getCurrentDate

class HorizontalCalendarViewModel : ViewModel() {
    private val _selectedDate = mutableStateOf(getCurrentDate())
    private val _initialIndex = mutableStateOf(0)
    val initialIndex : State<Int> = _initialIndex
    val selectedDate: State<String> = _selectedDate
    fun setSelectedDateState(value: String) {
        _selectedDate.value = value
    }
}