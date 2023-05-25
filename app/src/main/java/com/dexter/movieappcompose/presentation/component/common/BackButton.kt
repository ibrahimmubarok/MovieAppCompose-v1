package com.dexter.movieappcompose.presentation.component.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.ArrowBack,
    color: Color = Color.Black,
    onNavigateUp: () -> Unit,
) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .height(46.dp)
            .width(46.dp)
            .clickable {
                onNavigateUp.invoke()
            }
    ) {
        Icon(
            imageVector = icon,
            tint = color,
            contentDescription = null,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview
@Composable
fun BackButtonPrev() {
    MovieAppComposeTheme {
        BackButton {
            // TODO : Navigate Up
        }
    }
}

