package com.arnoract.cinemoapp.core.db.history

import androidx.room.Dao
import androidx.room.Query
import com.arnoract.cinemoapp.core.base.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MovieDao : BaseDao<MovieEntity>() {

    @Query("SELECT * from movie")
    abstract fun observeAll(): Flow<List<MovieEntity>>

    @Query("SELECT * from movie")
    abstract suspend fun getAll(): List<MovieEntity>
}