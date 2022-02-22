package com.example.nbanews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppSetup : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}