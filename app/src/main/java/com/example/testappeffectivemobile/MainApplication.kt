package com.example.testappeffectivemobile

import android.app.Application
import com.example.data.di.apiModule
import com.example.data.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidContext(this@MainApplication)
            modules(
                networkModule, apiModule
            )
        }

    }

}