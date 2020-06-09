package com.mobigods.connection_checker.factory

import android.net.NetworkCapabilities
import android.net.NetworkRequest

class ConnectionFactory: IConnectionFactory {

    override fun internetRequest(): NetworkRequest {

        return NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addCapability(NetworkCapabilities.NET_CAPABILITY_NOT_RESTRICTED)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
            .build()
    }
}