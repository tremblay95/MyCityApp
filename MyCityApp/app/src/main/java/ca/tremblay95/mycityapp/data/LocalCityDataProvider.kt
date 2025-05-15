package ca.tremblay95.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.model.Place

enum class Category(@StringRes title: Int, @DrawableRes icon: Int) {
    COFFEE_SHOPS(0, R.drawable.outline_local_cafe_24),
    RESTAURANTS(0, R.drawable.outline_local_dining_24),
    PUBLIC_LIBRARIES(0, R.drawable.outline_book_2_24),
    PARKS(0, R.drawable.outline_sports_soccer_24),
    COMMUNITY_CENTRES(0, R.drawable.outline_communities_24),
    SHOPPING_CENTRES(0, R.drawable.outline_shopping_bag_24      )
}

object LocalCityDataProvider {
    private val cityMap = mapOf(
        Category.COFFEE_SHOPS to listOf(
            Place(
                nameResource = 0,
                descriptionResource = 0,
                addressResource = 0,
                imageResource = 0
            )
        )
    )

    val defaultCategory = Category.COFFEE_SHOPS
    val defaultPlace = cityMap[defaultCategory]!!.first()

    fun getPlacesData(category: Category): List<Place> {
        return cityMap[category] ?: listOf()
    }
}