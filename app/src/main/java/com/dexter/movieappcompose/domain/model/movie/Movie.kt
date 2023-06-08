package com.dexter.movieappcompose.domain.model.movie

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.movie.MovieResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val id: Int = 0,
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
    val voteAverage: Double = 0.0,
) : Parcelable

fun MovieResponse.toMovie(): Movie {
    return Movie(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        id = id ?: 0,
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        voteAverage = voteAverage ?: 0.0
    )
}