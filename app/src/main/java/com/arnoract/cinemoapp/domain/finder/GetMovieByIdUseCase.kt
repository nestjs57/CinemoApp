package com.arnoract.cinemoapp.domain.finder

import com.arnoract.cinemoapp.core.base.UseCase
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

class GetMovieByIdUseCase(
    private val movieRepository: MovieRepository
) : UseCase<Int?, MovieFinder>() {
    override suspend fun execute(parameters: Int?): MovieFinder {
        return movieRepository.getMovieById(parameters)
    }
}