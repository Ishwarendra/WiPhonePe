package com.example.wiphonepe.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiphonepe.R

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    val headerColor = colorResource(id = R.color.light_blue)
    Column (
        modifier = modifier
            .background(color = headerColor)
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Explore",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
            Text(
                text = "Filter",
                color = Color(0xFF5CB075),
                fontSize = 18.sp
            )
        }

        SearchBar()
    }
}