package com.example.feature_select_country.domain.mapper

import com.google.gson.annotations.SerializedName

data class PriceCountryDto(
    @SerializedName("value")
    val value : Int
)

fun PriceCountryDto.toPriceCountry() = com.example.feature_select_country.domain.model.Price(
    value = value
)

