package com.fyrl29074.payment_tracker.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.fyrl29074.payment_tracker.domain.repository.StorageRepository

class StorageRepositoryImpl(context: Context): StorageRepository {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }

    override fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, DEFAULT_TOKEN) ?: ""
    }

    override fun clearToken() {
        sharedPreferences.edit().remove(TOKEN_KEY).apply()
    }

    companion object {
        private const val PREFS_NAME = "AppPreferences"
        private const val TOKEN_KEY = "token"
        private const val DEFAULT_TOKEN = ""
    }
}