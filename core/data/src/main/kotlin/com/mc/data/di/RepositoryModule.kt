package com.mc.data.di

import com.mc.data.repository.CurrencyRepository
import com.mc.data.repository.CurrencyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCurrencyRepositoryImpl(impl: CurrencyRepositoryImpl): CurrencyRepository
}