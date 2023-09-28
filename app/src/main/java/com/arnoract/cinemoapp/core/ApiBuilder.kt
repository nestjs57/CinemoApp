package com.arnoract.cinemoapp.core

import com.arnoract.cinemoapp.core.api.MovieFinderApi
import retrofit2.Retrofit
import retrofit2.create

class ApiBuilder(
    private val retrofit: Retrofit
) {
    fun movieApi(): MovieFinderApi = retrofit.create()
}