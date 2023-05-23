package com.dexter.movieappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.presentation.component.bottombar.BottomBar
import com.dexter.movieappcompose.presentation.navigation.MovieScreen
import com.dexter.movieappcompose.presentation.screen.home.HomeScreen
import com.dexter.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
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
                    color = colorResource(id = R.color.black),
                ) {
                    MovieApp()
                }
            }
        }
    }
}

@Composable
fun MovieApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        MovieNavigation()
//    }
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MovieScreen.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MovieScreen.HomeScreen.route) {
                HomeScreen(
                    navController = navController,
                )
            }
            composable(MovieScreen.AboutScreen.route) {

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