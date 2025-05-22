package ca.tremblay95.mycityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.model.NavBarInfo
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopBar(
    navBarInfo: NavBarInfo,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_extra_small))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(vertical = dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
        ) {
            if (canNavigateBack) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = navigateUp
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button)
                        )
                    }
                }
            }
            if (navBarInfo.imageRes != null) {
                Image(
                    painter = painterResource(navBarInfo.imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.top_bar_image_size))
                )
            }
            if (navBarInfo.iconRes != null) {
                Icon(
                    painter = painterResource(navBarInfo.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.top_bar_icon_size))
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.top_bar_icon_bottom_spacing)))
            }
            Text(
                text = stringResource(navBarInfo.titleRes),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview(name = "App Bar, No Back", showBackground = true)
@Composable
fun PreviewAppBarNoBack() {
    MyCityAppTheme {
        MyCityTopBar(
            navBarInfo = NavBarInfo(
                titleRes = R.string.mycity_label,
                imageRes = R.drawable.city_of_oshawa_logo
            ),
            canNavigateBack = false,
            navigateUp = { }
        )
    }
}

@Preview(name = "App Bar, Yes Back", showBackground = true)
@Composable
fun PreviewAppBarBack() {
    MyCityAppTheme {
        MyCityTopBar(
            navBarInfo = NavBarInfo(
                titleRes = R.string.category_cafes,
                iconRes = R.drawable.outline_local_cafe_24
            ),
            canNavigateBack = true,
            navigateUp = { }
        )
    }
}
