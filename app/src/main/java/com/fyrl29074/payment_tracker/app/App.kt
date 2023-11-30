package com.fyrl29074.payment_tracker.app

import android.app.Application
import com.fyrl29074.payment_tracker.app.di.appModule
import com.fyrl29074.payment_tracker.app.di.dataModule
import com.fyrl29074.payment_tracker.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            dataModule,
            domainModule,
            appModule,
        )
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}