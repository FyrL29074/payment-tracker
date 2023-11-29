package com.fyrl29074.payment_tracker.data.repository

import com.fyrl29074.payment_tracker.CustomException.InvalidTokenException
import com.fyrl29074.payment_tracker.data.RetrofitService
import com.fyrl29074.payment_tracker.data.model.LoginBody
import com.fyrl29074.payment_tracker.data.model.mapper.PaymentMapper
import com.fyrl29074.payment_tracker.domain.model.Payment
import com.fyrl29074.payment_tracker.domain.model.Token
import com.fyrl29074.payment_tracker.domain.repository.RestRepository

class RestRepositoryImpl: RestRepository {

    override suspend fun login(login: String, password: String): Token {
        val loginBody = LoginBody(login, password)
        val response = RetrofitService.mainApi.login(loginBody)

        if (!response.isSuccessful || response.body() == null) {
            throw InvalidTokenException(message = response.message())
        }

        return Token(response.body()!!.response.token)
    }

    override suspend fun getPayments(token: String): List<Payment> {
        val response = RetrofitService.mainApi.getPayments(token)

        if (!response.isSuccessful || response.body() == null) {
            throw InvalidTokenException(message = response.message())
        }

        val payments = response.body()!!.payments.map { dto ->
            PaymentMapper.map(dto)
        }

        return payments
    }
}