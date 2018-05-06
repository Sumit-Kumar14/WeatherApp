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
import java.util.*

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

    override fun updateUI(response: Response<WeatherData>) {
        tv_location.text = response.body()?.name
        tv_temp.text = convertTempFromStringToInt(response.body()!!.main!!.temp!!).toString() + 0x00B0.toChar()
        tv_day.text = getDayOfWeek()
        tv_max_temp.text = convertTempFromStringToInt(response.body()!!.main!!.tempMax!!.toString()).toString() + 0x00B0.toChar()
        tv_min_temp.text = convertTempFromStringToInt(response.body()!!.main!!.tempMin!!.toString()).toString() + 0x00B0.toChar()
        tv_degree.text = getWindDirection(response.body()!!.wind!!.deg!!.toInt())
        tv_wind_speed.text = response.body()!!.wind!!.speed!!.toString() + " m/s"
        tv_pressure.text = response.body()!!.main!!.presure!!.toString() + " hPa"
    }

    private fun convertTempFromStringToInt(temp : String) : Int {
        val temp : Float? = temp.toFloatOrNull()
        return temp?.minus(273.15)!!.toInt()
    }

    private fun getDayOfWeek() : String {
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

    private fun setUpFabListener() {
        fab.setOnClickListener {
            val citiesActivityIntent : Intent = Intent(mContext, CitiesActivity::class.java)
            startActivity(citiesActivityIntent)
        }
    }
}