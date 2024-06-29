package com.example.wiphonepe.components.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.wiphonepe.R
import com.example.wiphonepe.components.common.PriceRangeFilter
import com.example.wiphonepe.components.common.ToggleSwitch
import com.example.wiphonepe.data.FilterData

@Composable
fun FilterDialog(
    onDismiss: () -> Unit,
    toggleShippingDay: () -> Unit,
    updatePriceRange: (Float, Float) -> Unit,
    filters: FilterData,
    resetFilter: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            usePlatformDefaultWidth = false,
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .padding(start = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Filter Dialog",
                        tint = Color.Gray,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                onDismiss()
                            }
                            .padding(12.dp)
                            .height(28.dp)
                            .width(28.dp)
                        )
                }

                Text (
                    text = "Filters",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Text(
                    text = "Search by Name",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                SearchBar(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
                )

                Text(
                    text = stringResource(id = R.string.type),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(1F)
                        .padding(bottom = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.same_day_shipping),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    ToggleSwitch(
                        filters.sameDayShipping,
                        toggleShippingDay
                    )
                }

                Text(
                    text = stringResource(id = R.string.price),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.padding(bottom = 8.dp))

                PriceRangeFilter(
                    minPrice = filters.minPrice,
                    maxPrice = filters.maxPrice,
                    updatePriceRange = updatePriceRange,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.close),
                        fontWeight = FontWeight.Bold,
                    )
                }
                
                Spacer(modifier = Modifier.padding(vertical = 4.dp))

                TextButton(
                    onClick = resetFilter,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.reset),
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}