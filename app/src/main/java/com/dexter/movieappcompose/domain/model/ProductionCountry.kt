package com.dexter.movieappcompose.domain.model

import android.os.Parcelable
import com.dexter.movieappcompose.data.remote.model.response.ProductionCountryResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCountry(
    val iso31661: String = "",
    val name: String = ""
) : Parcelable

fun ProductionCountryResponse.toProductionCountry(): ProductionCountry {
    return ProductionCountry(
        iso31661 = iso31661.orEmpty(),
        name = name.orEmpty()
    )
}
