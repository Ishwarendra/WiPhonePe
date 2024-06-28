package com.example.wiphonepe.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wiphonepe.components.bottomnavigationbar.BottomNavigationBar
import com.example.wiphonepe.components.header.Header
import com.example.wiphonepe.navigation.Screen
import com.example.wiphonepe.viewmodel.ItemViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
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
        val viewModel: ItemViewModel = viewModel(factory = ItemViewModel.Factory)
        val items by viewModel.items.collectAsState()

        val focusManager = LocalFocusManager.current
        val interactionSource = remember { MutableInteractionSource() }

        val modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                focusManager.clearFocus()
            }
            .fillMaxSize()

        NavHost(
            navController = navController,
            startDestination = Screen.ListViewScreen.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screen.ListViewScreen.route) {
                ShopItemListScreen(
                    items = items,
                    modifier = modifier
                )
            }

            composable(Screen.GridViewScreen.route) {
                ShopItemGridScreen(
                    items = items,
                    modifier = modifier,
                )
            }
        }
    }
}