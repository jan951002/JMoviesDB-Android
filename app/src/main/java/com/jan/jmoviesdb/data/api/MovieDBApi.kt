package com.jan.jmoviesdb.data.api

import com.jan.jmoviesdb.data.api.response.MoviesPopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBApi {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") apiKey: String, @Query("page") page: Int
    ): MoviesPopularResponse
}