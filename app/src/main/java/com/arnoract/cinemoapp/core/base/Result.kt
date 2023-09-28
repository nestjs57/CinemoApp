package com.arnoract.cinemoapp.core.base

sealed class Result<out ResultType> {
    object Progress : Result<Nothing>()
    data class Success<ResultType>(val data: ResultType) : Result<ResultType>()
    data class Failure(val exception: Throwable) : Result<Nothing>()

    val isSuccess: Boolean get() = this is Success
    val isFailure: Boolean get() = this is Failure
    val isProgress: Boolean get() = this is Progress

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Failure -> "Failure[exception=${exception.message}]"
            is Progress -> "Progress"
        }
    }
}

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

fun <T> Result<T>.successOrThrow(): T {
    return when (this) {
        is Result.Success -> this.data
        is Result.Failure -> throw this.exception
        is Result.Progress -> throw throw IllegalStateException()
    }
}

inline fun <T, U> Result<T>.map(onSuccess: (T) -> U): Result<U> {
    return when (this) {
        is Result.Success -> Result.Success(onSuccess(this.data))
        is Result.Failure -> Result.Failure(this.exception)
        is Result.Progress -> Result.Progress
    }
}