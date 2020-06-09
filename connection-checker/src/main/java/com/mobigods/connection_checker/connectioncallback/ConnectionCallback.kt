package com.mobigods.connection_checker.connectioncallback

import android.net.ConnectivityManager
import android.net.Network
import androidx.core.net.ConnectivityManagerCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobigods.connection_checker.result.NetworkResult
import com.mobigods.connection_checker.result.Status

class ConnectionCallback: ConnectivityManager.NetworkCallback(), IConnectionCallback{
    var networtResult: MutableLiveData<NetworkResult> = MutableLiveData()


    override fun onLost(network: Network) {
        networtResult.postValue(NetworkResult(Status.LOST, network))
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        networtResult.postValue(NetworkResult(Status.LOSING, network))
    }

    override fun onAvailable(network: Network) {
        networtResult.postValue(NetworkResult(Status.AVAILABLE, network))
    }

}