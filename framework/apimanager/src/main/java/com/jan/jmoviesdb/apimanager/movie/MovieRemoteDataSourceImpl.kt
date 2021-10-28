package com.jan.jmoviesdb.apimanager.movie

import com.jan.jmoviesdb.data.movie.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(
    private val movieDBApi: MovieDBApi, private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(page: Int) =
        movieDBApi.getMovies(apiKey, page).results.map { it.toMovieDomain() }
}