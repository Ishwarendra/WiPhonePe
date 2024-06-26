package com.example.wiphonepe.repository

import com.example.wiphonepe.model.Item

interface ItemRepository {
    suspend fun getAllItems(): List<Item>
}