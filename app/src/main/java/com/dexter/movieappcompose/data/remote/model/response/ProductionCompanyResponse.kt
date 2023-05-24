package com.dexter.movieappcompose.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)