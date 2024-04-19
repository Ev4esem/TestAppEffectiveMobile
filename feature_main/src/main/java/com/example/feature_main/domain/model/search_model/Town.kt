package com.example.feature_main.domain.model.search_model

import com.example.feature_main.R

data class Town(
    val id : Int,
    val title : String,
    val image : Int,
)
val townList = listOf(
    Town(
        id = 0,
        title = "Стамбул",
        image = R.drawable.test_image1
    ),
    Town(
        id = 1,
        title = "Сочи",
        image = R.drawable.test_image2
    ),
    Town(
        id = 2,
        title = "Стамбул",
        image = R.drawable.test_image3
    ),
)