package com.arnoract.cinemoapp.core.db.history

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id") val id: Int = 0,
    @ColumnInfo(name = "timestamp") val timestamp: Date = Date(),
    @ColumnInfo(name = "titleEn") val titleEn: String,
    @ColumnInfo(name = "synopsisEn") val synopsisEn: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "posterUrl") val posterUrl: String,
)