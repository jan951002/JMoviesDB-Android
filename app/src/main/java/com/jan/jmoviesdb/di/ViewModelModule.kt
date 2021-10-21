package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.ui.movies.MoviesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

val viewModelModule = module {

    /* Define a ViewModel for MoviesViewModel */
    viewModel { MoviesViewModel(application = androidApplication(), movieRepository = get()) }
}