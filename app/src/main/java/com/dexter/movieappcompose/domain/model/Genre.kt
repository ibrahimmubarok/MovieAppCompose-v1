package com.dexter.movieappcompose.domain.model

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.GenreResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val id: Int = 0,
    val name: String = ""
) : Parcelable

fun GenreResponse.toGenre(): Genre {
    return Genre(
        id = id ?: 0,
        name = name.orEmpty()
    )
}