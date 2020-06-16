package com.bushel.bmohan.baseactivitydemo.data

import com.bushel.bmohan.baseactivitydemo.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/login")
    suspend fun login(@Body user: User): Response<TokenResponse>
}