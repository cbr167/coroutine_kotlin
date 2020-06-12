package com.example.coroutine_kotl.data

import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    val location: Location,
    val request: Request
)