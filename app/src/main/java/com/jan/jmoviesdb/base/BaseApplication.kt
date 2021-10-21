package com.jan.jmoviesdb.base

import android.app.Application
import com.jan.jmoviesdb.di.apiModule
import com.jan.jmoviesdb.di.databaseModule
import com.jan.jmoviesdb.di.repositoryModule
import com.jan.jmoviesdb.di.viewModelModule
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
                viewModelModule
            )
        }
    }
}