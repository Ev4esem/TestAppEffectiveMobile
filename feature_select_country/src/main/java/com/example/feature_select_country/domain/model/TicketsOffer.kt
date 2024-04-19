package com.example.feature_select_country.domain.model

data class TicketsOffer(
    val id: Int,
    val price: Price,
    val time_range: List<String>,
    val title: String
)