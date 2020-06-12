package com.example.coroutine_kotl.api

import android.provider.Telephony.TextBasedSmsColumns.BODY
import com.example.coroutine_kotl.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

class WeatherAPIClient {

    private val BASE_URL = "http://samples.openweathermap.org/data/2.5/"
    private val API_KEY = "439d4b804bc8187953eb36d2a8c26a02"
   // val logging: HttpLoggingInterceptor =  HttpLoggingInterceptor()


    val intercepter = Interceptor{
        chain->
        val url = chain.request().url().newBuilder().addQueryParameter("appid",API_KEY)
            .build()
        val request = chain.request().newBuilder().url(url).build()
        return@Interceptor chain.proceed(request)
    }



    val okHttpClient:OkHttpClient = OkHttpClient.Builder().
            addInterceptor(intercepter)
        // same for .addInterceptor(...)


        .build()
    val retrofit:Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}