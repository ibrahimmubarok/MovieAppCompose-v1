package com.dexter.movieappcompose.domain.model.tv_show

import com.dexter.movieappcompose.data.remote.model.response.tv_show.EpisodeResponse

data class Episode(
    val airDate: String = "",
    val episodeNumber: Int = 0,
    val id: Int = -1,
    val name: String = "",
    val overview: String = "",
    val productionCode: String = "",
    val seasonNumber: Int = 0,
    val showId: Int = -1,
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)

fun EpisodeResponse.mapToEpisode(): Episode {
    return Episode(
        airDate = airDate.orEmpty(),
        episodeNumber = episodeNumber ?: 0,
        id = id ?: -1,
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        productionCode = productionCode.orEmpty(),
        seasonNumber = seasonNumber ?: 0,
        showId = showId ?: -1,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0
    )
}