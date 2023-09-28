package com.arnoract.cinemoapp.ui.feature.finder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnoract.cinemoapp.core.base.CoroutinesDispatcherProvider
import com.arnoract.cinemoapp.core.base.successOrThrow
import com.arnoract.cinemoapp.core.util.setValueIfNew
import com.arnoract.cinemoapp.domain.finder.GetMoviesUseCase
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import com.arnoract.cinemoapp.ui.feature.finder.model.UiMovieFinderState
import com.arnoract.cinemoapp.ui.feature.finder.model.mapper.MovieFinderToUiItemMovieFinderMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieFinderViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieFinder>>()

    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String>
        get() = _searchText

    private val _uiState = MutableStateFlow<UiMovieFinderState>(UiMovieFinderState.Loading)
    val uiState: StateFlow<UiMovieFinderState>
        get() = _uiState.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                val result = withContext(coroutinesDispatcherProvider.io) {
                    getMoviesUseCase.invoke(Unit).successOrThrow()
                }
                _movies.value = result
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

    fun onTextChanged(value: String) {
        _searchText.setValueIfNew(value)
        val newValue = _movies.value?.filter { it.title.lowercase().contains(value.lowercase()) }
        prepareData(newValue ?: listOf())
    }
}