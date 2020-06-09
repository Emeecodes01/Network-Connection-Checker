package com.mobigods.internetchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobigods.connection_checker.NetworkConnectorMonitor
import com.mobigods.connection_checker.result.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val networkMonitor: NetworkConnectorMonitor by lazy {
        NetworkConnectorMonitor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkMonitor.monitor(this) { status, _ ->
            val networkStatus = when(status) {
                Status.AVAILABLE -> "Available"
                Status.LOSING -> "Losing"
                Status.LOST -> "Lost"
                else -> "Unknown"
            }
            net_status.text = networkStatus

            Log.i("status", networkStatus)
        }

    }


    override fun onStart() {
        super.onStart()
        networkMonitor.register()
    }

    override fun onStop() {
        super.onStop()
        networkMonitor.unregister()
    }
}