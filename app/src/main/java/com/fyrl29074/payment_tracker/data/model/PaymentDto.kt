package com.fyrl29074.payment_tracker.data.model

data class PaymentDto(
    val amount: Double,
    val created: Int,
    val id: Int,
    val title: String
)