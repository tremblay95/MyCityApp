package ca.tremblay95.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    @StringRes val nameResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val addressResource: Int,
    @StringRes val websiteResource: Int,
    @DrawableRes val imageResource: Int? = null
)
