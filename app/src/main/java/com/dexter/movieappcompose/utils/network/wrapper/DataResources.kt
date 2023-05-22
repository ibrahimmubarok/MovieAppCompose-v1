package com.dexter.movieappcompose.utils.network.wrapper

sealed class DataResources<T>(
    val payload: T? = null,
    val message: String? = null,
    val exception: Exception? = null,
) {
    class Success<T>(data: T) : DataResources<T>(data)
    class Error<T>(exception: Exception?, data: T? = null) :
        DataResources<T>(data, exception = exception)
}