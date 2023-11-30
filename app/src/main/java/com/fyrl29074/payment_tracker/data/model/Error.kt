package com.fyrl29074.payment_tracker.data.model

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_msg")
    val errorMsg: String,
)