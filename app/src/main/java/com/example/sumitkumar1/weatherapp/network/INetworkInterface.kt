package com.example.sumitkumar1.weatherapp.network

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import retrofit2.Response


/**
 * @author Sumit Kumar
 */

interface INetworkInterface {

    fun onSuccess(response : Response<WeatherData>)

    fun  onError(error: Throwable)
}