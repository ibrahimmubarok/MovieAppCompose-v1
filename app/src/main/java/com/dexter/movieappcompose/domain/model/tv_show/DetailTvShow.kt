package com.dexter.movieappcompose.domain.model.tv_show

import com.dexter.movieappcompose.data.remote.model.response.tv_show.DetailTvShowResponse
import com.dexter.movieappcompose.domain.model.movie.Genre
import com.dexter.movieappcompose.domain.model.movie.ProductionCompany
import com.dexter.movieappcompose.domain.model.movie.ProductionCountry
import com.dexter.movieappcompose.domain.model.movie.SpokenLanguage
import com.dexter.movieappcompose.domain.model.movie.mapToGenre
import com.dexter.movieappcompose.domain.model.movie.toProductCompany
import com.dexter.movieappcompose.domain.model.movie.toProductionCountry
import com.dexter.movieappcompose.domain.model.movie.toSpokenLanguage

data class DetailTvShow(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val createdBy: List<CreatedBy> = listOf(),
    val episodeRunTime: List<Any> = listOf(),
    val firstAirDate: String = "",
    val genres: List<Genre> = listOf(),
    val homepage: String = "",
    val id: Int = 0,
    val inProduction: Boolean = false,
    val languages: List<String> = listOf(),
    val lastAirDate: String = "",
    val lastEpisodeToAir: Episode,
    val name: String = "",
    val networks: List<NetworkData> = listOf(),
    val nextEpisodeToAir: Episode,
    val numberOfEpisodes: Int = 0,
    val numberOfSeasons: Int = 0,
    val originCountry: List<String> = listOf(),
    val originalLanguage: String = "",
    val originalName: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val productionCompanies: List<ProductionCompany> = listOf(),
    val productionCountries: List<ProductionCountry> = listOf(),
    val seasons: List<Season> = listOf(),
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val type: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)

fun DetailTvShowResponse.mapToDetailTvShow(): DetailTvShow {
    return DetailTvShow(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        createdBy = createdBy?.map {
            it.mapToCreatedBy()
        }.orEmpty(),
        episodeRunTime = episodeRunTime.orEmpty(),
        firstAirDate = firstAirDate.orEmpty(),
        genres = genres?.map {
            it.mapToGenre()
        }.orEmpty(),
        homepage = homepage.orEmpty(),
        id = id ?: 0,
        inProduction = inProduction ?: false,
        languages = languages.orEmpty(),
        lastAirDate = lastAirDate.orEmpty(),
        lastEpisodeToAir = lastEpisodeToAir?.mapToEpisode() ?: Episode(),
        name = name.orEmpty(),
        networks = networks?.map {
            it.mapToNetworkData()
        }.orEmpty(),
        nextEpisodeToAir = nextEpisodeToAir?.mapToEpisode() ?: Episode(),
        numberOfEpisodes = numberOfEpisodes ?: 0,
        numberOfSeasons = numberOfSeasons ?: 0,
        originCountry = originCountry.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalName = originalName.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        productionCountries = productionCountries?.map {
            it.toProductionCountry()
        }.orEmpty(),
        productionCompanies = productionCompanies?.map {
            it.toProductCompany()
        }.orEmpty(),
        seasons = seasons?.map {
            it.mapToSeason()
        }.orEmpty(),
        spokenLanguages = spokenLanguages?.map {
            it.toSpokenLanguage()
        }.orEmpty(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        type = type.orEmpty(),
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}