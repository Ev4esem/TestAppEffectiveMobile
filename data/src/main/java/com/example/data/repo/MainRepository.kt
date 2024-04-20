package com.example.data.repo

import com.example.data.model.main_model.Offer
import com.example.data.model.search_model.Town
import com.example.data.model.search_model.Util
import kotlinx.coroutines.flow.Flow

interface MainRepository {

     suspend fun getOfferList() : Flow<List<Offer>>

     fun getUtils() : List<Util>

     fun getTownList() : List<Town>


}