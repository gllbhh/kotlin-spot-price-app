package gllbhh.spot_price.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gllbhh.spot_price.ui.components.SpotPriceItem
import gllbhh.spot_price.viewmodel.SpotPriceViewModel

@Composable
fun SpotPriceScreen(modifier: Modifier = Modifier, viewModel: SpotPriceViewModel) {
    val prices = viewModel.prices.value

    Column(modifier = modifier) {
        prices.forEach { price ->
            SpotPriceItem(price = price)
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline,
                thickness = 1.dp
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun SpotPriceScreenPreview() {
    val viewModel = SpotPriceViewModel()
    SpotPriceScreen(modifier = Modifier, viewModel = viewModel)
}