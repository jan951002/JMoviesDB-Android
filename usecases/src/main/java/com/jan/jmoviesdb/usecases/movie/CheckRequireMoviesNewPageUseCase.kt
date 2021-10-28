package com.jan.jmoviesdb.usecases.movie

import com.jan.jmoviesdb.data.movie.MovieRepository

class CheckRequireMoviesNewPageUseCase(private val movieRepository: MovieRepository) {

    suspend fun invoke(lastVisible: Int) {
        movieRepository.checkRequireNewPage(lastVisible)
    }
}