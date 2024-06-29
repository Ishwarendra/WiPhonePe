package com.example.wiphonepe.components.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wiphonepe.viewmodel.ItemViewModel

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(100),
    searchBarColor: Color = Color(0XFFE8E8E8)
) {
    val focusManager = LocalFocusManager.current

    val viewModel: ItemViewModel = viewModel(factory = ItemViewModel.Factory)
    val searchText by viewModel.searchText.collectAsState()

    OutlinedTextField(
        value = searchText,
        onValueChange = viewModel::updateSearchText,
        placeholder = { Text(text = "Search") },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Search Bar",
                    tint = Color.Gray,
                    modifier = modifier.clickable {
                        viewModel.updateSearchText("")
                    }
                )
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Bar",
                tint = Color.Gray
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        shape = shape,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = searchBarColor,
            unfocusedContainerColor = searchBarColor,
            unfocusedIndicatorColor = searchBarColor,
            focusedIndicatorColor = Color.Gray
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
            }
        ),
        singleLine = true,
    )
}