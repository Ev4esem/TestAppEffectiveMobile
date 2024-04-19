package com.example.feature_main.di

import com.example.feature_main.data.repository.MainRepositoryImpl
import com.example.feature_main.domain.repo.MainRepository
import com.example.feature_main.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module


val mainModule = module {

    factoryOf(::MainRepositoryImpl) bind MainRepository::class

    viewModelOf(::MainViewModel)

}