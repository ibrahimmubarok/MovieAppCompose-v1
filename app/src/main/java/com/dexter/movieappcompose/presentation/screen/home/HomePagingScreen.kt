package com.dexter.movieappcompose.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.dexter.movieappcompose.presentation.component.common.ErrorItem
import com.dexter.movieappcompose.presentation.component.common.MovieListCard
import com.dexter.movieappcompose.presentation.viewmodel.movie.HomeViewModel

@Composable
fun HomePagingScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val moviesData = viewModel.getPagingPopularMovies().collectAsLazyPagingItems()

    LazyColumn {
        items(moviesData) { movie ->
            movie?.let { item ->
                MovieListCard(item)
            }
        }
        when (moviesData.loadState.append) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            is LoadState.Error -> {
                item {
                    ErrorItem(
                        message = (moviesData.loadState.append as LoadState.Error).error.message.toString()
                    )
                }
            }
        }
    }
}