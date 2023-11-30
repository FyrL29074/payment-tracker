package com.fyrl29074.payment_tracker.data.model

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token")
    val token: String,
)