package com.bushel.bmohan.baseactivitydemo.di

import com.bushel.bmohan.baseactivitydemo.view.login.LoginActivity
import com.bushel.bmohan.baseactivitydemo.view.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class ActivityModule {

}