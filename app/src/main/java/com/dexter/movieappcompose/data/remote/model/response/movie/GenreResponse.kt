package com.dexter.movieappcompose.data.remote.model.response.movie


import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)