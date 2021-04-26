package com.jan.jmoviesdb.di

import android.app.Application
import androidx.room.Room
import com.jan.jmoviesdb.data.database.AppDatabase
import com.jan.jmoviesdb.data.database.dao.MovieDao
import com.jan.jmoviesdb.data.database.datasource.MovieLocalDataSource
import com.jan.jmoviesdb.data.database.datasource.MovieLocalDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module to configure room database dependency injection
 * @author Jaime Trujillo
 */
val appDatabaseModule = module {

    /* Define a Singleton instance for AppDatabase */
    single { provideDatabase(androidApplication()) }

    /* Define a Singleton instance for MovieDao */
    single { provideMovieDao(get()) }

    /* Define a Singleton instance for MovieLocalDataSource */
    single { provideMovieLocalDataSource(get()) }
}

fun provideDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(application, AppDatabase::class.java, "app-db")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao

fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
    MovieLocalDataSourceImpl(movieDao)