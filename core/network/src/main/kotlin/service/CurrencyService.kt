package service

import model.response.currency_convertor.ExchangeResponse
import retrofit2.http.GET

interface CurrencyService {
    @GET("latest")
    suspend fun getExchangeRates(): ExchangeResponse
}