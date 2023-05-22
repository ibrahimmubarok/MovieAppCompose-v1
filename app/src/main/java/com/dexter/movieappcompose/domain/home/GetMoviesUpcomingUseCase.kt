package com.dexter.movieappcompose.domain.home

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUpcomingUseCase @Inject constructor(
    private val repository: MovieRepository,
) {
}