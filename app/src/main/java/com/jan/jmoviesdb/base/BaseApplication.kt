package com.jan.jmoviesdb.base

import android.app.Application
import com.jan.jmoviesdb.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 * @author Jaime Trujillo
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* Adding Koin modules to our application */
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                apiModule,
                databaseModule,
                repositoryModule,
                useCasesModule,
                viewModelModule
            )
        }
    }
}