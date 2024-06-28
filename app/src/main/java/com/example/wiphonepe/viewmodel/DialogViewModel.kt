package com.example.wiphonepe.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DialogViewModel : ViewModel() {
    private val _showDialog = MutableStateFlow(false)
    val showDialog
        get() = _showDialog.asStateFlow()

    fun showDialog() {
        _showDialog.value = true
    }

    fun dismissDialog() {
        _showDialog.value = false
    }
}