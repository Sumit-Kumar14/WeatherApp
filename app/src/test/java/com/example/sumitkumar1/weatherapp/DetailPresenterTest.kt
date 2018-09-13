package com.example.sumitkumar1.weatherapp

import com.example.sumitkumar1.weatherapp.datasource.MainData
import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import com.example.sumitkumar1.weatherapp.datasource.WindData
import com.example.sumitkumar1.weatherapp.detail.DetailPresenter
import com.example.sumitkumar1.weatherapp.detail.DetailView
import com.example.sumitkumar1.weatherapp.network.NetworkService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

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
        verify(weatherAppService).fetchWeatherDataFromNetwork(cityNameString)
    }

    @Test
    fun shouldConvertTempFromStringToInt() {
        assertEquals(0, detailPresenter.convertTempFromStringToInt(""))
        assertEquals(0, detailPresenter.convertTempFromStringToInt("invalid"))
        assertEquals(29, detailPresenter.convertTempFromStringToInt("303"))
    }

    @Test
    fun shouldGetWindSpeed() {
        val windData = WindData()
        windData.speed = 123.0f
        val weatherData = WeatherData()
        weatherData.wind = windData

        assertEquals("123.0 m/s", detailPresenter.getWindSpeed(weatherData))

        windData.speed = 12.5f
        weatherData.wind = windData
        assertEquals("12.5 m/s", detailPresenter.getWindSpeed(weatherData))

        assertEquals("0 m/s", detailPresenter.getWindSpeed(null))

        windData.speed = 0f
        weatherData.wind = windData
        assertEquals("0 m/s", detailPresenter.getWindSpeed(weatherData))

        weatherData.wind = null
        assertEquals("0 m/s", detailPresenter.getWindSpeed(weatherData))
    }

    @Test
    fun shouldGetPressure() {
        val mainData = MainData()
        mainData.pressure = 123
        val weatherData = WeatherData()
        weatherData.main = mainData

        assertEquals("123 hPa", detailPresenter.getPressure(weatherData))

        mainData.pressure = 0
        weatherData.main = mainData
        assertEquals("0 hPa", detailPresenter.getPressure(weatherData))

        weatherData.main = null
        assertEquals("0 hPa", detailPresenter.getPressure(weatherData))

        assertEquals("0 hPa", detailPresenter.getPressure(null))
    }

    @Test
    fun shouldGetMainTemp() {
        val mainData = MainData()
        mainData.temp = "283"
        val weatherData = WeatherData()
        weatherData.main = mainData

        assertEquals("9" + 0x00B0.toChar(), detailPresenter.getMainTemp(weatherData))

        mainData.temp = ""
        weatherData.main = mainData
        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMainTemp(weatherData))

        weatherData.main = null
        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMainTemp(weatherData))

        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMainTemp(null))
    }

    @Test
    fun shouldGetMinTemp() {
        val mainData = MainData()
        mainData.tempMin = 283f
        val weatherData = WeatherData()
        weatherData.main = mainData

        assertEquals("9" + 0x00B0.toChar(), detailPresenter.getMinTemp(weatherData))

        mainData.tempMin = 12.20f
        weatherData.main = mainData
        assertEquals("-260" + 0x00B0.toChar(), detailPresenter.getMinTemp(weatherData))

        mainData.tempMin = 0f
        weatherData.main = mainData
        assertEquals("-273" + 0x00B0.toChar(), detailPresenter.getMinTemp(weatherData))

        weatherData.main = null
        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMinTemp(weatherData))

        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMinTemp(null))
    }

    @Test
    fun shouldGetMaxTemp() {
        val mainData = MainData()
        mainData.tempMax = 283f
        val weatherData = WeatherData()
        weatherData.main = mainData

        assertEquals("9" + 0x00B0.toChar(), detailPresenter.getMaxTemp(weatherData))

        mainData.tempMin = 12.40f
        weatherData.main = mainData
        assertEquals("-260" + 0x00B0.toChar(), detailPresenter.getMinTemp(weatherData))

        mainData.tempMax = 0f
        weatherData.main = mainData
        assertEquals("-273" + 0x00B0.toChar(), detailPresenter.getMaxTemp(weatherData))

        weatherData.main = null
        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMaxTemp(weatherData))

        assertEquals("0" + 0x00B0.toChar(), detailPresenter.getMaxTemp(null))
    }

    @Test
    fun shouldGetWinDir() {
        val windData = WindData()
        windData.deg = 12f
        val weatherData = WeatherData()
        weatherData.wind = windData

        assertEquals("NE", detailPresenter.getWinDir(weatherData))

        windData.deg = 142.5f
        weatherData.wind = windData
        assertEquals("SE", detailPresenter.getWinDir(weatherData))

        assertEquals("NE", detailPresenter.getWinDir(null))

        windData.deg = 0f
        weatherData.wind = windData
        assertEquals("NE", detailPresenter.getWinDir(weatherData))

        weatherData.wind = null
        assertEquals("NE", detailPresenter.getWinDir(weatherData))
    }
}