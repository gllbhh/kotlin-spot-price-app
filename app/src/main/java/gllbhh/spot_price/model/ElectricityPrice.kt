package gllbhh.spot_price.model

import java.time.OffsetDateTime

data class ElectricityPrice (
    val price: Double,
    val startDate: String,
    val endDate: String
)

