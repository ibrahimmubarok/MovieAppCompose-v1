package com.dexter.movieappcompose.data.remote.services

import com.dexter.movieappcompose.BuildConfig
import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.DetailMovieResponse
import com.dexter.movieappcompose.data.remote.model.response.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowApiServices {
    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): BaseResponse<TvShowResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShow(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): BaseResponse<TvShowResponse>

    @GET("tv/on_the_air")
    suspend fun getOnAirTvShow(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1
    ): BaseResponse<TvShowResponse>

    @GET("tv/{series_id}")
    suspend fun getDetailTvShow(
        @Path("series_id") seriesId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): DetailMovieResponse
}