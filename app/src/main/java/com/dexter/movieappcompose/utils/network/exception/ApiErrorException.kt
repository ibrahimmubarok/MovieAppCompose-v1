package com.dexter.movieappcompose.utils.network.exception

class ApiErrorException(
    override val message: String? = null,
    val httpCode: Int? = null,
) : Exception()