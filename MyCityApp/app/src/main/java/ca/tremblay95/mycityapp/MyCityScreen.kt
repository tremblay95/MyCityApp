package ca.tremblay95.mycityapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme

enum class CityScreen {
    CategoriesList,
    PlacesList,
    PlaceDetails
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    title: String,
    @DrawableRes iconResource: Int? = null,
    @DrawableRes imageResource: Int? = null,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (imageResource != null) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                if (iconResource != null) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(iconResource),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Preview(name = "App Bar, No Back")
@Composable
fun PreviewAppBarNoBack() {
    MyCityAppTheme {
        MyCityAppBar(
            title = stringResource(R.string.mycity_label),
            imageResource = R.drawable.city_of_oshawa_logo,
            canNavigateBack = false,
            navigateUp = { }
        )
    }
}

@Preview(name = "App Bar, Yes Back")
@Composable
fun PreviewAppBarBack() {
    MyCityAppTheme {
        MyCityAppBar(
            title = stringResource(R.string.category_cafes),
            iconResource = R.drawable.outline_local_cafe_24,
            canNavigateBack = true,
            navigateUp = { }
        )
    }
}