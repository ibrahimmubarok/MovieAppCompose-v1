package com.dexter.movieappcompose.domain.usecase

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.domain.model.Movie
import com.dexter.movieappcompose.domain.model.toMovie
import com.dexter.movieappcompose.utils.BaseUseCase
import com.dexter.movieappcompose.utils.common.UiState
import com.dexter.movieappcompose.utils.ext.suspendSubscribe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) : BaseUseCase<Nothing, UiState<List<Movie>>>() {
    override fun execute(requestParam: Nothing?): Flow<UiState<List<Movie>>> =
        flow {
            emit(UiState.Loading)
            movieRepository.getPopularMovies().collect {
                it.suspendSubscribe(
                    doOnSuccess = { data ->
                        val movies = mutableListOf<Movie>()
                        val listMovie = data.payload?.results?.map { item ->
                            item.toMovie()
                        }
                        movies.addAll(listMovie.orEmpty())
                        emit(UiState.Success(movies))
                    },
                    doOnError = { error ->
                        emit(UiState.Error(error.message.toString()))
                    }
                )
            }
        }
}