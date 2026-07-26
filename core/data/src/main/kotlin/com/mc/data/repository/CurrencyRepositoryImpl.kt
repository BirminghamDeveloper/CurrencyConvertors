package com.mc.data.repository

import com.mc.model.currency_convertor.ExchangeRates
import kotlinx.coroutines.flow.Flow
import model.response.currency_convertor.toExternalModel
import service.CurrencyService
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyService: CurrencyService
): CurrencyRepository {
    override suspend fun getExchangeRates(): ExchangeRates {
        return currencyService
            .getExchangeRates()
            .toExternalModel(baseCurrency = "USD")
    }
}