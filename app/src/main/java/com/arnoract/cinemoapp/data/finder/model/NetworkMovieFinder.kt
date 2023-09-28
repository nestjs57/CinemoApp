package com.arnoract.cinemoapp.data.finder.model

import com.google.gson.annotations.SerializedName

data class NetworkMovie(
    val movies: List<NetworkMovieFinder>
)

data class NetworkMovieFinder(
    val id: Int,
    @SerializedName("title_en") val titleEn: String,
    @SerializedName("synopsis_en") val synopsisEn: String,
    @SerializedName("release_date") val releaseDate: String,
    val genre: String,
    @SerializedName("poster_url") val posterUrl: String
)
