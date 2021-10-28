package com.jan.jmoviesdb.usecases.movie

import com.jan.jmoviesdb.data.movie.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    fun invoke() = movieRepository.getMovies()
}