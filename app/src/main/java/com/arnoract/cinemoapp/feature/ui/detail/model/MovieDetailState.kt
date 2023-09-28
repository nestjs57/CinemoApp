package com.arnoract.cinemoapp.feature.ui.detail.model

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(
        val imageUrl: String, val genre: String, val title: String, val description: String
    ) : MovieDetailState()

    object ErrorMovieNotFound : MovieDetailState()
    data class NormalError(val message: String) : MovieDetailState()
}
