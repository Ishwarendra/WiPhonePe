package com.example.wiphonepe.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wiphonepe.components.bottomnavigationbar.BottomNavigationBar
import com.example.wiphonepe.components.header.Header
import com.example.wiphonepe.getItems
import com.example.wiphonepe.navigation.Screen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var navController = rememberNavController()
    Scaffold(
        topBar = {
            Header(modifier = Modifier.fillMaxWidth())
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.ListViewScreen.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.ListViewScreen.route) {
                ShopItemListScreen(
                    items = getItems()
                )
            }

            composable(Screen.GridViewScreen.route) {
                ShopItemGridScreen(
                    items = getItems()
                )
            }
        }
    }
}