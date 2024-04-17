package com.example.feature_main.domain.mapper

import com.example.feature_main.domain.model.Offer
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

fun OfferDto.toOffer() = Offer(
    id = id,
    price = price.toPrice(),
    title = title,
    town = town
)