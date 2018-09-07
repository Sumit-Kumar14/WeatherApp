package com.example.sumitkumar1.weatherapp.datasource

import com.google.gson.annotations.SerializedName

data class Cities(@SerializedName("cityName") var cityName: String, var isFav: Boolean)

data class MainData(var temp: String? = null,
                    var pressure: Int? = null,
                    var humidity: Int? = null) {

    @SerializedName("temp_min")
    var tempMin: Float? = null

    @SerializedName("temp_max")
    var tempMax: Float? = null
}

data class WindData(
        var speed: Float? = null,
        var deg: Float? = null
)

data class WeatherData(
        var main: MainData? = null,
        var wind: WindData? = null,
        var name: String? = null
)