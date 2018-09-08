package com.example.sumitkumar1.weatherapp

import android.app.Application
import com.example.sumitkumar1.weatherapp.network.NetworkInjectionModule
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import com.example.sumitkumar1.weatherapp.utility.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApp : Application() {

    var service: WeatherAppService? = null
    var appComponent: WeatherAppComponent? = null

    override fun onCreate() {
        super.onCreate()

        mInstance = this

        appComponent = DaggerWeatherAppComponent
                .builder()
                .networkInjectionModule(NetworkInjectionModule())
                .build()

        service = WeatherAppService()
    }

    companion object {
        var mInstance: WeatherApp? = null
    }
}