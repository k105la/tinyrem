package com.example.horizontalcalender.util

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val today = Calendar.getInstance().time
    return dateFormat.format(today)
}
