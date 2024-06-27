package com.example.wiphonepe.data

import com.example.wiphonepe.R
import com.example.wiphonepe.navigation.Screen

sealed class BottomNavigationData(
    val icon: Int,
    val title: String,
    val route: String
) {
    data object ListView : BottomNavigationData(
        icon = R.drawable.format_list_bulleted,
        title = "List View",
        route = Screen.ListViewScreen.route,
    )
    data object GridView : BottomNavigationData(
        icon = R.drawable.grid_view,
        title = "Grid View",
        route = Screen.GridViewScreen.route,
    )
}