package ca.tremblay95.mycityapp.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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


@Composable
fun PlaceDetailsView(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val cityUiState by viewModel.uiState.collectAsState()
    val place = viewModel.getCurrentPlace()

    val context = LocalContext.current
    val url = stringResource(place.websiteResource)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(place.imageResource),
                contentDescription = stringResource(R.string.expand_content_description),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter,
                modifier =
                    if (cityUiState.placeImageExpanded) Modifier else { Modifier.aspectRatio(16f / 9f) }
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(shape = RoundedCornerShape(8.dp))
                        .fillMaxWidth()
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
                        .offset(
                            x = dimensionResource(R.dimen.padding_small),
                            y = dimensionResource(R.dimen.padding_small)
                        )
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        }
        Text(
            text = stringResource(place.nameResource),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        Text(
            text = stringResource(place.addressResource),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge,
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
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(R.string.website_label),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
        Text(
            text = stringResource(place.descriptionResource),
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlaceDetails() {
    MyCityAppTheme {
        PlaceDetailsView(
            canNavigateBack = true,
            navigateUp = {}
        )
    }
}
