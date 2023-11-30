package com.fyrl29074.payment_tracker.data.model

import com.google.gson.annotations.SerializedName

data class PaymentResponse(
    @SerializedName("success")
    val success: String,
    @SerializedName("response")
    val payments: List<PaymentDto>?,
    @SerializedName("error")
    val error: Error?,
)