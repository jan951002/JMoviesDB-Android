package com.jan.jmoviesdb.apimanager.movie

import com.jan.jmoviesdb.data.movie.MovieRemoteDataSource

/* function to build our MovieRemoteDataSource */
fun provideMovieRemoteDataSource(movieDBApi: MovieDBApi, apiKey: String): MovieRemoteDataSource =
    MovieRemoteDataSourceImpl(movieDBApi, apiKey)