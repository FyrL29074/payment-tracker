package com.fyrl29074.payment_tracker.app.di

import com.fyrl29074.payment_tracker.domain.repository.RestRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.fyrl29074.payment_tracker.data.repository.RestRepositoryImpl
import com.fyrl29074.payment_tracker.data.repository.StorageRepositoryImpl
import com.fyrl29074.payment_tracker.domain.repository.StorageRepository
import org.koin.dsl.bind

val dataModule = module {
    singleOf(::RestRepositoryImpl) bind RestRepository::class
    singleOf(::StorageRepositoryImpl) bind StorageRepository::class
}