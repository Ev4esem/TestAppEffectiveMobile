package com.example.feature_main.domain.repo

import com.example.feature_main.domain.model.Offer
import com.example.feature_main.domain.model.Town
import com.example.feature_main.domain.model.Util
import kotlinx.coroutines.flow.Flow

interface MainRepository {

     suspend fun getOfferList() : Flow<List<Offer>>

     fun getUtils() : List<Util>

     fun getTownList() : List<Town>

}