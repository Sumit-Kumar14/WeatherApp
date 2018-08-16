package com.example.sumitkumar1.weatherapp.network

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.utility.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Sumit Kumar
 */


interface NetworkService {
    fun fetchWeatherDataFromNetwork(city : String)
}

open class WeatherAppService(retrofit: Retrofit): NetworkService {

    private var retrofitInterface : WeatherAppServiceInterface = retrofit.create(WeatherAppServiceInterface::class.java)
    var networkInterface : INetworkInterface? = null

    override fun fetchWeatherDataFromNetwork(city : String) {
        val apiCall = retrofitInterface.getWeatherDataFromNetwork(city, Constants.API_KEY)
        apiCall.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                networkInterface?.onSuccess(response.body())
            }
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                networkInterface?.onError(t)
            }
        })
    }
}