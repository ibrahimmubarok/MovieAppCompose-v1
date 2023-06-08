package com.dexter.movieappcompose.data.remote.model.response.tv_show


import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("episode_number")
    val episodeNumber: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("production_code")
    val productionCode: String?,
    @SerializedName("runtime")
    val runtime: Any?,
    @SerializedName("season_number")
    val seasonNumber: Int?,
    @SerializedName("show_id")
    val showId: Int?,
    @SerializedName("still_path")
    val stillPath: Any?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)