package com.dexter.movieappcompose.presentation.navigation

import android.net.Uri
import com.google.gson.Gson

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

    object TestScreen : MovieScreen("test/{profile}") {
        fun createRoute(profile: String) = "test/$profile"
    }
}

data class Profile(
    val name: String = "",
    val address: String = "",
) {
//    override fun toString(): String = Uri.encode(Gson().toJson(this))
}