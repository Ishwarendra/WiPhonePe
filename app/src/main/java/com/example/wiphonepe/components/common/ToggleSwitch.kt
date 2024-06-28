package com.example.wiphonepe.components.common

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable

@Composable
fun ToggleSwitch(
    checked: Boolean,
    toggleShipping: () -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = {
            toggleShipping()
        }
    )
}