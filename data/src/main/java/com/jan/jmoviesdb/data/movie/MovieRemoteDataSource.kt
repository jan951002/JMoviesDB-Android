package com.jan.jmoviesdb.data.movie

import com.jan.jmoviesdb.domain.movie.Movie

interface MovieRemoteDataSource {

    suspend fun getMovies(page: Int): List<Movie>
}