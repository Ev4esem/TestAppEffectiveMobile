package com.example.data.mapper.main_model

import com.google.gson.annotations.SerializedName

data class OfferDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: PriceDto,
    @SerializedName("title")
    val title: String,
    @SerializedName("town")
    val town: String
)

fun OfferDto.toOffer() = com.example.data.model.main_model.Offer(
    id = id,
    price = price.toPrice(),
    title = title,
    town = town
)