package com.example.feature_select_country.data.repository

import com.example.feature_select_country.data.network.SelectCountryApi
import com.example.feature_select_country.domain.mapper.toCountry
import com.example.feature_select_country.domain.model.Option
import com.example.feature_select_country.domain.model.TicketsOffer
import com.example.feature_select_country.domain.model.optionList
import com.example.feature_select_country.domain.repo.SelectCountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SelectCountryRepositoryImpl(
    private val selectCountryApi : SelectCountryApi
) : SelectCountryRepository {

    override fun getCountryList() : Flow<List<TicketsOffer>> = flow {
        val countryDto = selectCountryApi.getCountryList()
        val country = countryDto.tickets_offers.toCountry()
        emit(country)
    }

    override fun getOptions() : List<Option> {
        return optionList
    }

}