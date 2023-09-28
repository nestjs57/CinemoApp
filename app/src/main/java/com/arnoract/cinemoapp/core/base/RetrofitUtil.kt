package com.arnoract.cinemoapp.core.base

import retrofit2.HttpException
import retrofit2.Response

fun <ResultType> Response<ResultType>.unSafeToResult(): Result<ResultType> {
    return when {
        isSuccessful -> Result.Success(body()!!)
        else -> Result.Failure(BaseHttpException(this))
    }
}

class BaseHttpException(response: Response<*>) : HttpException(response) {
    override val message: String
        get() = "${super.message}\n${response().toString()}"
}