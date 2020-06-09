package com.mobigods.connection_checker.di

import com.mobigods.connection_checker.connectioncallback.ConnectionCallback
import com.mobigods.connection_checker.factory.ConnectionFactory
import com.mobigods.connection_checker.manager.ConnectionManager
import com.mobigods.connection_checker.connectioncallback.IConnectionCallback
import com.mobigods.connection_checker.factory.IConnectionFactory
import org.koin.dsl.module

val appModule = module {
    single<IConnectionCallback>{ ConnectionCallback() }

    single<IConnectionFactory>{ ConnectionFactory() }

    single { ConnectionManager(get(), get(), get()) }
}