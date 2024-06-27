package com.example.wiphonepe.data

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.List
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.wiphonepe.R
import com.example.wiphonepe.navigation.Screen

sealed class BottomNavigationData(
    val icon: Int,
    val title: String,
    val route: String
) {
    object ListView : BottomNavigationData(
        icon = R.drawable.format_list_bulleted,
        title = "List View",
        route = Screen.ListViewScreen.route,
    )
    object GridView : BottomNavigationData(
        icon = R.drawable.grid_view,
        title = "Grid View",
        route = Screen.GridViewScreen.route,
    )
}