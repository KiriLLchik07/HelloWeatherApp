package com.example.helloweatherapp.NavigationBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.sp
import com.example.helloweatherapp.view.ForecastSection
import com.example.helloweatherapp.view.WeatherSection
import com.example.helloweatherapp.viewModel.STATE

@Composable
fun ForecastScreen () {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Forecast", color = Color.Black, fontSize = 22.sp)
    }
}