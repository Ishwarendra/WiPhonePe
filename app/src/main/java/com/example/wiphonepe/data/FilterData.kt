package com.example.wiphonepe.data

data class FilterData(
    val sameDayShipping: Boolean = false,
    val minPrice: Double = 0.0,
    val maxPrice: Double = 1e4
)
