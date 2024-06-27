package com.example.wiphonepe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wiphonepe.model.Item
import com.example.wiphonepe.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemViewModel(
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items.asStateFlow()

    fun fetchItem() {
        viewModelScope.launch {
            _items.value = itemRepository.getAllItems()
        }
    }
}