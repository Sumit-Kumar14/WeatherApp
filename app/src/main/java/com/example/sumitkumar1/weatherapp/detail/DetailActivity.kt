package com.example.sumitkumar1.weatherapp.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sumitkumar1.weatherapp.R
import android.app.ProgressDialog
import com.example.sumitkumar1.weatherapp.datasource.WeatherData
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Response


class DetailActivity : AppCompatActivity(), DetailView{

    lateinit var detailPresenter : DetailPresenter
    lateinit var progressLoader : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

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

    override fun updateUI(response: Response<WeatherData>) {
        tv_location.text = response.body()?.name
        val temp : Float? = response.body()?.main?.temp?.toFloatOrNull()
        if(temp != null) {
            tv_temp.text = (temp - 273.15).toString()
        }
    }
}