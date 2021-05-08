package app.ammar.rippletask.ui.main

import android.app.Application
import app.ammar.rippletask.di.module.appModule
import app.ammar.rippletask.di.module.repoModule
import app.ammar.rippletask.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, repoModule, viewModelModule)
        }
    }

}
