package com.fyrl29074.payment_tracker.data.model

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("success")
    val success: String,
    @SerializedName("response")
    val response: TokenDto?,
    @SerializedName("error")
    val error: Error?,
)