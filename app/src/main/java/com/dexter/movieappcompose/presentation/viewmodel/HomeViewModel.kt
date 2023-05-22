package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.utils.common.UiState
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _upComingMovieData: MutableStateFlow<UiState<List<ResultResponse>>> =
        MutableStateFlow(UiState.Loading)
    private val _popularMovieData: MutableStateFlow<UiState<List<ResultResponse>>> =
        MutableStateFlow(UiState.Loading)
    private val _nowPlayingMovieData: MutableStateFlow<UiState<List<ResultResponse>>> =
        MutableStateFlow(UiState.Loading)

    val upComingMovieData: StateFlow<UiState<List<ResultResponse>>> = _upComingMovieData
    val nowPlayingMovieData: StateFlow<UiState<List<ResultResponse>>> = _nowPlayingMovieData
    val popularMovieData: StateFlow<UiState<List<ResultResponse>>> = _popularMovieData

    init {
        getUpcomingMovies()
        getPopularMovies()
        getNowPlayingMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            repository.getUpcomingMovies().collect { data ->
                when (data) {
                    is DataResources.Error -> {
                        _popularMovieData.value = UiState.Error(data.exception?.message.toString())
                    }

                    is DataResources.Success -> {
                        _popularMovieData.value =
                            UiState.Success(data.payload?.results ?: listOf())
                    }
                }
            }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            repository.getUpcomingMovies().collect { data ->
                when (data) {
                    is DataResources.Error -> {
                        _nowPlayingMovieData.value =
                            UiState.Error(data.exception?.message.toString())
                    }

                    is DataResources.Success -> {
                        _nowPlayingMovieData.value =
                            UiState.Success(data.payload?.results ?: listOf())
                    }
                }
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            repository.getUpcomingMovies().collect { data ->
                when (data) {
                    is DataResources.Error -> {
                        _upComingMovieData.value = UiState.Error(data.exception?.message.toString())
                    }

                    is DataResources.Success -> {
                        _upComingMovieData.value =
                            UiState.Success(data.payload?.results ?: listOf())
                    }
                }
            }
        }
    }

}