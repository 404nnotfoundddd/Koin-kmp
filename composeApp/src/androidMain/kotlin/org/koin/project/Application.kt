package org.koin.project

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.logger.Logger
import org.koin.project.di.initKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@Application)
        }
    }
}