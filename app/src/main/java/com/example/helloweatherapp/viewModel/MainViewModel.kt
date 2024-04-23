package com.example.helloweatherapp.viewModel

import com.example.helloweatherapp.model.MyLatLon
import com.example.helloweatherapp.model.data.forecast.ForecastResult
import com.example.helloweatherapp.model.data.weather.WeatherResult
import com.example.helloweatherapp.workWithAPI.RetrofitClient



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import java.lang.Exception

enum class STATE {
    LOADING,
    SUCCESS,
    FAILED
}

class MainViewModel: ViewModel() {

    var state by mutableStateOf((STATE.LOADING))
    var weatherResponse: WeatherResult by mutableStateOf(WeatherResult())
    var forecastResponse: ForecastResult by mutableStateOf(ForecastResult())
    var errorMessage: String by mutableStateOf("")

    fun getWeatherByLocation(latlon: MyLatLon) {
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try {
                val apiResponse = apiService.getWeatherData(latlon.lat, latlon.lon)
                weatherResponse = apiResponse
                state = STATE.SUCCESS
            }
            catch (e: Exception) {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }
    }

    fun getForecastByLocation(latlon: MyLatLon) {
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try {
                val apiResponse = apiService.getForecast(latlon.lat, latlon.lon)
                forecastResponse = apiResponse
                state = STATE.SUCCESS
            }
            catch (e: Exception) {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }
    }

}

