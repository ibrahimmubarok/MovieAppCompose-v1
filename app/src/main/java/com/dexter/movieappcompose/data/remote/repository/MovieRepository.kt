package com.dexter.movieappcompose.data.remote.repository

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.data.remote.services.MovieApiServices
import com.dexter.movieappcompose.utils.network.ApiHandler
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {

    suspend fun getUpcomingMovies(): Flow<DataResources<BaseResponse<ResultResponse>>>
    suspend fun getPopularMovies(): Flow<DataResources<BaseResponse<ResultResponse>>>
    suspend fun getNowPlayingMovies(): Flow<DataResources<BaseResponse<ResultResponse>>>
}

class MovieRepositoryImpl(private val apiService: MovieApiServices) : MovieRepository {
    override suspend fun getUpcomingMovies(): Flow<DataResources<BaseResponse<ResultResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getUpcomingMovies()
            })
        }

    override suspend fun getPopularMovies(): Flow<DataResources<BaseResponse<ResultResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getPopularMovies()
            })
        }

    override suspend fun getNowPlayingMovies(): Flow<DataResources<BaseResponse<ResultResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiService.getNowPlayingMovies()
            })
        }

}