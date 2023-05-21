package com.dexter.movieappcompose.utils.network.exception

class UnexpectedErrorException(
    override val message: String? = null,
    val httpCode: Int? = null
) : Exception()