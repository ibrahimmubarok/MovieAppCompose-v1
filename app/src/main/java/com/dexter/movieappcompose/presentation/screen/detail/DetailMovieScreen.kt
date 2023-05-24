package com.dexter.movieappcompose.presentation.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.domain.model.DetailMovie
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.ui.theme.Typography
import com.dexter.movieappcompose.presentation.ui.theme.White1
import com.dexter.movieappcompose.presentation.viewmodel.DetailMovieViewModel
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
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        viewModel.detailMovieData.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getDetailMovie(movieId = movieId)
                    LinearProgressIndicator()
                }

                is UiState.Success -> {
                    if (uiState.data.title.isNotEmpty()) {
                        TopBanner(imgBackdrop = uiState.data.backdropPath)
                        MainContent(data = uiState.data)
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
        model = imgBackdrop,
        contentDescription = null,
        contentScale = ContentScale.Fit,
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
        horizontalAlignment = Alignment.Start
    ) {
        BannerTitle(
            text = data.title,
        )
        Row(
            modifier = modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = "Release Date : ${data.releaseDate}",
                modifier = modifier.padding(end = 4.dp),
                style = Typography.displayMedium.copy(
                    color = White1,
                    fontSize = 16.sp,
                )
            )
            Text(
                text = "|",
                modifier = modifier.padding(end = 4.dp),
            )
            Text(
                text = String.format("%.2f", data.voteAverage),
                modifier = modifier.padding(end = 4.dp),
                style = Typography.displayMedium.copy(
                    color = White1,
                    fontSize = 16.sp,
                )
            )
            Icon(
                imageVector = Icons.Default.Star,
                tint = Color.Yellow,
                contentDescription = null,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPrev() {
    MovieAppComposeTheme {

    }
}