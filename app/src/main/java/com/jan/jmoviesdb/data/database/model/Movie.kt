package com.jan.jmoviesdb.data.database.model

import androidx.room.*
import com.jan.jmoviesdb.data.database.coverter.DataListIntConverter
import com.jan.jmoviesdb.data.domain.model.Movie

@Entity(tableName = "movies")
data class Movie(

    @PrimaryKey
    var id: Long,

    var adult: Boolean,

    @ColumnInfo(name = "backdrop_path")
    var backdropPath: String,

    @TypeConverters(DataListIntConverter::class)
    @ColumnInfo(name = "genre_ids")
    var genreIds: List<Int>,

    @ColumnInfo(name = "original_language")
    var originalLanguage: String,

    @ColumnInfo(name = "original_title")
    var originalTitle: String,

    var overview: String,

    var popularity: Double,

    @ColumnInfo(name = "poster_path")
    var posterPath: String,

    @ColumnInfo(name = "release_date")
    var releaseDate: String,

    var title: String,

    var video: Boolean,

    @ColumnInfo(name = "vote_average")
    var voteAverage: Double,

    @ColumnInfo(name = "vote_count")
    var voteCount: Int
) {
    fun toMovieDomain(): Movie = Movie(
        id = this.id,
        adult = this.adult,
        backdropPath = this.backdropPath,
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