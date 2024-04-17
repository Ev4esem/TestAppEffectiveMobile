package com.example.feature_main.domain.model

data class Offer(
    val id: Int,
    val price: Price,
    val title: String,
    val town: String
)