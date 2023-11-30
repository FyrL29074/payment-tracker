package com.fyrl29074.payment_tracker.app

sealed class State {
    data object Waiting : State()
    data object Loading : State()
    data class Loaded<T>(val data: T): State()
    data object Success : State()
    data class Error(val message: String) : State()
    data object TokenError : State()
}
