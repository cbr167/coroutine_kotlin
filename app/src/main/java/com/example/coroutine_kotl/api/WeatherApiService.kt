package com.example.coroutine_kotl.api

import com.example.coroutine_kotl.data.api.WeatherCurrentResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.weatherstack.com/current?access_key=0761ab5bd7bee64daa7cb27ff0b3e4ee&query=New%20York

interface WeatherApiService {

    @GET("weather")
     fun getCurrentWeather(
        @Query("q") location:String
    ):Deferred<WeatherCurrentResponse>
}