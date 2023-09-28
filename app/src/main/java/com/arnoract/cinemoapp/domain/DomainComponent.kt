package com.arnoract.cinemoapp.domain

import org.koin.core.context.GlobalContext.loadKoinModules

object DomainComponent {
    fun init() = loadKoinModules(
        listOf(
            useCaseModule,
        )
    )
}