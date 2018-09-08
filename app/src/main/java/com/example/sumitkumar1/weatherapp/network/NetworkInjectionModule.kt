package com.example.sumitkumar1.weatherapp.network

import com.example.sumitkumar1.weatherapp.utility.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module class NetworkInjectionModule {

    @Provides fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Provides fun provideWebService(): WeatherAppService {
        return WeatherAppService()
    }
}