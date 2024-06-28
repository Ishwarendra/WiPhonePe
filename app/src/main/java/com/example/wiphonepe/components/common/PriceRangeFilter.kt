package com.example.wiphonepe.components.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PriceRangeFilter() {
    var min by remember {
        mutableStateOf<Int?>(0)
    }

    var max by remember {
        mutableStateOf<Int?>(1000)
    }

    Row {
        OutlinedTextField(
            value = min.toString(),
            onValueChange = {
                min = it.toIntOrNull()
                if (min == null) {
                    min = 0
                }
            },
            placeholder = { Text(text = "Min") },
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
        )
        OutlinedTextField(
            value = max.toString(),
            onValueChange = {
                max = it.toIntOrNull()
                if (max == null) {
                    max = 0;
                }
            },
            placeholder = { Text(text = "Max") },
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
        )
    }
}