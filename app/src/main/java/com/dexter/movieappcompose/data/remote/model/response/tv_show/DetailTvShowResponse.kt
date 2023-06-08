package com.dexter.movieappcompose.data.remote.model.response.tv_show

import com.dexter.movieappcompose.data.remote.model.response.movie.GenreResponse
import com.dexter.movieappcompose.data.remote.model.response.movie.ProductionCompanyResponse
import com.dexter.movieappcompose.data.remote.model.response.movie.ProductionCountryResponse
import com.dexter.movieappcompose.data.remote.model.response.movie.SpokenLanguageResponse
import com.google.gson.annotations.SerializedName

data class DetailTvShowResponse(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("created_by")
    val createdBy: List<CreatedByResponse>?,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Any>?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("genres")
    val genres: List<GenreResponse>?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("in_production")
    val inProduction: Boolean?,
    @SerializedName("languages")
    val languages: List<String>?,
    @SerializedName("last_air_date")
    val lastAirDate: String?,
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: EpisodeResponse?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("networks")
    val networks: List<NetworkResponse>?,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: EpisodeResponse?,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyResponse>?,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryResponse>?,
    @SerializedName("seasons")
    val seasons: List<SeasonResponse>?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageResponse>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)