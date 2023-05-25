package com.dexter.movieappcompose.presentation.component.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.ui.theme.SeaBlue
import com.dexter.movieappcompose.presentation.ui.theme.White1

@Composable
fun ChipItem(
    name: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = SeaBlue,
    textColor: Color = White1,
) {
    Surface(
        modifier = Modifier.width(120.dp),
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun ChipItemPrev() {
    MovieAppComposeTheme {
        ChipItem(name = "Ini Chip")
    }
}