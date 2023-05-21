package com.dexter.movieappcompose.data.remote.datasource

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.data.remote.services.MovieApiServices

interface MovieDataSource {
    suspend fun getUpcomingMovies(): BaseResponse<ResultResponse>
    suspend fun getPopularMovies(): BaseResponse<ResultResponse>
    suspend fun getNowPlayingMovies(): BaseResponse<ResultResponse>
}

class MovieDataSourceImpl(private val api: MovieApiServices) : MovieDataSource {
    override suspend fun getUpcomingMovies(): BaseResponse<ResultResponse> {
        return api.getUpcomingMovies()
    }

    override suspend fun getPopularMovies(): BaseResponse<ResultResponse> {
        return api.getPopularMovies()
    }

    override suspend fun getNowPlayingMovies(): BaseResponse<ResultResponse> {
        return api.getNowPlayingMovies()
    }

}