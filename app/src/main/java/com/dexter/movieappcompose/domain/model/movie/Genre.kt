package com.dexter.movieappcompose.domain.model.movie

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.movie.GenreResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val id: Int = 0,
    val name: String = ""
) : Parcelable

fun GenreResponse.mapToGenre(): Genre {
    return Genre(
        id = id ?: 0,
        name = name.orEmpty()
    )
}