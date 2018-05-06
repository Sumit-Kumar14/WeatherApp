package com.example.sumitkumar1.weatherapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sumitkumar1.weatherapp.R
import com.example.sumitkumar1.weatherapp.datasource.Cities

/**
 * @author Sumit Kumar
 */

class CitiesListAdapter(private val mContext : Context, private val citiesList: List<Cities>) : RecyclerView.Adapter<CitiesListAdapter.CitiesViewHolder>() {

    override fun getItemCount(): Int {
        return citiesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.city_item, parent, false))
    }

    override fun onBindViewHolder(holder: CitiesViewHolder?, position: Int) {

    }

    class CitiesViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}