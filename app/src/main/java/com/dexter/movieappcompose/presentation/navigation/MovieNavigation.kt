package com.dexter.movieappcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dexter.movieappcompose.presentation.screen.home.HomeScreen
import com.dexter.movieappcompose.presentation.screen.splash.SplashScreen
import com.dexter.movieappcompose.presentation.viewmodel.HomeViewModel

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
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel = homeViewModel,
            ) {

            }
        }
    }
}