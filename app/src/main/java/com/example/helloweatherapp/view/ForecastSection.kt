package com.example.helloweatherapp.view

import Utils.Companion.buildIcon
import Utils.Companion.timesTampToHumanDate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.helloweatherapp.Const.Const.Companion.NA
import com.example.helloweatherapp.Const.Const.Companion.forecastItemColor
import com.example.helloweatherapp.model.data.forecast.ForecastResult


@Composable
fun ForecastSection(forecastResponse: ForecastResult) {
    return Column(
        modifier = Modifier.fillMaxSize(),

        ) {
        forecastResponse.list?.let { listForecast ->
            if (listForecast!!.size > 0) {
                LazyRow(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(listForecast!!) { currentItem ->
                        currentItem.let { item ->
                            var temp = ""
                            var icon = ""
                            var time = ""

                            item.main.let { main ->
                                temp = if (main == null) NA else "${main.temp} ℃"
                            }

                            item.weather.let { weather ->
                                icon = if (weather == null) NA else buildIcon(
                                    weather[0].icon!!,
                                    isBigSize = false
                                )
                            }

                            item.dt.let { dateTime ->
                                time = if (dateTime == null) NA
                                else timesTampToHumanDate(dateTime.toLong(), "EEE HH:mm")
                            }

                            ForecastTitle(temp = temp, image = icon, time = time)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ForecastTitle(temp: String, image: Any, time: String) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),


        colors = CardDefaults.cardColors(
            containerColor = Color(forecastItemColor).copy(alpha = 0.7f),
            contentColor = Color.Black
        ),

        )
    {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = temp.ifEmpty { NA }, color = Color.Black, fontFamily = FontFamily.Serif)
            AsyncImage(
                model = image, contentDescription = image.toString(),
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(text = time.ifEmpty { NA }, color = Color.Black, fontFamily = FontFamily.Serif)
        }
//
    }
}
