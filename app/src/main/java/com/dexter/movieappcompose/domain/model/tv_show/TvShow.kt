package com.dexter.movieappcompose.domain.model.tv_show

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.tv_show.TvShowResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    val backdropPath: String = "",
    val firstAirDate: String = "",
    val genreIds: List<Int?> = listOf(),
    val id: Int = 0,
    val name: String = "",
    val originCountry: List<String?> = listOf(),
    val originalLanguage: String = "",
    val originalName: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
) : Parcelable

fun TvShowResponse.mapToTvShow(): TvShow {
    return TvShow(
        backdropPath = backdropPath.orEmpty(),
        firstAirDate = firstAirDate.orEmpty(),
        genreIds = genreIds.orEmpty(),
        id = id ?: 0,
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalName = originalName.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}