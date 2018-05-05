package com.example.sumitkumar1.weatherapp.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Sumit Kumar
 */

class WindData : Serializable{

    @SerializedName("speed")
    var speed : Float? = null

    @SerializedName("deg")
    var deg : Float? = null
}
