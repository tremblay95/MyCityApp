package ca.tremblay95.mycityapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.data.Category
import ca.tremblay95.mycityapp.data.LocalCityDataProvider
import ca.tremblay95.mycityapp.model.CityUIState
import ca.tremblay95.mycityapp.model.NavBarInfo
import ca.tremblay95.mycityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

enum class CityScreen {
    CategoriesList,
    PlacesList,
    PlaceDetails
}

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUIState())
    val uiState: StateFlow<CityUIState> = _uiState

    fun updateCurrentPlace(selectedPlace: Place) {
        _uiState.update {
            it.copy(
                currentPlace = selectedPlace
            )
        }
    }

    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                currentPlace = LocalCityDataProvider.getPlacesData(selectedCategory).first()
            )
        }
    }

    fun getCategoriesList() : List<Category> {
        return LocalCityDataProvider.getCategoriesData()
    }

    fun getPlacesList() : List<Place> {
        return LocalCityDataProvider.getPlacesData(_uiState.value.currentCategory)
    }

    fun getCurrentPlace()  : Place {
        return _uiState.value.currentPlace
    }

    fun getNavBarInfo(currentScreen: CityScreen) : NavBarInfo {
        @StringRes var titleRes = 0
        var iconImageVector: ImageVector? = null
        @DrawableRes var imageRes: Int? = null

        when(currentScreen) {
            CityScreen.PlacesList -> {
                val category =  _uiState.value.currentCategory
                titleRes = category.title
                iconImageVector = category.iconImageVector
            }
            CityScreen.CategoriesList -> {
                titleRes = R.string.mycity_label
                imageRes = R.drawable.city_of_oshawa_logo
            }
            else -> {
                titleRes = R.string.mycity_label
            }
        }

        return NavBarInfo(titleRes, iconImageVector, imageRes)
    }
}
