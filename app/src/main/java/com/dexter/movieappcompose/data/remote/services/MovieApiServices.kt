package com.dexter.movieappcompose.data.remote.services

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import retrofit2.http.GET

interface MovieApiServices {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies() : BaseResponse<ResultResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies() : BaseResponse<ResultResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies() : BaseResponse<ResultResponse>

    @GET("")
    suspend fun getDetailMovie()
}