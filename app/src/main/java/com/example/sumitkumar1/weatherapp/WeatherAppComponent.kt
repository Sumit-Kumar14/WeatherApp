package com.example.sumitkumar1.weatherapp

import com.example.sumitkumar1.weatherapp.detail.DetailPresenter
import com.example.sumitkumar1.weatherapp.network.NetworkInjectionModule
import com.example.sumitkumar1.weatherapp.network.WeatherAppService
import dagger.Component

@Component(modules = arrayOf(NetworkInjectionModule::class))
interface WeatherAppComponent {

    fun injectNetworkService(appService: WeatherAppService)

    fun injectDetailPresenter(detailPresenter: DetailPresenter)
}