package com.bushel.bmohan.baseactivitydemo.di

import com.bushel.bmohan.baseactivitydemo.data.ApiService
import com.bushel.bmohan.baseactivitydemo.data.ResultHandler
import com.bushel.bmohan.baseactivitydemo.data.service.ILoginService
import com.bushel.bmohan.baseactivitydemo.data.service.LoginService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ServiceBuilder {
    @Provides
    @Singleton
    internal fun provideLoginService(apiService: ApiService, handler: ResultHandler): ILoginService {
        return LoginService(apiService, handler)
    }
}