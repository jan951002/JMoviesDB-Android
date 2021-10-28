package com.jan.jmoviesdb.data.api.datasource

import com.jan.jmoviesdb.data.api.MovieDBApi
import com.jan.jmoviesdb.data.api.mapper.toMovieDomain
import com.jan.jmoviesdb.data.movie.MovieRemoteDataSource

class MovieRemoteDataSourceImpl(
    private val movieDBApi: MovieDBApi, private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(page: Int) =
        movieDBApi.getMovies(apiKey, page).results.map { it.toMovieDomain() }
}