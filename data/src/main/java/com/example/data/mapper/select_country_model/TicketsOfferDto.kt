package com.example.data.mapper.select_country_model

import com.example.data.model.select_country_model.Price
import com.example.data.model.select_country_model.TicketsOffer
import com.google.gson.annotations.SerializedName

data class TicketsOfferDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Price,
    @SerializedName("time_range")
    val time_range: List<String>,
    @SerializedName("title")
    val title: String
)

fun TicketsOfferDto.toTicketsOffer() = TicketsOffer(
    id = id,
    price = price,
    time_range = time_range,
    title = title
)

