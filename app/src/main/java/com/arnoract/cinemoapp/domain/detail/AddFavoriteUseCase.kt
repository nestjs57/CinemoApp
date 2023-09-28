package com.arnoract.cinemoapp.domain.detail

import com.arnoract.cinemoapp.core.base.UseCase
import com.arnoract.cinemoapp.domain.finder.MovieRepository
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

class AddFavoriteUseCase(
    private val movieRepository: MovieRepository
) : UseCase<MovieFinder?, Unit>() {
    override suspend fun execute(parameters: MovieFinder?) {
        movieRepository.addFavorite(parameters)
    }
}