package com.arnoract.cinemoapp.data

import com.arnoract.cinemoapp.data.finder.MovieFinderRepositoryImpl
import com.arnoract.cinemoapp.domain.finder.MovieRepository
import org.koin.dsl.module

val movieModule = module {
    single<MovieRepository> { MovieFinderRepositoryImpl(get(), get()) }
}