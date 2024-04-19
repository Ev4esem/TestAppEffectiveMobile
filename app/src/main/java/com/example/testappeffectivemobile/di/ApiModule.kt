package com.example.testappeffectivemobile.di

import com.example.feature_main.data.network.MainApi
import com.example.feature_select_country.data.network.SelectCountryApi
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://drive.google.com/"

val appModule = module {


}


val networkModule = module {


    single<OkHttpClient> { provideOkHttp() }
    singleOf(::provideRetrofit)
    single { provideApi<SelectCountryApi>(get()) }
    single { provideApi<MainApi>(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.MILLISECONDS)
        .writeTimeout(60, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)
        .build()
}


inline fun <reified T> provideApi(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}
