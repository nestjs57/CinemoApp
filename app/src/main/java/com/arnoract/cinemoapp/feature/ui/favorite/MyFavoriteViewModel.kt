package com.arnoract.cinemoapp.feature.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnoract.cinemoapp.core.base.CoroutinesDispatcherProvider
import com.arnoract.cinemoapp.core.base.successOrThrow
import com.arnoract.cinemoapp.domain.favorite.GetMyFavoriteMoviesUseCase
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import com.arnoract.cinemoapp.feature.ui.finder.model.UiMovieFinderState
import com.arnoract.cinemoapp.feature.ui.finder.model.mapper.MovieFinderToUiItemMovieFinderMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyFavoriteViewModel(
    private val getMyFavoriteMoviesUseCase: GetMyFavoriteMoviesUseCase,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiMovieFinderState>(UiMovieFinderState.Loading)
    val uiState: StateFlow<UiMovieFinderState>
        get() = _uiState.asStateFlow()

    init {
        getMyFavorites()
    }

    private fun getMyFavorites() {
        viewModelScope.launch {
            try {
                val result = withContext(coroutinesDispatcherProvider.io) {
                    getMyFavoriteMoviesUseCase.invoke(Unit).successOrThrow()
                }
                prepareData(result)
            } catch (e: Exception) {
                UiMovieFinderState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    private fun prepareData(value: List<MovieFinder>) {
        val data = value.map {
            MovieFinderToUiItemMovieFinderMapper.map(it)
        }
        _uiState.value =
            if (value.isNotEmpty()) UiMovieFinderState.Success(data) else UiMovieFinderState.Empty
    }
}