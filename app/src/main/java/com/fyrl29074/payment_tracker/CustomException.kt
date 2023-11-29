package com.fyrl29074.payment_tracker

sealed class CustomException(override val message: String?): Exception() {
    class InvalidTokenException(override val message: String?): CustomException(message)
}
