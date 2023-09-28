package com.arnoract.cinemoapp.ui.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arnoract.cinemoapp.ui.feature.detail.model.MovieDetailState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieDetailScreen(
    movieId: Int?,
    viewModel: MovieDetailViewModel = getViewModel { parametersOf(movieId) }
) {
    when (val state = viewModel.movieDetailState.collectAsState().value) {
        MovieDetailState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is MovieDetailState.Success -> {
            MovieDetailContent(state.imageUrl, state.genre, state.title, state.description) {
                viewModel.onClickAddFavorite()
            }
        }

        MovieDetailState.ErrorMovieNotFound -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = "Error movie not found.")
            }
        }

        is MovieDetailState.NormalError -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }
}