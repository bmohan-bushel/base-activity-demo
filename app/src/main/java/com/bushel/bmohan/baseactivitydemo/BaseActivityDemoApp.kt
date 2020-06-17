package com.bushel.bmohan.baseactivitydemo

import android.app.Application
import com.bushel.bmohan.baseactivitydemo.data.prefs.AppPreferenceHelper
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseActivityDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppPreferenceHelper.initialize(this)
        Timber.plant(Timber.DebugTree())
    }
}