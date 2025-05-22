package ca.tremblay95.mycityapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import ca.tremblay95.mycityapp.ui.theme.MyCityAppTheme


@Composable
fun MyCityApp(
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CityScreen.valueOf(
        backStackEntry?.destination?.route ?: CityScreen.CategoriesList.name
    )

    NavHost(
        navController = navController,
        startDestination = CityScreen.CategoriesList.name
    ) {
        composable(CityScreen.CategoriesList.name) {
            CityListView(
                topBar = @Composable {
                    val navBarInfo = viewModel.getNavBarInfo(currentScreen)
                    MyCityTopBar(
                        navBarInfo = navBarInfo,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                    ) },
                categoriesList = viewModel.getCategoriesList(),
                onCategorySelected = {
                    viewModel.updateCurrentCategory(it)
                    navController.navigate(CityScreen.PlacesList.name)
                }
            )
        }
        composable(CityScreen.PlacesList.name) {
            CityListView(
                topBar = @Composable {
                    val navBarInfo = viewModel.getNavBarInfo(currentScreen)
                    MyCityTopBar(
                        navBarInfo = navBarInfo,
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                    ) },
                placesList = viewModel.getPlacesList(),
                onPlaceSelected = {
                    viewModel.updateCurrentPlace(it)
                    navController.navigate(CityScreen.PlaceDetails.name)
                }
            )
        }
        composable(CityScreen.PlaceDetails.name) {
            val navBarInfo = viewModel.getNavBarInfo(currentScreen)
            MyCityTopBar(
                navBarInfo = navBarInfo,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
            // todo: place details composable
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyCityApp() {
    MyCityAppTheme {
        MyCityApp()
    }
}
