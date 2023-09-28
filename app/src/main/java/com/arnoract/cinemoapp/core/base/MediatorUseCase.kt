package com.arnoract.cinemoapp.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext

abstract class MediatorUseCase<in P, R> {
    operator fun invoke(
        parameters: P, coroutineContext: CoroutineContext
    ): Flow<Result<R>> {
        return execute(parameters).onStart {
            emit(Result.Progress)
        }.catch { e ->
            if (e is CancellationException) throw e
            emit(Result.Failure(e))
        }.flowOn(coroutineContext)
    }

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}