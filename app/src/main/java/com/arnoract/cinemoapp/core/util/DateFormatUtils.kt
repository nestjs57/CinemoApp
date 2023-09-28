package com.arnoract.cinemoapp.core.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormatUtils {
    fun formatMonthDateCommaYear(
        inputDate: String,
    ): String {

        val inputFormat = SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date)
    }
}
