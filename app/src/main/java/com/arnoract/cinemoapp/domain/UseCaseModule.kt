package com.arnoract.cinemoapp.domain

import com.arnoract.cinemoapp.domain.detail.AddFavoriteUseCase
import com.arnoract.cinemoapp.domain.favorite.GetMyFavoriteMoviesUseCase
import com.arnoract.cinemoapp.domain.favorite.ObserveHaveFavoriteUseCase
import com.arnoract.cinemoapp.domain.finder.GetMovieByIdUseCase
import com.arnoract.cinemoapp.domain.finder.GetMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetMoviesUseCase(get()) }
    factory { GetMovieByIdUseCase(get()) }
    factory { AddFavoriteUseCase(get()) }
    factory { ObserveHaveFavoriteUseCase(get()) }
    factory { GetMyFavoriteMoviesUseCase(get()) }
}