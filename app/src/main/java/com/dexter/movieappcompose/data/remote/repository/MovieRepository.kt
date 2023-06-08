package com.dexter.movieappcompose.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dexter.movieappcompose.data.paging_sources.MoviePagingSource
import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.movie.DetailMovieResponse
import com.dexter.movieappcompose.data.remote.model.response.movie.MovieResponse
import com.dexter.movieappcompose.data.remote.services.MovieApiServices
import com.dexter.movieappcompose.domain.model.movie.Movie
import com.dexter.movieappcompose.utils.network.ApiHandler
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {

    suspend fun getUpcomingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getPopularMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getNowPlayingMovies(): Flow<DataResources<BaseResponse<MovieResponse>>>
    suspend fun getDetailMovie(movieId: Int): Flow<DataResources<DetailMovieResponse>>
    fun getPagingPopularMovies(): Flow<PagingData<Movie>>
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

    override fun getPagingPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(api = apiService)
            }
        ).flow
    }
}