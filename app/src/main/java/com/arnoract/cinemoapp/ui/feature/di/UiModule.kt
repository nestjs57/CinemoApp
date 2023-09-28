package com.arnoract.cinemoapp.ui.feature.di

import com.arnoract.cinemoapp.ui.MainViewModel
import com.arnoract.cinemoapp.ui.feature.detail.MovieDetailViewModel
import com.arnoract.cinemoapp.ui.feature.favorite.MyFavoriteViewModel
import com.arnoract.cinemoapp.ui.feature.finder.MovieFinderViewModel
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