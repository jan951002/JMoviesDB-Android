package com.jan.jmoviesdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jan.jmoviesdb.data.database.coverter.DataListIntConverter
import com.jan.jmoviesdb.data.database.dao.MovieDao
import com.jan.jmoviesdb.data.database.model.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataListIntConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao
}