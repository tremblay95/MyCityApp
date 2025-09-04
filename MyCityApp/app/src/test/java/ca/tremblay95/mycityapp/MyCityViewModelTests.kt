package ca.tremblay95.mycityapp

import ca.tremblay95.mycityapp.data.LocalCityDataProvider
import ca.tremblay95.mycityapp.ui.CityScreen
import ca.tremblay95.mycityapp.ui.MyCityViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertNotEquals
import org.junit.Test

class MyCityViewModelTests {
    private val viewModel = MyCityViewModel()

    @Test
    fun defaultPlaceAndCategoryValid() {
        val currentUiState = viewModel.uiState.value
        val currentCategory = currentUiState.currentCategory
        val currentPlace = currentUiState.currentPlace

        // check that the uiState defaults are valid
        assertTrue(LocalCityDataProvider.getPlacesData(LocalCityDataProvider.defaultCategory)
            .contains(LocalCityDataProvider.defaultPlace))

        // check that the uiState defaults are set properly
        assertEquals(currentCategory, LocalCityDataProvider.defaultCategory)
        assertEquals(currentPlace, LocalCityDataProvider.defaultPlace)
    }

    @Test
    fun updateCurrentPlace_stateUpdatedCorrectly() {
        var currentUiState = viewModel.uiState.value
        val initialPlace = currentUiState.currentPlace
        val expectedPlace = LocalCityDataProvider.getPlacesData(currentUiState.currentCategory).last()

        // double check that we're actually expecting a change
        assertNotEquals(initialPlace, expectedPlace)

        viewModel.updateCurrentPlace(expectedPlace)

        currentUiState = viewModel.uiState.value
        val actualPlace = currentUiState.currentPlace

        // check that the ui state place updated correctly
        assertEquals(expectedPlace, actualPlace)
    }

    @Test
    fun updateCurrentCategory_stateUpdatedCorrectly() {
        var currentUiState = viewModel.uiState.value
        val initialCategory = currentUiState.currentCategory
        val initialPlace = currentUiState.currentPlace

        val expectedCategory = LocalCityDataProvider.getCategoriesData().last()
        val expectedPlace = LocalCityDataProvider.getPlacesData(expectedCategory).first()

        // double check that we are actually expecting a change
        assertNotEquals(initialCategory, expectedCategory)
        assertNotEquals(initialPlace, expectedPlace)

        viewModel.updateCurrentCategory(expectedCategory)

        currentUiState = viewModel.uiState.value
        val actualCategory = currentUiState.currentCategory
        val actualPlace = currentUiState.currentPlace

        // check that the category is the expected category
        assertEquals(expectedCategory, actualCategory)
        // check that the place is the expected place
        assertEquals(expectedPlace, actualPlace)
    }

    @Test
    fun getNavBarInfo_categoriesListScreen_correctLabelAndImageResources() {
        val navBarInfo = viewModel.getNavBarInfo(CityScreen.CategoriesList)
        
        assertEquals(navBarInfo.titleRes, R.string.mycity_label)
        assertEquals(navBarInfo.imageRes, R.drawable.city_of_oshawa_logo)
        assertNull(navBarInfo.iconImageVector)
    }

    @Test
    fun getNavBarInfo_placesListScreen_correctLabelAndIconResources() {
        val uiState = viewModel.uiState.value
        val navBarInfo = viewModel.getNavBarInfo(CityScreen.PlacesList)

        assertEquals(navBarInfo.titleRes, uiState.currentCategory.title)
        assertEquals(navBarInfo.iconImageVector, uiState.currentCategory.iconImageVector)
        assertNull(navBarInfo.imageRes)
    }
}