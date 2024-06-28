package com.example.wiphonepe.util

fun isSubsequence(text: String, pattern: String): Boolean {
    val n = text.length
    val m = pattern.length

    var i = 0
    var j = 0
    while (i < n && j < m) {
        if (text[i] == pattern[j]) {
            j++
        }
        i++
    }

    return j == m
}