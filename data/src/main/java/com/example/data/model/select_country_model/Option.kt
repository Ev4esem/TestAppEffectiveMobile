package com.example.data.model.select_country_model

import com.example.base.R

data class Option(
    val id : String,
    val image : Int = 0,
    val title : String
)

val optionList = listOf(
    Option(
        id = "add",
        title = "Добавить",
        image = R.drawable.plus
    ),
    Option(
        id = "calendar",
        title = "19 июля",
    ),
    Option(
        id = "person",
        title = "1, эконом",
        image = R.drawable.person
    ),
    Option(
        id = "filter",
        title = "Фильтр",
        image = R.drawable.filter_kind_2
    ),
)

