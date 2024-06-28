package com.example.wiphonepe.model

import com.example.wiphonepe.util.isSubsequence

data class Item(
    val name: String,
    val price: Double,
    val sameDayShipping: Boolean = false,
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        return isSubsequence(
            text = name.lowercase().replace(" ", ""),
            pattern = query.lowercase().replace(" ", "")
        )
    }
}