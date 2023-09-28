package com.arnoract.cinemoapp.feature.ui

import org.koin.core.context.loadKoinModules

object UiComponent {
    fun init() = loadKoinModules(
        listOf(
            uiModule
        )
    )
}