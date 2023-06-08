package com.dexter.movieappcompose.data.remote.model.response.movie

import com.google.gson.annotations.SerializedName

data class ProductionCountryResponse(
    @SerializedName("iso_3166_1")
    val iso31661: String?,
    @SerializedName("name")
    val name: String?
)