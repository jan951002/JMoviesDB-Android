package com.jan.jmoviesdb

import android.app.Application
import com.jan.jmoviesdb.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 * @author Jaime Trujillo
 */
class JMoviesDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* Adding Koin modules to our application */
        startKoin {
            androidContext(this@JMoviesDBApplication)
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