package ca.tremblay95.mycityapp.model

import ca.tremblay95.mycityapp.data.Category
import ca.tremblay95.mycityapp.data.LocalCityDataProvider

data class CityUIState(
    val currentCategory: Category = LocalCityDataProvider.defaultCategory,
    val currentPlace: Place = LocalCityDataProvider.defaultPlace,
    val placeImageExpanded: Boolean = false
)
