package com.fyrl29074.payment_tracker.domain.model

data class Payment(
    val id: Int,
    val title: String,
    val amount: Double,
    val creationDate: Int,
)
