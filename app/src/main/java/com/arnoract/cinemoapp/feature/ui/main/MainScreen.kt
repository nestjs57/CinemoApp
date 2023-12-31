package com.arnoract.cinemoapp.feature.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arnoract.cinemoapp.feature.ui.Screen
import com.arnoract.cinemoapp.feature.ui.detail.MovieDetailScreen
import com.arnoract.cinemoapp.feature.ui.favorite.MyFavoriteScreen
import com.arnoract.cinemoapp.feature.ui.finder.MovieFinderScreen

@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = Screen.MovieFinder.route
    ) {
        composable(Screen.MovieFinder.route) {
            MovieFinderScreen(navHostController)
        }
        composable(
            route = Screen.MovieDetail.route, arguments = listOf(navArgument("movieId") {
                type = NavType.IntType
            })
        ) { entry ->
            val movieId = entry.arguments?.getInt("movieId")
            MovieDetailScreen(movieId)
        }
        composable(Screen.MyFavorite.route) {
            MyFavoriteScreen(navHostController)
        }
    }
}