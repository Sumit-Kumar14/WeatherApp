package com.example.sumitkumar1.weatherapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sumitkumar1.weatherapp.R
import com.example.sumitkumar1.weatherapp.datasource.Cities
import kotlinx.android.synthetic.main.city_item.view.*

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
        holder!!.cityName.text = citiesList[position].city
        if(citiesList[position].isFav) {
            holder.fabIcon.setImageResource(R.drawable.ic_favorite_black_24px)
        }else {
            holder.fabIcon.setImageResource(R.drawable.ic_favorite_border_black_24px)
        }
    }

    class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cityName = itemView.tv_city_name
        var fabIcon = itemView.im_fab
    }
}