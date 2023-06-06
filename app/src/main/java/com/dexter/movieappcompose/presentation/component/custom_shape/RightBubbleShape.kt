package com.dexter.movieappcompose.presentation.component.custom_shape

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class RightBubbleShape(
    private val cornerShape: Float,
    private val arrowWidth: Float,
    private val arrowHeight: Float,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(Path().apply {
            reset()
            moveTo(cornerShape, 0F)
            lineTo(size.width + arrowWidth, 0F)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width + arrowWidth, 0F),
                    size = Size(10F, 10F)
                ),
                startAngleDegrees = 270F,
                sweepAngleDegrees = 180F,
                forceMoveTo = false
            )
            lineTo(size.width, arrowHeight)
            lineTo(size.width, size.height - cornerShape)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - cornerShape, size.height - cornerShape),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 0F,
                sweepAngleDegrees = 90F,
                forceMoveTo = false
            )
            lineTo(size.width - cornerShape, size.height)
            arcTo(
                rect = Rect(
                    offset = Offset(0F, size.height - cornerShape),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 90F,
                sweepAngleDegrees = 90F,
                forceMoveTo = false
            )
            lineTo(0F, cornerShape)
            arcTo(
                rect = Rect(
                    offset = Offset(0F, 0F),
                    size = Size(cornerShape, cornerShape)
                ),
                startAngleDegrees = 180F,
                sweepAngleDegrees = 90F,
                forceMoveTo = false
            )
            close()
        })
    }
}

fun Modifier.drawRightBubble(
    bubbleColor: Color,
    cornerShape: Float,
    arrowWidth: Float,
    arrowHeight: Float
) = then(
    background(
        color = bubbleColor,
        shape = RightBubbleShape(
            cornerShape = cornerShape,
            arrowWidth = arrowWidth,
            arrowHeight = arrowHeight
        )
    )
)
