package com.mc.data.repository

import com.mc.model.currency_convertor.ExchangeRates
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
//    fun getExchangeRates(): Flow<ExchangeRates>
    suspend fun getExchangeRates(): ExchangeRates
}