package com.dexter.movieappcompose.presentation.screen.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.presentation.ui.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.ui.component.common.MovieItemCard
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.viewmodel.HomeViewModel
import com.dexter.movieappcompose.utils.common.UiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        viewModel.upComingMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Success -> {
                    if (uiState.data.isEmpty()) {
                        Text(
                            text = "Data Kosong",
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        Text(
                            text = uiState.data[0].title.toString(),
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                is UiState.Error -> {
                    Text(
                        text = uiState.errorMessage,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollableContent(
    movieUpComingData: List<ResultResponse>,
    scrollState: ScrollState,
    onNavigateToDetail: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(state = scrollState)
    ) {
        UpcomingMovieContent(
            movieUpComingData = movieUpComingData,
            onNavigateToDetail = onNavigateToDetail
        )
    }
}

@Composable
fun UpcomingMovieContent(
    movieUpComingData: List<ResultResponse>,
    onNavigateToDetail: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    BannerTitle(
        text = stringResource(R.string.label_upcoming_movies),
        modifier = Modifier.padding(8.dp)
    )
    LazyRow(
        state = listState,
        contentPadding = PaddingValues(bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieUpComingData, key = { it.id ?: 0 }) { movie ->
            MovieItemCard(
                photoUrl = movie.posterPath.toString(),
                title = movie.title.toString(),
                modifier = Modifier.clickable {
                    onNavigateToDetail()
                }
            )
        }
    }
}

@Composable
fun NowPlayingMovieContent() {

}

@Composable
fun PopularMovieContent() {

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieAppComposeTheme {

    }
}