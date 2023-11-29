package com.fyrl29074.payment_tracker.domain.repository

interface StorageRepository {
    fun saveToken(token: String)
    fun getToken(): String
}