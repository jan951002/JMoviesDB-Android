package com.jan.jmoviesdb.databasemanager.movie

import com.jan.jmoviesdb.data.movie.MovieLocalDataSource
import com.jan.jmoviesdb.domain.movie.Movie
import kotlinx.coroutines.flow.map

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