package com.jan.jmoviesdb.data.database.datasource

import com.jan.jmoviesdb.data.database.dao.MovieDao
import com.jan.jmoviesdb.data.database.mapper.toMovieDomain
import com.jan.jmoviesdb.data.database.mapper.toMovieRoom
import com.jan.jmoviesdb.domain.movie.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface MovieLocalDataSource {

    suspend fun saveMovies(movies: List<Movie>)

    suspend fun countMovies(): Int

    fun getMovies(): Flow<List<Movie>>

    suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int)
}

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun saveMovies(movies: List<Movie>) {
        movieDao.saveMovies(movies.map { it.toMovieRoom() })
    }

    override suspend fun countMovies() = movieDao.countMovies()

    override fun getMovies() =
        movieDao.getMovies().map { movies -> movies.map { it.toMovieDomain() } }

    override suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int) {
        movieDao.updateQuantityOnShoppingCart(movieLocalId, quantity)
    }
}