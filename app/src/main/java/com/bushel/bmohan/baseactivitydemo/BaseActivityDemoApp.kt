package com.bushel.bmohan.baseactivitydemo

import android.app.Application
import com.bushel.bmohan.baseactivitydemo.data.prefs.AppPreferenceHelper
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BaseActivityDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppPreferenceHelper.initialize(this)
        Timber.plant(Timber.DebugTree())
        rebuild()
    }

    fun rebuild() {
//        DaggerAppComponent.builder().application(this).build().inject(this)
    }



}