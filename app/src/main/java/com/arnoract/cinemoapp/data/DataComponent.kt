package com.arnoract.cinemoapp.data

import org.koin.core.context.loadKoinModules

object DataComponent {
    fun init() = loadKoinModules(
        listOf(
            movieModule,
        ),
    )
}