package com.example.feature_main.domain.mapper

import com.example.feature_main.domain.model.Price
import com.google.gson.annotations.SerializedName

data class PriceDto(
    @SerializedName("value")
    val value: Int
)

fun PriceDto.toPrice() = Price(
    value = value
)