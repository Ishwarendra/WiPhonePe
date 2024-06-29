package com.example.wiphonepe.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wiphonepe.R
import com.example.wiphonepe.viewmodel.DialogViewModel
import com.example.wiphonepe.viewmodel.ItemViewModel

@Composable
fun Header(
    modifier: Modifier = Modifier,
) {
    val headerColor = colorResource(id = R.color.light_blue)
    val viewModel: DialogViewModel = viewModel()
    val showDialog = viewModel.showDialog.collectAsState().value

    val itemViewModel: ItemViewModel = viewModel(factory = ItemViewModel.Factory)
    val filters = itemViewModel.filters.collectAsState().value

    Column (
        modifier = modifier
            .background(color = headerColor)
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
    ) {
        if (showDialog) {
            FilterDialog(
                onDismiss = viewModel::dismissDialog,
                filters = filters,
                toggleShippingDay = itemViewModel::toggleShippingDay,
                updatePriceRange = itemViewModel::updatePriceRange,
                resetFilter = itemViewModel::resetFilter
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Explore",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 12.dp)
            )
            Text(
                text = "Filter",
                color = Color(0xFF5CB075),
                fontSize = 18.sp,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        viewModel.showDialog()
                    }
                    .padding(
                        vertical = 4.dp,
                        horizontal = 12.dp
                    )
            )
        }

        SearchBar()
    }
}