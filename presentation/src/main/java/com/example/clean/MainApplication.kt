package com.example.clean

import android.app.Application
import com.example.clean.di.builder.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}