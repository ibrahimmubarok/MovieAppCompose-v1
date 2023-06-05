package com.dexter.movieappcompose.presentation.screen.profile.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.screen.home.NowPlayingMovieContent
import com.dexter.movieappcompose.presentation.viewmodel.HomeViewModel
import com.dexter.movieappcompose.utils.common.UiState

@Composable
fun TabScreen(
    content: String,
    viewModel: HomeViewModel = hiltViewModel()
) {
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
                    val posterMovieUpComingData = uiState.data.map {
                        it.posterPath
                    }
                    val idMovieUpComingData = uiState.data.map {
                        it.id
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
                        NowPlayingMovieContent(
                            imgMovieList = posterMovieUpComingData,
                            idMovieList = idMovieUpComingData
                        ) { _ ->
                            // TODO : Navigate to Detail Movie
                        }
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
}

@Composable
@Preview(showSystemUi = true)
fun PreviewTabScreen() {
    TabScreen(content = "Tab screen")
}