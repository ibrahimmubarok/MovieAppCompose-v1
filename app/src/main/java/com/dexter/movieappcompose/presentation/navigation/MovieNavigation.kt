package com.dexter.movieappcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dexter.movieappcompose.presentation.screen.home.HomeScreen
import com.dexter.movieappcompose.presentation.screen.splash.SplashScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.SplashScreen.name
    ) {
        composable(MovieScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}