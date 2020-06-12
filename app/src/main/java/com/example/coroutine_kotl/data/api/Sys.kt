package com.example.coroutine_kotl.data.api


import com.google.gson.annotations.SerializedName

data class Sys(
    val country: String,
    val id: Int,
    val message: Double,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)