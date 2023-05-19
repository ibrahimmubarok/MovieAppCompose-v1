package com.dexter.movieappcompose.presentation.ui.screen.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.data.remote.model.ResultResponse
import com.dexter.movieappcompose.presentation.ui.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.ui.component.common.MovieItemCard
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetail: () -> Unit,
) {
    val scrollState = rememberScrollState()

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
        items(movieUpComingData, key = { it.id }) { movie ->
            MovieItemCard(
                photoUrl = movie.posterPath,
                title = movie.title,
                modifier = Modifier.clickable {
                    onNavigateToDetail()
                }
            )
        }
    }
}

@Composable
fun LatestMovieContent() {

}

@Composable
fun PopularMovieContent() {

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieAppComposeTheme {
        HomeScreen(
            onNavigateToDetail = {}
        )
    }
}