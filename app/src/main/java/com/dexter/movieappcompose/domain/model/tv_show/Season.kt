package com.dexter.movieappcompose.domain.model.tv_show

import com.dexter.movieappcompose.data.remote.model.response.tv_show.SeasonResponse

data class Season(
    val airDate: String = "",
    val episodeCount: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val posterPath: String = "",
    val seasonNumber: Int = 0
)

fun SeasonResponse.mapToSeason(): Season {
    return Season(
        airDate = airDate.orEmpty(),
        episodeCount = episodeCount ?: 0,
        id = id ?: 0,
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        posterPath = posterPath.orEmpty(),
        seasonNumber = seasonNumber ?: 0
    )
}