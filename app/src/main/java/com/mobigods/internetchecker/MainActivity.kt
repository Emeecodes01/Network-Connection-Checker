package com.mobigods.internetchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
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
            val (networkStatus,  colorRes) = when(status) {
                Status.AVAILABLE -> Pair("Available", android.R.color.holo_green_light)
                Status.LOSING -> Pair("Losing", android.R.color.holo_red_light)
                Status.LOST -> Pair("Lost", android.R.color.holo_red_dark)
                else -> Pair("Unknown", 0)
            }

            net_status.text = networkStatus
            net_status.setTextColor(ContextCompat.getColor(this, colorRes))

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