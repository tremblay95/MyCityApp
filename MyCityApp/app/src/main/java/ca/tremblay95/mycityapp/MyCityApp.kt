package ca.tremblay95.mycityapp

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ca.tremblay95.mycityapp.ui.CityListView
import ca.tremblay95.mycityapp.ui.CityScreen
import ca.tremblay95.mycityapp.ui.MyCityTopBar
import ca.tremblay95.mycityapp.ui.MyCityViewModel
import ca.tremblay95.mycityapp.ui.PlaceDetailsView
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme


@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = CityScreen.CategoriesList.name,
    ) {
        composable(CityScreen.CategoriesList.name) {
            CityListView(
                topBar = @Composable {
                    val navBarInfo = viewModel.getNavBarInfo(CityScreen.CategoriesList)
                    MyCityTopBar(
                        navBarInfo = navBarInfo,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                    ) },
                categoriesList = viewModel.getCategoriesList(),
                onCategorySelected = {
                    viewModel.updateCurrentCategory(it)
                    navController.navigate(CityScreen.PlacesList.name)
                },
                modifier = modifier
            )
        }
        composable(CityScreen.PlacesList.name) {
            CityListView(
                topBar = @Composable {
                    val navBarInfo = viewModel.getNavBarInfo(CityScreen.PlacesList)
                    MyCityTopBar(
                        navBarInfo = navBarInfo,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                    ) },
                placesList = viewModel.getPlacesList(),
                onPlaceSelected = {
                    viewModel.updateCurrentPlace(it)
                    navController.navigate(CityScreen.PlaceDetails.name)
                },
                modifier = modifier
            )
        }
        composable(CityScreen.PlaceDetails.name) {
            PlaceDetailsView(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                viewModel = viewModel,
                modifier = modifier,
                windowSize = windowSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyCityApp() {
    MyCityAppTheme {
        MyCityApp(windowSize = WindowWidthSizeClass.Compact)
    }
}
