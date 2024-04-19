package com.example.testappeffectivemobile

import android.app.Application
import com.example.feature_main.di.mainModule
import com.example.feature_select_country.di.selectCountryModule
import com.example.testappeffectivemobile.di.appModule
import com.example.testappeffectivemobile.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()



        startKoin {
            androidContext(this@MainApplication)
            modules(
               listOf(
                   appModule,
                   mainModule,
                   selectCountryModule,
                   networkModule
               )
            )
        }

    }

}