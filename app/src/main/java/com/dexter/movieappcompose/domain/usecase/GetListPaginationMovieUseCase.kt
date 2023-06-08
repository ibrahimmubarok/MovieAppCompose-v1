package com.dexter.movieappcompose.domain.usecase

import androidx.paging.PagingData
import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.domain.model.Movie
import com.dexter.movieappcompose.utils.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPaginationMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : BaseUseCase<Nothing, PagingData<Movie>>() {
    override fun execute(requestParam: Nothing?): Flow<PagingData<Movie>> =
        movieRepository.getPagingPopularMovies()
}