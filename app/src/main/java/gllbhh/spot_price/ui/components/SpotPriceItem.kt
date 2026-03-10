package gllbhh.spot_price.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import gllbhh.spot_price.model.ElectricityPrice
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Composable
fun SpotPriceItem(priceItem: ElectricityPrice) {
    val formatter1 = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm")
    val formatter2 = DateTimeFormatter.ofPattern("HH:mm")

    val start = OffsetDateTime.parse(priceItem.startDate).format(formatter1)
    val end = OffsetDateTime.parse(priceItem.endDate).format(formatter2)
    Card(
        modifier = Modifier.padding(vertical = 1.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f)
        )
    ){
        Text(
            text = "$start-$end: %.2f ct".format(priceItem.price),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}