package com.example.data.mapper.select_country_model

import com.example.data.model.select_country_model.TicketsOffer
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("tickets_offers")
    val tickets_offers: List<TicketsOfferDto>
)

fun List<TicketsOfferDto>.toCountry() : List<TicketsOffer>{
    return map {
        it.toTicketsOffer()
    }
}


