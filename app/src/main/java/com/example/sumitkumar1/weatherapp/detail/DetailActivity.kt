package com.example.sumitkumar1.weatherapp.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sumitkumar1.weatherapp.R
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import com.example.sumitkumar1.weatherapp.cities.CitiesActivity
import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Response

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var detailPresenter : DetailPresenter
    private lateinit var progressLoader : ProgressDialog
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        mContext = this

        setUpFabListener()

        initProgressDialog()

        detailPresenter = DetailPresenter(this)
        detailPresenter.fetchWeatherDataByCityName("Bangalore")
    }

    private fun initProgressDialog() {
        progressLoader = ProgressDialog(this)
        progressLoader.setTitle("Loading")
        progressLoader.setMessage("Wait while loading...")
        progressLoader.setCancelable(false)
    }

    override fun showLoader() {
        progressLoader.show()
    }

    override fun hideLoader() {
        progressLoader.dismiss()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val city : String = intent?.getStringExtra("CITY")!!
        detailPresenter.fetchWeatherDataByCityName(city)
    }

    override fun updateUI(response: Response<WeatherData>) {
        tv_location.text = response.body()?.name
        tv_temp.text = detailPresenter.getMainTemp(response)
        tv_day.text = detailPresenter.getDayOfWeek()
        tv_max_temp.text = detailPresenter.getMaxTemp(response)
        tv_min_temp.text = detailPresenter.getMinTemp(response)
        tv_degree.text = detailPresenter.getWinDir(response)
        tv_wind_speed.text = detailPresenter.getWindSpeed(response)
        tv_pressure.text = detailPresenter.getPressure(response)
    }

    private fun setUpFabListener() {
        fab.setOnClickListener {
            val citiesActivityIntent : Intent = Intent(mContext, CitiesActivity::class.java)
            startActivity(citiesActivityIntent)
        }
    }
}