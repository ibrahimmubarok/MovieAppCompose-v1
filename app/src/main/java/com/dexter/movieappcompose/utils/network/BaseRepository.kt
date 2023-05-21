package com.dexter.movieappcompose.utils.network

import com.dexter.movieappcompose.utils.network.exception.ApiErrorException
import com.dexter.movieappcompose.utils.network.exception.NoInternetConnectionException
import com.dexter.movieappcompose.utils.network.exception.UnexpectedErrorException
import com.dexter.movieappcompose.utils.network.wrapper.DataResource
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {

    fun <T> getErrorMessageFromApi(response: T): String {
        return "Error Message"
    }

    suspend fun <T> safeNetworkCall(apiCall: suspend () -> T): DataResource<T> {
        return try {
            DataResource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> DataResource.Error(NoInternetConnectionException())
                is HttpException -> {
                    DataResource.Error(
                        ApiErrorException(
                            message = getErrorMessageFromApi(throwable.response()?.errorBody()),
                            httpCode = throwable.code(),
                        )
                    )
                }
                else -> {
                    DataResource.Error(UnexpectedErrorException())
                }
            }
        }
    }
}