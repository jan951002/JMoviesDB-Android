package com.jan.jmoviesdb.ui.movies

import com.jan.jmoviesdb.data.movie.MovieRepository
import com.jan.jmoviesdb.usecases.movie.CheckRequireMoviesNewPageUseCase
import com.jan.jmoviesdb.usecases.movie.GetMoviesUseCase
import com.jan.jmoviesdb.usecases.movie.UpdateMovieQuantityOnShoppingCartUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class MoviesDI {

    @Provides
    @ViewModelScoped
    fun checkRequireMoviesNewPageUseCaseProvider(movieRepository: MovieRepository) =
        CheckRequireMoviesNewPageUseCase(movieRepository)

    @Provides
    @ViewModelScoped
    fun getMoviesUseCaseProvider(movieRepository: MovieRepository) =
        GetMoviesUseCase(movieRepository)

    @Provides
    @ViewModelScoped
    fun updateMovieQuantityOnShoppingCartUseCaseProvider(movieRepository: MovieRepository) =
        UpdateMovieQuantityOnShoppingCartUseCase(movieRepository)
}