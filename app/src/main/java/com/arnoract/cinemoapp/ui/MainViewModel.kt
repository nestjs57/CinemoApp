package com.arnoract.cinemoapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnoract.cinemoapp.core.base.CoroutinesDispatcherProvider
import com.arnoract.cinemoapp.core.base.successOr
import com.arnoract.cinemoapp.domain.favorite.ObserveHaveFavoriteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val observeHaveFavoriteUseCase: ObserveHaveFavoriteUseCase,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _anyFavorite = MutableStateFlow(false)
    val anyFavorite: StateFlow<Boolean>
        get() = _anyFavorite

    init {
        observeHistory()
    }

    private fun observeHistory() {
        viewModelScope.launch {
            observeHaveFavoriteUseCase.invoke(Unit, coroutinesDispatcherProvider.io).collectLatest {
                val anyFavorite = it.successOr(false)
                _anyFavorite.value = anyFavorite
            }
        }
    }
}