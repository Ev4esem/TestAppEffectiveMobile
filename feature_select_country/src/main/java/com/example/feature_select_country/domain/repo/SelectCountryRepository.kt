package com.example.feature_select_country.domain.repo

import com.example.feature_select_country.domain.model.Option
import com.example.feature_select_country.domain.model.TicketsOffer
import kotlinx.coroutines.flow.Flow

interface SelectCountryRepository {

    fun getCountryList() : Flow<List<TicketsOffer>>

    fun getOptions() : List<Option>

}