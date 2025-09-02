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
import androidx.compose.material.icons.outlined.LocalCafe
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
        modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_small))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(bottom = dimensionResource(R.dimen.padding_large))
                .fillMaxWidth()
        ) {
            if (canNavigateBack) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BackButton(navigateUp = navigateUp)
                }
            }
            if (navBarInfo.imageRes != null) {
                Image(
                    painter = painterResource(navBarInfo.imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.top_bar_image_size))
                )
            }
            if (navBarInfo.iconImageVector != null) {
                Icon(
                    imageVector = navBarInfo.iconImageVector,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.top_bar_icon_size))
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.top_bar_icon_bottom_spacing)))
            }
            Text(
                text = stringResource(navBarInfo.titleRes),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
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
                iconImageVector = Icons.Outlined.LocalCafe
            ),
            canNavigateBack = true,
            navigateUp = { }
        )
    }
}

@Preview(name = "App Bar, Yes Back, No Icon", showBackground = true)
@Composable
fun PreviewAppBarNoIcon() {
    MyCityAppTheme {
        MyCityTopBar(
            navBarInfo = NavBarInfo(
                titleRes = R.string.brew_wizards_name
            ),
            canNavigateBack = true,
            navigateUp = { }
        )
    }
}