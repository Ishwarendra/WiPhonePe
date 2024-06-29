package com.example.wiphonepe.data

data class FilterData(
    val sameDayShipping: Boolean = false,
    val minPrice: Float = 0f,
    val maxPrice: Float = 1e4f
)
