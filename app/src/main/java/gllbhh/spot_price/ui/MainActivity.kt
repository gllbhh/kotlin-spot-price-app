package gllbhh.spot_price.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import gllbhh.spot_price.R
import gllbhh.spot_price.ui.navigation.SpotPriceDrawerApp
import gllbhh.spot_price.ui.navigation.SpotPriceNavHost
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
                Box(modifier = Modifier.fillMaxSize()){
                    Image(
                        painter = painterResource(R.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    SpotPriceDrawerApp(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}