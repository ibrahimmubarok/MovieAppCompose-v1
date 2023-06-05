package com.dexter.movieappcompose.presentation.component.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.domain.model.Movie
import com.dexter.movieappcompose.utils.MovieConst

@Composable
fun MovieListCard(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${MovieConst.PHOTO_URL}${movie.posterPath}")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.img_placeholder),
                contentDescription = stringResource(R.string.label_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(42.dp)
                    .height(42.dp)
            )
            Text(
                text = movie.title,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(CenterVertically)
            )
        }
    }
}