package com.example.feature_main.data.repository

import com.example.feature_main.data.network.MainApi
import com.example.feature_main.domain.mapper.toListOffer
import com.example.feature_main.domain.model.Offer
import com.example.feature_main.domain.repo.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
   private val mainApi : MainApi
) : MainRepository {

    override fun getOfferList() : Flow<List<Offer>> = flow {
        val countryMusicDto = mainApi.getOfferList()
        val countryMusic = countryMusicDto.offers.toListOffer()
        emit(countryMusic)
    }


}