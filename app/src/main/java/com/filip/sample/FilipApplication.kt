package com.filip.sample

import android.app.Application
import com.facebook.stetho.Stetho

class FilipApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}