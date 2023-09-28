package com.arnoract.cinemoapp.core.di

import com.arnoract.cinemoapp.core.base.CoroutinesDispatcherProvider
import com.arnoract.cinemoapp.core.base.MyGsonBuilder
import com.arnoract.cinemoapp.core.base.OkHttpBuilder
import com.arnoract.cinemoapp.core.base.RetrofitBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val coreModule = module {
    single { MyGsonBuilder().build() }
    single { OkHttpBuilder(androidApplication()).build() }
    single { RetrofitBuilder(get(), get()).build() }
    single { CoroutinesDispatcherProvider() }
}