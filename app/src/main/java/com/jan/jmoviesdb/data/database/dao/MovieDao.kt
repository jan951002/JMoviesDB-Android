package com.jan.jmoviesdb.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jan.jmoviesdb.data.database.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("SELECT COUNT(id) FROM movies")
    suspend fun countMovies(): Int

    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<Movie>>

    @Query("UPDATE movies SET count_on_cart = :quantity WHERE local_id = :movieLocalId")
    suspend fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int)
}