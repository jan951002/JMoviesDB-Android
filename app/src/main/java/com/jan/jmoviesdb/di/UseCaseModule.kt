package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.usecases.CheckRequireMoviesNewPageUseCase
import com.jan.jmoviesdb.usecases.GetMoviesUseCase
import com.jan.jmoviesdb.usecases.UpdateMovieQuantityOnShoppingCartUseCase
import org.koin.dsl.module

/**
 * Module to configure use cases dependency injection
 * @author Jaime Trujillo
 */

val useCasesModule = module {

    /* Define a factory (create a new instance each time) for CheckRequireMoviesNewPageUseCase */
    factory { CheckRequireMoviesNewPageUseCase(movieRepository = get()) }

    /* Define a factory (create a new instance each time) for GetMoviesUseCase */
    factory { GetMoviesUseCase(movieRepository = get()) }

    /* Define a factory (create a new instance each time) for UpdateMovieQuantityOnShoppingCartUseCase */
    factory {
        UpdateMovieQuantityOnShoppingCartUseCase(movieRepository = get())
    }
}