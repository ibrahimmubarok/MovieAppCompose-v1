package com.dexter.movieappcompose.domain.model.movie

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.movie.ProductionCompanyResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompany(
    val id: Int = 0,
    val logoPath: String = "",
    val name: String = "",
    val originCountry: String = ""
) : Parcelable

fun ProductionCompanyResponse.toProductCompany() : ProductionCompany {
    return ProductionCompany(
        id = id ?: 0,
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty()
    )
}