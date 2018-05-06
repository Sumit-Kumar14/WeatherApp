package com.example.sumitkumar1.weatherapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.sumitkumar1.weatherapp.cities.CitiesListFragment

/**
 * @author Sumit Kumar
 */

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return CitiesListFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        return 2
    }
}