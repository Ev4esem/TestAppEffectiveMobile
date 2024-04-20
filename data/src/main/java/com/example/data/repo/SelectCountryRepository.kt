package com.example.data.repo

import com.example.data.model.select_country_model.Option
import com.example.data.model.select_country_model.TicketsOffer
import kotlinx.coroutines.flow.Flow

interface SelectCountryRepository {

    fun getCountryList() : Flow<List<com.example.data.model.select_country_model.TicketsOffer>>

    fun getOptions() : List<com.example.data.model.select_country_model.Option>

}