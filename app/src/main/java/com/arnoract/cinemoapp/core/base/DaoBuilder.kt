package com.arnoract.cinemoapp.core.base

import com.arnoract.cinemoapp.core.db.history.MovieDao

class DaoBuilder(
    private val roomDatabaseStorage: RoomDatabaseStorage,
) {
    fun getMovieDao(): MovieDao = roomDatabaseStorage.getMovieDao()
}