package com.example.feature_main.domain.mapper.main_model

import com.example.feature_main.domain.model.main_model.Price
import com.google.gson.annotations.SerializedName

data class PriceDto(
    @SerializedName("value")
    val value: Int
)

fun PriceDto.toPrice() = Price(
    value = value
)