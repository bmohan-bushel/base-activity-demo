package com.myriadmobile.fargoeventsboard.data

sealed class Result<out D : Any, out E : Any> {
    data class Success<out D : Any>(val data: D) : Result<D, Nothing>()
    data class Error<out E : Any>(val error: E) : Result<Nothing, E>()
    data class Exception(val exception: java.lang.Exception) : Result<Nothing, Nothing>()
}