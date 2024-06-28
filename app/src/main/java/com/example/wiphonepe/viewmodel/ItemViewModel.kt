package com.example.wiphonepe.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.wiphonepe.model.Item
import com.example.wiphonepe.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.wiphonepe.MainActivity
import com.example.wiphonepe.repository.ItemRepositoryImpl
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class ItemViewModel (
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _searchText = MutableStateFlow("");
    val searchText
        get() = _searchText.asStateFlow()

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    @OptIn(FlowPreview::class)
    val items
        get() = searchText
            .debounce(800L)
            .combine(_items) { text, items ->
            items.filter {
                it.doesMatchSearchQuery(text)
            }
        }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                _items.value
            )

    init {
        fetchItem()
    }

    private fun fetchItem() {
        viewModelScope.launch {
            _items.value = itemRepository.getAllItems()
        }
    }

    fun updateSearchText(text: String) {
        _searchText.value = text
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val itemRepository = ItemRepositoryImpl()
                ItemViewModel(itemRepository)
            }
        }
    }
}