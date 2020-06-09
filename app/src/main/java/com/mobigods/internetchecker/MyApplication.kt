package com.mobigods.internetchecker

import android.app.Application
import com.mobigods.connection_checker.InternetChecker

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        InternetChecker.init(this)
    }
}