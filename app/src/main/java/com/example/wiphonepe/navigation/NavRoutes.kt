package com.example.wiphonepe.navigation

sealed class Screen(val route: String) {
    data object ListViewScreen : Screen("list_view_screen")
    data object GridViewScreen : Screen("grid_view_screen")
}