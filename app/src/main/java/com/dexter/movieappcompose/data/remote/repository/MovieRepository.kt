package com.dexter.movieappcompose.data.remote.repository

import com.dexter.movieappcompose.data.remote.datasource.MovieDataSource
import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.utils.network.BaseRepository
import com.dexter.movieappcompose.utils.network.wrapper.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface MovieRepository {

    suspend fun getUpcomingMovies(): Flow<DataResource<BaseResponse<ResultResponse>>>
    suspend fun getPopularMovies(): Flow<DataResource<BaseResponse<ResultResponse>>>
    suspend fun getNowPlayingMovies(): Flow<DataResource<BaseResponse<ResultResponse>>>
}

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository,
    BaseRepository() {
    override suspend fun getUpcomingMovies(): Flow<DataResource<BaseResponse<ResultResponse>>> =
        flow {
            emit(safeNetworkCall { dataSource.getUpcomingMovies() })
        }

    override suspend fun getPopularMovies(): Flow<DataResource<BaseResponse<ResultResponse>>> =
        flow {
            emit(safeNetworkCall { dataSource.getPopularMovies() })
        }

    override suspend fun getNowPlayingMovies(): Flow<DataResource<BaseResponse<ResultResponse>>> =
        flow {
            emit(safeNetworkCall { dataSource.getNowPlayingMovies() })
        }
}