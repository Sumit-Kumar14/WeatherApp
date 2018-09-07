package com.example.sumitkumar1.weatherapp.network

import com.example.sumitkumar1.weatherapp.datasource.WeatherData

/**
 * @author Sumit Kumar
 */

interface INetworkInterface {

    fun onSuccess(response : WeatherData?)

    fun  onError(error: Throwable)
}