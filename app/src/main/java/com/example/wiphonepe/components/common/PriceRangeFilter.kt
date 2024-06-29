package com.example.wiphonepe.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RangeSlider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wiphonepe.components.PriceTag
import kotlin.math.roundToInt

@Composable
fun PriceRangeFilter(
    minPrice: Float,
    maxPrice: Float,
    updatePriceRange: (Float, Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
    ) {
        RangeSlider(
            value = minPrice..maxPrice,
            steps = 9,
            onValueChange = { range ->
                updatePriceRange(range.start.roundToInt().toFloat(), range.endInclusive.roundToInt().toFloat())
            },
            valueRange = 0f..1000f,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            PriceTag(price = minPrice)
            PriceTag(price = maxPrice)
        }
    }
}