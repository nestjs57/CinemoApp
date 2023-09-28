package com.arnoract.cinemoapp.core.di

import com.arnoract.cinemoapp.core.ApiBuilder
import org.koin.dsl.module

val apiModule = module {
    single { ApiBuilder(get()).movieApi() }
}