package com.example.wiphonepe.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wiphonepe.components.SmallContentBlock
import com.example.wiphonepe.model.Item

@Composable
fun ShopItemListScreen(
    items: List<Item>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 32.dp
        ),
    ) {
       items(items) { item ->
           SmallContentBlock(
               item = item,
               modifier = Modifier.padding(10.dp)
           )
       }
    }
}