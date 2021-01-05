package com.ibrajix.directcurrencyconverter.network

import android.util.Log
import com.ibrajix.directcurrencyconverter.helper.Resource
import retrofit2.Response
import java.lang.Exception

/**
 * This helps to properly handle the response gotten from the API - Be it error, success etc
 */

abstract class BaseDataSource {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Log.e("remoteDataSource", message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

}