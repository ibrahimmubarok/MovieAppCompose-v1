package com.dexter.movieappcompose.domain.model.tv_show

import com.dexter.movieappcompose.data.remote.model.response.tv_show.NetworkResponse

data class NetworkData(
    val id: Int = 0,
    val logoPath: String = "",
    val name: String = "",
    val originCountry: String = ""
)

fun NetworkResponse.mapToNetworkData(): NetworkData {
    return NetworkData(
        id = id ?: 0,
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty()
    )
}