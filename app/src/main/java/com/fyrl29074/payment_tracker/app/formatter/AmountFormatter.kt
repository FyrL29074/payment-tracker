package com.fyrl29074.payment_tracker.app.formatter

object AmountFormatter {
    fun format(amount: Double?): String {
        return if (amount == null)  {
            "Unknown amount"
        } else {
            String.format("%.2f", amount)
        }
    }
}