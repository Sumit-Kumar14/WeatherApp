package com.example.sumitkumar1.weatherapp.cities

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.example.sumitkumar1.weatherapp.R
import com.example.sumitkumar1.weatherapp.adapters.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_cities.*

class CitiesActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = mSectionsPagerAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_cities, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUpTabLayout(view: View) {

    }
}