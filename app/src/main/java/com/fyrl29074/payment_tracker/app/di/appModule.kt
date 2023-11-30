package com.fyrl29074.payment_tracker.app.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.fyrl29074.payment_tracker.app.features.login.LoginViewModel
import com.fyrl29074.payment_tracker.app.features.payments.PaymentsViewModel

val appModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::PaymentsViewModel)
}