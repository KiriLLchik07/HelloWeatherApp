package com.example.helloweatherapp.view

import Utils.Companion.buildIcon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.helloweatherapp.Const.Const.Companion.LOADING
import com.example.helloweatherapp.R
import com.example.helloweatherapp.model.data.weather.WeatherResult

@Composable
fun WeatherSection(weatherResponse: WeatherResult) {

    var title = ""
    if(!weatherResponse.name.isNullOrEmpty()) {
        weatherResponse?.name?.let {
            title = it
        }
    }

    else {
        weatherResponse.coord?.let {
            title = "${it.lat}/${it.lon}"
        }
    }

    var icon = ""
    var description = ""
    weatherResponse.weather.let {
        if(it!!.size > 0) {
            description = if (it[0].description == null) LOADING else
                it[0].description!!
            icon = if(it[0].icon == null) LOADING else it[0].icon!!
        }
    }

    var temperature = ""
    weatherResponse.main?.let {
        temperature = "${it.temp} \u2103"
    }
    var wind = ""
    weatherResponse.wind.let {
        wind = if (it == null) LOADING else "${it.speed}"
    }
    var clouds = ""
    weatherResponse.clouds.let {
        clouds = if (it == null) LOADING else "${it.all}"
    }



    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),

    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)

        ) {
            WeatherTitleSection(text = title, fontSize = 30.sp)
            Text(modifier = Modifier.padding(top = 5.dp),text = "Right Now", fontSize = 20.sp, fontFamily = FontFamily.Serif)
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            WeatherImage(icon = icon)
            WeatherTitleSection(text = temperature, fontSize = 45.sp)
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.wind1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                WeatherInfo(text = wind)
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cloud1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                WeatherInfo(text = clouds)
            }


        }
    }
}

@Composable
fun WeatherInfo(text: String) {
    Text(text, fontSize = 24.sp, color = Color.Black, fontFamily = FontFamily.Serif)
}


@Composable
fun WeatherImage(icon: String) {
    AsyncImage(model = buildIcon(icon), contentDescription = icon,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        contentScale = ContentScale.FillBounds)
}


@Composable
fun WeatherTitleSection(text: String, fontSize: TextUnit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text, fontSize = fontSize, color = Color.Black, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)


    }
}