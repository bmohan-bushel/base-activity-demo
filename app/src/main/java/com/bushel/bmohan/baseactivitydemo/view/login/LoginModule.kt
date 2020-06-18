package com.bushel.bmohan.baseactivitydemo.view.login

import android.app.Activity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class LoginModule {

    @Provides
    fun provideLoginView(activity: Activity): ILoginView? {
        if(activity is LoginActivity){
            return activity
        }
        return null
    }
}