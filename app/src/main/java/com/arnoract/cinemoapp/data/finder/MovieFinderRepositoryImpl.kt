package com.arnoract.cinemoapp.data.finder

import com.arnoract.cinemoapp.core.api.MovieFinderApi
import com.arnoract.cinemoapp.core.base.successOrThrow
import com.arnoract.cinemoapp.core.base.unSafeToResult
import com.arnoract.cinemoapp.core.db.history.MovieDao
import com.arnoract.cinemoapp.core.db.history.MovieEntity
import com.arnoract.cinemoapp.data.finder.exception.MovieNotFoundException
import com.arnoract.cinemoapp.domain.finder.MovieRepository
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder
import com.arnoract.cinemoapp.domain.finder.model.mapper.MovieEntityToMovieFinderMapper
import com.arnoract.cinemoapp.domain.finder.model.mapper.NetworkMovieFinderToMovieFinderMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieFinderRepositoryImpl(
    private val movieFinderApi: MovieFinderApi, private val movieDao: MovieDao
) : MovieRepository {

    override fun observeHaveFavorite(): Flow<Boolean> {
        return movieDao.observeAll().map {
            it.any()
        }
    }

    override suspend fun getMyFavoriteMovies(): List<MovieFinder> {
        return movieDao.getAll().map {
            MovieEntityToMovieFinderMapper.map(it)
        }
    }

    override suspend fun getMovies(): List<MovieFinder> {
        val result = movieFinderApi.fetchMovies().unSafeToResult().successOrThrow()
        return result.movies.map {
            NetworkMovieFinderToMovieFinderMapper.map(it)
        }
    }

    override suspend fun getMovieById(id: Int?): MovieFinder {
        val result = movieFinderApi.fetchMovies().unSafeToResult().successOrThrow()
        val movie = result.movies.find { it.id == id } ?: throw MovieNotFoundException()
        return NetworkMovieFinderToMovieFinderMapper.map(movie)
    }

    override suspend fun addFavorite(data: MovieFinder?) {
        data ?: throw MovieNotFoundException()
        movieDao.insertOrUpdate(
            MovieEntity(
                id = data.id,
                titleEn = data.title,
                synopsisEn = data.synopsisEh,
                releaseDate = data.releaseDate,
                genre = data.genre,
                posterUrl = data.posterUrl
            )
        )
    }
}