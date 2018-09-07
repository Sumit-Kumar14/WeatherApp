package com.example.sumitkumar1.weatherapp

import android.app.Application
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import com.example.sumitkumar1.weatherapp.utility.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApp : Application() {

    var service: WeatherAppService? = null

    override fun onCreate() {
        super.onCreate()

        mInstance = this

        val retrofitClient = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = WeatherAppService(retrofitClient)
    }

    companion object {
        var mInstance: WeatherApp? = null
    }
}