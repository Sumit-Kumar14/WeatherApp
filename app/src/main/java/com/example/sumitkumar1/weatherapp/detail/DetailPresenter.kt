package com.example.sumitkumar1.weatherapp.detail

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.network.INetworkInterface
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import retrofit2.Response

/**
 * @author Sumit Kumar
 */

class DetailPresenter : INetworkInterface {

    private val weatherAppService : WeatherAppService
    private val detailViewContract : DetailView

    constructor(detailView : DetailView) {
        weatherAppService = WeatherAppService(this)
        detailViewContract = detailView
    }

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
}