package com.example.clean.data.di

import com.example.clean.data.Constants
import com.example.clean.data.remote.api.ItemApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
}

fun createWebService(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

fun createItemApi(retrofit: Retrofit): ItemApi = retrofit.create(ItemApi::class.java)

val networkModules = module {
    single { createOkHttpClient() }

    single { createWebService(get()) }

    single { createItemApi(get()) }
}