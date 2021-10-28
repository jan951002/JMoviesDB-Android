package com.jan.jmoviesdb.databasemanager.movie

import com.jan.jmoviesdb.databasemanager.movie.Movie

fun com.jan.jmoviesdb.domain.movie.Movie.toMovieRoom(): Movie = Movie(

    id = this.id,
    adult = this.adult,
    genreIds = this.genreIds,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount,
    countOnCart = this.countOnCart
)

fun Movie.toMovieDomain(): com.jan.jmoviesdb.domain.movie.Movie =
    com.jan.jmoviesdb.domain.movie.Movie(
        id = this.id,
        adult = this.adult,
        genreIds = this.genreIds,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        countOnCart = this.countOnCart,
        localId = localId
    )