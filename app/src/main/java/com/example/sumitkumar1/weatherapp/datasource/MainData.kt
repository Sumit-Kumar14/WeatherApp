package com.example.sumitkumar1.weatherapp.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Sumit Kumar
 */

class MainData : Serializable {

    @SerializedName("temp")
    var temp: String? = null

    @SerializedName("pressure")
    var presure : Int? = null

    @SerializedName("humidity")
    var humidity : Int? = null

    @SerializedName("temp_min")
    var tempMin : Float? = null

    @SerializedName("temp_max")
    var tempMax : Float? = null
}