package com.mobigods.connection_checker.factory

import android.net.NetworkRequest

interface IConnectionFactory {
    fun internetRequest(): NetworkRequest
}