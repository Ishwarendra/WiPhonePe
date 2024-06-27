package com.example.wiphonepe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wiphonepe.repository.ItemRepositoryImpl
import com.example.wiphonepe.screens.MainScreen
import com.example.wiphonepe.ui.theme.WIPhonePeTheme
import com.example.wiphonepe.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WIPhonePeTheme {
                MainScreen(
                    viewModel = ItemViewModel(
                        itemRepository = ItemRepositoryImpl()
                    )
                )
            }
        }
    }
}