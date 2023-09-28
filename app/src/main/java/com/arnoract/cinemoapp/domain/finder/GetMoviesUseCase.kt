package com.arnoract.cinemoapp.domain.finder

import com.arnoract.cinemoapp.core.base.UseCase
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) : UseCase<Unit, List<MovieFinder>>() {
    override suspend fun execute(parameters: Unit): List<MovieFinder> {
        return movieRepository.getMovies()
    }
}