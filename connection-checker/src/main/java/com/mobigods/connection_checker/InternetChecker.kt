package com.mobigods.connection_checker

import android.content.Context
import com.mobigods.connection_checker.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object InternetChecker {

    fun init(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(appModule)
        }
    }


}