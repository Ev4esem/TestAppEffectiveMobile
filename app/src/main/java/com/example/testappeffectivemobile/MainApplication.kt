package com.example.testappeffectivemobile

import android.app.Application
import com.example.feature_main.di.mainModule
import com.example.testappeffectivemobile.di.apiModule
import com.example.testappeffectivemobile.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidContext(this@MainApplication)
            modules(
               listOf(
                   apiModule,
                   mainModule,
                   networkModule
               )
            )
        }

    }

}