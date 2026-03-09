package gllbhh.spot_price.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gllbhh.spot_price.model.ElectricityPriceAPI
import kotlinx.coroutines.launch

class SpotPriceViewModel : ViewModel() {

    var prices = mutableStateOf<List<Double>>(emptyList())
        private set

    init {
        getPrices()
    }

    private fun getPrices() {
        viewModelScope.launch {
            try {
                val apiService = ElectricityPriceAPI.getInstance()
                val response = apiService.getPrices()
                prices.value = response.prices.map { it.price }
            } catch (e: Exception) {
                Log.e("SpotPriceViewModel", "Error loading prices", e)
            }
        }
    }
}