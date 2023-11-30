package com.fyrl29074.payment_tracker.domain.usecase

import com.fyrl29074.payment_tracker.domain.repository.StorageRepository

class LogoutUseCase(
    private val storageRepository: StorageRepository,
) {
    fun execute() {
        storageRepository.clearToken()
    }
}