package ca.tremblay95.mycityapp.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme
import androidx.core.net.toUri
import ca.tremblay95.mycityapp.data.LocalCityDataProvider
import ca.tremblay95.mycityapp.model.Place


@Composable
fun PlaceDetailsView(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    when (windowSize) {
        WindowWidthSizeClass.Compact,
        WindowWidthSizeClass.Medium -> {
            PlaceDetailsViewPortrait(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                modifier = modifier,
                viewModel = viewModel
            )
        }
        else -> {
            PlaceDetailsViewLandscape(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                modifier = modifier,
                viewModel = viewModel
            )
        }
    }
}

@Composable
private fun PlaceDetailsViewPortrait(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val cityUiState by viewModel.uiState.collectAsState()
    val place = viewModel.getCurrentPlace()

    Box(modifier = modifier.fillMaxWidth())
    {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(place.imageResource),
                    contentDescription = stringResource(R.string.expand_content_description),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopCenter,
                    modifier =
                        if (cityUiState.placeImageExpanded) Modifier else { Modifier.aspectRatio(16f / 9f) }
                            .padding(
                                start = dimensionResource(R.dimen.padding_small),
                                end = dimensionResource(R.dimen.padding_small),
                                top = dimensionResource(R.dimen.padding_small)
                            )
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(8.dp))
                            .clickable(
                                onClick = { viewModel.togglePlaceImageExpanded() }
                            )
                )
            }
            item {
                DetailsCard(place = place)
            }
        }

        if (canNavigateBack) {
            BackButton(
                navigateUp = navigateUp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = dimensionResource(R.dimen.padding_small), y = dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun PlaceDetailsViewPortrait_old(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val cityUiState by viewModel.uiState.collectAsState()
    val place = viewModel.getCurrentPlace()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    )
    {
        Box(
            modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(place.imageResource),
                contentDescription = stringResource(R.string.expand_content_description),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter,
                modifier =
                    if (cityUiState.placeImageExpanded) Modifier else { Modifier.aspectRatio(16f / 9f) }
                        .padding(
                            start = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_small),
                            top = dimensionResource(R.dimen.padding_small)
                        )
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(8.dp))
                        .clickable(
                            onClick = { viewModel.togglePlaceImageExpanded() }
                        )
            )
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp,
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = dimensionResource(R.dimen.padding_small), y = dimensionResource(R.dimen.padding_small))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        }
        LazyColumn {
            item {
                DetailsCard(
                    place = place,
                    modifier = Modifier.fillParentMaxHeight()
                )
            }
        }
    }
}

@Composable
private fun PlaceDetailsViewLandscape(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val cityUiState by viewModel.uiState.collectAsState()
    val place = viewModel.getCurrentPlace()

    Row(modifier = modifier.fillMaxWidth())
    {
        Box(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(place.imageResource),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .aspectRatio(3f / 4f)
                    .padding(
                        start = dimensionResource(R.dimen.padding_small),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            if (canNavigateBack) {
                BackButton(
                    navigateUp = navigateUp,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = dimensionResource(R.dimen.padding_small), y = dimensionResource(R.dimen.padding_small))
                )
            }
        }
        LazyColumn {
            item {
                DetailsCard(
                    place = place,
                    modifier = Modifier.fillParentMaxHeight()
                )
            }
        }
    }
}

@Composable
private fun DetailsCard(
    place: Place,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val url = stringResource(place.websiteResource)

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(place.nameResource),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
            )
            Text(
                text = stringResource(place.addressResource),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
            )
            Button(
                onClick = {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        url.toUri()
                    )
                    context.startActivity(urlIntent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(R.string.website_label),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Text(
                text = stringResource(place.descriptionResource),
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPlaceDetailsCompact() {
    MyCityAppTheme {
        PlaceDetailsView(
            canNavigateBack = true,
            navigateUp = {},
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}

@Preview(showBackground = true, widthDp = 900, heightDp = 400)
@Composable
fun PreviewPlaceDetailsLandscape() {
    MyCityAppTheme {
        PlaceDetailsView(
            canNavigateBack = true,
            navigateUp = {},
            windowSize = WindowWidthSizeClass.Expanded
        )
    }
}

@Preview(showBackground = true, widthDp = 800)
@Composable
fun PreviewPlaceDetailsMedium() {
    MyCityAppTheme {
        PlaceDetailsView(
            canNavigateBack = true,
            navigateUp = {},
            windowSize = WindowWidthSizeClass.Medium
        )
    }
}

@Preview(showBackground = true, widthDp = 1200)
@Composable
fun PreviewPlaceDetailsExpanded() {
    MyCityAppTheme {
        PlaceDetailsView(
            canNavigateBack = true,
            navigateUp = {},
            windowSize = WindowWidthSizeClass.Expanded
        )
    }
}
