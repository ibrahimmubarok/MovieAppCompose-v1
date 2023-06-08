package com.dexter.movieappcompose.presentation.viewmodel.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexter.movieappcompose.domain.model.movie.DetailMovie
import com.dexter.movieappcompose.domain.usecase.movie.GetDetailMovieUseCase
import com.dexter.movieappcompose.utils.common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val detailMovieUseCase: GetDetailMovieUseCase,
) : ViewModel() {

    private val _detailMovieData: MutableStateFlow<UiState<DetailMovie>> =
        MutableStateFlow(UiState.Loading)

    val detailMovieData: StateFlow<UiState<DetailMovie>> = _detailMovieData

    fun getDetailMovie(movieId: Int) {
        viewModelScope.launch {
            detailMovieUseCase.execute(movieId).collect { data ->
                when (data) {
                    is UiState.Success -> {
                        _detailMovieData.value = UiState.Success(data.data)
                    }

                    is UiState.Error -> {
                        _detailMovieData.value = UiState.Error(data.errorMessage)
                    }

                    else -> {
                        _detailMovieData.value = UiState.Loading
                    }
                }
            }
        }
    }
}