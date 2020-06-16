package com.bushel.bmohan.baseactivitydemo.di

import com.bushel.bmohan.baseactivitydemo.data.ApiEndpoint
import com.bushel.bmohan.baseactivitydemo.data.ApiService
import com.bushel.bmohan.baseactivitydemo.data.ResultHandler
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    internal fun provideJackson(): ObjectMapper {
        return jacksonObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        client: OkHttpClient,
        jackson: ObjectMapper,
        endpoint: ApiEndpoint
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(endpoint.url)
            .addConverterFactory(JacksonConverterFactory.create(jackson))
            .build()
    }

    @Provides
    @Singleton
    internal fun provideResultHandler(
        apiService: ApiService,
        jackson: ObjectMapper
    ): ResultHandler {
        return ResultHandler(apiService, jackson)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()).build()
    }

    @Provides
    @Singleton
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    internal fun provideEndpoint(): ApiEndpoint {
        return ApiEndpoint.DEV
    }
}