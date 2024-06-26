package com.example.wiphonepe.repository

import com.example.wiphonepe.model.Item
import kotlin.random.Random

class ItemRepositoryImpl : ItemRepository {
    override suspend fun getAllItems(): List<Item> {
        val items = mutableListOf<Item>()
        for (i in 1..10) {
            val shipSameDay = i < 2;
            items.add(
                Item(
                    name = "Item Name $i",
                    sameDayShipping = shipSameDay,
                    price = Random.nextDouble(10.0, 1000.0),
                )
            )
        }
        return items
    }
}