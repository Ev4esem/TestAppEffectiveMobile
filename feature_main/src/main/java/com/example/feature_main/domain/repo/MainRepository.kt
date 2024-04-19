package com.example.feature_main.domain.repo

import com.example.feature_main.domain.model.main_model.Offer
import com.example.feature_main.domain.model.search_model.Town
import com.example.feature_main.domain.model.search_model.Util
import kotlinx.coroutines.flow.Flow

interface MainRepository {

     suspend fun getOfferList() : Flow<List<Offer>>

     suspend fun getOfferTwoList() : List<Offer>


     fun getUtils() : List<Util>

     fun getTownList() : List<Town>


}