package com.example.wiphonepe

import com.example.wiphonepe.model.Item
import kotlin.random.Random

fun getItems() : List<Item> {
    val items = mutableListOf<Item>()
    for (i in 1..10) {
        val shipSameDay = i < 4;
        items.add(
            Item(
                name = "Item Name $i",
                sameDayShipping = shipSameDay,
                price = Random.nextInt(10, 100) * 10.0
            )
        )
    }
    return items;
}