package com.bushel.bmohan.baseactivitydemo.view.login

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class LoginModule {
    @Binds
    abstract fun provideLoginView(activity: LoginActivity): ILoginView
}