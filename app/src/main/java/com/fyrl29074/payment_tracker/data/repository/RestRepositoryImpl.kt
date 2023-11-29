package com.fyrl29074.payment_tracker.data.repository

import com.fyrl29074.payment_tracker.CustomException.InvalidTokenException
import com.fyrl29074.payment_tracker.data.RetrofitService
import com.fyrl29074.payment_tracker.data.model.LoginBody
import com.fyrl29074.payment_tracker.data.model.PaymentDto

class RestRepositoryImpl {

    suspend fun login(login: String, password: String): String {
        val loginBody = LoginBody(login, password)
        val response = RetrofitService.mainApi.login(loginBody)

        if (!response.isSuccessful || response.body() == null) {
            throw InvalidTokenException(message = response.message())
        }

        return response.body()!!.response.token
    }

    suspend fun getPayments(token: String): List<PaymentDto> {
        val response = RetrofitService.mainApi.getPayments(token)

        if (!response.isSuccessful || response.body() == null) {
            throw InvalidTokenException(message = response.message())
        }

        return response.body()!!.payments
    }
}