package com.example.hku_a_ios_001.android.ui;

import androidx.lifecycle.ViewModel;
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.data.OrderUiState;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.asStateFlow;
import kotlinx.coroutines.flow.update;


class HKUViewModel : ViewModel() {

    /**
     * Cupcake state for this order
     */
    private val _uiState = MutableStateFlow(OrderUiState( currentPage = HKUScreen.Home, openHamburger = false, openDropDown = false))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setPage(page: HKUScreen){
        _uiState.update { currentState ->
            currentState.copy(
                currentPage = page
            )
        }
    }

    fun openHamburger(){
        _uiState.update{ currentState ->
            currentState.copy(
                openHamburger = true,
                openDropDown = false,
                currentPage = HKUScreen.Home
            )
        }
    }


    fun closeHamburger(){
        _uiState.update{ currentState ->
            currentState.copy(
                openHamburger = false,
                currentPage = currentState.currentPage
            )
        }
    }

    fun openDropDown(){
        _uiState.update{ currentState ->
            currentState.copy(
                openDropDown = true,
            )
        }
    }

    fun closeDropDown(){
        _uiState.update{ currentState ->
            currentState.copy(
                openDropDown = false,
            )
        }
    }


}


