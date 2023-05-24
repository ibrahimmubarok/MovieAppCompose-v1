package com.dexter.movieappcompose.domain.model

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.SpokenLanguageResponse
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
