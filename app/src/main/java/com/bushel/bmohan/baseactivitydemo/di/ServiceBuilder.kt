package com.bushel.bmohan.baseactivitydemo.di

import com.bushel.bmohan.baseactivitydemo.data.ApiService
import com.bushel.bmohan.baseactivitydemo.data.ResultHandler
import com.bushel.bmohan.baseactivitydemo.data.service.ILoginService
import com.bushel.bmohan.baseactivitydemo.data.service.LoginService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceBuilder {
    @Provides
    @Singleton
    internal fun provideLoginService(apiService: ApiService, handler: ResultHandler): ILoginService {
        return LoginService(apiService, handler)
    }
}