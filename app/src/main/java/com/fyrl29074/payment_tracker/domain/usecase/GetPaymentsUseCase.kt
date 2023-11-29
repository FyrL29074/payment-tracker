package com.fyrl29074.payment_tracker.domain.usecase

import com.fyrl29074.payment_tracker.domain.model.Payment
import com.fyrl29074.payment_tracker.domain.repository.RestRepository
import com.fyrl29074.payment_tracker.domain.repository.StorageRepository

class GetPaymentsUseCase(
    private val repository: RestRepository,
    private val storageRepository: StorageRepository,
) {
    suspend fun execute(): List<Payment> {
        val token = storageRepository.getToken()
        return repository.getPayments(token)
    }
}