package com.example.data.model.search_model

import com.example.base.R

data class Util(
    val id : Int,
    val color : Int,
    val image : Int,
    val title : String
)
val utilList = listOf(
    Util(
        id = 0,
        color = R.color.Green,
        image = R.drawable.navigation,
        title = "Сложный\nмаршрут"
    ),
    Util(
        id = 1,
        color = R.color.Blue,
        image = R.drawable.word_kind_2,
        title = "Куда угодно"
    ),
    Util(
        id = 2,
        color = R.color.DarkBlue,
        image = R.drawable.calendare,
        title = "Выходные"
    ),
    Util(
        id = 3,
        color = R.color.Red,
        image = R.drawable.word_kind_2,
        title = "Горячие\nбилеты"
    )
)