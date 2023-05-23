package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dexter.movieappcompose.data.remote.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
}