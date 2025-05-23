package ca.tremblay95.mycityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarInfo(
    @StringRes val titleRes: Int,
    val iconImageVector: ImageVector? = null,
    @DrawableRes val imageRes: Int? = null
)
