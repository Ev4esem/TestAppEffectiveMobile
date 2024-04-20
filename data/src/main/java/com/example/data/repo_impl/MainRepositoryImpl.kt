package com.example.data.repo_impl

import com.example.data.model.main_model.offerList
import com.example.data.network.MainApi
import com.example.data.repo.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainRepositoryImpl() : MainRepository, KoinComponent {

    private val mainApi: MainApi by inject()

    override suspend fun getOfferList() : Flow<List<com.example.data.model.main_model.Offer>> = flow {
//        val countryMusicDto = mainApi.getOfferList()
//        val countryMusic = countryMusicDto.offers.toListOffer()
        emit(offerList)
    }

    override fun getUtils() : List<com.example.data.model.search_model.Util> {
        return com.example.data.model.search_model.utilList
    }

    override fun getTownList() : List<com.example.data.model.search_model.Town> {
        return com.example.data.model.search_model.townList
    }




}