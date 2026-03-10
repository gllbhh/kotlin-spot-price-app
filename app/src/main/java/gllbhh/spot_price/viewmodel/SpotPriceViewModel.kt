package gllbhh.spot_price.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gllbhh.spot_price.model.ElectricityPrice
import gllbhh.spot_price.model.ElectricityPriceAPI
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.Instant

class SpotPriceViewModel : ViewModel() {

    var prices = mutableStateOf<List<ElectricityPrice>>(emptyList())
        private set

    var isLoading = mutableStateOf(true)
        private set

    var pricesRetrieved = mutableStateOf(true)
        private set

    val currentPrice = mutableStateOf(0.0)

    fun findCurrentPrice(prices: List<ElectricityPrice>): Double? {

        val now = Instant.now()

        val current = prices.find { price ->
            val start = Instant.parse(price.startDate)
            val end = Instant.parse(price.endDate)

            now.isAfter(start) && now.isBefore(end)
        }

        return current?.price
    }

    init {
        getPrices()
    }

    private fun getPrices() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                //delay(2000)// to test the circular progress bar
                val apiService = ElectricityPriceAPI.getInstance()
                val response = apiService.getPrices()
                prices.value = response.prices
                val hour = LocalTime.now().hour
                currentPrice.value = findCurrentPrice(prices.value)?:0.0
                pricesRetrieved.value = true
            } catch (e: Exception) {
                pricesRetrieved.value = false
                Log.e("SpotPriceViewModel", "Error loading prices", e)
            } finally {
                isLoading.value = false
            }
        }
    }


}