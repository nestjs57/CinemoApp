package com.arnoract.cinemoapp.core.base

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.majorcineplex.com/"

class RetrofitBuilder(
    private val client: OkHttpClient,
    private val gson: Gson
) {
    fun build(): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}