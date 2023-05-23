package com.dexter.movieappcompose.presentation.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.ui.theme.PurpleGrey40
import com.dexter.movieappcompose.presentation.ui.theme.Typography
import com.dexter.movieappcompose.presentation.ui.theme.White1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItemCard(
    modifier: Modifier = Modifier,
    photoUrl: String,
    title: String,
) {
    Card(
        modifier = modifier
            .width(140.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onClick = {
            // TODO :: OPEN DETAIL ACTIVITY
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PurpleGrey40),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = photoUrl,
                modifier = Modifier
                    .width(140.dp)
                    .height(160.dp),
                placeholder = painterResource(id = R.drawable.img_placeholder),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    style = Typography.bodySmall.copy(
                        fontSize = 12.sp,
                        color = White1
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(8.dp),
                    text = title,
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieItemCardPrev() {
    MovieAppComposeTheme {
        MovieItemCard(
            photoUrl = "https://raw.githubusercontent.com/dicodingacademy/assets/main/android_compose_academy/pahlawan/6.jpg",
            title = "Spider-Man : Far From Home"
        )
    }
}

