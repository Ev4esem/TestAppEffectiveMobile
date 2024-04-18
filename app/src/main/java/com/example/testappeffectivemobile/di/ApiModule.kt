package com.example.testappeffectivemobile.di

import com.example.feature_main.data.network.MainApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://drive.google.com/uc?export=download&id="

val apiModule = module {


}


val networkModule = module {

    singleOf(::provideRetrofit)
    singleOf(::getUnsafeOkHttpClient)

    single { provideApi<MainApi>(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {

    val gson = GsonBuilder()
        .setDateFormat("dd.MM.yyyy HH:mm:ss")
        .create()

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

private fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.MILLISECONDS)
        .connectTimeout(60, TimeUnit.MILLISECONDS)
        .readTimeout(60, TimeUnit.MILLISECONDS)
        .writeTimeout(60, TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)
}

inline fun <reified T> provideApi(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}
