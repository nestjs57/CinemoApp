package com.arnoract.cinemoapp.feature.ui

import com.arnoract.cinemoapp.feature.ui.detail.MovieDetailViewModel
import com.arnoract.cinemoapp.feature.ui.favorite.MyFavoriteViewModel
import com.arnoract.cinemoapp.feature.ui.finder.MovieFinderViewModel
import com.arnoract.cinemoapp.feature.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        MovieFinderViewModel(get(), get())
    }
    viewModel { (movieId: Int?) ->
        MovieDetailViewModel(movieId, get(), get(), get())
    }
    viewModel {
        MainViewModel(get(), get())
    }
    viewModel {
        MyFavoriteViewModel(get(), get())
    }
}