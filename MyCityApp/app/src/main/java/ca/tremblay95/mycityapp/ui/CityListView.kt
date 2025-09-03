package ca.tremblay95.mycityapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ca.tremblay95.mycityapp.R


@Composable
fun CityListView(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    listItems: List<@Composable () -> Unit>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier.fillMaxSize()
    ) {
        item { topBar() }
        items(listItems) { cityListItem -> cityListItem() }
    }
}
