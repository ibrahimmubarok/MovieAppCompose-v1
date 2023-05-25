package com.dexter.movieappcompose.presentation.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.domain.model.DetailMovie
import com.dexter.movieappcompose.domain.model.Genre
import com.dexter.movieappcompose.presentation.component.common.BackButton
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.component.common.ChipItem
import com.dexter.movieappcompose.presentation.ui.theme.Typography
import com.dexter.movieappcompose.presentation.ui.theme.White1
import com.dexter.movieappcompose.presentation.viewmodel.DetailMovieViewModel
import com.dexter.movieappcompose.utils.MovieConst
import com.dexter.movieappcompose.utils.common.UiState

@Composable
fun DetailMovieScreen(
    movieId: Int,
    navigateBack: () -> Unit
) {
    DetailMovieContent(movieId = movieId, navigateBack = navigateBack)
}

@Composable
fun DetailMovieContent(
    movieId: Int,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailMovieViewModel = hiltViewModel()
) {

    LaunchedEffect(movieId) {
        viewModel.getDetailMovie(movieId = movieId)
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        viewModel.detailMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    Column(
                        modifier = modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            color = Color.White
                        )
                    }
                }

                is UiState.Success -> {
                    if (uiState.data.title.isNotEmpty()) {
                        Box {
                            TopBanner(imgBackdrop = uiState.data.backdropPath)
                            BackButton(modifier = Modifier.padding(16.dp)) {
                                navigateBack.invoke()
                            }
                        }
                        MainContent(
                            data = uiState.data,
                            modifier = modifier.padding(
                                horizontal = 16.dp,
                                vertical = 16.dp
                            )
                        )
                    } else {
                        Text(
                            text = stringResource(id = R.string.label_empty_data),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                is UiState.Error -> {
                    Text(
                        modifier = Modifier.padding(horizontal = 6.dp),
                        text = uiState.errorMessage,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun TopBanner(
    imgBackdrop: String,
) {
    AsyncImage(
        model = "${MovieConst.PHOTO_URL}$imgBackdrop",
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    )
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    data: DetailMovie,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        BannerTitle(
            text = data.title,
        )
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextContent(
                text = "Release Date : ${data.releaseDate}",
                modifier = Modifier.padding(end = 4.dp)
            )
            TextContent(
                text = "|",
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            TextContent(
                text = String.format("%.2f", data.voteAverage),
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Yellow,
                contentDescription = null,
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
    data.genres?.let { item ->
        ListChipGenre(genreItems = item)
    }
    Column(
        modifier = modifier.padding(top = 8.dp),
    ) {
        BannerTitle(
            text = stringResource(R.string.label_description),
            fontSize = 18.sp
        )
        TextContent(
            text = data.overview,
            textSize = 14.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun ListChipGenre(
    modifier: Modifier = Modifier,
    genreItems: List<Genre>
) {
    val listState = rememberLazyListState()

    LazyRow(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(genreItems, key = { it.id }) { genre ->
            ChipItem(name = genre.name)
        }
    }
}

@Composable
fun TextContent(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 16.sp,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.displayMedium.copy(
            color = White1,
            fontSize = textSize,
            textAlign = textAlign,
            lineHeight = 24.sp
        )
    )
}