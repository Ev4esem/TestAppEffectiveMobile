package com.example.data.mapper.main_model

import com.google.gson.annotations.SerializedName

data class PriceDto(
    @SerializedName("value")
    val value: Int
)

fun PriceDto.toPrice() = com.example.data.model.main_model.Price(
    value = value
)