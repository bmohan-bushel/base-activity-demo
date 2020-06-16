package com.bushel.bmohan.baseactivitydemo

import android.app.Application
import com.bushel.bmohan.baseactivitydemo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseActivityDemoApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        rebuild()
    }

    fun rebuild() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }



}