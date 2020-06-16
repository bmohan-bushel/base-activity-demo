package com.bushel.bmohan.baseactivitydemo.data.service

import com.bushel.bmohan.baseactivitydemo.data.ApiService
import com.bushel.bmohan.baseactivitydemo.data.ResultHandler
import com.bushel.bmohan.baseactivitydemo.model.ErrorResponse
import com.bushel.bmohan.baseactivitydemo.model.TokenResponse
import com.myriadmobile.fargoeventsboard.data.Result
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LoginService @Inject constructor(
    private val apiService: ApiService,
    private val handler: ResultHandler
) : ILoginService {

    override suspend fun login(
        username: String,
        password: String
    ): Result<TokenResponse, ErrorResponse> {
        //No-Op
        return Result.Error(ErrorResponse("Unable to login"))
    }
}

interface ILoginService {
    suspend fun login(username: String, password: String): Result<TokenResponse, ErrorResponse>
}