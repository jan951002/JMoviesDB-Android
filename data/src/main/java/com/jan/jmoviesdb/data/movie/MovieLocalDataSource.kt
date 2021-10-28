package com.jan.jmoviesdb.data.movie

import com.jan.jmoviesdb.domain.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    suspend fun saveMovies(movies: List<Movie>)

    suspend fun countMovies(): Int

    fun getMovies(): Flow<List<Movie>>

    suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int)
}