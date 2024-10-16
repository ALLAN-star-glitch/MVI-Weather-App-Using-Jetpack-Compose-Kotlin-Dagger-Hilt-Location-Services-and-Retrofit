package com.example.myweather2.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myweather2.data.remote.api.Api
import com.example.myweather2.domain.repository.WeatherRepository
import com.example.myweather2.domain.util.Resource
import com.example.myweather2.domain.weather.WeatherInfo
import com.example.myweather2.data.mapper.toWeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: Api
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}