package com.arnoract.cinemoapp.ui.feature.finder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arnoract.cinemoapp.ui.feature.finder.model.UiMovieFinderState

@Composable
fun MovieFinderContent(
    state: UiMovieFinderState,
    onClickedItemMovie: (Int) -> Unit
) {
    when (state) {
        UiMovieFinderState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiMovieFinderState.Success -> {
            LazyColumn(content = {
                items(state.item, key = { item ->
                    item.id
                }) { item ->
                    ItemMovieFinder(item) {
                        onClickedItemMovie(it)
                    }
                }
            }, verticalArrangement = Arrangement.spacedBy(16.dp))
        }

        is UiMovieFinderState.Empty -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = "Data not found.")
            }
        }

        is UiMovieFinderState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }
}