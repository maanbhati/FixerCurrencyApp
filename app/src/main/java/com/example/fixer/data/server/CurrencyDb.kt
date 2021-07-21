package com.example.fixer.data.server

import com.example.fixer.ui.commons.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CurrencyDb {
    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIMEOUT, TimeUnit.MINUTES) // connection timeout
            .writeTimeout(TIMEOUT, TimeUnit.MINUTES) // write timeout
            .readTimeout(TIMEOUT, TimeUnit.MINUTES) // read timeout
        builder.addInterceptor(this).build()
    }

    val service: CurrencyDbService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run {
            create(CurrencyDbService::class.java)
        }

    private const val TIMEOUT: Long = 5
}