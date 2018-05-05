package com.example.sumitkumar1.weatherapp.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sumitkumar1.weatherapp.R

class DetailActivity : AppCompatActivity() {

    var detailPresenter : DetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        detailPresenter = DetailPresenter()
        detailPresenter!!.fetchWeatherDataByCityName("Bangalore")
    }
}