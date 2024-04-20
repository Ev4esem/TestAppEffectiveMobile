package com.example.data.di

import com.example.data.repo.MainRepository
import com.example.data.repo.SelectCountryRepository
import com.example.data.repo_impl.MainRepositoryImpl
import com.example.data.repo_impl.SelectCountryRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {

    factoryOf(::MainRepositoryImpl) bind MainRepository::class

    factoryOf(::SelectCountryRepositoryImpl) bind SelectCountryRepository::class

}