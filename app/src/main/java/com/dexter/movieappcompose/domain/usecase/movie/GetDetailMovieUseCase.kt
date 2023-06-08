package com.dexter.movieappcompose.domain.usecase.movie

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.domain.model.movie.DetailMovie
import com.dexter.movieappcompose.domain.model.movie.toDetailMovie
import com.dexter.movieappcompose.utils.BaseUseCase
import com.dexter.movieappcompose.utils.common.state.UiState
import com.dexter.movieappcompose.utils.ext.suspendSubscribe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : BaseUseCase<Int, UiState<DetailMovie>>() {
    override fun execute(requestParam: Int?): Flow<UiState<DetailMovie>> =
        flow {
            emit(UiState.Loading)
            val movieId = requestParam ?: 0
            movieRepository.getDetailMovie(movieId).collect {
                it.suspendSubscribe(
                    doOnSuccess = { data ->
                        val moviesDetail = data.payload?.toDetailMovie()
                        if (moviesDetail != null) {
                            emit(UiState.Success(moviesDetail))
                        } else {
                            // You can change this state empty when moviesDetail is null
                            emit(UiState.Error("Data is empty"))
                        }
                    },
                    doOnError = { error ->
                        emit(UiState.Error(error.message.toString()))
                    }
                )
            }
        }
}