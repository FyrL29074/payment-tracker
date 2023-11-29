package com.fyrl29074.payment_tracker.domain.repository

interface StorageRepository {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String
}