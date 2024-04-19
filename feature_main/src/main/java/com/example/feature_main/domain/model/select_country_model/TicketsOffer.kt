package com.example.feature_main.domain.model.select_country_model

data class TicketsOffer(
    val id: Int,
    val price: Price,
    val time_range: List<String>,
    val title: String
)