package com.example.wiphonepe.components.bottomnavigationbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.wiphonepe.data.BottomNavigationData

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val bottomNavigationItem = listOf(
        BottomNavigationData.ListView,
        BottomNavigationData.GridView
    )

    val navControllerBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navControllerBackStackEntry?.destination?.route

    NavigationBar {
        bottomNavigationItem.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painterResource(id = it.icon),
                        contentDescription = "Go to ${it.title} screen"
                    )
                },
                label = {
                    Text(text = it.title)
                },
            )
        }
    }
}