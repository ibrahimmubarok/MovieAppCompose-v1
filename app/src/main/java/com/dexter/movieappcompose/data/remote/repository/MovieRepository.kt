package com.dexter.movieappcompose.data.remote.repository

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.DetailMovieResponse
import com.dexter.movieappcompose.data.remote.model.response.MovieResponse
import com.dexter.movieappcompose.data.remote.services.MovieApiServices
import com.dexter.movieappcompose.utils.network.ApiHandler
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {

    suspend fun getUpcomingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getPopularMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getNowPlayingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getDetailMovie(movieId: Int): Flow<DataResources<DetailMovieResponse>>
}

class MovieRepositoryImpl(private val apiService: MovieApiServices) : MovieRepository {
    override suspend fun getUpcomingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getUpcomingMovies()
            })
        }

    override suspend fun getPopularMovies(): Flow<DataResources<BaseResponse<MovieResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getPopularMovies()
            })
        }

    override suspend fun getNowPlayingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getNowPlayingMovies()
            })
        }

    override suspend fun getDetailMovie(movieId: Int): Flow<DataResources<DetailMovieResponse>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getDetailMovie(movieId = movieId)
            })
        }
}