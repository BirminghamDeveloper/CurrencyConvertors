package service


import model.response.currency_convertor.ExchangeRatesResponse
import retrofit2.http.GET

interface CurrencyService {
    @GET("latest")
    suspend fun getExchangeRates(): ExchangeRatesResponse
}