package com.example.sumitkumar1.weatherapp

import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @author Sumit Kumar
 */
class DetailPresenterTest {

    lateinit var weatherAppService : WeatherAppService

    @Before
    fun setUp() {
        weatherAppService = mock {  }
    }

    @Test
    fun shouldFetchWeatherFromNetwork() {

    }
}