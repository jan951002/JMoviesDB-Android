package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module to configure view models dependency injection
 * @author Jaime Trujillo
 */

val viewModelModule = module {

    /* Define a ViewModel for MainViewModel */
    viewModel { MainViewModel(application = androidApplication(), movieRepository = get()) }
}