package com.dexter.movieappcompose.di

import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.data.remote.repository.MovieRepositoryImpl
import com.dexter.movieappcompose.data.remote.services.MovieApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesMovieRepository(movieApiServices: MovieApiServices): MovieRepository {
        return MovieRepositoryImpl(movieApiServices)
    }
}