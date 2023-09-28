package com.arnoract.cinemoapp.domain.finder.model.mapper

import com.arnoract.cinemoapp.core.base.Mapper
import com.arnoract.cinemoapp.data.finder.model.NetworkMovieFinder
import com.arnoract.cinemoapp.domain.finder.model.MovieFinder

object NetworkMovieFinderToMovieFinderMapper : Mapper<NetworkMovieFinder, MovieFinder> {
    override fun map(from: NetworkMovieFinder): MovieFinder {
        return MovieFinder(
            id = from.id,
            title = from.titleEn,
            genre = from.genre,
            synopsisEh = from.synopsisEn,
            posterUrl = from.posterUrl,
            releaseDate = from.releaseDate
        )
    }
}