package com.mobigods.connection_checker

import android.content.Context
import android.net.Network
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mobigods.connection_checker.manager.ConnectionManager
import com.mobigods.connection_checker.result.Status
import org.koin.core.KoinComponent
import org.koin.core.inject

class NetworkConnectorMonitor: KoinComponent {
    val connectionManager: ConnectionManager by inject()

    fun monitor(lifecycleOwner: LifecycleOwner, callback: (Status, Network) -> Unit) {
        connectionManager.result.observe(lifecycleOwner, Observer {
            callback.invoke(it.status, it.networkInfo)
        })
    }

    fun register() = connectionManager.registerCallback()
    fun unregister() = connectionManager.unregisterCallback()

}