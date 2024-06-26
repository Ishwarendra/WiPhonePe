package com.example.wiphonepe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wiphonepe.components.header.Header
import com.example.wiphonepe.model.Item
import com.example.wiphonepe.screens.ShopItemGridScreen
import com.example.wiphonepe.ui.theme.WIPhonePeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val items = mutableListOf<Item>()
        for (i in 1..10) {
            val shipSameDay = i < 4;
            items.add(
                Item(
                    name = "Item Name $i",
                    sameDayShipping = shipSameDay,
                    price = Random.nextInt(10, 100) * 10.0
                )
            )
        }
        setContent {
            WIPhonePeTheme {
                Column {
                    Header(modifier = Modifier.fillMaxgitWidth())
                    ShopItemGridScreen(items)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}