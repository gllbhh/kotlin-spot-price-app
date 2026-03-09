package gllbhh.spot_price.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gllbhh.spot_price.ui.screens.InfoScreen
import gllbhh.spot_price.ui.screens.SpotPriceScreen
import gllbhh.spot_price.viewmodel.SpotPriceViewModel

@Composable
fun SpotPriceNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val spotPriceViewModel: SpotPriceViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Prices,
        modifier = modifier
    ) {
        composable(AppRoutes.Prices) {
            SpotPriceScreen(
                viewModel = spotPriceViewModel,
            )
        }

        composable(AppRoutes.Info) {
            InfoScreen()
        }
    }
}