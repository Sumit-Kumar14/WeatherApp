package com.example.sumitkumar1.weatherapp.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Sumit Kumar
 */

data class MainData(var temp: String? = null,
                    var pressure: Int? = null,
                    var humidity: Int? = null) {

    @SerializedName("temp_min")
    var tempMin: Float? = null

    @SerializedName("temp_max")
    var tempMax: Float? = null
}