package ca.tremblay95.mycityapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.data.Category
import ca.tremblay95.mycityapp.model.Place


@Composable
fun CityListView(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    onCategorySelected: (Category) -> Unit = {},
    onPlaceSelected: (Place) -> Unit = {},
    categoriesList: List<Category>? = null,
    placesList: List<Place>? = null
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {
        item {
            topBar()
        }
        if (categoriesList != null) {
            items(categoriesList) {
                CityListItem(
                    nameRes = it.title,
                    iconImageVector = it.iconImageVector
                ) { onCategorySelected(it) }
            }
        } else if (placesList != null) {
            items(placesList) {
                CityListItem(nameRes = it.nameResource) { onPlaceSelected(it) }
            }
        }
    }
}

@Composable
private fun CityListItem(
    @StringRes nameRes: Int,
    modifier: Modifier = Modifier,
    iconImageVector: ImageVector? = null,
    onCardClick: () -> Unit = {}
) {
    Card(
        onClick = onCardClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_small))
    ) {
        Row(
            horizontalArrangement = if (iconImageVector != null) { Arrangement.Start } else { Arrangement.Center },
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_large))
        ) {
            if (iconImageVector != null) {
                Icon(
                    imageVector = iconImageVector,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.list_item_icon_size_compact))
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.list_item_space_compact)))
            }
            Text(
                text = stringResource(nameRes),
                maxLines = 1,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
