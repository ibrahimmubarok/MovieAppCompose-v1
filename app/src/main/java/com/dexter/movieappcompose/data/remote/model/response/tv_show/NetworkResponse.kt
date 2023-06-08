package com.dexter.movieappcompose.data.remote.model.response.tv_show


import com.google.gson.annotations.SerializedName

data class NetworkResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)