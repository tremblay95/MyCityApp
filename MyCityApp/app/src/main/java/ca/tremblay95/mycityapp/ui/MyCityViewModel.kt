package ca.tremblay95.mycityapp.ui

import androidx.lifecycle.ViewModel
import ca.tremblay95.mycityapp.data.Category
import ca.tremblay95.mycityapp.data.LocalCityDataProvider
import ca.tremblay95.mycityapp.model.CityUIState
import ca.tremblay95.mycityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUIState())
    val uiState: StateFlow<CityUIState> = _uiState

    fun updateCurrentPlace(selectedPlace: Place) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }

    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                currentPlace = LocalCityDataProvider.getPlacesData(selectedCategory).first(),
            )
        }
    }
}