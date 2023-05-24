package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import com.dexter.movieappcompose.domain.model.DetailMovie
import com.dexter.movieappcompose.domain.model.toDetailMovie
import com.dexter.movieappcompose.utils.common.UiState
import com.dexter.movieappcompose.utils.network.wrapper.DataResources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _detailMovieData: MutableStateFlow<UiState<DetailMovie>> =
        MutableStateFlow(UiState.Loading)

    val detailMovieData: StateFlow<UiState<DetailMovie>> = _detailMovieData

    fun getDetailMovie(movieId: Int) {
        viewModelScope.launch {
            repository.getDetailMovie(movieId).collect { data ->
                when (data) {
                    is DataResources.Error -> {
                        _detailMovieData.value = UiState.Error(data.exception?.message.toString())
                    }

                    is DataResources.Success -> {
                        _detailMovieData.value =
                            UiState.Success(data.payload?.toDetailMovie() ?: DetailMovie())
                    }
                }
            }
        }
    }
}