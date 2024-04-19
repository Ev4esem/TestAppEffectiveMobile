package com.example.feature_main.domain.model.main_model

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)

val offerList = listOf(
    Offer(
        id = 0,
        price = Price(22000),
        title = "Die Antwoord",
        town = "Будапешт"
    ),
    Offer(
        id = 1,
        price = Price(2390),
        title = "Socrat& Lera",
        town = "Санкт-Петербург"
    ),
    Offer(
        id = 2,
        price = Price(22000),
        title = "Die Antwoord",
        town = "Будапешт"
    ),
    Offer(
        id = 3,
        price = Price(22000),
        title = "Die Antwoord",
        town = "Будапешт"
    ),
)
