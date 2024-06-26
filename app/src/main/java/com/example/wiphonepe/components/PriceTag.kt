package com.example.wiphonepe.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.wiphonepe.R

@Composable
fun PriceTag(
    price: Double,
    modifier: Modifier = Modifier,
    boldText: Boolean = false
) {
    val symbol = stringResource(id = R.string.Rs)

    if (boldText) {
        Text(
            text = "$symbol$price",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
    } else {
        Text(
            text = "$symbol$price",
            modifier = modifier,
        )
    }
}