package com.fyrl29074.payment_tracker.data.model

data class PaymentDto(
    val id: Int,
    val title: String,
    val amount: Double,
    val created: Int,
)