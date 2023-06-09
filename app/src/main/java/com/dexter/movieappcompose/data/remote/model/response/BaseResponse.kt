package com.dexter.movieappcompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<T>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("status_message")
    val message: String?
)