package com.example.feature_select_country.domain.model

import com.example.feature_select_country.R

data class Option(
    val id : String,
    val image : Int = 0,
    val title : String
)

val optionList = listOf(
    Option(
        id = "add",
        title = "Добавить",
        image = com.example.base.R.drawable.plus
    ),
    Option(
        id = "calendar",
        title = "19 июля",
    ),
    Option(
        id = "person",
        title = "1, эконом",
        image = com.example.base.R.drawable.person
    ),
    Option(
        id = "filter",
        title = "Фильтр",
        image = com.example.base.R.drawable.filter_kind_2
    ),
)

