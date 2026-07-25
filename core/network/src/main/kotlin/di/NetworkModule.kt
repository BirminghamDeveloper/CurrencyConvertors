package di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import interceptor.HeaderInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import service.CurrencyService
import util.Constants.CurrencyConvertorBaseUrl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            val level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .addNetworkInterceptor(HeaderInterceptor(mapOf("apikey" to "cur_live_tEwiIlyCFfln46N3T4GRxNbL7BVTV9GFeHetjyKh")))
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyRetrofitService(
        client: OkHttpClient
    ): CurrencyService {
        return Retrofit
            .Builder()
            .baseUrl(CurrencyConvertorBaseUrl)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(CurrencyService::class.java)
    }

}