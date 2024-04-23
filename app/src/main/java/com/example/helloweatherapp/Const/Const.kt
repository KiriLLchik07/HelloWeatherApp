package com.example.helloweatherapp.Const

import androidx.compose.ui.graphics.Color

class Const {
    companion object {
        val permission = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        const val openWeatherMapApiKey = "0e31caec1f1c4fe2a7e45039f9ff2ccc"
        const val LOADING = "Loading..."
        const val NA = "N/A"
        const val forecastItemColor = 0xFF475A64


    }
}