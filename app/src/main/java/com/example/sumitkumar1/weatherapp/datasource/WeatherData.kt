package com.example.sumitkumar1.weatherapp.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Sumit Kumar
 */

class WeatherData : Serializable {

    @SerializedName("main")
    var main : MainData? = null

    @SerializedName("wind")
    var wind : WindData? = null

    @SerializedName("name")
    var name : String? = null
}