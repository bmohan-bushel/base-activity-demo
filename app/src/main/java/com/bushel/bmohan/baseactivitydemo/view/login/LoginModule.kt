package com.bushel.bmohan.baseactivitydemo.view.login

import com.bushel.bmohan.baseactivitydemo.di.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {
    @ActivityScope
    @Binds
    abstract fun provideLoginView(activity: LoginActivity): ILoginView
}