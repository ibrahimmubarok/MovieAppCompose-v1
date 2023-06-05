package com.dexter.movieappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
import com.dexter.movieappcompose.presentation.screen.home.HomePagingScreen
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
fun MainScreen(
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

@Composable
fun MovieApp(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MovieScreen.FirstScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MovieScreen.MainScreen.route) {
            MainScreen()
        }
        composable(MovieScreen.HomePagingScreen.route) {
            HomePagingScreen()
        }
        composable(MovieScreen.FirstScreen.route) {
            FirstScreen(
                onNavigateToMainScreen = {
                    navController.navigate(MovieScreen.MainScreen.route)
                },
                onNavigateToPagingScreen = {
                    navController.navigate(MovieScreen.HomePagingScreen.route)
                }
            )
        }
    }
}

@Composable
fun FirstScreen(
    onNavigateToMainScreen: () -> Unit,
    onNavigateToPagingScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onNavigateToMainScreen.invoke() }) {
            Text(text = "Open Home Screen")
        }
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Button(onClick = { onNavigateToPagingScreen.invoke() }) {
            Text(text = "Open Home Paging Screen")
        }
    }
}