package com.example.feature_main.data.network

import com.example.feature_main.domain.mapper.CountryMusicDto
import com.example.feature_main.domain.mapper.OfferDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MainApi {

    @GET("1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav")
    fun getOfferList() : CountryMusicDto



}