package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.databasemanager.movie.provideMovieDao
import com.jan.jmoviesdb.databasemanager.movie.provideMovieLocalDataSource
import com.jan.jmoviesdb.databasemanager.provideDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module to configure room database dependency injection
 * @author Jaime Trujillo
 */
val databaseModule = module {

    /* Define a Singleton instance for AppDatabase */
    single { provideDatabase(androidApplication()) }

    /* Define a Singleton instance for MovieDao */
    single { provideMovieDao(get()) }

    /* Define a Singleton instance for MovieLocalDataSource */
    single { provideMovieLocalDataSource(get()) }
}