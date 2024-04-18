package com.example.feature_main.data.repository

import com.example.feature_main.data.network.MainApi
import com.example.feature_main.domain.mapper.toListOffer
import com.example.feature_main.domain.model.Offer
import com.example.feature_main.domain.model.Town
import com.example.feature_main.domain.model.Util
import com.example.feature_main.domain.model.townList
import com.example.feature_main.domain.model.utilList
import com.example.feature_main.domain.repo.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MainRepositoryImpl(
   private val mainApi : MainApi
) : MainRepository {

    override suspend fun getOfferList() : Flow<List<Offer>> = flow {
        val countryMusicDto = mainApi.getOfferList()
        val countryMusic = countryMusicDto.offers.toListOffer()
        emit(countryMusic)
    }

    override fun getUtils() : List<Util> {
        return utilList
    }

    override fun getTownList() : List<Town> {
        return townList
    }


}