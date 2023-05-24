package com.dexter.movieappcompose.presentation.navigation

enum class MovieScreens {
    SplashScreen,
    HomeScreen,
    DetailScreen,
    AboutScreen
}

sealed class MovieScreen(val route: String) {
    object HomeScreen : MovieScreen("home")
    object AboutScreen : MovieScreen("about")
    object DetailScreen : MovieScreen("detail/{movieId}") {
        fun createRoute(movieId: Int) = "detail/$movieId"
    }
}