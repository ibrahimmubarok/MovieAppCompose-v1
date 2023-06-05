package com.dexter.movieappcompose.presentation.screen.profile.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(
    val title: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit
)

val tabs = listOf(
    TabItem(
        title = "Account",
        icon = Icons.Filled.AccountBox,
        screen = { TabScreen(content = "Account Page") }
    ),
    TabItem(
        title = "Favorite",
        icon = Icons.Filled.Favorite,
        screen = { TabScreen(content = "Favorite list") }
    ),
    TabItem(
        title = "Place",
        icon = Icons.Filled.Place,
        screen = { TabScreen(content = "Places") }
    )
)