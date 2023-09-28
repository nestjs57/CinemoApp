package com.arnoract.cinemoapp.core.api

import com.arnoract.cinemoapp.data.finder.model.NetworkMovie
import retrofit2.Response
import retrofit2.http.GET

interface MovieFinderApi {
    @GET("apis/get_movie_avaiable")
    suspend fun fetchMovies(): Response<NetworkMovie>
}