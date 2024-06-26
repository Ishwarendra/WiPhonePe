package com.example.wiphonepe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.wiphonepe.R
import com.example.wiphonepe.model.Item

@Composable
fun MarketBlock(
    item: Item,
    modifier: Modifier = Modifier
) {
    Column {
        Box(
            modifier = Modifier
                .height(110.dp)
                .width(110.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = colorResource(R.color.light_gray))
        ) {}
        Text(text = item.name)
        PriceTag(
            price = item.price,
            boldText = true
        )
    }
}