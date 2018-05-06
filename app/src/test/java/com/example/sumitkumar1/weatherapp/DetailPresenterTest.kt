package com.example.sumitkumar1.weatherapp

import com.example.sumitkumar1.weatherapp.detail.DetailPresenter
import com.example.sumitkumar1.weatherapp.detail.DetailView
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

    lateinit var weatherAppService : WeatherAppService
    lateinit var detailPresenter : DetailPresenter
    lateinit var view : DetailView

    @Before
    fun setUp() {
        view = mock {  }
        weatherAppService = mock {  }
        detailPresenter = DetailPresenter(view)
    }

    @Test
    fun shouldFetchWeatherFromNetwork() {
        detailPresenter.fetchWeatherDataByCityName("Bangalore")

        verify(view).hideLoader()
    }
}