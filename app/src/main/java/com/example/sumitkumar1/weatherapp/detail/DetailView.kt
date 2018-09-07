package com.example.sumitkumar1.weatherapp.detail

import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import retrofit2.Response

/**
 * @author Sumit Kumar
 */

interface DetailView {

    fun showLoader()

    fun hideLoader()

    fun updateUI(response: WeatherData?)
}