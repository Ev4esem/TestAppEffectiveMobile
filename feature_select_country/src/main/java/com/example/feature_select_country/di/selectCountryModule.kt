package com.example.feature_select_country.di

import com.example.feature_select_country.data.repository.SelectCountryRepositoryImpl
import com.example.feature_select_country.domain.repo.SelectCountryRepository
import com.example.feature_select_country.view.SelectCountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val selectCountryModule = module {

    factoryOf(::SelectCountryRepositoryImpl) bind SelectCountryRepository::class

    viewModelOf(::SelectCountryViewModel)

}