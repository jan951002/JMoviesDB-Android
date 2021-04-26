package com.servinf.androidstack.di

import com.servinf.androidstack.data.repository.DogRepository
import com.servinf.androidstack.data.repository.DogRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Module to configure repositories dependency injection
 * @author Jaime Trujillo
 */

val repositoryModule = module {

    /* Define a factory (create a new instance each time) for DogRepository */
    factory<DogRepository> {
        DogRepositoryImpl(wikiApiService = get(), dogDao = get(), context = androidContext())
    }
}