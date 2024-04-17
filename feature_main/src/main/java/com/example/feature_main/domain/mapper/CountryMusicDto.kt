package com.example.feature_main.domain.mapper

import com.example.feature_main.domain.model.Offer
import com.google.gson.annotations.SerializedName


data class CountryMusicDto(
    @SerializedName("offers")
    val offers: List<OfferDto>
)

fun List<OfferDto>.toListOffer() : List<Offer> {
   return map {
        it.toOffer()
    }
}
