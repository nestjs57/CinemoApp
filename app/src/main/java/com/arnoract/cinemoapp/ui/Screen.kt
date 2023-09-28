package com.arnoract.cinemoapp.ui

sealed class Screen(val route: String) {
    object MovieFinder : Screen("movieFinder")
    object MovieDetail : Screen("movieDetail/{movieId}") {
        fun createRoute(movieId: Int) = "movieDetail/$movieId"
    }

    object MyFavorite : Screen("myFavorite")
}