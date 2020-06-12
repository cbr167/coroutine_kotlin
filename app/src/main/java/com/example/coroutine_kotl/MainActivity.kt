package com.example.coroutine_kotl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutine_kotl.ui.CurrentWeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        manager.beginTransaction().add(R.id.weather_frag,CurrentWeatherFragment()).commit()
    }
}
