package com.example.coroutine_kotl.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.coroutine_kotl.R
import com.example.coroutine_kotl.api.WeatherAPIClient
import com.example.coroutine_kotl.api.WeatherApiService
import com.example.coroutine_kotl.data.api.WeatherCurrentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CurrentWeatherFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_weather, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiService: WeatherApiService = WeatherAPIClient().retrofit.create(
            WeatherApiService::class.java)

        //testing api

        GlobalScope.launch(Dispatchers.IO) {
            val  weather = apiService.getCurrentWeather("Delhi").await()


        }




    }
}
