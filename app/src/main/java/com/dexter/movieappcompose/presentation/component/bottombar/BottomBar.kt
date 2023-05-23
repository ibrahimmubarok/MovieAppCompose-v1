package com.dexter.movieappcompose.presentation.component.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.presentation.navigation.MovieScreen
import com.dexter.movieappcompose.presentation.navigation.model.BottomNavItems
import com.dexter.movieappcompose.presentation.ui.theme.Purple1
import com.dexter.movieappcompose.presentation.ui.theme.Purple2
import com.dexter.movieappcompose.presentation.ui.theme.White1

@Composable
fun BottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navItems = listOf(
            BottomNavItems(
                title = stringResource(R.string.label_home),
                icon = Icons.Default.Home,
                screen = MovieScreen.HomeScreen,
            ),
            BottomNavItems(
                title = stringResource(R.string.label_about),
                icon = Icons.Default.AccountCircle,
                screen = MovieScreen.AboutScreen,
            )
        )
        NavigationBar(
            containerColor = Purple2,
        ) {
            navItems.map { item ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Purple1,
                        selectedIconColor = Color.White,
                        unselectedIconColor = White1,
                        selectedTextColor = Color.White,
                        unselectedTextColor = White1
                    ),
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navHostController.navigate(item.screen.route) {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}