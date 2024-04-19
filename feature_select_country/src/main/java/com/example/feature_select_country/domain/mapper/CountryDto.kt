package com.example.feature_select_country.domain.mapper

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("tickets_offers")
    val tickets_offers: List<TicketsOfferDto>
)

fun List<TicketsOfferDto>.toCountry() : List<com.example.feature_select_country.domain.model.TicketsOffer>{
    return map {
        it.toTicketsOffer()
    }
}


