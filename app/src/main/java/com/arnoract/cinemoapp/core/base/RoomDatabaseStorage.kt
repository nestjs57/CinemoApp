package com.arnoract.cinemoapp.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arnoract.cinemoapp.core.db.DateConverter
import com.arnoract.cinemoapp.core.db.history.MovieDao
import com.arnoract.cinemoapp.core.db.history.MovieEntity

@Database(
    entities = [MovieEntity::class], version = 1
)
@TypeConverters(DateConverter::class)
abstract class RoomDatabaseStorage : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}