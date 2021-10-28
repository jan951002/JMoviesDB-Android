package com.jan.jmoviesdb.usecases.movie

import com.jan.jmoviesdb.data.movie.MovieRepository

class UpdateMovieQuantityOnShoppingCartUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(movieLocalId: Long, quantity: Int) {
        movieRepository.updateQuantityOnShoppingCart(movieLocalId, quantity)
    }
}