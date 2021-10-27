package com.jan.jmoviesdb.data.repository

import com.jan.jmoviesdb.data.api.datasource.MovieRemoteDataSource
import com.jan.jmoviesdb.data.database.datasource.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<List<com.jan.jmoviesdb.domain.movie.Movie>>
    suspend fun checkRequireNewPage(lastVisible: Int)
    suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int)
}

class MovieRepositoryImpl(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    companion object {
        private const val PAGE_SIZE = 20
        private const val PAGE_THRESHOLD = 10
    }

    override fun getMovies(): Flow<List<com.jan.jmoviesdb.domain.movie.Movie>> = movieLocalDataSource.getMovies()

    override suspend fun checkRequireNewPage(lastVisible: Int) {
        val size = movieLocalDataSource.countMovies()
        if (lastVisible >= size - PAGE_THRESHOLD) {
            val page = size / PAGE_SIZE + 1
            val newMovies = movieRemoteDataSource.getMovies(page)
            movieLocalDataSource.saveMovies(newMovies)
        }
    }

    override suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int) {
        movieLocalDataSource.updateQuantityOnShoppingCart(movieLocalId, quantity)
    }
}
