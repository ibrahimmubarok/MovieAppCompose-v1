package com.dexter.movieappcompose.utils.ext

import com.dexter.movieappcompose.utils.network.wrapper.DataResources

suspend fun <T> DataResources<T>.suspendSubscribe(
    doOnSuccess: suspend (resource: DataResources<T>) -> Unit,
    doOnError: suspend (resource: DataResources<T>) -> Unit,
) {
    when (this) {
        is DataResources.Success -> doOnSuccess.invoke(this)
        is DataResources.Error -> doOnError.invoke(this)
    }
}