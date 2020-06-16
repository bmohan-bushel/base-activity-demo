package com.bushel.bmohan.baseactivitydemo.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ErrorResponse(val message: String? = null) : Parcelable