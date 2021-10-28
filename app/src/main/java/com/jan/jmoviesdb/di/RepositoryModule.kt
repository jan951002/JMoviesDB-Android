package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.data.movie.MovieRepository
import com.jan.jmoviesdb.data.movie.MovieRepositoryImpl
import org.koin.dsl.module

/**
 * Module to configure repositories dependency injection
 * @author Jaime Trujillo
 */

val repositoryModule = module {

    /* Define a factory (create a new instance each time) for MovieRepository */
    factory<MovieRepository> {
        MovieRepositoryImpl(movieLocalDataSource = get(), movieRemoteDataSource = get())
    }
}