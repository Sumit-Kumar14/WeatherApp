package com.example.sumitkumar1.weatherapp.cities

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sumitkumar1.weatherapp.R
import com.example.sumitkumar1.weatherapp.adapters.CitiesListAdapter
import com.example.sumitkumar1.weatherapp.datasource.Cities
import com.example.sumitkumar1.weatherapp.detail.DetailActivity
import com.example.sumitkumar1.weatherapp.utility.OnItemClickListener
import com.example.sumitkumar1.weatherapp.utility.addOnItemClickListener

/**
 * @author Sumit Kumar
 */

class CitiesListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_cities, container, false)
        setUpRecyclerView(rootView)
        return rootView
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): CitiesListFragment {
            val fragment = CitiesListFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    private fun setUpRecyclerView(view : View) {
        val rvCities = view.findViewById<RecyclerView>(R.id.rv_cities)
        rvCities.layoutManager = LinearLayoutManager(activity)
        val cities = listOf(Cities("Bangalore", false), Cities("London", true), Cities("Mumbai", false))
        rvCities.adapter = CitiesListAdapter(activity, cities)
        rvCities.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val fetchWeatherIntent = Intent(context, DetailActivity::class.java)
                fetchWeatherIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
                //fetchWeatherIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                fetchWeatherIntent.putExtra("CITY", cities[position].city)
                startActivity(fetchWeatherIntent)
                activity.finish()
            }
        })
    }
}