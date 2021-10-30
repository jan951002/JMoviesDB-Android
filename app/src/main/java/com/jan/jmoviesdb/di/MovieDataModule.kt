package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.apimanager.createWebService
import com.jan.jmoviesdb.apimanager.movie.MovieDBApi
import com.jan.jmoviesdb.apimanager.movie.provideMovieRemoteDataSource
import com.jan.jmoviesdb.data.movie.MovieLocalDataSource
import com.jan.jmoviesdb.data.movie.MovieRemoteDataSource
import com.jan.jmoviesdb.data.movie.MovieRepository
import com.jan.jmoviesdb.data.movie.MovieRepositoryImpl
import com.jan.jmoviesdb.databasemanager.AppDatabase
import com.jan.jmoviesdb.databasemanager.movie.MovieDao
import com.jan.jmoviesdb.databasemanager.movie.provideMovieDao
import com.jan.jmoviesdb.databasemanager.movie.provideMovieLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieDataModule {

    @Provides
    @Singleton
    fun movieDBApiProvider(@Named("movieDBBaseUrl") movieDBBaseUrl: String) =
        createWebService<MovieDBApi>(movieDBBaseUrl)

    @Provides
    @Singleton
    fun movieRemoteDataSourceProvider(
        movieDBApi: MovieDBApi, @Named("movieDBApiKey") movieDBApiKey: String
    ): MovieRemoteDataSource = provideMovieRemoteDataSource(movieDBApi, movieDBApiKey)

    @Provides
    @Singleton
    fun movieDaoProvider(appDatabase: AppDatabase): MovieDao = provideMovieDao(appDatabase)

    @Provides
    @Singleton
    fun movieLocalDataSourceProvider(
        movieDao: MovieDao
    ): MovieLocalDataSource = provideMovieLocalDataSource(movieDao)

    @Provides
    @Singleton
    fun movieRepositoryProvider(
        movieLocalDataSource: MovieLocalDataSource, movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository = MovieRepositoryImpl(movieLocalDataSource, movieRemoteDataSource)
}