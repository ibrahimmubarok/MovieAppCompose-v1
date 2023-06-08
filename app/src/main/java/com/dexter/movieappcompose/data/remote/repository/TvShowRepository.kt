package com.dexter.movieappcompose.data.remote.repository

import com.dexter.movieappcompose.data.remote.model.response.BaseResponse
import com.dexter.movieappcompose.data.remote.model.response.TvShowResponse
import com.dexter.movieappcompose.data.remote.services.TvShowApiServices
import com.dexter.movieappcompose.utils.network.ApiHandler
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface TvShowRepository {

    suspend fun getTopRatedTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>>
    suspend fun getPopularTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>>
    suspend fun getOnAirTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>>
}

class TvShowRepositoryImpl(private val apiServices: TvShowApiServices) : TvShowRepository {
    override suspend fun getTopRatedTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiServices.getTopRatedTvShow()
            })
        }

    override suspend fun getPopularTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiServices.getPopularTvShow()
            })
        }

    override suspend fun getOnAirTvShow(): Flow<DataResources<BaseResponse<TvShowResponse>>> =
        flow {
            emit(ApiHandler.handleApi {
                apiServices.getOnAirTvShow()
            })
        }
}