package ca.tremblay95.mycityapp.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material.icons.outlined.LocalDining
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.Park
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.model.Place

enum class Category(@StringRes val title: Int, val iconImageVector: ImageVector) {
    COFFEE_SHOPS(title = R.string.category_cafes, iconImageVector = Icons.Outlined.LocalCafe),
    BREWERIES(title = R.string.category_breweries, iconImageVector = Icons.Outlined.LocalBar),
    RESTAURANTS(title = R.string.category_restaurants, iconImageVector = Icons.Outlined.LocalDining),
    PUBLIC_LIBRARIES(title = R.string.category_libraries, iconImageVector = Icons.Outlined.LocalLibrary),
    PARKS(title = R.string.category_parks, iconImageVector = Icons.Outlined.Park),
    COMMUNITY_CENTRES(title = R.string.category_community_centres, iconImageVector = Icons.Outlined.FitnessCenter),
    SHOPPING_CENTRES(title = R.string.category_shopping_centres, iconImageVector = Icons.Outlined.ShoppingCart)
}

object LocalCityDataProvider {
    private val cityMap = mapOf(
        Category.COFFEE_SHOPS to listOf(
            Place(
                nameResource = R.string.coffin_creek_name,
                descriptionResource = R.string.coffin_creek_description,
                addressResource = R.string.coffin_creek_address,
                websiteResource = R.string.coffin_creek_webpage,
                imageResource = R.drawable.coffin_creek
            ),
            Place(
                nameResource = R.string.brew_wizards_name,
                descriptionResource = R.string.brew_wizards_description,
                addressResource = R.string.brew_wizards_address,
                websiteResource = R.string.brew_wizards_webpage,
                imageResource = R.drawable.brew_wizards
            ),
            Place(
                nameResource = R.string.cork_bean_name,
                descriptionResource = R.string.cork_bean_description,
                addressResource = R.string.cork_bean_address,
                websiteResource = R.string.cork_bean_webpage,
                imageResource = R.drawable.cork_n_bean
            ),
            Place(
                nameResource = R.string.bond_st_name,
                descriptionResource = R.string.bond_st_description,
                addressResource = R.string.bond_st_address,
                websiteResource = R.string.bond_st_webpage,
                imageResource = R.drawable.bondst_cafe
            ),
            Place(
                nameResource = R.string.kareza_cafe_name,
                descriptionResource = R.string.kareza_cafe_description,
                addressResource = R.string.kareza_cafe_address,
                websiteResource = R.string.kareza_cafe_webpage,
                imageResource = R.drawable.kareza
            )
        ),
        Category.BREWERIES to listOf(
            Place(
                nameResource = R.string.chronicle_name,
                descriptionResource = R.string.chronicle_description,
                addressResource = R.string.chronicle_address,
                websiteResource = R.string.chronicle_webpage,
                imageResource = R.drawable.chronicle_beer
            ),
            Place(
                nameResource = R.string.all_or_nothing_name,
                descriptionResource = R.string.all_or_nothing_description,
                addressResource = R.string.all_or_nothing_address,
                websiteResource = R.string.all_or_nothing_webpage,
                imageResource = R.drawable.all_or_nothing
            ),
            Place(
                nameResource = R.string.little_beasts_name,
                descriptionResource = R.string.little_beasts_description,
                addressResource = R.string.little_beasts_address,
                websiteResource = R.string.little_beasts_webpage,
                imageResource = R.drawable.little_beasts
            ),
            Place(
                nameResource = R.string.sir_montys_name,
                descriptionResource = R.string.sir_montys_description,
                addressResource = R.string.sir_montys_address,
                websiteResource = R.string.sir_montys_webpage,
                imageResource = R.drawable.sir_montys
            ),
            Place(
                nameResource = R.string.brock_st_name,
                descriptionResource = R.string.brock_st_description,
                addressResource = R.string.brock_st_address,
                websiteResource = R.string.brock_st_webpage,
                imageResource = R.drawable.brock_st
            )
        ),
        Category.RESTAURANTS to listOf(
            Place(
                nameResource = R.string.rainbow_name,
                descriptionResource = R.string.rainbow_description,
                addressResource = R.string.rainbow_address,
                websiteResource = R.string.rainbow_webpage,
                imageResource = R.drawable.rainbow
            ),
            Place(
                nameResource = R.string.teddys_name,
                descriptionResource = R.string.teddys_description,
                addressResource = R.string.teddys_address,
                websiteResource = R.string.teddys_webpage,
                imageResource = R.drawable.teddys
            ),
            Place(
                nameResource = R.string.beertown_name,
                descriptionResource = R.string.beertown_description,
                addressResource = R.string.beertown_address,
                websiteResource = R.string.beertown_webpage,
                imageResource = R.drawable.beertown
            ),
            Place(
                nameResource = R.string.sushi_today_name,
                descriptionResource = R.string.sushi_today_description,
                addressResource = R.string.sushi_today_address,
                websiteResource = R.string.sushi_today_webpage,
                imageResource = R.drawable.sushi_today
            ),
            Place(
                nameResource = R.string.courtyard_name,
                descriptionResource = R.string.courtyard_description,
                addressResource = R.string.courtyard_address,
                websiteResource = R.string.courtyard_webpage,
                imageResource = R.drawable.the_courtyard
            )
        ),
        Category.PUBLIC_LIBRARIES to listOf(
            Place(
                nameResource = R.string.jess_hann_library_name,
                descriptionResource = R.string.jess_hann_library_description,
                addressResource = R.string.jess_hann_library_address,
                websiteResource = R.string.jess_hann_library_webpage,
                imageResource = R.drawable.opl_jess_hann
            ),
            Place(
                nameResource = R.string.northview_library_name,
                descriptionResource = R.string.northview_library_description,
                addressResource = R.string.northview_library_address,
                websiteResource = R.string.northview_library_webpage,
                imageResource = R.drawable.opl_northview
            ),
            Place(
                nameResource = R.string.mclaughlin_library_name,
                descriptionResource = R.string.mclaughlin_library_description,
                addressResource = R.string.mclaughlin_library_address,
                websiteResource = R.string.mclaughlin_library_webpage,
                imageResource = R.drawable.opl_mclaughlin
            ),
            Place(
                nameResource = R.string.delpark_library_name,
                descriptionResource = R.string.delpark_library_description,
                addressResource = R.string.delpark_library_address,
                websiteResource = R.string.delpark_library_webpage,
                imageResource = R.drawable.opl_delpark
            )
        ),
        Category.PARKS to listOf(
            Place(
                nameResource = R.string.niagara_park_name,
                descriptionResource = R.string.niagara_park_description,
                addressResource = R.string.niagara_park_address,
                websiteResource = R.string.niagara_park_webpage,
                imageResource = R.drawable.niagara_park
            ),
            Place(
                nameResource = R.string.easton_park_name,
                descriptionResource = R.string.easton_park_description,
                addressResource = R.string.easton_park_address,
                websiteResource = R.string.easton_park_webpage,
                imageResource = R.drawable.easton_park
            ),
            Place(
                nameResource = R.string.lakefront_west_park_name,
                descriptionResource = R.string.lakefront_west_park_description,
                addressResource = R.string.lakefront_west_park_address,
                websiteResource = R.string.lakefront_west_park_webpage,
                imageResource = R.drawable.lakefront_park
            ),
            Place(
                nameResource = R.string.stone_street_park_name,
                descriptionResource = R.string.stone_street_park_description,
                addressResource = R.string.stone_street_park_address,
                websiteResource = R.string.stone_street_park_webpage,
                imageResource = R.drawable.stone_st_park
            )
        ),
        Category.COMMUNITY_CENTRES to listOf(
            Place(
                nameResource = R.string.south_oshawa_cc_name,
                descriptionResource = R.string.south_oshawa_cc_description,
                addressResource = R.string.south_oshawa_cc_address,
                websiteResource = R.string.south_oshawa_cc_webpage,
                imageResource = R.drawable.socc
            ),
            Place(
                nameResource = R.string.civic_rec_complex_name,
                descriptionResource = R.string.civic_rec_complex_description,
                addressResource = R.string.civic_rec_complex_address,
                websiteResource = R.string.civic_rec_complex_webpage,
                imageResource = R.drawable.civic_rec
            ),
            Place(
                nameResource = R.string.tribute_cc_name,
                descriptionResource = R.string.tribute_cc_description,
                addressResource = R.string.tribute_cc_address,
                websiteResource = R.string.tribute_cc_webpage,
                imageResource = R.drawable.tribute
            ),
            Place(
                nameResource = R.string.delpark_centre_name,
                descriptionResource = R.string.delpark_centre_description,
                addressResource = R.string.delpark_centre_address,
                websiteResource = R.string.delpark_centre_webpage,
                imageResource = R.drawable.delpark_centre
            ),
            Place(
                nameResource = R.string.donevan_rec_complex_name,
                descriptionResource = R.string.donevan_rec_complex_description,
                addressResource = R.string.donevan_rec_complex_address,
                websiteResource = R.string.donevan_rec_complex_webpage,
                imageResource = R.drawable.donevan_rec
            )
        ),
        Category.SHOPPING_CENTRES to listOf(
            Place(
                nameResource = R.string.oshawa_centre_name,
                descriptionResource = R.string.oshawa_centre_description,
                addressResource = R.string.oshawa_centre_address,
                websiteResource = R.string.oshawa_centre_webpage,
                imageResource = R.drawable.oshawa_centre
            ),
            Place(
                nameResource = R.string.midtown_mall_name,
                descriptionResource = R.string.midtown_mall_description,
                addressResource = R.string.midtown_mall_address,
                websiteResource = R.string.midtown_mall_webpage,
                imageResource = R.drawable.midtown_mall
            ),
            Place(
                nameResource = R.string.townline_centre_name,
                descriptionResource = R.string.townline_centre_description,
                addressResource = R.string.townline_centre_address,
                websiteResource = R.string.townline_centre_webpage,
                imageResource = R.drawable.townline_centre
            )
        )
    )

    val defaultCategory = Category.COFFEE_SHOPS
    val defaultPlace = cityMap[defaultCategory]!!.first()

    fun getPlacesData(category: Category): List<Place> {
        return cityMap[category] ?: listOf()
    }

    fun getCategoriesData(): List<Category> {
        return cityMap.keys.toList()
    }
}