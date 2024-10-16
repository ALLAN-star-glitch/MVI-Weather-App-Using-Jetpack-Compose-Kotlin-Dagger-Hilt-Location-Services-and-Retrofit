package com.example.myweather2.domain.repository

import com.example.myweather2.domain.util.Resource
import com.example.myweather2.domain.weather.WeatherInfo


interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}