package com.jan.jmoviesdb.data.domain.model

import com.jan.jmoviesdb.data.database.model.Movie

data class Movie(

    var id: Long,
    var adult: Boolean,
    var genreIds: List<Int>,
    var originalLanguage: String,
    var originalTitle: String,
    var overview: String,
    var popularity: Double,
    var posterPath: String,
    var releaseDate: String,
    var title: String,
    var video: Boolean,
    var voteAverage: Double,
    var voteCount: Int
) {

    fun toMovieRoom(): Movie = Movie(
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
        voteCount = this.voteCount
    )
}