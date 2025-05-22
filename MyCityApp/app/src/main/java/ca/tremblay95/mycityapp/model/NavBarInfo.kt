package ca.tremblay95.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NavBarInfo(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int? = null,
    @DrawableRes val imageRes: Int? = null
)
