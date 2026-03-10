package gllbhh.spot_price.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gllbhh.spot_price.R
import gllbhh.spot_price.model.ElectricityPrice
import gllbhh.spot_price.model.ElectricityPriceAPI
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class SpotPriceViewModel : ViewModel() {

    var prices = mutableStateOf<List<ElectricityPrice>>(emptyList())
        private set

    var isLoading = mutableStateOf(true)
        private set

    var pricesRetrieved = mutableStateOf(true)
        private set


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