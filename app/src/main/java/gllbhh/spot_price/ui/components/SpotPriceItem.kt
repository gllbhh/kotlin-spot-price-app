package gllbhh.spot_price.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SpotPriceItem(price: Double) {
    Text(text = "Price: $price")
}