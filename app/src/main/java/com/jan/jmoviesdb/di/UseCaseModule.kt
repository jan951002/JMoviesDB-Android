package com.jan.jmoviesdb.di

import com.jan.jmoviesdb.usecases.movie.CheckRequireMoviesNewPageUseCase
import com.jan.jmoviesdb.usecases.movie.GetMoviesUseCase
import com.jan.jmoviesdb.usecases.movie.UpdateMovieQuantityOnShoppingCartUseCase
import org.koin.dsl.module

/**
 * Module to configure use cases dependency injection
 * @author Jaime Trujillo
 */

val useCasesModule = module {

    /* Define a factory (create a new instance each time) for CheckRequireMoviesNewPageUseCase */
    factory { com.jan.jmoviesdb.usecases.movie.CheckRequireMoviesNewPageUseCase(movieRepository = get()) }

    /* Define a factory (create a new instance each time) for GetMoviesUseCase */
    factory { com.jan.jmoviesdb.usecases.movie.GetMoviesUseCase(movieRepository = get()) }

    /* Define a factory (create a new instance each time) for UpdateMovieQuantityOnShoppingCartUseCase */
    factory {
        com.jan.jmoviesdb.usecases.movie.UpdateMovieQuantityOnShoppingCartUseCase(movieRepository = get())
    }
}