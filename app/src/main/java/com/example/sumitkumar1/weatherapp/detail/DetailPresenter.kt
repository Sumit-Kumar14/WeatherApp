package com.example.sumitkumar1.weatherapp.detail

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.network.INetworkInterface
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import retrofit2.Response
import java.util.*

/**
 * @author Sumit Kumar
 */

open class DetailPresenter(detailView: DetailView) : INetworkInterface {

    private val weatherAppService : WeatherAppService
    private val detailViewContract : DetailView = detailView

    fun fetchWeatherDataByCityName(city : String) {
        detailViewContract.showLoader()
        weatherAppService.fetchWeatherDataFromNetwork(city)
    }

    override fun onSuccess(response: Response<WeatherData>) {
        detailViewContract.hideLoader()
        detailViewContract.updateUI(response)
    }

    override fun onError(error: Throwable) {
        detailViewContract.hideLoader()
    }

    private fun convertTempFromStringToInt(temp : String) : Int {
        val temp : Float? = temp.toFloatOrNull()
        return temp?.minus(273.15)!!.toInt()
    }

    fun getDayOfWeek() : String {
        val day : Int = Calendar.getInstance()!!.get(Calendar.DAY_OF_WEEK)
        when (day) {
            Calendar.SUNDAY -> return "Sunday"
            Calendar.MONDAY -> return "Monday"
            Calendar.TUESDAY -> return "Tuesday"
            Calendar.WEDNESDAY -> return "Wednesday"
            Calendar.THURSDAY -> return "Thursday"
            Calendar.FRIDAY -> return "Friday"
            Calendar.SATURDAY -> return "Saturday"
        }
        return ""
    }

    private fun getWindDirection(degree : Int) : String {
        when (degree) {
            in 0..89 -> return "NE"
            in 90..179 -> return "SE"
            in 180..260 -> return "SW"
            in 270..360 -> return "NW"
        }
        return "NE"
    }

    fun getWindSpeed(response: Response<WeatherData>) : String {
        return response.body()?.wind?.speed?.toString() + " m/s"
    }

    fun getPressure(response: Response<WeatherData>) : String {
        return response.body()?.main?.presure?.toString() + " hPa"
    }

    fun getMainTemp(response: Response<WeatherData>) : String {
        val temp = convertTempFromStringToInt(response.body()?.main?.temp!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getMinTemp(response: Response<WeatherData>) : String {
        val temp = convertTempFromStringToInt(response.body()?.main?.tempMin?.toString()!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getMaxTemp(response: Response<WeatherData>) : String {
        val temp = convertTempFromStringToInt(response.body()?.main?.tempMax?.toString()!!).toString()
        return temp + 0x00B0.toChar()
    }

    fun getWinDir(response: Response<WeatherData>) : String {
        val deg = response.body()?.wind?.deg?.toInt()
        return if(deg == null) {
            "NE"
        } else {
            getWindDirection(deg)
        }
    }

    init {
        weatherAppService = WeatherAppService(this)
    }
}