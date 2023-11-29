package com.fyrl29074.payment_tracker.data.model

import com.google.gson.annotations.SerializedName

data class LoginBody(
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String,
)
