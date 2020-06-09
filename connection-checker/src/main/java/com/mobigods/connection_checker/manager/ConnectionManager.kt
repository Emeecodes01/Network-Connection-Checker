package com.mobigods.connection_checker.manager

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobigods.connection_checker.connectioncallback.ConnectionCallback
import com.mobigods.connection_checker.connectioncallback.IConnectionCallback
import com.mobigods.connection_checker.factory.IConnectionFactory
import com.mobigods.connection_checker.result.NetworkResult

class ConnectionManager(
    private val context: Context,
    private val connectionCallback: IConnectionCallback,
    private val connectionFactory: IConnectionFactory
): IConnectionManager {

    private val connectivityManager by lazy {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    val result: MutableLiveData<NetworkResult>
        get() = (connectionCallback as  ConnectionCallback).networtResult

    override fun registerCallback() {
        val internetRequest = connectionFactory.internetRequest()
        connectivityManager.registerNetworkCallback(internetRequest, connectionCallback as ConnectionCallback)
    }

    override fun unregisterCallback() {
        connectivityManager.unregisterNetworkCallback(connectionCallback as ConnectionCallback)
    }
}