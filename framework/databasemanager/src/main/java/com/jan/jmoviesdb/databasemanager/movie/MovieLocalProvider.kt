package com.jan.jmoviesdb.databasemanager.movie

import com.jan.jmoviesdb.data.movie.MovieLocalDataSource
import com.jan.jmoviesdb.databasemanager.AppDatabase

fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao

fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
    MovieLocalDataSourceImpl(movieDao)