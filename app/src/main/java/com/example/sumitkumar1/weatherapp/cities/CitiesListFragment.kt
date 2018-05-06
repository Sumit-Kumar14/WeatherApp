package com.example.sumitkumar1.weatherapp.cities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sumitkumar1.weatherapp.R
import com.example.sumitkumar1.weatherapp.adapters.CitiesListAdapter
import com.example.sumitkumar1.weatherapp.datasource.Cities

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
        rvCities.setOnClickListener({
            val pos = rvCities.indexOfChild(view)
            Toast.makeText(context, cities[pos].city, Toast.LENGTH_LONG).show()
        })
    }
}