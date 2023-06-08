package com.dexter.movieappcompose.di

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.domain.usecase.movie.GetDetailMovieUseCase
import com.dexter.movieappcompose.domain.usecase.movie.GetListPaginationMovieUseCase
import com.dexter.movieappcompose.domain.usecase.movie.GetNowPlayingMoviesUseCase
import com.dexter.movieappcompose.domain.usecase.movie.GetPopularMoviesUseCase
import com.dexter.movieappcompose.domain.usecase.movie.GetUpcomingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object MovieUseCaseModule {

    @Provides
    fun providesGetUpcomingMoviesUseCase(
        movieRepository: MovieRepository,
    ): GetUpcomingMoviesUseCase {
        return GetUpcomingMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesGetNowPlayingMoviesUseCase(
        movieRepository: MovieRepository
    ): GetNowPlayingMoviesUseCase {
        return GetNowPlayingMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetPopularMoviesUseCase(
        movieRepository: MovieRepository,
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetListPaginationMovieUseCase(
        movieRepository: MovieRepository
    ): GetListPaginationMovieUseCase {
        return GetListPaginationMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetDetailMovieUseCase(
        movieRepository: MovieRepository,
    ): GetDetailMovieUseCase {
        return GetDetailMovieUseCase(movieRepository)
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

}