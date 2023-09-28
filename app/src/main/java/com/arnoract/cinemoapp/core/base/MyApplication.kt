package com.arnoract.cinemoapp.core.base

import android.app.Application
import com.arnoract.cinemoapp.data.DataComponent
import com.arnoract.cinemoapp.domain.DomainComponent
import com.arnoract.cinemoapp.feature.ui.UiComponent
import com.arnoract.doykub.core.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
        }
        AppComponent.init()
        UiComponent.init()
        DataComponent.init()
        DomainComponent.init()
    }
}