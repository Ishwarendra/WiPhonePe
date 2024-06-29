package com.example.wiphonepe.model

import com.example.wiphonepe.util.isSubsequence

data class Item(
    val name: String,
    val price: Float,
    val sameDayShipping: Boolean = false,
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        return isSubsequence(
            text = name.lowercase().replace(" ", ""),
            pattern = query.lowercase().replace(" ", "")
        )
    }

    fun priceIsBetween(start: Float, end: Float): Boolean {
        return price in start..end
    }
}