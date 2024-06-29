package com.example.wiphonepe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wiphonepe.R
import com.example.wiphonepe.model.Item

@Composable
fun SmallContentBlock(
    item: Item,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .height(50.dp)
            .width(50.dp)
            .background(color = colorResource(id = R.color.light_gray))
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Column {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(text = "MRP: ", color = Color(0XFFA3A3A3))
                    PriceTag(price = item.price)
                }

                if (item.sameDayShipping) {
                    Text(
                        text = stringResource(R.string.same_day_shipping),
                        color = Color(0XFFA3A3A3),
                        modifier = Modifier.padding(end = 4.dp, top = 4.dp, bottom = 4.dp),
                        fontSize = 12.sp
                    )
                }
            }
            HorizontalDivider(color = colorResource(id = R.color.light_gray))
        }
    }
}