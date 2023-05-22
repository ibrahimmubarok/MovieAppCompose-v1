package com.dexter.movieappcompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.dexter.movieappcompose.domain.home.GetMoviesNowPlayingUseCase
import com.dexter.movieappcompose.domain.home.GetMoviesPopularUseCase
import com.dexter.movieappcompose.domain.home.GetMoviesUpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val upComingUseCase: GetMoviesUpcomingUseCase,
    private val nowPlayingUseCase: GetMoviesNowPlayingUseCase,
    private val popularUseCase: GetMoviesPopularUseCase,
) : ViewModel() {
}