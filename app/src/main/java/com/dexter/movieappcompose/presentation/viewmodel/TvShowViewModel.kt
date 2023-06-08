package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dexter.movieappcompose.data.remote.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

}