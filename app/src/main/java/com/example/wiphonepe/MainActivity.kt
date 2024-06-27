package com.example.wiphonepe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wiphonepe.components.bottomnavigationbar.BottomNavigationBar
import com.example.wiphonepe.components.header.Header
import com.example.wiphonepe.model.Item
import com.example.wiphonepe.screens.MainScreen
import com.example.wiphonepe.screens.ShopItemGridScreen
import com.example.wiphonepe.screens.ShopItemListScreen
import com.example.wiphonepe.ui.theme.WIPhonePeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WIPhonePeTheme {
                MainScreen()
            }
        }
    }
}