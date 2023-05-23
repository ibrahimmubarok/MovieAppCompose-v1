package com.dexter.movieappcompose.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.data.remote.model.response.ResultResponse
import com.dexter.movieappcompose.presentation.component.carousell.BannerAutoSlideCarousel
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.component.common.MovieItemCard
import com.dexter.movieappcompose.presentation.ui.theme.Black
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.viewmodel.HomeViewModel
import com.dexter.movieappcompose.utils.MovieConst
import com.dexter.movieappcompose.utils.common.UiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    ScrollableContent(
        scrollState = scrollState,
        viewModel = viewModel
    ) {

    }
}

@Composable
fun ScrollableContent(
    scrollState: ScrollState,
    viewModel: HomeViewModel,
    onNavigateToDetail: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(Black)
    ) {
        viewModel.nowPlayingMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {}

                is UiState.Success -> {
                    if (uiState.data.isEmpty()) {
                        Text(
                            text = stringResource(R.string.label_empty_data),
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        val movieUpComingData = uiState.data.map {
                            it.posterPath.orEmpty()
                        }
                        Column {
                            BannerTitle(
                                text = stringResource(R.string.label_title),
                                modifier = Modifier.padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 0.dp,
                                    bottom = 0.dp
                                )
                            )
                            NowPlayingMovieContent(imgMovie = movieUpComingData)
                        }
                    }
                }

                is UiState.Error -> {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = uiState.errorMessage,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        viewModel.upComingMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {}

                is UiState.Success -> {
                    if (uiState.data.isEmpty()) {
                        Text(
                            text = stringResource(R.string.label_empty_data),
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        val movieUpComingData = uiState.data
                        Column {
                            HorizontalMovieListContent(
                                movieUpComingData = movieUpComingData,
                                labelTitle = stringResource(id = R.string.label_upcoming_movies),
                                onNavigateToDetail = onNavigateToDetail,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                        }
                    }
                }

                is UiState.Error -> {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = uiState.errorMessage,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        viewModel.popularMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {}

                is UiState.Success -> {
                    if (uiState.data.isEmpty()) {
                        Text(
                            text = stringResource(R.string.label_empty_data),
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        val moviePopularData = uiState.data
                        Column {
                            HorizontalMovieListContent(
                                movieUpComingData = moviePopularData,
                                labelTitle = stringResource(R.string.label_popular_movies),
                                onNavigateToDetail = onNavigateToDetail,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Spacer(modifier = Modifier.padding(bottom = 16.dp))
                        }
                    }
                }

                is UiState.Error -> {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = uiState.errorMessage,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Composable
fun HorizontalMovieListContent(
    movieUpComingData: List<ResultResponse>,
    labelTitle: String,
    modifier: Modifier = Modifier,
    onNavigateToDetail: () -> Unit,
) {
    val listState = rememberLazyListState()

    BannerTitle(
        text = labelTitle,
        modifier = modifier
    )
    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieUpComingData, key = { it.id ?: 0 }) { movie ->
            MovieItemCard(
                photoUrl = "${MovieConst.PHOTO_URL}${movie.posterPath.toString()}",
                title = movie.title.toString(),
                modifier = Modifier.clickable {
                    onNavigateToDetail()
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NowPlayingMovieContent(
    imgMovie: List<String>,
) {
    Card(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        BannerAutoSlideCarousel(
            itemsCount = imgMovie.size,
            itemContent = { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("${MovieConst.PHOTO_URL}${imgMovie[index]}")
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MovieAppComposeTheme {

    }
}