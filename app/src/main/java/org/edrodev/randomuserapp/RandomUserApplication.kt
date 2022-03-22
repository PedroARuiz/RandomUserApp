package org.edrodev.randomuserapp

import android.app.Application
import org.edrodev.randomuserapp.di.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RandomUserApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            allowOverride(true)
            androidContext(applicationContext)
            modules(diModules)
        }
    }
}