package com.example.helloweatherapp.workWithAPI

import com.example.helloweatherapp.Const.Const.Companion.openWeatherMapApiKey
import com.example.helloweatherapp.model.data.weather.WeatherResult
import com.example.helloweatherapp.model.data.forecast.ForecastResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeatherData (
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey
    ): WeatherResult

    @GET("forecast")
    suspend fun getForecast (
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey
    ): ForecastResult

}