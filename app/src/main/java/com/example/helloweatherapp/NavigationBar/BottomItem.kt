package com.example.helloweatherapp.NavigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem (
    val title: String,
    val icon: ImageVector,
    val route: String
)

val listOfBottomNavigationItem = listOf(
    BottomNavigationItem(
        title = "Locations",
        icon = Icons.Filled.LocationOn,
        route = Screens.Locations.name
    ),
    BottomNavigationItem(
        title = "Forecast",
        icon = Icons.Filled.DateRange,
        route = Screens.Forecast.name
    ),
    BottomNavigationItem(
        title = "Settings",
        icon = Icons.Filled.Settings,
        route = Screens.Settings.name
    )
)