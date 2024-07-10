package com.example.hkuandorid13.android.data

import com.example.hkuandorid13.android.HKUScreen

/**
 * Data class that represents [currentPage]
 */
data class OrderUiState(
    val currentPage : HKUScreen,
    val openHamburger : Boolean,
    val openDropDown: Boolean
)



// can delete?