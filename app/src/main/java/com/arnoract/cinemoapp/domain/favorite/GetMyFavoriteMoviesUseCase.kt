package com.arnoract.cinemoapp.domain.favorite

import com.arnoract.cinemoapp.core.base.UseCase
import com.arnoract.cinemoapp.domain.finder.MovieRepository
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

class GetMyFavoriteMoviesUseCase(
    private val movieRepository: MovieRepository
) : UseCase<Unit, List<MovieFinder>>() {
    override suspend fun execute(parameters: Unit): List<MovieFinder> {
        return movieRepository.getMyFavoriteMovies()
    }
}