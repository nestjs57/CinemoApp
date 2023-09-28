package com.arnoract.cinemoapp.core.base

import android.content.Context
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkHttpBuilder(
    private val context: Context
) {
    fun build(): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()
    }
}
