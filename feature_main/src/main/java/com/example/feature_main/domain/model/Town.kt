package com.example.feature_main.domain.model

import com.example.feature_main.R

data class Town(
    val id : Int,
    val title : Int,
    val image : Int,
)
val townList = listOf(
    Town(
        id = 0,
        title = R.string.stambul,
        image = R.drawable.test_image1
    ),
    Town(
        id = 1,
        title = R.string.sochi,
        image = R.drawable.test_image2
    ),
    Town(
        id = 2,
        title = R.string.phiket,
        image = R.drawable.test_image3
    ),
)