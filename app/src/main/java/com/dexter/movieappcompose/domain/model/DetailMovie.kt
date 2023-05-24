package com.dexter.movieappcompose.domain.model

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.DetailMovieResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailMovie(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val budget: Int = 0,
    val genres: List<Genre>? = null,
    val homepage: String = "",
    val id: Int = 0,
    val imdbId: String = "",
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val productionCompanies: List<ProductionCompany>? = listOf(),
    val productionCountries: List<ProductionCountry>? = listOf(),
    val releaseDate: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spokenLanguages: List<SpokenLanguage>? = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
) : Parcelable

fun DetailMovieResponse.toDetailMovie(): DetailMovie {
    return DetailMovie(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        budget = budget ?: 0,
        genres = genres?.map {
            it.toGenre()
        },
        homepage = homepage.orEmpty(),
        id = id ?: 0,
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        productionCompanies = productionCompanies?.map {
            it.toProductCompany()
        },
        productionCountries = productionCountries?.map {
            it.toProductionCountry()
        },
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages?.map {
            it.toSpokenLanguage()
        },
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}