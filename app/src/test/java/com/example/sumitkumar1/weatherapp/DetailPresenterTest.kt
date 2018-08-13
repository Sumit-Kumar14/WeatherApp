package com.example.sumitkumar1.weatherapp

import com.example.sumitkumar1.weatherapp.detail.DetailPresenter
import com.example.sumitkumar1.weatherapp.detail.DetailView
import com.example.sumitkumar1.weatherapp.network.NetworkService
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @author Sumit Kumar
 */
class DetailPresenterTest {

    lateinit var weatherAppService : NetworkService
    lateinit var detailPresenter : DetailPresenter
    lateinit var view : DetailView
    private val cityNameString = "Bangalore"

    @Before
    fun setUp() {
        view = mock {  }
        weatherAppService = mock {  }
        detailPresenter = DetailPresenter(view)
    }

    @Test
    fun shouldFetchWeatherFromNetwork() {
        detailPresenter.fetchWeatherDataByCityName(cityNameString)
        verify(view).showLoader()
        //verify(weatherAppService).fetchWeatherDataFromNetwork(cityNameString)
    }

    @Test
    fun shouldConvertTempFromStringToInt() {
        assertEquals(0, detailPresenter.convertTempFromStringToInt(""))
        assertEquals(0, detailPresenter.convertTempFromStringToInt("invalid"))
        assertEquals(29, detailPresenter.convertTempFromStringToInt("303"))
    }

    @Test
    fun shouldGiveDayOfWeek() {

    }
}