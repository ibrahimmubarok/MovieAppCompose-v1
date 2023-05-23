package com.dexter.movieappcompose.presentation.navigation.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.dexter.movieappcompose.presentation.navigation.MovieScreen

data class BottomNavItems(
    val title: String,
    val icon: ImageVector,
    val screen: MovieScreen
)