package com.bushel.bmohan.baseactivitydemo.di

import com.bushel.bmohan.baseactivitydemo.view.login.LoginActivity
import com.bushel.bmohan.baseactivitydemo.view.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun provideLoginActivity(): LoginActivity
}