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

open class WeatherAppService {

    private var retrofitClient : Retrofit
    private var retrofitInterface : WeatherAppServiceInterface
    private val constants = Constants()
    private var networkInterface : INetworkInterface

    constructor(n : INetworkInterface) {
        networkInterface = n

        retrofitClient = Retrofit.Builder()
                .baseUrl(constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofitInterface = retrofitClient.create(WeatherAppServiceInterface::class.java)
    }

    fun fetchWeatherDataFromNetwork(city : String) {
        val apiCall = retrofitInterface.getWeatherDataFromNetwork(city, constants.API_KEY)
        apiCall.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>?, response: Response<WeatherData>?) {
                if (response != null) {
                    networkInterface.onSuccess(response)
                }
            }

            override fun onFailure(call: Call<WeatherData>?, t: Throwable?) {
                if (t != null) {
                    networkInterface.onError(t)
                }
            }
        })
    }

}