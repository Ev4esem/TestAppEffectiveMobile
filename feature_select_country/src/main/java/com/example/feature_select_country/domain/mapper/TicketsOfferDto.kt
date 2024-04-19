package com.example.feature_select_country.domain.mapper

import com.google.gson.annotations.SerializedName

data class TicketsOfferDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: com.example.feature_select_country.domain.model.Price,
    @SerializedName("time_range")
    val time_range: List<String>,
    @SerializedName("title")
    val title: String
)

fun TicketsOfferDto.toTicketsOffer() = com.example.feature_select_country.domain.model.TicketsOffer(
    id = id,
    price = price,
    time_range = time_range,
    title = title
)

