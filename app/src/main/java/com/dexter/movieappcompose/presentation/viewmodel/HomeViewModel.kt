package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dexter.movieappcompose.domain.model.Movie
import com.dexter.movieappcompose.domain.usecase.GetListPaginationMovieUseCase
import com.dexter.movieappcompose.domain.usecase.GetNowPlayingMoviesUseCase
import com.dexter.movieappcompose.domain.usecase.GetPopularMoviesUseCase
import com.dexter.movieappcompose.domain.usecase.GetUpcomingMoviesUseCase
import com.dexter.movieappcompose.utils.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val upComingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val nowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val popularMoviesUseCase: GetPopularMoviesUseCase,
    private val listPaginationMovieUseCase: GetListPaginationMovieUseCase,
) : ViewModel() {

    private val _upComingMovieData: MutableStateFlow<UiState<List<Movie>>> =
        MutableStateFlow(UiState.Loading)
    private val _popularMovieData: MutableStateFlow<UiState<List<Movie>>> =
        MutableStateFlow(UiState.Loading)
    private val _nowPlayingMovieData: MutableStateFlow<UiState<List<Movie>>> =
        MutableStateFlow(UiState.Loading)

    val upComingMovieData: StateFlow<UiState<List<Movie>>> = _upComingMovieData
    val nowPlayingMovieData: StateFlow<UiState<List<Movie>>> = _nowPlayingMovieData
    val popularMovieData: StateFlow<UiState<List<Movie>>> = _popularMovieData

    fun getPopularMovies() {
        viewModelScope.launch {
            popularMoviesUseCase.execute().collect { data ->
                when (data) {
                    is UiState.Success -> {
                        _popularMovieData.value = UiState.Success(data.data)
                    }

                    is UiState.Error -> {
                        _popularMovieData.value = UiState.Error(data.errorMessage)
                    }

                    else -> {
                        _popularMovieData.value = UiState.Loading
                    }
                }
            }
        }
    }

    fun getPagingPopularMovies(): Flow<PagingData<Movie>> {
        return listPaginationMovieUseCase.execute().cachedIn(viewModelScope)
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            nowPlayingMoviesUseCase.execute().collect { data ->
                when (data) {
                    is UiState.Success -> {
                        _nowPlayingMovieData.value = UiState.Success(data.data.take(5))
                    }

                    is UiState.Error -> {
                        _nowPlayingMovieData.value = UiState.Error(data.errorMessage)
                    }

                    else -> {
                        _nowPlayingMovieData.value = UiState.Loading
                    }
                }
            }
        }
    }

    fun getUpcomingMovies() {
        viewModelScope.launch {
            upComingMoviesUseCase.execute().collect { data ->
                when (data) {
                    is UiState.Success -> {
                        _upComingMovieData.value = UiState.Success(data.data)
                    }

                    is UiState.Error -> {
                        _upComingMovieData.value = UiState.Error(data.errorMessage)
                    }

                    else -> {
                        _upComingMovieData.value = UiState.Loading
                    }
                }
            }
        }
    }
}