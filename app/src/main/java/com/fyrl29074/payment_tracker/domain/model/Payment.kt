package com.fyrl29074.payment_tracker.domain.model

data class Payment(
    val amount: Double,
    val created: Int,
    val id: Int,
    val title: String,
)
