package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class DessertViewModel: ViewModel() {
    // UI state
    private val _uiState = MutableStateFlow(DessertUiState())
    // Backing property to avoid state updates from other classes
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

  fun onDessertClicked() {
      _uiState.update { dessertUiState ->
          val dessertsSold = dessertUiState.dessertsSold +1
          val nextDessertIndex = determineDessertIndex(dessertsSold)
          dessertUiState.copy(
              currentDessertIndex = nextDessertIndex,
              revenue = dessertUiState.revenue + dessertUiState.currentDessertPrice,
              dessertsSold = dessertsSold,
              currentDessertImageId = dessertList[nextDessertIndex].imageId,
              currentDessertPrice = dessertList[nextDessertIndex].price
          )
      }
  }


    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertToShowIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertToShowIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShowIndex
    }

}