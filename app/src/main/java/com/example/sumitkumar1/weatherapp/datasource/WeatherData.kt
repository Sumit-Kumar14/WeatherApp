package com.example.sumitkumar1.weatherapp.datasource

/**
 * @author Sumit Kumar
 */

data class WeatherData(
        var main: MainData? = null,
        var wind: WindData? = null,
        var name: String? = null
)