package com.fyrl29074.payment_tracker.data.model

data class PaymentResponse(
    val success: String,
    val payments: List<PaymentDto>,
)