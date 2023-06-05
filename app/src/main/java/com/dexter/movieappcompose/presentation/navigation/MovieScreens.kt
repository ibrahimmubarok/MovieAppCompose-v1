package com.dexter.movieappcompose.presentation.navigation

sealed class MovieScreen(val route: String) {
    object HomeScreen : MovieScreen("home")
    object AboutScreen : MovieScreen("about")
    object DetailScreen : MovieScreen("detail/{movieId}") {
        fun createRoute(movieId: Int) = "detail/$movieId"
    }

    object MainScreen : MovieScreen("main")
    object HomePagingScreen : MovieScreen("home_paging")
    object FirstScreen : MovieScreen("first_screen")
}