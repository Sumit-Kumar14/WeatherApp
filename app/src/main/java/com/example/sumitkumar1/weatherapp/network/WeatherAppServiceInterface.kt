package com.example.sumitkumar1.weatherapp.network

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Sumit Kumar
 */

interface WeatherAppServiceInterface {

    @GET("data/2.5/weather")
    fun getWeatherDataFromNetwork(@Query("q") city : String, @Query("appid") key : String) : Call<WeatherData>

}