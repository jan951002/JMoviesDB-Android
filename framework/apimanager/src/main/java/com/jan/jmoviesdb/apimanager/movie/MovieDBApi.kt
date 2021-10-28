package com.jan.jmoviesdb.apimanager.movie

import com.jan.jmoviesdb.apimanager.movie.model.MoviesPopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBApi {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun getMovies(
        @Query("api_key") apiKey: String, @Query("page") page: Int
    ): MoviesPopularResponse
}