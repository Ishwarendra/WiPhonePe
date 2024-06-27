package com.example.wiphonepe.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wiphonepe.components.bottomnavigationbar.BottomNavigationBar
import com.example.wiphonepe.components.header.Header
import com.example.wiphonepe.navigation.Screen
import com.example.wiphonepe.viewmodel.ItemViewModel

@Composable
fun MainScreen(
    viewModel: ItemViewModel,
    navController: NavHostController = rememberNavController()
) {
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
        viewModel.fetchItem()
        val items by viewModel.items.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Screen.ListViewScreen.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screen.ListViewScreen.route) {
                ShopItemListScreen(
                    items = items
                )
            }

            composable(Screen.GridViewScreen.route) {
                ShopItemGridScreen(
                    items = items
                )
            }
        }
    }
}