package com.dexter.movieappcompose.presentation.navigation

enum class MovieScreens {
    SplashScreen,
    HomeScreen,
    DetailScreen,
    AboutScreen
}

sealed class MovieScreen(val route: String) {
    object HomeScreen : MovieScreen("home")
    object DetailScreen : MovieScreen("detail")
    object AboutScreen : MovieScreen("about")
}