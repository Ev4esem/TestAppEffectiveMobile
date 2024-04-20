package com.example.data.mapper.select_country_model

import com.example.data.model.select_country_model.Price
import com.google.gson.annotations.SerializedName

data class PriceCountryDto(
    @SerializedName("value")
    val value : Int
)

fun PriceCountryDto.toPriceCountry() = Price(
    value = value
)

