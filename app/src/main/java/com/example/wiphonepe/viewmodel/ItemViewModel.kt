package com.example.wiphonepe.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.wiphonepe.model.Item
import com.example.wiphonepe.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.wiphonepe.data.FilterData
import com.example.wiphonepe.repository.ItemRepositoryImpl
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

class ItemViewModel (
    private val itemRepository: ItemRepository
) : ViewModel() {
    private val _searchText = MutableStateFlow("");
    val searchText
        get() = _searchText.asStateFlow()

    private val _filters = MutableStateFlow(FilterData())
    val filters
        get() = _filters.asStateFlow()

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
            .combine(filters) { items, filters ->
                items.filter {
                    var ok = it.priceIsBetween(filters.minPrice, filters.maxPrice)
                    if (filters.sameDayShipping) {
                        ok = ok and it.sameDayShipping
                    }
                    ok
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

    fun resetFilter() {
        _filters.value = FilterData()
    }

    fun updatePriceRange(minPrice: Double, maxPrice: Double) {
        val sameDayShip = _filters.value.sameDayShipping
        _filters.value = FilterData(
            sameDayShipping = sameDayShip,
            minPrice = minPrice,
            maxPrice = maxPrice
        )
    }

    fun toggleShipping() {
        val minPrice = _filters.value.minPrice
        val maxPrice = _filters.value.maxPrice
        _filters.value = FilterData(
            !_filters.value.sameDayShipping,
            minPrice,
            maxPrice
        )
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