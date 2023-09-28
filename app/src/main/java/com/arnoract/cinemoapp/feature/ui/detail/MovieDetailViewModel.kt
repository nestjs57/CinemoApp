package com.arnoract.cinemoapp.feature.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnoract.cinemoapp.core.base.CoroutinesDispatcherProvider
import com.arnoract.cinemoapp.core.base.successOrThrow
import com.arnoract.cinemoapp.data.finder.exception.MovieNotFoundException
import com.arnoract.cinemoapp.domain.detail.AddFavoriteUseCase
import com.arnoract.cinemoapp.domain.finder.GetMovieByIdUseCase
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import com.arnoract.cinemoapp.feature.ui.detail.model.MovieDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(
    private val movieId: Int?,
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _movieFinder = MutableLiveData<MovieFinder>()

    private val _movieDetailState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState.Loading)
    val movieDetailState: StateFlow<MovieDetailState>
        get() = _movieDetailState

    init {
        getMovieById()
    }

    private fun getMovieById() {
        viewModelScope.launch {
            _movieDetailState.value = MovieDetailState.Loading
            try {
                val result = withContext(coroutinesDispatcherProvider.io) {
                    getMovieByIdUseCase.invoke(movieId).successOrThrow()
                }
                _movieFinder.value = result
                _movieDetailState.value = MovieDetailState.Success(
                    imageUrl = result.posterUrl,
                    genre = result.genre,
                    title = result.title,
                    description = result.synopsisEh
                )
            } catch (e: MovieNotFoundException) {
                _movieDetailState.value = MovieDetailState.ErrorMovieNotFound
            } catch (e: Exception) {
                _movieDetailState.value = MovieDetailState.NormalError(e.message ?: "Unknown Error")
            }
        }
    }

    fun onClickAddFavorite() {
        viewModelScope.launch {
            try {
                addFavoriteUseCase.invoke(_movieFinder.value).successOrThrow()
            } catch (e: MovieNotFoundException) {
                // handle error
            } catch (e: Exception) {
                // handle error
            }
        }
    }
}