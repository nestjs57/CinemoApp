package com.arnoract.doykub.core.di

import com.arnoract.cinemoapp.core.di.apiModule
import com.arnoract.cinemoapp.core.di.coreModule
import com.arnoract.cinemoapp.core.di.databaseModule
import org.koin.core.context.GlobalContext.loadKoinModules

object AppComponent {
    fun init() = loadKoinModules(
        listOf(
            coreModule,
            apiModule,
            databaseModule
        )
    )
}