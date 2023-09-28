package com.arnoract.cinemoapp.domain.favorite

import com.arnoract.cinemoapp.core.base.MediatorUseCase
import com.arnoract.cinemoapp.core.base.Result
import com.arnoract.cinemoapp.domain.finder.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveHaveFavoriteUseCase(
    private val movieRepository: MovieRepository
) : MediatorUseCase<Unit, Boolean>() {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> {
        return movieRepository.observeHaveFavorite().map {
            Result.Success(it)
        }
    }
}