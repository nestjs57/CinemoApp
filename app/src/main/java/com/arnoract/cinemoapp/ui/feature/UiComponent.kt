package com.arnoract.cinemoapp.ui.feature

import com.arnoract.cinemoapp.ui.feature.di.uiModule
import org.koin.core.context.loadKoinModules

object UiComponent {
    fun init() = loadKoinModules(
        listOf(
            uiModule
        )
    )
}