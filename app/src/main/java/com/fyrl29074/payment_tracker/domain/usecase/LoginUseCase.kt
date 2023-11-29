package com.fyrl29074.payment_tracker.domain.usecase

import com.fyrl29074.payment_tracker.domain.repository.RestRepository
import com.fyrl29074.payment_tracker.domain.repository.StorageRepository

class LoginUseCase(
    private val repository: RestRepository,
    private val storageRepository: StorageRepository,
) {
    suspend fun execute(login: String, password: String) {
        val token = repository.login(login, password)
        storageRepository.saveToken(token.token)
    }
}