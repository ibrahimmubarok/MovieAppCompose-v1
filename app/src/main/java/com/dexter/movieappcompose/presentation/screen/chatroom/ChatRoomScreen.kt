package com.dexter.movieappcompose.presentation.screen.chatroom

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dexter.movieappcompose.presentation.component.custom_shape.drawRightBubble
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme

@Composable
fun ChatRoomScreen() {

}

@Composable
fun MessageBox(
    message: String
) {
    val cornerShape = with(LocalDensity.current) { 16.dp.toPx() }
    val arrowWidth = with(LocalDensity.current) { 8.dp.toPx() }
    val arrowHeight = with(LocalDensity.current) { 12.dp.toPx() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(end = 16.dp, start = 80.dp),
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .drawRightBubble(
                    cornerShape = cornerShape,
                    arrowWidth = arrowWidth,
                    arrowHeight = arrowHeight,
                    bubbleColor = Color.LightGray
                )
        ) {
            Text(
                text = message,
                modifier = Modifier.padding(8.dp),
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun MessageBoxPreview() {
    MovieAppComposeTheme {
        MessageBox(message = "Ini adalah message box dengan custom shape")
    }

}