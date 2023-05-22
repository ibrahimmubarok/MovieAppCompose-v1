package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dexter.movieappcompose.domain.detail.GetDetailMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val useCase: GetDetailMovieUseCase
) : ViewModel(){
}