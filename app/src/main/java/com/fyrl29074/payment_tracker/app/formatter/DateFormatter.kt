package com.fyrl29074.payment_tracker.app.formatter

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun format(createdDate: Int?): String {
        if (createdDate == null) {
            return "Unknown date"
        }

        val timestamp = createdDate * 1000L
        val date = Date(timestamp)

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())

        return dateFormat.format(date)
    }
}