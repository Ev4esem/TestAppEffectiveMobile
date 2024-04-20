package com.example.data.repo_impl

import com.example.data.mapper.select_country_model.toCountry
import com.example.data.network.SelectCountryApi
import com.example.data.repo.SelectCountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SelectCountryRepositoryImpl() : SelectCountryRepository, KoinComponent {

    private val selectCountryApi : SelectCountryApi by inject()


    override fun getCountryList() : Flow<List<com.example.data.model.select_country_model.TicketsOffer>> = flow {
        val countryDto = selectCountryApi.getCountryList()
        val country = countryDto.tickets_offers.toCountry()
        emit(country)
    }

    override fun getOptions() : List<com.example.data.model.select_country_model.Option> {
        return com.example.data.model.select_country_model.optionList
    }

}