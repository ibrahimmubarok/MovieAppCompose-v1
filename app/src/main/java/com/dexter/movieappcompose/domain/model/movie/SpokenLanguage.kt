package com.dexter.movieappcompose.domain.model.movie

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.movie.SpokenLanguageResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpokenLanguage(
    val englishName: String = "",
    val iso6391: String = "",
    val name: String = ""
) : Parcelable

fun SpokenLanguageResponse.toSpokenLanguage(): SpokenLanguage {
    return SpokenLanguage(
        englishName = englishName.orEmpty(),
        iso6391 = iso6391.orEmpty(),
        name = name.orEmpty()
    )
}
