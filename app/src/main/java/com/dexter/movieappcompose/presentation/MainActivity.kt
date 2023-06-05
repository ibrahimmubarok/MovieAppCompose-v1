package com.dexter.movieappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dexter.movieappcompose.presentation.component.bottombar.BottomBar
import com.dexter.movieappcompose.presentation.navigation.MovieScreen
import com.dexter.movieappcompose.presentation.screen.about.AboutScreen
import com.dexter.movieappcompose.presentation.screen.detail.DetailMovieScreen
import com.dexter.movieappcompose.presentation.screen.home.HomeScreen
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.dexter.movieappcompose.presentation.ui.theme.Purple2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Purple2,
                ) {
                    MovieApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        containerColor = Purple2,
        bottomBar = {
            if (currentRoute != MovieScreen.DetailScreen.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MovieScreen.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MovieScreen.HomeScreen.route) {
                HomeScreen { movieId ->
                    navController.navigate(MovieScreen.DetailScreen.createRoute(movieId))
                }
            }
            composable(MovieScreen.AboutScreen.route) {
                AboutScreen()
            }
            composable(
                route = MovieScreen.DetailScreen.route,
                arguments = listOf(navArgument("movieId") { type = NavType.IntType }),
            ) {
                val movieId = it.arguments?.getInt("movieId") ?: 0
                DetailMovieScreen(
                    movieId = movieId,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppComposeTheme {

    }
}