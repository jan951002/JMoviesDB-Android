package com.jan.jmoviesdb.databasemanager

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jan.jmoviesdb.databasemanager.converter.DataListIntConverter
import com.jan.jmoviesdb.databasemanager.movie.MovieDao
import com.jan.jmoviesdb.databasemanager.movie.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataListIntConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao
}