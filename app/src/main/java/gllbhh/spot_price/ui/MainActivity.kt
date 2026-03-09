package gllbhh.spot_price.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import gllbhh.spot_price.ui.screens.SpotPriceScreen
import gllbhh.spot_price.ui.theme.SpotPriceTheme
import gllbhh.spot_price.viewmodel.SpotPriceViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotPriceTheme {
                val spotPriceViewModel: SpotPriceViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SpotPriceScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = spotPriceViewModel
                    )
                }
            }
        }
    }
}