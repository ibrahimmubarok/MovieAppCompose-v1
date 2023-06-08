package com.dexter.movieappcompose.data.remote.model.response.tv_show


import com.google.gson.annotations.SerializedName

data class CreatedByResponse(
    @SerializedName("credit_id")
    val creditId: String?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profile_path")
    val profilePath: String?
)