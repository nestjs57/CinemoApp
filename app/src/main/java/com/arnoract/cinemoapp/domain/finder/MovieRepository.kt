package com.arnoract.cinemoapp.domain.finder

import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun observeHaveFavorite(): Flow<Boolean>
    suspend fun getMyFavoriteMovies(): List<MovieFinder>
    suspend fun getMovies(): List<MovieFinder>
    suspend fun getMovieById(id: Int?): MovieFinder
    suspend fun addFavorite(data: MovieFinder?)
}