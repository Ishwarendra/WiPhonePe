package com.example.wiphonepe.repository

import com.example.wiphonepe.model.Item
import kotlin.random.Random

class ItemRepositoryImpl : ItemRepository {
    override suspend fun getAllItems(): List<Item> {
        val items = mutableListOf<Item>()
        val n = Random.nextInt(15, 26)
        for (i in 1..n) {
            val shipSameDay = Random.nextInt(1, 4) == 1;
            items.add(
                Item(
                    name = "Item Name $i",
                    sameDayShipping = shipSameDay,
                    price = Random.nextInt(1, 100) * 10f,
                )
            )
        }
        return items
    }
}