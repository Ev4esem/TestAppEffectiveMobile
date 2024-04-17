package com.example.feature_main.domain.repo

import com.example.feature_main.domain.mapper.OfferDto
import com.example.feature_main.domain.model.Offer
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getOfferList() : Flow<List<Offer>>

}