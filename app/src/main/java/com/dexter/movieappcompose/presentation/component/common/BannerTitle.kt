package com.dexter.movieappcompose.presentation.component.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dexter.movieappcompose.presentation.ui.theme.Typography
import com.dexter.movieappcompose.presentation.ui.theme.White1

@Composable
fun BannerTitle(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 22.sp
) {
    Text(
        text = text,
        style = Typography.headlineMedium.copy(
            fontWeight = FontWeight.ExtraBold,
            fontSize = fontSize,
            color = White1
        ),
        modifier = modifier
            .padding(
                start = 8.dp,
                end = 4.dp,
                bottom = 8.dp,
                top = 24.dp
            )
            .semantics { heading() }
    )
}

@Preview
@Composable
fun MovieAppTitlePreview() {
    BannerTitle(text = "Latest Movie")
}