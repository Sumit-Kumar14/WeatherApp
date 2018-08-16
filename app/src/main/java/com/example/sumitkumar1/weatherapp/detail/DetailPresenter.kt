package com.example.sumitkumar1.weatherapp.detail

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.network.INetworkInterface
import com.example.sumitkumar1.weatherapp.network.NetworkService
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import com.example.sumitkumar1.weatherapp.utility.Utils
import retrofit2.Response
import java.util.*

/**
 * @author Sumit Kumar
 */

class DetailPresenter(private val detailViewContract: DetailView) : INetworkInterface {

    private val weatherAppService: NetworkService = WeatherAppService(this)

    fun fetchWeatherDataByCityName(city: String) {
        detailViewContract.showLoader()
        weatherAppService.fetchWeatherDataFromNetwork(city)
    }

    override fun onSuccess(response: WeatherData?) {
        detailViewContract.hideLoader()
        detailViewContract.updateUI(response)
    }

    override fun onError(error: Throwable) {
        detailViewContract.hideLoader()
    }

    fun convertTempFromStringToInt(temp: String): Int {
        val tempInFloat: Float? = temp.toFloatOrNull()
        return tempInFloat?.minus(273.15)?.toInt() ?: 0
    }


    fun getWindSpeed(response: WeatherData?): String {
        return response?.wind?.speed?.toString() + " m/s"
    }

    fun getPressure(response: WeatherData?): String {
        return response?.main?.pressure?.toString() + " hPa"
    }

    fun getMainTemp(response: WeatherData?): String {
        val temp = convertTempFromStringToInt(response?.main?.temp!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getMinTemp(response: WeatherData?): String {
        val temp = convertTempFromStringToInt(response?.main?.tempMin?.toString()!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getMaxTemp(response: WeatherData?): String {
        val temp = convertTempFromStringToInt(response?.main?.tempMax?.toString()!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getWinDir(response: WeatherData?): String {
        val deg = response?.wind?.deg?.toInt()
        return if (deg == null) {
            "NE"
        } else {
            Utils.getWindDirection(deg)
        }
    }

}