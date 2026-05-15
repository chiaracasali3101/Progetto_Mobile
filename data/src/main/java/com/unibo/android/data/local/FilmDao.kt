package com.unibo.android.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unibo.android.data.entities.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {
    @Query("SELECT * FROM watchlist ORDER BY addedAt DESC")
    fun getWatchlist(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun addToWatchlist(movie: FilmEntity)

    @Delete
    suspend fun removeFromWatchlist(movie: FilmEntity)

    @Query("SELECT EXISTS(SELECT * FROM watchlist WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}