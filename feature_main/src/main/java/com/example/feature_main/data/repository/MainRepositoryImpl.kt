package com.example.feature_main.data.repository

import android.util.Log
import com.example.feature_main.data.network.MainApi
import com.example.feature_main.domain.mapper.main_model.toListOffer
import com.example.feature_main.domain.mapper.select_country_model.toCountry
import com.example.feature_main.domain.model.main_model.Offer
import com.example.feature_main.domain.model.main_model.offerList
import com.example.feature_main.domain.model.search_model.Town
import com.example.feature_main.domain.model.search_model.Util
import com.example.feature_main.domain.model.search_model.townList
import com.example.feature_main.domain.model.search_model.utilList
import com.example.feature_main.domain.model.select_country_model.TicketsOffer
import com.example.feature_main.domain.repo.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MainRepositoryImpl(
   private val mainApi : MainApi
) : MainRepository {

    override suspend fun getOfferList() : Flow<List<Offer>> = flow {
//        val countryMusicDto = mainApi.getOfferList()
//        val countryMusic = countryMusicDto.offers.toListOffer()
        emit(offerList)
    }

    override suspend fun getOfferTwoList() : List<Offer> {
        val countryMusicDto = mainApi.getOfferList()
        val countryMusic = countryMusicDto.offers.toListOffer()
        return listOf()
    }

    override fun getUtils() : List<Util> {
        return utilList
    }

    override fun getTownList() : List<Town> {
        return townList
    }

    override fun getCountryList() : Flow<List<TicketsOffer>> = flow {
        val countryDto = mainApi.getCountryList()
        val country = countryDto.tickets_offers.toCountry()
        emit(country)
    }


}