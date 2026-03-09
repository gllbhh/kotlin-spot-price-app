package gllbhh.spot_price.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.porssisahko.net/v2/"

interface ElectricityPriceAPI {

    @GET("latest-prices.json")
    suspend fun getPrices(): PriceResponse

    companion object {
        private var electricityPriceService: ElectricityPriceAPI? = null

        fun getInstance(): ElectricityPriceAPI {
            if (electricityPriceService == null) {
                electricityPriceService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ElectricityPriceAPI::class.java)
            }
            return electricityPriceService!!
        }
    }
}