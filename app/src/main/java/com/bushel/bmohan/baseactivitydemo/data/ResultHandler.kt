package com.bushel.bmohan.baseactivitydemo.data

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.myriadmobile.fargoeventsboard.data.Result
import okhttp3.ResponseBody
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultHandler @Inject constructor(val apiService: ApiService, val mapper: ObjectMapper) {
    inline fun <D : Any, reified E : Any> handle(function: ApiService.() -> Response<D>): Result<D, E> {
        return try {
            val response = function(apiService)
            when {
                response.isSuccessful -> Result.Success(response.body()!!)
                else -> Result.Error(parseError(response.errorBody(), jacksonTypeRef())!!)
            }
        } catch (e: java.lang.Exception) {
            Result.Exception(e)
        }

    }

    fun <E> parseError(body: ResponseBody?, type: TypeReference<E>): E? {
        return try {
            val errorString = body!!.string()
            mapper.readValue(errorString, type)
        } catch (e: Exception) {
            Timber.e("unable to parse validation error")
            null
        }
    }
}