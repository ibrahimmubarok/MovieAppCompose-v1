package com.dexter.movieappcompose.utils

import kotlinx.coroutines.flow.Flow

/**
 *  You can give "Any" data type for request param and response value
 *  but, please give this variable with your data class
 */

abstract class BaseUseCase<P : Any?, R : Any?> {
    abstract fun execute(requestParam: P? = null): Flow<R>
}