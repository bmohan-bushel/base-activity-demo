package com.bushel.bmohan.baseactivitydemo.data.prefs

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.bushel.bmohan.baseactivitydemo.BuildConfig

object AppPreferenceHelper {
    private const val KEY_ACCESS_TOKEN = "key_access_token"
    private const val KEY_DEVICE_UUID = "key_device_uuid"

    private lateinit var prefs: SharedPreferences

    fun initialize(app: Application) {
        if (AppPreferenceHelper::prefs.isInitialized) return

        prefs = app.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

    fun getAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)

    fun setAccessToken(accessToken: String?) = prefs.edit { putString(KEY_ACCESS_TOKEN, accessToken) }

    fun getDeviceUUID() = prefs.getString(KEY_DEVICE_UUID, null) ?: ""

    fun setDeviceUUID(deviceUUID: String?) = prefs.edit { putString(KEY_DEVICE_UUID, deviceUUID) }
}