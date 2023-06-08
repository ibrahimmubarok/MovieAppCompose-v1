package com.dexter.movieappcompose.di

import com.dexter.movieappcompose.data.remote.repository.TvShowRepository
import com.dexter.movieappcompose.domain.usecase.tv_show.GetDetailTvShowUseCase
import com.dexter.movieappcompose.domain.usecase.tv_show.GetOnAirTvShowUseCase
import com.dexter.movieappcompose.domain.usecase.tv_show.GetPopularTvShowUseCase
import com.dexter.movieappcompose.domain.usecase.tv_show.GetTopRatedTvShowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TvShowUseCaseModule {

    @Provides
    fun provideGetOnAirTvShowUseCase(
        tvShowRepository: TvShowRepository
    ): GetOnAirTvShowUseCase {
        return GetOnAirTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetDetailTvShowUseCase(
        tvShowRepository: TvShowRepository
    ): GetDetailTvShowUseCase {
        return GetDetailTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetPopularTvShowUseCase(
        tvShowRepository: TvShowRepository
    ): GetPopularTvShowUseCase {
        return GetPopularTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetTopRatedTvShowUseCase(
        tvShowRepository: TvShowRepository
    ): GetTopRatedTvShowUseCase {
        return GetTopRatedTvShowUseCase(tvShowRepository)
    }

}