package com.dexter.movieappcompose.domain.model.tv_show

import com.dexter.movieappcompose.data.remote.model.response.tv_show.CreatedByResponse

data class CreatedBy(
    val creditId: String = "",
    val gender: Int = -1,
    val id: Int = -1,
    val name: String = "",
    val profilePath: String = ""
)

fun CreatedByResponse.mapToCreatedBy(): CreatedBy {
    return CreatedBy(
        creditId = creditId.orEmpty(),
        gender = gender ?: -1,
        id = id ?: 0,
        name = name.orEmpty(),
        profilePath = profilePath.orEmpty()
    )
}
