package com.example.wiphonepe.components.header

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Text(
        text = "SearchBar",
        modifier = Modifier.padding(vertical = 16.dp)
    )
}