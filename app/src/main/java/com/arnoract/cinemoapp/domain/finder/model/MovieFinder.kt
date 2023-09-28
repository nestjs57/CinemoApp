package com.arnoract.cinemoapp.domain.finder.model

data class MovieFinder(
    val id: Int,
    val title: String,
    val genre: String,
    val synopsisEh: String,
    val posterUrl: String,
    val releaseDate: String
)
