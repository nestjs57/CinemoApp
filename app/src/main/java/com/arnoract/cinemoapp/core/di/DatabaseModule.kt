package com.arnoract.cinemoapp.core.di

import com.arnoract.cinemoapp.core.base.DaoBuilder
import com.arnoract.cinemoapp.core.base.DatabaseBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseBuilder(androidApplication()).buildRoomDatabaseStorage() }
    single { DaoBuilder(get()).getMovieDao() }
}