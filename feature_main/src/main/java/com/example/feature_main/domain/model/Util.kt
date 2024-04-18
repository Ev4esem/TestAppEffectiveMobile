package com.example.feature_main.domain.model

import com.example.feature_main.R

data class Util(
    val id : Int,
    val color : Int,
    val image : Int,
    val title : Int
)
val utilList = listOf(
    Util(
        id = 0,
        color = com.example.base.R.color.Green,
        image = com.example.base.R.drawable.navigation,
        title = R.string.hard_destination
    ),
    Util(
        id = 1,
        color = com.example.base.R.color.Blue,
        image = R.drawable.word_kind_2,
        title = R.string.anywhere
    ),
    Util(
        id = 2,
        color = com.example.base.R.color.DarkBlue,
        image = com.example.base.R.drawable.calendare,
        title = R.string.weekend
    ),
    Util(
        id = 3,
        color = com.example.base.R.color.Red,
        image = R.drawable.word_kind_2,
        title = R.string.anywhere
    )
)