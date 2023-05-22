package com.dexter.movieappcompose.utils.network

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.utils.network.exception.ApiErrorException
import com.dexter.movieappcompose.utils.network.exception.NoInternetConnectionException
import com.dexter.movieappcompose.utils.network.exception.UnexpectedErrorException
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import com.google.gson.Gson
import com.google.gson.JsonParseException
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException

object ApiHandler {

    private val gson: Gson = Gson()

    private fun <T> getErrorFromApi(response: T): String {
        val responseBody = response as ResponseBody
        return try {
            val body = gson.fromJson(responseBody.string(), BaseResponse::class.java)
            body.message ?: "Error Api"
        } catch (e: JsonParseException) {
            "Error Api"
        }
    }

    suspend fun <T> handleApi(apiCall: suspend () -> T): DataResources<T> {
        return try {
            DataResources.Success(apiCall.invoke())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> DataResources.Error(NoInternetConnectionException())
                is HttpException -> {
                    DataResources.Error(
                        ApiErrorException(
                            message = getErrorFromApi(t.response()?.errorBody()),
                            httpCode = t.code()
                        )
                    )
                }

                else -> {
                    DataResources.Error(UnexpectedErrorException())
                }
            }
        }
    }

}