package com.dexter.movieappcompose.data.remote.services

import com.dexter.movieappcompose.BuildConfig
import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiServices {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): BaseResponse<ResultResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): BaseResponse<ResultResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): BaseResponse<ResultResponse>

    @GET("")
    suspend fun getDetailMovie()
}