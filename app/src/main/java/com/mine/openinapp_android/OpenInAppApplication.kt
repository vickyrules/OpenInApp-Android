package com.mine.openinapp_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OpenInAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}