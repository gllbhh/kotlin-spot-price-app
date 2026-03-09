package gllbhh.spot_price.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import gllbhh.spot_price.ui.components.SpotPriceItem
import gllbhh.spot_price.viewmodel.SpotPriceViewModel

@Composable
fun SpotPriceScreen(
    modifier: Modifier = Modifier,
    viewModel: SpotPriceViewModel
) {
    val prices = viewModel.prices.value
    val isLoading = viewModel.isLoading.value

    if (isLoading){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Loading prices...",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    } else {
        LazyColumn(
            modifier = modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(prices) { item ->
                SpotPriceItem(priceItem = item)

            }
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