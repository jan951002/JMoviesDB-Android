package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.R
import com.jan.jmoviesdb.apimanager.createWebService
import com.jan.jmoviesdb.apimanager.movie.MovieDBApi
import com.jan.jmoviesdb.apimanager.movie.provideMovieRemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Module to configure api dependency injection
 * @author Jaime Trujillo
 */

val apiModule = module {

    /* Define a Singleton instance for MovieDBApi */
    single {
        createWebService<MovieDBApi>(
            androidContext().getString(R.string.movies_db_base_url)
        )
    }

    single {
        provideMovieRemoteDataSource(get(), androidContext().getString(R.string.movies_db_api_key))
    }
}