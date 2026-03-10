package gllbhh.spot_price.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gllbhh.spot_price.viewmodel.SpotPriceViewModel

@Composable
fun CurrentPriceScreen(
    viewModel: SpotPriceViewModel
) {

    val currentPrice = viewModel.currentPrice.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Current electricity price",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "$currentPrice c/kWh",
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}