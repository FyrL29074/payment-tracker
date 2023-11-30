package com.fyrl29074.payment_tracker.app.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.fyrl29074.payment_tracker.domain.usecase.GetPaymentsUseCase
import com.fyrl29074.payment_tracker.domain.usecase.LoginUseCase
import com.fyrl29074.payment_tracker.domain.usecase.LogoutUseCase

val domainModule = module {
    factoryOf(::GetPaymentsUseCase)
    factoryOf(::LoginUseCase)
    factoryOf(::LogoutUseCase)
}