package com.arnoract.cinemoapp.ui.feature.finder.model

sealed class UiMovieFinderState {
    object Loading : UiMovieFinderState()
    data class Success(
        val item: List<UiItemMovieFinder>
    ) : UiMovieFinderState()

    object Empty : UiMovieFinderState()
    data class Error(
        val message: String
    ) : UiMovieFinderState()
}