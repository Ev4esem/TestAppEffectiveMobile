package com.example.data.mapper.main_model

import com.google.gson.annotations.SerializedName


data class CountryMusicDto(
    @SerializedName("offers")
    val offers: List<OfferDto>
)

fun List<OfferDto>.toListOffer() : List<com.example.data.model.main_model.Offer> {
   return map {
        it.toOffer()
    }
}
