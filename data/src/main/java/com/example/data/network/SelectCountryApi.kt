package com.example.data.network

import com.example.data.mapper.select_country_model.CountryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SelectCountryApi {

    @GET("uc")
    suspend fun getCountryList(
        @Query("export") export : String = "download",
        @Query("id") id : String = "13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta"
    ) : CountryDto

}