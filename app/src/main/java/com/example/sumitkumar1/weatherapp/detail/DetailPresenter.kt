package com.example.sumitkumar1.weatherapp.detail

import android.util.Log
import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.network.INetworkInterface
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import retrofit2.Response

/**
 * @author Sumit Kumar
 */

class DetailPresenter : INetworkInterface {

    private val weatherAppService : WeatherAppService

    constructor() {
        weatherAppService = WeatherAppService(this)
    }

    fun fetchWeatherDataByCityName(city : String) {
        weatherAppService.fetchWeatherDataFromNetwork(city)
    }

    override fun onSuccess(response: Response<WeatherData>) {
        Log.d("DetailPresenter", "Response Came")
    }

    override fun onError(error: Throwable) {
        Log.d("DetailPresenter", "Error Came")
    }
}