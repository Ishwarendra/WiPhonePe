package com.example.wiphonepe.model

data class Item(
    val name: String,
    val price: Double,
    val sameDayShipping: Boolean = false,
)