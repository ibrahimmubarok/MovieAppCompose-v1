package com.dexter.movieappcompose.domain.detail

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import javax.inject.Inject

class GetDetailMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
}