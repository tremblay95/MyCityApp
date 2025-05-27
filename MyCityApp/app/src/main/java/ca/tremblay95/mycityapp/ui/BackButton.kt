package ca.tremblay95.mycityapp.ui

import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.tremblay95.mycityapp.R
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun BackButton(
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = navigateUp,
        colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_button),
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Preview
@Composable
fun BackButtonPreview()
{
    MyCityAppTheme {
        BackButton()
    }
}