package com.mine.openinapp_android.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.TextStyle
import java.time.temporal.ChronoField
import java.util.Calendar
import java.util.Locale


//val outputFormat = "dd MMMM yyyy, HH:mm:ss"

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTimeFromString(
    inputDateTime: String, inputDateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
): String {
    val inputFormatter = DateTimeFormatter.ofPattern(inputDateFormat)
    val outputFormatter = DateTimeFormatterBuilder()
        .appendText(ChronoField.MONTH_OF_YEAR, TextStyle.SHORT)
        .appendLiteral(" ")
        .appendValue(ChronoField.DAY_OF_MONTH, 2)
        .appendLiteral("")
        .appendValue(ChronoField.YEAR)
        .appendLiteral(" ")
        .appendLiteral("| ")
        .appendValue(ChronoField.CLOCK_HOUR_OF_AMPM, 2)
        .appendLiteral(":")
        .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
        .appendLiteral(" ")
        .appendText(ChronoField.AMPM_OF_DAY, TextStyle.SHORT)
        .toFormatter(Locale.ENGLISH)
    val dateTime: LocalDateTime = LocalDateTime.parse(inputDateTime, inputFormatter)
    return outputFormatter.format(dateTime)

}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateFromString(
    inputDateTime: String,
    inputDateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"): String {
    val inputFormatter = DateTimeFormatter.ofPattern(inputDateFormat)
    val outputFormatter = DateTimeFormatterBuilder()
        .appendValue(ChronoField.DAY_OF_MONTH, 2)
        .appendLiteral(" ")
        .appendText(ChronoField.MONTH_OF_YEAR, TextStyle.SHORT)
        .appendLiteral(" ")
        .appendValue(ChronoField.YEAR)
        .appendLiteral(" ")
        .toFormatter(Locale.ENGLISH)
    val dateTime: LocalDateTime = LocalDateTime.parse(inputDateTime, inputFormatter)
    return outputFormatter.format(dateTime)
}

@RequiresApi(Build.VERSION_CODES.O)
fun FormattedMonthString(input:String): Int {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val month = Month.from(formatter.parse(input))
    return month.value
}