package com.fyrl29074.payment_tracker.domain.repository

import com.fyrl29074.payment_tracker.domain.model.Payment
import com.fyrl29074.payment_tracker.domain.model.Token

interface RestRepository {

    suspend fun login(login: String, password: String): Token
    suspend fun getPayments(token: String): List<Payment>
}